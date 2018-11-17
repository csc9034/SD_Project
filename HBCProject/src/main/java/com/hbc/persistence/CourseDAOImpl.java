package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.CourseVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CourseDTO;

/**
 * 과목 테이블에서 기본 CRUD를 정의한 인터페이스를 구현한 클래스
 * @author CHO
 *
 */
@Repository
public class CourseDAOImpl implements CourseDAO {

	@Inject
	SqlSession sqlSession;

	private static final String namespace = "com.hbc.mappers.CourseMapper";

	@Override
	public void create(CourseVO vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);
	}

	@Override
	public void update(CourseVO vo) throws Exception {
	      sqlSession.update(namespace + ".update", vo);

	}

	@Override
	public void delete(int cournum) throws Exception {
	      sqlSession.delete(namespace + ".delete", cournum);

	}

	@Override
	public List<CourseVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public List<EmployeeVO> listEmp(String compname) throws Exception {
		return sqlSession.selectList(namespace + ".empList", compname);
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
	public List<CourseVO> listSearch(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public CourseVO read(int cournum) throws Exception {
	      return sqlSession.selectOne(namespace + ".read", cournum);

	}

	@Override
	public CourseDTO readDTO(int cournum) throws Exception {
	      return sqlSession.selectOne(namespace + ".readDTO", cournum);
	}

}
