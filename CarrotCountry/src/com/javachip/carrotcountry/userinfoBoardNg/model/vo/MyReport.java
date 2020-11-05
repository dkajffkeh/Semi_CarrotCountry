package com.javachip.carrotcountry.userinfoBoardNg.model.vo;

import java.sql.Date;

public class MyReport {
	
	// 필드
	private int rNum; 			// 컬럼 순서 1부터 쭈루룩 나오기 위한 변수
	private int reportNo; 		// 신고번호
	private String postName;	// 게시글명
	private String reportTypeName;	// 신고유형
	private String reportReason;	// 신고사유
	private String reportNickName;	// 신고받은사람
	private Date reportDate;		// 신고일
	private String reportCheck;		// 처리상태 'N' 'Y'
	
	// 기본생성자
	public MyReport() {}

	// 매개변수 생성자 (전체)
	public MyReport(int rNum, int reportNo, String postName, String reportTypeName, String reportReason,
			String reportNickName, Date reportDate, String reportCheck) {
		super();
		this.rNum = rNum;
		this.reportNo = reportNo;
		this.postName = postName;
		this.reportTypeName = reportTypeName;
		this.reportReason = reportReason;
		this.reportNickName = reportNickName;
		this.reportDate = reportDate;
		this.reportCheck = reportCheck;
	}

	// setter/getter 메소드
	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getReportTypeName() {
		return reportTypeName;
	}

	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportNickName() {
		return reportNickName;
	}

	public void setReportNickName(String reportNickName) {
		this.reportNickName = reportNickName;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportCheck() {
		return reportCheck;
	}

	public void setReportCheck(String reportCheck) {
		this.reportCheck = reportCheck;
	}

	// toString 메소드
	@Override
	public String toString() {
		return "MyReport [rNum=" + rNum + ", reportNo=" + reportNo + ", postName=" + postName + ", reportTypeName="
				+ reportTypeName + ", reportReason=" + reportReason + ", reportNickName=" + reportNickName
				+ ", reportDate=" + reportDate + ", reportCheck=" + reportCheck + "]";
	}
	
}
