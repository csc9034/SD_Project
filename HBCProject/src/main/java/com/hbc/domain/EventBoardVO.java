package com.hbc.domain;

import java.util.Date;

public class EventBoardVO {

	private int num;
	private String title;
	private String content;
	private String paylink;
	private String applylink;
	private Date regdate;
	private Date moddate;
	private String adminId;
	private int viewcnt;

	public EventBoardVO() {
		super();
	}

	public EventBoardVO(int num, String title, String content, String paylink, String applylink, Date regdate,
			Date moddate, String adminId, int viewcnt) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.paylink = paylink;
		this.applylink = applylink;
		this.regdate = regdate;
		this.moddate = moddate;
		this.adminId = adminId;
		this.viewcnt = viewcnt;
	}

	public String getpaylink() {
		return paylink;
	}

	public void setpaylink(String paylink) {
		this.paylink = paylink;
	}

	public String getapplylink() {
		return applylink;
	}

	public void setapplylink(String applylink) {
		this.applylink = applylink;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "EventBoardVO [num=" + num + ", title=" + title + ", content=" + content + ", paylink=" + paylink
				+ ", applylink=" + applylink + ", regdate=" + regdate + ", moddate=" + moddate + ", adminId=" + adminId
				+ ", viewcnt=" + viewcnt + "]";
	}

}