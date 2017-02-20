package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Stock;
import com.shxt.util.JDBC_Tool;
/**
 * 库存信息控制器
 * @author 张国荣
 * @ClassName: StockService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:07:23
 * @description 类描述
 */
public class StockService {
	private String sql;
	private Stock st;
	private JDBC_Tool jt;
	private List<Map<String,String>> temp;
	public StockService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看前四条库存提示
	 * @author 张国荣
	 * @title: getFourStock
	 * @date 2016年8月14日 上午2:07:34
	 * @return List<Stock>
	 */
	public List<Stock> getFourStock(){
		sql = "SELECT id,stock_name,kind_id,rest,top,piece_id FROM stock ORDER BY rest/top LIMIT 0,4";
		temp = jt.queryMap(sql, null);
		List<Stock> four_stock = new ArrayList<>();
		for(Map<String,String> e : temp){
			st = new Stock();
			st.setId(Integer.parseInt(e.get("id")));
			st.setName(e.get("stock_name"));
			st.setKindId(Integer.parseInt(e.get("kind_id")));
			st.setRest(Double.parseDouble(e.get("rest")));
			st.setTop(Double.parseDouble(e.get("top")));
			st.setPercent((int)(Double.parseDouble(e.get("rest"))*100/Double.parseDouble(e.get("top"))));
			four_stock.add(st);
		}
		return four_stock;
	}
	/**
	 * 查看某类库存信息
	 * @author 张国荣
	 * @title: getKindStock
	 * @date 2016年8月14日 上午2:07:59
	 * @param kind_id
	 * @return List<Stock>
	 */
	public List<Stock> getKindStock(String kind_id){
		sql = "SELECT id,stock_name,kind_id,rest,top,piece_id FROM stock WHERE kind_id = " + kind_id + " ORDER BY rest";
		temp = jt.queryMap(sql, null);
		List<Stock> kindSTock = new ArrayList<>();
		for(Map<String,String> e : temp){
			st = new Stock();
			st.setId(Integer.parseInt(e.get("id")));
			st.setName(e.get("stock_name"));
			st.setKindId(Integer.parseInt(e.get("kind_id")));
			st.setRest(Double.parseDouble(e.get("rest")));
			st.setTop(Double.parseDouble(e.get("top")));
			st.setPieceId(Integer.parseInt(e.get("piece_id")));
			st.setPercent((int)(Double.parseDouble(e.get("rest"))*100/Double.parseDouble(e.get("top"))));
			kindSTock.add(st);
		}
		return kindSTock;
	}
	/**
	 * 按剩余百分比排序库存信息
	 * @author 张国荣
	 * @title: getSeldomStock
	 * @date 2016年8月14日 上午2:08:29
	 * @return List<Stock>
	 */
	public List<Stock> getSeldomStock(){
		sql = "SELECT id,stock_name,kind_id,rest,top,piece_id FROM stock ORDER BY rest/top";
		temp = jt.queryMap(sql, null);
		List<Stock> kindSTock = new ArrayList<>();
		for(Map<String,String> e : temp){
			if((int)(Double.parseDouble(e.get("rest"))*100/Double.parseDouble(e.get("top")))<50){
				st = new Stock();
				st.setId(Integer.parseInt(e.get("id")));
				st.setName(e.get("stock_name"));
				st.setKindId(Integer.parseInt(e.get("kind_id")));
				st.setRest(Double.parseDouble(e.get("rest")));
				st.setTop(Double.parseDouble(e.get("top")));
				st.setPieceId(Integer.parseInt(e.get("piece_id")));
				st.setPercent((int)(Double.parseDouble(e.get("rest"))*100/Double.parseDouble(e.get("top"))));
				kindSTock.add(st);
			}
		}
		return kindSTock;
	}
	/**
	 * 添加库存
	 * @author 张国荣
	 * @title: addStock
	 * @date 2016年8月14日 上午2:08:46
	 * @param st void
	 */
	public void addStock(Stock st){
		sql = "INSERT INTO stock(stock_name,kind_id,rest,top,piece_id) VALUES(?,?,?,?,?)";
		jt.update(sql, new String[]{st.getName(),String.valueOf(st.getKindId()),String.valueOf(st.getRest()),String.valueOf(st.getTop()),String.valueOf(st.getPieceId())});
	}
	/**
	 * 修改库存信息
	 * @author 张国荣
	 * @title: updateStock
	 * @date 2016年8月14日 上午2:09:15
	 * @param st void
	 */
	public void updateStock(Stock st){
		sql = "UPDATE stock SET stock_name = ?, kind_id = ? ,rest=? , top=? , piece_id= ? WHERE id = ?";
		jt.update(sql, new String[]{st.getName(),String.valueOf(st.getKindId()),String.valueOf(st.getRest()),String.valueOf(st.getTop()),String.valueOf(st.getPieceId()),String.valueOf(st.getId())});
	}
	/**
	 * 删除库存
	 * @author 张国荣
	 * @title: deleteStock
	 * @date 2016年8月14日 上午2:09:27
	 * @param id void
	 */
	public void deleteStock(String id){
		sql = "DELETE FROM stock WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 查看一条库存
	 * @author 张国荣
	 * @title: selOneStock
	 * @date 2016年8月14日 上午2:09:39
	 * @param id
	 * @return Stock
	 */
	public Stock selOneStock(String id){
		sql = "SELECT id,stock_name,kind_id,rest,top,piece_id FROM stock WHERE id = " + id;
		Map<String,String> temp = jt.queryMap(sql, null).get(0);
		st = new Stock();
		st.setId(Integer.parseInt(temp.get("id")));
		st.setKindId(Integer.parseInt(temp.get("kind_id")));
		st.setName(temp.get("stock_name"));
		st.setRest(Double.parseDouble(temp.get("rest")));
		st.setTop(Double.parseDouble(temp.get("top")));
		st.setPieceId(Integer.parseInt(temp.get("piece_id")));
		return st;
	}
}
