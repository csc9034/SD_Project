package com.hbc.controller;

/**
 * 프로그램 목록 관리자 컨트롤러
 */
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
@RequestMapping("admin/program/")
public class AdminProgramController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProgramController.class);

	@Inject
	private ProgramService service;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") ProgSearchCriteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());

		model.addAttribute("list", service.searchListCriteria(cri));
		model.addAttribute("centerList", service.centerList());
		ProgPageMaker pageMaker = new ProgPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}



	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("intronum") int intronum, ProgSearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(intronum);


		rttr.addAttribute("page", cri.getPage());//��������ȣ
		rttr.addAttribute("perPageNum", cri.getPerPageNum());//������ ������ ��
		rttr.addAttribute("searchType", cri.getSearchType());// �˻�Ÿ��
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("compnum", cri.getCompnums());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:../program/list";
	}

	

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(int intronum, @ModelAttribute("cri") ProgSearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.read(intronum));
		model.addAttribute("centerList", service.centerList());
	}


	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(ProgramVO program, ProgSearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(cri.toString());
		service.modify(program);
		
		// 페이징 정보를 rttr에 담음
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("compnum", cri.getCompnums());
		rttr.addFlashAttribute("msg", "SUCCESS");
			

		logger.info(rttr.toString());

		return "redirect:../program/list";
	}


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("cri") ProgSearchCriteria cri, Model model) throws Exception {
		logger.info("register get..............");
		model.addAttribute("centerList", service.centerList());
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProgramVO Program, ProgSearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(Program.toString());

		service.regist(Program);// 
		System.out.println(Program.toString());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("compnum", cri.getCompnums());
		rttr.addFlashAttribute("msg", "SUCCESS"); // 
		return "redirect:../program/list";
	}
}
