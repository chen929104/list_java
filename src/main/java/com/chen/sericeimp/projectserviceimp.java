package com.chen.sericeimp;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.project;
import com.chen.mapping.projectmapping;
import com.chen.service.projectservice;

@Service
public class projectserviceimp implements projectservice{

	@Autowired
	projectmapping pm;
	
	public Map<String, Object> insert(project project)
	{
		Map<String, Object> map=new HashMap<>();
		project.setDate(System.currentTimeMillis());
		pm.insert(project);
		map.put("msg", 1);
		
		return map;
	}
	public  Map<String, Object> updata(project project)
	{
		Map<String, Object> map=new HashMap<>();
		pm.updata(project);
		map.put("msg", 1);
		
		return map;
	}
	public Map<String, Object> select(int projectid)
	{
		Map<String, Object> map=new HashMap<>();
		project project=pm.select(projectid);
		map.put("data", project);
		return map;
	}
	public Map<String, Object> selectall( int userid,int page, int rows)
	{
		Map<String, Object> map=new HashMap<>();
		List<project> list=pm.selectall(userid, page, rows);
		int total= pm.getTotal(userid);
		map.put("data", list);
		map.put("total", total);
		return map;
		
	}
	public Map<String, Object> delete(String projectid)
	{
		Map<String, Object> map=new HashMap<>();
		String string[]=projectid.split(",");
		List<String> list=new ArrayList();
		for(String ss:string) 
		{
			list.add(ss);
		}
		pm.delete(list);
		map.put("msg", 1);
		return map;
	}
}
