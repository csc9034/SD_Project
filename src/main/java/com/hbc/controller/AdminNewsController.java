package com.hbc.controller;

/**
 * 관리자의 News게시판 컨트롤러
 * 전현찬, 윤홍식
 */
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.NewsVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.NewsService;

@Controller
@RequestMapping("/admin/news/*")
public class AdminNewsController {
	private static final Logger logger = LoggerFactory.getLogger(AdminNewsController.class);

	@Resource(name = "newsUploadPath")
	private String uploadPath;

	@Inject
	private NewsService service;

	// 등록 GET방식
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("regist get ..........");
	}

	// 등록 POST방식
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(NewsVO news, RedirectAttributes rttr, MultipartHttpServletRequest mtfRequest)
			throws Exception {

		logger.info("regist post ...........");
		logger.info(news.toString());

		MultipartFile mf = mtfRequest.getFile("file");

		if (mf != null) {

			if (!mf.getOriginalFilename().equals("")) {

				// 업로드된 파일 저장
				// 원본 파일 명
				String originFileName = mf.getOriginalFilename();

				// 실제 DB에 저장될 현재 시간 + 원본 파일명(경로 제외)
				String safeFile = System.currentTimeMillis() + originFileName;

				try {

					// 실제 업로드 폴더에 파일 저장
					mf.transferTo(new File(uploadPath + safeFile));

				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 첨부파일 정보 객체 저장
				news.setFileName(safeFile);
			}
		}

		// 게시글 디비 저장 -> 첨부파일 저장
		service.regist(news);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/news/list";

	}

	// 조회 GET방식
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("newsNum") int newsNum, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		model.addAttribute(service.read(newsNum));
	}

	// 조회 POST방식
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("newsNum") int newsNum, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		// 1.첨부파일 삭제 => 2.게시글 삭제
		service.remove(newsNum);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/news/list";
	}

	// 수정 GET방식
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("newsNum") int newsNum, @ModelAttribute("cri") SearchCriteria cri,
			Model model) throws Exception {
		System.out.println(cri.getKeyword());
		// 게시글 정보 + 첨부파일
		model.addAttribute(service.read(newsNum));
	}

	// 수정 POST방식
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(NewsVO news, SearchCriteria cri, RedirectAttributes rttr,
			MultipartHttpServletRequest mtfRequest) throws Exception {

		// 업로드된 파일 저장
		MultipartFile mf = mtfRequest.getFile("file");
		String attachName = mtfRequest.getParameter("attachName");

		if (mf != null) {

			// 보도 자료 수정 시, 첨부 파일도 수정
			if (!mf.getOriginalFilename().equals("")) {

				// 원본 파일 명
				String originFileName = mf.getOriginalFilename();

				// 실제 DB에 저장될 현재 시간 + 원본 파일명(경로 제외)
				String safeFile = System.currentTimeMillis() + originFileName;

				try {

					// 실제 업로드 폴더에 파일 저장
					mf.transferTo(new File(uploadPath + safeFile));

				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 첨부파일 정보 객체 저장
				news.setFileName(safeFile);

			} else {

				// 보도 자료 수정 시, 첨부 파일 삭제
				if (attachName.equals("파일선택")) {
					// 첨부파일 삭제
					/*NewsVO fileVO = new NewsVO();
					fileVO.setNewsNum(news.getNewsNum());
					service.deleteFile(fileVO);*/
					news.setFileName(attachName);
				}
			}

		}else {

	         if (attachName.equals("파일선택")) {
					// 첨부파일 삭제
/*					NewsVO fileVO = new NewsVO();
					fileVO.setNewsNum(news.getNewsNum());
					service.deleteFile(fileVO);*/
					news.setFileName(attachName);

	         }
		}

		// 첨부파일 수정 -> 게시글 수정
		service.modify(news);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/news/list";
	}

	// 게시판 목록 가져오기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping("/getAttach/{newsNum}")
	@ResponseBody
	public String getAttach(@PathVariable("newsNum") Integer newsNum) throws Exception {
		return service.getAttach(newsNum);
	}

	// 첨부파일 다운로드 (사용자도 추가)
	@RequestMapping(value = "/downloadFile.do")
	public void downloadFile(String fileName, HttpServletResponse response) throws Exception {

		byte fileByte[] = FileUtils.readFileToByteArray(new File(uploadPath + fileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

}