package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.dto.user_Dto;

import util.DButil;
/*
 * �û�����ط���
 */
public class admin_model {
	// ͨ��id��ѯ ����һ��admin��Dto
	public admin_Dto QueryById(String id) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		admin_Dto dto = new admin_Dto();
		try {
			String sql = "select * from admin where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();// ִ��SQL���
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
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

	// 2.�����ݿ⵼������(ȫ����admin��Ϣ)
	public  List<admin_Dto> find_admin_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<admin_Dto> list = new ArrayList<admin_Dto>();
		try {
			String sql = "select * from admin";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// ִ��SQL���
			while (rs.next()) {
				admin_Dto dto = new admin_Dto();
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
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
	//3.�������ݵ�admin����  ����admin_Dto����
	public void add_admin(admin_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into admin(id, passw) values(?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getId());
		statement.setString(2, dto.getPassw());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("���뵽admin��ɹ�!");
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
