package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.ProgSearchCriteria;
import com.hbc.domain.ProgramVO;
import com.hbc.persistence.ProgramDAO;
@Service
public class ProgramServiceImpl implements ProgramService {
	@Inject
	ProgramDAO dao;
	
	@Override
	public void regist(ProgramVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public void modify(ProgramVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void remove(Integer intronum) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(intronum);
	}

	@Override
	public ProgramVO read(Integer intronum) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(intronum);
	}

	@Override
	public List<ProgramVO> searchListCriteria(ProgSearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchList(cri);
	}

	@Override
	public int listSearchCount(ProgSearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

	@Override
	public List<String> centerList() throws Exception {
		// TODO Auto-generated method stub
		return dao.centerList();
	}

	// 사용자 화면
	
	@Override
	public List<String> sideList() throws Exception {
		// TODO Auto-generated method stub
		return dao.sideList();
	}

	@Override
	public List<String> programList(ProgramVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.programList(vo);
	}

	@Override
	public List<String> programImg(Integer intronum) throws Exception {
		// TODO Auto-generated method stub
		return dao.programImg(intronum);
	}

	@Override
	public List<String> programImgs() throws Exception {
		// TODO Auto-generated method stub
		return dao.programImgs();
	}
	
	@Override
	public List<ProgramVO> listProg(int num) throws Exception {
		return dao.listProg(num);
	}
	
	@Override
	public List<ProgramVO> listAjaxProg(String compname) throws Exception {
		return dao.listAjaxProg(compname);
	}

}
