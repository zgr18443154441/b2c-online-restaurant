package com.shxt.model;
/**
 * 收货地址模型
 * @author 张国荣
 * @ClassName: Address
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:51:48
 * @description 类描述
 */
public class Address {
	private int id;
	private int user_id;
	private String all_location;
	private String last_location;
	private String phone_number;
	private String name;
	private String sex;
	public String getAll_location() {
		return all_location;
	}
	public void setAll_location(String all_location) {
		this.all_location = all_location;
	}
	public String getLast_location() {
		return last_location;
	}
	public void setLast_location(String last_location) {
		this.last_location = last_location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
