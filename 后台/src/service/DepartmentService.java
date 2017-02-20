package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 员工部门选择器
 * @author 张国荣
 * @ClassName: DepartmentService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:46:30
 * @description 类描述
 */
public class DepartmentService {
	private String sql;
	private JDBC_Tool jt;
	public DepartmentService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询所有员工部门
	 * @author 张国荣
	 * @title: getDepartment
	 * @date 2016年8月14日 上午1:46:56
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getDepartment(){
		sql = "SELECT id,department_name FROM department";
		return jt.queryMap(sql, null);
	}
}
