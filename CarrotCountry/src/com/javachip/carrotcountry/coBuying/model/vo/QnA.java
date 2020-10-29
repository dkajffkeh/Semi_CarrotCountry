package com.javachip.carrotcountry.coBuying.model.vo;

import java.sql.Date;

public class QnA {
	
	private int gqNo;
	private String memNo;
	private int postNo;
	private String gqContent;
	private String gqAnswer;
	private int gqViews;
	private Date gqEnrollDate;
	
	
	public QnA() {}

	
	
	
	

	public QnA(int gqNo, String memNo, String gqContent, int gqViews, Date gqEnrollDate) {
		super();
		this.gqNo = gqNo;
		this.memNo = memNo;
		this.gqContent = gqContent;
		this.gqViews = gqViews;
		this.gqEnrollDate = gqEnrollDate;
	}






	public QnA(int gqNo, String memNo, int postNo, String gqContent, String gqAnswer, int gqViews, Date gqEnrollDate) {
		super();
		this.gqNo = gqNo;
		this.memNo = memNo;
		this.postNo = postNo;
		this.gqContent = gqContent;
		this.gqAnswer = gqAnswer;
		this.gqViews = gqViews;
		this.gqEnrollDate = gqEnrollDate;
	}


	public int getGqNo() {
		return gqNo;
	}


	public void setGqNo(int gqNo) {
		this.gqNo = gqNo;
	}


	public String getMemNo() {
		return memNo;
	}


	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public String getGqContent() {
		return gqContent;
	}


	public void setGqContent(String gqContent) {
		this.gqContent = gqContent;
	}


	public String getGqAnswer() {
		return gqAnswer;
	}


	public void setGqAnswer(String gqAnswer) {
		this.gqAnswer = gqAnswer;
	}


	public int getGqViews() {
		return gqViews;
	}


	public void setGqViews(int gqViews) {
		this.gqViews = gqViews;
	}


	public Date getGqEnrollDate() {
		return gqEnrollDate;
	}


	public void setGqEnrollDate(Date gqEnrollDate) {
		this.gqEnrollDate = gqEnrollDate;
	}


	@Override
	public String toString() {
		return "QnA [gqNo=" + gqNo + ", memNo=" + memNo + ", postNo=" + postNo + ", gqContent=" + gqContent
				+ ", gqAnswer=" + gqAnswer + ", gqViews=" + gqViews + ", gqEnrollDate=" + gqEnrollDate + "]";
	}
	
	
	
	
	

}
