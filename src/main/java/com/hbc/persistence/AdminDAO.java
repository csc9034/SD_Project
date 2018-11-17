package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.AdminVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.LoginDTO;

public interface AdminDAO {
	
	public AdminVO login(LoginDTO dto) throws Exception;		

	public AdminVO read(AdminVO admin) throws Exception;

	public int insert(AdminVO admin) throws Exception;
	
	public int update(AdminVO admin) throws Exception;
	
	public int delete(AdminVO admin) throws Exception;
	
	public List<AdminVO> listAll() throws Exception;
	
	public List<AdminVO> listSearch(AppSearchCriteria cri);
	
	public int ListSearchCount(AppSearchCriteria cri);
	
	public AdminVO validatePhone(AdminVO admin);
	
	public AdminVO validateEmail(AdminVO admin);
	
	public List<CompanyDTO> readComps();

	
}
