package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.dto.article_colect_Dto;

import util.DButil;

/*
 * �����ռ�����ط���
 */
public class article_colect_model {
	//1.ͨ��useerid��ѯ ����һ��article_colect��Dto
	public article_colect_Dto QueryByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		article_colect_Dto dto = new article_colect_Dto();
		try {
			String sql = "select * from article_colect where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// ִ��SQL���
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
	// 2.�����ݿ⵼������(ȫ����article_colect��Ϣ)
	public List<article_colect_Dto> find_article_colect() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_colect_Dto> list = new ArrayList<article_colect_Dto>();
		try {
			String sql = "select * from article_colect";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// ִ��SQL���
			while (rs.next()) {
				article_colect_Dto dto = new article_colect_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
	//3.�������ݵ�article_colect����  ����article_colect_Dto����
	public void add_article_colect(article_colect_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into article_colect(userid, arcid, col_time, uncol_time) values(?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getArcid());
		statement.setString(3, dto.getCol_time());
		statement.setString(4, dto.getUncol_time());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("���뵽article_colect��ɹ�!");
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

	// 4.ͨ��userid�����ݿ⵼������(ȫ����article_colect��Ϣ)
	public List<article_colect_Dto> find_article_colect_DtoByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_colect_Dto> list = new ArrayList<article_colect_Dto>();
		try {
			String sql = "select * from article_colect where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// ִ��SQL���
			while (rs.next()) {
				article_colect_Dto dto = new article_colect_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
}
