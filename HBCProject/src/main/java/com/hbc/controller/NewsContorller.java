package com.hbc.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbc.domain.Criteria;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.NewsService;
/**
 * 사용자 News게시판 컨트롤러
 * @author 전현찬,윤홍식
 *
 */
@Controller
@RequestMapping("/news/*")
public class NewsContorller {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsContorller.class);
	
	@Resource(name = "newsUploadPath")
	private String uploadPath;

	@Inject
	private NewsService service;
	
	// 리스트목록 GET방식 가져오기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("list", service.listSearchCriteria(cri));

		/*model.addAttribute("sideList", service.sideList());*/
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
	
	// read GET방식 가져오기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("newsNum") int newsNum, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		service.updateViewCnt(newsNum);
		model.addAttribute(service.read(newsNum));
		
	}
	
	//첨부파일 다운로드 (사용자도 추가)
		@RequestMapping(value="/downloadFile.do")
		public void downloadFile(String fileName, HttpServletResponse response) throws Exception{
			
			byte fileByte[] = FileUtils.readFileToByteArray(new File(uploadPath+fileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		
	
	
}
