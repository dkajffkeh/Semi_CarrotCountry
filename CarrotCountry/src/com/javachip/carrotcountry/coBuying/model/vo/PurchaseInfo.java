package com.javachip.carrotcountry.coBuying.model.vo;

import java.sql.Date;

public class PurchaseInfo {
	
	private int purchaseNo;		// 구매번호	seq_pinfo
	private int postNo;			// 게시글번호
	private int memNo;			// 구매자번호
	private int shippingNo;		// 배송지번호
	private int optionNo;		// 옵션번호
	private String depositor;	// 입금자명
	private int purchasePrice;	// 구매가격
	private Date purchaseDate;	// 구매일
	private String courier;		// 택배사명
	private int trackingNo;		// 운송장번호
	private String requests;	// 배송요청사항
	
	public PurchaseInfo() {
		super();
	}

	public PurchaseInfo(int purchaseNo, int postNo, int memNo, int shippingNo, int optionNo, String depositor,
			int purchasePrice, Date purchaseDate, String courier, int trackingNo, String requests) {
		super();
		this.purchaseNo = purchaseNo;
		this.postNo = postNo;
		this.memNo = memNo;
		this.shippingNo = shippingNo;
		this.optionNo = optionNo;
		this.depositor = depositor;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		this.courier = courier;
		this.trackingNo = trackingNo;
		this.requests = requests;
	}

	public PurchaseInfo(int postNo, int memNo, int shippingNo, int optionNo, String depositor, int purchasePrice,
			String requests) {
		super();
		this.postNo = postNo;
		this.memNo = memNo;
		this.shippingNo = shippingNo;
		this.optionNo = optionNo;
		this.depositor = depositor;
		this.purchasePrice = purchasePrice;
		this.requests = requests;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
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

	public int getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(int shippingNo) {
		this.shippingNo = shippingNo;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public int getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(int trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "PurchaseInfo [purchaseNo=" + purchaseNo + ", postNo=" + postNo + ", memNo=" + memNo + ", shippingNo="
				+ shippingNo + ", optionNo=" + optionNo + ", depositor=" + depositor + ", purchasePrice="
				+ purchasePrice + ", purchaseDate=" + purchaseDate + ", courier=" + courier + ", trackingNo="
				+ trackingNo + ", requests=" + requests + "]";
	}

}
