package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.GalleryBoardVO;
import com.hbc.domain.GalleryFileVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.ImgGalleryDAO;

@Service
public class ImgGalleryServiceImpl implements ImgGalleryService {

	@Inject
	private ImgGalleryDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ImgGalleryServiceImpl.class);

	@Override
	public void regist(GalleryBoardVO board) throws Exception {

		// 1. 텍스트에어리어 줄바꿈 적용
		board.setContent(board.getContent().replace("\r\n", "<br>"));

		// 2.게시글 등록 후 게시글 SEQ 받아오기
		int galNum = dao.insert(board);
		System.out.println("=====>galleryNum: " + galNum);

		// 3.게시글에 연결된 이미지 저장

		// 3-1 대표 이미지 객체 생성
		GalleryFileVO vo = new GalleryFileVO();

		// 3-2 게시글 SEQ 설정
		vo.setGalnum(galNum);

		String[] files = board.getFiles();

		if (files != null) {
			for (String fileName : files) {
				vo.setName(fileName);
				logger.info(fileName);
				dao.addAttach(vo);
			}
		}
		
	}

	@Override
	public GalleryBoardVO read(int galnum) throws Exception {
		GalleryBoardVO vo = dao.read(galnum);

		if (vo.getContent() != null) {
			vo.setContent(vo.getContent().replace("<br>", "\r\n"));
		}

		return vo;
	}

	@Override
	public GalleryBoardVO userRead(int galnum) throws Exception {
		dao.updateViewCnt(galnum);
		
		GalleryBoardVO vo = dao.read(galnum);
		
		return vo;
	}

	@Transactional
	@Override
	public void modify(GalleryBoardVO vo) throws Exception {

		// 1-1. 텍스트에어리어 줄바꿈 적용
		vo.setContent(vo.getContent().replace("\r\n", "<br>"));

		// 1-2.게시글 수정
		dao.update(vo);

		int galleryNum = vo.getGalnum();

		// 2.첨부파일 삭제
		dao.deleteAttach(galleryNum);

		// 3-2 게시글 SEQ 설정
		// 3.첨부파일 교체 작업

		GalleryFileVO fvo = new GalleryFileVO();

		fvo.setGalnum(galleryNum);

		System.out.println("fvo : " + fvo);

		String[] files = vo.getFiles();

		if (files != null) {
			for (String fileName : files) {
				fvo.setName(fileName);
				logger.info(fileName);
				dao.addAttach(fvo);
			}
		}
	}

	@Override
	public void remove(int galnum) throws Exception {
		dao.deleteAttach(galnum);
		dao.delete(galnum);
	}

	@Override
	public List<GalleryBoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public List<GalleryBoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public List<GalleryBoardVO> adminListSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.adminListSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void deleteAttach(int galnum) throws Exception {
		dao.deleteAttach(galnum);

	}

	@Override
	public List<String> getAttach(int galnum) throws Exception {
		return dao.getAttach(galnum);

	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return dao.listComp();
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
}
