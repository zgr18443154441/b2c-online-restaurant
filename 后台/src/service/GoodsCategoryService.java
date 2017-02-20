package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 商品类别信息控制器
 * @author 张国荣
 * @ClassName: GoodsCategoryService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:54:07
 * @description 类描述
 */
public class GoodsCategoryService {
	private String sql;
	private JDBC_Tool jt;
	public GoodsCategoryService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询商品大类别
	 * @author 张国荣
	 * @title: selGoodsCategory
	 * @date 2016年8月14日 上午1:54:19
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selGoodsCategory(){
		sql = "SELECT id,kind,parent_id FROM goods_category WHERE parent_id IS NULL";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询大类别类名
	 * @author 张国荣
	 * @title: firstName
	 * @date 2016年8月14日 上午1:54:45
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> firstName(){
		sql = "SELECT id,kind FROM goods_category WHERE parent_id IS NULL"; 
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询所有大类别信息
	 * @author 张国荣
	 * @title: firstClass
	 * @date 2016年8月14日 上午1:55:23
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> firstClass(){
		sql = "SELECT g1.id,g1.kind,COUNT(g1.id) class_number FROM goods_category g1 LEFT JOIN goods_category g2 ON g1.id = g2.parent_id WHERE g1.parent_id IS NULL GROUP BY g1.id  ORDER BY g1.id"; 
		List<Map<String,String>> firstClass = jt.queryMap(sql, null);
		sql = "SELECT first_id,COUNT(first_id) number FROM goods GROUP BY first_id ORDER BY first_id";
		List<Map<String,String>> temp = jt.queryMap(sql, null);
		for(Map<String,String> e : firstClass){
			String id = e.get("id");
			String number = new String();
			for(Map<String,String> e2 : temp){
				if(e2.get("first_id").equals(id)){
					number = e2.get("number");
					break;
				}
			}
			e.put("goods_number", number);
		}
		return firstClass;
	}
	/**
	 * 查询小类别
	 * @author 张国荣
	 * @title: secondClass
	 * @date 2016年8月14日 上午1:55:54
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> secondClass(String id){
		sql = "SELECT gc.id,gc.kind,COUNT(gc.id) number FROM goods_category gc LEFT JOIN goods g ON gc.id = g.second_id WHERE gc.parent_id = " + id + " GROUP BY gc.id";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询小类别类名
	 * @author 张国荣
	 * @title: secondName
	 * @date 2016年8月14日 上午1:56:11
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> secondName(String id){
		sql = "SELECT id,kind FROM goods_category WHERE parent_id = " + id; 
		return jt.queryMap(sql, null);
	}
	/**
	 * 添加大类别
	 * @author 张国荣
	 * @title: addFirstClass
	 * @date 2016年8月14日 上午1:56:21
	 * @param name
	 * @return String
	 */
	public String addFirstClass(String name){
		sql = "INSERT INTO goods_category(kind) VALUES(?)";
		jt.update(sql,new String[]{name});
		sql = "SELECT id FROM goods_category WHERE kind = ?";
		return jt.queryMap(sql, new String[]{name}).get(0).get("id");
	}
	/**
	 * 添加天价小类别
	 * @author 张国荣
	 * @title: addSecondClass
	 * @date 2016年8月14日 上午1:56:31
	 * @param name
	 * @param firstId
	 * @return String
	 */
	public String addSecondClass(String name,String firstId){
		sql = "INSERT INTO goods_category(kind,parent_id) VALUES(?,?)";
		jt.update(sql, new String[]{name,firstId});
		sql = "SELECT id FROM goods_category WHERE kind = ?";
		return jt.queryMap(sql, new String[]{name}).get(0).get("id");
	}
}
