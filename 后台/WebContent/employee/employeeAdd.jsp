<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<base href="<%=basePath%>" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>后台界面</title>

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
<script type="text/javascript" src="plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
function able(){
	var $fieldset = $("#manager");
	$fieldset.attr("disabled",false);
}
function disable(){
	var $fieldset = $("#manager");
	$fieldset.attr("disabled",true);
	var $usernameTxt = $("#username");
	$usernameTxt.val("");
	var $passwordTxt = $("#password");
	$passwordTxt.val("");
	var $repasswordTxt = $("#repassword");
	$repasswordTxt.val("");
}
function test(){
	var $fieldset = $("#manager");
	if($fieldset.prop("disabled")==false){
		var $usernameTxt = $("#username");
		if($usernameTxt.val() == ""){
			var $fontObj = $("#usernameError");
			$fontObj.html("用户名不能为空");
			var $divObj = $("#un");
			$divObj.attr("class","form-group has-error");
			return false;
		}
		var $passwordTxt = $("#password");
		if($passwordTxt.val() == ""){
			var $fontObj = $("#passwordError");
			$fontObj.html("密码不能为空");
			var $divObj = $("#pw");
			$divObj.attr("class","form-group has-error");
			return false;
		}
		var $repasswordTxt = $("#repassword");
		if($repasswordTxt.val() == ""){
			var $fontObj = $("#repasswordError");
			$fontObj.html("确认密码不能为空");
			var $divObj = $("#rw");
			$divObj.attr("class","form-group has-error");
			return false;
		}
		if($passwordTxt.val()!=$repasswordTxt.val()){
			var $repasswordError = $("#repasswordError");
			$repasswordError.html("两次密码不一致，请重新输入");
			$passwordTxt.val("");
			$repasswordTxt.val("");
			var $divObj = $("#rw");
			$divObj.attr("class","form-group has-error");
			return false;
		}
	}
	var $realnameTxt = $("#real_name");
	if($realnameTxt.val() == ""){
		var $fontObj = $("#realnameError");
		$fontObj.html("姓名不能为空");
		var $divObj = $("#rn");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	return true;
}
function usernameError(){
	var $usernameTxt = $("#username");
	if($usernameTxt.val() != ""){
		var $fontObj = $("#usernameError");
		$fontObj.html("");
		var $divObj = $("#un");
		$divObj.attr("class","form-group");
	}
}
function passwordError(){
	var $passwordTxt = $("#password");
	if($passwordTxt.val() != ""){
		var $fontObj = $("#passwordError");
		$fontObj.html("");
		var $divObj = $("#pw");
		$divObj.attr("class","form-group");
	}
}
function repasswordError(){
	var $repasswordTxt = $("#repassword");
	if($repasswordTxt.val() != ""){
		var $fontObj = $("#repasswordError");
		$fontObj.html("");
		var $divObj = $("#rw");
		$divObj.attr("class","form-group");
	}
}
function realnameError(){
	var $realnameTxt = $("#real_name");
	if($realnameTxt.val() != ""){
		var $fontObj = $("#realnameError");
		$fontObj.html("");
		var $divObj = $("#rn");
		$divObj.attr("class","form-group");
	}
}
function exist(){
	var url = "userNameExist.do";
	var $usernameTxt = $("#username");
	var param = {username:$usernameTxt.val()};
	$.post(url,param,function(message){
		if("0" == message){
			var $fontObj = $("#usernameError");
			$fontObj.html("该用户名已存在");
			var $divObj = $("#un");
			$divObj.attr("class","form-group has-error");
		}else{
			var $fontObj = $("#usernameError");
			$fontObj.html("");
			var $divObj = $("#un");
			$divObj.attr("class","form-group");
		}
	})
}
</script>
</head>

<body>
    <div id="wrapper">
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        	<!--title-->
            <jsp:include page="/index/title.jsp"></jsp:include>
            <!--option-->
            <jsp:include page="/index/option.jsp"></jsp:include>
        </nav>
		<!-- /#page-wrapper -->
		  <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">添加员工</h1>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 v1.0
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form action="addEmployee.do" method="post" enctype="multipart/form-data" onsubmit="return test();">
                                    <div class="form-group">
                                            <label>请先选择员工权限</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="power" value="2" checked onclick="disable();">普通员工
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="power" value="1" onclick="able();">平台管理员
                                                </label>
                                            </div>
                                        </div>
                                         <fieldset id="manager" disabled>
                                            <div id="un" class="form-group">
                                                <label for="disabledSelect">用户名</label>
                                                <input class="form-control" id="username" name="username" type="text" placeholder="管理员选项" onkeyup="usernameError();" onblur="exist();">
                                                <p class="help-block" id="usernameError"></p>
                                                <font color="red">${error}</font>
                                            </div>
                                            <div id="pw" class="form-group">
                                                <label for="disabledSelect">密码</label>
                                                <input class="form-control" id="password" name="password" type="password" placeholder="管理员选项" onkeyup="passwordError();">
                                                <p class="help-block" id="passwordError"></p>
                                            </div>
                                            <div id="rw" class="form-group">
                                                <label for="disabledSelect">确认密码</label>
                                                <input class="form-control" id="repassword" name="repassword" type="password" placeholder="管理员选项" onkeyup="repasswordError();">
                                                <p class="help-block" id="repasswordError"></p>
                                            </div>
                                        </fieldset>
                                        <div id="rn" class="form-group">
                                             <label for="disabledSelect">姓名</label>
                                                <input class="form-control" id="real_name" name="real_name" type="text" value="${requestScope.real_name}" onkeyup="realnameError();">
                                                <p class="help-block" id="realnameError"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>性别</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="sex" id="man" value="男" >男
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="sex" id="woman" value="女" >女
                                            </label>
                                        </div>
                                        <div id="bd" class="form-group">
                                            <label>出生年月</label>
                                            <input class="form-control" type="text" id="birthday" name="birthday" value="${birthday}" placeholder="请输入格式为“2000-01-01”格式的日期">
                                            <p class="help-block">提示信息</p>
                                        </div>
                                        <div class="form-group">
                                            <label>邮箱</label>
                                            <input class="form-control" type="text" name="email" value="${email}">
                                        </div>
                                        <div class="form-group">
                                            <label>部门</label>
                                            <select class="form-control" name="department">
                                                <c:forEach items="${department_list}" var="d">
                                                	<option value="${d.department_name}" <c:if test="${d.department_name==department}">selected="selected"</c:if>>${d.department_name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
		                                    <label>照片</label>
		                                    <input type="file" name="photo" onchange="preview(this,'preview','imghead',150,200)" src="upload/${photo}">
		                                </div>
	                                    <div class="form-group" id= "preview">
											<img id="imghead" width="202" height="111"/>
										</div>
                                        <button type="submit" class="btn btn-default">提交</button>
                                        <button type="reset" class="btn btn-default">清空</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
	<script type="text/javascript" src="plugins/imagePreview/imagePreview.js"></script>

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
