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

import com.hbc.domain.AppSearchCriteria;
import com.hbc.domain.ApplyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.StudentVO;
import com.hbc.service.StudentService;

@Controller
@RequestMapping("/admin/student/*")
public class AdminStudentController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCourseController.class);

	@Inject
	private StudentService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("cri") AppSearchCriteria cri, ApplyVO apply, Model model) throws Exception {
		model.addAttribute("list", service.listComp());
		logger.info("regist get.......................");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(StudentVO student, RedirectAttributes rttr) throws Exception {

		logger.info("regist post.......................");
		logger.info("등록 : " + student.toString());

		service.register(student);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/student/list";

	}

	@RequestMapping(value = "/listComp", method = RequestMethod.GET)
	public void listAll(CourseVO course, Model model) throws Exception {

		logger.info("show all list..........");
		model.addAttribute("list", service.listComp());

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		System.out.println("조회" + service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		System.out.println(pageMaker.getTotalCount());
		logger.info(pageMaker.getTotalCount() + "페이지개수");

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPageingGET(@RequestParam("stuid") String stuid, @ModelAttribute("cri") AppSearchCriteria cri,
			Model model) throws Exception {

		model.addAttribute(service.read(stuid));
		model.addAttribute("list", service.listComp());

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPage(StudentVO student, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("mod Post.............");
		logger.info("제발====================================>" + cri.getPage());
		logger.info("mod Post.............");

		service.modify(student);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/student/list";

	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("stuid") String stuid, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.remove(stuid);
		System.out.println(stuid);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		System.out.println("삭제!");

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/student/list";
	}

}
