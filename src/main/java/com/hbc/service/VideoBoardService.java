package com.hbc.service;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.VideoBoardVO;

public interface VideoBoardService {

	public void regist(VideoBoardVO board) throws Exception;

	public void modify(VideoBoardVO board) throws Exception;

	public void remove(Integer num) throws Exception;
	
	public VideoBoardVO read(Integer bno) throws Exception;

	public List<VideoBoardVO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<VideoBoardVO> searchListCriteria(SearchCriteria cri) throws Exception;
	
	public List<VideoBoardVO> listSearch(SearchCriteria cri) throws Exception;

	public VideoBoardVO adminRead(Integer bno) throws Exception;
	
	public List<CompanyVO> selectComp()throws Exception; 
	
	public List<VideoBoardVO> listSearchUser(SearchCriteria cri) throws Exception;
	
	public int listSearchCountUser(SearchCriteria cri) throws Exception;
}
