package com.javachip.carrotcountry.member.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import com.javachip.carrotcountry.member.model.dao.MemberDao;
import com.javachip.carrotcountry.member.model.vo.Member;

import java.sql.Connection;

	public class MemberService {
		
		public Member loginMember(String memUserId, String memUserPwd) {
			
			Connection conn = getConnection();
			
			Member m = new MemberDao().loginMember(conn, memUserId, memUserPwd);
			
			close(conn);
			
			return m;
			
		}
		
		
		
		
}
