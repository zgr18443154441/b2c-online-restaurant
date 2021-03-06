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
					<h2 class="heading">我的邮箱</h2>
					<p class="sub-heading">温馨提示：如果您的邮件未得到回复，可以拨打您所在城市的分店负责人的联系电话进行咨询。</p>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${email}" var="e">
					<div class="col-sm-5">
						<div class="fh5co-event to-animate-2">
							<p style="line-height: 10px;font-size: 20px">邮件内容</p>
							<span class="fh5co-event-meta" style="text-align: left;">${e.words}<br>${e.write_time}</span>
							<c:if test="${e.reply==null}"><span class="fh5co-event-meta" style="text-align: left;">暂未得到回复</span></c:if>
							<c:if test="${e.reply!=null}">
								<p style="line-height: 10px;font-size: 20px">回复内容</p>
								<span class="fh5co-event-meta" style="text-align: left;">${e.reply}<br>${e.reply_time}</span>
							</c:if>
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