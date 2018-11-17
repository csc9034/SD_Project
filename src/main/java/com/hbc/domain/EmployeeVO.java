package com.hbc.domain;

public class EmployeeVO {

//	EMPNUM		NUMBER				No		1
//	EMPNAME		VARCHAR2(16 BYTE)	No		2
//	EMPPHONE	CHAR(11 BYTE)		No		3
//	EMPEMAIL	VARCHAR2(50 BYTE)	No		4
//	POSITION	VARCHAR2(60 BYTE)	No		5
//	SNSLINK1	VARCHAR2(30 BYTE)	Yes		6
//	SNSLINK2	VARCHAR2(30 BYTE)	Yes		7
//	SNSLINK3	VARCHAR2(30 BYTE)	Yes		8
//	COMPNUM		NUMBER				No		9
//	IMGNAME		VARCHAR2(200 BYTE)	Yes		10
//	EMPDESC		VARCHAR2(4000 BYTE)	Yes		11
	
	
	// 멤버변수 선언부
	private int empnum;
	private String empname;
	private String empphone;
	private String empemail;
	private String position;
	private String snslink1;
	private String snslink2;
	private String snslink3;
	private int compnum;
	private int filenum;
	private String empdesc;
	
	private String[] files;
	
	private String compname;
	
	// 생성자 선언부
	public EmployeeVO() {
		super();
	}
	
	public EmployeeVO(int empnum) {
		super();
		this.empnum = empnum;
	}

	public EmployeeVO(int empnum, String empname, String position) {
		super();
		this.empnum = empnum;
		this.empname = empname;
		this.position = position;
	}
	
	public EmployeeVO(String empname, String empphone, String empemail, String position, int compnum) {
		super();
		this.empname = empname;
		this.empphone = empphone;
		this.empemail = empemail;
		this.position = position;
		this.compnum = compnum;
	}

	public EmployeeVO(int empnum, String empname, String empphone, String empemail, String position, String snslink1,
			String snslink2, String snslink3, int compnum, int filenum, String empdesc) {
		super();
		this.empnum = empnum;
		this.empname = empname;
		this.empphone = empphone;
		this.empemail = empemail;
		this.position = position;
		this.snslink1 = snslink1;
		this.snslink2 = snslink2;
		this.snslink3 = snslink3;
		this.compnum = compnum;
		this.setFilenum(filenum);
		this.empdesc = empdesc;
	}

	// 접근수정자 선언부
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
	public String getEmpphone() {
		return empphone;
	}
	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSnslink1() {
		return snslink1;
	}
	public void setSnslink1(String snslink1) {
		this.snslink1 = snslink1;
	}
	public String getSnslink2() {
		return snslink2;
	}
	public void setSnslink2(String snslink2) {
		this.snslink2 = snslink2;
	}
	public String getSnslink3() {
		return snslink3;
	}
	public void setSnslink3(String snslink3) {
		this.snslink3 = snslink3;
	}
	public int getCompnum() {
		return compnum;
	}
	public void setCompnum(int compnum) {
		this.compnum = compnum;
	}
	public String getEmpdesc() {
		return empdesc;
	}
	public void setEmpdesc(String empdesc) {
		this.empdesc = empdesc;
	}
	
	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	// 지원메소드 선언부
	@Override
	public String toString() {
		return "EmployeeVO [empnum=" + empnum + ", empname=" + empname + ", empphone=" + empphone + ", empemail="
				+ empemail + ", position=" + position + ", snslink1=" + snslink1 + ", snslink2=" + snslink2
				+ ", snslink3=" + snslink3 + ", compnum=" + compnum + ", filenum=" + getFilenum() + ", empdesc=" + empdesc
				+ ", files=" + files + "]";
	}

	public int getFilenum() {
		return filenum;
	}

	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	
	
	
	
}
