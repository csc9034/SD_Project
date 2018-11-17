package com.hbc.dto;

import static com.hbc.util.SHA256.getSHA256;

public class LoginDTO {

	private String adminid;
	private String adminpw;
	private boolean useCookie;
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminpw() {
		return adminpw;
	}
	/** 
	 * dto에 값 넣을 때 SHA256 형태로 넣도록 해놨음 
	 * 문제 생기면 이 곳을 수정
	 * */
	public void setAdminpw(String adminpw) {
		this.adminpw = getSHA256(adminpw);
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [adminid=" + adminid + ", adminpw=" + adminpw + ", useCookie=" + useCookie + "]";
	}
	
	
}
