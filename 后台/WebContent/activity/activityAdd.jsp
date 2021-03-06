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
function test(){
	var $stockname = $("#stockname");
	if($stockname.val() == ""){
		var $fontObj = $("stocknameError");
		$fontObj.html("活动名称不能为空");
		var $divObj = $("#sn");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $start = $("#start");
	if($start.val() == ""){
		var $fontObj = $("startError");
		$fontObj.html("开始时间不能为空");
		var $divObj = $("#st");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $top = $("#top");
	if($top.val()==""){
		var $fontObj = $("topError");
		$fontObj.html("结束时间不能为空");
		var $divObj = $("#to");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $description = $("#description");
	if($description.val()==""){
		var $fontObj = $("descriptionError");
		$fontObj.html("活动描述不能为空");
		var $divObj = $("#de");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	return true;
}
function stocknameError(){
	var $stockname = $("#stockname");
	if($stockname.val() != ""){
		var $fontObj = $("#stocknameError");
		$fontObj.html("");
		var $divObj = $("#sn");
		$divObj.attr("class","form-group");
	}
}
function startError(){
	var $start = $("#start");
	if($start.val() != ""){
		var $fontObj = $("#startError");
		$fontObj.html("");
		var $divObj = $("#st");
		$divObj.attr("class","form-group");
	}
}
function topError(){
	var $top = $("#top");
	if($top.val() != ""){
		var $fontObj = $("#topError");
		$fontObj.html("");
		var $divObj = $("#to");
		$divObj.attr("class","form-group");
	}
}
function descriptionError(){
	var $description = $("#description");
	if($description.val() != ""){
		var $fontObj = $("#descriptionError");
		$fontObj.html("");
		var $divObj = $("#de");
		$divObj.attr("class","form-group");
	}
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
                    <h1 class="page-header">添加活动</h1>
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
                                    <form role="form" action="addActivity.do" method="post" enctype="multipart/form-data" onsubmit="return test();">
                                        <div id="sn" class="form-group">
                                             <label for="disabledSelect">名称</label>
                                                <input class="form-control" id="stockname" name="stockname" type="text" onkeyup="stocknameError()">
                                                <p class="help-block" id="stocknameError"></p>
                                        </div>
                                        <div id="st" class="form-group">
                                             <label for="disabledSelect">初始时间</label>
                                                <input class="form-control" id="start" name="start" type="text" onkeyup="startError()">
                                                <p class="help-block" id="startError"></p>
                                        </div>
                                        <div id="to" class="form-group">
                                             <label for="disabledSelect">结束时间</label>
                                                <input class="form-control" id="top" name="top" type="text" onkeyup="topError()">
                                                <p class="help-block" id="topError"></p>
                                        </div>
                                        <div id="de" class="form-group">
                                             <label for="disabledSelect">内容描述</label>
                                                <textarea rows="5" cols="30" class="form-control" id="description" name="description" onkeyup="descriptionError()"></textarea>
                                                <p class="help-block" id="descriptionError"></p>
                                        </div>
                                        <div class="form-group">
		                                    <label>活动宣传图</label>
		                                    <input type="file" name="photo" onchange="preview(this,'preview','imghead',150,200)">
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
	<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>

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
