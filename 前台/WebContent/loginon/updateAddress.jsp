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
	<title>Foodee</title>
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
function test(){
	var $phonenumber = $("#phonenumber");
	var $phonenumberError = $("#phonenumberError");
	var $location = $("#location");
	var $locationError = $("#locationError");
	var $city = $("#city");
	var $cityError = $("#cityError");
	if($phonenumber.val()==""){
		$phonenumberError.html("联系电话不能为空");
		return false;
	}
	if($location.val()==""){
		$locationError.html("详细地址不能为空");
		return false;
	}
	if($city.val()=="0"){
		$cityError.html("省市选项不能为空");
		return false;
	}
}
function phonenumberError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#phonenumberError").html("");
	}
}
function locationError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#locationError").html("");
	}
}
function cityError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#cityError").html("");
	}
}
function changeCity(obj){
	$province = $(obj);
	var $city = $("#city");
	$city.empty();
	if($province.val()=="0"){
		$city.append("<option value='0'>--请选择城市--</option>");
	}else{
		var url = "selCity.do";
		var param = {id:$province.val()};
		$.post(url,param,function(city){
			for(var i = 0; i<city.length; i++){
				$city.append("<option value=" + city[i].id + ">" + city[i].local_name + "</option>");
			}
		})
	}
}
$(function(){
	$(":radio[name='sex']").val(["${address.sex}"]);
	$("#location").html("${address.last_location}");
})
</script>
</head>
<body>

	<div id="fh5co-container">
		<!-- 菜单栏 -->
		<jsp:include page="/index/top_loginout.jsp"></jsp:include>
		<!-- 表单页 -->
		<div id="fh5co-contact" data-section="reservation">
			<div class="container">
				<div class="row">
					<div class="col-md-6 to-animate-2">
						<h3>修改地址</h3>
						<form action="updateAddress.do" method="post" enctype="multipart/form-data" onsubmit="return test();">
						<input type="hidden" name="user_id" value="${sessionScope.id}">
						<input type="hidden" name="id" value="${address.id}">
							<div class="form-group">
								<input name="realname" class="form-control" placeholder="姓名" type="text" value="${address.name}">
							</div>
							<div class="form-group">
								称呼&nbsp;&nbsp;
								<input id="name" name="sex" type="radio" value="先生">先生
								&nbsp;&nbsp;
								<input id="name" name="sex" type="radio" value="女士">女士
							</div>
							<div class="form-group">
								<input id="phonenumber" name="phonenumber" class="form-control" placeholder="联系电话" type="text" value="${address.phone_number}" onkeyup="phonenumberError();">
								<font id="phonenumberError" color="red" size="3"></font>
							</div>
							<div class="form-group">
								<select class="form-control" id="province" name="province" onchange="changeCity(this);">
									<option value="0">--请选择省份--</option>
									<c:forEach items="${province}" var="p">
										<option value="${p.id}">${p.local_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<select class="form-control" id="city" name="city" onchange="cityError();">
									<option value="0">--请选择城市--</option>
								</select>
								<font id="cityError" color="red" size="3"></font>
							</div>
							<div class="form-group ">
								<textarea name="location" id="location" cols="30" rows="5" class="form-control" placeholder="详细地址" onkeyup="locationError();"></textarea>
								<font id="locationError" color="red" size="3"></font>
							</div>
							<br>
							<div class="form-group ">
								<center>
									<input class="btn btn-primary" value="提交" type="submit">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="btn btn-primary" value="清空" type="reset">
								</center>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 站底 -->
	<jsp:include page="/index/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="plugins/imagePreview/imagePreview.js"></script>
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