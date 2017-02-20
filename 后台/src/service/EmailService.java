package com.shxt.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shxt.model.Email;
import com.shxt.model.OrderList;
import com.shxt.util.JDBC_Tool;
/**
 * 邮件信息控制器
 * @author 张国荣
 * @ClassName: EmailService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:47:15
 * @description 类描述
 */
public class EmailService {
	private String sql;
	private JDBC_Tool jt;
	private Email em;
	private OrderList ol;
	private List<Map<String,String>> temp;
	private List<Map<String,String>> temp2;
	public EmailService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看最近的四个评价
	 * @author 张国荣
	 * @title: getFourEstimate
	 * @date 2016年8月14日 上午1:47:26
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getFourEstimate(){
		sql = "SELECT e.assessment,e.assess_time,u.real_name FROM estimate e LEFT JOIN USER u ON e.user_id = u.id ORDER BY e.assess_time DESC LIMIT 0,3";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询所有订单
	 * @author 张国荣
	 * @title: getOrderList
	 * @date 2016年8月14日 上午1:47:51
	 * @return List<OrderList>
	 */
	public List<OrderList> getOrderList(){
		List<OrderList> orderList = new ArrayList<>();
		sql = "SELECT ol.id,ol.code,u.real_name FROM order_list ol LEFT JOIN USER u ON ol.user_id = u.id ORDER BY deal_time DESC";
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			ol = new OrderList();
			ol.setId(Integer.parseInt(e.get("id")));
			ol.setCode(Integer.parseInt(e.get("code")));
			ol.setUser_name(e.get("real_name"));
			sql = "SELECT e.id,g.goods_name,og.real_price,og.number,e.star,e.assessment,e.assess_time FROM estimate e LEFT JOIN order_goods og ON e.goods_id = og.goods_id LEFT JOIN goods g ON e.goods_id = g.id WHERE e.list_id = " + e.get("id") + " AND og.order_id = "+ e.get("id");
			temp2 = jt.queryMap(sql, null);
			List<Email> el = new ArrayList<>();
			for(Map<String,String> e2 : temp2){
				em = new Email();
				em.setId(Integer.parseInt(e2.get("id")));
				em.setGoods_name(e2.get("goods_name"));
				el.add(em);
			}
			ol.setEstimate(el);
			orderList.add(ol);
		}
		return orderList;
	}
	/**
	 * 查询所有邮件信息
	 * @author 张国荣
	 * @title: selEmailList
	 * @date 2016年8月14日 上午1:48:12
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selEmailList(){ 
		sql = "SELECT id,user_id,words,write_time,reply,reply_time FROM email";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询一条邮件
	 * @author 张国荣
	 * @title: selEmail
	 * @date 2016年8月14日 上午1:48:39
	 * @param id
	 * @return Map<String,String>
	 */
	public Map<String,String> selEmail(String id){
		sql = "SELECT id,words,write_time FROM email WHERE id =" + id;
		return jt.queryMap(sql, null).get(0);
	}
	/**
	 * 查询订单商品信息
	 * @author 张国荣
	 * @title: goodsMessage
	 * @date 2016年8月14日 上午1:48:56
	 * @param list_id
	 * @param goods_id
	 * @return Map<String,String>
	 */
	public Map<String,String> goodsMessage(String list_id,String goods_id){
		sql ="SELECT o.order_id,o.goods_id,g.goods_name,o.real_price,o.number FROM order_goods o LEFT JOIN goods g ON o.goods_id = g.id WHERE o.order_id = " + list_id + " AND goods_id = " + goods_id;
		return jt.queryMap(sql, null).get(0);
	}
	/**
	 * 查询一条评价信息
	 * @author 张国荣
	 * @title: selOneEmail
	 * @date 2016年8月14日 上午1:49:36
	 * @param id
	 * @return Map<String,String>
	 */
	public Map<String,String> selOneEmail(String id){
		sql = "SELECT e.id,g.goods_name,og.real_price,og.number,e.star,e.assessment,e.assess_time FROM estimate e LEFT JOIN order_goods og ON e.goods_id = og.goods_id LEFT JOIN goods g ON e.goods_id = g.id WHERE e.id = " + id;
		return jt.queryMap(sql, null).get(0);
	}
	/**
	 * 回复邮件
	 * @author 张国荣
	 * @title: replyEmail
	 * @date 2016年8月14日 上午1:49:47
	 * @param id
	 * @param reply void
	 */
	public void replyEmail(String id,String reply){
		sql = "UPDATE email SET reply = ?,reply_time = ? WHERE id = ?";
		jt.update(sql, new String[]{reply,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),id});
	}
	/**
	 * 查询新邮件数量
	 * @author 张国荣
	 * @title: countNewEmail
	 * @date 2016年8月14日 上午1:50:00
	 * @return String
	 */
	public String countNewEmail(){
		sql = "SELECT COUNT(id) times FROM email WHERE reply IS NULL";
		return jt.queryMap(sql, null).get(0).get("times");
	}
}
