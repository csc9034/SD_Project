package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.VideoBoardVO;

public interface VideoBoardDAO {
	//게시판 등록
	public void create(VideoBoardVO vo) throws Exception;
	//게시판 수정
	public void modify(VideoBoardVO board) throws Exception;
	//글 삭제
	public void remove(Integer num) throws Exception;
	//상세보기
	public VideoBoardVO read(int bno) throws Exception;
	//조회수 카운트
	public void updateViewCnt(int bno) throws Exception;
	//쓰지 않음.
	public List<VideoBoardVO> listPage(int page)throws Exception;
	//리스트 목록수
	public List<VideoBoardVO> listCriteria(Criteria cri) throws Exception;
	//페이징 카운트
	public int  countPaging(Criteria cri) throws Exception;
	//목록
	public List<VideoBoardVO> listSearch(SearchCriteria cri) throws Exception;
	//검색 페이징
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<CompanyVO> selectComp()throws Exception; 
	
	public List<VideoBoardVO> listSearchUser(SearchCriteria cri) throws Exception;
	
	public int listSearchCountUser(SearchCriteria cri) throws Exception;
	
}
