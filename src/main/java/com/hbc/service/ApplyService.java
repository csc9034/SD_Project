package com.hbc.service;

import java.util.List;

import com.hbc.domain.ApplyVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.ApplyDTO;

public interface ApplyService {

	public void register(ApplyVO vo) throws Exception;

	public ApplyVO read(Integer appnum) throws Exception;

	public void modify(ApplyVO vo) throws Exception;

	public void remove(Integer cournum) throws Exception;

	public List<ApplyVO> listAll() throws Exception;

	public List<CompanyVO> listComp() throws Exception;

	public List<CompanyVO> appCompList() throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<ApplyVO> listSearchCriteria(AppSearchCriteria cri) throws Exception;

	public List<ApplyVO> userListSearchCriteria(AppSearchCriteria cri) throws Exception;

	public int listSearchCount(AppSearchCriteria cri) throws Exception;

	public int userListSearchCount(AppSearchCriteria cri) throws Exception;

	public ApplyDTO readDTO(Integer appnum) throws Exception;

	public List<CourseVO> listCour(String compname) throws Exception;

}
