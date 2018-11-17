package com.hbc.service;

import java.util.List;

import com.hbc.domain.Criteria;
import com.hbc.domain.NewsVO;
import com.hbc.domain.SearchCriteria;

public interface NewsService {

	public void regist(NewsVO news) throws Exception;
	
	public NewsVO read(int newsNum) throws Exception;
	
	public void modify(NewsVO news) throws Exception;
	
	public void remove(int newsNum) throws Exception;
	
	public List<NewsVO> listAll() throws Exception;

	public void updateViewCnt(int newsNum) throws Exception;
	
	public List<NewsVO> listCriteria(Criteria cri)throws Exception;
	
	public int listCountCriteria(Criteria cri)throws Exception;
	
	public List<NewsVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
	public String getAttach(Integer newsNum)throws Exception;
	
	public void deleteFile(NewsVO news) throws Exception;
	
	/*public List<String> sideList() throws Exception;*/
}
