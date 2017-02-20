package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 购物车控制器
 * @author 张国荣
 * @ClassName: CartService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:02:26
 * @description 类描述
 */
public class CartService {
	private String sql;
	private JDBC_Tool jt;
	private List<Map<String,String>> temp;
	public CartService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 根据用户查询购物车
	 * @author 张国荣
	 * @title: selCart
	 * @date 2016年8月14日 上午10:02:59
	 * @param user_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selCart(String user_id){
		sql = "SELECT c.id,g.goods_name,c.number,g.post_price,g.discount,g.photo FROM cart c JOIN goods g ON c.goods_id = g.id WHERE c.user_id = " + user_id;
		List<Map<String,String>> cart = jt.queryMap(sql, null);
		for(Map<String,String> e : cart){
			double real_price = Double.parseDouble(e.get("post_price"))*Double.parseDouble(e.get("discount"));
			e.put("real_price", String.valueOf(real_price));
		}
		return cart;
	}
	/**
	 * 向购物车中添加一条单个商品信息
	 * @author 张国荣
	 * @title: addCart
	 * @date 2016年8月14日 上午10:03:19
	 * @param goods_id
	 * @param user_id void
	 */
	public void addCart(String goods_id,String user_id){
		sql = "INSERT INTO cart(goods_id,user_id,number) VALUES(?,?,1)";
		jt.update(sql, new String[]{goods_id,user_id});
	}
	/**
	 * 向购物车中添加一条多个商品细信息
	 * @author 张国荣
	 * @title: addCart
	 * @date 2016年8月14日 上午10:05:59
	 * @param goods_id
	 * @param user_id
	 * @param number void
	 */
	public void addCart(String goods_id,String user_id,String number){
		sql = "INSERT INTO cart(goods_id,user_id,number) VALUES(?,?,?)";
		jt.update(sql, new String[]{goods_id,user_id,number});
	}
	/**
	 * 商品数量加一
	 * @author 张国荣
	 * @title: plusCart
	 * @date 2016年8月14日 上午10:06:30
	 * @param goods_id
	 * @param user_id void
	 */
	public void plusCart(String goods_id,String user_id){
		sql = "UPDATE cart SET number = number + 1 WHERE goods_id = ? AND user_id = ?";
		jt.update(sql, new String[]{goods_id,user_id});
	}
	/**
	 * 商品数量减一
	 * @author 张国荣
	 * @title: minusCart
	 * @date 2016年8月14日 上午10:07:00
	 * @param goods_id
	 * @param user_id void
	 */
	public void minusCart(String goods_id,String user_id){
		sql = "UPDATE cart SET number = number - 1 WHERE goods_id = ? AND user_id = ?";
		jt.update(sql, new String[]{goods_id,user_id});
	}
	/**
	 * 删除一条购物车信息
	 * @author 张国荣
	 * @title: deleteOneCart
	 * @date 2016年8月14日 上午10:07:17
	 * @param goods_id
	 * @param user_id void
	 */
	public void deleteOneCart(String goods_id,String user_id){
		sql = "DELETE FROM cart WHERE goods_id = ? AND user_id = ?";
		jt.update(sql, new String[]{goods_id,user_id});
	}
	/**
	 * 清空购物车
	 * @author 张国荣
	 * @title: deleteCart
	 * @date 2016年8月14日 上午10:07:34
	 * @param user_id void
	 */
	public void deleteCart(String user_id){
		sql = "DELETE FROM cart WHERE user_id = ?";
		jt.update(sql, new String[]{user_id});
	}
	/**
	 * 删除一条购物车信息
	 * @author 张国荣
	 * @title: deleteOneCart
	 * @date 2016年8月14日 上午10:07:53
	 * @param id void
	 */
	public void deleteOneCart(String id){
		sql = "DELETE FROM cart WHERE id = ?";
		jt.update(sql, new String[]{id});
	}
	/**
	 * 清空购物车
	 * @author 张国荣
	 * @title: dropCart
	 * @date 2016年8月14日 上午10:08:44
	 * @param user_id void
	 */
	public void dropCart(String user_id){
		sql = "DELETE FROM cart WHERE user_id = " + user_id;
		jt.update(sql);
	}
	/**
	 * 查询购物车是否为空
	 * @author 张国荣
	 * @title: cartExist
	 * @date 2016年8月14日 上午10:08:54
	 * @param user_id
	 * @param goods_id
	 * @return String
	 */
	public String cartExist(String user_id,String goods_id){
		sql = "SELECT number FROM cart WHERE goods_id = ? AND user_id = ?";
		temp = jt.queryMap(sql, new String[]{goods_id,user_id});
		if(temp.isEmpty()){
			return "0";
		}else{
			return temp.get(0).get("number");
		}
	}
}
