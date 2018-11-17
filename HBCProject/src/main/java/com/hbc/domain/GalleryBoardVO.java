package com.hbc.domain;

import java.util.Arrays;
import java.util.Date;

public class GalleryBoardVO {
	private int galnum;
	private String title;
	private String content;
	private int viewcnt;
	private Date regdate;
	private Date moddate;
	private int compnum;
	private String adminId;
	private String name;

	/**
	 * 파일명
	 */
	private String[] files;

	// 선택한 기관 정보
	private String compname;

	public GalleryBoardVO() {

	}

	public GalleryBoardVO(int galnum, String title, String content, int viewcnt, Date regdate, Date moddate,
			int compnum, String adminId, String name, String[] files, String compname) {
		super();
		this.galnum = galnum;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.moddate = moddate;
		this.compnum = compnum;
		this.adminId = adminId;
		this.name = name;
		this.files = files;
		this.compname = compname;
	}

	public int getGalnum() {
		return galnum;
	}

	public void setGalnum(int galnum) {
		this.galnum = galnum;
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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
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

	public int getCompnum() {
		return compnum;
	}

	public void setCompnum(int compnum) {
		this.compnum = compnum;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	@Override
	public String toString() {
		return "GalleryBoardVO [galnum=" + galnum + ", title=" + title + ", content=" + content + ", viewcnt=" + viewcnt
				+ ", regdate=" + regdate + ", moddate=" + moddate + ", compnum=" + compnum + ", adminId=" + adminId
				+ ", name=" + name + ", files=" + Arrays.toString(files) + ", compname=" + compname + "]";
	}
	

}
