package com.javachip.carrotcountry.userinfoBoard.model.vo;

public class WishList {
	
	private int memNo;  //회원번호
	private int postNo; // 글번호

	public WishList() {}

	public WishList(int memNo, int postNo) {
		super();
		this.memNo = memNo;
		this.postNo = postNo;
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

	@Override
	public String toString() {
		return "WishList [memNo=" + memNo + ", postNo=" + postNo + "]";
	}
	
	
}
