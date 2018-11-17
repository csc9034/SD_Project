package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.ProgSearchCriteria;
import com.hbc.domain.ProgramVO;
@Repository
public class ProgramDAOImpl implements ProgramDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.hbc.mapper.programMapper";
	
    @Override
	public void create(ProgramVO vo) throws Exception {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public ProgramVO read(Integer intronum) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", intronum);
	}

	@Override
	public void update(ProgramVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer intronum) throws Exception {
		session.delete(namespace + ".delete", intronum);
		
	}

	@Override
	public List<ProgramVO> searchList(ProgSearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".searchlist", cri);
	}

	@Override
	public int listSearchCount(ProgSearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public List<String> centerList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".centerList");
	}

	/// 사용자
	
	@Override
	public List<String> sideList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".sideList");
	}

	@Override
	public List<String> programList(ProgramVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".progUserList", vo);
	}

	@Override
	public List<String> programImg(Integer intronum) throws Exception {
		
		return session.selectList(namespace + ".imgsCall", intronum);
	}
	@Override
	public List<String> programImgs() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".imgsCalls");
	}	
	
	@Override
	public List<ProgramVO> listProg(int num) throws Exception {
		return session.selectList(namespace+".listProg", num);
	}
	
	@Override
	public List<ProgramVO> listAjaxProg(String compname) throws Exception {
		return session.selectList(namespace+".listAjaxProg", compname);
	}

}
