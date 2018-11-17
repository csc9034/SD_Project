package com.hbc.domain;

import java.util.Date;

public class ProgramVO {
	Integer intronum;
	String title;
	String content;
	Integer category;
	Date regdate;
	Date moddate;
	String link;
    String adminId;
    Integer compnum;
	String compname;
	String name;
	
	public Integer getIntronum() {
		return intronum;
	}
	public void setIntronum(Integer intronum) {
		this.intronum = intronum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public Integer getCompnum() {
		return compnum;
	}
	public void setCompnum(Integer compnum) {
		this.compnum = compnum;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProgramVO [intronum=" + intronum + ", title=" + title + ", content=" + content + ", category="
				+ category + ", regdate=" + regdate + ", moddate=" + moddate + ", link=" + link + ", adminid=" + adminId
				+ ", compnum=" + compnum + ", compname=" + compname + ", name=" + name + "]";
	}
	
	
	
	
	
	
}
