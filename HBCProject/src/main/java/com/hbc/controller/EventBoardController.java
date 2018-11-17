package com.hbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.inject.Inject;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.EventBoardService;
import com.hbc.util.MediaUtils;

@Controller
@RequestMapping("/eventBoard/*")
public class EventBoardController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEventBoardController.class);
	
	@Inject
	private EventBoardService service;
	
	@Resource(name = "imgUploadPath")
	private String imgUploadPath;

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("num") int num, @ModelAttribute("cri") SearchCriteria cri, Model model,
			RedirectAttributes rttr) throws Exception {
		
		model.addAttribute(service.read(num));
		model.addAttribute("imgFile", service.readFile(num, "0"));
		model.addAttribute("attachFile", service.readFile(num, "1"));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		logger.info(cri.getListType());
		
		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("list", service.searchListCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.searchListCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/downloadFile.do")
	public void downloadFile(String fileName, HttpServletResponse response) throws Exception {

		byte fileByte[] = FileUtils.readFileToByteArray(new File(fileUploadPath + fileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	@ResponseBody
	@RequestMapping("/displayImg")
	public ResponseEntity<byte[]> displayImg(String fileName) throws Exception {

		System.out.println("=====> fileName : " + fileName);

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(imgUploadPath + fileName);

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
}
