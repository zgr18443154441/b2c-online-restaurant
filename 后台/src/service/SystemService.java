package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 登录信息控制器
 * @author 张国荣
 * @ClassName: SystemService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:10:06
 * @description 类描述
 */
public class SystemService {
	private String sql;
	private JDBC_Tool jt;
	public SystemService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 管理员登录
	 * @author 张国荣
	 * @title: login
	 * @date 2016年8月14日 上午2:10:26
	 * @param username
	 * @param password
	 * @return String
	 */
	public String login(String username,String password){
		sql = "SELECT username,PASSWORD,real_name FROM USER WHERE role = 1";
		List<Map<String,String>> manager = jt.queryMap(sql, null);
		String pass = new String();
		String real_name = new String();
		boolean notfound = true;
		for(Map<String,String> e : manager){
			if(e.get("username").equals(username)){
				pass = e.get("password");
				real_name = e.get("real_name");
				notfound = false;
				break;
			}
		}
		if (notfound) {
			return "username";
		}else if(!password.equals(pass)){
			return "password";
		}else{
			return real_name;
		}
	}
	public String validate(String random,String RANDOM){
		if ("".equals(random) || null == random) {
			return "请输入验证码";
		}
		if (RANDOM == null || "".equals(RANDOM)) {
			return "服务器验证码错误";
		}
		if (!random.equalsIgnoreCase(RANDOM)) {
			return "输入的验证码有误";
		}
		return "通过验证";
	}
}
