package com.shxt.model;
/**
 * 活动信息类
 * @author 张国荣
 * @ClassName: Activity
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:38:33
 * @description 类描述
 */
public class Activity {
	private int id;
	private String name;
	private String start_time;
	private String end_time;
	private String description;
	private String photo;
	private int state;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
