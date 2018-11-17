package com.hbc.domain;

import java.util.Date;

/**
 * 수강 테이블의 필요한 변수들을 정의해 놓은 ApplyVO 클래스
 * 
 * @author CHO
 *
 */
public class ApplyVO extends CourseVO{
	
	// 1. 변수 선언
	private int appnum;
	private Date sdate;
	private Date edate;
	private String dayinfo;
	private String price;
	private String link;
	private String spec;
	private int cournum;
	private String stuid;
	private String stuname;
	
	
	// 2. setter, getter 선언
	public int getAppnum() {
		return appnum;
	}

	public void setAppnum(int appnum) {
		this.appnum = appnum;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}
	

	public String getDayinfo() {
		return dayinfo;
	}

	public void setDayinfo(String dayinfo) {
		this.dayinfo = dayinfo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getCournum() {
		return cournum;
	}

	public void setCournum(int cournum) {
		this.cournum = cournum;
	}
	
	
	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	// 3. toString() 오버라이딩
	@Override
	public String toString() {
		return "ApplyVO [appnum=" + appnum + ", sdate=" + sdate + ", edate=" + edate + ", dayinfo=" + dayinfo
				+ ", price=" + price + ", link=" + link + ", spec=" + spec + ", cournum=" + cournum + ", stuid=" + stuid
				+ ", stuname=" + stuname + "]";
	}

	

}
