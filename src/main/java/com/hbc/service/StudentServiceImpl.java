package com.hbc.service;

import static com.hbc.util.DataFormatUtil.phoneModelToView;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.AppSearchCriteria;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.StudentVO;
import com.hbc.dto.AdminValidationDTO;
import com.hbc.dto.StudentLoginDTO;
import com.hbc.dto.StudentValidationDTO;
import com.hbc.persistence.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Inject
	private StudentDAO dao;
	
	@Override
	public void register(StudentVO vo) throws Exception {
		
		vo.setStuphone(vo.getStuphone().replace("-", ""));
		dao.create(vo);
	}

	@Override
	public StudentVO read(String stuid) throws Exception {
		
		StudentVO vo = dao.read(stuid);
		
		vo.setStuphone(phoneModelToView(vo.getStuphone()));
		
		return vo;
	}

	@Override
	public void modify(StudentVO vo) throws Exception {
		vo.setStuphone(vo.getStuphone().replace("-", ""));
		dao.update(vo);
	}

	@Override
	public void remove(String stuid) throws Exception {
		dao.delete(stuid);
	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return dao.listComp();
	}


	@Override
	public List<StudentVO> listSearchCriteria(AppSearchCriteria cri) throws Exception {
		
		List<StudentVO> students = dao.listSearch(cri);
		
		for (StudentVO vo : students) {
			vo.setStuphone(phoneModelToView(vo.getStuphone()));
		}
		
		return students;
	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public StudentValidationDTO validate(String stuid) throws Exception {
		StudentValidationDTO dto = new StudentValidationDTO((dao.read(stuid) != null) ? "idFailed" : "idOk");
				return dto;
	}
	
	@Override
	public StudentVO login(StudentLoginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
