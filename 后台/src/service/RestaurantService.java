package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Restaurant;
import com.shxt.util.JDBC_Tool;
/**
 * 实体店信息控制器
 * @author 张国荣
 * @ClassName: RestaurantService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:03:44
 * @description 类描述
 */
public class RestaurantService {
	private String sql;
	private JDBC_Tool jt;
	private List<Map<String,String>> temp;
	private Map<String,String> temp2;
	private Restaurant re;
	public RestaurantService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询所有实体店信息
	 * @author 张国荣
	 * @title: selRestList
	 * @date 2016年8月14日 上午2:03:55
	 * @return List<Restaurant>
	 */
	public List<Restaurant> selRestList(){
		List<Restaurant> rest_list = new ArrayList<>();
		sql = "SELECT id,location,phone_number,NAME,sex FROM address WHERE user_id IS NULL";
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			re = new Restaurant();
			re.setId(Integer.parseInt(e.get("id")));
			re.setArea(e.get("location").split("市")[0]+"市");
			re.setLocation(e.get("location").split("市")[1]);
			re.setManager(e.get("name"));
			re.setPhone_number(e.get("phone_number"));
			re.setSex(e.get("sex"));
			rest_list.add(re);
		}
		return rest_list;
	}
	/**
	 * 查询省份信息
	 * @author 张国荣
	 * @title: selProvince
	 * @date 2016年8月14日 上午2:04:06
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selProvince(){
		sql = "SELECT id,local_name FROM map WHERE province IS NULL";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询城市信息
	 * @author 张国荣
	 * @title: selCity
	 * @date 2016年8月14日 上午2:04:18
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selCity(String id){
		sql = "SELECT id,local_name FROM map WHERE province = " + id;
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询所有地址信息
	 * @author 张国荣
	 * @title: allMap
	 * @date 2016年8月14日 上午2:04:34
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> allMap(){
		sql = "SELECT id,local_name FROM map";
		return jt.queryMap(sql, null);
	}
	/**
	 * 新店加盟
	 * @author 张国荣
	 * @title: addRestaurant
	 * @date 2016年8月14日 上午2:04:49
	 * @param re void
	 */
	public void addRestaurant(Restaurant re){
		sql = "INSERT INTO address(location,phone_number,NAME,sex) VALUES(?,?,?,?)";
		jt.update(sql, new String[]{re.getLocation(),re.getPhone_number(),re.getManager(),re.getSex()});
	}
	/**
	 * 标记已经存在分店的城市
	 * @author 张国荣
	 * @title: addPlace
	 * @date 2016年8月14日 下午1:02:33
	 * @param map_id void
	 */
	public void addPlace(String map_id){
		sql = "UPDATE map SET state = 1 WHERE id = " + map_id;
		jt.update(sql);
	}
	/**
	 * 查询一家实体店
	 * @author 张国荣
	 * @title: selOneRestaurant
	 * @date 2016年8月14日 上午2:04:58
	 * @param id
	 * @return Restaurant
	 */
	public Restaurant selOneRestaurant(String id){
		sql = "SELECT id,location,phone_number,NAME,sex FROM address WHERE id =" + id;
		temp2 = jt.queryMap(sql, null).get(0);
		re = new Restaurant();
		re.setId(Integer.parseInt(temp2.get("id")));
		re.setArea(temp2.get("location").split("市")[0]+"市");
		re.setLocation(temp2.get("location").split("市")[1]);
		re.setManager(temp2.get("name"));
		re.setPhone_number(temp2.get("phone_number"));
		re.setSex(temp2.get("sex"));
		return re;
	}
	/**
	 * 修改实体店信息
	 * @author 张国荣
	 * @title: updateRestaurant
	 * @date 2016年8月14日 上午2:05:12
	 * @param re void
	 */
	public void updateRestaurant(Restaurant re){
		sql = "UPDATE address SET location=?,phone_number=?,NAME=?,sex=? WHERE id = ?";
		jt.update(sql, new String[]{re.getLocation(),re.getPhone_number(),re.getManager(),re.getSex(),String.valueOf(re.getId())});
	}
	/**
	 * 删除实体店
	 * @author 张国荣
	 * @title: deleteRestaurant
	 * @date 2016年8月14日 上午2:05:23
	 * @param id void
	 */
	public void deleteRestaurant(String id){
		sql = "DELETE FROM address WHERE id = " + id;
		jt.update(sql);
	}
}
