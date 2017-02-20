package com.shxt.servlet.address;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.model.Address;
import com.shxt.service.AddressService;
import com.shxt.service.CartService;
/**
 * 选择地址服务器
 * @author 张国荣
 * @ClassName: ChooseAddressServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:29:07
 * @description 类描述
 */
@WebServlet("/chooseAddress.do")
public class ChooseAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(new CartService().selCart((String)(session.getAttribute("id"))).isEmpty()){
			request.setAttribute("error", "购物车为空，无法结算，请先选购商品。");
			request.getRequestDispatcher("/loginon/cart.jsp").forward(request, response);
			return;
		}
		List<Address> address = new AddressService().selAddress(String.valueOf(session.getAttribute("id")));
		request.setAttribute("address", address);
		request.getRequestDispatcher("/loginon/chooseAddress.jsp").forward(request, response);
	}

}
