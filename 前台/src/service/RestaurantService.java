package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 实体店控制器
 * @author 张国荣
 * @ClassName: RestaurantService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:25:06
 * @description 类描述
 */
public class RestaurantService {
	private String sql;
	private JDBC_Tool jt;
	private List<Map<String,String>> temp;
	public RestaurantService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询所有地址信息
	 * @author 张国荣
	 * @title: selcity
	 * @date 2016年8月14日 上午10:25:23
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selcity(){
		sql = "SELECT id,location FROM address WHERE user_id IS NULL";
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			e.put("city", e.get("location").split("市")[0]+"市");
		}
		return temp;
	}
	/**
	 * 查询地址信息
	 * @author 张国荣
	 * @title: selmessage
	 * @date 2016年8月14日 上午10:25:58
	 * @param id
	 * @return Map<String,String>
	 */
	public Map<String,String> selmessage(String id){
		sql = "SELECT id,location,phone_number,NAME,sex FROM address WHERE id = " + id;
		Map<String,String> temp = jt.queryMap(sql, null).get(0);
		temp.put("city", temp.get("location").split("市")[1]);
		return temp;
	}
}
