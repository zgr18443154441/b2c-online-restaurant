package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.OrderGoods;
import com.shxt.model.OrderList;
import com.shxt.util.JDBC_Tool;
/**
 * 订单信息控制器
 * @author 张国荣
 * @ClassName: OrderService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:01:38
 * @description 类描述
 */
public class OrderService {
	private String sql;
	private JDBC_Tool jt;
	private OrderList ol;
	private OrderGoods og;
	private List<Map<String,String>> temp;
	private List<Map<String,String>> temp2;
	public OrderService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 获取所有订单号
	 * @author 张国荣
	 * @title: getCode
	 * @date 2016年8月14日 上午2:01:53
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getCode(){
		sql = "SELECT id,CODE FROM order_list";
		return jt.queryMap(sql, null);
	}
	/**
	 * 获取订单产品信息
	 * @author 张国荣
	 * @title: selGoodsMessage
	 * @date 2016年8月14日 上午2:02:15
	 * @param goods_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selGoodsMessage(String goods_id){
		sql = "SELECT o.order_id,g.id,g.goods_name,o.real_price,o.number FROM order_goods o LEFT JOIN goods g ON o.goods_id = g.id WHERE goods_id" + goods_id;
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询新订单数量
	 * @author 张国荣
	 * @title: countNewOrder
	 * @date 2016年8月14日 上午2:02:39
	 * @return String
	 */
	public String countNewOrder(){
		sql = "SELECT COUNT(id) times FROM order_list WHERE state = 0";
		return jt.queryMap(sql, null).get(0).get("times");
	}
	/**
	 * 查询新订单信息
	 * @author 张国荣
	 * @title: selNewOrder
	 * @date 2016年8月14日 上午2:02:55
	 * @return List<OrderList>
	 */
	public List<OrderList> selNewOrder(){
		List<OrderList> orderList = new ArrayList<>();
		sql = "SELECT ol.id,ol.code,u.real_name,a.location,a.phone_number,ol.remark,ol.sum_price,ol.deal_time FROM order_list ol LEFT JOIN USER u ON ol.user_id = u.id LEFT JOIN address a ON ol.address_id = a.id WHERE ol.state= 0 ORDER BY deal_time DESC";
		temp = jt.queryMap(sql,null);
		for(Map<String,String> e : temp){
			ol = new OrderList();
			ol.setId(Integer.parseInt(e.get("id")));
			ol.setCode(Integer.parseInt(e.get("code")));
			ol.setUser_name(e.get("real_name"));
			ol.setLocation(e.get("location"));
			ol.setPhone_number(e.get("phone_number"));
			ol.setRemark(e.get("remark"));
			ol.setSum_price(Double.parseDouble(e.get("sum_price")));
			ol.setDeal_time(e.get("deal_time"));
			sql = "SELECT g.id,g.goods_name,p.piece_name,og.real_price,og.number FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id LEFT JOIN pieces p ON g.piece_id = p.id WHERE og.order_id =" + e.get("id");
			temp2 = jt.queryMap(sql, null);
			List<OrderGoods> order_goods = new ArrayList<>();
			for(Map<String,String> e2 : temp2){
				og = new OrderGoods();
				og.setGoods_id(Integer.parseInt(e2.get("id")));
				og.setGoods_name(e2.get("goods_name"));
				og.setNumber(Integer.parseInt(e2.get("number")));
				og.setPiece_name(e2.get("piece_name"));
				og.setReal_price(Double.parseDouble(e2.get("real_price")));
				order_goods.add(og);
			}
			ol.setOrder_goods(order_goods);
			orderList.add(ol);
		}
		return orderList;
	}
	/**
	 * 确认订单
	 * @author 张国荣
	 * @title: finishOrder
	 * @date 2016年8月14日 上午2:03:09
	 * @param order_id void
	 */
	public void finishOrder(String order_id){
		sql = "UPDATE order_list SET state = 1 WHERE id = " + order_id;
		jt.update(sql);
	}
}
