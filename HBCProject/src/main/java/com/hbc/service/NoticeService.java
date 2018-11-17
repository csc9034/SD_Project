package com.hbc.service;

import java.util.List;

import com.hbc.domain.NoticeVO;
import com.hbc.domain.SearchCriteria;
/**
 * 
 * @author 남정규
 */
public interface NoticeService {
	public void regist(NoticeVO vo) throws Exception;

	public void userRead(Integer noNum) throws Exception;
	
	public NoticeVO read(Integer noNum) throws Exception;

	public void modify(NoticeVO vo) throws Exception;

	public void remove(Integer noNum) throws Exception;

	public List<NoticeVO> searchlist(SearchCriteria cri) throws Exception;
	
	public List<NoticeVO> topList(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<String> getAttach(Integer noNum) throws Exception;
	
	public String getUri(String fullName) throws Exception;
	
	public void removeAttach(String fullName) throws Exception;
	
	public void removeRink(String fullName) throws Exception;
}
