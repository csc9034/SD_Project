package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.GalleryFileVO;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.SearchCriteria;

public interface ImgGalleryDAO {
	
	public int insert(GalleryBoardVO vo) throws Exception;

	public GalleryBoardVO read(Integer imgnum) throws Exception;

	public void update(GalleryBoardVO vo) throws Exception;

	public void delete(Integer imgnum) throws Exception;

	public List<GalleryBoardVO> listPage(int page) throws Exception;

	public List<GalleryBoardVO> listCriteria(Criteria cri) throws Exception;

	public List<GalleryBoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void updateViewCnt(Integer imgnum) throws Exception;

	public void addAttach(GalleryFileVO vo) throws Exception;

	public List<String> getAttach(int galnum) throws Exception;

	public void deleteAttach(int galnum) throws Exception;

	public void deleteAttach(String filename) throws Exception;

	public int getCurrFileSeq() throws Exception;
	
	public List<CompanyVO> listComp() throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public List<GalleryBoardVO> adminListSearch(SearchCriteria cri) throws Exception;
	
}
