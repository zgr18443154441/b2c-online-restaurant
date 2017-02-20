package com.shxt.servlet.estimate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EstimateService;
/**
 * 处理评分服务器
 * @author 张国荣
 * @ClassName: StarServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:37:23
 * @description 类描述
 */
@WebServlet("/star.do")
public class StarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(new EstimateService().EstimateExist(request.getParameter("list_id"), request.getParameter("goods_id"))){
			new EstimateService().updateStar(request.getParameter("star"), request.getParameter("list_id"), request.getParameter("goods_id"));
		}else{
			new EstimateService().addStar( request.getParameter("list_id"), request.getParameter("goods_id"),(String)(request.getSession().getAttribute("id")),request.getParameter("star"));
		}
	}

}
