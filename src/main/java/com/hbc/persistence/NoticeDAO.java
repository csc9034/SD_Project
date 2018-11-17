package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.NoticeVO;
import com.hbc.domain.SearchCriteria;

/**
 * 
 * @author 남정규
 */
public interface NoticeDAO {

	public void create(NoticeVO vo) throws Exception;

	public NoticeVO read(Integer noNum) throws Exception;

	public void update(NoticeVO vo) throws Exception;

	public void delete(Integer noNum) throws Exception;

	public void updateNoViewCnt(Integer noNum) throws Exception;

	public List<NoticeVO> searchlist(SearchCriteria cri) throws Exception;
	
	public List<NoticeVO> topList(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer noNum) throws Exception;
	
	public void deleteAttach(Integer noNum) throws Exception;
	
	public void deleteOneAttach(String fullName) throws Exception;
	
	public void replaceAttach(String fullName, Integer noNum) throws Exception; 
	
	public void addLink(String uri, String fullName) throws Exception;
	
	public String getUri(String fullName) throws Exception;
	
	/*public void deleteLink(Integer noNum) throws Exception;*/
	
	public void deleteLink(String fullName) throws Exception;
	
	public void replaceLink(String uri, String fullName, Integer noNum) throws Exception;
}
