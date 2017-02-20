package com.shxt.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 订单信息类
 * @author 张国荣
 * @ClassName: OrderList
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:40:03
 * @description 类描述
 */
public class OrderList {
	private int id;
	private int code;
	private String user_name;
	private String location;
	private String phone_number;
	private double sum_price;
	private String deal_time;
	private String remark;
	private List<Email> estimate;
	private List<OrderGoods> order_goods;
	public OrderList(){
		estimate = new ArrayList<>();
		order_goods = new ArrayList<>();
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public List<OrderGoods> getOrder_goods() {
		return order_goods;
	}
	public void setOrder_goods(List<OrderGoods> order_goods) {
		this.order_goods = order_goods;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public List<Email> getEstimate() {
		return estimate;
	}
	public void setEstimate(List<Email> estimate) {
		this.estimate = estimate;
	}
}
