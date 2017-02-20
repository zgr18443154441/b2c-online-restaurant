package com.shxt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 订单模型
 * @author 张国荣
 * @ClassName: OrderList
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:53:53
 * @description 类描述
 */
public class OrderList {
	private int id;
	private int code;
	private int user_id;
	private int address_id;
	private double sum_price;
	private String deal_time;
	private String remark;
	private Address add;
	private String state;
	private String get;
	private String assess;
	private List<Map<String,String>> order_goods;
	public OrderList(){
		order_goods = new ArrayList<>();
		add = new Address();
	}
	public String getAssess() {
		return assess;
	}
	public void setAssess(String assess) {
		this.assess = assess;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		this.get = get;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public List<Map<String, String>> getOrder_goods() {
		return order_goods;
	}
	public void setOrder_goods(List<Map<String, String>> order_goods) {
		this.order_goods = order_goods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public double getSum_price() {
		return sum_price;
	}
	public void setSum_price(double sum_price) {
		this.sum_price = sum_price;
	}
	public String getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
