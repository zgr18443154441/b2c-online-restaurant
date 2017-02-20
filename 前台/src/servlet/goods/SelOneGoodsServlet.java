package com.shxt.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.service.CartService;
import com.shxt.service.CustomerService;
import com.shxt.service.EstimateService;
import com.shxt.service.GoodsService;
/**
 * 查询一件商品信息服务器
 * @author 张国荣
 * @ClassName: SelOneGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:42:33
 * @description 类描述
 */
@WebServlet("/selOneGoods.do")
public class SelOneGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("goods", new GoodsService().selOneGoods(request.getParameter("id")));
		request.setAttribute("customers", new CustomerService().selCustomerName());
		request.setAttribute("estimate_list", new EstimateService().selGoodsEstimate(request.getParameter("id")));
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null){
			request.getRequestDispatcher("/loginout/goods.jsp").forward(request, response);
		}else{
			String number = new CartService().cartExist((String)(session.getAttribute("id")),request.getParameter("id"));
			request.setAttribute("number", number);
			request.getRequestDispatcher("/loginon/goods.jsp").forward(request, response);
		}
	}

}
