package com.javachip.carrotcountry.jmboard.oneTo.model.vo;

import java.util.Date;

public class OneTo {

	private int oneToNo;
	private String writerNo;
	private String answrerNo;
	private String oneToType;
	private String oneToName;
	private String oneToContent;
	private String filePath;
	private String answerContent;
	private Date answerDate;
	private String answerState;
	
	public OneTo() {}

	public OneTo(int oneToNo, String writerNo, String answrerNo, String oneToType, String oneToName,
			String oneToContent, String filePath, String answerContent, Date answerDate, String answerState) {
		super();
		this.oneToNo = oneToNo;
		this.writerNo = writerNo;
		this.answrerNo = answrerNo;
		this.oneToType = oneToType;
		this.oneToName = oneToName;
		this.oneToContent = oneToContent;
		this.filePath = filePath;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.answerState = answerState;
	}

	public OneTo(int oneToNo, String writerNo, String oneToType, String oneToName, Date answerDate,
			String answerState) {
		super();
		this.oneToNo = oneToNo;
		this.writerNo = writerNo;
		this.oneToType = oneToType;
		this.oneToName = oneToName;
		this.answerDate = answerDate;
		this.answerState = answerState;
	}

	public int getOneToNo() {
		return oneToNo;
	}

	public void setOneToNo(int oneToNo) {
		this.oneToNo = oneToNo;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}

	public String getAnswrerNo() {
		return answrerNo;
	}

	public void setAnswrerNo(String answrerNo) {
		this.answrerNo = answrerNo;
	}

	public String getOneToType() {
		return oneToType;
	}

	public void setOneToType(String oneToType) {
		this.oneToType = oneToType;
	}

	public String getOneToName() {
		return oneToName;
	}

	public void setOneToName(String oneToName) {
		this.oneToName = oneToName;
	}

	public String getOneToContent() {
		return oneToContent;
	}

	public void setOneToContent(String oneToContent) {
		this.oneToContent = oneToContent;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public String getAnswerState() {
		return answerState;
	}

	public void setAnswerState(String answerState) {
		this.answerState = answerState;
	}

	@Override
	public String toString() {
		return "OneTo [oneToNo=" + oneToNo + ", writerNo=" + writerNo + ", answrerNo=" + answrerNo + ", oneToType="
				+ oneToType + ", oneToName=" + oneToName + ", oneToContent=" + oneToContent + ", filePath=" + filePath
				+ ", answerContent=" + answerContent + ", answerDate=" + answerDate + ", answerState=" + answerState
				+ "]";
	}
	
	
	
}
