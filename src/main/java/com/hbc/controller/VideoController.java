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

import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.VideoBoardVO;
import com.hbc.service.VideoBoardService;

@Controller
@RequestMapping("/admin/videoBoard/*")
public class VideoController {

	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

	@Inject
	private VideoBoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(RedirectAttributes rttr, @ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		logger.info("register get........");
		
		model.addAttribute("list", service.selectComp());
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(VideoBoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post.............");
		logger.info(board.toString());
		
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/videoBoard/list";
	}
	
	   @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		      logger.info(cri.toString());
		      
		      model.addAttribute("lists", service.selectComp());
		      model.addAttribute("list", service.searchListCriteria(cri));
		      
		      PageMaker pageMaker = new PageMaker();
		      pageMaker.setCri(cri);
		      cri.setPerPageNum(10);
		      pageMaker.setTotalCount(service.listSearchCount(cri));
		      
		      
		      
		      model.addAttribute("pageMaker", pageMaker);
	   
	   }
	   
	   
	   
		@RequestMapping(value = "/modify", method = RequestMethod.GET)
		public void modifyPagingGET(int num, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
			
			model.addAttribute("list", service.selectComp());
			model.addAttribute(service.adminRead(num));
			
		}

		
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String modifyPagingPOST(VideoBoardVO vo, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
			logger.info(cri.toString());
			System.out.println(vo);
			service.modify(vo);

			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "SUCCESS");
			
			logger.info(rttr.toString());

			return "redirect:/admin/videoBoard/list";
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public String remove(@RequestParam("num") int num, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
			service.remove(num);

			// 보던 곳으로 가기위해서
			rttr.addAttribute("page", cri.getPage());//페이지번호
			rttr.addAttribute("perPageNum", cri.getPerPageNum());//페이지 데이터 수
			rttr.addAttribute("searchType", cri.getSearchType());// 검색타입
			rttr.addAttribute("keyword", cri.getKeyword());// 키워드

			rttr.addFlashAttribute("msg", "SUCCESS");

			return "redirect:/admin/videoBoard/list";
		}
	   
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public void read(@RequestParam("num") int num, @ModelAttribute("cri") SearchCriteria cri, Model model)
				throws Exception {
			model.addAttribute(service.read(num));
			System.out.println(num);
		}
	
	
}
