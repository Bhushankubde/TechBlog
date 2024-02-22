package com.techblog.entites;

import java.sql.Timestamp;

public class Post {

	private int pid;
	private String pTitle;
	private String pContent;
	private String pCode;
	private Timestamp pDate;
	private int catID;
	private int userID;
	
	public Post() {
		
	}

	public Post(int pid, String pTitle, String pContent, String pCode, Timestamp pDate, int catID,int userID) {
		
		this.pid = pid;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pDate = pDate;
		this.catID = catID;
		this.userID = userID;
	}

	public Post(String pTitle, String pContent, String pCode, Timestamp pDate, int catID,int userID) {
		
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pDate = pDate;
		this.catID = catID;
		this.userID = userID;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
