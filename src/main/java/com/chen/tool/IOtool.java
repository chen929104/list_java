package com.chen.tool;

import org.springframework.web.multipart.MultipartFile;

public interface IOtool {
	
	public String writeArticke(String Context);
	
	public String readArticle(String path);
	
	public  String upload(MultipartFile file, String fileName);
}
