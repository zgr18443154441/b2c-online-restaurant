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
<title>Foodee &mdash; 信息管理</title>
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
function sendover(obj){
	var $get = $(obj);
	$get.html("评价订单");
	$get.attr("href","addEstimate.do?order_list=" + $get.prev().val());
	var param = {id:$get.prev().val()};
	var url = "getOrder.do";
	$.post(url,param);
}
</script>
</head>
<body>

<div id="fh5co-container">
	<!-- 菜单栏 -->
	<jsp:include page="/index/top_loginon.jsp"></jsp:include>
	<!-- 地址信息 -->
	<div id="fh5co-events" data-section="events" style="background-image: url(foodee/images/slide_2.jpg);" data-stellar-background-ratio="0.5">
		<div class="fh5co-overlay"></div>
		<div class="container">
			<div class="row text-center fh5co-heading row-padded">
				<div class="col-md-8 col-md-offset-2 to-animate">
					<h2 class="heading">订单多多，优惠多多</h2>
					<p class="sub-heading">请用一分钟对您的订单进行评价和打分，您的宝贵建议是我们改善餐品的第一动力。</p>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${order_list}" var="ol">
					<div class="col-sm-5">
						<div class="fh5co-event to-animate-2">
							<h3 align="left">${ol.add.name}<font size="3">（${ol.add.sex}）</font></h3>
							<span class="fh5co-event-meta" style="text-align: left;">
								订餐电话：${ol.add.phone_number}<br>
								订餐时间：${ol.deal_time}<br>
								送餐地址：${ol.add.all_location}<br>
								备注：${ol.remark}<br>
								订单号：${ol.code}
							</span>
							<p style="line-height: 10px;font-size: 20px">订单详情</p>
							<c:forEach items="${ol.order_goods}" var="og">
								<p align="left" style="line-height: 10px">${og.goods_name} * ${og.number} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${og.real_price}￥</p>
							</c:forEach>
							<p align="left" style="line-height: 10px">总计：${ol.sum_price}￥</p>
							<p>
								<a href="reorderList.do?order_list=${ol.id}&address=${ol.add.id}" class="btn btn-primary btn-outline">再来一单</a>
								&nbsp;&nbsp;&nbsp;
								<c:if test="${ol.state=='0'}">
									<a href="javascript:void(0);" class="btn btn-primary btn-outline">等待接单</a>
								</c:if>
								<c:if test="${ol.state=='1'&&ol.get=='0'}">
									<input type="hidden" value="${ol.id}">
									<a href="javascript:void(0);" class="btn btn-primary btn-outline" onclick="sendover(this);">确认送达</a>
								</c:if>
								<c:if test="${ol.state=='1'&&ol.get=='1'&&ol.assess=='0'}">
									<a href="addEstimate.do?order_list=${ol.id}" class="btn btn-primary btn-outline">评价订单</a>
								</c:if>
								<c:if test="${ol.state=='1'&&ol.get=='1'&&ol.assess=='1'}">
									<a href="javascript:void(0);" class="btn btn-primary btn-outline">已评价</a>
								</c:if>
							</p>
						</div>
					</div>
				</c:forEach>
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