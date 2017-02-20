package com.shxt.servlet.address;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.AddressService;
/**
 * 查询城市服务器
 * @author 张国荣
 * @ClassName: SelCityServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:28:12
 * @description 类描述
 */
@WebServlet("/selCity.do")
public class SelCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Map<String,String>> city = new AddressService().selCity(request.getParameter("id"));
		Gson gson = new Gson();
		out.print(gson.toJson(city));
		out.flush();
		out.close();
	}

}
