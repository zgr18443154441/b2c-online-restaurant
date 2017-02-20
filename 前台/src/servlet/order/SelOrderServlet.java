package com.shxt.servlet.order;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.AddressService;
import com.shxt.service.CartService;
/**
 * 查询订单服务器
 * @author 张国荣
 * @ClassName: SelOrderServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:43:52
 * @description 类描述
 */
@WebServlet("/selOrder.do")
public class SelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> cart = new CartService().selCart((String)(request.getSession().getAttribute("id")));
		String address_id = new String();
		if(null==request.getParameter("id")){
			address_id = (String)(request.getAttribute("id"));
		}else{
			address_id = request.getParameter("id");
		}
		request.setAttribute("address", new AddressService().selOneAddress(address_id));
		request.setAttribute("cart", cart);
		double sum_price = 0;
		for(Map<String,String> e : cart){
			sum_price+= Double.parseDouble(e.get("real_price"))*Double.parseDouble(e.get("number"));
		}
		request.setAttribute("sum_price", String.valueOf(sum_price));
		request.getRequestDispatcher("/loginon/pay.jsp").forward(request, response);
	}

}
