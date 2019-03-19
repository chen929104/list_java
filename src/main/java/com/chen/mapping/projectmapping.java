package com.chen.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chen.dao.project;

@Mapper
public interface projectmapping {

	public void insert(project project);
	public void updata(project project);
	public project select(int projectid);
	public List<project> selectall(@Param(value="userid") int userid,@Param(value="page")int page, @Param(value="rows")int rows);
	public void delete(List projectid);
	public int getTotal(int userid);
	
}
