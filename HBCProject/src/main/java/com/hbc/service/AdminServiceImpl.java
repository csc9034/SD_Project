package com.hbc.service;

import static com.hbc.util.DataFormatUtil.phoneModelToView;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hbc.domain.AdminVO;
import com.hbc.domain.CompanyVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.AdminValidationDTO;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.LoginDTO;
import com.hbc.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	// 어드민 DAO 객체
	@Inject
	private AdminDAO dao;

	@Override
	public AdminVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	/**
	 * 파라미터로 넘긴 어드민 객체의 아이디와 맞는 어드민 객체 하나 읽어오는 메소드
	 * 
	 * @param admin
	 * @return 어드민 객체
	 * @throws Exception
	 */
	@Override
	public AdminVO read(AdminVO admin) throws Exception {
		return dao.read(admin);
	}

	/**
	 * 파라미터로 넘긴 어드민 객체를 데이터베이스로 추가하는 메소드
	 * 
	 * @param admin
	 * @return 삽입된 행의 개수
	 * @throws Exception
	 */
	@Override
	public int insert(AdminVO admin) throws Exception {
		return dao.insert(admin);
	}

	/**
	 * 파라미터로 넘긴 어드민 객체의 아이디와 매칭되는 데이터베이스의 행을 어드민 객체의 데이터로 수정하는 메소드
	 * 
	 * @param admin
	 * @return 수정된 행의 개수
	 * @throws Exception
	 */
	@Override
	public int update(AdminVO admin) throws Exception {
		return dao.update(admin);
	}

	/**
	 * 어드민 객체를 파라미터로 넘겨서 객체의 ID와 매칭되는 데이터베이스 행을 삭제하는 메소드
	 * 
	 * @param admin
	 * @return 삭제된 행의 개수
	 * @throws Exception
	 */
	@Override
	public int delete(AdminVO admin) throws Exception {
		return dao.delete(admin);
	}

	/**
	 * 어드민 테이블의 행을 모두 리스트 객체에 담아서 가져오는 메소드
	 * 
	 * @return 어드민객체 리스트
	 * @throws Exception
	 */
	@Override
	public List<AdminVO> listAll() throws Exception {
		return dao.listAll();
	}

	/**
	 * SearchCriteria 객체를 파라미터로 검색조건을 만족하는 리스트를 페이징해서 가져오는 메소드
	 * 
	 * @param cri
	 * @return 검색조건에 맞는 어드민 리스트
	 * @throws Exception
	 */
	@Override
	public List<AdminVO> listSearch(AppSearchCriteria cri) throws Exception {
		
		List<AdminVO> list = dao.listSearch(cri);
		
		for (AdminVO admin : list)
		{
			admin.setAdminPhone(phoneModelToView(admin.getAdminPhone()));
		}
		
		return list;
	}

	/**
	 * DB에서 검색조건에 맞는 행의 개수를 가져오는 메소드
	 * 
	 * @param cri
	 * @return 행의 개수
	 * @throws Exception
	 */
	@Override
	public int listCount(AppSearchCriteria cri) throws Exception {
		return dao.ListSearchCount(cri);
	}

	/**
	 * 아이디, 이메일, 전화번호의 유효성을 검사하는 메소드
	 * 
	 * @param admin
	 * @return 유효성 검사 결과 메시지
	 * @throws Exception
	 */
	@Override
	public AdminValidationDTO validate(AdminVO admin) throws Exception {
		// AdminValidationDTO 객체를 생성하면서
		// 아이디, 이메일, 전화번호로 각각 검색한 결과가
		// null이 아니면 중복되는 값이므로 Failed 메시지로
		// 초기화되고 null이면 Ok 메시지로 초기화됨
		AdminValidationDTO dto = new AdminValidationDTO((dao.read(admin) != null) ? "idFailed" : "idOk",
				(dao.validateEmail(admin) != null) ? "emailFailed" : "emailOk",
				(dao.validatePhone(admin) != null) ? "phoneFailed" : "phoneOk");

		return dto;
	}

	/**
	 * 셀렉트박스에서 출력할 기관 리스트를 가져오는 메소드
	 * 
	 * @return 기관 리스트
	 */
	@Override
	public List<CompanyDTO> readComps() {
		return dao.readComps();
	}

}
