package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ReviewVO;
import com.hbc.domain.SearchCriteria;
/**
 * ReviewDAO 인터페이스
 * @author 이동희
 *
 */
public interface ReviewDAO {
	/**
	 * 게시물 생성
	 * @param vo
	 * @throws Exception
	 */
	public int create(ReviewVO vo) throws Exception;
	
	/**
	 * 게시물 생성
	 * @param vo
	 * @throws Exception
	 */
	public void createLink(ReviewVO vo) throws Exception;
	/**
	 * 게시물 수정
	 * @param vo
	 * @throws Exception
	 */
	public void update(ReviewVO vo) throws Exception;
	
	
	/**
	 * 게시물 링크 수정
	 * @param vo
	 * @throws Exception
	 */
	public void updateLink(ReviewVO vo) throws Exception;
	
	
	/**
	 * 게시물 삭제
	 * @param reviewNum
	 * @throws Exception
	 */
	public void delete(int reviewNum) throws Exception;
	
	/**
	 * 게시물 링크 삭제
	 * @param reviewNum
	 * @throws Exception
	 */
	public void deleteLink(int reviewNum) throws Exception;
	
	
	/**
	 * 게시물 1개 조회
	 * @param reviewNum
	 * @return
	 * @throws Exception
	 */
	public ReviewVO read(int reviewNum) throws Exception;
	
	
	/**
	 * 게시물 1개 조회
	 * @param reviewNum
	 * @return
	 * @throws Exception
	 */
	public String readLink(int reviewNum) throws Exception;
	
	
	/**
	 * 게시물 전체 조회
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
	public int countPaging(Criteria cri) throws Exception;
	/**
	 * ViewCnt 증가
	 * @throws Exception
	 */
	public void updateViewCnt(int reviewNum) throws Exception;
	/**
	 * 조회순 정렬
	 * @return
	 * @throws Exception
	 */
	public List<ReviewVO> descViewCnt(SearchCriteria cri) throws Exception;
	/**
	 * 날짜순 정렬
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
	
	/**
	 * 강좌리스트 조회
	 * @param compNum
	 * @return
	 * @throws Exception
	 */
	public List<CourseVO> searchCourList(int compNum) throws Exception;
	
	/**
	 * ajax용 강좌리스트 조회
	 * @param compNum
	 * @return
	 * @throws Exception
	 */
	public List<CourseVO> ajaxSearchCourList(String compNum) throws Exception;
	
	/**
	 * 기관리스트 조회
	 * @return
	 * @throws Exception
	 */
	public List<CompanyVO> ajaxSearchList () throws Exception;
}
