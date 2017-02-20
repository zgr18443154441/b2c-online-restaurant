package com.shxt.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.GoodsService;
/**
 * 查询推荐商品服务器
 * @author 张国荣
 * @ClassName: IntroduceGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:55:31
 * @description 类描述
 */
@WebServlet("/introduceGoods.do")
public class IntroduceGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("goods_list", new GoodsService().selIntroduceGoods());
		request.setAttribute("goods_ld", new GoodsService().selGoodsId());
		request.getRequestDispatcher("/goods/goodsIntroduce.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
