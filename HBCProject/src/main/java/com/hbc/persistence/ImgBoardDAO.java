package com.hbc.persistence;

import java.util.List;

import com.hbc.domain.ImgBoardVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.SearchCriteria;

public interface ImgBoardDAO {

	public int create(ImgBoardVO vo) throws Exception;

	public ImgBoardVO read(Integer imgnum) throws Exception;

	public void update(ImgBoardVO vo) throws Exception;

	public void delete(Integer imgnum) throws Exception;

	public List<ImgBoardVO> listAll() throws Exception;

	public List<ImgBoardVO> listPage(int page) throws Exception;

	public List<ImgBoardVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<ImgBoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	// public void updateReplyCnt(Integer bno, int amount)throws Exception;

	public void updateViewCnt(Integer imgnum) throws Exception;

	// public void addAttach(String name)throws Exception;List<ImgVO> imgVOList

	// 게시글에 연동된 모든 이미지 리스트 저장하기
	public void addAttach(ImgFileVO imgVO) throws Exception;

	// 게시글에 연동된 모든 이미지 리스트 가져오기(수정페이지에서 사용)
	public List<ImgFileVO> getAttach(Integer imgnum) throws Exception;
	
	public List<ImgFileVO> getMainAttach(Integer imgnum) throws Exception;
	
	// 사용자 게시글에 연동된 모든 이미지 리스트 가져오기(detail페이지에서 사용)
	public List<ImgFileVO> getUAttach(Integer imgnum) throws Exception;
	
	public List<ImgFileVO> getUMainAttach(Integer imgnum) throws Exception;
	
	// detail에서 관련 게시물 사진이랑 링크 뿌리는 거
	public List<ImgBoardVO> getRelatAtt(Integer imgnum) throws Exception;
	
	
	//추가 이미지 삭제
	public void deleteAttach(Integer imgnum) throws Exception;
	
	//메인 이미지 삭제
	public void deleteMainAttach(Integer imgnum) throws Exception;
	
	//추가 이미지 새롭게 추가
	public void replaceAttach(String name, Integer imgnum) throws Exception;
	
	//메인 이미지 새롭게 추가
	public void replaceMainAttach(String name, Integer imgnum) throws Exception;

}
