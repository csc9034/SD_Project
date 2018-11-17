package com.hbc.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.MainLinkVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.MainLinkService;


//메인링크 컨트롤러
//메인링크 화면은 페이징과 검색이 없음
@Controller
@RequestMapping("/admin/mainLink/*")
public class LinkComtroller {
	
	private static final Logger logger = LoggerFactory.getLogger(LinkComtroller.class);
	
	@Inject
	private MainLinkService service;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(MainLinkVO vo, Model model)throws Exception{
		
		
		//링크 등록된 기관 제외하고
		model.addAttribute("list", service.listComp());
		
		logger.info("register get...........");
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(MainLinkVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("register post..........");
		
		logger.info(vo.toString());
		
		service.create(vo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/admin/mainLink/list";
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(int compNum, @ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		
		//링크 등록된 기관만
		model.addAttribute("list", service.listAll());
		
		model.addAttribute(service.read(compNum));
	}

	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(MainLinkVO vo, AppSearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(cri.toString());
		service.modify(vo);
		
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/admin/mainLink/list";
	}
	
	   @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public void listPage(Model model) throws Exception {
		   
		      logger.info("show listAll............");
		      //페이징처리없이 리스트화면 보여줌
		      model.addAttribute("list", service.listAll());
	   }
	
	   
	
}
