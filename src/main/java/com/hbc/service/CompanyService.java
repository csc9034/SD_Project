package com.hbc.service;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;

/**
 * 기관 서비스를 처리하는 클래스
 * 
 * @author 정준호
 *
 */

public interface CompanyService {

	// 기관 등록
	public void register(CompanyVO vo) throws Exception;

	// 기관 한 행 조회
	public CompanyVO read(Integer compnum) throws Exception;

	// 기관 수정
	public void modify(CompanyVO vo) throws Exception;

	// 기관 삭제
	public void remove(Integer compnum) throws Exception;

	// 모든 기관 행 조회
	public List<CompanyVO> listView(int division) throws Exception;

	// 페이징된 행 개수 조회
	public int listCountCriteria(Criteria cri) throws Exception;

	// 검색된 행 조회
	public List<CompanyVO> listSearchCriteria(AppSearchCriteria cri) throws Exception;

	// 검색된 행 개수 조회
	public int listSearchCount(AppSearchCriteria cri) throws Exception;
	
	public List<CompanyVO> listComp() throws Exception;

	public void deleteAttach(String fileName) throws Exception;

	public String getAttach(int compnum) throws Exception;
}
