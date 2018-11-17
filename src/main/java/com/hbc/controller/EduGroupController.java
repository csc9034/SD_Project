package com.hbc.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbc.service.EmployeeService;

@Controller
@RequestMapping("/edugroup/*")
public class EduGroupController {
	
	private static final Logger logger = LoggerFactory.getLogger(EduGroupController.class);
	
	@Inject
	private EmployeeService service;
	
	
//	/**
//	 * 사람들 소개
//	 * @param model
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/people", method = RequestMethod.GET)
//	public void people(Model model) throws Exception {
//		logger.info("show all list...");
//		model.addAttribute("list", service.peopleList());
//	}
	
	/**
	 * 사람들 상세보기
	 * @param empNum
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void read(@RequestParam("empNum") int empnum, Model model) throws Exception{
		
		model.addAttribute(service.read(empnum));
	}
	
	/**
	 * 그룹소개
	 * @throws Exception
	 */
	@RequestMapping(value = "/intro", method = RequestMethod.GET)
	public void intro() throws Exception {
		logger.info("intro...");
	}
	
	/**
	 * 연혁
	 * @throws Exception
	 */
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public void history() throws Exception {
		logger.info("history...");
	}
	
	/**
	 * 가치
	 * @throws Exception
	 */
	@RequestMapping(value = "/value", method = RequestMethod.GET)
	public void value() throws Exception {
		logger.info("value...");
	}
	
	/**
	 * 가치
	 * @throws Exception
	 */
	@RequestMapping(value = "/people", method = RequestMethod.GET)
	public void people() throws Exception {
		logger.info("people...");
	}
	
}
