package com.chen.toolimp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chen.tool.IOtool;


@Service
public class IOtoolimp implements IOtool {

	/**	
	 * 写入文章
	 */
	public String writeArticke(String Context) 
	{
		long times=System.currentTimeMillis();
		System.out.println(times);
		String path="article/"+times+".html";
		
		File file=new File("src/main/resources/templates/"+path);

		try {
			FileOutputStream out=new FileOutputStream(file);
			
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
			
			bw.write(Context);
			
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 *  读取文章
	 */
	public String readArticle(String path)
	{
		
		String context="";
		File file=new File(path);
		try {
			InputStreamReader reader=new InputStreamReader(new FileInputStream(file),"utf-8");
			
			BufferedReader br=new BufferedReader(reader);
			context=br.readLine();
			while(br.read()>0) 
			{
				context=context+"<br/>"+br.readLine();
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context;
		
	}
	
	 /**
    *
    * @param file 文件
    * @param path 文件存放路径
    * @param fileName 源文件名
    * @return
    */
   public  String upload(MultipartFile file, String fileName){

      
       String path = "src/main/resources/static/image";
//       String absolutePath=new File(path).getAbsoluteFile()+"/"+fileName;
       String absolutePath = this.getClass().getResource("/").getPath()+"/static/image/"+fileName;
       File dest = new File(absolutePath);
   
       //判断文件父目录是否存在
       if(!dest.getParentFile().exists()){
           dest.getParentFile().mkdir();
       }

       try {
           //保存文件
           file.transferTo(dest);
           return "image"+"/"+fileName;
       } catch (IllegalStateException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           return "false";
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           return "false";
       }

   }

}
