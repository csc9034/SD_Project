package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.Criteria;
import com.hbc.domain.NewsVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.NewsDAO;
import com.hbc.util.DataFormatUtil;

/**
 * 
 * @author 윤홍식
 *
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Inject
	private NewsDAO dao;

	@Override
	public void regist(NewsVO news) throws Exception {
		news.setNewsText(news.getNewsText().replace("\r\n", "<br/>"));

		// 1.보도자료 게시글 등록 -> 등록한 게시물 번호 리턴
		int newsNum = dao.create(news);
		news.setNewsNum(newsNum);

		String file = news.getFileName();

		// 2.첨부파일 저장
		if (file != null) {

			dao.addAttach(news);

		}

	}

	@Override
	public NewsVO read(int newsNum) throws Exception {
		// 1. 조회수 + 1 서비스(read)에서 기능을 나누어 구현
		/* dao.updateViewCnt(newsNum); */

		// 2.보도자료 게시글 가져오기

		NewsVO vo = dao.read(newsNum);
		
		// <br/> 태그 없애기
		vo.setNewsText(vo.getNewsText().replace("<br>", "\r\n"));
		
		// 3.첨부파일 가져오기
		String file = dao.getAttach(vo.getNewsNum());
		vo.setFileName(file);

		return vo;
	}

	@Override
	public void modify(NewsVO news) throws Exception {

		// 1.첨부 파일 수정
		if (news.getFileName() != null) {
			
			// 1-1 예전 첨부파일 삭제
			dao.deleteAttach(news.getNewsNum());

			if (!news.getFileName().equals("파일선택")) {
				// 1-2 수정된 첨부파일 등록
				dao.addAttach(news);

			}
		}
		
		// 2.게시글 수정
		news.setNewsText(news.getNewsText().replace("\r\n", "<br>"));
		dao.update(news);
	}

	@Override
	public void remove(int newsNum) throws Exception {

		// 1.첨부파일 삭제
		dao.deleteAttach(newsNum);

		// 2.게시글 삭제
		dao.delete(newsNum);

	}

	@Override
	public List<NewsVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public void updateViewCnt(int newsNum) throws Exception {
		dao.updateViewCnt(newsNum);

	}

	@Override
	public List<NewsVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);

	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {

		return dao.countPaging(cri);

	}

	@Override
	public List<NewsVO> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return dao.listSearchCount(cri);
	}

	@Override
	public String getAttach(Integer newsNum) throws Exception {
		return dao.getAttach(newsNum);
	}

	@Override
	public void deleteFile(NewsVO news) throws Exception {

		dao.deleteFile(news);
	}

	/*
	 * @Override public List<String> sideList() throws Exception { // return
	 * dao.sideList(); }
	 */

}