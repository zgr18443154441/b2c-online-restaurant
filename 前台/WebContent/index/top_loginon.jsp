<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<div class="js-sticky">
	<div class="fh5co-main-nav">
		<div class="container-fluid">
			<div class="fh5co-menu-1">
				<a href="selMenu.do">开始订餐</a>
				<a href="selCart.do">购物车</a>
				<a href="selList.do">我的订单</a>
			</div>
			<div class="fh5co-logo">
				<a href="javascript:void(0);">foodee</a>
			</div>
			<div class="fh5co-menu-2">
				<a href="selAddress.do">信息管理</a>
				<a href="sendMessage.do">客服中心</a>
				<a href="loginOut.do">注销</a>
				<a href="javascript:void(0);">${sessionScope.real_name} 登录中</a>
			</div>
		</div>
	</div>
</div>