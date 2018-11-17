package com.hbc.dto;

import static com.hbc.util.SHA256.getSHA256;

public class StudentLoginDTO {

	private String stuid;
	private String stupw;
	private boolean useCookie;
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStupw() {
		return stupw;
	}
	/** 
	 * dto에 값 넣을 때 SHA256 형태로 넣도록 해놨음 
	 * 문제 생기면 이 곳을 수정
	 * */
	public void setStupw(String stupw) {
		this.stupw = getSHA256(stupw);
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [adminid=" + stuid + ", adminpw=" + stupw + ", useCookie=" + useCookie + "]";
	}
	
	
}
