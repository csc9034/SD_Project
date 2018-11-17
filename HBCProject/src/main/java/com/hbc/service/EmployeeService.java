package com.hbc.service;

import java.util.List;

import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;

public interface EmployeeService {

	/**
	 * 직원 정보를 입력하기위한 메소드
	 * 매퍼의 insert 구문을 실행
	 * 
	 * @param vo - 직원 정보가 담긴 객체
	 * @throws Exception 
	 */
	public void register(EmployeeVO vo) throws Exception;
	
	/**
	 * 직원 정보를 수정하기위한 메소드
	 * 매퍼의 update 구문을 실행
	 * 
	 * @param vo - 직원 정보가 담긴 객체
	 * @throws Exception 
	 */
	public void modify(EmployeeVO vo) throws Exception;
	
	/**
	 * 직원 정보를 삭제하기위한 메소드
	 * 매퍼의 delete 구문을 실행
	 * 
	 * @param empnum - 삭제할 직원 번호가 담긴 변수
	 */
	public void delete(int empnum);
	
	/**
	 * 저장된 이미지를 DB에서 삭제하기 위한 메소드
	 * 
	 * @param fileName  - 삭제하기 위한 이미지의 파일명
	 */
	public void deleteAttach(String fileName);
	
	/**
	 * 직원 정보 하나를 가져오기 위한 메소드
	 * 
	 * 
	 * @param empnum - 정보를 가져올 직원 번호가 담긴 변수
	 */
	public EmployeeVO read(int empnum);

	/**
	 * 
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int listCountCriteria(Criteria cri) throws Exception;

	/**
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeVO> listSearchCriteria(AppSearchCriteria cri) throws Exception;

	/**
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int listSearchCount(AppSearchCriteria cri) throws Exception;
	
	/**
	 * 저장된 직원 이미지의 파일명을 가져오기 위한 메소드
	 * 
	 * @param empnum
	 * @return
	 */
	public String getAttach(int empnum);
	
	/**
	 * 기관의 기관번호, 기관이름을 목록으로 가져오는 메소드
	 * 
	 * @return 기관목록
	 */
	public List<CompanyDTO> readComps();
	
}
