package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.SearchCriteria;
import com.hbc.domain.VideoBoardVO;
import com.hbc.persistence.VideoBoardDAO;

@Service
public class VideoBoardServiceImpl implements VideoBoardService {
	@Inject
	private VideoBoardDAO dao;

	@Override
	public void regist(VideoBoardVO board) throws Exception {
		
		//텍스트에어리어 줄바꿈 적용
		board.setContent(board.getContent().replace("\r\n","<br>"));
		//링크 주소 17자리 잘라서 저장
		board.setLink(board.getLink().substring(17));
		
		dao.create(board);
	}
	
	
	@Override
	public void modify(VideoBoardVO board) throws Exception {
		//링크 주소 17자리 잘라서 저장
		board.setLink(board.getLink().substring(17));
		
		//텍스트에어리어 줄바꿈 적용
		board.setContent(board.getContent().replace("\r\n","<br>"));
				
		dao.modify(board);
	}

	@Override
	public void remove(Integer num) throws Exception {
		dao.remove(num);
	}

	@Override
	public VideoBoardVO read(Integer bno) throws Exception {
		//사용자화면 상세보기 -조회수 적용-
		
		dao.updateViewCnt(bno);
		
		
		return dao.read(bno);
	}

	@Override
	public List<VideoBoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<VideoBoardVO> searchListCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}


	@Override
	public VideoBoardVO adminRead(Integer bno) throws Exception {
		//관리자화면에서 상세보기(수정화면으로 넘어감) -조회수 미적용-
		VideoBoardVO board = dao.read(bno);
		
		//텍스트에어리어 줄바꿈 적용 (리턴받는 값이 달라서 if 안써주면 널포인트 뜸)
		if(board.getContent()!=null) {
			board.setContent(board.getContent().replace("<br>","\r\n"));
		}
		
		
		return board;
	}


	@Override
	public List<VideoBoardVO> listSearch(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}


	@Override
	public List<CompanyVO> selectComp() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectComp();
	}


	@Override
	public List<VideoBoardVO> listSearchUser(SearchCriteria cri) throws Exception {
		return dao.listSearchUser(cri);
	}


	@Override
	public int listSearchCountUser(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCountUser(cri);
	}
	
}
