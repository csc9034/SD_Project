package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbc.domain.NoticeVO;
import com.hbc.domain.SearchCriteria;
import com.hbc.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDAO dao;

	@Transactional
	@Override
	public void regist(NoticeVO vo) throws Exception {
		System.out.println("등록 텍스트 내용 : "+vo.getNoText());
		vo.setNoText(vo.getNoText().replace("\r\n","<br>"));
		System.out.println("등록 텍스트 바뀐 내용 :"+vo.getNoText());
		
		dao.create(vo);

		String[] files = vo.getFiles();
		String[] links = vo.getLinks();
		String[] imgFileNames = vo.getImgFileNames();
		
		/*if(links != null) {
		for(String link :links) {
			System.out.println("service 링크 배열 : "+link);
		}
		}
		if(files !=null) {
		for(String file : files) {
			System.out.println("service 파일명 : " + file);
		}
		}*/
		
		if (files == null) {
			return;
		} 
		for(String fileName : files) {
			System.out.println("파일 등록 실행");
			dao.addAttach(fileName);
		}
		
		if (links == null || imgFileNames == null) {
			return;
		} else {
			for(int idx=0; idx < links.length; idx++) {
				dao.addLink(links[idx], imgFileNames[idx]);
				System.out.println("파일, 링크 업로드 : "+ links[idx] + " "+ imgFileNames[idx]);
			}
		}
	}

	@Override
	public NoticeVO read(Integer noNum) throws Exception {
		NoticeVO vo = dao.read(noNum);
		
		if (vo.getNoText() != null) {
			vo.setNoText(vo.getNoText().replace("<br>","\r\n"));
		}
		return vo;
	}
	
	@Override
	public void userRead(Integer noNum) throws Exception {
		dao.updateNoViewCnt(noNum);
	}

	@Transactional
	@Override
	public void modify(NoticeVO vo) throws Exception {
		if (vo.getNoText() != null) {
			vo.setNoText(vo.getNoText().replace("\r\n","<br>"));
		}
	
		dao.update(vo);

		Integer noNum = vo.getNoNum();

		for(String filename : dao.getAttach(noNum)) {
			dao.deleteLink(filename);
		}
		dao.deleteAttach(noNum);

		String[] files = vo.getFiles();
		String[] links = vo.getLinks();
		String[] imgFileNames = vo.getImgFileNames();
		/*if(files != null) {
		for(String file : files) {
			System.out.println("service 수정 일반 첨부파일명 : "+file);
		}
		}
		if(links != null) {
		for(String link : links) {
			System.out.println("service 수정 링크 주소 : "+link);
		}
		}
		
		if(imgFileNames != null) {
		for(String imgfile : imgFileNames) {
			System.out.println("service 수정 이미지 파일명 : "+imgfile);
		}
		}*/

		if (files == null) {
			return;
		} 
		for(String fileName : files) {
			dao.replaceAttach(fileName, noNum);
		}
		
		if (links == null || imgFileNames == null) {
			return;
		} else {
			for(int idx=0; idx < links.length; idx++) {
				dao.replaceLink(links[idx], imgFileNames[idx], noNum);
			}
		}
	}

	@Transactional
	@Override
	public void remove(Integer noNum) throws Exception {
		for(String filename : dao.getAttach(noNum)) {
			dao.deleteLink(filename);
		}
		dao.deleteAttach(noNum);
		dao.delete(noNum);
	}

	@Override
	public List<NoticeVO> searchlist(SearchCriteria cri) throws Exception {
		return dao.searchlist(cri);
	}
	
	@Override
	public List<NoticeVO> topList(SearchCriteria cri) throws Exception {
		return dao.topList(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer noNum) throws Exception {
		return dao.getAttach(noNum);
	}

	@Override
	public String getUri(String fullName) throws Exception {
		return dao.getUri(fullName);
	}

	@Override
	public void removeAttach(String fullName) throws Exception {
		dao.deleteOneAttach(fullName);
	}

	@Override
	public void removeRink(String fullName) throws Exception {
		dao.deleteLink(fullName);
	}

}
