package com.shxt.servlet.activity;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.ActivityService;
/**
 * 撤销活动服务器
 * @author 张国荣
 * @ClassName: ConcelActivityServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:11:02
 * @description 类描述
 */
@WebServlet("/concelActivity.do")
public class ConcelActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ActivityService().concelActivity(request.getParameter("id"));
	}

}
