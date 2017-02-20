package com.shxt.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shxt.model.OrderList;
import com.shxt.util.JDBC_Tool;
/**
 * 订单控制器
 * @author 张国荣
 * @ClassName: OrderService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:23:22
 * @description 类描述
 */
public class OrderService {
	private String sql;
	private JDBC_Tool jt;
	private List<Map<String,String>> temp;
	private OrderList ol;
	public OrderService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 添加新订单
	 * @author 张国荣
	 * @title: addOrderList
	 * @date 2016年8月14日 上午10:23:32
	 * @param user_id
	 * @param address_id
	 * @param sum_price
	 * @param remark void
	 */
	public void addOrderList(String user_id,String address_id,String sum_price,String remark){
		String code = String.valueOf(new Date().getTime()).substring(0, 9);
		String deal_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		sql = "INSERT INTO order_list(CODE,user_id,address_id,sum_price,deal_time,remark) VALUES(?,?,?,?,?,?)";
		jt.update(sql, new String[]{code,user_id,address_id,sum_price,deal_time,remark});
	}
	/**
	 * 查询用户订单
	 * @author 张国荣
	 * @title: selOrderList
	 * @date 2016年8月14日 上午10:23:44
	 * @param user_id
	 * @return List<OrderList>
	 */
	public List<OrderList> selOrderList(String user_id){
		List<OrderList> order_list = new ArrayList<>();
		sql = "SELECT id,CODE,user_id,address_id,sum_price,deal_time,remark,state,get,assess FROM order_list WHERE user_id = " + user_id + " ORDER BY deal_time DESC";
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			ol = new OrderList();
			ol.setAddress_id(Integer.parseInt(e.get("address_id")));
			ol.setCode(Integer.parseInt(e.get("code")));
			ol.setDeal_time(e.get("deal_time"));
			ol.setId(Integer.parseInt(e.get("id")));
			ol.setRemark(e.get("remark"));
			ol.setState(e.get("state"));
			ol.setGet(e.get("get"));
			ol.setAssess(e.get("assess"));
			ol.setSum_price(Double.parseDouble(e.get("sum_price")));
			ol.setUser_id(Integer.parseInt(e.get("user_id")));
			sql = "SELECT g.id,g.goods_name,og.real_price,og.number FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id WHERE og.order_id = " + ol.getId();
			temp = jt.queryMap(sql, null);
			List<Map<String,String>> order_goods = new ArrayList<>();
			for(Map<String,String> e2 : temp){
				Map<String,String> temp = new HashMap<>();
				temp.put("id", e2.get("id"));
				temp.put("goods_name", e2.get("goods_name"));
				temp.put("real_price", e2.get("real_price"));
				temp.put("number",e2.get("number"));
				order_goods.add(temp);
			}
			ol.setOrder_goods(order_goods);
			order_list.add(ol);
		}
		return order_list;
	}
	/**
	 * 查询订单商品
	 * @author 张国荣
	 * @title: selReoderGoods
	 * @date 2016年8月14日 上午10:24:29
	 * @param list_id
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selReoderGoods(String list_id){
		sql = "SELECT goods_id,number FROM order_goods WHERE order_id = "+ list_id;
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询新订单ID
	 * @author 张国荣
	 * @title: selNewOrderListId
	 * @date 2016年8月14日 上午10:24:38
	 * @return String
	 */
	public String selNewOrderListId(){
		sql = "SELECT MAX(id) id FROM order_list";
		return jt.queryMap(sql, null).get(0).get("id");
	}
	/**
	 * 添加订单商品
	 * @author 张国荣
	 * @title: addOrderGoods
	 * @date 2016年8月14日 上午10:24:51
	 * @param user_id
	 * @param order_id void
	 */
	public void addOrderGoods(String user_id,String order_id){
		sql = "SELECT c.goods_id,c.number,g.post_price,g.discount FROM cart c LEFT JOIN goods g ON c.goods_id = g.id WHERE c.user_id = " + user_id;
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			double real_price = Double.parseDouble(e.get("post_price"))*Double.parseDouble(e.get("discount"))*Double.parseDouble(e.get("number"));
			sql = "INSERT INTO order_goods(order_id,goods_id,real_price,number) VALUES(?,?,?,?)";
			jt.update(sql, new String[]{order_id,e.get("goods_id"),String.valueOf(real_price),e.get("number")});
		}
	}
	/**
	 * 确认商品送达
	 * @author 张国荣
	 * @title: getOrder
	 * @date 2016年8月14日 下午6:47:27
	 * @param id void
	 */
	public void getOrder(String id){
		sql = "UPDATE order_list SET get = 1 WHERE id = " + id;
		jt.update(sql);
	}
}
