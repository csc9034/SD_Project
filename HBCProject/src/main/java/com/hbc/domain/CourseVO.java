package com.hbc.domain;

/**
 * 과목 테이블의 필요한 변수들을 정의해 놓은 CourseVO 클래스
 * @author CHO
 *
 */
public class CourseVO extends EmployeeVO{
	
	// 1. 멤버 변수 선언
	private int cournum;
	private String courname;
	private int empnum;

	// 2. setter, getter 선언
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
	
	// 3. toString() 오버라이딩
	@Override
	public String toString() {
		return "CourseVO [cournum=" + cournum + ", courname=" + courname + ", empnum=" + empnum + "]";
	}

}
