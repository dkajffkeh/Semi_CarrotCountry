package com.javachip.carrotcountry.userinfoBoard.model.vo;

public class Location {
	private String localNo;
	private String localSi;
	private String localGu;
	private String localDong;
	
	public Location() {}

	public Location(String localNo, String localSi, String localGu, String localDong) {
		super();
		this.localNo = localNo;
		this.localSi = localSi;
		this.localGu = localGu;
		this.localDong = localDong;
	}

	public String getLocalNo() {
		return localNo;
	}

	public void setLocalNo(String localNo) {
		this.localNo = localNo;
	}

	public String getLocalSi() {
		return localSi;
	}

	public void setLocalSi(String localSi) {
		this.localSi = localSi;
	}

	public String getLocalGu() {
		return localGu;
	}

	public void setLocalGu(String localGu) {
		this.localGu = localGu;
	}

	public String getLocalDong() {
		return localDong;
	}

	public void setLocalDong(String localDong) {
		this.localDong = localDong;
	}

	@Override
	public String toString() {
		return "Location [localNo=" + localNo + ", localSi=" + localSi + ", localGu=" + localGu + ", localDong="
				+ localDong + "]";
	}
	
	
}
