package com.hbc.service;

import java.util.List;

import com.hbc.domain.ImgBoardVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.SearchCriteria;

public interface ImgBoardService {
	public void regist(ImgBoardVO board) throws Exception;

	public ImgBoardVO read(int imgnum) throws Exception;
	
	public ImgBoardVO userRead(int imgnum) throws Exception;
	
	public void modify(ImgBoardVO board) throws Exception;

	public void remove(int imgnum) throws Exception;

	public List<ImgBoardVO> listAll() throws Exception;

	public List<ImgBoardVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<ImgBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 게시글에 연동된 모든 이미지 리스트 가져오기(수정페이지에서 사용)
	public List<ImgFileVO> getAttach(Integer imgnum) throws Exception;
	
	public List<ImgFileVO> getMainAttach(Integer imgnum) throws Exception;
	
	
	// 사용자 게시글에 연동된 모든 이미지 리스트 가져오기(detail페이지에서 사용)
	public List<ImgFileVO> getUAttach(Integer imgnum) throws Exception;
	
	public List<ImgFileVO> getUMainAttach(Integer imgnum) throws Exception;
	
	public List<ImgBoardVO> getRelatAtt(Integer imgnum) throws Exception;
	
	//추가 이미지 삭제
	public void deleteAttach(Integer imgnum) throws Exception;
	
	//메인 이미지 삭제
	public void deleteMainAttach(Integer imgnum) throws Exception;
	
	
//	//추가 이미지 삭제
//	public void deleteAttach(Integer imgnum) throws Exception;
//	
//	//메인 이미지 삭제
//	public void deleteMainAttach(Integer imgnum) throws Exception;
//	
//	//추가 이미지 새롭게 추가
//	public void replaceAttach(String name, Integer imgnum) throws Exception;
//	
//	//메인 이미지 새롭게 추가
//	public void replaceMainAttach(String name, Integer imgnum) throws Exception;
	
	

}
