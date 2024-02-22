package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DislikeDao {
	 
	 Connection con;

	public DislikeDao(Connection con) {
		this.con = con;
	}
	 
	public boolean insertDisLike(int pdid, int udid) {
		  
		   boolean f=false;
		
		try {
			
			String q = "insert into disliked(pdid,udid)values(?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(q);
			pstmt.setInt(1, pdid);
			pstmt.setInt(2, udid);
		    pstmt.executeUpdate();
		    f=true;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countDisLikeOnPost(int pdid) {
		
		int count = 0;
		try {
			
			String q = "select count(*) from disliked where pdid=?";
	        PreparedStatement p = this.con.prepareStatement(q);
	        p.setInt(1, pdid);
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


