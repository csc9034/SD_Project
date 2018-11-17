package com.hbc.domain;

/**
 * 그룹정보변수 선언 클래스
 * 
 * @author PC382224
 *
 */
public class CompanyVO {
	// 오라클 데이터 베이스 데이터 변수 그대로 가져옴
	
	// 기관 번호
	private int compnum;
	// 기관명
	private String compname;
	// 우편번호
	private String zipcode;
	// 전화번호
	private String phone;
	// 주소
	private String frontaddr;
	// 상세주소
	private String rearaddr;
	// 기관 분야
	private String compfield;
	// 이미지 링크
	private String imglink;
	// 기관 상세설명
	private String compdesc;
	// 기관 대상
	private String target;
	// 기관 구분
	private int division;
	

	/*****************************  게터 세터  ******************************/
	/*******************************************************************/
	public int getCompnum() { return compnum; }
	public void setCompnum(int compnum) { this.compnum = compnum; }
	public String getCompname() { return compname; }
	public void setCompname(String compname) { this.compname = compname; }
	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getFrontaddr() { return frontaddr; }
	public void setFrontaddr(String frontaddr) { this.frontaddr = frontaddr; }
	public String getRearaddr() { return rearaddr; }
	public void setRearaddr(String rearaddr) { this.rearaddr = rearaddr; }
	public String getCompfield() { return compfield; }
	public void setCompfield(String compfield) { this.compfield = compfield; }
	public String getImglink() { return imglink; }
	public void setImglink(String imglink) { this.imglink = imglink; }
	public String getCompdesc() { return compdesc; }
	public void setCompdesc(String compdesc) { this.compdesc = compdesc; }
	public String getTarget() { return target; }
	public void setTarget(String target) { this.target = target; }
	public int getDivision() { return division; }
	public void setDivision(int division) { this.division = division; }
	/*******************************************************************/
	
	/**
	 * 투스트링
	 */
	@Override
	public String toString() {
		return "CompanyVO [compnum=" + compnum + ", compname=" + compname + ", zipcode=" + zipcode + ", phone=" + phone
				+ ", frontaddr=" + frontaddr + ", rearaddr=" + rearaddr + ", compfield=" + compfield + ", imglink="
				+ imglink + ", compdesc=" + compdesc + ", target=" + target + ", division=" + division + "]";
	}


}
