package com.javachip.carrotcountry.adminBoard.model.vo;

import java.sql.Date;

public class AdminMember {
	
		private int memNo;				// 회원 식별번호
		private int localNo;			// 회원 지역번호
		private String memUserId;		// 회원 아이디
		private String memUserPwd;		// 회원 비밀번호
		private String memName;			// 회원 이름
		private String memNickName;		// 회원 닉네임
		private String memBirthday;		// 회원 생년월일
		private String memGender;		// 회원 성별
		private String memPhone;		// 회원 전화번호
		private String memEmail;		// 회원 이메일
		private String memLocation;		// 회원 거주지역
		private Date memEnrollDate;		// 회원가입일
		private String bListCheck;		// 블랙리스트여부 'N/Y'
		private String leaveCheck;		// 탈퇴여부 'N/Y'
		private String managerCheck;	// 관리자여부 'N/Y'
		private int reportCount;
		
		public AdminMember() {}

		public AdminMember(int memNo, int localNo, String memUserId, String memUserPwd, String memName,
				String memNickName, String memBirthday, String memGender, String memPhone, String memEmail,
				String memLocation, Date memEnrollDate, String bListCheck, String leaveCheck, String managerCheck,
				int reportCount) {
			super();
			this.memNo = memNo;
			this.localNo = localNo;
			this.memUserId = memUserId;
			this.memUserPwd = memUserPwd;
			this.memName = memName;
			this.memNickName = memNickName;
			this.memBirthday = memBirthday;
			this.memGender = memGender;
			this.memPhone = memPhone;
			this.memEmail = memEmail;
			this.memLocation = memLocation;
			this.memEnrollDate = memEnrollDate;
			this.bListCheck = bListCheck;
			this.leaveCheck = leaveCheck;
			this.managerCheck = managerCheck;
			this.reportCount = reportCount;
		}

		public AdminMember(int memNo, String memUserId, String memName, String memBirthday, String memPhone,
				String memEmail, Date memEnrollDate, String bListCheck) {
			super();
			this.memNo = memNo;
			this.memUserId = memUserId;
			this.memName = memName;
			this.memBirthday = memBirthday;
			this.memPhone = memPhone;
			this.memEmail = memEmail;
			this.memEnrollDate = memEnrollDate;
			this.bListCheck = bListCheck;
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

		public String getMemNickName() {
			return memNickName;
		}

		public void setMemNickName(String memNickName) {
			this.memNickName = memNickName;
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

		public int getReportCount() {
			return reportCount;
		}

		public void setReportCount(int reportCount) {
			this.reportCount = reportCount;
		}

		@Override
		public String toString() {
			return "AdminMember [memNo=" + memNo + ", localNo=" + localNo + ", memUserId=" + memUserId + ", memUserPwd="
					+ memUserPwd + ", memName=" + memName + ", memNickName=" + memNickName + ", memBirthday="
					+ memBirthday + ", memGender=" + memGender + ", memPhone=" + memPhone + ", memEmail=" + memEmail
					+ ", memLocation=" + memLocation + ", memEnrollDate=" + memEnrollDate + ", bListCheck=" + bListCheck
					+ ", leaveCheck=" + leaveCheck + ", managerCheck=" + managerCheck + ", reportCount=" + reportCount
					+ "]";
		}

}
