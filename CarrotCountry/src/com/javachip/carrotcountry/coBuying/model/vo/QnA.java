package com.javachip.carrotcountry.coBuying.model.vo;

import java.sql.Date;

public class QnA {
	
	private int gqNo;			// 문의번호
	private String memNo;		// 유저식별번호(유저아이디 받아와야돼서 String)
	private int postNo;			// 게시글번호
	private String gqContent;	// 문의내용
	private String gqAnswer;	// 문의답변
	private int gqViews;		// 조회수
	private Date gqEnrollDate;	// 등록일자
	private String gqStatus; // N/Y
	private String gqTitle; // 문의글제목
	
	
	public QnA() {}

	
	
	
	



	public QnA(int gqNo, String gqTitle, String memNo, Date gqEnrollDate, String gqContent) {
		super();
		this.gqNo = gqNo;
		this.gqTitle = gqTitle;
		this.memNo = memNo;
		this.gqEnrollDate = gqEnrollDate;
		this.gqContent = gqContent;
	}








	public QnA(int gqNo, String memNo, String gqTitle, int gqViews, Date gqEnrollDate) {
		super();
		this.gqNo = gqNo;
		this.memNo = memNo;
		this.gqEnrollDate = gqEnrollDate;
		this.gqTitle = gqTitle;
		this.gqViews = gqViews;
	}








	public QnA(int gqNo, String memNo, int postNo, String gqContent, String gqAnswer, int gqViews, Date gqEnrollDate,
			String gqStatus, String gqTitle) {
		super();
		this.gqNo = gqNo;
		this.memNo = memNo;
		this.postNo = postNo;
		this.gqContent = gqContent;
		this.gqAnswer = gqAnswer;
		this.gqViews = gqViews;
		this.gqEnrollDate = gqEnrollDate;
		this.gqStatus = gqStatus;
		this.gqTitle = gqTitle;
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
	
	
	
	
	

	public String getGqStatus() {
		return gqStatus;
	}






	public void setGqStatus(String gqStatus) {
		this.gqStatus = gqStatus;
	}






	public String getGqTitle() {
		return gqTitle;
	}






	public void setGqTitle(String gqTitle) {
		this.gqTitle = gqTitle;
	}






	@Override
	public String toString() {
		return "QnA [gqNo=" + gqNo + ", memNo=" + memNo + ", postNo=" + postNo + ", gqContent=" + gqContent
				+ ", gqAnswer=" + gqAnswer + ", gqViews=" + gqViews + ", gqEnrollDate=" + gqEnrollDate + "]";
	}
	
	
	
	
	

}
