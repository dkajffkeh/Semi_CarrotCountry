package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

public class PhotoBoardVo {

	private int photoNo;
	private int postNo;
	private String photoPath;
	private String photoFileName;
	private String photoLoadPath;
	
	public PhotoBoardVo() {
		
	}
	public PhotoBoardVo(int photoNo, int postNo, String photoPath, String photoFileName, String photoLoadPath) {
		super();
		this.photoNo = photoNo;
		this.postNo = postNo;
		this.photoPath = photoPath;
		this.photoFileName = photoFileName;
		this.photoLoadPath = photoLoadPath;
	}		

	public PhotoBoardVo(String photoPath, String photoFileName, String photoLoadPath) {
		super();
		this.photoPath = photoPath;
		this.photoFileName = photoFileName;
		this.photoLoadPath = photoLoadPath;
	}
	public int getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoLoadPath() {
		return photoLoadPath;
	}

	public void setPhotoLoadPath(String photoLoadPath) {
		this.photoLoadPath = photoLoadPath;
	}

	@Override
	public String toString() {
		return "PhotoBoardVo [photoNo=" + photoNo + ", postNo=" + postNo + ", photoPath=" + photoPath
				+ ", photoFileName=" + photoFileName + ", photoLoadPath=" + photoLoadPath + "]";
	}
	
	
}
