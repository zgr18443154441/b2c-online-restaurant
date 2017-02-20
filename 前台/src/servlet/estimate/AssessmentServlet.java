package com.shxt.servlet.estimate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EstimateService;
/**
 * 处理评价服务器
 * @author 张国荣
 * @ClassName: AssessmentServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:38:14
 * @description 类描述
 */
@WebServlet("/assessment.do")
public class AssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(new EstimateService().EstimateExist(request.getParameter("list_id"), request.getParameter("goods_id"))){
			new EstimateService().updateEstimate(request.getParameter("assessment"), request.getParameter("list_id"), request.getParameter("goods_id"));
		}else{
			new EstimateService().addEstimate( request.getParameter("list_id"), request.getParameter("goods_id"),(String)(request.getSession().getAttribute("id")),request.getParameter("assessment"));
		}
	}

}
