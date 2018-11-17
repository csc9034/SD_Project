package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.EmpFileDTO;

public interface EmployeeDAO {
	
	/**
	 * 직원 정보를 입력하기위한 메소드
	 * 매퍼의 insert 구문을 실행
	 * 
	 * @param vo - 직원 정보가 담긴 객체
	 */
	public void register(EmployeeVO vo);
	
	/**
	 * 직원 정보를 수정하기위한 메소드
	 * 매퍼의 update 구문을 실행
	 * 
	 * @param vo - 직원 정보가 담긴 객체
	 */
	public void modify(EmployeeVO vo);
	
	/**
	 * 직원 정보를 삭제하기위한 메소드
	 * 매퍼의 delete 구문을 실행
	 * 
	 * @param empnum - 삭제할 직원 번호가 담긴 변수
	 */
	public void delete(int empnum);
	
	/**
	 * 직원 이미지를 저장하기 위한 메소드
	 * 
	 * @param fileName - 이미지 파일 이름
	 * retrun
	 */
	public int addAttach(String fileName);
	
	/**
	 * 저장된 직원 이미지의 파일명을 가져오기 위한 메소드
	 * 
	 * @param empnum - 직원 번호
	 * @return  이미지가 있으면 그 이미지의 파일경로를 리턴하고, 
	 *            이미지가 없으면 null을 리턴
	 */
	public String getAttach(int empnum);
	
	/**
	 * 저장된 이미지를 DB에서 삭제하기 위한 메소드
	 * 
	 * @param filenum - 삭제하기 위한 이미지의 이미지 번호
	 */
	public void deleteAttach(int filenum);
	
	/**
	 * 저장된 이미지를 DB에서 삭제하기 위한 메소드
	 * 
	 * @param fileName  - 삭제하기 위한 이미지의 파일명
	 */
	public void deleteAttach(String fileName);
	
	/**
	 * 직원 이미지의 현재 시퀀스를 가져오기 위한 메소드
	 * 
	 * @return 현재 시퀀스
	 */
	public int getCurrFileSeq() throws Exception;
	
	/**
	 * 직원 정보 하나를 가져오기 위한 메소드
	 * 
	 * @param empnum - 직원 번호
	 * @return 직원정보 객체
	 */
	public EmployeeVO read(int empnum);

	/**
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int countPaging(Criteria cri) throws Exception;

	/**
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeVO> listSearch(AppSearchCriteria cri) throws Exception;

	/**
	 * 
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int listSearchCount(AppSearchCriteria cri) throws Exception;

	
	/**
	 * 기관의 기관번호, 기관이름을 목록으로 가져오는 메소드
	 * 
	 * @return 기관목록
	 */
	public List<CompanyDTO> readComps();
	
	
}
