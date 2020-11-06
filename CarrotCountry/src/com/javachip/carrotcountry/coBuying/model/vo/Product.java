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
	private String gpDeadline;

	private Date postEnrollDate;
	private String postComment;
	private String gpRefund;

	private int memNo;			// 얘네 안써요
	private String categoryNo;	
	private String gpContent; 	// 얘네 안써요
	private int gpPostCheck;	
	
	private String thumbnailLoadpath;
	private String postName;
	private int postLikes;
	private String thumbnailPath;
	private String thumbnailFilename;
	
	public Product() {}

	
	
	
	
	
	
	
	
	
	

	public Product(int postNo, String thumbnailPath, String thumbnailFilename, String thumbnailLoadpath,
			String postName, int gpPeople, int postLikes, int gpPrice, int gpDRate, int gpDPrice) {
		super();
		this.postNo = postNo;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
		this.gpPeople = gpPeople;
		this.postLikes = postLikes;
		this.gpPrice = gpPrice;
		this.gpDRate = gpDRate;
		this.gpDPrice = gpDPrice;
	}












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









	public Product(int postNo, Date postEnrollDate, String gpDeadline, int gpMinPeople, int gpPeople, int gpDPrice, 
			String postComment, String gpRefund) {
		super();
		this.postNo = postNo;
		this.postEnrollDate = postEnrollDate;
		this.gpDeadline = gpDeadline;
		this.gpMinPeople = gpMinPeople;
		this.gpPeople = gpPeople;
		this.gpDPrice = gpDPrice;
		this.postComment = postComment;
		this.gpRefund = gpRefund;
	}



	public Product(int postNo, int gpPrice, int gpDPrice, int gpDRate, int gpMinPeople, int gpPeople, String gpStatus,
			String gpDeadline, Date postEnrollDate, String postComment, String gpRefund, int memNo, String categoryNo,
			String gpContent, int gpPostCheck, String thumbnailLoadpath, String postName, int postLikes) {
		super();
		this.postNo = postNo;
		this.gpPrice = gpPrice;
		this.gpDPrice = gpDPrice;
		this.gpDRate = gpDRate;
		this.gpMinPeople = gpMinPeople;
		this.gpPeople = gpPeople;
		this.gpStatus = gpStatus;
		this.gpDeadline = gpDeadline;
		this.postEnrollDate = postEnrollDate;
		this.postComment = postComment;
		this.gpRefund = gpRefund;
		this.memNo = memNo;
		this.categoryNo = categoryNo;
		this.gpContent = gpContent;
		this.gpPostCheck = gpPostCheck;
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
		this.postLikes = postLikes;
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


	public String getGpDeadline() {
		return gpDeadline;
	}


	public void setGpDeadline(String gpDeadline) {
		this.gpDeadline = gpDeadline;
	}


	
	//========== 추가 ===========
	
	


	public String getPostComment() {
		return postComment;
	}





	public void setPostComment(String postComment) {
		this.postComment = postComment;
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
	
	
	


	public Date getPostEnrollDate() {
		return postEnrollDate;
	}








	public void setPostEnrollDate(Date postEnrollDate) {
		this.postEnrollDate = postEnrollDate;
	}








	public String getGpRefund() {
		return gpRefund;
	}








	public void setGpRefund(String gpRefund) {
		this.gpRefund = gpRefund;
	}








	public int getMemNo() {
		return memNo;
	}








	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}








	public String getCategoryNo() {
		return categoryNo;
	}








	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}








	public String getGpContent() {
		return gpContent;
	}








	public void setGpContent(String gpContent) {
		this.gpContent = gpContent;
	}








	public int getGpPostCheck() {
		return gpPostCheck;
	}








	public void setGpPostCheck(int gpPostCheck) {
		this.gpPostCheck = gpPostCheck;
	}




	
	
	
	




	public String getThumbnailPath() {
		return thumbnailPath;
	}












	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}












	public String getThumbnailFilename() {
		return thumbnailFilename;
	}












	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}












	@Override
	public String toString() {
		return "Product [postNo=" + postNo + ", gpPrice=" + gpPrice + ", gpDPrice=" + gpDPrice + ", gpDRate="
				+ gpDRate + ", gpMinPeople=" + gpMinPeople + ", gpPeople=" + gpPeople + ", gpStatus=" + gpStatus
				+ ", gpDeadline=" + gpDeadline + "]";
	}





	
	
	
	
	
	
}
