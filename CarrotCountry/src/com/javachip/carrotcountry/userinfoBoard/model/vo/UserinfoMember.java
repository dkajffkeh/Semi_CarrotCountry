package com.javachip.carrotcountry.userinfoBoard.model.vo;

import java.sql.Date;

public class UserinfoMember {
	
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
	private Date memEnrollDate;		
	private String bListCheck;		
	private String leaveCheck;		
	private String managerCheck;	
	private String profilePath; 	    // 프로필 사진 경로
    private String profileModifyname;	// 프로필 사진 수정명
    private String profileOrignname;	// 프로필 사진 원본명
    private String profileLoadname;		// 경로 + 수정명
    private String localSi;
    private String localGu;
    private String localDong;

    public UserinfoMember() {}

	public UserinfoMember(int memNo, int localNo, String memUserId, String memUserPwd, String memName,
			String memNickname, String memBirthday, String memGender, String memPhone, String memEmail,
			Date memEnrollDate, String bListCheck, String leaveCheck, String managerCheck, String profilePath,
			String profileModifyname, String profileOrignname, String profileLoadname, String localSi, String localGu,
			String localDong) {
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
		this.memEnrollDate = memEnrollDate;
		this.bListCheck = bListCheck;
		this.leaveCheck = leaveCheck;
		this.managerCheck = managerCheck;
		this.profilePath = profilePath;
		this.profileModifyname = profileModifyname;
		this.profileOrignname = profileOrignname;
		this.profileLoadname = profileLoadname;
		this.localSi = localSi;
		this.localGu = localGu;
		this.localDong = localDong;
	}
	
	

	


	public UserinfoMember(String memUserId, String memName, String memGender, String memBirthday, String memNickname,
			String memPhone, int localNo, String memEmail) {
		super();
		this.memUserId = memUserId;
		this.memName = memName;
		this.memGender = memGender;
		this.memBirthday = memBirthday;
		this.memNickname = memNickname;
		this.memPhone = memPhone;
		this.localNo = localNo;
		this.memEmail = memEmail;
	}

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

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public String getProfileModifyname() {
		return profileModifyname;
	}

	public void setProfileModifyname(String profileModifyname) {
		this.profileModifyname = profileModifyname;
	}

	public String getProfileOrignname() {
		return profileOrignname;
	}

	public void setProfileOrignname(String profileOrignname) {
		this.profileOrignname = profileOrignname;
	}

	public String getProfileLoadname() {
		return profileLoadname;
	}

	public void setProfileLoadname(String profileLoadname) {
		this.profileLoadname = profileLoadname;
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
		return "UserinfoMember [memNo=" + memNo + ", localNo=" + localNo + ", memUserId=" + memUserId + ", memUserPwd="
				+ memUserPwd + ", memName=" + memName + ", memNickname=" + memNickname + ", memBirthday=" + memBirthday
				+ ", memGender=" + memGender + ", memPhone=" + memPhone + ", memEmail=" + memEmail + ", memEnrollDate="
				+ memEnrollDate + ", bListCheck=" + bListCheck + ", leaveCheck=" + leaveCheck + ", managerCheck="
				+ managerCheck + ", profilePath=" + profilePath + ", profileModifyname=" + profileModifyname
				+ ", profileOrignname=" + profileOrignname + ", profileLoadname=" + profileLoadname + ", localSi="
				+ localSi + ", localGu=" + localGu + ", localDong=" + localDong + "]";
	}

	
	
    
    
}
