package com.hbc.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.NoticeVO;
import com.hbc.domain.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mapper.NoticeMapper";

	@Override
	public void create(NoticeVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public NoticeVO read(Integer noNum) throws Exception {
		return session.selectOne(namespace + ".read", noNum);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer noNum) throws Exception {
		session.delete(namespace + ".delete", noNum);
	}

	@Override
	public void updateNoViewCnt(Integer noNum) throws Exception {
		session.update(namespace + ".updateNoViewCnt", noNum);
	}

	@Override
	public List<NoticeVO> searchlist(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public List<NoticeVO> topList(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".topList", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSerachCount", cri);
	}

	@Override
	public void addAttach(String fullName) throws Exception {
		System.out.println("DAO 파일명" + fullName);
		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer noNum) throws Exception {
		return session.selectList(namespace + ".getAttach", noNum);
	}

	@Override
	public void deleteAttach(Integer noNum) throws Exception {
		session.delete(namespace + ".deleteAttach", noNum);
	}
	
	@Override
	public void deleteOneAttach(String fullName) throws Exception {
		session.delete(namespace + ".deleteOneAttach", fullName);
	}

	@Override
	public void replaceAttach(String fullName, Integer noNum) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("noNum", noNum);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}

	@Override
	public void addLink(String uri, String fullName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("uri", uri);
		paramMap.put("fullName", fullName);
		session.insert(namespace + ".addLink", paramMap);
	}

	@Override
	public String getUri(String fullName) throws Exception {
		
		return session.selectOne(namespace + ".getLink", fullName);
	}

	/*@Override
	public void deleteLink(Integer noNum) throws Exception {
		session.delete(namespace + ".deleteLink", noNum);
	}*/
	
	@Override
	public void deleteLink(String fullName) throws Exception {
		session.delete(namespace + ".deleteLink", fullName);
	}

	@Override
	public void replaceLink(String uri, String fullName, Integer noNum) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("uri", uri);
		paramMap.put("fullName", fullName);
		paramMap.put("noNum", noNum);

		session.insert(namespace + ".replaceLink", paramMap);
	}

}
