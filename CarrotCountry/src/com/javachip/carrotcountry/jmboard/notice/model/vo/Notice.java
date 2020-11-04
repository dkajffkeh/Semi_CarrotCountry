package com.javachip.carrotcountry.jmboard.notice.model.vo;

import java.util.Date;

public class Notice {
	
	private int noticeNo;
	private String memNo;
	private String noticeTitle;
	private String noticeContent;
	private String filePath;
	private Date noticeEnrollDate;
	private int noticeCount;
	private String fileModifyName;
	private String fileOriginName;
	private String noticeStatus;
	
	public Notice() {}

	public Notice(int noticeNo, String memNo, String noticeTitle, String noticeContent, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.memNo = memNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCount = noticeCount;
	}
	



	public Notice(int noticeNo, String memNo, String noticeTitle, Date noticeEnrollDate, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.memNo = memNo;
		this.noticeTitle = noticeTitle;
		this.noticeEnrollDate = noticeEnrollDate;
		this.noticeCount = noticeCount;
	}
	//insert controller
	public Notice(String memNo, String noticeTitle, String noticeContent, String filePath,
			String fileModifyName, String fileOriginName) {
		super();
		this.memNo = memNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.filePath = filePath;
		this.fileModifyName = fileModifyName;
		this.fileOriginName = fileOriginName;
	}
	//insert Dao
	public Notice(int noticeNo, String memNo, String noticeTitle, String noticeContent, String filePath,
			Date noticeEnrollDate, String fileModifyName, String fileOriginName) {
		super();
		this.noticeNo = noticeNo;
		this.memNo = memNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.filePath = filePath;
		this.noticeEnrollDate = noticeEnrollDate;
		this.fileModifyName = fileModifyName;
		this.fileOriginName = fileOriginName;
	}
	
	



	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getNoticeEnrollDate() {
		return noticeEnrollDate;
	}

	public void setNoticeEnrollDate(Date noticeEnrollDate) {
		this.noticeEnrollDate = noticeEnrollDate;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	public String getFileModifyName() {
		return fileModifyName;
	}

	public void setFileModifyName(String fileModifyName) {
		this.fileModifyName = fileModifyName;
	}

	public String getFileOriginName() {
		return fileOriginName;
	}

	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memNo=" + memNo + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", filePath=" + filePath + ", noticeEnrollDate=" + noticeEnrollDate + ", noticeCount="
				+ noticeCount + ", fileModifyName=" + fileModifyName + ", fileOriginName=" + fileOriginName
				+ ", noticeStatus=" + noticeStatus + "]";
	}
	
	
	
}
