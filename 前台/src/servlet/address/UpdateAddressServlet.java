package com.shxt.servlet.address;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Address;
import com.shxt.service.AddressService;
import com.shxt.util.FileUploadTool;
/**
 * 修改地址信息服务器
 * @author 张国荣
 * @ClassName: UpdateAddressServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:27:56
 * @description 类描述
 */
@WebServlet("/updateAddress.do")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("address", new AddressService().selOneAddress(request.getParameter("id")));
		request.setAttribute("province",new AddressService().selProvince());
		request.getRequestDispatcher("/loginon/updateAddress.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		String province = new String();
		String city = new String();
		for(Map<String,String> e : new AddressService().allMap()){
			if(e.get("id").equals(fut.getParameter("province"))){
				province = e.get("local_name");
			}
			if(e.get("id").equals(fut.getParameter("city"))){
				city = e.get("local_name");
				break;
			}
		}
		fut.upload();
		Address ad = new Address();
		ad.setAll_location(province+"省"+city+"市"+fut.getParameter("location"));
		ad.setName(fut.getParameter("realname"));
		ad.setPhone_number(fut.getParameter("phonenumber"));
		ad.setSex(fut.getParameter("sex"));
		ad.setId(Integer.parseInt(fut.getParameter("id")));
		ad.setUser_id(Integer.parseInt(fut.getParameter("user_id")));
		new AddressService().updateAddress(ad);
		response.sendRedirect("selAddress.do");
	}
}
