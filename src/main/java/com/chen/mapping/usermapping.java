package com.chen.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chen.dao.userdao;
@Mapper
public interface usermapping {
	
	public void insertuser(userdao user);
	public void updata(userdao user);
	public userdao select(String appid);
	public userdao selectbyid(int userid);
	public void delete(int userid);
	
}
