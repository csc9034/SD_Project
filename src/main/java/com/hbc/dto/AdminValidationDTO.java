package com.hbc.dto;

/**
 * 관리자 유효성 검사 결과를
 * 전달하는 클래스
 * @author 진재환
 *
 */

public class AdminValidationDTO
{
	// 아이디 유효성검사 결과 메시지
	private String idMsg;
	// 이메일 유효성검사 결과 메시지
	private String emailMsg;
	// 전화번호 유효성검사 결과 메시지
	private String phoneMsg;
	
	/**
	 * 기본 생성자
	 */
	public AdminValidationDTO()
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
	public AdminValidationDTO(String idMsg, String emailMsg, String phoneMsg)
	{
		super();
		this.idMsg = idMsg;
		this.emailMsg = emailMsg;
		this.phoneMsg = phoneMsg;
	}
	
	/****************************  게터 세터  *********************************/
	/**********************************************************************/
	public String getIdMsg() { return idMsg; }
	public void setIdMsg(String idMsg) { this.idMsg = idMsg; }
	public String getEmailMsg() { return emailMsg; }
	public void setEmailMsg(String emailMsg) { this.emailMsg = emailMsg; }
	public String getPhoneMsg() { return phoneMsg; }
	public void setPhoneMsg(String phoneMsg) { this.phoneMsg = phoneMsg; }
	/**********************************************************************/
}
