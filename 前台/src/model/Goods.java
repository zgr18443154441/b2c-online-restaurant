package com.shxt.model;
/**
 * 商品模型
 * @author 张国荣
 * @ClassName: Goods
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:53:30
 * @description 类描述
 */
public class Goods {
	private int id;
	private int first_id;
	private int second_id;
	private String goods_name;
	private double post_price;
	private double discount;
	private double real_price;
	private int piece_id;
	private int sale_times;
	private int star;
	private String photo;
	public Goods(){
		real_price = post_price*discount;
	}
	public double getReal_price() {
		return real_price;
	}
	public void setReal_price(double real_price) {
		this.real_price = real_price;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getSale_times() {
		return sale_times;
	}
	public void setSale_times(int sale_times) {
		this.sale_times = sale_times;
	}
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
	public int getPiece_id() {
		return piece_id;
	}
	public void setPiece_id(int piece_id) {
		this.piece_id = piece_id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
