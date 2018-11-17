package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.MainLinkVO;
import com.hbc.persistence.MainLinkDAO;

@Service
public class MainLinkServiceImpl implements MainLinkService {
	@Inject
	private MainLinkDAO dao;

	@Override
	public void create(MainLinkVO vo) throws Exception {

		String link = vo.getLinkName();
		
		// 링크 주소 17자리 잘라서 저장
		vo.setLinkName(link.substring(link.length() - 11));

		dao.create(vo);
	}

	@Override
	public void modify(MainLinkVO vo) throws Exception {
		
		String link = vo.getLinkName();
		
		// 링크 주소 17자리 잘라서 저장
		vo.setLinkName(link.substring(link.length() - 11));
		dao.modify(vo);
	}

	@Override
	public void remove(Integer compNum) throws Exception {
		dao.remove(compNum);
	}

	@Override
	public List<MainLinkVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public MainLinkVO read(Integer num) throws Exception {
		return dao.read(num);
	}

	@Override
	public List<MainLinkVO> listComp() throws Exception {
		// TODO Auto-generated method stub
		return dao.listComp();
	}

}
