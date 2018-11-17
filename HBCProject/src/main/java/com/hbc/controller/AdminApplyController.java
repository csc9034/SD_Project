package com.hbc.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.hbc.domain.ApplyVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.ApplyService;
import com.hbc.service.StudentService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/apply/*")
public class AdminApplyController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCourseController.class);

	@Inject
	private ApplyService service;
	@Inject
	private StudentService stuService;
	
	/**
	 * 수강을 등록하는 페이지로 이동하는 메소드
	 * 
	 * @param apply
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("cri") AppSearchCriteria cri, ApplyVO apply, Model model) throws Exception {
		model.addAttribute("list", service.listComp());
		logger.info("regist get.......................");

	}
	
	/**
	 * 수강 등록 페이지에서 수강을 등록해주는 페이지
	 *  
	 * @param apply : 등록할 ApplyVO 객체
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ApplyVO apply, RedirectAttributes rttr) throws Exception {

		logger.info("regist post.......................");
		logger.info("등록 : " + apply.toString());

		service.register(apply);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/apply/list";

	}
	
	/**
	 * ajax로 호출 된 컨트롤러로서 특정 기관의 이름을 조회하여 해당 기관의 과목을 조회하여 json 객체로 반환해주는 메소드
	 * 
	 * @param req
	 * @param res
	 * @param param
	 */
	@RequestMapping(value = "/testSelect", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void selectAjax(HttpServletRequest req, HttpServletResponse res, String param) {
		try {
			// ajax에서 받은 기관의 이름을 compname 변수에 담음
			String compname = param;

			System.out.println(compname);
			
			// 기관 번호와 명만 조회하여 리스트에 담은 객체 생성
			List<CompanyVO> compList = service.listComp();
			
			// 리스트 확인
			for (CompanyVO vo : compList) {
				System.out.println(vo);
			}
			
			// 특정 기관명을 조회하여 해당하는 과목번호와 이름을 조회하여 리스트 객체 생성
			List<CourseVO> courList = service.listCour(compname);
			
			// 리스트 확인
			for (CourseVO vo : courList) {
				System.out.println(vo);
			}
			
			
			List<CourseVO> courJsonList = new ArrayList<CourseVO>();

			for (int idx = 0; idx < compList.size(); idx++) {
				if (compname.equals(compList.get(idx).getCompname())) {
					for (int i = 0; i < courList.size(); i++) {
						courJsonList.add(courList.get(i));
					}
				}
			}

			// jsonArray에 추가
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < courJsonList.size(); i++) {
				jsonArray.add(courJsonList.get(i));
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
	
	/**
	 * 회사번호와 회사명을 조회하는 메소드
	 * 
	 * @param course
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/listComp", method = RequestMethod.GET)
	public void listAll(CourseVO course, Model model) throws Exception {

		logger.info("show all list..........");
		model.addAttribute("list", service.listComp());

	}
	
	/**
	 * 전체 리스트 페이지에 보여줄 수강 정보를 조회하는 메소드
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
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

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void stuSearch(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());

		model.addAttribute("list", stuService.listSearchCriteria(cri));

		System.out.println("조회" + stuService.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(stuService.listSearchCount(cri));

		System.out.println(pageMaker.getTotalCount());
		logger.info(pageMaker.getTotalCount() + "페이지개수");

		model.addAttribute("pageMaker", pageMaker);
		

		
	}
	
	/**
	 * 특정 appnum을 조회하여 수정 페이지로 이동하는 메소드
	 * 
	 * @param appnum  : 조회할 appnum
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPageingGET(@RequestParam("appnum") int appnum, @ModelAttribute("cri") AppSearchCriteria cri,
			Model model) throws Exception {

		/*
		 * 수정 화면에서 데이트타임피커가
		 * 잘 작동할 수 있도록 포맷을 맞춰주는 코드
		 * 
		 * comment.. 데이터베이스 자료형 다시 DATE로 바꾸어야 될것 같습니다. by 강현
		 * 
		 */
		ApplyVO appvo = service.read(appnum);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY HH:mm");
		model.addAttribute("sdate", sdf.format(appvo.getSdate()));
		model.addAttribute("edate", sdf.format(appvo.getEdate()));
		
		model.addAttribute(service.readDTO(appnum));
		model.addAttribute(service.read(appnum));
		model.addAttribute("list", service.listComp());
		
		String compname = service.readDTO(appnum).getCompname();
		
		model.addAttribute("courList", service.listCour(compname));
		

	}
	
	/**
	 * 수강 정보를 수정하게 해주는 메소드
	 * 
	 * @param apply
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPage(ApplyVO apply, @ModelAttribute("cri") AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("mod Post.............");
		logger.info("제발====================================>" + cri.getPage());
		logger.info("mod Post.............");

		service.modify(apply);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/apply/list";

	}
	
	/**
	 * 특정 appnum을 조회하여 해당 수강 정보를 삭제하는 메소드
	 * 
	 * @param appnum
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("appnum") int appnum, AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {
		
		service.remove(appnum);
		System.out.println(appnum);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		System.out.println("삭제!");
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/apply/list";
	}

}
