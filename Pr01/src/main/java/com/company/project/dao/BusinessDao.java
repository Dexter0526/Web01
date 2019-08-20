package com.company.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.company.project.dto.BusinessDto;
import com.company.project.util.constant;

public class BusinessDao {
	JdbcTemplate template;
	
	public BusinessDao() {
		this.template = constant.template;
	}
	
	private static BusinessDao instance = new BusinessDao();
	
	public BusinessDao getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle11g");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public List<BusinessDto> selectAllBusiness(String table){
		String sql = "select * from " + table + " order by num desc";
		List<BusinessDto> businessList = new ArrayList<BusinessDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BusinessDto bdto = new BusinessDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setField(rs.getString("field"));
				businessList.add(bdto);
				
				System.out.println(bdto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return businessList;
	}
	
	public void insertBusiness(BusinessDto bdto, String table) {
		String sql = "insert into "+table+"("+"num, title, content, field) "
					+"values("+table+"_seq.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(sql);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getTitle());
			pstmt.setString(2, bdto.getContent());
			pstmt.setString(3, bdto.getField());

			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public BusinessDto getBusiness(String num, String table) {
		String sql = "select * from "+table+" where num = ?";
		BusinessDto bdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdto = new BusinessDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setField(rs.getString("field"));
				
				System.out.println(bdto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return bdto;
	}
	
	public void updateBusiness(BusinessDto bdto, String table) {
		String sql = "update "+table+" set title=?, content=?, field=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getTitle());
			pstmt.setString(2, bdto.getContent());
			pstmt.setString(3, bdto.getField());
			pstmt.setInt(4, bdto.getNum());
			System.out.println(sql);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteBusiness(int num, String table) {
		String sql = "delete "+table+" where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
