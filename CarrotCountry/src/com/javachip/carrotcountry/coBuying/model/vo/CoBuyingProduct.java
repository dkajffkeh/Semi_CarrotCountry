package com.javachip.carrotcountry.coBuying.model.vo;

import java.sql.Date;

public class CoBuyingProduct {
	
	private int postNo;  
	private int gpPrice;
	private int gpDPrice;
	private int gpDRate;
	private int gpMinPeople;
	private int gpPeople;
	private String gpStatus;
	private Date gpDeadline;

	
	public CoBuyingProduct() {}


	public CoBuyingProduct(int postNo, int gpPrice, int gpDPrice, int gpDRate, int gpMinPeople, int gpPeople,
			String gpStatus, Date gpDeadline) {
		super();
		this.postNo = postNo;
		this.gpPrice = gpPrice;
		this.gpDPrice = gpDPrice;
		this.gpDRate = gpDRate;
		this.gpMinPeople = gpMinPeople;
		this.gpPeople = gpPeople;
		this.gpStatus = gpStatus;
		this.gpDeadline = gpDeadline;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public int getGpPrice() {
		return gpPrice;
	}


	public void setGpPrice(int gpPrice) {
		this.gpPrice = gpPrice;
	}


	public int getGpDPrice() {
		return gpDPrice;
	}


	public void setGpDPrice(int gpDPrice) {
		this.gpDPrice = gpDPrice;
	}


	public int getGpDRate() {
		return gpDRate;
	}


	public void setGpDRate(int gpDRate) {
		this.gpDRate = gpDRate;
	}


	public int getGpMinPeople() {
		return gpMinPeople;
	}


	public void setGpMinPeople(int gpMinPeople) {
		this.gpMinPeople = gpMinPeople;
	}


	public int getGpPeople() {
		return gpPeople;
	}


	public void setGpPeople(int gpPeople) {
		this.gpPeople = gpPeople;
	}


	public String getGpStatus() {
		return gpStatus;
	}


	public void setGpStatus(String gpStatus) {
		this.gpStatus = gpStatus;
	}


	public Date getGpDeadline() {
		return gpDeadline;
	}


	public void setGpDeadline(Date gpDeadline) {
		this.gpDeadline = gpDeadline;
	}


	@Override
	public String toString() {
		return "CoBuyingProduct [postNo=" + postNo + ", gpPrice=" + gpPrice + ", gpDPrice=" + gpDPrice + ", gpDRate="
				+ gpDRate + ", gpMinPeople=" + gpMinPeople + ", gpPeople=" + gpPeople + ", gpStatus=" + gpStatus
				+ ", gpDeadline=" + gpDeadline + "]";
	}
	
	
	
	
	
	
	
	
}
