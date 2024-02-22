package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.techblog.entites.Category;
import com.techblog.entites.Post;

public class PostDao {
	
	Connection con;

	public PostDao(Connection con) {
		this.con = con;
	}
	
	public ArrayList<Category> getAllCategories(){
		ArrayList<Category> list=new ArrayList<>();
		
		try {
			
			String q = "select *from categories";
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while (rs.next()) {
				
				int cid = rs.getInt("cid");
				String name = rs.getString("name"); 
				String description = rs.getString("description");
				
				Category c = new Category(cid,name,description);
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
        return list;		
	}
	
	public boolean savePost(Post p) {
		boolean f=false;
		try {
			
			String q = "insert into post (pTitle,pContent,pCode,catID,userID)values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1,p.getpTitle());
			pstmt.setString(2,p.getpContent());
			pstmt.setString(3,p.getpCode());
			pstmt.setInt(4, p.getCatID());
			pstmt.setInt(5, p.getUserID());
			
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		
		return f;
	}
	
	//get all the posts
	
	public List<Post>getAllPosts(){
		
		List<Post> list = new ArrayList<>();
		//fetch the posts
		try {
			
			PreparedStatement pstmt = con.prepareStatement("select *from post order by pid desc");
			ResultSet rs = pstmt.executeQuery();
		     
			while (rs.next()) {
				
				int pid = rs.getInt("pid");
				String pTitle = rs.getString("pTitle");
				String pContent = rs.getString("pContent");
				String pCode = rs.getString("pCode");
				Timestamp date = rs.getTimestamp("pDate");
				int catID = rs.getInt("catID");
				int userID = rs.getInt("userID");
				
				Post post = new Post(pid,pTitle,pContent,pCode,date,catID,userID);
				
				list.add(post);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	//get posts by id
	public List<Post>getAllPostByCatid(int catID){

		List<Post> list = new ArrayList<>();
		//fetch the post by id
         try {
        	 PreparedStatement pstmt = con.prepareStatement("select *from post where catID=?");
        	 pstmt.setInt(1, catID);
 			ResultSet rs = pstmt.executeQuery();
 		     
 			while (rs.next()) {
 				
 				int pid = rs.getInt("pid");
 				String pTitle = rs.getString("pTitle");
 				String pContent = rs.getString("pContent");
 				String pCode = rs.getString("pCode");
 				Timestamp date = rs.getTimestamp("pDate");
 				int userID = rs.getInt("userID");
 				
 				Post post = new Post(pid,pTitle,pContent,pCode,date,catID,userID);
 				
 				list.add(post);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	
	}
	
   public Post getPostByPostId(int postID) {
	    Post post=null;
	   try {
		   String q = "select *from post where pid=?";	
		 PreparedStatement pstmt =this.con.prepareStatement(q);
		 pstmt.setInt(1, postID);
		 ResultSet rs = pstmt.executeQuery();
		 if (rs.next()) {
			 
			    int pid = rs.getInt("pid");
				String pTitle = rs.getString("pTitle");
				String pContent = rs.getString("pContent");
				String pCode = rs.getString("pCode");
				Timestamp date = rs.getTimestamp("pDate");
				int userID = rs.getInt("userID");
				int cid = rs.getInt("catID");
				
				 post = new Post(pid,pTitle,pContent,pCode,date,cid,userID);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return post;
	 
	}

}


