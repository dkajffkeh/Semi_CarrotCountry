package com.javachip.carrotcountry.member.model.vo;

import java.sql.Date;

public class Member {

	// 필드
	private int memNo;
	private int localNo;
	private String memUserId;
	private String memUserPwd;
	private String memName;
	private String memNickname;
	private String memBirthday;
	private String memGender;
	private String memPhone;
	private String memEmail;
	private String memLocation;
	private Date memEnrollDate;
	private String bListCheck;
	private String leaveCheck;
	private String managerCheck;
	
	// 기본생성자
	public Member() {}

	// 매개변수 생성자 (전체)
	public Member(int memNo, int localNo, String memUserId, String memUserPwd, String memName, String memNickname,
			String memBirthday, String memGender, String memPhone, String memEmail, String memLocation,
			Date memEnrollDate, String bListCheck, String leaveCheck, String managerCheck) {
		super();
		this.memNo = memNo;
		this.localNo = localNo;
		this.memUserId = memUserId;
		this.memUserPwd = memUserPwd;
		this.memName = memName;
		this.memNickname = memNickname;
		this.memBirthday = memBirthday;
		this.memGender = memGender;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memLocation = memLocation;
		this.memEnrollDate = memEnrollDate;
		this.bListCheck = bListCheck;
		this.leaveCheck = leaveCheck;
		this.managerCheck = managerCheck;
	}
	
	// 매개변수 생성자 (회원가입용)
	public Member(int localNo, String memUserId, String memUserPwd, String memName, String memNickname,
			String memBirthday, String memGender, String memPhone, String memEmail) {
		super();
		this.localNo = localNo;
		this.memUserId = memUserId;
		this.memUserPwd = memUserPwd;
		this.memName = memName;
		this.memNickname = memNickname;
		this.memBirthday = memBirthday;
		this.memGender = memGender;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
	}

	// setter / getter 메소드
	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getLocalNo() {
		return localNo;
	}

	public void setLocalNo(int localNo) {
		this.localNo = localNo;
	}

	public String getMemUserId() {
		return memUserId;
	}

	public void setMemUserId(String memUserId) {
		this.memUserId = memUserId;
	}

	public String getMemUserPwd() {
		return memUserPwd;
	}

	public void setMemUserPwd(String memUserPwd) {
		this.memUserPwd = memUserPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getMemBirthday() {
		return memBirthday;
	}

	public void setMemBirthday(String memBirthday) {
		this.memBirthday = memBirthday;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemLocation() {
		return memLocation;
	}

	public void setMemLocation(String memLocation) {
		this.memLocation = memLocation;
	}

	public Date getMemEnrollDate() {
		return memEnrollDate;
	}

	public void setMemEnrollDate(Date memEnrollDate) {
		this.memEnrollDate = memEnrollDate;
	}

	public String getbListCheck() {
		return bListCheck;
	}

	public void setbListCheck(String bListCheck) {
		this.bListCheck = bListCheck;
	}

	public String getLeaveCheck() {
		return leaveCheck;
	}

	public void setLeaveCheck(String leaveCheck) {
		this.leaveCheck = leaveCheck;
	}

	public String getManagerCheck() {
		return managerCheck;
	}

	public void setManagerCheck(String managerCheck) {
		this.managerCheck = managerCheck;
	}

	// toString 메소드
	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", localNo=" + localNo + ", memUserId=" + memUserId + ", memUserPwd="
				+ memUserPwd + ", memName=" + memName + ", memNickname=" + memNickname + ", memBirthday=" + memBirthday
				+ ", memGender=" + memGender + ", memPhone=" + memPhone + ", memEmail=" + memEmail + ", memLocation="
				+ memLocation + ", memEnrollDate=" + memEnrollDate + ", bListCheck=" + bListCheck + ", leaveCheck="
				+ leaveCheck + ", managerCheck=" + managerCheck + "]";
	}
	
}
