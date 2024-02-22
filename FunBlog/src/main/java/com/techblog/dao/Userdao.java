package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

import javax.xml.crypto.Data;

import com.techblog.entites.User;

public class Userdao {
	
	private Connection con;

	public Userdao(Connection con) {
		this.con = con;
	}
	
	public boolean saveUser(User user) {
		boolean f=false;
		try {
			String q ="INSERT INTO user(name,email,password,gender,about)values(?,?,?,?,?)"; 
			PreparedStatement pstmt = this.con.prepareStatement(q);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());	
		    pstmt.executeUpdate();
		    f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User getUserEmailandUserPassword(String email, String password) {
		User user=null;
				try {
					String q= "SELECT *FROM user WHERE email=? and password=?";
					PreparedStatement pstmt = con.prepareStatement(q);
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						user = new User();
						/* Data from Db */
						
						String name = rs.getString("name");
						
						/* Set to user object */
						user.setName(name);
						user.setId(rs.getInt("id"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						user.setGender(rs.getString("gender"));
						user.setDateTime(rs.getTimestamp("regdt"));
						user.setAbout(rs.getString("about"));
						user.setProfile(rs.getString("profile"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		return user;
				
	}
	public boolean updateData(User user) {
		boolean f=false;
		try {
			String q = "update user set name=?, email=?, password=?, gender=?, about=?, profile=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());
			pstmt.setString(6, user.getProfile());
			pstmt.setInt(7, user.getId());
			
			pstmt.executeUpdate();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	public User getUserIdByusertId(int userID) {
		User user = null;
		
		try {
		  String q = "select *from user where id=?";	
		  PreparedStatement pstmt = this.con.prepareStatement(q);
		  pstmt.setInt(1, userID);
		  ResultSet rs = pstmt.executeQuery();
		  if (rs.next()) {
			   
			  user = new User();
				/* Data from Db */
				
				String name = rs.getString("name");
				
				/* Set to user object */
				user.setName(name);
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setDateTime(rs.getTimestamp("regdt"));
				user.setAbout(rs.getString("about"));
				user.setProfile(rs.getString("profile"));
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
		
	}

}
