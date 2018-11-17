package com.hbc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbc.domain.PageMaker;
import com.hbc.domain.StudentVO;
import com.hbc.dto.StudentLoginDTO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.ApplyService;
import com.hbc.service.StudentService;

@Controller
@RequestMapping("/apply/*")
public class ApplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);

	@Inject
	private ApplyService service;
	
	@Inject 
	private StudentService stuService;
	
	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public void login(Model model) throws Exception {
		
		model.addAttribute("appCompList", service.appCompList());
		
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(StudentLoginDTO dto, HttpSession session, Model model) throws Exception {

		StudentVO vo = stuService.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("studentVO", vo);

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/apply/login";
	}
	
	/**
	 * 전체 리스트 페이지에 보여줄 수강 정보를 조회하는 메소드
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listApply(@ModelAttribute("cri") AppSearchCriteria cri, Model model, HttpServletRequest request) throws Exception {

		logger.info(cri.toString());
		
		HttpSession session = request.getSession();
		String stuid = ((StudentVO) session.getAttribute("stuLogin")).getStuid();
		logger.info("학원생 아이디" + stuid);
		
		cri.setStuid(stuid);
		

		model.addAttribute("list", service.userListSearchCriteria(cri));
		model.addAttribute("count", service.userListSearchCount(cri));
		model.addAttribute("appCompList", service.appCompList());
		System.out.println("조회" + service.userListSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		System.out.println(pageMaker.getTotalCount());
		logger.info(pageMaker.getTotalCount() + "페이지개수");

		model.addAttribute("pageMaker", pageMaker);

	}

}
