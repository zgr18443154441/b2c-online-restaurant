<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shxt.util.MyConstant" %>
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
</head>
<body>

	<div id="fh5co-container">
		<!-- 菜单栏 -->
		<jsp:include page="/index/top_loginon.jsp"></jsp:include>
		<!-- 菜单页 -->
		<div id="fh5co-menus" data-section="menu">
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class="heading to-animate">商品菜单</h2>
						<p class="sub-heading to-animate">信誉在食品界是何等重要，而这正是我们所拥有的。</p>
					</div>
				</div>
				<div class="row row-padded">
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-drinks">快餐便当</h2>
							<ul>
								<c:forEach items="${class1}" var="c1">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c1.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c1.id}"><h3>${c1.goods_name}</h3></a>
												<p><c:if test="${c1.discount!='1'}">折扣：${c1.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c1.post_price}/${c1.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-dishes">特色菜系</h2>
							<ul>
								<c:forEach items="${class2}" var="c2">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c2.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c2.id}"><h3>${c2.goods_name}</h3></a>
												<p><c:if test="${c2.discount!='1'}">折扣：${c2.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c2.post_price}/${c2.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-dishes">小吃甜品</h2>
							<ul>
								<c:forEach items="${class4}" var="c4">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c4.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c4.id}"><h3>${c4.goods_name}</h3></a>
												<p><c:if test="${c4.discount!='1'}">折扣：${c4.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c4.post_price}/${c4.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-drinks">异国料理</h2>
							<ul>
								<c:forEach items="${class3}" var="c3">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c3.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c3.id}"><h3>${c3.goods_name}</h3></a>
												<p><c:if test="${c3.discount!='1'}">折扣：${c3.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c3.post_price}/${c3.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-drinks">养生汤煲</h2>
							<ul>
								<c:forEach items="${class5}" var="c5">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c5.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c5.id}"><h3>${c5.goods_name}</h3></a>
												<p><c:if test="${c5.discount!='1'}">折扣：${c5.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c5.post_price}/${c5.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-dishes">清凉饮品</h2>
							<ul>
								<c:forEach items="${class6}" var="c6">
									<li>
										<div class="fh5co-food-desc">
											<figure>
												<img src="<%=MyConstant.BACK_PATH %>${c6.photo}" class="img-responsive">
											</figure>
											<div>
												<a href="selOneGoods.do?id=${c6.id}"><h3>${c6.goods_name}</h3></a>
												<p><c:if test="${c6.discount!='1'}">折扣：${c6.discount}</c:if></p>
											</div>
										</div>
										<div class="fh5co-food-pricing">
											￥${c6.post_price}/${c6.piece_name}
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4 text-center to-animate-2">
						<p><a href="selSecondMenu.do?id=1" class="btn btn-primary btn-outline">查看详细菜单</a></p>
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