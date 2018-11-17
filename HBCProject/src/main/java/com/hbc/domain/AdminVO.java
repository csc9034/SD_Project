package com.hbc.domain;

import static com.hbc.util.SHA256.getSHA256;

/**
 * 관리자 VO
 * 
 * @author 진재환
 *
 */

public class AdminVO
{
	// 관리자 아이디
	private String adminId;
	// 관리자 비밀번호
	private String adminPw;
	// 관리자 이름
	private String adminName;
	// 전화번호
	private String adminPhone;
	// 이메일
	private String adminEmail;
	// 소속기관번호
	private int compNum;
	
	// 소속기관이름
	private String compname;
	
	/**
	 * 기본 생성자
	 */
	public AdminVO() {  }
	
	/**
	 * adminId만 넣는 생성자
	 * @param adminId
	 */
	public AdminVO(String adminId)
	{
		this(adminId, null, null, null, null, 0);
	}
	
	/**
	 * 매개변수가 있는 생성자
	 * 
	 * @param adminId
	 * @param adminPw
	 * @param adminName
	 * @param adminPhone
	 * @param adminEmail
	 * @param compNum
	 */
	public AdminVO(String adminId, String adminPw, String adminName
			, String adminPhone, String adminEmail, int compNum)
	{
		this.adminId = adminId;
		if (adminPw != null)
			this.adminPw = getSHA256(adminPw);
		else
			this.adminPw = null;
		this.adminName = adminName;
		this.adminPhone = adminPhone;
		this.adminEmail = adminEmail;
		this.compNum = compNum;
	}

	/************************  게터 세터  **************************/
	/***********************************************************/
	public String getAdminId() { return adminId; }
	public void setAdminId(String adminId) { this.adminId = adminId; }
	public String getAdminPw() { return adminPw; }
	public void setAdminPw(String adminPw)
	{
		if (adminPw != null)
			this.adminPw = getSHA256(adminPw);
		else
			this.adminPw = null;
	}
	public String getAdminName() { return adminName; }
	public void setAdminName(String adminName) { this.adminName = adminName; }
	public String getAdminPhone() { return adminPhone; }
	public void setAdminPhone(String adminPhone) { this.adminPhone = adminPhone; }
	public String getAdminEmail() { return adminEmail; }
	public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
	public int getCompNum() { return compNum; }
	public void setCompNum(int compNum) { this.compNum = compNum; }
	public String getCompname() {return compname;}
	public void setCompname(String compname) {this.compname = compname;}
	/***********************************************************/
	
	/**
	 * 투스트링
	 */
	@Override
	public String toString()
	{
		return "AdminVO [adminId=" + adminId + ", adminPw="
				+ adminPw + ", adminName=" + adminName + ", adminPhone="
				+ adminPhone + ", adminEmail=" + adminEmail
				+ ", compNum=" + compNum + "]";
	}

	
}
