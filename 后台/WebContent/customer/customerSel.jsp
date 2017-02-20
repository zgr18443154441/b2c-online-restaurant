<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shxt.util.MyConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
function define(obj){
	var $define = $(obj);
	var id = $define.parent().prev().prev().prev().prev().prev().prev().prev().prev().html();
	var url = "defineCustomer.do";
	var param = {id:id};
	$.post(url,param);
	$define.html("<i class='fa fa-check-circle fa-fw'></i>恢复使用");
	$define.attr("onclick","recover(this);");
}
function recover(obj){
	var $define = $(obj);
	var id = $define.parent().prev().prev().prev().prev().prev().prev().prev().prev().html();
	var url = "recoverCustomer.do";
	var param = {id:id};
	$.post(url,param);
	$define.html("<i class='fa fa-minus-circle fa-fw'></i>限制使用");
	$define.attr("onclick","define(this);");
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
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">用户信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	总表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr align="center">
                                            <th width="6%"><center>用户ID</center></th>
                                            <th width="6%"><center>用户名</center></th>
                                            <th width="6%"><center>姓名</center></th>
                                            <th width="5%"><center>性别</center></th>
                                            <th><center>生日</center></th>
                                            <th><center>邮箱</center></th>
                                            <th><center>照片</center></th>
                                            <th><center>地址</center></th>
                                            <th width="20%"><center>操作</center></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${allCustomer}" var="a">
                                        	<tr class="gradeU" align="center">
                                            <td style="vertical-align: middle;">${a.id}</td>
                                            <td style="vertical-align: middle;">${a.username}</td>
                                            <td style="vertical-align: middle;">${a.real_name}</td>
                                            <td style="vertical-align: middle;">${a.sex}</td>
                                            <td style="vertical-align: middle;">${a.birthday}</td>
                                            <td style="vertical-align: middle;">${a.email}</td>
                                            <td>
                                            	<img alt="" width="50" src="<%=MyConstant.SHOP_PATH%>${a.photo}">
                                            </td>
                                            <td style="vertical-align: middle;">
                                            	<select class="form-control">
                                            		<c:forEach items="${a.address}" var="aa">
                                            			<option>${aa}</option>
                                            		</c:forEach>
                                            	</select>
                                            </td>
                                            <td style="vertical-align: middle;">
	                                            <a href="selCustomerDealDate.do?id=${a.id}"><i class="fa fa-cog fa-fw"></i>查询交易记录</a>
	                                            <c:if test="${a.state==1}">
	                                            	<a class="define" href="javascript:void(0);" onclick="define(this);"><i class="fa fa-minus-circle  fa-fw"></i>限制使用</a>
	                                            </c:if>
	                                            <c:if test="${a.state==0}">
	                                            	<a class="define" href="javascript:void(0);" onclick="recover(this);"><i class="fa fa-check-circle  fa-fw"></i>恢复使用</a>
	                                            </c:if>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->
    </div>
        <script type="text/javascript" src="<%=path %>plugins/jQuery/jquery.js"></script>
		<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
    <!-- /#wrapper -->

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
