package com.javachip.carrotcountry.userinfoBoard.model.vo;

import java.sql.Date;

public class SaleProduct {
	
	private int postNo;	//게시글번호
	private int memNo;  //유저넘버
	private String postName; //게시글제목 (상품명?)
	private int prodPrice; //상품 가격
	private String prodStatus; //진행상태
	private Date postEnrollDate; // 등록일
	private String thumbNailPath;   //상품사진
	private String thumbNailFileName;
	private String thumbNailLoadPath;
	
	public SaleProduct() {};
	
	public SaleProduct(int postNo, int memNo, String postName, int prodPrice, String prodStatus, Date postEnrollDate,
			String thumbNailPath, String thumbNailFileName, String thumbNailLoadPath) {
		super();
		this.postNo = postNo;
		this.memNo = memNo;
		this.postName = postName;
		this.prodPrice = prodPrice;
		this.prodStatus = prodStatus;
		this.postEnrollDate = postEnrollDate;
		this.thumbNailPath = thumbNailPath;
		this.thumbNailFileName = thumbNailFileName;
		this.thumbNailLoadPath = thumbNailLoadPath;
	}
	
	
	
	public SaleProduct(int postNo, int memNo, String postName, int prodPrice, String prodStatus, Date postEnrollDate,
			String thumbNailPath, String thumbNailFileName) {
		super();
		this.postNo = postNo;
		this.memNo = memNo;
		this.postName = postName;
		this.prodPrice = prodPrice;
		this.prodStatus = prodStatus;
		this.postEnrollDate = postEnrollDate;
		this.thumbNailPath = thumbNailPath;
		this.thumbNailFileName = thumbNailFileName;
	}

	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}
	public Date getPostEnrollDate() {
		return postEnrollDate;
	}
	public void setPostEnrollDate(Date postEnrollDate) {
		this.postEnrollDate = postEnrollDate;
	}
	public String getThumbNailPath() {
		return thumbNailPath;
	}
	public void setThumbNailPath(String thumbNailPath) {
		this.thumbNailPath = thumbNailPath;
	}
	public String getThumbNailFileName() {
		return thumbNailFileName;
	}
	public void setThumbNailFileName(String thumbNailFileName) {
		this.thumbNailFileName = thumbNailFileName;
	}
	public String getThumbNailLoadPath() {
		return thumbNailLoadPath;
	}
	public void setThumbNailLoadPath(String thumbNailLoadPath) {
		this.thumbNailLoadPath = thumbNailLoadPath;
	}

	@Override
	public String toString() {
		return "SaleProduct [postNo=" + postNo + ", memNo=" + memNo + ", postName=" + postName + ", prodPrice="
				+ prodPrice + ", prodStatus=" + prodStatus + ", postEnrollDate=" + postEnrollDate + ", thumbNailPath="
				+ thumbNailPath + ", thumbNailFileName=" + thumbNailFileName + ", thumbNailLoadPath="
				+ thumbNailLoadPath + "]";
	}
	
	
	

}
