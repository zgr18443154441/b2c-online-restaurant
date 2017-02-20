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
$(function(){
	$("tr:odd").attr("class","info");
})
function add(){
	var addname = $("#add").val();
	var url = "addStockClass.do";
	var param = {addname:addname};
	$.post(url,param,function(classId){
		$("#stockclass").append("<tr align='center'><td>" + classId + "</td><td>" + addname + "</td><td>0</td><td><i class='fa fa-cog fa-fw'></i>修改<i class='fa fa-trash-o fa-fw'></i>删除</td></tr>");
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
        <div id="page-wrapper">
          <div class="row">
              <div class="col-lg-12">
                  <h1 class="page-header">类别信息</h1>
              </div>
          </div>
          <div class="row">
              <div class="col-lg-6">
                  <div class="panel panel-default">
                      <div class="panel-heading">
                          	&nbsp;&nbsp;
                          	<input  placeholder="类名" type="text" id=add>
                          	<button type="button" class="btn btn-outline btn-info btn-xs" onclick="add();">添加</button>
                      </div>
                      <!-- /.panel-heading -->
                      <div class="panel-body">
                          <div class="table-responsive">
                              <table class="table">
                                  <tr>
                                          <th><center>类别ID</center></th>
                                          <th><center>类名</center></th>
                                          <th><center>库存个数</center></th>
                                          <th><center>操作</center></th>
                                  </tr>
                                  <tbody id="stockclass">
                                  	<c:forEach items="${stock_list}" var="sl">
                                      <tr align="center">
                                          <td>${sl.id}</td>
                                          <td>${sl.kind}</td>
                                          <td>${sl.number}</td>
                                          <td>
                                          	<i class="fa fa-cog fa-fw"></i>修改
                                            <i class="fa fa-trash-o fa-fw"></i>删除
                                          </td>
                                      </tr>
                                  	</c:forEach>
                                  </tbody>
                              </table>
                          </div>
                          <!-- /.table-responsive -->
                      </div>
                      <!-- /.panel-body -->
                  </div>
                  <!-- /.panel -->
              </div>
              <!-- /.col-lg-6 -->
          </div>
          <!-- /.row -->
      </div>
     <!-- /#page-wrapper -->
    </div>
		<script type="text/javascript" src="plugins/imagePreview/imagePreview.js"></script>
    <!-- /#wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
