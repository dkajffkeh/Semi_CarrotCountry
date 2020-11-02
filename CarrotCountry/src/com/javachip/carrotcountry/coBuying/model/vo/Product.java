package com.javachip.carrotcountry.coBuying.model.vo;

import java.sql.Date;

public class Product {
	
	private int postNo;  
	private int gpPrice;
	private int gpDPrice;
	private int gpDRate;
	private int gpMinPeople;
	private int gpPeople;
	private String gpStatus;
	private Date gpDeadline;

	private Date postEnrollDate;
	private String postComment;
	private String postRefund;
	
	
	private String thumbnailLoadpath;
	private String postName;
	private int postLikes;
	
	
	
	public Product() {}

	
	
	
	
	
	
	

	public Product(String thumbnailLoadpath, String postName) {
		super();
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
	}









	public Product(int postNo, String thumbnailLoadpath, String postName, int gpPeople,
			int postLikes, int gpPrice, int gpDRate, int gpDPrice) {
		super();
		this.postNo = postNo;
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
		this.gpPeople = gpPeople;
		this.postLikes = postLikes;
		this.gpPrice = gpPrice;
		this.gpDRate = gpDRate;
		this.gpDPrice = gpDPrice;
	}









	public Product(int postNo, Date postEnrollDate, Date gpDeadline, int gpMinPeople, int gpPeople, int gpDPrice, 
			String postComment, String postRefund) {
		super();
		this.postNo = postNo;
		this.postEnrollDate = postEnrollDate;
		this.gpDeadline = gpDeadline;
		this.gpMinPeople = gpMinPeople;
		this.gpPeople = gpPeople;
		this.gpDPrice = gpDPrice;
		this.postComment = postComment;
		this.postRefund = postRefund;
	}







	public Product(int postNo, int gpPrice, int gpDPrice, int gpDRate, int gpMinPeople, int gpPeople,
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


	
	//========== 추가 ===========
	
	
	
	public Date getPostEnrollDate() {
		return postEnrollDate;
	}





	public void setPostEnrollDate(Date postEnrollDate) {
		this.postEnrollDate = postEnrollDate;
	}





	public String getPostComment() {
		return postComment;
	}





	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}





	public String getPostRefund() {
		return postRefund;
	}





	public void setPostRefund(String postRefund) {
		this.postRefund = postRefund;
	}

	
	
	//============== 추가 ==================
	
	
	


	public String getThumbnailLoadpath() {
		return thumbnailLoadpath;
	}







	public void setThumbnailLoadpath(String thumbnailLoadpath) {
		this.thumbnailLoadpath = thumbnailLoadpath;
	}







	public String getPostName() {
		return postName;
	}







	public void setPostName(String postName) {
		this.postName = postName;
	}







	public int getPostLikes() {
		return postLikes;
	}







	public void setPostLikes(int postLikes) {
		this.postLikes = postLikes;
	}
	
	
	
	
	

	
	
	
	
	
	
	




	@Override
	public String toString() {
		return "Product [postNo=" + postNo + ", gpPrice=" + gpPrice + ", gpDPrice=" + gpDPrice + ", gpDRate="
				+ gpDRate + ", gpMinPeople=" + gpMinPeople + ", gpPeople=" + gpPeople + ", gpStatus=" + gpStatus
				+ ", gpDeadline=" + gpDeadline + "]";
	}





	
	
	
	
	
	
}
