package com.hbc.controller;

import java.io.FileInputStream;


import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbc.domain.SearchCriteria;
import com.hbc.service.EventBoardService;
import com.hbc.util.MediaUtils;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private EventBoardService service;
	
	@Resource(name = "imgUploadPath")
	private String imgUploadPath;

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("cri") SearchCriteria cri, Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("list", service.searchEventImgList()); // 이벤트 파일 이미지 갖고 오는거
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		
		
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
