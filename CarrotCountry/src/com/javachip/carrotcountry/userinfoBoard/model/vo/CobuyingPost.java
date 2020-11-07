package com.javachip.carrotcountry.userinfoBoard.model.vo;

import java.sql.Date;

public class CobuyingPost {
	
	private int postNo;			//번호
	private String postName;	// 제목
	private Date postEnrollDate;
	private int postViews;
	private String blindCheck;
	private int gpPostCheck;
	private int memNo;
	
	
	public CobuyingPost(int postNo, String postName, Date postEnrollDate, int postViews, String blindCheck,
			int gpPostCheck, int memNo) {
		super();
		this.postNo = postNo;
		this.postName = postName;
		this.postEnrollDate = postEnrollDate;
		this.postViews = postViews;
		this.blindCheck = blindCheck;
		this.gpPostCheck = gpPostCheck;
		this.memNo = memNo;
	}
	
	
	
	
	public CobuyingPost(int postNo, String postName, Date postEnrollDate, int postViews) {
		super();
		this.postNo = postNo;
		this.postName = postName;
		this.postEnrollDate = postEnrollDate;
		this.postViews = postViews;
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
	public Date getPostEnrollDate() {
		return postEnrollDate;
	}
	public void setPostEnrollDate(Date postEnrollDate) {
		this.postEnrollDate = postEnrollDate;
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
	public int getGpPostCheck() {
		return gpPostCheck;
	}
	public void setGpPostCheck(int gpPostCheck) {
		this.gpPostCheck = gpPostCheck;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	
	
	@Override
	public String toString() {
		return "CobuyingPost [postNo=" + postNo + ", postName=" + postName + ", postEnrollDate=" + postEnrollDate
				+ ", postViews=" + postViews + ", blindCheck=" + blindCheck + ", gpPostCheck=" + gpPostCheck
				+ ", memNo=" + memNo + "]";
	}
	
	
	
	
}
