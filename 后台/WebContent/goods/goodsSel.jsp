<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <h1 class="page-header">商品信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	${firstName}
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr >
                                            <th><center>产品ID</center></th>
                                            <th><center>名称</center></th>
                                            <th><center>类别</center></th>
                                            <th><center>单价（元）</center></th>
                                            <th><center>单位</center></th>
                                            <th><center>折扣</center></th>
                                            <th><center>照片</center></th>
                                            <th><center>操作</center></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${tenGoods}" var="t">
                                        	<tr class="gradeU" align="center">
                                            <td style="vertical-align: middle;">${t.id}</td>
                                            <td style="vertical-align: middle;">${t.goods_name}</td>
                                            <td style="vertical-align: middle;">
                                            	<c:forEach items="${secondName}" var="sn">
                                            		<c:if test="${t.second_id == sn.id}">${sn.kind}</c:if>
                                            	</c:forEach>
                                            </td>
                                            <td style="vertical-align: middle;">${t.post_price}</td>
                                            <td style="vertical-align: middle;">
                                            	<c:forEach items="${piece}" var="pi">
                                            		<c:if test="${t.piece_id == pi.id}">${pi.piece_name}</c:if>
                                            	</c:forEach>
                                            </td>
                                            <td style="vertical-align: middle;">${t.discount}</td>
                                            <td>
                                            	<img alt="" width="150" src="upload/${t.photo}">
                                            </td>
                                            <td style="vertical-align: middle;">
                                            <a href="updateGoods.do?id=${t.id}"><i class="fa fa-cog fa-fw"></i>修改</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="deleteGoods.do?id=${t.id}"><i class="fa fa-trash-o fa-fw"></i>删除</a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            <div class="well">
                                <a class="btn btn-default btn-lg btn-block" target="_self" href="selGoodsCategory.do">商品类别管理</a>
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
