package com.hbc.domain;

public class MainEventVO extends EventBoardVO{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MainEventVO [name=" + name + "]";
	}
	
	
	
}
