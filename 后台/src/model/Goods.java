package com.shxt.model;
/**
 * 商品信息类
 * @author 张国荣
 * @ClassName: Goods
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:39:39
 * @description 类描述
 */
public class Goods {
	private int id;
	private int first_id;
	private int second_id;
	private String goods_name;
	private double post_price;
	private int piece_id;
	private double discount;
	private String photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFirst_id() {
		return first_id;
	}
	public void setFirst_id(int first_id) {
		this.first_id = first_id;
	}
	public int getSecond_id() {
		return second_id;
	}
	public void setSecond_id(int second_id) {
		this.second_id = second_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getPost_price() {
		return post_price;
	}
	public void setPost_price(double post_price) {
		this.post_price = post_price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPiece_id() {
		return piece_id;
	}
	public void setPiece_id(int piece_id) {
		this.piece_id = piece_id;
	}
	
}
