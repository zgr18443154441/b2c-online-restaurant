<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<div class="js-sticky">
	<div class="fh5co-main-nav">
		<div class="container-fluid">
			<div class="fh5co-menu-1">
				<a href="loginout/welcome.jsp" >欢迎页</a>
				<a href="loginout/introduction.jsp" >关于我们</a>
				<a href="selIntroduceGoods.do" >精选美食</a>
			</div>
			<div class="fh5co-logo">
				<a href="javascript:void(0);">foodee</a>
			</div>
			<div class="fh5co-menu-2">
				<a href="selMenu.do">商品菜单</a>
				<a href="selActivity.do">热门活动</a>
				<a href="loginout/login.jsp">登录（注册）</a>
			</div>
		</div>
	</div>
</div>