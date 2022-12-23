package org.project.dao1223;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.project.dbconnect1223.DBConnect;

public class MemberDao {
	
	private static class SingleTon{
		
		private static final MemberDao INSTANCE = new MemberDao();
	}
	
	private int result;
	
	private MemberDao() {
		System.out.println("MemberDao");
	}
	
	public static MemberDao getInstance() {
		return SingleTon.INSTANCE;
	}
	
	//회원가입
	public int MemberInsertDo(String userId, String userPw, String gender, String hobbys, String city, String memo) {
		int result = 0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		try {
			conn=DBConnect.getConnection();
			query="insert into login1222(userId,userPw,gender,hobbys,city,memo)values(?,?,?,?,?,?)";
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, gender);
			pstm.setString(4, hobbys);
			pstm.setString(5, city);
			pstm.setString(6, memo);
			
			result=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
			} finally {
			}
		}
		return result;
	}
	
	//로그인 실행
	public int LoginOkDo(String userId, String userPw) {

		int result=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String query="";
		
		
		try {
			query="SELECT count(*) from login1222 where userId=? and userPw=?";
			conn = DBConnect.getConnection();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			
			rs=pstm.executeQuery();
			
			if (rs!=null) {
				while(rs.next()) {
				result=rs.getInt(1); //회원이면 1
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn!=null)
					conn.close();
					if(pstm!=null)
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}
}