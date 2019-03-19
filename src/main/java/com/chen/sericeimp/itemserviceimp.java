package com.chen.sericeimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.internal.matchers.InstanceOf.VarArgAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.item;
import com.chen.mapping.itemmapping;
import com.chen.service.itemservice;

@Service
public class itemserviceimp implements itemservice {

	@Autowired
	itemmapping im;
	
	
	public Map<String, Object> insert(String context, int projectid)
	{
		Map<String, Object> map=new HashMap<>();
		item i=new item();
		i.setContext(context);
		i.setState(0);
		i.setDate(System.currentTimeMillis());
		i.setProjectid(projectid);
		im.insert(i);
		map.put("mag", 1);
		return map;
		
	}
	public Map<String, Object> updata(String context, int projectid,int itemid)
	{
		Map<String, Object> map=new HashMap<>();
		item i=new item();
		i.setContext(context);
		i.setProjectid(projectid);
		i.setDate(System.currentTimeMillis());
		i.setItemid(itemid);
		im.updata(i);
		map.put("mag", 1);
		return map;
	}
	public Map<String, Object> finish(String itemid)
	{
		Map<String, Object> map=new HashMap<>();
		String string[]=itemid.split(",");
		List<item> list=new ArrayList();
		int a=1;
		for(String ss:string) 
		{
			item i=new item();
			i.setState(a);
			i.setItemid(Integer.parseInt(ss));
			list.add(i);
		}
		for(item i:list)
		{
			System.out.println(i.toString());
		}
		im.finish(list);
		map.put("mag", 1);
		return map;
	}
	public Map<String, Object> select(int itemid)
	{
		Map<String, Object> map=new HashMap<>();
		item item =im.select(itemid);
		map.put("data", item);
		return map;
	}
	public Map<String, Object> delete(String itemid)
	{
		Map<String, Object> map=new HashMap<>();
		String string[]=itemid.split(",");
		List<String> list=new ArrayList();
		for(String ss:string) 
		{
			list.add(ss);
		}
		im.delete(list);
		map.put("mag", 1);
		return map;
	}
	public Map<String, Object> selectall( int projectid,int page, int rows)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("data",im.selectall(projectid, page, rows));
		map.put("total", im.getTotal(projectid));
		return map;
		
	}
	public Map<String, Object> deleteitem(String projectid)
	{
		Map<String, Object> map=new HashMap<>();
		String string[]=projectid.split(",");
		List<String> list=new ArrayList();
		for(String ss:string) 
		{
			list.add(ss);
		}
		im.delete(list);
		im.deleteitem(list);
		map.put("mag", 1);
		return map;
	}
}
