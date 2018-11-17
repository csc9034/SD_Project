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
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.CourseService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/course/*")
public class AdminCourseController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCourseController.class);

	@Inject
	private CourseService service;

	/**
	 * 과목을 등록하는 페이지로 이동해주는 등록 메소드
	 * 
	 * @param course
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("cri") AppSearchCriteria cri, CourseVO course, Model model)
			throws Exception {
		model.addAttribute("list", service.listComp());
		logger.info("regist get.......................");

	}

	/**
	 * 수강 정보를 등록해주는 메소드
	 * 
	 * @param course
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(CourseVO course, RedirectAttributes rttr) throws Exception {

		logger.info("regist post.......................");
		logger.info(course.toString());
		service.register(course);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/course/list";

	}

	/**
	 * 과목 리스트 페이지에 보여줄 정보를 조회해주는 메소드
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		System.out.println(pageMaker.getTotalCount());
		logger.info(pageMaker.getTotalCount() + "페이지개수");

		model.addAttribute("pageMaker", pageMaker);

	}

	/**
	 * 특정 과목을 수정할 수정페이지로 이동해주는 메소드
	 * 
	 * @param cournum
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPageingGET(@RequestParam("cournum") int cournum, @ModelAttribute("cri") AppSearchCriteria cri,
			Model model) throws Exception {

		model.addAttribute(service.readDTO(cournum));
		model.addAttribute("list", service.listComp());

		String compname = service.readDTO(cournum).getCompname();

		model.addAttribute("empList", service.listEmp(compname));

	}

	/**
	 * 특정 과목을 수정해주는 메소드
	 * 
	 * @param course
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPage(CourseVO course, @ModelAttribute("cri") AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("mod Post.............");
		logger.info("제발====================================>" + cri.getPage());
		logger.info("mod Post.............");

		service.modify(course);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/course/list";

	}

	/**
	 * 특정 과목을 삭제해 주는 메소드
	 * 
	 * @param cournum
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("cournum") int cournum, AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {
		
		service.remove(cournum);
		
		if (service.remove(cournum) == "success") {
			
			rttr.addFlashAttribute("msg", "SUCCESS");

		} else if (service.remove(cournum) == "fail") {
			
			rttr.addFlashAttribute("msg", "FAIL");
			
		}

		System.out.println(cournum);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		System.out.println("삭제!");

		return "redirect:/admin/course/list";

	}

	/**
	 * ajax로 호출 된 컨트롤러로서 특정 기관의 이름을 조회하여 기관에 소속된 직원을 조회하여 json 객체로 반환해주는 메소드
	 * 
	 * @param req
	 * @param res
	 * @param param
	 */
	@RequestMapping(value = "/testSelect", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void selectAjax(HttpServletRequest req, HttpServletResponse res, String param) {
		try {
			// param 정보 받음
			String compname = param;

			System.out.println(compname);
			// 알맞은 동적 select box info 생성
			List<CompanyVO> compList = service.listComp();
			for (CompanyVO vo : compList) {
				System.out.println(vo);
			}
			List<EmployeeVO> empList = service.listEmp(compname);
			for (EmployeeVO vo : empList) {
				System.out.println(vo);
			}

			List<EmployeeVO> empJsonList = new ArrayList<EmployeeVO>();

			for (int idx = 0; idx < compList.size(); idx++) {
				if (compname.equals(compList.get(idx).getCompname())) {
					for (int i = 0; i < empList.size(); i++) {
						empJsonList.add(empList.get(i));
					}
				}
			}

			// jsonArray에 추가
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < empJsonList.size(); i++) {
				jsonArray.add(empJsonList.get(i));
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

	@RequestMapping(value = "/listComp", method = RequestMethod.GET)
	public void listAll(CourseVO course, Model model) throws Exception {

		logger.info("show all list..........");
		model.addAttribute("list", service.listComp());

	}

}
