package com.shxt.model;
/**
 * 评价模型
 * @author 张国荣
 * @ClassName: Estimate
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:53:19
 * @description 类描述
 */
public class Estimate {
	private int id;
	private int list_id;
	private int goods_id;
	private int user_id;
	private int star;
	private String assessment;
	private String assess_time;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
