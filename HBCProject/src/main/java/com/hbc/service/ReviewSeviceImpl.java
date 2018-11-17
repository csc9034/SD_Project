package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ReviewVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.ReviewDAO;

/**
 * ReviewService 실현 클래스
 * @author 김승유
 *
 */
@Service
public class ReviewSeviceImpl implements ReviewService {
	
	@Inject
	ReviewDAO dao;

	@Override
	public void regist(ReviewVO vo) throws Exception {
		
		//1. 게시글 등록
		int reviewNum = dao.create(vo);
		
		//2. 링크 등록
		vo.setReviewNum(reviewNum);
		dao.createLink(vo);
		
	}

	@Override
	public void modify(ReviewVO vo) throws Exception {
		//1. 게시글 업데이트
		dao.update(vo);
		//2. 링크 업데이트
		dao.updateLink(vo);
	}

	@Override
	public void remove(int reviewNum) throws Exception {
		
		//1.링크 삭제
		dao.deleteLink(reviewNum);
		
		//2.게시글 삭제
		dao.delete(reviewNum);
	}

	@Override
	public ReviewVO read(int reviewNum) throws Exception {
		
		//관리자에서는 조회수가 오르면 안됨
		//dao.updateViewCnt(reviewNum);
		ReviewVO vo = dao.read(reviewNum);
		vo.setUri(dao.readLink(reviewNum));
		
		return vo;
	}

	@Override
	public List<ReviewVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public void viewCount(int reviewNum) throws Exception {
		dao.updateViewCnt(reviewNum);
	}

	@Override
	public List<ReviewVO> descViewCnt(SearchCriteria cri) throws Exception {
		return dao.descViewCnt(cri);
	}

	@Override
	public List<ReviewVO> descRegdateView(SearchCriteria cri) throws Exception {
		return dao.descRegdateView(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<CourseVO> searchCourseList(int compNum) throws Exception {
		return dao.searchCourList(compNum);
	}

	@Override
	public List<CourseVO> ajaxSearchCourseList(String compNum) throws Exception {
		
		return dao.ajaxSearchCourList(compNum);
	}
	
	@Override
	public List<CompanyVO> ajaxSearchList() throws Exception {
		return dao.ajaxSearchList();
	}
}
