package com.shxt.servlet.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.AddressService;
/**
 * 删除地址服务器
 * @author 张国荣
 * @ClassName: DeleteAddressServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:28:38
 * @description 类描述
 */
@WebServlet("/deleteAddress.do")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new AddressService().deleteAddress(request.getParameter("id"));
		response.sendRedirect("selAddress.do");
	}

}
