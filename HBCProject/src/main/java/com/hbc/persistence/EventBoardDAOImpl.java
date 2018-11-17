package com.hbc.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.Criteria;
import com.hbc.domain.EventBoardVO;
import com.hbc.domain.EventFileVO;
import com.hbc.domain.MainEventVO;
import com.hbc.domain.SearchCriteria;

@Repository
public class EventBoardDAOImpl implements EventBoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mapper.EventBoardMapper";

	@Override
	public void insert(EventBoardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void addAttach(Map<String, String> fileList) throws Exception {
		session.insert(namespace + ".addAttach", fileList);
	}

	@Override
	public EventBoardVO read(Integer num) throws Exception {
		return session.selectOne(namespace + ".read", num);
	}
	
	@Override
	public EventFileVO readFile(Integer num, String type) throws Exception {
		Map<String, String> searchFile = new HashMap<>();
		searchFile.put("num", String.valueOf(num));
		searchFile.put("type", type);
		return session.selectOne(namespace + ".readFile", searchFile);
	}

	@Override
	public void update(EventBoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer num) throws Exception {
		session.delete(namespace + ".delete", num);
	}

	@Override
	public List<EventBoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<EventBoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<EventBoardVO> searchlist(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".searchlist", cri);
	}

	@Override
	public int searchListCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".searchListCount", cri);
	}

	@Override
	public void updateViewCnt(Integer num) throws Exception {
		session.update(namespace + ".updateViewCnt", num);
	}
	
	@Override
	public String getAttach(Integer num) throws Exception {
		return session.selectOne(namespace + ".getAttach", num);
	}

	@Override
	public void deleteFile(EventFileVO vo) throws Exception {
		session.delete(namespace + ".deleteFile", vo);
		
	}

	@Override
	public void insertFile(EventFileVO vo) throws Exception {
		session.insert(namespace + ".createFile", vo);
		
	}
	
	@Override
	   public List<EventFileVO> searchEventFileList() throws Exception {
	      return session.selectList(namespace + ".searchEventFileList");
	   }

	@Override
	public List<MainEventVO> searchEventImgList() throws Exception {
		return session.selectList(namespace + ".searchEventImgList");
	}
	

}