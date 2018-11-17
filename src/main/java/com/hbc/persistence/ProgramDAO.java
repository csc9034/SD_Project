package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.ProgSearchCriteria;
import com.hbc.domain.ProgramVO;

public interface ProgramDAO {
	
	/*관리자 화면 등 수 삭 읽*/
	
	   public void create(ProgramVO vo) throws Exception;
	   
	   public ProgramVO read(Integer intronum) throws Exception;
	   
	   public void update(ProgramVO vo) throws Exception;
	   
	   public void delete(Integer intronum) throws Exception;
	   
	   // use for dynamic sql
	   public List<ProgramVO> searchList(ProgSearchCriteria cri) throws Exception;
	   
	   public int listSearchCount(ProgSearchCriteria cri) throws Exception;
	   
	   public List<String> centerList() throws Exception; 
	   
	   /*사용자 화면*/
	   
	   // 사이드메뉴
	   public List<String> sideList() throws Exception; 
	   // 프로그램 목록
	   public List<String> programList(ProgramVO vo) throws Exception;
	   // 프로그램 대표이미지
	   public List<String> programImg(Integer intronum) throws Exception;
	   // 프로그램을 쓰는 이미지들
	   public List<String> programImgs() throws Exception;
	
	//객체형 Program 리스트 가져오기
	public List<ProgramVO> listProg(int num) throws Exception;
	
	//문자형 Program 리스트 가져오기
	public List<ProgramVO> listAjaxProg(String compname) throws Exception;
	

}
