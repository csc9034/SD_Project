package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.ApplyVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.ApplyDTO;
import com.hbc.persistence.ApplyDAO;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Inject
	private ApplyDAO dao;

	@Override
	public void register(ApplyVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public ApplyVO read(Integer appnum) throws Exception {
		return dao.read(appnum);
	}

	@Override
	public void modify(ApplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer appnum) throws Exception {
		dao.delete(appnum);
	}

	@Override
	public List<ApplyVO> listAll() throws Exception {
		return dao.listAll();
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
	public List<ApplyVO> listSearchCriteria(AppSearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<CourseVO> listCour(String compname) throws Exception {
		return dao.listCour(compname);
	}

	@Override
	public ApplyDTO readDTO(Integer appnum) throws Exception {
		return dao.readDTO(appnum);
	}

	@Override
	public List<CompanyVO> appCompList() throws Exception {
		return dao.appCompList();
	}

	@Override
	public List<ApplyVO> userListSearchCriteria(AppSearchCriteria cri) throws Exception {
		return dao.userListSearch(cri);
	}

	@Override
	public int userListSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.userListSearchCount(cri);

	}
}
