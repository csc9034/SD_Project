package com.hbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.hbc.domain.EventBoardVO;
import com.hbc.domain.EventFileVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.EventBoardService;
import com.hbc.util.MediaUtils;

@Controller
@RequestMapping("/admin/eventBoard/*")
public class AdminEventBoardController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEventBoardController.class);

	@Resource(name = "imgUploadPath")
	private String imgUploadPath;

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;

	@Inject
	private EventBoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(EventBoardVO board, Model model, RedirectAttributes rttr, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		
		logger.info("register get............");

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(EventBoardVO board, RedirectAttributes rttr, MultipartHttpServletRequest mtfRequest) throws Exception {

		logger.info("register post...........");
		logger.info(board.toString());

		MultipartFile mfImg = mtfRequest.getFile("imgFile");
		MultipartFile mfAttach = mtfRequest.getFile("attachFile");

		String saveFile;

		Map<String, String> fileName = new HashMap<>();
		if (mfImg != null) {
			if (!mfImg.getOriginalFilename().equals("")) {
				String imgName = System.currentTimeMillis() + mfImg.getOriginalFilename();
				System.out.println("imgName value : " + imgName);
				saveFile = imgUploadPath + imgName;

				fileName.put("img", imgName);

				try {
					mfImg.transferTo(new File(saveFile));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (mfAttach != null) {
			if (!mfAttach.getOriginalFilename().equals("")) {
				String attachName = System.currentTimeMillis() + mfAttach.getOriginalFilename();
				System.out.println("attachName value : " + attachName);
				saveFile = fileUploadPath + attachName;

				fileName.put("attach", attachName);

				try {
					mfAttach.transferTo(new File(saveFile));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		service.regist(board, fileName);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/eventBoard/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("list", service.searchListCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.searchListCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("num") int num, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(num);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(int num, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute(service.readAdmin(num));
		model.addAttribute("imgFile", service.readFile(num, "0"));
		model.addAttribute("attachFile", service.readFile(num, "1"));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagingPOST(EventBoardVO bvo, SearchCriteria cri, RedirectAttributes rttr, MultipartHttpServletRequest mtfRequest) throws Exception {
		logger.info(cri.toString());

		MultipartFile mfImg = mtfRequest.getFile("imgFile");
		MultipartFile mfAttach = mtfRequest.getFile("attachFile");

		// 이미 등록된 이미지 파일 이름
		String imgFileName = mtfRequest.getParameter("imgName");
		
		// 이미 등록된 첨부 파일 이름
		String attachFileName = mtfRequest.getParameter("attachName");
		
		if (mfImg != null) {

			if (!mfImg.getOriginalFilename().equals("")) {

				String imgName = System.currentTimeMillis() + mfImg.getOriginalFilename();

				System.out.println("mfImg ===> " + imgName);

				try {
					mfImg.transferTo(new File(imgUploadPath + imgName));
					EventFileVO fileVO = new EventFileVO();

					fileVO.setName(imgName);
					fileVO.setType(0);
					fileVO.setNum(bvo.getNum());
					service.modifyFile(fileVO);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

				if (imgFileName.equals("파일선택")) {
					// 이미지 삭제
					EventFileVO fileVO = new EventFileVO();

					fileVO.setType(0);
					fileVO.setNum(bvo.getNum());
					service.deleteFile(fileVO);
				}

			}

		} else {

			if (imgFileName.equals("파일선택")) {
				// 이미지 삭제
				EventFileVO fileVO = new EventFileVO();

				fileVO.setType(0);
				fileVO.setNum(bvo.getNum());
				service.deleteFile(fileVO);

			}

		}

		if (mfAttach != null) {

			if (!mfAttach.getOriginalFilename().equals("")) {

				String attachName = System.currentTimeMillis() + mfAttach.getOriginalFilename();

				System.out.println("mfAttach ===> " + attachName);

				try {
					mfAttach.transferTo(new File(fileUploadPath + attachName));

					EventFileVO fileVO = new EventFileVO();

					fileVO.setName(attachName);
					fileVO.setType(1);
					fileVO.setNum(bvo.getNum());
					service.modifyFile(fileVO);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {

				if (attachFileName.equals("파일선택")) {
					// 첨부파일 삭제
					EventFileVO fileVO = new EventFileVO();

					fileVO.setType(1);
					fileVO.setNum(bvo.getNum());
					service.deleteFile(fileVO);
				}
			}

		} else {
			if (attachFileName.equals("파일선택")) {
				// 첨부파일 삭제
				EventFileVO fileVO = new EventFileVO();

				fileVO.setType(1);
				fileVO.setNum(bvo.getNum());
				service.deleteFile(fileVO);

			}
		}

		service.modify(bvo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/eventBoard/list";
	}

	@RequestMapping("/getAttach/{num}")
	@ResponseBody
	public String getAttach(@PathVariable("num") Integer num) throws Exception {
		return service.getAttach(num);
	}

	@RequestMapping(value = "/downloadFile.do")
	public void downloadFile(String fileName, HttpServletResponse response) throws Exception {

		byte fileByte[] = FileUtils.readFileToByteArray(new File(fileUploadPath + fileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	@ResponseBody
	@RequestMapping("/displayImg")
	public ResponseEntity<byte[]> displayImg(String fileName) throws Exception {

		System.out.println("=====> fileName : " + fileName);

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(imgUploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
}