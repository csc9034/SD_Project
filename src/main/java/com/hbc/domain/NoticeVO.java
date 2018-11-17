package com.hbc.domain;

import java.util.Arrays;
import java.util.Date;

public class NoticeVO {

	private Integer noNum;
	private String noTitle;
	private String noText;
	private int noKeyword;
	private Date noRegDate;
	private Date noModDate;
	private int noViewCnt;
	private String adminId;
	private String[] files;
	private String[] links;
	private String[] imgFileNames;

	public Integer getNoNum() {
		return noNum;
	}

	public void setNoNum(Integer noNum) {
		this.noNum = noNum;
	}

	public String getNoTitle() {
		return noTitle;
	}

	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}

	public String getNoText() {
		return noText;
	}

	public void setNoText(String noText) {
		this.noText = noText;
	}

	public int getNoKeyword() {
		return noKeyword;
	}

	public void setNoKeyword(int noKeyword) {
		this.noKeyword = noKeyword;
	}

	public Date getNoRegDate() {
		return noRegDate;
	}

	public void setNoRegDate(Date noRegDate) {
		this.noRegDate = noRegDate;
	}

	public Date getNoModDate() {
		return noModDate;
	}

	public void setNoModDate(Date noModDate) {
		this.noModDate = noModDate;
	}

	public int getNoViewCnt() {
		return noViewCnt;
	}

	public void setNoViewCnt(int noViewCnt) {
		this.noViewCnt = noViewCnt;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}
	
	public String[] getImgFileNames() {
		return imgFileNames;
	}

	public void setImgFileNames(String[] imgFileNames) {
		this.imgFileNames = imgFileNames;
	}

	@Override
	public String toString() {
		return "NoticeVO [noNum=" + noNum + ", noTitle=" + noTitle + ", noText=" + noText + ", noKeyword=" + noKeyword
				+ ", noRegDate=" + noRegDate + ", noModDate=" + noModDate + ", noViewCnt=" + noViewCnt + ", adminId="
				+ adminId + ", files=" + Arrays.toString(files) + ", links=" + Arrays.toString(links)
				+ ", imgFileNames=" + Arrays.toString(imgFileNames) + "]";
	}
	
}
