package com.hbc.domain;

import java.util.Date;

public class GalleryFileVO {

	private String name;
	private Date regdate;
	private int galnum;
	
	public GalleryFileVO() {
		
	}
	
	public GalleryFileVO(String name, Date regdate, int galnum) {
		super();
		this.name = name;
		this.regdate = regdate;
		this.galnum = galnum;
	}

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

	public int getGalnum() {
		return galnum;
	}

	public void setGalnum(int galnum) {
		this.galnum = galnum;
	}

	@Override
	public String toString() {
		return "GalleryFileVO [name=" + name + ", regdate=" + regdate + ", galnum=" + galnum + "]";
	}
	
	
}
