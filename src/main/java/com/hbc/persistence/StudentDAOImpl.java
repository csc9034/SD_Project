package com.hbc.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.AppSearchCriteria;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.StudentVO;
import com.hbc.dto.StudentLoginDTO;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Inject
	SqlSession sqlSession;

	private static final String namespace = "com.hbc.mappers.StudentMapper";

	@Override
	public void create(StudentVO vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);
		
	}

	@Override
	public void update(StudentVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(String stuid) throws Exception {
		sqlSession.delete(namespace + ".delete", stuid);
		
	}

	@Override
	public StudentVO read(String stuid) throws Exception {
		return sqlSession.selectOne(namespace + ".read", stuid);
	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return sqlSession.selectList(namespace + ".compList");

	}

	@Override
	public List<StudentVO> listSearch(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", cri);

	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);

	}
	
	@Override
	public StudentVO login(StudentLoginDTO dto) throws Exception {
		return sqlSession.selectOne(namespace + ".login" , dto);
	}

}
