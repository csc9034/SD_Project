package com.hbc.domain;

import java.util.Date;

/**
 * NewsVO
 * @author 전현찬,윤홍식
 *
 */
public class NewsVO {
	
	/** 보도자료 번호 */
	private int newsNum;
	/** 보도자료 작성일 */
	private Date newsRegDate;
	/** 보도자료 수정일 */
	private Date newsModDate;
	/** 보도자료 제목 */
	private String newsTitle;
	/** 보도자료 내용 */
	private String newsText;
	/** 보도자료 조회수 */
	private int newsViewCnt;
	/** 보도자료 작성자 */
	private String adminId;
	/** 업로드 파일*/
	private String fileName;
	/** 뉴스링크 */
	private String newsLink;
	
	
	// getter, setter 생성
	public int getNewsNum() {
		return newsNum;
	}
	public void setNewsNum(int newsNum) {
		this.newsNum = newsNum;
	}
	public Date getNewsRegDate() {
		return newsRegDate;
	}
	public void setNewsRegDate(Date newsRegDate) {
		this.newsRegDate = newsRegDate;
	}
	public Date getNewsModDate() {
		return newsModDate;
	}
	public void setNewsModDate(Date newsModDate) {
		this.newsModDate = newsModDate;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsText() {
		return newsText;
	}
	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}
	public int getNewsViewCnt() {
		return newsViewCnt;
	}
	public void setNewsViewCnt(int newsViewCnt) {
		this.newsViewCnt = newsViewCnt;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "NewsVO [newsNum=" + newsNum + ", newsRegDate=" + newsRegDate + ", newsModDate=" + newsModDate
				+ ", newsTitle=" + newsTitle + ", newsText=" + newsText + ", newsViewCnt=" + newsViewCnt + ", adminId="
				+ adminId + ", fileName=" + fileName + ", newsLink=" + newsLink + "]";
	}



	

}
