package com.hbc.service;

import java.util.List;
import java.util.Map;

import com.hbc.domain.Criteria;
import com.hbc.domain.EventBoardVO;
import com.hbc.domain.EventFileVO;
import com.hbc.domain.MainEventVO;
import com.hbc.domain.SearchCriteria;

public interface EventBoardService {
   
   public void regist(EventBoardVO board, Map<String, String> name) throws Exception;

   public EventBoardVO read(Integer num) throws Exception;
   
   public EventBoardVO readAdmin(Integer num) throws Exception;

   public EventFileVO readFile(Integer num, String type) throws Exception;
   
   public void modify(EventBoardVO vo) throws Exception;
   
   public void modifyFile(EventFileVO vo) throws Exception;
   
   public void deleteFile(EventFileVO vo) throws Exception;

   public void remove(Integer num) throws Exception;
   
   public List<EventBoardVO> listCriteria(Criteria cri) throws Exception;
   
   public int listCountCriteria(Criteria cri) throws Exception;
   
   public List<EventBoardVO> searchListCriteria(SearchCriteria cri) throws Exception;
   
   public int searchListCount(SearchCriteria cri) throws Exception;
   
   public String getAttach(Integer num) throws Exception;
   
   public List<EventFileVO> searchEventFileList() throws Exception;
   
   public List<MainEventVO> searchEventImgList() throws Exception;

}