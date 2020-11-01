package com.javachip.carrotcountry.jmboard.faq.model.vo;

import java.sql.Date;

public class Faq {

	private int faqNo;
	private String memNo;
	private String faqTitle;
	private String faqContent;
	private String category;
	private Date faqEnrollDate;
	private String faqwriter;
	private String faqstatus;
	
public Faq() {}

public Faq(int faqNo, String memNo, String faqTitle, String faqContent, String category, Date faqEnrollDate,
		String faqwriter, String faqstatus) {
	super();
	this.faqNo = faqNo;
	this.memNo = memNo;
	this.faqTitle = faqTitle;
	this.faqContent = faqContent;
	this.category = category;
	this.faqEnrollDate = faqEnrollDate;
	this.faqwriter = faqwriter;
	this.faqstatus = faqstatus;
}

public Faq(int faqNo, String faqTitle, String faqContent, String category, Date faqEnrollDate, String faqwriter,
		String faqstatus) {
	super();
	this.faqNo = faqNo;
	this.faqTitle = faqTitle;
	this.faqContent = faqContent;
	this.category = category;
	this.faqEnrollDate = faqEnrollDate;
	this.faqwriter = faqwriter;
	this.faqstatus = faqstatus;
}



	
	
}
