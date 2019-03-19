package com.chen.dao;



public class userdao {

	private int userid;
	private String appid;
	private String name;
	private String heardimg;
	
	
	public int getId() {
		return userid;
	}
	public void setId(int id) {
		this.userid = id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeardimg() {
		return heardimg;
	}
	public void setHeardimg(String heardimg) {
		this.heardimg = heardimg;
	}
	
	@Override
	public String toString() {
		return "userdao [id=" + userid + ", appid=" + appid + ", name=" + name + ", heardimg=" + heardimg + "]";
	}
	
}
