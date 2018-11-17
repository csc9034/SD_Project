package com.hbc.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hbc.domain.AdminVO;
import com.hbc.dto.CompanyDTO;
import com.hbc.persistence.AdminDAO;

/**
 * 어드민 테스트 클래스
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class AdminTest
{
	// 테스트할 DAO
	@Inject
	private AdminDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(AdminTest.class);
	
	// 어드민 데이터 하나 읽어오는 테스트
	/*@Test
	public void test1ReadAdmin() throws Exception
	{
		AdminVO admin = new AdminVO();
		admin.setAdminId("jaehwanspin189");
		admin = dao.read(admin);
		logger.info(admin.toString());
	}*/
	
	/**
	 * 어드민 객체 삽입 테스트
	 */
	@Test
	public void test2InsertAdmin() throws Exception
	{
		AdminVO admin = new AdminVO(
					"lovelyjaehwan"
					, "1234"
					, "재환♥"
					, "01040279050"
					, "jinjaehwan@empas.com"
					, 1
				);
		
		int result = dao.insert(admin);
		
		logger.info(result + "행 삽입");
	}
	
	/**
	 * 어드민 수정 테스트
	 */
	/*@Test
	public void test3UpdateAdmin() throws Exception
	{
		AdminVO admin = new AdminVO(
				"lovelyjaehwan"
				, "1234"
				, "재환凸"
				, "01040279050"
				, "jinjaehwan@empas.com"
				, 5
			);
		
		int result = dao.update(admin);
		
		logger.info(result + "행 수정");
		
		admin = new AdminVO();
		admin.setAdminId("lovelyjaehwan");
		admin = dao.read(admin);
		logger.info(admin.toString());
	}
	
	/**
	 * 어드민 삭제 테스트
	 */
	/*@Test
	public void test4DeleteAdmin() throws Exception
	{
		AdminVO admin = new AdminVO();
		admin.setAdminId("lovelyjaehwan");
		int result = dao.delete(admin);
		logger.info(result + "행 삭제");
	}*/
	
	/**
	 * 어드민 리스트 테스트
	 */
	/*@Test
	public void test5ListAllAdmin() throws Exception
	{
		List<AdminVO> admins = null;
		admins = dao.listAll();
		
		for (AdminVO admin : admins)
		{
			logger.info(admin.toString());
		}
	}*/
	
	/**
	 * 어드민 페이징 리스트 테스트
	 */
	/*@Test
	public void test6ListPageAdmin() throws Exception
	{
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("");
		cri.setSearchType("nameid");
		cri.setPage(2);
		
		List<AdminVO> list = dao.listSearch(cri);
		
		for (AdminVO admin : list)
		{
			logger.info(admin.toString());
		}
		
		logger.info(cri.getPage() + " 페이지");
	}*/
	
	/**
	 * 이메일과 폰번의 유효성 검사 테스트
	 */
	/*@Test
	public void test7ValidateAdmin() throws Exception
	{
		AdminVO admin = new AdminVO("lovelyjaehwan");
		admin.setAdminEmail("jinjaehwan@empas.com");
		admin.setAdminPhone("01040279050");
		
		AdminVO validate = dao.validateEmail(admin);
		
		logger.info(validate != null ?
				"이메일이 중복됩니다" : "이메일을 사용 가능합니다");
		
		validate = dao.validatePhone(admin);
		
		logger.info(validate != null ?
				"전화번호가 중복됩니다" : "전화번호를 사용 가능합니다");
	}*/
	
//	@Test
	public void test8GetCompSelect()
	{
		List<CompanyDTO> list = dao.readComps();
		
		for (CompanyDTO comp : list)
		{
			logger.info(comp.toString());
		}
		
	}
}
