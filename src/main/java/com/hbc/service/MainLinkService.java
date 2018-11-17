package com.hbc.service;

import java.util.List;

import com.hbc.domain.MainLinkVO;

public interface MainLinkService {
	
	public void create(MainLinkVO vo) throws Exception;
	
	public void modify(MainLinkVO vo) throws Exception;

	public void remove(Integer compNum) throws Exception;
	
	public List<MainLinkVO> listAll()throws Exception;
	
	public MainLinkVO read(Integer num) throws Exception;
	
	public List<MainLinkVO> listComp() throws Exception;
}
