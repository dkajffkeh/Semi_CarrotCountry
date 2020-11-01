package com.javachip.carrotcountry.adminBoard.model.vo;

import java.sql.Date;

public class AdminBoard {
	
	private int postNo;
	private String categoryName;
	private String memNo;
	private String postName;
	private Date postEnrollDate;
	private int postReports;
	private int postViews;
	private String blindCheck;
	private int usedPostCheck;
	private int gpPostCheck;
	
	public AdminBoard() {}

	public AdminBoard(int postNo, String categoryName, String memNo, String postName, Date postEnrollDate,
			int postReports, int postViews, String blindCheck) {
		super();
		this.postNo = postNo;
		this.categoryName = categoryName;
		this.memNo = memNo;
		this.postName = postName;
		this.postEnrollDate = postEnrollDate;
		this.postReports = postReports;
		this.postViews = postViews;
		this.blindCheck = blindCheck;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getPostEnrollDate() {
		return postEnrollDate;
	}

	public void setPostEnrollDate(Date postEnrollDate) {
		this.postEnrollDate = postEnrollDate;
	}

	public int getPostReports() {
		return postReports;
	}

	public void setPostReports(int postReports) {
		this.postReports = postReports;
	}

	public int getPostViews() {
		return postViews;
	}

	public void setPostViews(int postViews) {
		this.postViews = postViews;
	}

	public String getBlindCheck() {
		return blindCheck;
	}

	public void setBlindCheck(String blindCheck) {
		this.blindCheck = blindCheck;
	}

	public int getUsedPostCheck() {
		return usedPostCheck;
	}

	public void setUsedPostCheck(int usedPostCheck) {
		this.usedPostCheck = usedPostCheck;
	}

	public int getGpPostCheck() {
		return gpPostCheck;
	}

	public void setGpPostCheck(int gpPostCheck) {
		this.gpPostCheck = gpPostCheck;
	}

	@Override
	public String toString() {
		return "AdminBoard [postNo=" + postNo + ", categoryName=" + categoryName + ", memNo=" + memNo + ", postName="
				+ postName + ", postEnrollDate=" + postEnrollDate + ", postReports=" + postReports + ", postViews="
				+ postViews + ", blindCheck=" + blindCheck + ", usedPostCheck=" + usedPostCheck + ", gpPostCheck="
				+ gpPostCheck + "]";
	}
	
}
