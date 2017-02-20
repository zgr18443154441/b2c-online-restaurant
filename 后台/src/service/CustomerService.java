package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Customer;
import com.shxt.model.OrderGoods;
import com.shxt.model.OrderList;
import com.shxt.util.JDBC_Tool;
/**
 * 用户信息控制器
 * @author 张国荣
 * @ClassName: CustomerService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:43:29
 * @description 类描述
 */
public class CustomerService {
	private String sql;
	private JDBC_Tool jt;
	private Customer cu;
	private OrderList ol;
	private OrderGoods og;
	private List<Map<String,String>> temp;
	private List<Map<String,String>> temp2;
	private Map<String,String> temp3;
	public CustomerService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看所有用户
	 * @author 张国荣
	 * @title: getAllCustomer
	 * @date 2016年8月14日 上午1:43:39
	 * @return List<Customer>
	 */
	public List<Customer> getAllCustomer(){
		List<Customer> allCustomer = new ArrayList<>();
		sql = "SELECT id,username,real_name,sex,birthday,email,photo,state FROM USER WHERE role = 0";
		List<Map<String,String>> all_customer = jt.queryMap(sql, null);
		sql = "SELECT user_id,location FROM address";
		List<Map<String,String>> all_address = jt.queryMap(sql, null);
		List<String> temp = new ArrayList<>();
		for(Map<String,String> e : all_customer){
			cu = new Customer();
			cu.setEmail(e.get("email"));
			cu.setId(Integer.parseInt(e.get("id")));
			cu.setPhoto(e.get("photo"));
			cu.setReal_name(e.get("real_name"));
			cu.setSex(e.get("sex").charAt(0));
			cu.setUsername(e.get("username"));
			cu.setBirthday(e.get("birthday"));
			cu.setState(Integer.parseInt(e.get("state")));
			temp = new ArrayList<>();
			for(Map<String,String> a : all_address){
				if(a.get("user_id")!=null&&a.get("user_id").equals(e.get("id"))){
					temp.add(a.get("location"));
				}
			}
			cu.setAddress(temp);
			allCustomer.add(cu);
		}
		return allCustomer;
	}
	/**
	 * 查询所有用户姓名
	 * @author 张国荣
	 * @title: getName
	 * @date 2016年8月14日 上午1:43:58
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getName(){
		sql = "SELECT id,real_name FROM USER WHERE role = 0";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询用户登录权限
	 * @author 张国荣
	 * @title: selCustomerState
	 * @date 2016年8月14日 上午1:44:18
	 * @param id
	 * @return String
	 */
	public String selCustomerState(String id){
		sql = "SELECT state FROM USER WHERE id =" + id;
		return jt.queryMap(sql, null).get(0).get("state");
	}
	/**
	 * 限制用户登录权限
	 * @author 张国荣
	 * @title: defineCustomer
	 * @date 2016年8月14日 上午1:44:35
	 * @param id void
	 */
	public void defineCustomer(String id){
		sql = "UPDATE USER SET state = 0 WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 恢复用户登录权限
	 * @author 张国荣
	 * @title: recoverCustomer
	 * @date 2016年8月14日 上午1:44:49
	 * @param id void
	 */
	public void recoverCustomer(String id){
		sql = "UPDATE USER SET state = 1 WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 查询用户消费排行榜
	 * @author 张国荣
	 * @title: selOldCustomer
	 * @date 2016年8月14日 上午1:45:09
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selOldCustomer(){
		sql = "SELECT u.id,u.real_name,COUNT(ol.code) times,SUM(ol.sum_price) sum_pay,MAX(deal_time) last_time FROM order_list ol LEFT JOIN USER u ON ol.user_id = u.id GROUP BY ol.user_id ORDER BY sum_pay DESC";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询单个用户所有订单
	 * @author 张国荣
	 * @title: getOneCustomerOrderList
	 * @date 2016年8月14日 上午1:45:28
	 * @param user_id
	 * @return List<OrderList>
	 */
	public List<OrderList> getOneCustomerOrderList(String user_id){
		List<OrderList> orderList = new ArrayList<>();
		sql = "SELECT ol.id,ol.code,u.real_name,a.location,a.phone_number,ol.sum_price,ol.deal_time FROM order_list ol LEFT JOIN USER u ON ol.user_id = u.id LEFT JOIN address a ON ol.address_id = a.id WHERE ol.user_id= ? ORDER BY deal_time DESC";
		temp = jt.queryMap(sql, new String[]{user_id});
		for(Map<String,String> e : temp){
			ol = new OrderList();
			ol.setId(Integer.parseInt(e.get("id")));
			ol.setCode(Integer.parseInt(e.get("code")));
			ol.setUser_name(e.get("real_name"));
			ol.setLocation(e.get("location"));
			ol.setPhone_number(e.get("phone_number"));
			ol.setSum_price(Double.parseDouble(e.get("sum_price")));
			ol.setDeal_time(e.get("deal_time"));
			sql = "SELECT g.id,g.goods_name FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id WHERE og.order_id =" + e.get("id");
			temp2 = jt.queryMap(sql, null);
			List<OrderGoods> order_goods = new ArrayList<>();
			for(Map<String,String> e2 : temp2){
				og = new OrderGoods();
				og.setGoods_id(Integer.parseInt(e2.get("id")));
				og.setGoods_name(e2.get("goods_name"));
				order_goods.add(og);
			}
			ol.setOrder_goods(order_goods);
			orderList.add(ol);
		}
		return orderList;
	}
	/**
	 * 查询订单商品信息
	 * @author 张国荣
	 * @title: selOrderGoods
	 * @date 2016年8月14日 上午1:45:45
	 * @param goods_id
	 * @return OrderGoods
	 */
	public OrderGoods selOrderGoods(String goods_id){
		sql = "SELECT p.piece_name,og.real_price,og.number FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id LEFT JOIN pieces p ON g.piece_id = p.id WHERE g.id =" + goods_id;
		temp3 = jt.queryMap(sql, null).get(0);
		og = new OrderGoods();
		og.setNumber(Integer.parseInt(temp3.get("number")));
		og.setPiece_name(temp3.get("piece_name"));
		og.setReal_price(Double.parseDouble(temp3.get("real_price")));
		return og;
	}
	/**
	 * 查询新用户人数
	 * @author 张国荣
	 * @title: countNewCustomer
	 * @date 2016年8月14日 上午1:46:12
	 * @return String
	 */
	public String countNewCustomer(){
		sql = "SELECT COUNT(id) times FROM user WHERE register_time > DATE_SUB(NOW(),INTERVAL 3 DAY) AND role = 0";
		return jt.queryMap(sql, null).get(0).get("times");
	}
}
