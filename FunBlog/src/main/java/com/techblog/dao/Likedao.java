package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Likedao {
	
	Connection con;
	   
	public Likedao(Connection con) {
		this.con = con;
	}


	public boolean insertLike(int pid, int uid) {
		  
		   boolean f=false;
		
		try {
			
			String q = "insert into liked (pid,uid)values(?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(q);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, uid);
		    pstmt.executeUpdate();
		    f=true;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countLikeOnPost(int pid) {
		
		int count = 0;
		try {
			
			String q = "select count(*) from liked where pid=?";
	        PreparedStatement p = this.con.prepareStatement(q);
	        p.setInt(1, pid);
	        ResultSet rs = p.executeQuery();
	        if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
		return count;
		
	}
	
}
