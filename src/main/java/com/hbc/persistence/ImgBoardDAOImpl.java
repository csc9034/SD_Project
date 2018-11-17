package com.hbc.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.hbc.domain.ImgBoardVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.ImgFileVO;
import com.hbc.domain.SearchCriteria;

@Repository
public class ImgBoardDAOImpl implements ImgBoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mapper.ImgBoardMapper";

	@Override
	public int create(ImgBoardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		return vo.getImgnum();
	}

	@Override
	public ImgBoardVO read(Integer imgnum) throws Exception {
		return session.selectOne(namespace + ".read", imgnum);
	}

	@Override
	public void update(ImgBoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer imgnum) throws Exception {
		session.delete(namespace + ".delete", imgnum);
	}

	@Override
	public List<ImgBoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<ImgBoardVO> listPage(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<ImgBoardVO> listCriteria(Criteria cri) throws Exception {

		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<ImgBoardVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}


	@Override
	public void updateViewCnt(Integer imgnum) throws Exception {

		session.update(namespace + ".updateViewCnt", imgnum);

	}

	@Override
	public void addAttach(ImgFileVO imgVO) throws Exception {

		session.insert(namespace + ".addAttach", imgVO);

	}

	@Override
	public List<ImgFileVO> getAttach(Integer imgnum) throws Exception {

		return session.selectList(namespace + ".getAttach", imgnum);
	}
	
	@Override
	public List<ImgFileVO> getMainAttach(Integer imgnum) throws Exception {

		return session.selectList(namespace + ".getMainAttach", imgnum);
	}
	@Override
	public List<ImgFileVO> getUAttach(Integer imgnum) throws Exception {
		
		return session.selectList(namespace + ".getUAttach", imgnum);
	}
	
	@Override
	public List<ImgFileVO> getUMainAttach(Integer imgnum) throws Exception {
		
		return session.selectList(namespace + ".getUMainAttach", imgnum);
	}
	@Override
	public List<ImgBoardVO> getRelatAtt(Integer imgnum) throws Exception {
		
		return session.selectList(namespace + ".relatAtt", imgnum);
	}

	@Override
	public void deleteAttach(Integer imgnum) throws Exception {

		session.delete(namespace + ".deleteAttach", imgnum);

	}
	
	@Override
	public void deleteMainAttach(Integer imgnum) throws Exception {
		session.delete(namespace + ".deleteMainAttach", imgnum);
		
	}

	@Override
	public void replaceAttach(String name, Integer imgnum) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("imgnum", imgnum);
		paramMap.put("name", name);
		
		session.insert(namespace + ".replaceAttach", paramMap);

	}

	@Override
//	public void replaceMainAttach(String name, Integer imgnum) throws Exception {
	public void replaceMainAttach(String mainfile, Integer imgnum) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("imgnum", imgnum);
//		paramMap.put("name", name);
		paramMap.put("mainfile", mainfile);
		
		session.insert(namespace + ".replaceMainAttach", paramMap);
		
	}




}
