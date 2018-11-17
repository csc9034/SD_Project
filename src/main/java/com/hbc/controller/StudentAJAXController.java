package com.hbc.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbc.domain.AdminVO;
import com.hbc.domain.StudentVO;
import com.hbc.dto.AdminValidationDTO;
import com.hbc.dto.StudentValidationDTO;
import com.hbc.service.AdminService;
import com.hbc.service.StudentService;

/**
 * JSON데이터를 주고받는 콘트롤러
 * 일단 동적 유효성검사를 위해 만들어짐
 * 
 * @author 진재환
 *
 */

@RestController
public class StudentAJAXController
{
	@Inject
	private StudentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * AJAX로 요청하는 유효성 검사 메소드
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/student/validate", method = RequestMethod.POST)
	@ResponseBody
	public StudentValidationDTO validate(@RequestBody StudentVO student) throws Exception
	{
		// AdminValidationDTO 객체를 서비스에서 받아옴
		// 이 객체에는 유효성검사 결과가 들어있음
		StudentValidationDTO msg = service.validate(student.getStuid());
		
		// 메시지를 JSON으로 뷰에 전달함
		return msg;
	}	

}
