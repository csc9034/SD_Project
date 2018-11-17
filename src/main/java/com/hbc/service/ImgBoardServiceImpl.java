package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbc.domain.ImgBoardVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.ImgBoardDAO;

@Service
public class ImgBoardServiceImpl implements ImgBoardService {

   @Inject
   private ImgBoardDAO dao;

   @Override
   public void regist(ImgBoardVO board) throws Exception {

      // 1. 텍스트에어리어 줄바꿈 적용
      board.setContent(board.getContent().replace("\r\n", "<br>"));

      // 2.게시글 등록 후 게시글 SEQ 받아오기
      int imgnum = dao.create(board);
      System.out.println("=====>imgnum: " + imgnum);

      // 3.게시글에 연결된 이미지 저장

//      // 3-1 대표 이미지 객체 생성
//      ImgFileVO vo = new ImgFileVO();
//
//      // 3-2 게시글 SEQ 설정
//      vo.setNum(imgnum);
//
//      // 3-3 대표 이미지 정보 설정
//      vo.setName(board.getMainfile());
//      System.out.println(board.getMainfile());
//      vo.setMain("1");
//
//      System.out.println("mainVo : " + vo);
//
//      // 3-4 대표 이미지 디비 저장
//      dao.addAttach(vo);

      // 4. 추가 이미지 존재 여부 IF문
      if (board.getFiles() != null) {

         // 4. 추가 이미지 저장 FOR문
         for (int i = 0; i < board.getFiles().length; i++) {

            // 4-1.추가 이미지 저장

            ImgFileVO subVo = new ImgFileVO();
            subVo.setNum(imgnum);
            subVo.setMain("0");
            subVo.setName(board.getFiles()[i]);

            // System.out.println("subVo : " + subVo);

            // 4-2.추가 이미지 저장
            dao.addAttach(subVo);

         }
      }

   }

   @Override
   public ImgBoardVO read(int imgnum) throws Exception {
      ImgBoardVO board = dao.read(imgnum);
      
      if(board.getContent() != null) {
         board.setContent(board.getContent().replace("<br>", "\r\n"));
      }
      
      return board;
   }

   @Override
   public ImgBoardVO userRead(int imgnum) throws Exception {
      dao.updateViewCnt(imgnum);

      return dao.read(imgnum);
   }

   @Transactional
   @Override
   public void modify(ImgBoardVO board) throws Exception {

      // 1-1. 텍스트에어리어 줄바꿈 적용
      board.setContent(board.getContent().replace("\r\n", "<br>"));

      // 1-2.게시글 수정
      dao.update(board);

      int imgnum = board.getImgnum();

      // 2.첨부파일 삭제
      dao.deleteAttach(imgnum);

      // 3-2 게시글 SEQ 설정
      // 3.첨부파일 교체 작업

      ImgFileVO vo = new ImgFileVO();

//      // 3-1 대표 이미지 정보 설정
//      vo.setName(board.getMainfile());
//      vo.setMain("1");
//      vo.setNum(imgnum);
//
//      System.out.println("mainVo : " + vo);
//
//      // 3-2 대표 이미지 디비 저장
//      dao.addAttach(vo);

      // 4. 추가 이미지 존재 여부 IF문
      if (board.getFiles() != null) {

         // 4. 추가 이미지 저장 FOR문
         for (int i = 0; i < board.getFiles().length; i++) {

            // 4-1.추가 이미지 저장

            ImgFileVO subVo = new ImgFileVO();
            subVo.setNum(imgnum);
            subVo.setMain("0");
            subVo.setName(board.getFiles()[i]);

            System.out.println("subVo : " + subVo);

            // 4-2.추가 이미지 저장
            dao.addAttach(subVo);

         }
      }
      // dao.deleteAttach(imgnum);
      // dao.deleteMainAttach(imgnum);
      //
      // //추가 이미지
      // String[] files = board.getFiles();
      // if(files ==null) {return;}
      // for(String fileName : files)
      // dao.replaceAttach(fileName, imgnum);
      //
      // //메인 이미지
      // String mainfileName = board.getMainfile();
      // dao.replaceMainAttach(mainfileName, imgnum);

   }

   @Override
   public void remove(int imgnum) throws Exception {
      dao.deleteAttach(imgnum);
      dao.delete(imgnum);
   }

   @Override
   public List<ImgBoardVO> listAll() throws Exception {
      return dao.listAll();
   }

   @Override
   public List<ImgBoardVO> listCriteria(Criteria cri) throws Exception {
      return dao.listCriteria(cri);
   }

   @Override
   public int listCountCriteria(Criteria cri) throws Exception {
      return dao.countPaging(cri);
   }

   @Override
   public List<ImgBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
      return dao.listSearch(cri);
   }

   @Override
   public int listSearchCount(SearchCriteria cri) throws Exception {
      return dao.listSearchCount(cri);
   }

   @Override
   public List<ImgFileVO> getAttach(Integer imgnum) throws Exception {
      return dao.getAttach(imgnum);
   }

   @Override
   public List<ImgFileVO> getMainAttach(Integer imgnum) throws Exception {
      return dao.getMainAttach(imgnum);
   }

   @Override
   public List<ImgFileVO> getUAttach(Integer imgnum) throws Exception {
      return dao.getUAttach(imgnum);
   }

   @Override
   public List<ImgFileVO> getUMainAttach(Integer imgnum) throws Exception {
      return dao.getUMainAttach(imgnum);
   }

   @Override
   public List<ImgBoardVO> getRelatAtt(Integer imgnum) throws Exception {
      return dao.getRelatAtt(imgnum);
   }

   @Override
   public void deleteAttach(Integer imgnum) throws Exception {

      dao.delete(imgnum);

   }

   @Override
   public void deleteMainAttach(Integer imgnum) throws Exception {
      dao.delete(imgnum);

   }

   /*
    * @Override public List<ImgVO> getAttach(Integer imgnum) throws Exception {
    * 
    * List<ImgVO> imglist = dao.getAttach(imgnum);
    * 
    * for(int idx = 0; idx < imglist.size(); idx++) {
    * 
    * ImgVO vo = imglist.get(idx);
    * 
    * if(vo.getMain() == "0") { //SUB
    * 
    * }
    * 
    * } imgnum = return null;
    * 
    * 
    * 
    * 
    * // return dao.getAttach(imgnum); return null; }
    */

}