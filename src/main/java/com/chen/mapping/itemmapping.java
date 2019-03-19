package com.chen.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.dao.item;


public interface itemmapping {
	
	public void insert(item item);
	public void updata(item item);
	public item select(int itemid);
	public List<item> selectall(@Param(value="projectid") int projectid,@Param(value="page")int page, @Param(value="rows")int rows);
	public void delete(List itemid);
	public void deleteitem(List projectid);
	public int getTotal(int projectid);
	public void finish(List<item> list);
}
