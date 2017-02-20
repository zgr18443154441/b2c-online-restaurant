<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录界面</title>

    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="../plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
function test(){
	var $accountTxt = $("#account");
	if($accountTxt.val() == ""){
		var $fontObj = $("#accountError");
		$fontObj.html("用户名不能为空");
		return false;
	}
	var $passwordTxt = $("#password");
	if($passwordTxt.val() == ""){
		var $passwordError = $("#passwordError");
		$passwordError.html("密码不能为空");
		return false;
	}
	var $randTxt = $("#rand");
	if($randTxt.val() == ""){
		var $randError = $("#randError");
		$randError.html("密码不能为空");
		return false;
	}
	return true;
}
function accountError(obj){
	var $obj = $(obj);
	if($obj.val() != ""){
		var $fontObj = $("#accountError");
		$fontObj.html("");
	}
}
function passwordError(obj){
	var $obj = $(obj);
	if($obj.val() != ""){
		var $fontObj = $("#passwordError");
		$fontObj.html("");
	}
}
function randError(obj){
	var $obj = $(obj);
	if($obj.val() != ""){
		var $fontObj = $("#randError");
		$fontObj.html("");
	}
}
function random() {
	document.getElementById("codeImg").setAttribute("src","vcode/vcode.jsp?time="+Math.random());
}
</script>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">后台登录</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="login.do" onsubmit="return test();">
                            <fieldset>
                                <div class="form-group">
                                    <input id="account" class="form-control" placeholder="用户名" name="username" type="text" onkeyup="accountError(this);">
                                    <font id="accountError" color="red"></font>
                                </div>
                                <div class="form-group">
                                    <input id="password" class="form-control" placeholder="密码" name="password" type="password" onkeyup="passwordError(this);">
                                    <font id="passwordError" color="red"></font>
                                </div>
                                <div class="form-group">
								<img src="vcode/vcode.jsp" alt="看不清,换一张" id="codeImg" style="margin-right:5px;margin-bottom: -3px;cursor:pointer" onclick="random();"/>
                                </div>
                                <div class="form-group">
                                    <input id="rand" class="form-control" placeholder="验证码" name="rand" type="text" onkeyup="randError(this);">
                                    <font id="randError" color="red"></font>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="1">记住用户名
                                    </label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <font color="red">${error}</font>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="登录"/>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>
</html>