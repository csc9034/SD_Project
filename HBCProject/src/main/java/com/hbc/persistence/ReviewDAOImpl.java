package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ReviewVO;
import com.hbc.domain.SearchCriteria;

/**
 * ReviewDAO 실현 클래스
 * @author 김승유
 */
@Repository
public class ReviewDAOImpl implements ReviewDAO {

	private static final String namespace = "com.hbc.mapper.reviewMapper";
	@Inject
	SqlSession sqlSession;
	
	/**
	 * 게시물 생성
	 */
	@Override
	public int create(ReviewVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
		
		return vo.getReviewNum();
	}
	
	/**
	 * 링크 생성
	 */
	@Override
	public void createLink(ReviewVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertLink", vo);
		
	}
	
	/**
	 * 게시물 수정
	 */
	@Override
	public void update(ReviewVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);
	}
	
	/**
	 * 링크 수정
	 */
	@Override
	public void updateLink(ReviewVO vo) throws Exception {
		sqlSession.update(namespace + ".updateLink", vo);
	}
	
	/**
	 * 게시물 삭제
	 */
	@Override
	public void delete(int reviewNum) throws Exception {
		System.out.println(reviewNum);
		System.out.println("삭제 실행");
		sqlSession.delete(namespace + ".delete", reviewNum);
	}
	
	/**
	 * 링크 삭제
	 */
	@Override
	public void deleteLink(int reviewNum) throws Exception {
		sqlSession.delete(namespace + ".deleteLink", reviewNum);
	}
	
	/**
	 * 게시물 조회
	 */
	@Override
	public ReviewVO read(int reviewNum) throws Exception {
		return sqlSession.selectOne(namespace + ".read", reviewNum);
	}
	
	/**
	 * 링크 조회
	 */
	@Override
	public String readLink(int reviewNum) throws Exception {
		return sqlSession.selectOne(namespace + ".readLink", reviewNum);
	}

	/**
	 * 게시물 전체조회
	 */
	@Override
	public List<ReviewVO> listSearch(SearchCriteria cri) throws Exception {
		
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	/**
	 * 게시물 총 개수
	 */
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging", cri);
	}

	/**
	 * 조회순 정렬
	 */
	@Override
	public List<ReviewVO> descViewCnt(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".descView");
	}

	/**
	 * 날짜순 정렬
	 */
	@Override
	public List<ReviewVO> descRegdateView(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".regdateView");
	}

	/**
	 * 조회수 증가
	 */
	@Override
	public void updateViewCnt(int reviewNum) throws Exception {
		sqlSession.update(namespace + ".updateViewCnt", reviewNum);		
	}

	/**
	 * 검색 후 게시물 수
	 */
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);
	}
	
	@Override
	public List<CourseVO> searchCourList(int compNum) throws Exception {
		return sqlSession.selectList(namespace + ".searchCourseList", compNum);
	}

	@Override
	public List<CourseVO> ajaxSearchCourList(String compNum) throws Exception {
		
		return sqlSession.selectList(namespace + ".searchCourseList", compNum);
	}

	@Override
	public List<CompanyVO> ajaxSearchList() throws Exception {
		return sqlSession.selectList(namespace + ".ajaxSearchList") ;
	}
}
