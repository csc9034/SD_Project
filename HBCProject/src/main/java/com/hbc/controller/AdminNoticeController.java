package com.hbc.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("admin/notice/*")
public class AdminNoticeController {
	@Inject
	private NoticeService service;
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(NoticeVO vo, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(NoticeVO vo, RedirectAttributes rttr, @RequestParam(value="imgUri", required=false) String[] imgUri, @RequestParam(value="imgFileName", required=false) String[] imgFileName) throws Exception {
		logger.info(vo.toString());
		vo.setLinks(imgUri);
		vo.setImgFileNames(imgFileName);
		service.regist(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}

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

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("noNum") int noNum, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(service.read(noNum));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(NoticeVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr, @RequestParam(value="imgUri", required=false) String[] imgUri, @RequestParam(value="imgFileName", required=false) String[] imgFileName)
			throws Exception {
		vo.setLinks(imgUri);
		for(String temp : imgUri) {
			
			System.out.println("컨트롤러 수정 URI : " + temp);
		}
		vo.setImgFileNames(imgFileName);
		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(@RequestParam("noNum") int noNum, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		service.remove(noNum);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/notice/list";
	}
	@ResponseBody
	@RequestMapping(value="/removeAttach", method=RequestMethod.POST)
	public ResponseEntity<String> removeAttach(@RequestParam("fileName") String fileName) throws Exception{
		service.removeRink(fileName);
		service.removeAttach(fileName);
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
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
