package com.javachip.carrotcountry.userinfoBoardNg.model.vo;

import java.sql.Date;

public class MyPurchaseInfo {
	// purchse_Info 테이블 (기본 정보)
	private int purchaseNo;		// 구매 번호
	private int postNo;			// 게시글 번호
	private int memNo;			// 구매자 번호
	private int shippingNo;		// 배송지 번호
	private int optionNo;		// 옵션번호
	private String depositor;	// 입금자명
	private int purchasePrice;	// 공동구매가격
	private Date purchaseDate;  // 구매일
	private String courier; 	// 택배사 명
	private int trackingNo;		// 운송장 번호
	private String requests;	// 요청사항
	
	// 추가 필요 정보
	private String thumbnailLoadpath;	// 썸네일 경로
	private String postName;			// 상품명
	private String memNickname;			// 진행자 닉네임
	private int gpMinpeople;			// 최소인원
	private int gpPeople;				// 현재인원
	private Date gpDeadLine;			// 마감일
	private String gpStatus;			// 상태
	
	// 기본 생성자
	public MyPurchaseInfo() {}

	// 매개변수 메소드 전체
	public MyPurchaseInfo(int purchaseNo, int postNo, int memNo, int shippingNo, int optionNo, String depositor,
			int purchasePrice, Date purchaseDate, String courier, int trackingNo, String requests,
			String thumbnailLoadpath, String postName, String memNickname, int gpMinpeople, int gpPeople,
			Date gpDeadLine, String gpStatus) {
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
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
		this.memNickname = memNickname;
		this.gpMinpeople = gpMinpeople;
		this.gpPeople = gpPeople;
		this.gpDeadLine = gpDeadLine;
		this.gpStatus = gpStatus;
	}

	// 내 공동구매 참며 리스트 조회용
	public MyPurchaseInfo(int purchaseNo, int postNo, String thumbnailLoadpath, String postName, String memNickname,
			int gpMinpeople, int gpPeople, Date gpDeadLine, String gpStatus) {
		super();
		this.purchaseNo = purchaseNo;
		this.postNo = postNo;
		this.thumbnailLoadpath = thumbnailLoadpath;
		this.postName = postName;
		this.memNickname = memNickname;
		this.gpMinpeople = gpMinpeople;
		this.gpPeople = gpPeople;
		this.gpDeadLine = gpDeadLine;
		this.gpStatus = gpStatus;
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

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public int getGpMinpeople() {
		return gpMinpeople;
	}

	public void setGpMinpeople(int gpMinpeople) {
		this.gpMinpeople = gpMinpeople;
	}

	public int getGpPeople() {
		return gpPeople;
	}

	public void setGpPeople(int gpPeople) {
		this.gpPeople = gpPeople;
	}

	public Date getGpDeadLine() {
		return gpDeadLine;
	}

	public void setGpDeadLine(Date gpDeadLine) {
		this.gpDeadLine = gpDeadLine;
	}

	public String getGpStatus() {
		return gpStatus;
	}

	public void setGpStatus(String gpStatus) {
		this.gpStatus = gpStatus;
	}

	@Override
	public String toString() {
		return "MyPurchaseInfo [purchaseNo=" + purchaseNo + ", postNo=" + postNo + ", memNo=" + memNo + ", shippingNo="
				+ shippingNo + ", optionNo=" + optionNo + ", depositor=" + depositor + ", purchasePrice="
				+ purchasePrice + ", purchaseDate=" + purchaseDate + ", courier=" + courier + ", trackingNo="
				+ trackingNo + ", requests=" + requests + ", thumbnailLoadpath=" + thumbnailLoadpath + ", postName="
				+ postName + ", memNickname=" + memNickname + ", gpMinpeople=" + gpMinpeople + ", gpPeople=" + gpPeople
				+ ", gpDeadLine=" + gpDeadLine + ", gpStatus=" + gpStatus + "]";
	}

}
