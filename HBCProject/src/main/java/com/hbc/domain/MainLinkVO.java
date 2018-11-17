package com.hbc.domain;

import java.util.Date;

/*
 * 이름       널?       유형            
-------- -------- ------------- 
COMPNUM  NOT NULL NUMBER        
LINKNAME NOT NULL VARCHAR2(200) 
REGDATE           DATE  
 */
public class MainLinkVO {
	private int compNum;
	//셀렉박스에 이름으로 출력
	private String compName; 
	private String linkName;
	private Date regdate;

	public MainLinkVO() {
		super();
	}

	public MainLinkVO(int compNum, String linkName, Date regdate) {
		super();
		this.compNum = compNum;
		this.linkName = linkName;
		this.regdate = regdate;
	}

	public int getCompNum() {
		return compNum;
	}

	public void setCompNum(int compNum) {
		this.compNum = compNum;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MainLinkVO [compNum=" + compNum + ", compName=" + compName + ", linkName=" + linkName + ", regdate="
				+ regdate + "]";
	}

}
