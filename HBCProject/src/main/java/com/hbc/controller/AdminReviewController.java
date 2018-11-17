package com.hbc.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.ReviewVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.ReviewService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/review/**")
/**
 * ReviewAdminController
 * 관리자리뷰 컨트롤러
 * @author 이동희
 *
 */
public class AdminReviewController {
	
private static final Logger logger = LoggerFactory.getLogger(AdminReviewController.class);
	
	@Inject
	private ReviewService reService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	/**
	 * 수강후기 리스트 페이지 -- 관리자
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		System.out.println((cri.toString()));
		
		//강좌 리스트 생성
		List<CourseVO> courList = reService.searchCourseList(cri.getsearchComp());
		
		//기관 리스트 보내주기
		model.addAttribute("compSelect", reService.ajaxSearchList());
		//강좌 리스트 보내주기
		model.addAttribute("courList", courList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(reService.listSearchCount(cri));
		
		model.addAttribute("list", reService.listSearch(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping("/list.do")
	/**
	 * ajax 셀렉트 박스 처리
	 * @param req
	 * @param res
	 * @param param
	 * @param comp
	 */
	public void selectAjax(HttpServletRequest req, HttpServletResponse res, String param ,CompanyVO comp) { 
	   try {
		
	   // 알맞은 동적 select box info 생성
	   // 기관 리스트객체를 생성
	   List<CompanyVO> compList = reService.ajaxSearchList();
	   for(CompanyVO compa : compList) {
		   System.out.println(compa);
	   }
	   
	   // 강좌 리스트객체를 생성
	   List<CourseVO> cousrList = reService.ajaxSearchCourseList(param);
	   for(CourseVO vo : cousrList) {
		   System.out.println(vo);
	   }
	   
	   // 기관과 강좌가 매칭되는 것을 저장할 리스트 객체를 생성 
	   List<CourseVO> cousre = new ArrayList<CourseVO>();
	   
	   for(int i =0; i<compList.size(); i++) {
		   if(compList.get(i).getCompnum()==1) {
			   for(int j=0; j<cousrList.size(); j++) {
				   cousre.add(cousrList.get(j));
			   }
		   }
	   }
	   
	   // jsonArray에 추가
	   JSONArray jsonArray = new JSONArray();
	   for (int i = 0; i < cousre.size(); i++) {
	      jsonArray.add(cousre.get(i));
	   }
	 
	   // jsonArray 넘김
	   PrintWriter pw = res.getWriter();
	   pw.print(jsonArray.toString());
	   pw.flush();
	   pw.close();
	 
	   } catch (Exception e) {
		  
	       System.out.println("Controller error");
	   }
	}
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	/**
	 * 수강후기 삭제 -- 관리자
	 * @param reviewNum
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	public String deletePage(@RequestParam("reviewNum") int reviewNum
			              , @ModelAttribute("cri") SearchCriteria cri
			              , RedirectAttributes rttr) throws Exception {
		
		reService.remove(reviewNum);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/admin/review/list";
	}
		
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	/**
	 * 수강후기 수정 페이지 -- 관리자/GET
	 * @param reviewNum
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	public void modifyPageGET(@RequestParam("reviewNum") int reviewNum
			               , @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

//		List<CompanyVO> compList = compService.searchList("1");
//		model.addAttribute("compList", compList);

		ReviewVO vo = reService.read(reviewNum);
		
		model.addAttribute(vo);
		System.out.println("컨트롤러 리뷰넘"+reviewNum);
		
		
		List<CourseVO> courList = reService.searchCourseList(vo.getCompNum());
		model.addAttribute("courList", courList);
		model.addAttribute("compSelect", reService.ajaxSearchList());
		
		
	}
		
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	/**
	 * 수강후기 수정 페이지 -- 관리자/POST
	 * @param review
	 * @param model
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	public String modifyPagePOST(ReviewVO review, Model model, @ModelAttribute("cri") SearchCriteria cri
			                  , RedirectAttributes rttr) throws Exception {
		
		logger.info(cri.toString());
		
		reService.modify(review);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("searchComp", cri.getsearchComp());
		rttr.addAttribute("searchCour", cri.getsearchCour());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/admin/review/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	/**
	 * 수강후기 등록 페이지 -- 관리자/GET
	 * @param model
	 * @throws Exception
	 */
	public void registGET(Model model) throws Exception {
		
		logger.info("register post.............");
		model.addAttribute("compSelect", reService.ajaxSearchList());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	/**
	 * 수강후기 등록 페이지 -- 관리자/POST
	 * @param review
	 * @param rttr
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public String registPOST(ReviewVO review, RedirectAttributes rttr,  Model model) throws Exception {

		logger.info("register post.............");
		logger.info(review.toString());
		
		System.out.println(review);
		reService.regist(review);
		
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/review/list";
	}
	
}
