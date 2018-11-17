package com.hbc.service;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ReviewVO;
import com.hbc.domain.SearchCriteria;
/**
 * ReviewService
 * @author 이동희
 *
 */
public interface ReviewService {
	/**
	 * 게시물 등록
	 * @param vo
	 * @throws Exception
	 */
	public void regist(ReviewVO vo) throws Exception;
	/**
	 * 게시물 수정
	 * @param vo
	 * @throws Exception
	 */
	public void modify(ReviewVO vo) throws Exception;
	/**
	 * 게시물 삭제
	 * @param reviewNum
	 * @throws Exception
	 */
	public void remove(int reviewNum) throws Exception;
	/**
	 * 게시물 1개 조회
	 * @param reviewNum
	 * @return
	 * @throws Exception
	 */
	public ReviewVO read(int reviewNum) throws Exception;
	/**
	 * 게시물 상세 조회
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<ReviewVO> listSearch(SearchCriteria cri) throws Exception;
	/**
	 * 게시물 총 갯수
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int listCountCriteria(Criteria cri) throws Exception;
	/**
	 * 뷰 카운트 증가
	 * @throws Exception
	 */
	public void viewCount(int reviewNum) throws Exception;
	
	/**
	 * 조회순 정렬
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<ReviewVO> descViewCnt(SearchCriteria cri) throws Exception;
	
	/**
	 * 날짜순 정렬
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<ReviewVO> descRegdateView(SearchCriteria cri) throws Exception;
	
	/**
	 * 검색 후 게시물 수
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<CourseVO> searchCourseList(int courNum) throws Exception;
	
	public List<CourseVO> ajaxSearchCourseList(String courNum) throws Exception;
	
	public List<CompanyVO> ajaxSearchList() throws Exception;
}
