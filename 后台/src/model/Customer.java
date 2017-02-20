package com.shxt.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 用户信息类
 * @author 张国荣
 * @ClassName: Customer
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:39:03
 * @description 类描述
 */
public class Customer {
	private int id;
	private String username;
	private String real_name;
	private char sex;
	private String email;
	private String photo;
	private String birthday;
	private int state;
	private List<String> address;
	public Customer(){
		address = new ArrayList<>();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
}
