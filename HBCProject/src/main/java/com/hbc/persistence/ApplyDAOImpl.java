package com.hbc.persistence;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.ApplyVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.ApplyDTO;

/**
 * 수강 테이블의 기본 CRUD 정의한 인터페이를 구현한 클래스
 * 
 * @author CHO
 *
 */
@Repository
public class ApplyDAOImpl implements ApplyDAO {

	@Inject
	SqlSession sqlSession;

	private static final String namespace = "com.hbc.mappers.ApplyMapper";
	
	@Override
	public void create(ApplyVO vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);
	}

	@Override
	public List<ApplyVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");

	}

	@Override
	public void update(ApplyVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int appnum) throws Exception {
		sqlSession.delete(namespace + ".delete", appnum);

	}

	@Override
	public ApplyVO read(int appnum) throws Exception {
		return sqlSession.selectOne(namespace + ".read", appnum);

	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return sqlSession.selectList(namespace + ".compList");

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging", cri);

	}

	@Override
	public List<ApplyVO> listSearch(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", cri);

	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);

	}

	@Override
	public List<CourseVO> listCour(String compname) throws Exception {
		return sqlSession.selectList(namespace + ".courList", compname);
	}

	@Override
	public ApplyDTO readDTO(int appnum) throws Exception {
		return sqlSession.selectOne(namespace + ".readDTO", appnum);
	}

	@Override
	public List<CompanyVO> appCompList() throws Exception {
		return sqlSession.selectList(namespace + ".appCompList");
	}

	@Override
	public List<ApplyVO> userListSearch(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".userListSearch", cri);

	}

	@Override
	public int userListSearchCount(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".userListSearchCount", cri);
	}

}
