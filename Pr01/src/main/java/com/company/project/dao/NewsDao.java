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
import com.company.project.dto.NewsDto;

public class NewsDao {
	JdbcTemplate template;

	private static NewsDao instance = new NewsDao();

	public NewsDao getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oracle11g");
		Connection conn = ds.getConnection();
		return conn;
	}

	public List<NewsDto> selectAllNews(){
		String sql = "select * from news order by num desc";
		List<NewsDto> newsList = new ArrayList<NewsDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				NewsDto ndto = new NewsDto();
				ndto.setNum(rs.getInt("num"));
				ndto.setTitle(rs.getString("title"));
				ndto.setContent(rs.getString("content"));
				ndto.setCount(rs.getInt("count"));
				ndto.setReg_Date(rs.getTimestamp("reg_Date"));
				newsList.add(ndto);

				System.out.println(ndto);
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

		return newsList;
	}
	
	public void insertNews(NewsDto ndto) {
		String sql="insert into news("+"num, title, content) "+"values(news_seq.nextval,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ndto.getTitle());
			pstmt.setString(2, ndto.getContent());
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
	
	public NewsDto getNews(int num) {
		String sql = "select * from news where num = ?";
		NewsDto ndto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ndto = new NewsDto();
				ndto.setNum(rs.getInt("num"));
				ndto.setTitle(rs.getString("title"));
				ndto.setContent(rs.getString("content"));
				ndto.setCount(rs.getInt("count"));
				ndto.setReg_Date(rs.getTimestamp("reg_Date"));
				System.out.println(ndto);
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
		return ndto;
	}
	
	public void updateNews(NewsDto ndto) {
		String sql = "update news set title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ndto.getTitle());
			pstmt.setString(2, ndto.getContent());
			pstmt.setInt(3, ndto.getNum());
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
	
	public void updateCount(int num) {
		String sql = "update news set count=count+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	
	public void deleteNews(int num) {
		String sql = "delete news where num=?";
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
