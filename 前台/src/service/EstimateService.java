package com.shxt.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shxt.model.Estimate;
import com.shxt.util.JDBC_Tool;
/**
 * 评价控制器
 * @author 张国荣
 * @ClassName: EstimateService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:14:09
 * @description 类描述
 */
public class EstimateService {
	private String sql;
	private JDBC_Tool jt;
	private Estimate es;
	private List<Map<String,String>> temp;
	public EstimateService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询商品评价信息
	 * @author 张国荣
	 * @title: selGoodsEstimate
	 * @date 2016年8月14日 上午10:14:58
	 * @param goods_id
	 * @return List<Estimate>
	 */
	public List<Estimate> selGoodsEstimate(String goods_id){
		sql = "SELECT id,list_id,goods_id,user_id,star,assessment,assess_time FROM estimate WHERE goods_id = " + goods_id;
		temp = jt.queryMap(sql, null);
		List<Estimate> estimate_list = new ArrayList<>();
		for(Map<String,String> e : temp){
			es = new Estimate();
			es.setAssess_time(e.get("assess_time"));
			es.setAssessment(e.get("assessment"));
			es.setGoods_id(Integer.parseInt(e.get("goods_id")));
			es.setId(Integer.parseInt(e.get("id")));
			es.setList_id(Integer.parseInt(e.get("list_id")));
			es.setStar(Integer.parseInt(e.get("star")));
			es.setUser_id(Integer.parseInt(e.get("user_id")));
			estimate_list.add(es);
		}
		return estimate_list;
	}
	/**
	 * 查询评价是否为空
	 * @author 张国荣
	 * @title: estimateExist
	 * @date 2016年8月14日 上午10:15:28
	 * @param user_id
	 * @param list_id
	 * @return String
	 */
	public String estimateExist(String user_id,String list_id){
		sql = "SELECT id FROM estimate WHERE list_id = ? AND user_id = ?";
		if(jt.queryMap(sql, new String[]{list_id,user_id}).isEmpty()){
			return "0";
		}else{
			return "1";
		}
	}
	/**
	 * 查询评价信息是否为空
	 * @author 张国荣
	 * @title: EstimateExist
	 * @date 2016年8月14日 上午10:15:48
	 * @param list_id
	 * @param goods_id
	 * @return boolean
	 */
	public boolean EstimateExist(String list_id,String goods_id){
		sql = "SELECT id FROM estimate WHERE list_id = ? AND goods_id = ?";
		if(jt.queryMap(sql, new String[]{list_id,goods_id}).isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 评价商品
	 * @author 张国荣
	 * @title: addEstimate
	 * @date 2016年8月14日 上午10:16:48
	 * @param list_id
	 * @param goods_id
	 * @param user_id
	 * @param assessment void
	 */
	public void addEstimate(String list_id,String goods_id,String user_id,String assessment){
		sql = "INSERT INTO estimate(list_id,goods_id,user_id,assessment,assess_time) VALUES(?,?,?,?,?)";
		jt.update(sql, new String[]{list_id,goods_id,user_id,assessment,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}
	/**
	 * 修改评价
	 * @author 张国荣
	 * @title: updateEstimate
	 * @date 2016年8月14日 上午10:17:06
	 * @param assessment
	 * @param list_id
	 * @param goods_id void
	 */
	public void updateEstimate(String assessment,String list_id,String goods_id){
		sql = "UPDATE estimate SET assessment = ? WHERE list_id = ? AND goods_id = ?";
		jt.update(sql, new String[]{assessment,list_id,goods_id});
	}
	/**
	 * 给商品评分
	 * @author 张国荣
	 * @title: addStar
	 * @date 2016年8月14日 上午10:17:37
	 * @param list_id
	 * @param goods_id
	 * @param user_id
	 * @param star void
	 */
	public void addStar(String list_id,String goods_id,String user_id,String star){
		sql = "INSERT INTO estimate(list_id,goods_id,user_id,star,assess_time) VALUES(?,?,?,?,?)";
		jt.update(sql, new String[]{list_id,goods_id,user_id,star,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}
	/**
	 * 修改评分
	 * @author 张国荣
	 * @title: updateStar
	 * @date 2016年8月14日 上午10:17:57
	 * @param star
	 * @param list_id
	 * @param goods_id void
	 */
	public void updateStar(String star,String list_id,String goods_id){
		sql = "UPDATE estimate SET star = ? WHERE list_id = ? AND goods_id = ?";
		jt.update(sql, new String[]{star,list_id,goods_id});
	}
	/**
	 * 订单评价完成
	 * @author 张国荣
	 * @title: assessFinish
	 * @date 2016年8月14日 下午6:50:37
	 * @param id void
	 */
	public void assessFinish(String id){
		sql = "UPDATE order_list SET assess = 1 WHERE id = " + id;
		jt.update(sql);
	}
}
