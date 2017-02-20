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
function message(obj){
	var $city = $(obj);
	var url = "selRestaurantMessage.do";
	var param = {id:$city.val()};
	if($city.val()!=""){
		$.post(url,param,function(message){
			$("#add").html("<i class='icon-home'></i>餐厅地址：" + message.city);
			$("#pn").html("<i class='icon-phone'></i>联系电话：" + message.phone_number);
			$("#ma").html("<i class='icon-user'></i>负责人（经理）：" + message.name + "(" + message.sex + ")");
		})
	}else{
		$("#add").html("");
		$("#pn").html("");
		$("#ma").html("");
	}
}
function test(){
	var $email = $("#email");
	var $emailError = $("#emailError");
	if($email.val()==""){
		$emailError.html("发送邮件内容不能为空");
		return false;
	}
}
function emailError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#emailError").html("");
	}
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
						<h2 class="heading to-animate">沟通渠道</h2>
						<p class="sub-heading to-animate">在您的投诉邮件中留下您的联系方式有助于我们在第一时间和您取得联系，解决您的问题</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 to-animate-2">
						<h3>企业信息</h3>
						<ul class="fh5co-contact-info">
							<li>
								<div class="form-group">
								<i class="icon-search2"></i>
									<select class="form-control" id="city" onchange="message(this);">
										<option value="">请先选择所在城市</option>
										<c:forEach items="${city}" var="c">
											<option value="${c.id}">${c.city}</option>
										</c:forEach>
									</select>
								</div>
							</li>
							<li id="add"></li>
							<li id="pn"></li>
							<li id="ma"></li>
						</ul>
					</div>
					<div class="col-sm-6 to-animate-2">
						<h3>投诉信箱</h3>
						<form action="sendMessage.do" method="post" onsubmit="return test();">
							<div class="form-group ">
								<textarea name="email" id="email" cols="30" rows="5" class="form-control" placeholder="如果您对我们的商品和服务有什么意见和建议，请在此留言给我们，您的鼓励与督促是我们进步的动力。" onkeyup="emailError(this);"></textarea>
								<font id="emailError" color="red" size="3"></font>
							</div>
							<div class="form-group ">
								<input class="btn btn-primary" value="提交邮件" type="submit">
								<a class="btn btn-primary" href="selEmail.do">查看我的邮箱</a>
							</div>
						</form>
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