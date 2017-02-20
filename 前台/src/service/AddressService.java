package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Address;
import com.shxt.util.JDBC_Tool;
/**
 * 收货地址控制器
 * @author 张国荣
 * @ClassName: AddressService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:55:12
 * @description 类描述
 */
public class AddressService {
	private String sql;
	private JDBC_Tool jt;
	private Address add;
	private List<Map<String,String>> temp;
	public AddressService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询一个用户的所有地址信息
	 * @author 张国荣
	 * @title: selAddress
	 * @date 2016年8月14日 上午9:55:27
	 * @param user_id
	 * @return List<Address>
	 */
	public List<Address> selAddress(String user_id){
		sql = "SELECT id,location,phone_number,NAME,sex FROM address WHERE user_id = " + user_id;
		temp = jt.queryMap(sql, null);
		List<Address> address = new ArrayList<Address>();
		for(Map<String,String> e : temp){
			add = new Address();
			add.setId(Integer.parseInt(e.get("id")));
			add.setAll_location(e.get("location"));
			add.setName(e.get("name"));
			add.setPhone_number(e.get("phone_number"));
			add.setSex(e.get("sex"));
			address.add(add);
		}
		return address;
	}
	/**
	 * 查询所有的地名
	 * @author 张国荣
	 * @title: allMap
	 * @date 2016年8月14日 上午10:00:09
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> allMap(){
		sql = "SELECT id,local_name FROM map";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询省份信息
	 * @author 张国荣
	 * @title: selProvince
	 * @date 2016年8月14日 上午10:00:34
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selProvince(){
		sql = "SELECT id,local_name FROM map WHERE province IS NULL AND state = 1";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询城市信息
	 * @author 张国荣
	 * @title: selCity
	 * @date 2016年8月14日 上午10:00:43
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selCity(String id){
		sql = "SELECT id,local_name FROM map WHERE state = 1 AND province = " + id;
		return jt.queryMap(sql, null);
	}
	/**
	 * 添加地址
	 * @author 张国荣
	 * @title: addAddress
	 * @date 2016年8月14日 上午10:01:06
	 * @param ad void
	 */
	public void addAddress(Address ad){
		sql = "INSERT INTO address(user_id,location,phone_number,NAME,sex) VALUES(?,?,?,?,?)";
		jt.update(sql, new String[]{String.valueOf(ad.getUser_id()),ad.getAll_location(),ad.getPhone_number(),ad.getName(),ad.getSex()});
	}
	/**
	 * 修改地址信息
	 * @author 张国荣
	 * @title: updateAddress
	 * @date 2016年8月14日 上午10:01:19
	 * @param ad void
	 */
	public void updateAddress(Address ad){
		sql = "UPDATE address SET location=?,phone_number=?,NAME=?,sex=? WHERE id = ?";
		jt.update(sql, new String[]{ad.getAll_location(),ad.getPhone_number(),ad.getName(),ad.getSex(),String.valueOf(ad.getId())});
	}
	/**
	 * 删除地址
	 * @author 张国荣
	 * @title: deleteAddress
	 * @date 2016年8月14日 上午10:01:37
	 * @param id void
	 */
	public void deleteAddress(String id){
		sql = "DELETE FROM address WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 查询一条地址信息
	 * @author 张国荣
	 * @title: selOneAddress
	 * @date 2016年8月14日 上午10:01:47
	 * @param id
	 * @return Address
	 */
	public Address selOneAddress(String id){
		sql = "SELECT id,user_id,location,phone_number,NAME,sex FROM address WHERE id = " + id;
		Map<String,String> temp = jt.queryMap(sql, null).get(0);
		add = new Address();
		add.setUser_id(Integer.parseInt(temp.get("user_id")));
		add.setId(Integer.parseInt(temp.get("id")));
		add.setLast_location(temp.get("location").split("市")[1]);
		add.setAll_location(temp.get("location"));
		add.setName(temp.get("name"));
		add.setPhone_number(temp.get("phone_number"));
		add.setSex(temp.get("sex"));
		return add;
	}
}
