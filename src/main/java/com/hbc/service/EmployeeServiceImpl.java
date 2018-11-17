package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hbc.controller.AdminController;
import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;
import com.hbc.persistence.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public void register(EmployeeVO vo) throws Exception {

		String[] files = vo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				
				logger.info(fileName);
				vo.setFilenum(dao.addAttach(fileName));
			}
		}
		dao.register(vo);
	}

	@Override
	public void modify(EmployeeVO vo) throws Exception {
		String[] files = vo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				dao.addAttach(fileName);
				vo.setFilenum(dao.addAttach(fileName));
			}
		}
		
		dao.modify(vo);

	}

	@Override
	public void delete(int empnum) {
		dao.delete(empnum);

	}
	
	@Override
	public void deleteAttach(String fileName) {
		dao.deleteAttach(fileName);
	}
	
	@Override
	public EmployeeVO read(int empnum) {
		return dao.read(empnum);
	}
	
	@Override
	public String getAttach(int empnum) {
		return dao.getAttach(empnum);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);

	}

	@Override
	public List<EmployeeVO> listSearchCriteria(AppSearchCriteria cri) throws Exception {
		return dao.listSearch(cri);

	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);

	}

	@Override
	public List<CompanyDTO> readComps() {
		return dao.readComps();
	}






}
