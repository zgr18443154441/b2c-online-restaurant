package com.shxt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 邮件控制器
 * @author 张国荣
 * @ClassName: EmailService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:13:20
 * @description 类描述
 */
public class EmailService {
	private String sql;
	private JDBC_Tool jt;
	public EmailService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 发送邮件
	 * @author 张国荣
	 * @title: addEmail
	 * @date 2016年8月14日 上午10:13:32
	 * @param user_id
	 * @param words void
	 */
	public void addEmail(String user_id,String words){
		sql = "INSERT INTO email(user_id,words,write_time) VALUES(?,?,?)";
		jt.update(sql, new String[]{user_id,words,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}
	/**
	 * 查询邮件
	 * @author 张国荣
	 * @title: selEmail
	 * @date 2016年8月14日 上午10:13:47
	 * @param user_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selEmail(String user_id){
		sql = "SELECT words,write_time,reply,reply_time FROM email WHERE user_id = "  + user_id + " ORDER BY write_time DESC ";
		return jt.queryMap(sql, null);
	}
}
