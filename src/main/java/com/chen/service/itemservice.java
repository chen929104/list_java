package com.chen.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chen.dao.item;

public interface itemservice {

	public Map<String, Object> insert(String context, int projectid);
	public Map<String, Object> updata(String context, int projectid,int itemid);
	public Map<String, Object> finish(String itemid);
	public Map<String, Object> select(int itemid);
	public Map<String, Object> delete(String itemid);
	public Map<String, Object> selectall( int projectid,int page, int rows);
	public Map<String, Object> deleteitem(String projectid);
	
}
