package com.hbc.service;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.GalleryFileVO;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.SearchCriteria;

public interface ImgGalleryService {

	public void regist(GalleryBoardVO board) throws Exception;

	public GalleryBoardVO read(int imgnum) throws Exception;
	
	public GalleryBoardVO userRead(int imgnum) throws Exception;
	
	public void modify(GalleryBoardVO board) throws Exception;

	public void remove(int imgnum) throws Exception;

	public List<GalleryBoardVO> listCriteria(Criteria cri) throws Exception;

	public List<GalleryBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public List<GalleryBoardVO> adminListSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void deleteAttach(int galnum) throws Exception;

	public List<String> getAttach(int galnum) throws Exception;
	
	public List<CompanyVO> listComp() throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
}
