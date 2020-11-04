package com.javachip.carrotcountry.userinfoBoardNg.model.vo;

public class RepPageInfo {

	private int repListCount;
	private int repCurrentPage;
	private int repPageLimit;
	private int repBoardLimit;
	
	private int repMaxPage;
	private int repStartPage;
	private int repEndPage;
	
	// 기본생성자
	public RepPageInfo() {}

	// 매개변수생성자 (전체)
	public RepPageInfo(int repListCount, int repCurrentPage, int repPageLimit, int repBoardLimit, int repMaxPage,
			int repStartPage, int repEndPage) {
		super();
		this.repListCount = repListCount;
		this.repCurrentPage = repCurrentPage;
		this.repPageLimit = repPageLimit;
		this.repBoardLimit = repBoardLimit;
		this.repMaxPage = repMaxPage;
		this.repStartPage = repStartPage;
		this.repEndPage = repEndPage;
	}

	// setter/getter 메소드
	public int getRepListCount() {
		return repListCount;
	}

	public void setRepListCount(int repListCount) {
		this.repListCount = repListCount;
	}

	public int getRepCurrentPage() {
		return repCurrentPage;
	}

	public void setRepCurrentPage(int repCurrentPage) {
		this.repCurrentPage = repCurrentPage;
	}

	public int getRepPageLimit() {
		return repPageLimit;
	}

	public void setRepPageLimit(int repPageLimit) {
		this.repPageLimit = repPageLimit;
	}

	public int getRepBoardLimit() {
		return repBoardLimit;
	}

	public void setRepBoardLimit(int repBoardLimit) {
		this.repBoardLimit = repBoardLimit;
	}

	public int getRepMaxPage() {
		return repMaxPage;
	}

	public void setRepMaxPage(int repMaxPage) {
		this.repMaxPage = repMaxPage;
	}

	public int getRepStartPage() {
		return repStartPage;
	}

	public void setRepStartPage(int repStartPage) {
		this.repStartPage = repStartPage;
	}

	public int getRepEndPage() {
		return repEndPage;
	}

	public void setRepEndPage(int repEndPage) {
		this.repEndPage = repEndPage;
	}

	// toString 메소드
	@Override
	public String toString() {
		return "repPageInfo [repListCount=" + repListCount + ", repCurrentPage=" + repCurrentPage + ", repPageLimit="
				+ repPageLimit + ", repBoardLimit=" + repBoardLimit + ", repMaxPage=" + repMaxPage + ", repStartPage="
				+ repStartPage + ", repEndPage=" + repEndPage + "]";
	}
	
	
	
	
}
