package com.hbc.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	private int startPage;
	private int pageCotorller;

	public Criteria() {

		this.page = 1;
		this.perPageNum = 10;

		setPageCotorller(perPageNum);
	}

	public int getPageCotorller() {
		return pageCotorller;
	}

	public void setPageCotorller(int pageCotorller) {

		// 들어오는 perPageNum에 따라서 설정하기
		this.pageCotorller = pageCotorller - 1;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {

		this.perPageNum = perPageNum;

		// perPageNum 수정 시 pageController 설정
		setPageCotorller(perPageNum);

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;

	}

	public int getPageEnd() {
		return this.startPage + pageCotorller;
	}

	public int getPageStart() {
		this.startPage = (this.page * perPageNum) - pageCotorller;

		return this.startPage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startPage=" + startPage + "]";
	}

}
