package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 库存类别信息控制器
 * @author 张国荣
 * @ClassName: StockCategoryService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:05:43
 * @description 类描述
 */
public class StockCategoryService {
	private String sql;
	private JDBC_Tool jt;
	public StockCategoryService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看库存类别
	 * @author 张国荣
	 * @title: selStockCategory
	 * @date 2016年8月14日 上午2:05:59
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selStockCategory(){
		sql = "SELECT id,kind FROM stock_category";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查看库存类别信息
	 * @author 张国荣
	 * @title: stockMessage
	 * @date 2016年8月14日 上午2:06:11
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> stockMessage(){
		sql = "SELECT sc.id,sc.kind,COUNT(sc.id) number FROM stock_category sc LEFT JOIN stock s ON sc.id = s.kind_id GROUP BY sc.id";
		return jt.queryMap(sql, null);
	}
	/**
	 * 添加库存类别
	 * @author 张国荣
	 * @title: addStockClass
	 * @date 2016年8月14日 上午2:06:40
	 * @param name
	 * @return String
	 */
	public String addStockClass(String name){
		sql = "INSERT INTO stock_category(kind) VALUES(?)";
		jt.update(sql, new String[]{name});
		sql = "SELECT id FROM stock_category WHERE kind = ?";
		return jt.queryMap(sql, new String[]{name}).get(0).get("id");
	}
}
