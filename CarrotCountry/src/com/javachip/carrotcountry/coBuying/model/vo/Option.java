package com.javachip.carrotcountry.coBuying.model.vo;

public class Option {
	
	private int optionNo;
	private int postNo;
	private String optionName;
	
	
	public Option() {}
	
	


	public Option(int optionNo, String optionName) {
		super();
		this.optionNo = optionNo;
		this.optionName = optionName;
	}




	public Option(int optionNo, int postNo, String optionName) {
		super();
		this.optionNo = optionNo;
		this.postNo = postNo;
		this.optionName = optionName;
	}


	public int getOptionNo() {
		return optionNo;
	}


	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public String getOptionName() {
		return optionName;
	}


	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}


	@Override
	public String toString() {
		return "Option [optionNo=" + optionNo + ", postNo=" + postNo + ", optionName=" + optionName + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
