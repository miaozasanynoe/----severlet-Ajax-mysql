package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.lock_user_Dto;
import com.dto.notice_Dto;

import util.DButil;

public class notice_model {
	//1.ͨ��admin_id��ѯ ����һ��notice��Dto
	public notice_Dto QueryByAdminId(String admin_id) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		notice_Dto dto = new notice_Dto();
		try {
			String sql = "select * from notice where admin_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin_id);
			rs = pstmt.executeQuery();// ִ��SQL���
			if (rs.next()) {
				dto.setNotice_text(rs.getString("notice_text"));
				dto.setTime(rs.getString("time"));
				dto.setAdmin_id(rs.getString("admin_id"));
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
	// 2.�����ݿ⵼������(ȫ����notice��Ϣ)
	public  List<notice_Dto> find_notice_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<notice_Dto> list = new ArrayList<notice_Dto>();
		try {
			String sql = "select * from notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// ִ��SQL���
			while (rs.next()) {
				notice_Dto dto = new notice_Dto();
				dto.setNotice_text(rs.getString("notice_text"));
				dto.setTime(rs.getString("time"));
				dto.setAdmin_id(rs.getString("admin_id"));
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
	//3.�������ݵ�notice����  ����notice_Dto����
	public void add_notice(notice_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into notice(notice_text, time, admin_id) values(?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getNotice_text());
		statement.setString(2, dto.getTime());
		statement.setString(3, dto.getAdmin_id());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("���뵽notice��ɹ�!");
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
