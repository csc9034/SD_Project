package com.hbc.domain;

import java.util.Date;

/**
 * 첨부파일에 대한 VO (DB: TBL_IMG_FILE)
 * @author 김소민
 *
 */
public class ImgFileVO {
	/**
	 * 첨부이미지 fullName
	 */
	private String name;
	private Date regdate;
	/**
	 * 이미지가 대표이미지인지 추가 이미지 인지
	 * 대표이미지여부 대표사진 : 1, 아닐때 : 0
	 */
	private String main;
	/**
	 * TBL_IMG_BOARD의 PK인 IMGNUM이 FK로 들어옴
	 */
	private Integer num;
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
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "ImgFileVO [name=" + name + ", regdate=" + regdate + ", main=" + main + ", num=" + num + "]";
	}
	
	
	
}
