package com.hbc.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.MainLinkVO;


@Repository
public class MainLinkDAOImpl implements MainLinkDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.hbc.mapper.MainLinkMapper";
	
	
	@Override
	public void create(MainLinkVO vo) throws Exception {
		session.insert(namespace + ".create",vo);
	}

	@Override
	public void modify(MainLinkVO vo) throws Exception {
		session.update(namespace + ".update",vo);
	}

	@Override
	public void remove(Integer compNum) throws Exception {
		session.delete(namespace + ".delete", compNum);
	}
	
	//등록화면 셀렉박스 보여주는 곳
	@Override
	public List<MainLinkVO> listAll() throws Exception {
		return session.selectList(namespace + ".mainLinkList");
	}
	//수정화면 셀렉박스 보여주는 곳
	@Override
	public List<MainLinkVO> listComp() throws Exception {
		return session.selectList(namespace + ".mainLinkListInsert");
	}
	
	@Override
	public MainLinkVO read(int num) throws Exception {
		return session.selectOne(namespace + ".detail", num);
	}

}
