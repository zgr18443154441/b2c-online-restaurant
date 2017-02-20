package com.shxt.model;

import java.util.List;
/**
 * 商品类别模型
 * @author 张国荣
 * @ClassName: Category
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:52:03
 * @description 类描述
 */
public class Category {
	private int id;
	private int parent_id;
	private String kind;
	private int number;
	private List<Goods> goods;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
}
