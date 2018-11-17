package com.hbc.dto;

/**
 * 관리자 유효성 검사 결과를
 * 전달하는 클래스
 * @author 진재환
 *
 */

public class StudentValidationDTO
{
	// 아이디 유효성검사 결과 메시지
	private String idMsg;
	
	/**
	 * 기본 생성자
	 */
	public StudentValidationDTO()
	{
		super();
	}
	/**
	 * 매개변수 있는 생성자
	 * 
	 * @param idMsg
	 * @param emailMsg
	 * @param phoneMsg
	 */
	public StudentValidationDTO(String idMsg)
	{
		super();
		this.idMsg = idMsg;
	}
	
	/****************************  게터 세터  *********************************/
	/**********************************************************************/
	public String getIdMsg() { return idMsg; }
	public void setIdMsg(String idMsg) { this.idMsg = idMsg; }
	/**********************************************************************/
}
