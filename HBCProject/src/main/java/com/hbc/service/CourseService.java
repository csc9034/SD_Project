package com.hbc.service;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CourseDTO;

public interface CourseService {

	public void register(CourseVO vo) throws Exception;

	public CourseVO read(Integer appnum) throws Exception;

	public CourseDTO readDTO(Integer appnum) throws Exception;

	public void modify(CourseVO vo) throws Exception;

	public String remove(Integer appnum) throws Exception;

	public List<CourseVO> listAll() throws Exception;

	public List<EmployeeVO> listEmp(String compname) throws Exception;

	public List<CompanyVO> listComp() throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<CourseVO> listSearchCriteria(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;

}
