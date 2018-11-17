package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.Criteria;
import com.hbc.domain.NewsVO;
import com.hbc.domain.SearchCriteria;

public interface NewsDAO {
	// 등록
	public int create(NewsVO vo)throws Exception;
	// 조회
	public NewsVO read(int newsNum)throws Exception;
	// 수정
	public void update(NewsVO vo)throws Exception;
	// 삭제
	public void delete(int newsNum)throws Exception;
	// 전체조회
	public List<NewsVO> listAll()throws Exception;
	// 조회수더하기
	public void updateViewCnt(int newsNum) throws Exception;
	// 페이징목록
	public List<NewsVO> listPage(int page) throws Exception;
	
	public List<NewsVO> listCriteria(Criteria cri) throws Exception;
	
	public List<NewsVO> listSearch(SearchCriteria cri)throws Exception;
	// 게시물 총개수
	public int countPaging(Criteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
	// 파일 첨부
	public void addAttach(NewsVO vo)throws Exception;
	// 파일가져오기
	public String getAttach(Integer newsNum)throws Exception;
	// 파일삭제
	public void deleteAttach(Integer newsNum)throws Exception;
	
	public void deleteFile(NewsVO vo)throws Exception;
	
/*	public List<String> sideList() throws Exception;
	*/
	

}
