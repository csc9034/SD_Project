package com.hbc.domain;

import static com.hbc.util.SHA256.getSHA256;

public class StudentVO extends CompanyVO {

	private String stuid;
	private String stupw;
	private String stuname;
	private String stuemail;
	private String stuphone;
	private int compnum;
	
	
	public StudentVO() {
		super();
	}

	public StudentVO(String stuid, String stupw, String stuname, String stuemail, String stuphone, int compnum) {
		super();
		this.stuid = stuid;
		if (stupw != null) {
			this.stupw = getSHA256(stupw);
		} else {
			this.stupw = null;
		}
		this.stuname = stuname;
		this.stuemail = stuemail;
		this.stuphone = stuphone;
		this.compnum = compnum;
	}

	public int getCompnum() {
		return compnum;
	}

	public void setCompnum(int compnum) {
		this.compnum = compnum;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStupw() {
		return stupw;
	}

	public void setStupw(String stupw) {
		if (stupw != null)
			this.stupw = getSHA256(stupw);
		else
			this.stupw = null;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStuemail() {
		return stuemail;
	}

	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}

	public String getStuphone() {
		return stuphone;
	}

	public void setStuphone(String stuphone) {
		this.stuphone = stuphone;
	}

	@Override
	public String toString() {
		return "StudentVO [stuid=" + stuid + ", stupw=" + stupw + ", stuname=" + stuname + ", stuemail=" + stuemail
				+ ", stuphone=" + stuphone + ", compnum=" + compnum + "]";
	}


}
