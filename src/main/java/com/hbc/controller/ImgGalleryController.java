package com.hbc.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

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

import com.hbc.domain.Criteria;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.ImgGalleryService;
import com.hbc.util.MediaUtils;

@Controller
@RequestMapping("/imgGallery/*")
public class ImgGalleryController {
	private static final Logger logger = LoggerFactory.getLogger(ImgGalleryController.class);

	@Inject
	private ImgGalleryService imgGalleryService;

	/**
	 * 파일을 업로드하기 위해 리소스 어노테이션을 단 업로드 경로를 선언함
	 */
	@Resource(name = "imgGalleryUploadPath")
	private String imgGalleryUploadPath;

	@RequestMapping(value = "/getAttach/{galnum}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("galnum") Integer galnum) throws Exception {
		return imgGalleryService.getAttach(galnum);
	}

	/**
	 * 목록 갯수
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("show all list with Criteria.........");
		model.addAttribute("list", imgGalleryService.listCriteria(cri));
	}

	/**
	 * 목록 with 페이징 처리
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	   public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
	      logger.info(cri.toString());

	      model.addAttribute("list", imgGalleryService.listSearchCriteria(cri));   

	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCri(cri);
	      
	      // 사용자 화면 List 5개로 설정 : 기존은 10개
	      cri.setPerPageNum(5);

	      pageMaker.setTotalCount(imgGalleryService.listSearchCount(cri));

	      model.addAttribute("pageMaker", pageMaker);

	   }

	/**
	 * 페이징 처리되는 상세보기
	 * 
	 * @param imgnum
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void read(@RequestParam("galnum") int galnum, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		model.addAttribute("galleryBoardVO", imgGalleryService.userRead(galnum));
		model.addAttribute("list", imgGalleryService.getAttach(galnum));

	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(imgGalleryUploadPath + fileName);

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