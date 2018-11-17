package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CourseDTO;

/**
 * 과목 테이블의 기본 CRUD를 정의한 인터페이스
 * 
 * @author CHO
 *
 */
public interface CourseDAO {
	
	/**
	 * 과목 테이블에 데이터를 등록하는 메소드
	 * @param vo  : 등록할 CourseVO 객체
	 * @throws Exception
	 */
	public void create(CourseVO vo) throws Exception;
	
	/**
	 * 과목 테이블을 전체 조회하는 메소드
	 * 
	 * @return  : 조회된 CourseVO 리스트
	 * @throws Exception
	 */
	public List<CourseVO> listAll() throws Exception;
	
	/**
	 * 과목 테이블의 데이터를 수정하는 메소드
	 * @param vo	: 수정할 CourseVO 객체
	 * @throws Exception
	 */
	public void update(CourseVO vo) throws Exception;
	
	/**
	 * 과목 테이블의 데이터를 삭제하는 메소드
	 * 
	 * @param cournum  : 삭제할 cournum
	 * @throws Exception
	 */
	public void delete(int cournum) throws Exception;
	
	/**
	 * 특정 과목을 조회하는 메소드
	 * 
	 * @param cournum : 조회할 특정 cournum
	 * @return	      : 조회 된 CourseVO 객체
	 * @throws Exception
	 */
	public CourseVO read(int cournum) throws Exception;
	
	/**
	 * 특정 과목을 조회하여 해당 과목의 담당하는 기관과 직원을 조회하기 위한 메소드
	 * 
	 * @param cournum : 조회할 cournum
	 * @return        : 조회된 CourseVO 객체 
	 * @throws Exception
	 */
	public CourseDTO readDTO(int cournum) throws Exception;
	
	/**
	 * 특정 기관에 소속된 직원 테이블의 번호와 이름을 조회하는 메소드 
	 * @param compname : 조회할 기관명
	 * @return		   : 조회된 EmpVO 객체
	 * @throws Exception
	 */
	public List<EmployeeVO> listEmp(String compname) throws Exception;
	
	/**
	 * 기관의 번호와 이름을 조회하는 클래스
	 * 
	 * @return : 조회 된 CompanyVO 객체
	 * @throws Exception
	 */
	public List<CompanyVO> listComp() throws Exception;

	/**********************************
	 * 이하. 페이징을 하면서 리스트를 조회하는 메소드 *
	***********************************/
	public int countPaging(Criteria cri) throws Exception;

	public List<CourseVO> listSearch(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;

}
