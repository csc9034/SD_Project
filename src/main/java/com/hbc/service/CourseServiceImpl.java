package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CourseDTO;
import com.hbc.persistence.CourseDAO;

@Service
public class CourseServiceImpl implements CourseService {

	@Inject
	private CourseDAO dao;

	@Override
	public void register(CourseVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<CourseVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<EmployeeVO> listEmp(String compname) throws Exception {
		return dao.listEmp(compname);
	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return dao.listComp();
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);

	}

	@Override
	public List<CourseVO> listSearchCriteria(AppSearchCriteria cri) throws Exception {
		return dao.listSearch(cri);

	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);

	}

	@Override
	public CourseVO read(Integer cournum) throws Exception {
		return dao.read(cournum);
	}

	@Override
	public void modify(CourseVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public String remove(Integer compname) {
		String msg;
		
		try {
			
			dao.delete(compname);
			msg = "success";
		
		} catch (Exception e) {
			
			msg = "fail";
			
			// e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public CourseDTO readDTO(Integer cournum) throws Exception {
		return dao.readDTO(cournum);
	}

}
