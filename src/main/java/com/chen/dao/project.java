package com.chen.dao;

public class project {

	private int projectid;
	private int userid;
	private String title;
	private String context;
	private String image;
	private long date;
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return "project [prijectid=" + projectid + ", userid=" + userid + ", title=" + title + ", context=" + context
				+ ", image=" + image + ", date=" + date + "]";
	}
	
	
}
