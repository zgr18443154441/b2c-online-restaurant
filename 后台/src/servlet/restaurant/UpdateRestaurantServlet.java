package com.shxt.servlet.restaurant;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Restaurant;
import com.shxt.service.RestaurantService;
import com.shxt.util.FileUploadTool;
/**
 * 修改实体店信息服务器
 * @author 张国荣
 * @ClassName: UpdateRestaurantServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:03:46
 * @description 类描述
 */
@WebServlet("/updateRestaurant.do")
public class UpdateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("province",new RestaurantService().selProvince());
		request.setAttribute("restaurant", new RestaurantService().selOneRestaurant(request.getParameter("id")));
		request.getRequestDispatcher("/restaurant/updateRestaurant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		String province = new String();
		String city = new String();
		for(Map<String,String> e : new RestaurantService().allMap()){
			if(e.get("id").equals(fut.getParameter("province"))){
				province = e.get("local_name");
			}
			if(e.get("id").equals(fut.getParameter("city"))){
				city = e.get("local_name");
				break;
			}
		}
		fut.upload();
		Restaurant re = new Restaurant();
		re.setId(Integer.parseInt(fut.getParameter("id")));
		re.setLocation(province+"省"+city+"市"+fut.getParameter("location"));
		re.setManager(fut.getParameter("manager"));
		re.setPhone_number(fut.getParameter("phonenumber"));
		re.setSex(fut.getParameter("sex"));
		new RestaurantService().updateRestaurant(re);
		response.sendRedirect("index/frame.jsp");
	}

}
