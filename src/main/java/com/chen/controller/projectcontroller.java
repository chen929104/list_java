package com.chen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.dao.project;
import com.chen.service.projectservice;

@Controller
@RequestMapping(value="/project")
@CrossOrigin
public class projectcontroller {

	@Autowired
	projectservice ps;
	
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(String title, String context,String image,int userid)
	{
		Map<String, Object> map=new HashMap<>();
		project project=new project();
		project.setContext(context);;
		project.setImage(image);
		project.setTitle(title);
		project.setUserid(userid);
		map=ps.insert(project);
		return map;
	}
	
	@RequestMapping(value="/updata" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updata(int projectid,String title, String context,String image,int userid)
	{
		Map<String, Object> map=new HashMap<>();
		project project=new project();
		project.setProjectid(projectid);
		project.setContext(context);;
		project.setImage(image);
		project.setTitle(title);
		project.setUserid(userid);
		map=ps.updata(project);
		return map;
	}
	
	@RequestMapping(value="/select")
	@ResponseBody
	public Map<String, Object> select(int projectid)
	{
		Map<String, Object> map=new HashMap<>();
		map=ps.select(projectid);
		return map;
	}
	@RequestMapping(value="/selectall")
	@ResponseBody
	public Map<String, Object> selectall(int userid,int page, int rows)
	{
		Map<String, Object> map=new HashMap<>();
		page=page*rows;
		map=ps.selectall(userid, page, rows);
		return map;
	}
	@RequestMapping(value="/delete")
	@ResponseBody
	public Map<String, Object> delete(String projectid)
	{
		Map<String, Object> map=new HashMap<>();
		map=ps.delete(projectid);
		return map;
	}
}
