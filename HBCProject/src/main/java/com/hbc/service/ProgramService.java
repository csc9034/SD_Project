package com.hbc.service;

import java.util.List;

import com.hbc.domain.ProgSearchCriteria;
import com.hbc.domain.ProgramVO;



public interface ProgramService {
	// ��
	public void regist(ProgramVO vo) throws Exception; 
	// �� 
	public void modify(ProgramVO vo) throws Exception;
	// ��
	public void remove(Integer prodcod) throws Exception; 
	// ��ȸ
	public ProgramVO read(Integer prodcod) throws Exception;
	// ���
	public List<ProgramVO> searchListCriteria(ProgSearchCriteria cri) throws Exception;
	// ��ϼ�
	public int listSearchCount(ProgSearchCriteria cri) throws Exception;
	
	public List<String> centerList() throws Exception;
	
	/*사용자 화면*/
	   
    public List<String> sideList() throws Exception;
    public List<String> programList(ProgramVO vo) throws Exception;
    public List<String> programImgs() throws Exception;
    public List<String> programImg(Integer intronum) throws Exception;
	
	public List<ProgramVO> listProg(int num) throws Exception;
	public List<ProgramVO> listAjaxProg(String compname) throws Exception;


	/**
	 * 이미지 게시판 
	 * 동적 select 박스 수정을 위한 메소드
	 */
	
//	public List<ProgramVO> ajaxSearchCourseList(String )
}
