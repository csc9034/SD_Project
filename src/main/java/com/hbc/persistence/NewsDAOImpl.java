package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.Criteria;
import com.hbc.domain.NewsVO;
import com.hbc.domain.SearchCriteria;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mapper.newsMapper";

	@Override
	public int create(NewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

		return vo.getNewsNum();
	}

	@Override
	public NewsVO read(int newsNum) throws Exception {
		return session.selectOne(namespace + ".read", newsNum);
	}

	@Override
	public void update(NewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int newsNum) throws Exception {
		session.delete(namespace + ".delete", newsNum);
	}

	@Override
	public List<NewsVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public void updateViewCnt(int newsNum) throws Exception {
		session.update(namespace + ".updateViewCnt", newsNum);

	}

	@Override
	public List<NewsVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<NewsVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<NewsVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void addAttach(NewsVO vo) throws Exception {

		session.insert(namespace + ".addAttach", vo);
	}

	@Override
	public String getAttach(Integer newsNum) throws Exception {
		return session.selectOne(namespace + ".getAttach", newsNum);
	}

	@Override
	public void deleteAttach(Integer newsNum) throws Exception {
		session.delete(namespace + ".deleteAttach", newsNum);
		
	}
	/*@Override
	public List<String> sideList() throws Exception {
		return session.selectList(namespace + ".sideList");
	}*/

	@Override
	public void deleteFile(NewsVO vo) throws Exception {
		session.delete(namespace + ".deleteFile", vo);
		
	}
	
}
