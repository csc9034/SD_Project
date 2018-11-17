package com.hbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.EmployeeVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.EmployeeService;
import com.hbc.util.MediaUtils;
import com.hbc.util.EmpUploadFileUtils;

/**
 * 직원 관련 기능들을 컨트롤 하는 컨트롤러
 * 
 * @author 강현
 *
 */

@Controller
@RequestMapping("/admin/emp")
public class EmployeeController {

	@Inject
	private EmployeeService service;

	@Resource(name = "empUploadPath")
	private String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void empWriteGET(@ModelAttribute("cri") AppSearchCriteria cri,  Model model) {

		model.addAttribute("compList", service.readComps());
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String empWritePOST(EmployeeVO vo, RedirectAttributes rttr) throws Exception {

		logger.info(vo.toString());
		
		vo.setEmpphone(vo.getEmpphone().replace("-", ""));

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/emp/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void empModifyGET(@RequestParam("empnum") int empnum,  @ModelAttribute("cri") AppSearchCriteria cri,  Model model) {
		model.addAttribute(service.read(empnum));
		model.addAttribute("compList", service.readComps());
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String empModifyPOST(EmployeeVO vo, RedirectAttributes rttr) throws Exception {

		logger.info(vo.toString());

		vo.setEmpphone(vo.getEmpphone().replace("-", ""));
		
		service.modify(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/emp/list";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String empRemovePOST(int empnum, RedirectAttributes rttr) throws Exception {

		service.delete(empnum);
		rttr.addFlashAttribute("msg", "SUCCESS");
		

		return "redirect:/admin/emp/list";
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		logger.info(pageMaker.getTotalCount() + "페이지개수");

		model.addAttribute("pageMaker", pageMaker);

	}

	// 아래부터는 이미지 업로드 관리를 위한 메소드

	/**
	 * 업로드할 파일의 확장자를 검사하는 메소드
	 * 
	 * @param filepath
	 * @return
	 */
	public static boolean isImage(String filepath) {
		String[] extensions = { ".jpg", ".png", ".jpeg", ".JPG", ".PNG", ".JPEG" };
		for (String extension : extensions) {
			if (filepath.endsWith(extension)) {
				System.out.println("Its an image");
				return true;
			}
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> empUploadAjaxPOST(MultipartFile file, HttpServletRequest request) throws Exception {
		logger.info("originalName: " + file.getOriginalFilename());

		// 확장자가 jpg, png 종류가 아니면 null을 반환하도록 함
		if (!isImage(file.getOriginalFilename())) {
			return null;
		}

		return new ResponseEntity<>(EmpUploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

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

	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		
		service.deleteAttach(fileName);
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files) {

		logger.info("delete all files: " + files);

		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {

				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	/**
	 * 업로드된 파일의 이름을 리턴시켜주는 메소드
	 * 항상 파일 하나를 넘겨주지만
	 * 페이지에서 사용하는 jquery 코드에서 list로 받기때문에
	 * 확장성을 위해 list 형식으로 넘겨줄것
	 * 
	 * @param empnum
	 * @return
	 */
	@RequestMapping("/getAttach/{empnum}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("empnum")Integer empnum) {
		List<String> fileList = new ArrayList<>();
		fileList.add(service.getAttach(empnum));
		
		return fileList;
	}

}
