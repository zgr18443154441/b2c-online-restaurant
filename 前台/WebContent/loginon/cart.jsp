<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shxt.util.MyConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
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
</head>
<body>

	<div id="fh5co-container">
		<!-- 菜单栏 -->
		<jsp:include page="/index/top_loginon.jsp"></jsp:include>
		<!-- 购物车页 -->
		<div id="fh5co-menus" data-section="menu">
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class="heading to-animate">购物车</h2>
						<p class="sub-heading to-animate">膳食搭配的原则在于“食不厌杂”，意在食物要多样，目的是通过食物多样化的途径，实现营养全面性的目标。“杂”主要指的是食物的种类要多，跨度要大，属性远，一般人的膳食每日的食物种类应在30种以上。</p>
					</div>
				</div>
				<div class="row row-padded">
					<div class="col-md-6">
						<div class="fh5co-food-menu to-animate-2">
							<ul>
								<c:if test="${fun:length(cart)==0}"><li><center>${error}</center></li></c:if>
								<c:forEach items="${cart}" var="cart">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${cart.photo}" class="img-responsive">
											</figure>
											<div>
												<h3>
													${cart.goods_name} * <font color="#fb6e14" size="6" id="number">
													${cart.number}</font>
												</h3>
													<a class="icon-cross2" href="deleteCart.do?id=${cart.id}"></a>
												<p>
													<c:if test="${cart.discount!='1'}">折扣：${cart.discount}</c:if>
												</p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${cart.post_price}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4 text-center to-animate-2">
						<p>
							<a href="selMenu.do" class="btn btn-primary btn-outline">继续选购</a>
							<a href="dropCart.do" class="btn btn-primary btn-outline">清空购物车</a>
							<a href="chooseAddress.do" class="btn btn-primary btn-outline">进行结算</a>
						</p>
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