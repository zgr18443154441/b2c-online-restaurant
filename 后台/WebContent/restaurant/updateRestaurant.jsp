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
<script type="text/javascript" src="../plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
function test(){
	var $manager = $("#manager");
	var $managerError = $("#managerError");
	var $phonenumber = $("#phonenumber");
	var $phonenumberError = $("#phonenumberError");
	var $location = $("#location");
	var $locationError = $("#locationError");
	var $city = $("#city");
	var $cityError = $("#cityError");
	if($manager.val()==""){
		$managerError.html("负责人不能为空");
		return false;
	}
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
function managerError(obj){
	var $obj = $(obj);
	if($obj.val()!=""){
		$("#managerError").html("");
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
                    <h1 class="page-header">店铺信息更改</h1>
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
                                    <form role="form" action="updateRestaurant.do" method="post" enctype="multipart/form-data">
                                    	<input type="hidden" name="id" value="${restaurant.id}">
                                        <div id="sn" class="form-group">
                                            <label for="disabledSelect">负责人</label>
                                        	<input class="form-control" id="manager" name="manager" type="text" onblur="manager(this);" value="${restaurant.manager}">
                                            <p class="help-block" id="managerError"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>性别</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="sex" id="man" value="先生" <c:if test="${restaurant.sex=='先生'}">checked="checked"</c:if> >先生
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="sex" id="woman" value="女士" <c:if test="${restaurant.sex=='女士'}">checked="checked"</c:if> >女士
                                            </label>
                                        </div>
                                        <div id="sn" class="form-group">
                                            <label for="disabledSelect">联系电话</label>
                                        	<input class="form-control" id="phonenumber" name="phonenumber" type="text" onblur="phonenumberError(this);" value="${restaurant.phone_number}">
                                            <p class="help-block" id="phonenumberError"></p>
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
											<textarea name="location" id="location" cols="30" rows="5" class="form-control" placeholder="详细地址" onkeyup="locationError();">${restaurant.location}</textarea>
											<font id="locationError" color="red" size="3"></font>
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
    <script type="text/javascript" src="<%=path %>plugins/jQuery/jquery.js"></script>
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
