package com.hbc.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.ProgPageMaker;
import com.hbc.domain.ProgramVO;
import com.hbc.domain.ProgSearchCriteria;
import com.hbc.service.ProgramService;

@Controller
@RequestMapping("program/")
public class ProgramController {

	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);

	@Inject
	private ProgramService service;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri") ProgSearchCriteria cri, Model model) throws Exception {
		
		
		model.addAttribute("sideList", service.sideList());
		
		ProgPageMaker pageMaker = new ProgPageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		System.out.println(service.searchListCriteria(cri));
		
		model.addAttribute("list", service.searchListCriteria(cri));
		
		System.out.println("getCompnums - " + cri.getCompnums());
		System.out.println("model " + model);
		
		model.addAttribute("mainImg", service.programImgs());
		
/*		logger.info(vo.toString());
		System.out.println(vo);
		*/
	}	

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void read(@RequestParam("intronum") Integer intronum,@ModelAttribute("intronum") Integer intronums, @ModelAttribute("cri") ProgSearchCriteria cri, Model model)
			throws Exception {
		
		ProgPageMaker pageMaker = new ProgPageMaker();
		pageMaker.setCri(cri);
		model.addAttribute("pageMaker", pageMaker);
		
		// 사이드메뉴
		model.addAttribute("sideList", service.sideList());
		// 프로그램 내용
		model.addAttribute(service.read(intronum));
		model.addAttribute("mainImg", service.programImg(intronum));
		//System.out.println(service.programImg(intronum).toString());
		
	}






}
