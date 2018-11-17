package com.hbc.persistence;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.VideoBoardVO;
@Repository
public class VideoBoardDAOImpl implements VideoBoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.hbc.mapper.VideoBoardMapper";
	
	@Override
	public void create(VideoBoardVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public void modify(VideoBoardVO board) throws Exception {
		session.update(namespace + ".update", board); 
		
	}

	@Override
	public void remove(Integer num) throws Exception {
		session.delete(namespace + ".delete", num);
	}
	
	
	@Override
	public VideoBoardVO read(int bno) throws Exception {
		
		return session.selectOne(namespace + ".read",bno);
		
	}
	
	@Override
	public void updateViewCnt(int bno) throws Exception {
		session.update(namespace + ".updateViewCnt",bno);
	}

	@Override
	public List<VideoBoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 5;
		return session.selectList(namespace + ".listPage", page);
	}
	

	@Override
	public List<VideoBoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<VideoBoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch",cri);	
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	
	}

	@Override
	public List<CompanyVO> selectComp() throws Exception {
		return session.selectList(namespace + ".companyList");
	}

	@Override
	public List<VideoBoardVO> listSearchUser(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".listSearchUser",cri);
	}

	@Override
	public int listSearchCountUser(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCountUser");
	}



}
