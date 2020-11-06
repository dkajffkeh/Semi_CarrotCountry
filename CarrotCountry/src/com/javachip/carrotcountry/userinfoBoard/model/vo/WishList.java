package com.javachip.carrotcountry.userinfoBoard.model.vo;

public class WishList {
	
	private int memNo;  //회원번호
	private int postNo; // 글번호
	
	private int postLikes; //찜 개수
	private String postName; // 글제목
	private int prodPrice;  //제품 가격
	private String blindCheck; // 블라인드 여부 (N :유효 Y:금지된 게시물)
	
	private String thumbNailPath;		// 이미지
	private String thumbNailFileName;
	private String thumbNailLoadPath;
	

	public WishList() {}


	public WishList(int memNo, int postNo, int postLikes, String postName, int prodPrice, String blindCheck,
			String thumbNailPath, String thumbNailFileName, String thumbNailLoadPath) {
		super();
		this.memNo = memNo;
		this.postNo = postNo;
		this.postLikes = postLikes;
		this.postName = postName;
		this.prodPrice = prodPrice;
		this.blindCheck = blindCheck;
		this.thumbNailPath = thumbNailPath;
		this.thumbNailFileName = thumbNailFileName;
		this.thumbNailLoadPath = thumbNailLoadPath;
	}


	
	
	
	public WishList(int memNo, int postLikes, String postName, int prodPrice, String blindCheck, String thumbNailPath,
			String thumbNailFileName, String thumbNailLoadPath) {
		super();
		this.memNo = memNo;
		this.postLikes = postLikes;
		this.postName = postName;
		this.prodPrice = prodPrice;
		this.blindCheck = blindCheck;
		this.thumbNailPath = thumbNailPath;
		this.thumbNailFileName = thumbNailFileName;
		this.thumbNailLoadPath = thumbNailLoadPath;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public int getPostLikes() {
		return postLikes;
	}


	public void setPostLikes(int postLikes) {
		this.postLikes = postLikes;
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


	public String getBlindCheck() {
		return blindCheck;
	}


	public void setBlindCheck(String blindCheck) {
		this.blindCheck = blindCheck;
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
		return "WishList [memNo=" + memNo + ", postNo=" + postNo + ", postLikes=" + postLikes + ", postName=" + postName
				+ ", prodPrice=" + prodPrice + ", blindCheck=" + blindCheck + ", thumbNailPath=" + thumbNailPath
				+ ", thumbNailFileName=" + thumbNailFileName + ", thumbNailLoadPath=" + thumbNailLoadPath + "]";
	}

	
	
	
	
}
