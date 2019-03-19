package com.chen.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chen.dao.userdao;
import com.chen.service.usersevice;
import com.chen.ssl.MyX509TrustManager;
import com.chen.tool.IOtool;



@Controller
@RequestMapping(value="/user")
@CrossOrigin
public class usercontroller {

	@Autowired
	usersevice us;
	@Autowired
	IOtool io;
	
	
	@RequestMapping(value="/a1")
	@ResponseBody
	public String name() {
		String a="test";
		return a;
	}
	@RequestMapping(value="/getappid",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getappid(@Param(value="code") String code) 
	{
		Map<String,Object> map=new HashMap();
		System.out.println(code.toString());
		String appid="wx3f340732f3397c37";
		String secret="9252857183f306fe95bfce795875f571";
		StringBuffer buffer=null;
	    String url1="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
		try{
			SSLContext sslContext=SSLContext.getInstance("SSL"); 
			TrustManager[] tm={new MyX509TrustManager()}; 
			//初始化 
			sslContext.init(null, tm, new java.security.SecureRandom());; 
			//获取SSLSocketFactory对象 
			SSLSocketFactory ssf=sslContext.getSocketFactory(); 
			URL url=new URL(url1);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			//读取服务器端返回的内容
			InputStream is=conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			
			 buffer=new StringBuffer();
			 
			String line=null;
			while((line=br.readLine())!=null){
				buffer.append(line);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		String arr[]=buffer.toString().split(",");
		String arr1[];
		for(String ss:arr) 
		{
			arr1=ss.split(":");
			
			map.put(arr1[0].substring(arr1[0].indexOf("\"") + 1, arr1[0].lastIndexOf("\"")),arr1[1].substring(arr1[1].indexOf("\"") + 1, arr1[1].lastIndexOf("\"")));
		}
		
		
		return map;
	}
	
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adduser(String appid,String name,String hreadimg) {
		Map<String, Object> map=new HashMap<>();
		userdao user=new userdao();
		user.setAppid(appid);
		user.setHeardimg(hreadimg);
		user.setName(name);
		map=us.insertuser(user);
		return map;
	}
	@RequestMapping(value="/updatauser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatauser(String appid,String name,String hreadimg,int id) {
		Map<String, Object> map=new HashMap<>();
		userdao user=new userdao();
		user.setId(id);
		user.setAppid(appid);
		user.setHeardimg(hreadimg);
		user.setName(name);
		map=us.updata(user);
		return map;
	}
	
	@RequestMapping(value="/selectuser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectuser(String appid) {
		Map<String, Object> map=new HashMap<>();
		map=us.select(appid);
		return map;
	}
	@RequestMapping(value="/selectbyid",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectbyid(int id) {
		Map<String, Object> map=new HashMap<>();
		map=us.selectbyid(id);
		return map;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(int id) {
		Map<String, Object> map=new HashMap<>();
		map=us.delete(id);
		return map;
	}
	@RequestMapping(value="/image" , method=RequestMethod.POST)
	@ResponseBody
    public String upload(@RequestParam("fileName") MultipartFile image){


       // 上传成功或者失败的提示
       String msg = "";
       String path=io.upload(image , image.getOriginalFilename());
       if (path!="false"){
           // 上传成功，给出页面提示
           msg = "上传成功！";
       }else {
           msg = "上传失败！";

       }
       Map<String, Object> map=new HashMap<>();
       // 显示图片
       map.put("msg", msg);
       map.put("path",path);
       

       return path;
   }
	

}
