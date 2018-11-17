package com.hbc.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hbc.domain.EmployeeVO;
import com.hbc.dto.EmpFileDTO;
import com.hbc.persistence.EmployeeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class EmpTest {

	@Inject 
	private EmployeeDAO dao;

	private static Logger logger = LoggerFactory.getLogger(AdminTest.class);
	
//	@Test
	public void TestInsertEmp() {
		
		EmployeeVO vo = new EmployeeVO();
//		EmployeeVO vo = new EmployeeVO("홍길동", "01012345678", "sample01@samp.le", "강사", 1);
		
		vo.setEmpname("홍길동");
		vo.setEmpemail("sample01@samp.le");
		vo.setEmpphone("01012345678");
		vo.setPosition("강사");
		vo.setCompnum(1);
		
		dao.register(vo);
		
	}

	@Test
	public void TestAddFile() {
		
		logger.info(dao.addAttach("메롱")+"");
		
	}
}
