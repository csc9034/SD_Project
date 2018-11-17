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

import com.hbc.domain.Criteria;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.ImgBoardService;

@Controller
@RequestMapping("/imgBoard/*")
public class ImgBoardController {
   private static final Logger logger = LoggerFactory.getLogger(ImgBoardController.class);

   @Inject
   private ImgBoardService service;
   
   
   
   /**
    * 2018.08.21
    * 11:45
    * @param imgnum
    * @return
    * @throws Exception
    */
   @RequestMapping(value = "/getAttach/{imgnum}")
   @ResponseBody
   public List<ImgFileVO> getAttach(@PathVariable("imgnum") Integer imgnum) throws Exception{
      return service.getAttach(imgnum);
   }
   
   
   /**
    * 2018.08.21
    * 11:45
    * @param imgnum
    * @return
    * @throws Exception
    */
   @RequestMapping(value = "/getMainAttach/{imgnum}")
   @ResponseBody
   public List<ImgFileVO> getMainAttach(@PathVariable("imgnum") Integer imgnum) throws Exception{
      return service.getMainAttach(imgnum);
   }
   
   
   /**
    * 목록 갯수
    * @param cri
    * @param model
    * @throws Exception
    */
   @RequestMapping(value = "/listCri", method = RequestMethod.GET)
   public void listAll(Criteria cri, Model model) throws Exception {
      logger.info("show all list with Criteria.........");
      model.addAttribute("list", service.listCriteria(cri));
   }
   
   /**
    * 목록 with 페이징 처리
    * @param cri
    * @param model
    * @throws Exception
    */
   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
      logger.info(cri.toString());

      
      //사용자 화면 리스트 5개로 보여주기
      cri.setPerPageNum(5);
      
      model.addAttribute("list", service.listSearchCriteria(cri));
      PageMaker pageMaker = new PageMaker();
      pageMaker.setCri(cri);

      pageMaker.setTotalCount(service.listCountCriteria(cri));

      model.addAttribute("pageMaker", pageMaker);
   }
   
   
   
   /**
    * 페이징 처리되는 상세보기
    * @param imgnum
    * @param cri
    * @param model
    * @throws Exception
    */
   @RequestMapping(value = "/detail", method = RequestMethod.GET)
   public void read(@RequestParam("imgnum") int imgnum, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
      PageMaker pageMaker = new PageMaker();
      pageMaker.setCri(cri);

      pageMaker.setTotalCount(service.listCountCriteria(cri));
      model.addAttribute("imgBoardVO", service.userRead(imgnum));
      model.addAttribute("mainImg", service.getUMainAttach(imgnum));
      model.addAttribute("imgs", service.getUAttach(imgnum));
      model.addAttribute("RImgs", service.getRelatAtt(imgnum));
      
      
      

   }
   
}