package com.chen.dao;

public class item {

	private int itemid;
	private int projectid;
	private long date;
	private String context;
	private int state;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "item [itemid=" + itemid + ", projrctid=" + projectid + ", date=" + date + ", context=" + context
				+ ", state=" + state + "]";
	}
}
