package com.hbc.dto;

/**
 * 과목 테이블에서 해당 기관의 과목을 누가 담당하는지를 조회하기 위해 필요한 속성의 변수들을 정의한 클래스
 * 
 * @author CHO
 *
 */
public class CourseDTO {

	private int cournum;
	private String courname;
	private int empnum;
	private String empname;
	private int compnum;
	private String compname;

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

	public int getEmpnum() {
		return empnum;
	}

	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
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

	@Override
	public String toString() {
		return "CourseDTO [cournum=" + cournum + ", courname=" + courname + ", empnum=" + empnum + ", empname="
				+ empname + ", compnum=" + compnum + ", compname=" + compname + "]";
	}

}
