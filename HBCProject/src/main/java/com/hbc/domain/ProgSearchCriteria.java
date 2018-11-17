package com.hbc.domain;

public class ProgSearchCriteria extends Criteria{

	private String categorize;
	private String compnums;
	private String searchType;
	private String keyword;
	
	
	
	
	public String getCompnums() {
		return compnums;
	}
	public void setCompnums(String compnums) {
		this.compnums = compnums;
	}
	public String getCategorize() {
		return categorize;
	}
	public void setCategorize(String categorize) {
		this.categorize = categorize;
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
	@Override
	public String toString() {
		return "SearchCriteria [categorize=" + categorize + ", compnums=" + compnums + ", searchType=" + searchType
				+ ", keyword=" + keyword + "]";
	}
	
	
	
}

