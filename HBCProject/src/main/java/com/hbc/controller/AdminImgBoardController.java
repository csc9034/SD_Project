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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ImgBoardVO;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.ProgramVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.service.CompanyService;
import com.hbc.service.ImgBoardService;
import com.hbc.service.ProgramService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/imgBoard/*")
public class AdminImgBoardController {
   private static final Logger logger = LoggerFactory.getLogger(AdminImgBoardController.class);

   @Inject
   private ImgBoardService service;
   
   @Inject
   private CompanyService compservice;
   
   @Inject
   private ProgramService progservice;
   
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
	   
	  System.out.println("getMainAttach ===> " + imgnum);
      return service.getMainAttach(imgnum);
   }
   
   
   /**
    * 등록
    * 
    * @param cri
    * @throws Exception
    */
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public void registerGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
	   
      
      System.out.println("/register cri =====> " + cri);
      System.out.println(compservice.listComp());
      logger.info("register get......");
      
      model.addAttribute("list", compservice.listComp());

   }

   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public String registerPOST(ImgBoardVO board, RedirectAttributes rttr) throws Exception {
      logger.info("register post....");
      System.out.println(board.toString());
      
      //1.게시글 저장 -> SEQ 받아오기 -> 메인이미지 저장 -> 서브 이미지 저장(서비스단에서 로직 구현)
      service.regist(board);
      
      rttr.addFlashAttribute("msg", "SUCCESS");
      return "redirect:/admin/imgBoard/list";
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
      
      System.out.println("/list===> " + cri);

      model.addAttribute("list", service.listSearchCriteria(cri));
      
      PageMaker pageMaker = new PageMaker();
      pageMaker.setCri(cri);
      pageMaker.setTotalCount(service.listCountCriteria(cri));
      model.addAttribute("pageMaker", pageMaker);
      
      
   }
   
   
   /**
    * 페이징 처리되는 수정
    * @param imgnum
    * @param cri
    * @param model
    * @throws Exception
    */
   @RequestMapping(value = "/modify", method = RequestMethod.GET)
   public void modifyPagingGET(@RequestParam("imgnum") int imgnum, @ModelAttribute("cri") SearchCriteria cri, Model model)
         throws Exception {
      
      //1.게시글 객체 ImgBoardVO 게시글 가져오기
      ImgBoardVO vo = service.read(imgnum);
      
      //2.기관 리스트 가져오기
      List<CompanyVO> compList = compservice.listComp();
      
      //3.프로그램 리스트(객체형) 가져오기
      List<ProgramVO> progList = progservice.listProg(vo.getCompnum());
      
      //4.View 보내기
      model.addAttribute(vo);
      model.addAttribute("compList",compList);
      model.addAttribute("progList", progList);
      
      
      
   }
   
   @RequestMapping(value = "/modify", method = RequestMethod.POST)
   public String modifyPagingPOST(ImgBoardVO board, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {
      
	   
	   System.out.println("board===> " + board);
	   
      service.modify(board);
      
      rttr.addAttribute("page", cri.getPage());
      rttr.addAttribute("perPageNum", cri.getPerPageNum());
      rttr.addAttribute("searchType", cri.getSearchType());
      rttr.addAttribute("keyword", cri.getKeyword());
      
      rttr.addFlashAttribute("msg", "SUCCESS");
      
      return "redirect:/admin/imgBoard/list";
   }
   
   
   /**
    * 페이징 처리되는 삭제
    * @param imgnum
    * @param cri
    * @param rttr
    * @return
    * @throws Exception
    */
   @RequestMapping(value = "/remove", method = RequestMethod.GET)
   public String remove(@RequestParam("imgnum") int imgnum, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
         throws Exception {
      
      service.remove(imgnum);
      
      System.out.println("remove : " + cri);

      rttr.addAttribute("page", cri.getPage());
      rttr.addAttribute("perPageNum", cri.getPerPageNum());
      rttr.addAttribute("searchType", cri.getSearchType());
      rttr.addAttribute("keyword", cri.getKeyword());
      
      rttr.addFlashAttribute("msg", "SUCCESS");
      return "redirect:/admin/imgBoard/list";

   }
   
   /**
    * 페이징 처리되는 상세보기
    * @param imgnum
    * @param cri
    * @param model
    * @throws Exception
    */
   @RequestMapping(value = "/read", method = RequestMethod.GET)
   public void read(@RequestParam("imgnum") int imgnum, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
      model.addAttribute(service.read(imgnum));

   }
   

   
   @RequestMapping(value = "/testSelect", method = RequestMethod.POST, produces = "application/json; charset=utf8")
      public void selectAjax(HttpServletRequest req, HttpServletResponse res, String param) {
         try {
            // param 정보 받음
            String compname = param;

            System.out.println("회사이름" + compname);
            // 알맞은 동적 select box info 생성
            List<CompanyVO> compList = compservice.listComp();
            for (CompanyVO vo : compList) {
               System.out.println(vo);
            }
            
            //프로그램 리스트(문자형) 가져오기
            List<ProgramVO> progList = progservice.listAjaxProg(compname);
            for (ProgramVO vo : progList) {
               System.out.println(vo);
            }

            List<ProgramVO> progJsonList = new ArrayList<ProgramVO>();

            for (int idx = 0; idx < compList.size(); idx++) {
               if (compname.equals(compList.get(idx).getCompname())) {
                  for (int i = 0; i < progList.size(); i++) {
                     progJsonList.add(progList.get(i));
                  }
               }
            }

            // jsonArray에 추가
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < progJsonList.size(); i++) {
               jsonArray.add(progJsonList.get(i));
               System.out.println("jsonarray" + jsonArray);
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
   
}