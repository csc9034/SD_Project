package com.hbc.dto;

import java.util.Date;

public class EmpFileDTO {

	private int filenum;
	private String name;
	private Date regdate;
	
	public EmpFileDTO() {
		super();
	}

	public EmpFileDTO(String name) {
		super();
		this.name = name;
	}


	public EmpFileDTO(int filenum, String name) {
		super();
		this.filenum = filenum;
		this.name = name;
	}
	
	
	public EmpFileDTO(int filenum, String name, Date regdate) {
		super();
		this.filenum = filenum;
		this.name = name;
		this.regdate = regdate;
	}


	public int getFilenum() {
		return filenum;
	}
	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "EmpFileDTO [filenum=" + filenum + ", name=" + name + ", regdate=" + regdate + "]";
	}
	
	
	
}
