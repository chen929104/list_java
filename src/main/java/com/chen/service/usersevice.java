package com.chen.service;

import java.util.Map;

import com.chen.dao.userdao;

public interface usersevice {

	public Map<String, Object> insertuser(userdao user);
	public Map<String, Object> updata(userdao user);
	public Map<String, Object> delete(int id);
	public Map<String, Object> select(String appid);
	public Map<String, Object> selectbyid(int id);
}
