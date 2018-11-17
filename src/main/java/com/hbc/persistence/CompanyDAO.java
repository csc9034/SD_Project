package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;

/**
 * 기관 VO 인터페이스
 * @author 정준호
 *
 */
public interface CompanyDAO {
	
	// 기관 등록
	public void create(CompanyVO vo) throws Exception;

	// 기관 한 행 조회
	public CompanyVO read(int compnum) throws Exception;

	// 기관 수정
	public void update(CompanyVO vo) throws Exception;

	// 기관 삭제
	public void delete(int compnum) throws Exception;

	// 사용자화면을 위한 기관을 조회
	public List<CompanyVO> listView(int division) throws Exception;

	// 기관 검색후 리스트로 
	public List<CompanyVO> listSearch(AppSearchCriteria cri) throws Exception;

	// 검색후 페이징처리된 행 갯수 카운트
	public int listSearchCount(AppSearchCriteria cri) throws Exception;

	// 페이징처리한 행 갯수 카운트
	public int countPaging(Criteria cri) throws Exception;
	
	public List<CompanyVO> listComp() throws Exception;

	public void addAttach(String fileName) throws Exception;

	public String getAttach(int compnum) throws Exception;

	public void deleteAttach(int filenum) throws Exception;

	public void deleteAttach(String filename) throws Exception;

	public int getCurrFileSeq() throws Exception;
}
