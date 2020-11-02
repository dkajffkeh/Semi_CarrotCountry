package com.javachip.carrotcountry.adminBoard.model.vo;

import java.sql.Date;

public class AdminReport {
	
	private int reportNo;
	private String memNo;
	private String reportTypeNo;
	private String reportReason;
	private Date reportDate;
	private String reportPostNo;
	private String reportCheck;
	
	public AdminReport() {}

	public AdminReport(int reportNo, String memNo, String reportTypeNo, String reportReason, Date reportDate,
			String reportPostNo, String reportCheck) {
		super();
		this.reportNo = reportNo;
		this.memNo = memNo;
		this.reportTypeNo = reportTypeNo;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
		this.reportPostNo = reportPostNo;
		this.reportCheck = reportCheck;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getReportTypeNo() {
		return reportTypeNo;
	}

	public void setReportTypeNo(String reportTypeNo) {
		this.reportTypeNo = reportTypeNo;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reqortDate) {
		this.reportDate = reqortDate;
	}

	public String getReportPostNo() {
		return reportPostNo;
	}

	public void setReportPostNo(String reportPostNo) {
		this.reportPostNo = reportPostNo;
	}

	public String getReportCheck() {
		return reportCheck;
	}

	public void setReportCheck(String reportCheck) {
		this.reportCheck = reportCheck;
	}

	@Override
	public String toString() {
		return "AdminReport [reportNo=" + reportNo + ", memNo=" + memNo + ", reportTypeNo=" + reportTypeNo
				+ ", reportReason=" + reportReason + ", reqortDate=" + reportDate + ", reportPostNo=" + reportPostNo
				+ ", reportCheck=" + reportCheck + "]";
	}
	
}
