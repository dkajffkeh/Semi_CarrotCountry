package com.javachip.carrotcountry.userinfoBoardNg.model.vo;

import java.sql.Date;

public class MyPurchaseInfo {
	// purchse_Info 테이블 (기본 정보)
	private int purchaseNo;		// 구매 번호
	private int postNo;			// 게시글 번호
	private int memNo;			// 내 번호(구매자 번호)
	private int shippingNo;		// 배송지 번호
	private int optionNo;		// 옵션번호
	private String depositor;	// 입금자명
	private int purchasePrice;	// 공동구매가격
	private Date purchaseDate;  // 구매일
	private String courier; 	// 택배사 명
	private long trackingNo;	// 운송장 번호
	private String requests;	// 요청사항

	
	// 추가-----------------------------------------
	
	// 추가 필요 정보
	private String thumbnailLoadpath;	// 썸네일 경로
	private String postName;			// 상품명
	private String memNickname;			// 진행자 닉네임
	private String memPhone;			// 진행자 전화번호
	private int gpMinpeople;			// 최소인원
	private int gpPeople;				// 현재인원
	private Date gpDeadLine;			// 마감일
	private String gpStatus;			// 상태
	
	// 상세조회를 위한 추가 필요 정보-----------------------
	// 상품
	private int gpPrice;				// 원가
	private int gpDprice;				// 할인가
	private int gpDrate;				// 할인율
	private int dDay;					// 남은날짜 수
	
	// 옵션
	private String optionName;			// 선택한 옵션명
	
	// 배송
	private String shippingAddress;		// 배송지
	private String myPhone;				// 수령인 연락처
	private String myName;				// 수령인
	private String slStatus;			// 배송 상태 (기본값이 'Y' ?)
	
	// 진행자 계좌
	private String memName; 			// 진행자 이름
	private String account;				// 계좌
	private String bank;				// 은행
	
	// 상품
	private String dealType;	// 결제방식
	private String site;		// 배송지 (POST테이블에 배송지?)
	
	// 기본 생성자
	public MyPurchaseInfo() {}

	// 기본 매개변수 메소드 전체
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
	
	// 공동구매 상세조회용
	public MyPurchaseInfo(int purchaseNo, int postNo, int memNo, int shippingNo, int optionNo, String depositor,
			int purchasePrice, Date purchaseDate, String courier, long trackingNo, String requests,
			String thumbnailLoadpath, String postName, String memNickname, String memPhone, int gpMinpeople,
			int gpPeople, Date gpDeadLine, String gpStatus, int gpPrice, int gpDprice, int gpDrate, int dDay,
			String optionName, String shippingAddress, String myPhone, String myName, String slStatus, String memName,
			String account, String bank, String dealType, String site) {
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
		this.memPhone = memPhone;
		this.gpMinpeople = gpMinpeople;
		this.gpPeople = gpPeople;
		this.gpDeadLine = gpDeadLine;
		this.gpStatus = gpStatus;
		this.gpPrice = gpPrice;
		this.gpDprice = gpDprice;
		this.gpDrate = gpDrate;
		this.dDay = dDay;
		this.optionName = optionName;
		this.shippingAddress = shippingAddress;
		this.myPhone = myPhone;
		this.myName = myName;
		this.slStatus = slStatus;
		this.memName = memName;
		this.account = account;
		this.bank = bank;
		this.dealType = dealType;
		this.site = site;
	}

	// 공구 구매한사람 리스트 조회하기위한 생성자 
	public MyPurchaseInfo(int purchaseNo, int postNo, int memNo, String depositor, Date purchaseDate, String courier,
			long trackingNo) {
		super();
		this.purchaseNo = purchaseNo;
		this.postNo = postNo;
		this.memNo = memNo;
		this.depositor = depositor;
		this.purchaseDate = purchaseDate;
		this.courier = courier;
		this.trackingNo = trackingNo;
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

	public long getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(long trackingNo) {
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

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
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

	public int getGpPrice() {
		return gpPrice;
	}

	public void setGpPrice(int gpPrice) {
		this.gpPrice = gpPrice;
	}

	public int getGpDprice() {
		return gpDprice;
	}

	public void setGpDprice(int gpDprice) {
		this.gpDprice = gpDprice;
	}

	public int getGpDrate() {
		return gpDrate;
	}

	public void setGpDrate(int gpDrate) {
		this.gpDrate = gpDrate;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getMyPhone() {
		return myPhone;
	}

	public void setMyPhone(String myPhone) {
		this.myPhone = myPhone;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getSlStatus() {
		return slStatus;
	}

	public void setSlStatus(String slStatus) {
		this.slStatus = slStatus;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "MyPurchaseInfo [purchaseNo=" + purchaseNo + ", postNo=" + postNo + ", memNo=" + memNo + ", shippingNo="
				+ shippingNo + ", optionNo=" + optionNo + ", depositor=" + depositor + ", purchasePrice="
				+ purchasePrice + ", purchaseDate=" + purchaseDate + ", courier=" + courier + ", trackingNo="
				+ trackingNo + ", requests=" + requests + ", thumbnailLoadpath=" + thumbnailLoadpath + ", postName="
				+ postName + ", memNickname=" + memNickname + ", memPhone=" + memPhone + ", gpMinpeople=" + gpMinpeople
				+ ", gpPeople=" + gpPeople + ", gpDeadLine=" + gpDeadLine + ", gpStatus=" + gpStatus + ", gpPrice="
				+ gpPrice + ", gpDprice=" + gpDprice + ", gpDrate=" + gpDrate + ", dDay=" + dDay + ", optionName="
				+ optionName + ", shippingAddress=" + shippingAddress + ", myPhone=" + myPhone + ", myName=" + myName
				+ ", slStatus=" + slStatus + ", memName=" + memName + ", account=" + account + ", bank=" + bank
				+ ", dealType=" + dealType + ", site=" + site + "]";
	}
	
}
