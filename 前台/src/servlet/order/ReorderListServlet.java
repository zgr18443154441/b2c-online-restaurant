package com.shxt.servlet.order;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.service.CartService;
import com.shxt.service.OrderService;
/**
 * 再来一单服务器
 * @author 张国荣
 * @ClassName: ReorderListServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:44:24
 * @description 类描述
 */
@WebServlet("/reorderList.do")
public class ReorderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> reorder_goods = new OrderService().selReoderGoods(request.getParameter("order_list"));
		HttpSession session = request.getSession();
		for(Map<String,String> e : reorder_goods){
			new CartService().addCart(e.get("goods_id"), (String)(session.getAttribute("id")), e.get("number"));
		}
		request.setAttribute("id", request.getParameter("address"));
		request.getRequestDispatcher("/selOrder.do").forward(request, response);
	}

}
