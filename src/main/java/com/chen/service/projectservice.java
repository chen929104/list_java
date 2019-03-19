package com.chen.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chen.dao.project;

public interface projectservice {
	
	public Map<String, Object> insert(project project);
	public  Map<String, Object> updata(project project);
	public Map<String, Object> select(int projectid);
	public Map<String, Object> selectall(@Param(value="userid") int userid,@Param(value="page")int page, @Param(value="rows")int rows);
	public Map<String, Object> delete(String projectid);
}
