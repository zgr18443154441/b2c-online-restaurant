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
	var $top = $("#top");
	if($top.val()==""||$top.val()<0){
		var $fontObj = $("topError");
		$fontObj.html("推荐语不能为空");
		var $divObj = $("#to");
		$divObj.attr("class","form-group has-error");
		return false;
	}
	return true;
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
function goods(obj){
	var $goods = $(obj);
	var goods_id = $goods.val();
	var list_id = $goods.parent().prev().val();
	var param = {goods_id:goods_id,list_id:list_id};
	var url = "changeIntroduce.do";
	$.post(url,param);
}
function description(obj){
	var $description = $(obj);
	var description = $description.val();
	var list_id = $description.parent().prev().prev().val();
	var param = {description:description,list_id:list_id};
	var url = "changeDescription.do";
	$.post(url,param);
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
                    <h1 class="page-header">添加货物</h1>
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
                                    <form role="form" action="uploadIntroduce.do" method="post" onsubmit="return test();">
                                        <c:forEach items="${goods_list}" var="gl">
                                        	<input type="hidden" id="id" value="${gl.id}">
                                        	<div class="form-group">
	                                            <label>推荐商品${gl.id}</label>
	                                            <select class="form-control" onchange="goods(this);">
	                                            	<c:forEach items="${goods_ld}" var="gd">
	                                            		<option value="${gd.id}" <c:if test="${gd.id==gl.goods_id}">selected="selected"</c:if>>${gd.id}（${gd.goods_name}）</option>
	                                            	</c:forEach>
	                                            </select>
	                                        </div>
	                                        <div id="to" class="form-group">
	                                        	<label for="disabledSelect">推荐语</label>
	                                           	<textarea rows="3" cols="30" class="form-control" id="top" onkeyup="topError()" onblur="description(this);">${gl.description}</textarea>
	                                          	<p class="help-block" id="topError"></p>
	                                        </div>
	                                        <br><br>
                                        </c:forEach>
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
