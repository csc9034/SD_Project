package com.hbc.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hbc.dto.LoginDTO;
import com.hbc.persistence.AdminDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class LoginTest {

	@Inject
	private AdminDAO dao;
	
	
	@Test
	public void TestLogin() throws Exception {
		
		LoginDTO dto = new LoginDTO();
		
		dto.setAdminid("admin");
		dto.setAdminpw("admin");
		
		System.out.println(dto.getAdminpw());
		
		dao.login(dto);
		
	}
	
}
