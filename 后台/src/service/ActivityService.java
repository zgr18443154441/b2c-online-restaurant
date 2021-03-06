package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Activity;
import com.shxt.util.JDBC_Tool;
/**
 * 活动信息控制器
 * @author 张国荣
 * @ClassName: ActivityService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:40:45
 * @description 类描述
 */
public class ActivityService {
	private String sql;
	private JDBC_Tool jt;
	private Activity ac;
	private List<Map<String,String>> temp;
	public ActivityService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查看活动信息
	 * @author 张国荣
	 * @title: selActivity
	 * @date 2016年8月14日 上午1:42:41
	 * @return List<Activity>
	 */
	public List<Activity> selActivity(){
		List<Activity> activity_list = new ArrayList<>();
		sql = "SELECT id,activity_name,start_time,end_time,description,state,photo FROM activity";
		temp = jt.queryMap(sql, null);
		for(Map<String,String> e : temp){
			ac = new Activity();
			ac.setDescription(e.get("description"));
			ac.setEnd_time(e.get("end_time"));
			ac.setId(Integer.parseInt(e.get("id")));
			ac.setName(e.get("activity_name"));
			ac.setStart_time(e.get("start_time"));
			ac.setState(Integer.parseInt(e.get("state")));
			ac.setPhoto(e.get("photo"));
			activity_list.add(ac);
		}
		return activity_list;
	}
	/**
	 * 撤销活动信息
	 * @author 张国荣
	 * @title: concelActivity
	 * @date 2016年8月14日 上午1:42:56
	 * @param id void
	 */
	public void concelActivity(String id){
		sql = "UPDATE activity SET state = 0 WHERE id = " + id;
		jt.update(sql);
	}
	/**
	 * 添加活动信息
	 * @author 张国荣
	 * @title: addActivity
	 * @date 2016年8月14日 上午1:43:12
	 * @param ac void
	 */
	public void addActivity(Activity ac){
		sql = "INSERT INTO activity(activity_name,start_time,end_time,description,photo) VALUES(?,?,?,?,?)";
		jt.update(sql, new String[]{ac.getName(),ac.getStart_time(),ac.getEnd_time(),ac.getDescription(),ac.getPhoto()});
	}
}
