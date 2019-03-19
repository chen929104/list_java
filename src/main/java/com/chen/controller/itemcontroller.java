package com.chen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.service.itemservice;

@Controller
@RequestMapping(value="/item")
@CrossOrigin
public class itemcontroller {
	
	@Autowired 
	itemservice is;
	
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(String context, int projectid)
	{
		Map<String, Object> map=new HashMap<>();
		map=is.insert(context,  projectid);
		
		return map;
	}
	
	@RequestMapping(value="/updata" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updata(String context, int projectid ,int itemid)
	{
		Map<String, Object> map=new HashMap<>();
		map=is.updata(context,  projectid ,itemid);
		return map;
	}
	@RequestMapping(value="/finish")
	@ResponseBody
	public Map<String, Object> finish(String itemid)
	{
		Map<String, Object> map=new HashMap<>();
		map=is.finish(itemid);
		
		return map;
	}
	
	@RequestMapping(value="/select")
	@ResponseBody
	public Map<String, Object> select(int itemid)
	{
		Map<String, Object> map=new HashMap<>();
		map=is.select(itemid);
		
		return map;
	}
	@RequestMapping(value="/delete")
	@ResponseBody
	public Map<String, Object> delete(String itemid)
	{
		Map<String, Object> map=new HashMap<>();
		map=is.delete(itemid);
		
		return map;
	}
	
	@RequestMapping(value="/selectall")
	@ResponseBody
	public Map<String, Object> selectall( int projectid,int page, int rows)
	{
		Map<String, Object> map=new HashMap<>();
		page=page*rows;
		map=is.selectall(projectid, page, rows);
		return map;
	}
	@RequestMapping(value="/deleeteitem")
	@ResponseBody
	public Map<String, Object> deleeteitem( String projectid)
	{
		Map<String, Object> map=new HashMap<>();
		
		map=is.deleteitem(projectid);
		return map;
	}
}
