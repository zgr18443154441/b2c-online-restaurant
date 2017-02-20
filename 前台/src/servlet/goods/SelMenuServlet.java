package com.shxt.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.service.GoodsService;
/**
 * 查询大类别商品服务器
 * @author 张国荣
 * @ClassName: SelMenuServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:42:47
 * @description 类描述
 */
@WebServlet("/selMenu.do")
public class SelMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService gs = new GoodsService();
		request.setAttribute("class1", gs.selMenu("1"));
		request.setAttribute("class2", gs.selMenu("2"));
		request.setAttribute("class3", gs.selMenu("3"));
		request.setAttribute("class4", gs.selMenu("4"));
		request.setAttribute("class5", gs.selMenu("5"));
		request.setAttribute("class6", gs.selMenu("6"));
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null){
			request.getRequestDispatcher("loginout/first_category.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("loginon/first_category.jsp").forward(request, response);
		}
	}

}
