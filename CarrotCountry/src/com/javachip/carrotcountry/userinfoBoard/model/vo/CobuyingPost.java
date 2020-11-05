package com.javachip.carrotcountry.userinfoBoard.model.vo;

import java.sql.Date;

public class CobuyingPost {
	
	private int postNo;			//번호
	private String postName;	// 제목
	private Date gpCreateDate; //작성일
	private String gpStatus; 	//진행상태
	
	public CobuyingPost() {}

	public CobuyingPost(int postNo, String postName, Date gpCreateDate, String gpStatus) {
		super();
		this.postNo = postNo;
		this.postName = postName;
		this.gpCreateDate = gpCreateDate;
		this.gpStatus = gpStatus;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getGpCreateDate() {
		return gpCreateDate;
	}

	public void setGpCreateDate(Date gpCreateDate) {
		this.gpCreateDate = gpCreateDate;
	}

	public String getGpStatus() {
		return gpStatus;
	}

	public void setGpStatus(String gpStatus) {
		this.gpStatus = gpStatus;
	}

	@Override
	public String toString() {
		return "CobuyingPost [postNo=" + postNo + ", postName=" + postName + ", gpCreateDate=" + gpCreateDate
				+ ", gpStatus=" + gpStatus + "]";
	}

	
	
	
}
