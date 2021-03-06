<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	var $password = $("#password");
	var $passwordError = $("#passwordError");
	var $repassword = $("#repassword");
	var $repasswordError = $("#repasswordError");
	if($password.val()==""){
		$passwordError.html("新密码不能为空");
		return false;
	}
	if($repassword.val()==""){
		$repasswordError.html("确认密码不能为空");
		return false;
	}
	if($password.val()!=$repassword.val()){
		$passwordError.html("两次密码输入不一致");
		return false;
	}
}
function passwordError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#passwordError").html("");
	}
}
function repasswordError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#repasswordError").html("");
	}
}
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
						<h3>重设密码</h3>
						<form action="resetPassword.do" method="post" onsubmit="return test();">
							<input name="account" value="${account}" style="display: none;">
							<div class="form-group">
								<input id="password" name="password" class="form-control" placeholder="新密码" type="password" onkeyup="passwordError(this);">
								<font id="passwordError" color="red" size="3"></font>
							</div>
							<div class="form-group">
								<input id="repassword" class="form-control" placeholder="确认密码" type="password" onkeyup="repasswordError(this);">
								<font id="repasswordError" color="red" size="3"></font>
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