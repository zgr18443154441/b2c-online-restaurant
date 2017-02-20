<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shxt.util.MyConstant" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
	<base href="<%=basePath%>" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Foodee &mdash; 100% Free Fully Responsive HTML5 Template </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='http://fonts.useso.com/css?family=Playfair+Display:400,700,400italic,700italic|Merriweather:300,400italic,300italic,400,700italic' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="foodee/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="foodee/css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" href="foodee/css/simple-line-icons.css">
	<!-- Datetimepicker -->
	<link rel="stylesheet" href="foodee/css/bootstrap-datetimepicker.min.css">
	<!-- Flexslider -->
	<link rel="stylesheet" href="foodee/css/flexslider.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="foodee/css/bootstrap.css">

	<link rel="stylesheet" href="foodee/css/style.css">


	<!-- Modernizr JS -->
	<script src="foodee/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="foodee/js/respond.min.js"></script>
	<![endif]-->
<script type="text/javascript" src="plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(function(){
	var $star = $("#star");
	$star.append("<i class='icon-thumbs-o-up'></i>（评分）");
	if("${goods.star}"==0){
		$star.append("暂无评分");
	}else{
		for(var i=0; i<"${goods.star}"; i++){
			$star.append("&nbsp;&nbsp;&nbsp;&nbsp;<i class='icon-star'></i>");
		}
	}
})
</script>
</head>
<body>

	<div id="fh5co-container">
		<!-- 菜单栏 -->
		<jsp:include page="/index/top_loginout.jsp"></jsp:include>
		<!-- 单个商品页 -->
		<div id="fh5co-about" data-section="about">
			<div class="fh5co-2col fh5co-bg to-animate-2" style="background-image: url(<%=MyConstant.BACK_PATH%>${goods.photo})"></div>
			<div class="fh5co-2col fh5co-text">
				<h2 class="heading to-animate">${goods.goods_name}</h2>
				<ul class="fh5co-contact-info" style="color: white;font-size: 20px;">
					<li><i class="icon-rmb"></i>（售价）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="15">${goods.post_price}</font>元</li>
					<li><i class="icon-bolt"></i>（优惠）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${goods.discount!='1'}"><font size="15">${goods.discount}</font>折</c:if>
						<c:if test="${goods.discount=='1'}">暂无</c:if>
					</li>
					<li><i class="icon-database"></i>（累计销售）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="15">${goods.sale_times}</font>份</li>
					<br/>
					<li id="star"></li>
				</ul>
				<br/>
				<p class="text-center to-animate">
					<a id="add" href="javascript:void(0);" class="btn btn-primary btn-outline" onclick="add();">加入购物车</a>
					<font id="number" size="6" color="white">0</font>份
					<a id="plus" class=" icon-chevron-up" href="javascript:void(0);"></a>
					<a id="minus" class=" icon-chevron-down" href="javascript:void(0);"></a>
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0);" class="btn btn-primary btn-outline">进行结算</a>
				</p>
			</div>
		</div>
		<!-- 评价信息栏 -->
		<div id="fh5co-sayings">
			<div class="container">
				<div class="row to-animate">
					<div class="flexslider">
						<ul class="slides">
							<c:if test="${fun:length(estimate_list)<=0}"><li>暂无评价</li></c:if>
							<c:forEach items="${estimate_list}" var="el">
								<li>
									<blockquote>
										<p>&ldquo;${el.assessment}。&rdquo;</p>
										<c:forEach items="${customers}" var="cus">
											<p class="quote-author">
												<c:if test="${el.user_id==cus.id}">
													<c:if test="${cus.real_name==''}">用户${cus.username}</c:if>
													<c:if test="${cus.real_name!=''}">${cus.real_name}</c:if>
												</c:if>
											</p>
										</c:forEach>
										${el.assess_time}
									</blockquote>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 站底 -->
	<jsp:include page="/index/bottom.jsp"></jsp:include>

	<!-- jQuery -->
	<script src="foodee/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="foodee/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="foodee/js/bootstrap.min.js"></script>
	<!-- Bootstrap DateTimePicker -->
	<script src="foodee/js/moment.js"></script>
	<script src="foodee/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Waypoints -->
	<script src="foodee/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="foodee/js/jquery.stellar.min.js"></script>

	<!-- Flexslider -->
	<script src="foodee/js/jquery.flexslider-min.js"></script>
	<script>
		$(function () {
	       $('#date').datetimepicker();
	   });
	</script>
	<!-- Main JS -->
	<script src="foodee/js/main.js"></script>

</body>
</html>