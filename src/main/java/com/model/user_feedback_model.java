package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.lock_user_Dto;
import com.dto.notice_Dto;
import com.dto.user_feedback_Dto;

import util.DButil;

public class user_feedback_model {
	//1.ͨ��userid��ѯ ����һ��user_feedback��Dto
	public user_feedback_Dto QueryByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		user_feedback_Dto dto = new user_feedback_Dto();
		try {
			String sql = "select * from user_feedback where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// ִ��SQL���
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setTime(rs.getString("time"));
				dto.setType(rs.getString("type"));
				dto.setFeedtext(rs.getString("feedtext"));
				dto.setId(rs.getString("id"));
			}
			// �رգ��ͷ���Դ
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	// 2.�����ݿ⵼������(ȫ����user_feedback��Ϣ)
	public  List<user_feedback_Dto> find_user_feedback_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<user_feedback_Dto> list = new ArrayList<user_feedback_Dto>();
		try {
			String sql = "select * from user_feedback";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// ִ��SQL���
			while (rs.next()) {
				user_feedback_Dto dto = new user_feedback_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setTime(rs.getString("time"));
				dto.setType(rs.getString("type"));
				dto.setFeedtext(rs.getString("feedtext"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
			// �رգ��ͷ���Դ
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//3.�������ݵ�user_feedback����  ����user_feedback_Dto����
	public void add_user_feedback(user_feedback_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into user_feedback(userid, time, type,feedtext,id) values(?,?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getTime());
		statement.setString(3, dto.getType());
		statement.setString(4, dto.getFeedtext());
		statement.setString(5, dto.getId());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("���뵽user_feedback��ɹ�!");
		}
	}
	catch(Exception e1) {
		e1.printStackTrace();
		System.out.println(e1.getMessage());
	}
	finally 
	{
		try {
			statement.close();
			conn.close();
		}
		catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
    
   }
}
