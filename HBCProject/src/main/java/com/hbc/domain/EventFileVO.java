package com.hbc.domain;

public class EventFileVO {

	private int num;
	private String name;
	private int type;
	
	public EventFileVO() {

	}
	
	public EventFileVO(int num, String name, int type) {
		this.num = num;
		this.name = name;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EventFileVO [num=" + num + ", name=" + name + ", type=" + type + "]";
	}
	
}
