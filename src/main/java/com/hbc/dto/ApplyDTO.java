package com.hbc.dto;

/**
 * 수강 테이블에서 해당 기관의 과목을 조회하기 위해 필요한 속성의 변수들을 정의한 클래스
 * 
 * @author CHO
 *
 */
public class ApplyDTO {

	private int appnum;
	private int cournum;
	private String courname;
	private int compnum;
	private String compname;
	private String stuid;
	private String stuname;

	public int getAppnum() {
		return appnum;
	}

	public void setAppnum(int appnum) {
		this.appnum = appnum;
	}

	public int getCournum() {
		return cournum;
	}

	public void setCournum(int cournum) {
		this.cournum = cournum;
	}

	public String getCourname() {
		return courname;
	}

	public void setCourname(String courname) {
		this.courname = courname;
	}

	public int getCompnum() {
		return compnum;
	}

	public void setCompnum(int compnum) {
		this.compnum = compnum;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	@Override
	public String toString() {
		return "ApplyDTO [appnum=" + appnum + ", cournum=" + cournum + ", courname=" + courname + ", compnum=" + compnum
				+ ", compname=" + compname + ", stuid=" + stuid + ", stuname=" + stuname + "]";
	}

}
