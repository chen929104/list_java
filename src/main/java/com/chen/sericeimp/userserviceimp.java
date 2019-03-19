package com.chen.sericeimp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.userdao;
import com.chen.mapping.usermapping;
import com.chen.service.usersevice;
@Service
public class userserviceimp implements usersevice {

	@Autowired
	usermapping um;
	@Override
	public Map<String, Object> insertuser(userdao user) {
		Map<String, Object> map=new HashMap<>();
		userdao userdao=um.select(user.getAppid());
	    if(userdao==null) 
	    {
		um.insertuser(user);
		userdao=um.select(user.getAppid());
	    }
	    map.put("data",userdao);
		return map;
	}

	@Override
	public Map<String, Object> updata(userdao user) {
		Map<String, Object> map=new HashMap<>();
		um.updata(user);
		map.put("msg", 1);
		return map;
	}

	@Override
	public Map<String, Object> select(String appid) {
		Map<String, Object> map=new HashMap<>();
		userdao user=um.select(appid);
		map.put("data", user);
		return map;
	}
	@Override
	public Map<String, Object> selectbyid(int id) {
		Map<String, Object> map=new HashMap<>();
		userdao user=um.selectbyid(id);
		map.put("data", user);
		return map;
	}
	@Override
	public Map<String, Object> delete(int id) {
		Map<String, Object> map=new HashMap<>();
		um.delete(id);
		map.put("msg", 1);
		return map;
	}

}
