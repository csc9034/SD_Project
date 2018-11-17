package com.hbc.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ProgPageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 10;

	private Criteria cri;


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;

		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	}

	public String makeQuery(int page) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum()).build();

		return uriComponents.toUriString();
	}

	public String makeSearch(int page) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((ProgSearchCriteria) cri).getSearchType())
				.queryParam("keyword", ((ProgSearchCriteria) cri).getKeyword()).build();

		return uriComponents.toUriString();
	}
	
	// 사이드 메뉴 바꿀 때 page 정보를 넘기지 않기 위해 추가함
	public String makeSearchs(int page) {

		UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance().queryParam("perPageNum", cri.getPerPageNum());


		return uriComponents.toUriString();
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
}