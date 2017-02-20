package com.shxt.service;

import java.util.List;
import java.util.Map;

import com.shxt.util.JDBC_Tool;
/**
 * 单位信息控制器
 * @author 张国荣
 * @ClassName: PieceService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:03:20
 * @description 类描述
 */
public class PieceService {
	private String sql;
	private JDBC_Tool jt;
	public PieceService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 查询所有单位
	 * @author 张国荣
	 * @title: selPiece
	 * @date 2016年8月14日 上午2:03:33
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selPiece(){
		sql = "SELECT id,piece_name FROM pieces";
		return jt.queryMap(sql, null);
	}
}
