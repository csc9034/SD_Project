package com.hbc.service;

import java.util.List;

import com.hbc.domain.AdminVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.AdminValidationDTO;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.LoginDTO;

/**
 * 어드민 서비스를 담당하는 서비스클래스
 * 
 * @author 진재환
 *
 */
public interface AdminService {

	public AdminVO login(LoginDTO dto) throws Exception;

	public List<CompanyDTO> readComps();
	public AdminValidationDTO validate(AdminVO admin) throws Exception;
	public int listCount(AppSearchCriteria cri) throws Exception;
	public List<AdminVO> listSearch(AppSearchCriteria cri) throws Exception;
	public List<AdminVO> listAll() throws Exception;
	public int delete(AdminVO admin) throws Exception;
	public int update(AdminVO admin) throws Exception;
	public int insert(AdminVO admin) throws Exception;
	public AdminVO read(AdminVO admin) throws Exception;
	
}
