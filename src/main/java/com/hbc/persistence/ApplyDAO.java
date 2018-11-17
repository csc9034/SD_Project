package com.hbc.persistence;

import java.util.List;


import com.hbc.domain.ApplyVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.ApplyDTO;

/**
 * 과목 테이블의 기본 CRUD를 정의한 인터페이스
 * 
 * @author CHO
 *
 */
public interface ApplyDAO {
	
	/**
	 * 수강 테이블에 데이터를 등록하는 메소드
	 * 
	 * @param vo : 등록 할 ApplyVO 객체
	 * @throws Exception
	 */
	public void create(ApplyVO vo) throws Exception;
	
	/**
	 * 수강 테이블의 전체 조회하는 메소드
	 * 
	 * @return : ApplyVO 리스트
	 * @throws Exception
	 */
	public List<ApplyVO> listAll() throws Exception;
	
	/**
	 * 수강 테이블에 저장 된 데이터를 수정하는 메소드
	 * 
	 * @param vo : 수정할 ApplyVO 객체
	 * @throws Exception
	 */
	public void update(ApplyVO vo) throws Exception;

	/**
	 * 수강 테이블의 저장 된 데이터를 삭제하는 메소드
	 * 
	 * @param appnum : 삭제 할 수강번호
	 * @throws Exception
	 */
	public void delete(int appnum) throws Exception;
	
	/**
	 * 특정 수강 정보를 조회하는 메소드
	 * 
	 * @param appnum : 조회 할 수강 번호
	 * @return       : 조회 된 ApplyVO 객체
	 * @throws Exception
	 */
	public ApplyVO read(int appnum) throws Exception;
	
	/**
	 * 특정 수강 번호의 특정 기관에 해당하는 과목 정보를 조회하는 메소드
	 * 
	 * @param appnum : 조회할 수강 번호
	 * @return       : 조회 된 ApplyDTO 객체
	 * @throws Exception
	 */
	public ApplyDTO readDTO(int appnum) throws Exception;
	
	/**
	 * 특정 기관명을 조회하여 해당 과목의 정보를 조회하는 메소드
	 * 
	 * @param compname : 조회 할 기관명
	 * @return		   : 조회 된 과목 CourseVO 객체
	 * @throws Exception
	 */
	public List<CourseVO> listCour(String compname) throws Exception;
	
	/**
	 * 기관의 번호와 이름을 조회하는 클래스
	 * 
	 * @return : 조회 된 CompanyVO 리스트
	 * @throws Exception
	 */
	public List<CompanyVO> listComp() throws Exception;

	/**
	 * 수학의 시선을 제외한 회사번호, 회사이름 조회하는 클래스
	 * @return
	 * @throws Exception
	 */
	
	public List<CompanyVO> appCompList() throws Exception;
	
	
	/**********************************
	 * 이하. 페이징을 하면서 리스트를 조회하는 메소드 *
	***********************************/
	
	public int countPaging(Criteria cri) throws Exception;

	public List<ApplyVO> listSearch(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;
	
	/**
	 * 사용자 메뉴 수강신청 조회하는 메소드
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<ApplyVO> userListSearch(AppSearchCriteria cri) throws Exception;
	

	public int userListSearchCount(AppSearchCriteria cri) throws Exception;
	


}
