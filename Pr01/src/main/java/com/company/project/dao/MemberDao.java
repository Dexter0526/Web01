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

import com.company.project.dto.MemberDto;
import com.company.project.util.constant;

public class MemberDao {
	JdbcTemplate template;

	public MemberDao() {
		this.template = constant.template;
	}

	private static MemberDao instance = new MemberDao();

	public MemberDao getInstance() {

		return instance;
	}

	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle11g");
		Connection conn = ds.getConnection();
		return conn;
	}

	public int userCheck(String email, String pwd) {
		int result = -1;
		String sql = "select pwd from member where email = ?";
		System.out.println("email = " + email);
		System.out.println("pwd = " + pwd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = 1;
				}else result = 0;
			}else result = -1;

		}catch(Exception e){
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
		
		return result;
	}

	public MemberDto getMember(String email) {
		MemberDto mdto = null;
		String sql = "select * from member where email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAdmin(rs.getInt("admin"));
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
		return mdto;
	}
	public List<MemberDto> selectAllMember() {
		String sql = "select * from member order by admin asc";
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAdmin(rs.getInt("admin"));
				memberList.add(mdto);
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
		return memberList;
	}

	public int confirmEmail(String email) {
		int result = -1;
		String sql = "select email from member where email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else result = -1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember(MemberDto mdto) {
		int result = -1;
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getEmail());
			pstmt.setString(3, mdto.getPwd());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setInt(5, mdto.getAdmin());
			result = pstmt.executeUpdate();
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

		return result;
	}

	public int updateMember(MemberDto mdto) {
		int result = -1;
		String sql = "update member set pwd=?, phone = ?," + "admin = ? where email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getPwd());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setInt(3, mdto.getAdmin());
			pstmt.setString(4, mdto.getEmail());
			result = pstmt.executeUpdate();
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

		return result;
	}
	
	public void memberDelete(String email) {
		String sql = "delete from member where email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
