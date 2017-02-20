package com.shxt.model;
/**
 * 实体店模型
 * @author 张国荣
 * @ClassName: Restaurant
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:54:02
 * @description 类描述
 */
public class Restaurant {
	private int id;
	private String area;
	private String location;
	private String phone_number;
	private String manager;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
