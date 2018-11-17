package com.hbc.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.NoticeVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.NoticeService;

@Controller
@RequestMapping("notice/*")
public class NoticeController {
	@Inject
	private NoticeService service;
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(NoticeVO vo, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(NoticeVO vo, RedirectAttributes rttr, @RequestParam("uri") String[] uri) throws Exception {
		logger.info(vo.toString());
		System.out.println("컨트롤러 uri : "+ uri[0]);
		vo.setLinks(uri);
		service.regist(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}*/

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		model.addAttribute("list", service.searchlist(cri));
		model.addAttribute("topList", service.topList(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	/*@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("noNum") int noNum, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(service.read(noNum));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(NoticeVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {
		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("noNum") int noNum, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		service.remove(noNum);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}*/
	
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public void getNoViewCnt(@RequestParam("noNum") Integer noNum) throws Exception{
		 service.userRead(noNum);
	}
	
	@RequestMapping("/getAttach/{noNum}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("noNum") Integer noNum) throws Exception{
		return service.getAttach(noNum);
	}
	
	@RequestMapping("/getUriLink")
	@ResponseBody
	public String getUriLink(@RequestParam("fullName") String fullName) throws Exception{
		System.out.println("컨트롤러 uri 파일 명 : "+ fullName);
		return service.getUri(fullName);
	}
	
}
