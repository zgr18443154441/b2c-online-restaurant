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
<script type="text/javascript" src="plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
function bond(obj){
	$select = $(obj);
	var url = "selOrderGoods.do";
	if($select.val()!=""){
		var param = {goods_id:$select.val()};
		$.post(url,param,function(order_goods){
			$select.parent().next().html(order_goods.real_price);
			$select.parent().next().next().html(order_goods.number+"（" + order_goods.piece_name + "）");
		})
	}else{
		$select.parent().next().html("");
		$select.parent().next().next().html("");
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
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">用户订单表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	用户：${orderList[0].user_name}
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr >
                                            <th><center>订单号</center></th>
                                            <th><center>订单商品</center></th>
                                            <th><center>价格（实际）</center></th>
                                            <th><center>数量</center></th>
                                            <th><center>总价（元）</center></th>
                                            <th><center>下单时间</center></th>
                                            <th><center>送餐地址</center></th>
                                            <th><center>联系电话</center></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orderList}" var="ol">
                                        	<tr class="gradeU" align="center">
                                        	<td style="display: none;" id="list_id">${ol.id}</td>
                                            <td>${ol.code}</td>
                                            <td>
                                            	<select class="form-control" onchange="bond(this);">
                                            		<option value="">--查看商品--</option>
                                            		<c:forEach items="${ol.order_goods}" var="og">
                                            			<option value="${og.goods_id}">${og.goods_name}</option>
                                            		</c:forEach>
                                            	</select>
                                            </td>
                                            <td></td><td></td>
                                            <td>${ol.sum_price}</td>
                                            <td>${ol.deal_time}</td>
                                            <td>${ol.location}</td>
                                            <td>${ol.phone_number}</td>
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
