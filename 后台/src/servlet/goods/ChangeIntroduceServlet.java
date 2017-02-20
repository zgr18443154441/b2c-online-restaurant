package com.shxt.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.GoodsService;
/**
 * 改变推荐商品服务器
 * @author 张国荣
 * @ClassName: ChangeIntroduceServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:54:05
 * @description 类描述
 */
@WebServlet("/changeIntroduce.do")
public class ChangeIntroduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new GoodsService().changeIntroduceGoods(request.getParameter("list_id"), request.getParameter("goods_id"));
	}

}
