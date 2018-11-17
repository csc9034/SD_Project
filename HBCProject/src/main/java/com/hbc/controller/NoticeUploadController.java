package com.hbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hbc.util.MediaUtils;
import com.hbc.util.UploadFileUtils;
/**
 * 공지사항 게시판의 파일 업로드를 위한 컨트롤러
 * 
 * @author 남정규
 */
@Controller
@RequestMapping("noticeUp/*")
public class NoticeUploadController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeUploadController.class);

	@Resource(name = "noticeUploadPath")
	private String uploadPath;

	/**
	 * Ajax를 사용하여 파일 업로드
	 * 
	 * 업로드 경로에 직접 저장되고 데이터베이스에는 저장되지 않음
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		System.out.println("업로드 컨트롤러 파일 : "+file);
		logger.info("originalName: " + file.getOriginalFilename());

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	/**
	 * 업로드된 파일을 화면에 출력
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME : " + fileName);

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	/**
	 * 업로드된 하나의 파일을 삭제
	 * 
	 * 저장되어 있는 경로에서 직접 삭제하고 데이터베이스에서는 삭제되지 않음
	 * 
	 * @param fileName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("delete file: " + fileName);
		System.out.println("업로드 컨트롤러 사진삭제 파일명 : " + fileName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	/**
	 * 게시글 하나에 업로드된 파일을 모두 삭제
	 * 
	 * 저장되어 있는 경로에서 직접 삭제하고 데이터베이스에서는 삭제되지 않음
	 * 
	 * @param files
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteAllFiles", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files){
		logger.info("delete all files: "+ files);
		
		if(files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		
		for(String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			if(mType != null) {
				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
			}
			
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/downloadFile.do")
	public void downloadFile(String fileName, HttpServletResponse response) throws Exception {

		byte fileByte[] = FileUtils.readFileToByteArray(new File(uploadPath + fileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
