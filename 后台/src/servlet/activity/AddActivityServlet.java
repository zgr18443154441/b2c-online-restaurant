package com.shxt.servlet.activity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Activity;
import com.shxt.service.ActivityService;
import com.shxt.util.FileUploadTool;
/**
 * 添加活动服务器
 * @author 张国荣
 * @ClassName: AddActivityServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:10:46
 * @description 类描述
 */
@WebServlet("/addActivity.do")
public class AddActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Activity ac = new Activity();
		ac.setDescription(fut.getParameter("description"));
		ac.setEnd_time(fut.getParameter("top"));
		ac.setName(fut.getParameter("stockname"));
		ac.setStart_time(fut.getParameter("start"));
		ac.setPhoto(fut.getParameter("photo"));
		new ActivityService().addActivity(ac);
		response.sendRedirect("index/frame.jsp");
	}

}
