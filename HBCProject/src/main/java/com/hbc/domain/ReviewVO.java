package com.hbc.domain;

import java.util.Date;
/**
 * reviewVO
 * @author 이동희
 *
 */
public class ReviewVO {
	
//	CREATE TABLE TBL_COURREVIEW
//	(
//	   ADMINID              VARCHAR2(15) NOT NULL -- 작성자
//	  , REVIEWNUM            NUMBER NOT NULL -- 글번호
//	  , COURNUM              NUMBER NOT NULL -- 과목번호
//	  , REREGDATE            DATE DEFAULT SYSDATE NOT NULL -- 등록일
//	  , REMODDATE            DATE NULL -- 수정일
//	  , REVIEWTITLE          VARCHAR2(50) NOT NULL -- 제목
//	  , REVIEWTEXT           VARCHAR2(4000) NOT NULL -- 내용
//	  , REVIEWCNT            NUMBER DEFAULT 0 NOT NULL  -- 조회수
//	  , CONSTRAINT PK_TBL_COURREVIEW_REVIEWNUM PRIMARY KEY (REVIEWNUM)
//	  , CONSTRAINT FK_TBL_COURREVIEW_COURNUM FOREIGN KEY (COURNUM)
//	                                          REFERENCES TBL_COURSE (COURNUM)
//	  , CONSTRAINT FK_TBL_COURREVIEW_ADMINID FOREIGN KEY (ADMINID)
//	                                          REFERENCES TBL_ADMIN (ADMINID)
//	)
//	;
	
	/** 게시물 번호 */
	private int reviewNum;
	/** 게시물 제목 */
	private String reviewTitle;
	/** 게시물 내용*/
	private String reviewText;
	/** 조회 수*/
	private int reviewCnt;
	/** 작성일 */
	private Date reRegDate;
	/** 작성자 */
	private String adminId;
	/** 강좌 번호 */
	private int courNum;
	/** 강좌 이름 */
	private String courName;
	/** 기관 번호 */
	private int compNum;
	/** 기관 이름 */
	private String compName;
	/** 강사 이름 */
	private String empName;
	/** 링크주소 */
	private String uri;

	
	// 생성자 선언
	public ReviewVO() {
	}


	public ReviewVO(int reviewNum, String reviewTitle, String reviewText, int reviewCnt, Date reRegDate, String adminId,
			int courNum, String courName, int compNum, String compName, String empName) {
		super();
		this.reviewNum = reviewNum;
		this.reviewTitle = reviewTitle;
		this.reviewText = reviewText;
		this.reviewCnt = reviewCnt;
		this.reRegDate = reRegDate;
		this.adminId = adminId;
		this.courNum = courNum;
		this.courName = courName;
		this.compNum = compNum;
		this.compName = compName;
		this.empName = empName;
		
	}


	// 접근자 / 수정자 선언
	
	public int getReviewNum() {
		return reviewNum;
	}




	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getReviewText() {
		return reviewText;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public int getReviewCnt() {
		return reviewCnt;
	}


	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}


	public Date getReRegDate() {
		return reRegDate;
	}


	public void setReRegDate(Date reRegDate) {
		this.reRegDate = reRegDate;
	}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public int getCourNum() {
		return courNum;
	}


	public void setCourNum(int courNum) {
		this.courNum = courNum;
	}
	
	
	public String getCourName() {
		return courName;
	}


	public void setCourName(String courName) {
		this.courName = courName;
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

	public String getEmpName() {
		return empName;
	}
	
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	// toString 선언
	@Override
	public String toString() {
		return "ReviewVO [reviewNum=" + reviewNum + ", reviewTitle=" + reviewTitle + ", reviewText=" + reviewText
				+ ", reviewCnt=" + reviewCnt + ", reRegDate=" + reRegDate + ", adminId=" + adminId + ", courNum="
				+ courNum + ", courName=" + courName + ", compNum=" + compNum + ", compName=" + compName + ", empName="
				+ empName + ", uri=" + uri + "]";
	}


}
