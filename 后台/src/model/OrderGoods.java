package com.shxt.model;
/**
 * 订单商品类
 * @author 张国荣
 * @ClassName: OrderGoods
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:39:50
 * @description 类描述
 */
public class OrderGoods {
	private int goods_id;
	private String goods_name;
	private String piece_name;
	private double real_price;
	private int number;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getPiece_name() {
		return piece_name;
	}
	public void setPiece_name(String piece_name) {
		this.piece_name = piece_name;
	}
	public double getReal_price() {
		return real_price;
	}
	public void setReal_price(double real_price) {
		this.real_price = real_price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
