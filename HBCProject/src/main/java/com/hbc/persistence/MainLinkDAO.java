package com.hbc.persistence;



import java.util.List;


import com.hbc.domain.MainLinkVO;
/*
 * 메인링크 등록/수정/삭제 메소드 -수학의 시선 메인화면에 쓰일 링크 저장소-
 */
public interface MainLinkDAO {
	
	public void create(MainLinkVO vo) throws Exception;
	
	public void modify(MainLinkVO vo) throws Exception;
	//수정화면으로 이동
	public MainLinkVO read(int num) throws Exception;
	//삭제 기능은 없으나 혹시몰라서...
	public void remove(Integer compNum) throws Exception;
	
	public List<MainLinkVO> listAll()throws Exception;
	
	public List<MainLinkVO> listComp() throws Exception;
	
	
}
