package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Goods;
import com.shxt.util.JDBC_Tool;
/**
 * 商品信息控制器
 * @author 张国荣
 * @ClassName: GoodsService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:56:52
 * @description 类描述
 */
public class GoodsService {
	private String sql;
	private JDBC_Tool jt;
	private Goods go;
	public GoodsService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看十个大类商品信息
	 * @author 张国荣
	 * @title: secondTenGoods
	 * @date 2016年8月14日 上午1:57:59
	 * @param first_id
	 * @return List<Goods>
	 */
	public List<Goods> secondTenGoods(String first_id){
		List<Goods> tenGoods = new ArrayList<>();
		sql = "SELECT id,second_id,goods_name,post_price,piece_id,discount,photo FROM goods WHERE first_id = ? ORDER BY post_price";
		List<Map<String,String>> temp = jt.queryMap(sql, new String[]{first_id});
		for(Map<String,String> e : temp){
			go = new Goods();
			go.setDiscount(Double.parseDouble(e.get("discount")));
			go.setGoods_name(e.get("goods_name"));
			go.setId(Integer.parseInt(e.get("id")));
			go.setSecond_id(Integer.parseInt(e.get("second_id")));
			go.setPhoto(e.get("photo"));
			go.setPost_price(Double.parseDouble(e.get("post_price")));
			go.setPiece_id(Integer.parseInt(e.get("piece_id")));
			tenGoods.add(go);
		}
		return tenGoods;
	}
	/**
	 * 查询大类别类名
	 * @author 张国荣
	 * @title: selFirstName
	 * @date 2016年8月14日 上午1:58:30
	 * @param id
	 * @return String
	 */
	public String selFirstName(String id){
		sql = "SELECT kind FROM goods_category WHERE id = " + id;
		return jt.queryMap(sql, null).get(0).get("kind");
	}
	/**
	 * 添加商品
	 * @author 张国荣
	 * @title: addGoods
	 * @date 2016年8月14日 上午1:58:48
	 * @param g void
	 */
	public void addGoods(Goods g){
		sql = "INSERT INTO goods(first_id,second_id,goods_name,post_price,piece_id,discount,photo) VALUES(?,?,?,?,?,?,?)";
		jt.update(sql, new String[]{String.valueOf(g.getFirst_id()),String.valueOf(g.getSecond_id()),g.getGoods_name(),String.valueOf(g.getPost_price()),String.valueOf(g.getPiece_id()),String.valueOf(g.getDiscount()),g.getPhoto()});
	}
	/**
	 * 修改商品信息
	 * @author 张国荣
	 * @title: updateGoods
	 * @date 2016年8月14日 上午1:58:55
	 * @param g void
	 */
	public void updateGoods(Goods g){
		sql = "UPDATE goods SET first_id = ? ,second_id = ? ,goods_name=? ,post_price=? ,piece_id = ?,discount = ?,photo=? WHERE id = ?";
		jt.update(sql, new String[]{String.valueOf(g.getFirst_id()),String.valueOf(g.getSecond_id()),g.getGoods_name(),String.valueOf(g.getPost_price()),String.valueOf(g.getPiece_id()),String.valueOf(g.getDiscount()),g.getPhoto(),String.valueOf(g.getId())});
	}
	/**
	 * 删除商品
	 * @author 张国荣
	 * @title: deleteGoods
	 * @date 2016年8月14日 上午1:59:10
	 * @param id void
	 */
	public void deleteGoods(String id){
		sql = "DELETE FROM goods WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 查询一种商品
	 * @author 张国荣
	 * @title: selOneGoods
	 * @date 2016年8月14日 上午1:59:20
	 * @param id
	 * @return Goods
	 */
	public Goods selOneGoods(String id){
		sql = "SELECT id,first_id,second_id,goods_name,post_price,piece_id,discount,photo FROM goods WHERE id = " + id;
		Map<String,String> temp =  jt.queryMap(sql, null).get(0);
		go = new Goods();
		go.setId(Integer.parseInt(temp.get("id")));
		go.setDiscount(Double.parseDouble(temp.get("discount")));
		go.setGoods_name(temp.get("goods_name"));
		go.setId(Integer.parseInt(temp.get("id")));
		go.setSecond_id(Integer.parseInt(temp.get("second_id")));
		go.setPhoto(temp.get("photo"));
		go.setPost_price(Double.parseDouble(temp.get("post_price")));
		go.setPiece_id(Integer.parseInt(temp.get("piece_id")));
		return go;
	}
	/**
	 * 查询推荐商品信息
	 * @author 张国荣
	 * @title: selIntroduceGoods
	 * @date 2016年8月14日 上午1:59:41
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selIntroduceGoods(){
		sql = "SELECT id,goods_id,description FROM introduce";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询商品ID
	 * @author 张国荣
	 * @title: selGoodsId
	 * @date 2016年8月14日 上午1:59:57
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selGoodsId(){
		sql = "SELECT id,goods_name FROM goods";
		return jt.queryMap(sql, null);
	}
	/**
	 * 改变推荐商品
	 * @author 张国荣
	 * @title: changeIntroduceGoods
	 * @date 2016年8月14日 上午2:00:52
	 * @param list_id
	 * @param goods_id void
	 */
	public void changeIntroduceGoods(String list_id,String goods_id){
		sql = "UPDATE introduce SET goods_id = ? WHERE id = ?";
		jt.update(sql, new String[]{goods_id,list_id});
	}
	/**
	 * 改变推荐商品描述
	 * @author 张国荣
	 * @title: changeDescription
	 * @date 2016年8月14日 上午2:01:07
	 * @param description
	 * @param list_id void
	 */
	public void changeDescription(String description,String list_id){
		sql = "UPDATE introduce SET description = ? WHERE id = ?";
		jt.update(sql, new String[]{description,list_id});
	}
	/**
	 * 查询热销商品
	 * @author 张国荣
	 * @title: selHotGoods
	 * @date 2016年8月14日 上午2:01:22
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selHotGoods(){
		sql = "SELECT og.goods_id,g.goods_name,SUM(og.number) sum_number,p.piece_name ,SUM(og.real_price) sum_price FROM order_goods og LEFT JOIN goods g ON og.goods_id = g.id LEFT JOIN pieces p ON g.piece_id = p.id GROUP BY og.goods_id ORDER BY sum_number DESC";
		return jt.queryMap(sql, null);
	}
}
