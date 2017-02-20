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
	var $goodsnameTxt = $("#goods_name");
	if($goodsnameTxt.val() == ""){
		var $fontObj = $("#goodsnameError");
		$fontObj.html("商品名称不能为空");
		var $divObj = $("#gn");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $second_class = $("#second_class");
	var $first_class = $("#first_class");
	if($second_class.val() == "" ||$first_class == ""){
		var $fontObj = $("#classNameError");
		$fontObj.html("商品类别不能为空");
		var $divObj = $("#className");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $postpriceTxt = $("#post_price");
	if($postpriceTxt.val() == ""){
		var $fontObj = $("#postpriceError");
		$fontObj.html("商品价格不能为空");
		var $divObj = $("#pp");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	var $discountTxt = $("#discount");
	if($discountTxt.val() == ""){
		var $fontObj = $("#discountError");
		$fontObj.html("折扣不能为空");
		var $divObj = $("#dis");
		$divObj.attr("class","form-group has-error");
		return false;
	}else if($discountTxt.val()>1||$discountTxt.val()<0){
		var $fontObj = $("#discountError");
		$fontObj.html("折扣范围有误");
		var $divObj = $("#dis");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	return true;
}
function postpriceError( ){
	var $postpriceTxt = $("#post_price");
	if($postpriceTxt.val() != ""){
		var $fontObj = $("#postpriceError");
		$fontObj.html("");
		var $divObj = $("#pp");
		$divObj.attr("class","form-group");
	}
}
function goodsnameError( ){
	var $goodsnameTxt = $("#goodsname");
	if($goodsnameTxt.val() != ""){
		var $fontObj = $("#usernameError");
		$fontObj.html("");
		var $divObj = $("#gn");
		$divObj.attr("class","form-group");
	}
}
function discountError( ){
	var $discountTxt = $("#discount");
	if($discountTxt.val() != ""){
		var $fontObj = $("#discountError");
		$fontObj.html("");
		var $divObj = $("#dis");
		$divObj.attr("class","form-group");
	}
}
function changeSecondClass(obj){
	var firstClassId = $(obj).val();
	var $second_class = $("#second_class");
	$second_class.empty();
	if(firstClassId == ""){
		$second_class.append("<option value=''>--请先选择大类--</option>");
		return;
	}
	var url = "connectCategory.do";
	var param = {id:firstClassId};
	$.post(url,param,function(secondName){
		for(var i = 0; i < secondName.length; i++){
			$second_class.append("<option value='" + secondName[i].id + "'>" + secondName[i].kind + "</option>")
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
                    <h1 class="page-header">添加商品</h1>
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
                                    <form role="form" action="addGoods.do" method="post" enctype="multipart/form-data" onsubmit="return test();">
                                        <div id="gn" class="form-group">
                                             <label for="disabledSelect">名称</label>
                                                <input class="form-control" id="goods_name" name="goods_name" type="text" value="${goods_name}" onkeyup="goodsnameError();">
                                                <p class="help-block" id="goodsnameError"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>大类</label>
                                            <select class="form-control" name="first_class" onchange="changeSecondClass(this);">
                                            	<option value="">--请选择大类--</option>
                                            	<c:forEach items="${firstName}" var="fn">
                                            		<option value="${fn.id}">${fn.kind}</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                        <div id="className" class="form-group">
                                            <label>小类</label>
                                            <select class="form-control" name="second_class" id="second_class">
                                            	<option value="">--请先选择大类--</option>
                                            </select>
                                             <p class="help-block" id="classNameError"></p>
                                        </div>
                                        <div id="pp" class="form-group">
                                             <label for="disabledSelect">单价（元）</label>
                                                <input class="form-control" id="post_price" name="post_price" type="text" value="${post_price}" onkeyup="postpriceError();">
                                                <p class="help-block" id="postpriceError"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>单位</label>
                                            <select class="form-control" name="piece">
                                            	<c:forEach items="${piece}" var="p">
                                                	<option value="${p.id}">${p.piece_name}</option>
                                            	</c:forEach>
                                            </select>
                                        </div>
                                        <div id="dis" class="form-group">
                                            <label for="disabledSelect">折扣</label>
                                            <input class="form-control" id="discount" name="discount" type="text" value="${discount}" placeholder="只能填入0-1之间的小数"/>
                                        	<p class="help-block" id="discountError"></p>
                                        </div>
                                        <div class="form-group">
	                                    <label>照片</label>
	                                    <input type="file" name="photo" onchange="preview(this,'preview','imghead',150,200)" src="upload/${photo}">
		                                </div>
	                                    <div class="form-group" id= "preview">
											<img id="imghead" width="200" height="200"/>
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
