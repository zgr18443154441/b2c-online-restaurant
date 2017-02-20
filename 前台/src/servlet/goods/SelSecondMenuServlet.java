package com.shxt.servlet.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.GoodsService;
/**
 * 查询小类别商品服务器
 * @author 张国荣
 * @ClassName: SelSecondMenuServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:42:16
 * @description 类描述
 */
@WebServlet("/selSecondMenu.do")
public class SelSecondMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("secondMenu", new GoodsService().selSecondMenu(request.getParameter("id")));
		request.setAttribute("piece", new GoodsService().selPiece());
		request.getRequestDispatcher("loginout/second_category.jsp").forward(request, response);
	}

}
