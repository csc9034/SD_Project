package com.hbc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.Criteria;
import com.hbc.domain.EventBoardVO;
import com.hbc.domain.EventFileVO;
import com.hbc.domain.MainEventVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.EventBoardDAO;

@Service
public class EventBoardServiceImpl implements EventBoardService {

	@Inject
	private EventBoardDAO dao;

	@Override
	public void regist(EventBoardVO board, Map<String, String> name) throws Exception {

		// content의 줄 개행을 위해
		board.setContent(board.getContent().replace("\r\n","<br>"));
		
		Map<String, String> imgFileList = new HashMap<>();
		Map<String, String> attachFileList = new HashMap<>();

		dao.insert(board);

		if (name.get("img") != null) {
			imgFileList.put("name", name.get("img"));
			imgFileList.put("num", String.valueOf(board.getNum()));
			imgFileList.put("type", "0");
			
			dao.addAttach(imgFileList);
		}

		if (name.get("attach") != null) {
			attachFileList.put("name", name.get("attach"));
			attachFileList.put("num", String.valueOf(board.getNum()));
			attachFileList.put("type", "1");

			dao.addAttach(attachFileList);
		}
	}

	@Override
	public EventBoardVO read(Integer num) throws Exception {
		
		dao.updateViewCnt(num);
		return dao.read(num);
	}

	@Override
	public EventBoardVO readAdmin(Integer num) throws Exception {
		
		//관리자화면에서 상세보기(수정화면으로 넘어감) -조회수 미적용-
	    EventBoardVO board = dao.read(num);
		
		//텍스트에어리어 줄바꿈 적용
	    if (board.getContent() != null ) {
	    	board.setContent(board.getContent().replace("<br>","\r\n"));
	    }
		
		return board;
	}

	@Override
	public EventFileVO readFile(Integer num, String type) throws Exception {
		return dao.readFile(num, type);
	}

	@Override
	public void modify(EventBoardVO vo) throws Exception {
		
		//텍스트에어리어 줄바꿈 적용
		if (vo.getContent() != null) {
			vo.setContent(vo.getContent().replace("\r\n", "<br>"));
		}
		
		dao.update(vo);
		

	}

	@Override
	public void modifyFile(EventFileVO vo) throws Exception {
		dao.deleteFile(vo);
		dao.insertFile(vo);
	}
	
	@Override
	public void deleteFile(EventFileVO vo) throws Exception {
		dao.deleteFile(vo);
	}

	@Override
	public void remove(Integer num) throws Exception {
		EventFileVO vo = new EventFileVO();
		vo.setNum(num);
		vo.setType(0);
		dao.deleteFile(vo);

		vo.setType(1);
		dao.deleteFile(vo);

		dao.delete(num);
	}

	@Override
	public List<EventBoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<EventBoardVO> searchListCriteria(SearchCriteria cri) throws Exception {
		return dao.searchlist(cri);
	}

	@Override
	public int searchListCount(SearchCriteria cri) throws Exception {
		return dao.searchListCount(cri);
	}

	@Override
	public String getAttach(Integer num) throws Exception {
		return dao.getAttach(num);
	}
	
	@Override
	   public List<EventFileVO> searchEventFileList() throws Exception {
	      return dao.searchEventFileList();
	}

	@Override
	public List<MainEventVO> searchEventImgList() throws Exception {
		return dao.searchEventImgList();
	}
	
}