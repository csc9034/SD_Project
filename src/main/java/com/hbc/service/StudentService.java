package com.hbc.service;

import java.util.List;

import com.hbc.domain.AdminVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.StudentVO;
import com.hbc.dto.StudentLoginDTO;
import com.hbc.dto.StudentValidationDTO;

public interface StudentService {

	public void register(StudentVO vo) throws Exception;

	public StudentVO read(String stuid) throws Exception;

	public void modify(StudentVO vo) throws Exception;

	public void remove(String stuid) throws Exception;

	public List<CompanyVO> listComp() throws Exception;
	
	public StudentValidationDTO validate(String stuid) throws Exception;

	public List<StudentVO> listSearchCriteria(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;

	/**
	 * 학원생의 로그인을 위한 서비스 메소드
	 * 
	 * 
	 * @param dto - 로그인 정보가 담긴 dto
	 * @return 비밀번호를 제외한 학원생 객체를 리턴
	 * @throws Exception 
	 */
	public StudentVO login(StudentLoginDTO dto) throws Exception;
	
}
