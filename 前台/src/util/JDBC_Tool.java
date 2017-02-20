package com.shxt.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
/**
 * JDBC工具类
 * @author 张国荣
 *
 */
public class JDBC_Tool {
	/**驱动*/
	private final String driver = "com.mysql.jdbc.Driver";
	/**连接信息*/
	private final String url = "jdbc:mysql://localhost:3308/";
	/**用户名*/
	private final String UserName = "root";
	/**密码*/
	private final String password = "mysql";
	/**连接对象*/
	private Connection con;
	/**执行sql语句的对象*/
//	private Statement st;
	/**结果集*/
	private ResultSet rs;
	/**执行预编译对象*/
	private PreparedStatement ps;
	/**
	 * 初始化数据
	 * @param database
	 */
	public JDBC_Tool(String database/**数据库*/){
		try {
			/**加载驱动*/
			Class.forName(driver);
			/**获取连接对象*/
			con = (Connection) DriverManager.getConnection(url + database, UserName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * 执行DML语言
	 * @param sql
	 * @param param
	 */
	public void update(String sql,String[] param){
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setString(i+1, param[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行DML语言
	 * @param sql
	 */
	public void update(String sql){
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行DQL语言（list）
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<List<String>> queryList(String sql,String[] param){
		List<List<String>> tablelist = new ArrayList<>();
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
				}
			}
			rs = ps.executeQuery();
			//通过此对象获取sql语句中列的相关信息
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			//列的个数
			int columnCount = rsmd.getColumnCount();
			while(rs.next()){
				List<String> row = new ArrayList<>();
				for(int col = 1; col <= columnCount; col++){
					row.add(rs.getString(col));
				}
				tablelist.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablelist;
	}
	/**
	 * 执行DQL语言（map）
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<Map<String,String>> queryMap(String sql,String[] param){
		List<Map<String,String>> tablemap = new ArrayList<>();
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
				}
			}
			rs = ps.executeQuery();
			rs = ps.executeQuery();
			//通过此对象获取sql语句中列的相关信息
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			//列的个数
			int columnCount = rsmd.getColumnCount();
			//列的名称组
			String[] columnNames = new String[columnCount];
			for (int i = 0; i < columnNames.length; i++) {
				columnNames[i] = rsmd.getColumnName(i+1).toLowerCase();
			}
			while(rs.next()){
				Map<String,String> row = new HashMap<>();
				for (int i = 0; i < columnNames.length; i++) {
					row.put(columnNames[i],rs.getString(columnNames[i]));
				}
				tablemap.add(row);
			}
			return tablemap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablemap;
	}
	/**
	 * 批量执行DML语言
	 * @param sql
	 * @param paramList
	 */
	public void updateBatch(String sql,List<String[]> paramList){
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			for(String[] param : paramList){
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
				}
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
