package com.hbc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.Criteria;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.persistence.CompanyDAO;
import com.hbc.util.DataFormatUtil;

import static com.hbc.util.DataFormatUtil.contentModelToView;
import static com.hbc.util.DataFormatUtil.contentViewToModel;
import static com.hbc.util.DataFormatUtil.phoneViewToModel;
import static com.hbc.util.DataFormatUtil.phoneModelToView;

/**
 * 기관 서비스 구현 클래스
 * 
 * @author 정준호
 *
 */

@Service
public class CompanyServiceImpl implements CompanyService {

	// 기관 DAO 객체
	@Inject
	private CompanyDAO dao;

	/**
	 * 파라미터로 들어온 기관 객체를 DAO로 전송함
	 */
	@Override
	public void register(CompanyVO vo) throws Exception {
		// 기관 설명을 \n을 <br/>로 바꿈
		vo.setCompdesc(DataFormatUtil.contentViewToModel(vo.getCompdesc()));
		vo.setPhone(vo.getPhone().replace("-", ""));

		dao.create(vo);

	}

	/**
	 * 뷰로부터 기관 번호를 받아서 DAO로 기관 번호를 전송한 뒤 검색결과를 받고 다시 뷰로 넘겨줌
	 */
	@Override
	public CompanyVO read(Integer compnum) throws Exception {
		CompanyVO comp = dao.read(compnum);
		
		// 기관설명의 <br/>을 모두 \n로 바꿔줌
		comp.setCompdesc(contentModelToView(comp.getCompdesc()));
		// 전화번호에 - 문자를 적절하게 넣어줌
		comp.setPhone(phoneModelToView(comp.getPhone()));
		
		return comp;
	}

	/**
	 * 뷰로부터 수정할 기관 객체를 받아서 DAO 객체에 기관 객체를 넘거줌
	 */
	@Override
	public void modify(CompanyVO vo) throws Exception {
		// 기관 설명을 \n을 <br/>로 바꿈
		vo.setCompdesc(contentViewToModel(vo.getCompdesc()));
		vo.setPhone(vo.getPhone().replace("-", ""));
		
		dao.update(vo);

	}

	/**
	 * 뷰로부터 삭제할 기관 객체를 받아서 DAO 객체에 기관 객체를 넘겨줌
	 */
	@Override
	public void remove(Integer compnum) throws Exception {
		dao.delete(compnum);

	}

	/**
	 * 뷰에 전체 기관 리스트를 전달함
	 */
	@Override
	public List<CompanyVO> listView(int division) throws Exception {
		
		List<CompanyVO> list = dao.listView(division);
		
		for (CompanyVO comp : list)
		{
			comp.setPhone(phoneModelToView(comp.getPhone()));
		}
		
		return list;
	}

	/**
	 * 뷰로부터 Criteria 객체를 받아서 DAO로 객체를 넘겨주고 행의 개수륿 받아서 다시 뷰로 돌려줌
	 */
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);

	}

	/**
	 * 뷰로부터 SearchCriteria 객체를 받고 SearchCriteria 객체를 DAO로 넘겨준 후 SearchCriteria 객체의
	 * 검색키워드, 검색조건을 이용하여 기관 검색후 리스트로 받고 뷰에 리스트를 넘겨줌
	 */
	@Override
	public List<CompanyVO> listSearchCriteria(AppSearchCriteria cri)
			throws Exception {
		List<CompanyVO> list = dao.listSearch(cri);
		
		for (CompanyVO comp : list)
		{
			comp.setPhone(phoneModelToView(comp.getPhone()));
		}
		
		return list;
	}

	/**
	 * 뷰로부터 SearchCriteria 객체를 받고 SearchCriteria 객체를 DAO로 넘겨준 후 SearchCriteria 객체의
	 * 검색키워드, 검색조건을 이용하여 기관 검색후 행의 개수를 받고 뷰에 리스트를 넘겨줌
	 */
	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void deleteAttach(String fileName) throws Exception {
		dao.deleteAttach(fileName);

	}

	@Override
	public String getAttach(int compnum) throws Exception {
		return dao.getAttach(compnum);

	}

	@Override
	public List<CompanyVO> listComp() throws Exception {
		return dao.listComp();
	}


}
