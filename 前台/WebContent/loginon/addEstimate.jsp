<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<title>Foodee &mdash; 支付界面 </title>
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
function assessment(obj){
	var $assessment = $(obj);
	var goods_id = $assessment.parent().prev().val();
	var list_id = "${list_id}";
	var url = "assessment.do";
	var param = {list_id:list_id,goods_id:goods_id,assessment:$assessment.val()};
	$.post(url,param);
}
function star(obj){
	var $star = $(obj);
	var goods_id = $star.parent().prev().prev().val();
	var list_id = "${list_id}";
	var url = "star.do";
	var param = {list_id:list_id,goods_id:goods_id,star:$star.val()};
	$.post(url,param);
}
</script>
</head>
<body>

	<div id="fh5co-container">
		<!-- 菜单栏 -->
		<jsp:include page="/index/top_loginon.jsp"></jsp:include>
		<!-- 支付信息 -->
		<div id="fh5co-contact" data-section="reservation">
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class="heading to-animate">评价商品，赚取积分</h2>
						<p class="sub-heading to-animate">用心评价商品的用户有机会获得我们的活动名额，快来吐槽吧</p>
					</div>
				</div>
				<form action="addEstimate.do" method="post">
					<div class="row">
						<div class="col-sm-6 to-animate-2">
							<h3>建议与意见</h3>
							<input type="hidden" name="list_id" value="${list_id}">
							<div class="form-group ">
								<textarea name="email" cols="30" rows="5" class="form-control" placeholder="您的宝贵建议是我们前进的动力"></textarea>
							</div>
						</div>
						<div class="col-sm-6 to-animate-2">
							<h3>商品评价</h3>
							<c:forEach items="${goods}" var="g">
								<input type="hidden" value="${g.id}">
								<div class="form-group ">
									<input class="form-control" placeholder="${g.goods_name}" type="text" onblur="assessment(this);">
								</div>
								<div class="form-group">
									<select class="form-control" onchange="star(this);">
										<option value="1">味同嚼蜡（☆）</option>
									  	<option value="2">勉强及格（☆☆）</option>
									 	<option value="3">可以接受（☆☆☆）</option>
									  	<option value="4">味道不错（☆☆☆☆）</option>
									  	<option value="5">美味佳肴（☆☆☆☆☆）</option>
									</select>
								</div>
							</c:forEach>
							<div class="form-group ">
								<input class="btn btn-primary" value="提交评价" type="submit">
							</div>
						</div>
					</div>
				</form>
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