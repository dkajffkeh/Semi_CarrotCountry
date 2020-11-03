package com.javachip.carrotcountry.userinfoBoard.model.vo;

public class ShippingLocation {
	
	private int shippingNo;
	private int memNo;
	private String shippingAddress;
	private String memUserName;
	private String memPhone;
	private String shippingDefault;
	
	
	public ShippingLocation() {}


	public ShippingLocation(int shippingNo, int memNo, String shippingAddress, String memUserName, String memPhone,
			String shippingDefault) {
		super();
		this.shippingNo = shippingNo;
		this.memNo = memNo;
		this.shippingAddress = shippingAddress;
		this.memUserName = memUserName;
		this.memPhone = memPhone;
		this.shippingDefault = shippingDefault;
	}


	public int getShippingNo() {
		return shippingNo;
	}


	public void setShippingNo(int shippingNo) {
		this.shippingNo = shippingNo;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getMemUserName() {
		return memUserName;
	}


	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}


	public String getMemPhone() {
		return memPhone;
	}


	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}


	public String getShippingDefault() {
		return shippingDefault;
	}


	public void setShippingDefault(String shippingDefault) {
		this.shippingDefault = shippingDefault;
	}


	@Override
	public String toString() {
		return "ShippingLocation [shippingNo=" + shippingNo + ", memNo=" + memNo + ", shippingAddress="
				+ shippingAddress + ", memUserName=" + memUserName + ", memPhone=" + memPhone + ", shippingDefault="
				+ shippingDefault + "]";
	}
	
	

}
