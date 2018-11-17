package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.AppSearchCriteria;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.StudentVO;
import com.hbc.dto.StudentLoginDTO;


public interface StudentDAO {
	

	public void create(StudentVO vo) throws Exception;
	
	public void update(StudentVO vo) throws Exception;

	public void delete(String stuid) throws Exception;
	
	public StudentVO read(String stuid) throws Exception;
	
	public List<CompanyVO> listComp() throws Exception;
	
	/**********************************
	 * 이하. 학원생용 로그인을 컨트롤하기 위한 메소드 *
	***********************************/

	public StudentVO login(StudentLoginDTO dto) throws Exception;
	
	/**********************************
	 * 이하. 페이징을 하면서 리스트를 조회하는 메소드 *
	***********************************/
	
	public List<StudentVO> listSearch(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;
	
}
