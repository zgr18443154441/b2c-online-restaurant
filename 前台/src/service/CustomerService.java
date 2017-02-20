package com.shxt.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.shxt.model.Customer;
import com.shxt.util.JDBC_Tool;
/**
 * 用户控制器
 * @author 张国荣
 * @ClassName: CustomerService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:09:33
 * @description 类描述
 */
public class CustomerService {
	private String sql;
	private JDBC_Tool jt;
	private Customer cus;
	private List<Map<String,String>> temp;
	public CustomerService(){
		jt = new JDBC_Tool("shop");
	}
	/**
	 * 登录验证
	 * @author 张国荣
	 * @title: testLogin
	 * @date 2016年8月14日 上午10:10:07
	 * @param account
	 * @param password
	 * @return String
	 */
	public String testLogin(String account,String password){
		sql = "SELECT username,PASSWORD,state FROM USER WHERE role = 0 AND username = ?";
		temp = jt.queryMap(sql, new String[]{account});
		if(temp.isEmpty()){
			return "0";
		}else if(!password.equals(temp.get(0).get("password"))){
			return "1";
		}else if("0".equals(temp.get(0).get("state"))){
			return "2";
		}else{
			return "pass";
		}
	}
	/**
	 * 登录成功传递用户信息
	 * @author 张国荣
	 * @title: login
	 * @date 2016年8月14日 上午10:10:18
	 * @param username
	 * @return Customer
	 */
	public Customer login(String username){
		sql = "SELECT id,real_name,sex,birthday,email,photo FROM USER WHERE username = ?";
		temp = jt.queryMap(sql, new String[]{username});
		cus = new Customer();
		cus.setBirthday(temp.get(0).get("birthday"));
		cus.setEmail(temp.get(0).get("email"));
		cus.setId(Integer.parseInt(temp.get(0).get("id")));
		cus.setPhoto(temp.get(0).get("photo"));
		cus.setReal_name(temp.get(0).get("real_name"));
		cus.setSex(temp.get(0).get("sex").charAt(0));
		cus.setUsername(username);
		return cus;
	}
	/**
	 * 验证用户名是否存在
	 * @author 张国荣
	 * @title: userNameExist
	 * @date 2016年8月14日 上午10:10:50
	 * @param account
	 * @return String
	 */
	public String userNameExist(String account){
		sql = "SELECT id FROM USER WHERE username = ? AND role = 0";
		if(jt.queryMap(sql, new String[]{account}).isEmpty()){
			return "0";
		}else{
			return "exist";
		}
	}
	/**
	 * 注册用户
	 * @author 张国荣
	 * @title: register
	 * @date 2016年8月14日 上午10:11:15
	 * @param cus void
	 */
	public void register(Customer cus){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a",Locale.US);
		try {
			d = sdf.parse(cus.getBirthday());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		cus.setBirthday(sdf.format(d));
		sql = "INSERT INTO USER(username,PASSWORD,real_name,sex,birthday,email,photo,question,answer,register_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jt.update(sql, new String[]{cus.getUsername(),cus.getPassword(),cus.getReal_name(),String.valueOf(cus.getSex()),cus.getBirthday(),cus.getEmail(),cus.getPhoto(),cus.getQuestion(),cus.getAnswer(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())});
	}
	/**
	 * 查询所有用户姓名
	 * @author 张国荣
	 * @title: selCustomerName
	 * @date 2016年8月14日 上午10:11:30
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> selCustomerName(){
		sql = "SELECT id,username,real_name FROM USER WHERE role = 0";
		return jt.queryMap(sql, null);
	}
	/**
	 * 查询用户的密保问题
	 * @author 张国荣
	 * @title: selQuestion
	 * @date 2016年8月14日 上午10:11:46
	 * @param account
	 * @return String
	 */
	public String selQuestion(String account){
		sql = "SELECT question FROM USER WHERE username = ? AND role = 0";
		if(jt.queryMap(sql, new String[]{account}).isEmpty()){
			return "找回密码的问题";
		}else{
			return jt.queryMap(sql, new String[]{account}).get(0).get("question");
		}
	}
	/**
	 * 验证用户的验证回答是否正确
	 * @author 张国荣
	 * @title: proveAnswer
	 * @date 2016年8月14日 上午10:12:17
	 * @param account
	 * @param answer
	 * @return boolean
	 */
	public boolean proveAnswer(String account,String answer){
		sql = "SELECT answer FROM USER WHERE username = ? AND role = 0";
		if(jt.queryMap(sql, new String[]{account}).get(0).get("answer").equals(answer)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 验证用户的联系电话是否存在
	 * @author 张国荣
	 * @title: provePhoneNumber
	 * @date 2016年8月14日 上午10:12:41
	 * @param account
	 * @param phone_number
	 * @return boolean
	 */
	public boolean provePhoneNumber(String account,String phone_number){
		sql = "SELECT id FROM USER WHERE username = ? AND role = 0";
		String user_id = jt.queryMap(sql, new String[]{account}).get(0).get("id");
		sql = "SELECT phone_number FROM address WHERE user_id = " + user_id;
		temp = jt.queryMap(sql, null);
		boolean exist = false;
		for(Map<String,String> e : temp){
			if(e.get("phone_number").equals(phone_number)){
				exist = true;
			}
		}
		return exist;
	}
	/**
	 * 重设密码
	 * @author 张国荣
	 * @title: resetPassword
	 * @date 2016年8月14日 上午10:13:04
	 * @param account
	 * @param password void
	 */
	public void resetPassword(String account,String password){
		sql = "UPDATE USER SET PASSWORD = ? WHERE username = ?";
		jt.update(sql,new String[]{password,account});
	}
}
