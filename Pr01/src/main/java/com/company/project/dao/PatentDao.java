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

import com.company.project.dto.PatentDto;
import com.company.project.util.constant;

public class PatentDao {
	JdbcTemplate template;

	public PatentDao() {
		this.template = constant.template;
	}

	private static MemberDao instance = new MemberDao();

	private static MemberDao getInstance() {

		return instance;
	}

	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle11g");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public PatentDto getPatent(String patentNum) {
		String sql = "select * from patent where patentnum=?";
		
		PatentDto pdto = new PatentDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patentNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pdto.setNum(rs.getInt("num"));
				pdto.setPatentNum(rs.getString("patentnum"));
				pdto.setTitle(rs.getString("title"));
				pdto.setContent(rs.getString("content"));
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
		
		return pdto;
	}

	public List<PatentDto> selectAllPatent(){
		String sql = "select * from patent order by num desc";
		List<PatentDto> patentList = new ArrayList<PatentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PatentDto pdto = new PatentDto();
				pdto.setNum(rs.getInt("num"));
				pdto.setPatentNum(rs.getString("patentnum"));
				pdto.setTitle(rs.getString("title"));
				pdto.setContent(rs.getString("content"));
				patentList.add(pdto);
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
		return patentList;
	}

	public void insertPatent(PatentDto pdto) {
		String sql = "insert into patent(" + "num, patentnum, title, content) " + "values(patent_seq.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getPatentNum());
			pstmt.setString(2, pdto.getTitle());
			pstmt.setString(3, pdto.getContent());

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
	
	public void updatePatent(PatentDto pdto) {
		String sql = "update patent set patentnum=?, title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getPatentNum());
			pstmt.setString(2, pdto.getTitle());
			pstmt.setString(3, pdto.getContent());
			pstmt.setInt(4, pdto.getNum());
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
	
	public void deletePatent(String patentNum) {
		String sql = "delete patent where patentnum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, patentNum);
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
