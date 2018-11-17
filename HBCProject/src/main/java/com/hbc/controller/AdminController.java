package com.hbc.controller;

import static com.hbc.util.SHA256.getSHA256;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.AdminVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.LoginDTO;
import com.hbc.service.AdminService;

/**
 * 관리자 시스템의 관리자 뷰 컨트롤러
 * 
 * 관리자 기능을 컨트롤하는 Controller 로그인 기능등을 포함
 * 
 * @author 진재환 강현
 *
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Inject
	private AdminService service;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * 로그인 화면으로 이동하기 위한 메소드
	 * 
	 * @param dto
	 */
	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	/**
	 * 로그인 기능을 수행하는 메소드 모든 기능을 수행하고 admin/loginPost.jsp 화면으로 이동
	 * 
	 * @param dto
	 *            - 로그인 정보(아이디, 비밀번호)를 담고있는 dto
	 * @param session
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {

		AdminVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("adminVO", vo);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "admin/login";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	/**
	 * 관리자 리스트로 이동하는 메소드
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public void adminList(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		model.addAttribute("list", service.listSearch(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	/**
	 * 관리자 등록화면으로 이동하는 메소드
	 * 
	 * @param board
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		model.addAttribute("compList", service.readComps());
	}

	/**
	 * 관리자 등록 처리하는 메소드
	 * 
	 * @param admin
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registPOST(AdminVO admin, RedirectAttributes rttr) throws Exception {

		admin.setAdminPhone(admin.getAdminPhone().replace("-", ""));
		
		service.insert(admin);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/user/list";
	}

	/**
	 * 관리자 수정 페이지로 이동하는 메소드
	 * 
	 * @param adminId
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam(value = "adminId", required = true) String adminId,
			@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		
		
		model.addAttribute("admin", service.read(new AdminVO(adminId)));
		model.addAttribute("compList", service.readComps());
	}

	/**
	 * 관리자 수정 과정을 처리하는 메소드
	 * 
	 * @param admin
	 * @param cri
	 * @param rttr
	 * @return 리다이렉트 방식으로 list 뷰로 이동
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(AdminVO admin, AppSearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(cri.toString());

		admin.setAdminPhone(admin.getAdminPhone().replace("-", ""));
		
		/*
		 * 정보 수정 시 비밀번호를 입력하지 않으면
		 * null 값을 넣어서 
		 * 매퍼에서 비밀번호를 바꾸지 않도록 처리해주는 로직
		 */
		if((getSHA256("")).equals(admin.getAdminPw())) {
			admin.setAdminPw(null);
		}
		
		service.update(admin);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/admin/user/list";
	}

	/**
	 * 삭제 과정을 처리하는 메소드
	 * 
	 * @param adminId
	 * @param cri
	 * @param rttr
	 * @return 리다이렉트 방식으로 리스트로 이동
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("adminId") String adminId, AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {
		service.delete(new AdminVO(adminId));

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/user/list";
	}

}
