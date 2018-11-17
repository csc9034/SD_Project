package com.hbc.domain;

import java.util.Date;

public class VideoBoardVO {

	/**
		이름      널?       유형             
		------- -------- -------------- 
		NUM     NOT NULL NUMBER         
		TITLE   NOT NULL VARCHAR2(90)   
		LINK    NOT NULL VARCHAR2(4000) 
		REGDATE NOT NULL DATE           
		MODDATE          DATE           
		CONTENT          VARCHAR2(2000) 
		VIEWCNT NOT NULL NUMBER         
		ADMINID NOT NULL VARCHAR2(15)   
	 */
	
	
	private int num;
	

	private String title;
	private String link;
	private Date regdate;
	private Date moddate;
	private String content;
	private int viewcnt;
	private String adminid;
	private int compnum;
	private String compname;
	

	
	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public VideoBoardVO() {
		super();
	}

	public VideoBoardVO(int num, String title, String link, Date regdate, int viewcnt, String adminid) {
		super();
		this.num = num;
		this.title = title;
		this.link = link;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.adminid = adminid;
	}

	public VideoBoardVO(int num, String title, String link, Date regdate, Date moddate, String content, int viewcnt,
			String adminid) {
		super();
		this.num = num;
		this.title = title;
		this.link = link;
		this.regdate = regdate;
		this.moddate = moddate;
		this.content = content;
		this.viewcnt = viewcnt;
		this.adminid = adminid;
	}
	
	
	public int getCompnum() {
		return compnum;
	}

	public void setCompnum(int compnum) {
		this.compnum = compnum;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getmoddate() {
		return moddate;
	}

	public void setmoddate(Date moddate) {
		this.moddate = moddate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "VideoBoardVO [num=" + num + ", title=" + title + ", link=" + link + ", regdate=" + regdate
				+ ", moddate=" + moddate + ", content=" + content + ", viewcnt=" + viewcnt + ", adminid=" + adminid
				+ ", compnum=" + compnum + ", compname=" + compname + "]";
	}

}
