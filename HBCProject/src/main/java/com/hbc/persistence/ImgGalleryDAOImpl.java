package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.GalleryFileVO;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.SearchCriteria;

@Repository
public class ImgGalleryDAOImpl implements ImgGalleryDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mapper.ImgGalleryBoardMapper";

	@Override
	public int insert(GalleryBoardVO vo) throws Exception {
		session.insert(namespace + ".insert", vo);
		return vo.getGalnum();
	}

	@Override
	public GalleryBoardVO read(Integer galnum) throws Exception {
		return session.selectOne(namespace + ".read", galnum);
	}

	@Override
	public void update(GalleryBoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer galnum) throws Exception {
		session.delete(namespace + ".delete", galnum);
	}

	@Override
	public List<GalleryBoardVO> listPage(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<GalleryBoardVO> listCriteria(Criteria cri) throws Exception {

		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public List<GalleryBoardVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public List<GalleryBoardVO> adminListSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".adminListSearch", cri);
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
	public void addAttach(GalleryFileVO vo) throws Exception {
		session.insert(namespace + ".addAttach", vo);

	}

	@Override
	public List<String> getAttach(int galnum) throws Exception {
		return session.selectList(namespace + ".getAttach", galnum);

	}

	@Override
	public void deleteAttach(int galnum) throws Exception {
		session.insert(namespace + ".deleteAttach", galnum);

	}

	@Override
	public void deleteAttach(String filename) throws Exception {
		session.insert(namespace + ".deleteImageByName", filename);

	}

	@Override
	public int getCurrFileSeq() throws Exception {
		return session.selectOne(namespace + ".getCurrFileSeq");

	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return session.selectList(namespace + ".listComp");
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".countPaging", cri);
	}
	
}
