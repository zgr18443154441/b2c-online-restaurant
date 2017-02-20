package com.shxt.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Address;
import com.shxt.model.OrderList;
import com.shxt.service.AddressService;
import com.shxt.service.OrderService;
/**
 * 查询订单商品服务器
 * @author 张国荣
 * @ClassName: SelListServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:44:12
 * @description 类描述
 */
@WebServlet("/selList.do")
public class SelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderList> order_list = new OrderService().selOrderList((String)(request.getSession().getAttribute("id")));
		for(OrderList e : order_list){
			Address add = new AddressService().selOneAddress(String.valueOf(e.getAddress_id()));
			e.setAdd(add);
		}
		request.setAttribute("order_list", order_list);
		request.getRequestDispatcher("/loginon/order_list.jsp").forward(request, response);
	}

}
