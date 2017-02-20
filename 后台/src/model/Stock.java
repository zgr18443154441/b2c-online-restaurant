package com.shxt.model;

import java.io.Serializable;
/**
 * 库存信息类
 * @author 张国荣
 * @ClassName: Stock
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:40:30
 * @description 类描述
 */
public class Stock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118481724883320271L;
	private int id;
	private String name;
	private int kindId;
	private double rest;
	private double top;
	private int percent;
	private int pieceId;
	public int getPieceId() {
		return pieceId;
	}
	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
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
	public int getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	public double getRest() {
		return rest;
	}
	public void setRest(double rest) {
		this.rest = rest;
	}
	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
}
