package com.hbc.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;

/**
 * 기관 DAO 메소드를 구현한 클래스
 * 
 * @author 정준호
 *
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

	// MyBatis 세션 객체
	@Inject
	SqlSession sqlSession;

	// 매퍼와 네임스페이스를 맞춤
	private static final String namespace = "com.hbc.mappers.CompanyMapper";

	/**
	 * 파라미터로 받은 기관 객체의 모든 필드 데이터들을 DB에 저장함
	 */
	@Override
	public void create(CompanyVO vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);

	}

	/**
	 * 파라미터로 넘거진 기관 객체에 있는 compnum으로 검색한 후 기관 객체 하나를 가져옴
	 */
	@Override
	public CompanyVO read(int compnum) throws Exception {
		return sqlSession.selectOne(namespace + ".read", compnum);
	}

	/**
	 * 파라미터로 받은 기관 객체의 모든 필드 데이터들로 DB에 있는 행을 수정함
	 */
	@Override
	public void update(CompanyVO vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);

	}

	/**
	 * 기관 번호를 받아서 해당 기관 번호의 DB 행을 삭제함
	 */
	@Override
	public void delete(int compnum) throws Exception {
		sqlSession.delete(namespace + ".delete", compnum);

	}

	/**
	 * 사용자 화면으로 목록을 보내주는 메소드
	 */
	@Override
	public List<CompanyVO> listView(int division) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("division", division);
		
		return sqlSession.selectList(namespace + ".listView", map);
	}

	/**
	 * SearchCriteria 객체를 받아서 검색조건과 검색키워드로 검색한 행을 리스트로 담아서 가져옴
	 */
	@Override
	public List<CompanyVO> listSearch(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	/**
	 * 검색조건에 맞는 행의 개수를 가져옴
	 */
	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);
	}

	/**
	 * 페이징된 행들의 개수를 가져옴
	 */
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public void addAttach(String fileName) throws Exception {
		sqlSession.insert(namespace + ".addAttach", fileName);

	}

	@Override
	public String getAttach(int compnum) throws Exception {
		return sqlSession.selectOne(namespace + ".getAttach", compnum);

	}

	@Override
	public void deleteAttach(int filenum) throws Exception {
		sqlSession.insert(namespace + ".deleteImage", filenum);

	}

	@Override
	public void deleteAttach(String filename) throws Exception {
		sqlSession.insert(namespace + ".deleteImageByName", filename);

	}

	@Override
	public int getCurrFileSeq() throws Exception {
		return sqlSession.selectOne(namespace + ".getCurrFileSeq");

	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return sqlSession.selectList(namespace+".listComp");
	}

}
