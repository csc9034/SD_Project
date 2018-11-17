package com.hbc.dto;

/**
 * 관리자를 등록할때
 * 셀렉트박스를 출력하기 위해
 * 데이터를 전송하는 클래스
 * @author 진재환
 *
 */
public class CompanyDTO
{
	// 기관 번호
	private int compNum;
	// 기관이름
	private String compName;

	/**
	 * 기본 생성자
	 */
	public CompanyDTO()
	{
		super();
	}

	/**
	 * 매개변수가 있는 생성자
	 * @param compNum
	 * @param compName
	 */
	public CompanyDTO(int compNum, String compName)
	{
		super();
		this.compNum = compNum;
		this.compName = compName;
	}
	
	/****************************  게터 세터  ********************************/
	/************************************ ********************************/
	public int getCompNum() { return compNum; }
	public void setCompNum(int compNum) { this.compNum = compNum; }
	public String getCompName() { return compName; }
	public void setCompName(String compName) { this.compName = compName; }
	/************************************ ********************************/
	
	/**
	 * 투스트링
	 */
	@Override
	public String toString()
	{
		return "CompanyDTO [compNum=" + compNum + ", compName="
				+ compName + "]";
	}
}