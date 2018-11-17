package com.hbc.persistence;

import java.util.List;
import java.util.Map;

import com.hbc.domain.Criteria;
import com.hbc.domain.EventBoardVO;
import com.hbc.domain.EventFileVO;
import com.hbc.domain.MainEventVO;
import com.hbc.domain.SearchCriteria;

public interface EventBoardDAO {
   
   public void insert(EventBoardVO vo) throws Exception;
   
   public void insertFile(EventFileVO vo) throws Exception;
      
   public EventBoardVO read(Integer num) throws Exception;
   
   public EventFileVO readFile(Integer num, String type) throws Exception;
   
   public void update(EventBoardVO vo) throws Exception;
   
   public void delete(Integer num) throws Exception;
   
   public void deleteFile(EventFileVO vo) throws Exception;
   
   public void updateViewCnt(Integer num) throws Exception;

   public List<EventBoardVO> listPage(int page) throws Exception; 
   
   public List<EventBoardVO> listCriteria(Criteria cri) throws Exception;
   
   public int countPaging(Criteria cri) throws Exception;
   
   public List<EventBoardVO> searchlist(SearchCriteria cri) throws Exception;
   
   public int searchListCount(SearchCriteria cri) throws Exception;

   public void addAttach(Map<String, String> fileList) throws Exception;
   
   public String getAttach(Integer num) throws Exception;
   
   public List<EventFileVO> searchEventFileList() throws Exception;
   
   public List<MainEventVO> searchEventImgList() throws Exception;
   
}