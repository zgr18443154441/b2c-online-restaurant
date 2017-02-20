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
/**
 * 查询地址信息服务器
 * @author 张国荣
 * @ClassName: SelAddressServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:28:25
 * @description 类描述
 */
@WebServlet("/selAddress.do")
public class SelAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Address> address = new AddressService().selAddress(String.valueOf(session.getAttribute("id")));
		request.setAttribute("address", address);
		request.getRequestDispatcher("/loginon/manageAddress.jsp").forward(request, response);
	}

}
