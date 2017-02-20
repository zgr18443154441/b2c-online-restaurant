package com.shxt.model;
/**
 * 邮件信息类
 * @author 张国荣
 * @ClassName: Email
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:39:14
 * @description 类描述
 */
public class Email {
	private int id;
	private int list_id;
	private String goods_name;
	private int star;
	private String assessment;
	private String assess_time;
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getList_id() {
		return list_id;
	}
	public void setList_id(int list_id) {
		this.list_id = list_id;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getAssess_time() {
		return assess_time;
	}
	public void setAssess_time(String assess_time) {
		this.assess_time = assess_time;
	}
}
