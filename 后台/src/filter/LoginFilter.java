package com.shxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 后台登录过滤器
 * @author 张国荣
 * @ClassName: LoginFilter
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午1:37:39
 * @description 类描述
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest sr, ServletResponse sre, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)sr;
		HttpServletResponse response = (HttpServletResponse)sre;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		//去掉不需要过滤的请求
		String url = request.getServletPath();
		if("/index/login.jsp".equals(url) || "/login.do".equals(url)){
			chain.doFilter(request, response);
			return;
		}
		//跳到登录页面
		if("".equals(request.getSession().getAttribute("username"))){
			request.getRequestDispatcher("/index/login.jsp").forward(request, response);
			return;
		}
		//让请求继续访问
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
