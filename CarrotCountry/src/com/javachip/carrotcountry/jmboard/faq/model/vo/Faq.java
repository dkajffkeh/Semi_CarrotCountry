package com.javachip.carrotcountry.jmboard.faq.model.vo;

import java.sql.Date;

public class Faq {

	private int faqNo;
	private String memNo;
	private String faqTitle;
	private String faqContent;
	private Date faqEnrollDate;
	private String category;
	private String faqstatus;
	
	public Faq(int faqNo, String memNo, String faqTitle, String faqContent, Date faqEnrollDate, String category,
			String faqstatus) {
		super();
		this.faqNo = faqNo;
		this.memNo = memNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqEnrollDate = faqEnrollDate;
		this.category = category;
		this.faqstatus = faqstatus;
	}

	public String getFaqstatus() {
		return faqstatus;
	}

	public void setFaqstatus(String faqstatus) {
		this.faqstatus = faqstatus;
	}

	public Faq() {}

	public Faq(int faqNo, String memNo, String faqTitle, String faqContent, Date faqEnrollDate, String category) {
		super();
		this.faqNo = faqNo;
		this.memNo = memNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqEnrollDate = faqEnrollDate;
		this.category = category;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public Date getFaqEnrollDate() {
		return faqEnrollDate;
	}

	public void setFaqEnrollDate(Date faqEnrollDate) {
		this.faqEnrollDate = faqEnrollDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", memNo=" + memNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent
				+ ", faqEnrollDate=" + faqEnrollDate + ", category=" + category + "]";
	}
	
	
}
