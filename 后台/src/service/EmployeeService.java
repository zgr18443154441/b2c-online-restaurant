package com.shxt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shxt.model.Employee;
import com.shxt.util.JDBC_Tool;
/**
 * 员工信息控制器
 * @author 张国荣
 * @ClassName: EmployeeService
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:50:21
 * @description 类描述
 */
public class EmployeeService {
	private String sql;
	private JDBC_Tool jt;
	private Employee em;
	private List<Map<String,String>> department_list;
	private String department_id;
	private String department_name;
	public EmployeeService(){
		jt = new JDBC_Tool("shop");
		department_list = new DepartmentService().getDepartment();
	}
	/**
	 * 查询所有员工信息
	 * @author 张国荣
	 * @title: getEmployee
	 * @date 2016年8月14日 上午1:50:35
	 * @return List<Employee>
	 */
	public List<Employee> getEmployee(){
		sql = "SELECT u.id,d.department_name,u.real_name,u.sex,u.birthday,u.email,u.photo FROM USER u LEFT JOIN department d ON u.department_id = d.id WHERE u.role = 1 OR u.role = 2";
		List<Map<String,String>> employee_list = jt.queryMap(sql, null);
		List<Employee> em_list = new ArrayList<>();
		for(Map<String,String> e : employee_list){
			em = new Employee();
			em.setId(Integer.parseInt(e.get("id")));
			em.setName(e.get("real_name"));
			em.setBirthday(e.get("birthday"));
			em.setDepartment(e.get("department_name"));
			em.setEmail(e.get("email"));
			em.setSex(e.get("sex").charAt(0));
			em.setPhoto(e.get("photo"));
			em_list.add(em);
		}
		return em_list;
	}
	/**
	 * 查询用户名是否存在
	 * @author 张国荣
	 * @title: testUserName
	 * @date 2016年8月14日 上午1:50:52
	 * @param username
	 * @return boolean
	 */
	public boolean testUserName(String username){
		sql = "SELECT username FROM USER WHERE username IS NOT NULL ";
		List<Map<String,String>> username_list = jt.queryMap(sql, null);
		for(Map<String,String> e : username_list){
			if(e.get("username").equals(username)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 测试用户名信息
	 * @author 张国荣
	 * @title: testManagerName
	 * @date 2016年8月14日 上午1:51:58
	 * @param id
	 * @return String
	 */
	public String testManagerName(String id){
		sql = "UPDATE USER SET role=1 WHERE id =" + id;
		jt.update(sql);
		sql = "SELECT username FROM USER WHERE username IS NOT NULL AND id = " + id;
		if(jt.queryMap(sql, null).isEmpty()){
			return "0";
		}else{
			return jt.queryMap(sql, null).get(0).get("username");
		}
	}
	/**
	 * 验证原密码是否正确
	 * @author 张国荣
	 * @title: testOldPassword
	 * @date 2016年8月14日 上午1:52:09
	 * @param id
	 * @param oldPassword
	 * @return String
	 */
	public String testOldPassword(String id,String oldPassword){
		sql = "SELECT PASSWORD FROM USER WHERE id = " + id;
		String password = jt.queryMap(sql, null).get(0).get("password");
		if(null==password){
			return "0";
		}else if(password.equals(oldPassword)){
			return "1";
		}else{
			return "2";
		}
	}
	/**
	 * 取消员工登录后台权限
	 * @author 张国荣
	 * @title: concelPower
	 * @date 2016年8月14日 上午1:52:52
	 * @param id void
	 */
	public void concelPower(String id){
		sql = "UPDATE USER SET PASSWORD=NULL,role=2 WHERE id =" + id;
		jt.update(sql);
	}
	/**
	 * 添加新员工
	 * @author 张国荣
	 * @title: addEmployee
	 * @date 2016年8月14日 上午1:53:09
	 * @param emp void
	 */
	public void addEmployee(Employee emp){
		for(Map<String,String> e : department_list){
			if(e.get("department_name").equals(emp.getDepartment())){
				department_id = e.get("id");
				break;
			}
		}
		if(emp.getRole()=='1'){
			sql = "INSERT INTO USER(username,PASSWORD,role,department_id,real_name,sex,birthday,email,photo) VALUES(?,?,?,?,?,?,?,?,?)";
			jt.update(sql, new String[]{emp.getUsername(),emp.getPassword(),"1",department_id,emp.getName(),String.valueOf(emp.getSex()),emp.getBirthday(),emp.getEmail(),emp.getPhoto()});
		}else{
			sql = "INSERT INTO USER(role,department_id,real_name,sex,birthday,email,photo) VALUES(?,?,?,?,?,?,?)";
			jt.update(sql, new String[]{"2",department_id,emp.getName(),String.valueOf(emp.getSex()),emp.getBirthday(),emp.getEmail(),emp.getPhoto()});
		}
	}
	/**
	 * 查询一名员工信息
	 * @author 张国荣
	 * @title: selEmployee
	 * @date 2016年8月14日 上午1:53:26
	 * @param id
	 * @return Employee
	 */
	public Employee selEmployee(String id){
		sql = "SELECT id,username,PASSWORD,role,department_id,real_name,sex,birthday,email,photo FROM USER WHERE id = " + id;
		em = new Employee();
		Map<String,String> emp = jt.queryMap(sql, null).get(0);
		for(Map<String,String> e : department_list){
			if(e.get("id").equals(emp.get("department_id"))){
				department_name = e.get("department_name");
				break;
			}
		}
		em.setId(Integer.parseInt(emp.get("id")));
		em.setBirthday(emp.get("birthday"));
		em.setDepartment(department_name);
		em.setEmail(emp.get("email"));
		em.setName(emp.get("real_name"));
		em.setPassword(emp.get("password"));
		em.setPhoto(emp.get("photo"));
		em.setRole(emp.get("role").charAt(0));
		em.setSex(emp.get("sex").charAt(0));
		em.setUsername(emp.get("username"));
		return em;
	}
	/**
	 * 修改员工信息
	 * @author 张国荣
	 * @title: updateEmployee
	 * @date 2016年8月14日 上午1:53:45
	 * @param emp void
	 */
	public void updateEmployee(Employee emp){
		for(Map<String,String> e : department_list){
			if(e.get("department_name").equals(emp.getDepartment())){
				department_id = e.get("id");
				break;
			}
		}
		if(emp.getRole()=='1'){
			sql = "UPDATE USER SET username=?,PASSWORD=?,role=1,department_id=?,real_name=?,sex=?,birthday=?,email=?,photo=? WHERE id =?";
			jt.update(sql, new String[]{emp.getUsername(),emp.getPassword(),department_id,emp.getName(),String.valueOf(emp.getSex()),emp.getBirthday(),emp.getEmail(),emp.getPhoto(),String.valueOf(emp.getId())});
		}else{
			sql = "UPDATE USER SET username=NULL,PASSWORD=NULL,role=2,department_id=?,real_name=?,sex=?,birthday=?,email=?,photo=? WHERE id =?";
			jt.update(sql, new String[]{department_id,emp.getName(),String.valueOf(emp.getSex()),emp.getBirthday(),emp.getEmail(),emp.getPhoto(),String.valueOf(emp.getId())});
		}
	}
	/**
	 * 删除员工信息
	 * @author 张国荣
	 * @title: deleteEmployee
	 * @date 2016年8月14日 上午1:53:54
	 * @param id void
	 */
	public void deleteEmployee(String id){
		sql = "DELETE FROM USER WHERE id = " + id;
		jt.update(sql);
	}
}
