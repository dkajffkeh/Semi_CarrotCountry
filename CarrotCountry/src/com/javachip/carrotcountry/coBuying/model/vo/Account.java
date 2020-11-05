package com.javachip.carrotcountry.coBuying.model.vo;

public class Account {

	
	private String account;
	private int postNo;
	private String bank;
	private String[] accountList;
	
	
	
	public Account() {}



	public Account(String account, int postNo, String bank) {
		super();
		this.account = account;
		this.postNo = postNo;
		this.bank = bank;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public int getPostNo() {
		return postNo;
	}



	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}


	
	
	
	

	public String[] getAccountList() {
		return accountList;
	}



	public void setAccountList(String[] accountList) {
		this.accountList = accountList;
	}



	@Override
	public String toString() {
		return "Account [account=" + account + ", postNo=" + postNo + ", bank=" + bank + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
