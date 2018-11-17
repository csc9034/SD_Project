package com.hbc.domain;

public class SearchCriteria extends Criteria {

	private String searchType;
	private String keyword;
	private String listType;
	private String categorize;
	private String compnums;
	private String numType;

	// 윤홍식조 수강후기 검색기능 추가
	private int searchComp;
	private int searchCour;

	public int getsearchComp() {
		return searchComp;
	}

	public void setsearchComp(int searchComp) {
		this.searchComp = searchComp;
	}

	public int getsearchCour() {
		return searchCour;
	}

	public void setsearchCour(int searchCour) {
		this.searchCour = searchCour;
	}
	// 윤홍식조 추가 끝

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getCategorize() {
		return categorize;
	}

	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}

	public String getCompnums() {
		return compnums;
	}

	public void setCompnums(String compnums) {
		this.compnums = compnums;
	}

	public String getNumType() {
		return numType;
	}

	public void setNumType(String numType) {
		this.numType = numType;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", listType=" + listType
				+ ", categorize=" + categorize + ", compnums=" + compnums + ", numType=" + numType + ", searchComp="
				+ searchComp + ", searchCour=" + searchCour + "]";
	}

	
}

// public class SearchCriteria extends Criteria{
//
// private String searchType;
// private String keyword;
//
// public String getSearchType() {
// return searchType;
// }
// public void setSearchType(String searchType) {
// this.searchType = searchType;
// }
// public String getKeyword() {
// return keyword;
// }
// public void setKeyword(String keyword) {
// this.keyword = keyword;
// }
//
// @Override
// public String toString() {
// return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword +
// "]";
// }
//
//
//
// }
