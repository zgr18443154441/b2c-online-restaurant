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
function sel(id,kind){
	$("#secondClass").empty();
	$("#secondName").html(kind+"&nbsp;&nbsp;<input type='hidden' value='" + id + "' id='firstId'><input  placeholder='类名' type='text' id='secondadd'> <button type='button' class='btn btn-outline btn-info btn-xs' onclick='secondadd();'>添加</button>");
	var url = "selSecondClass.do";
	var param = {id:id};
	$.post(url,param,function(secondClass){
		for(var i = 0; i<secondClass.length; i++){
			$("#secondClass").append("<tr align='center'><td>" + secondClass[i].id + "</td><td>" + secondClass[i].kind + "</td><td>" + secondClass[i].number + "</td></tr>");
		}
		$("tr:odd").attr("class","info");
	})
}
function firstadd(){
	var firstname = $("#firstadd").val();
	var url = "addFirstClass.do";
	var param = {firstname:firstname};
	$.post(url,param,function(classId){
		$("#firstClass").append("<tr align='center'><td>" + classId + "</td><td>" + firstname + "</td><td>0</td><td id='number'>0</td><td><button class='btn btn-outline btn-xs' onclick='sel(${fc.id});'><i class='fa fa-search fa-fw' ></i>查看</button></td></tr>");
	})
}
function secondadd(){
	var secondname = $("#secondadd").val();
	var firstId = $("#firstId").val();
	var url = "addSecondClass.do";
	var param = {secondname:secondname,firstId:firstId};
	$.post(url,param,function(classId){
		$("#secondClass").append("<tr align='center'><td>" + classId + "</td><td>" + secondname + "</td><td>0</td></tr>");
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
                          	商品大类
                          	&nbsp;&nbsp;
                          	<input  placeholder="类名" type="text" id="firstadd">
                          	<button type="button" class="btn btn-outline btn-info btn-xs" onclick="firstadd();">添加</button>
                      </div>
                      <!-- /.panel-heading -->
                      <div class="panel-body">
                          <div class="table-responsive">
                              <table class="table">
                                  <tr>
                                          <th><center>类别ID</center></th>
                                          <th><center>类名</center></th>
                                          <th><center>子类个数</center></th>
                                          <th><center>商品个数</center></th>
                                          <th><center>操作</center></th>
                                  </tr>
                                  <tbody id="firstClass">
                                  	<c:forEach items="${firstClass}" var="fc">
                                      <tr align="center">
                                          <td>${fc.id}</td>
                                          <td>${fc.kind}</td>
                                          <td>${fc.class_number}</td>
                                          <td id="number">${fc.goods_number}</td>
                                          <td>
                                          	<button class="btn btn-outline btn-xs" onclick="sel(${fc.id},'${fc.kind}');">
                                          		<i class="fa fa-search fa-fw" ></i>查看
                                          	</button>
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
              <div class="col-lg-6">
                  <div class="panel panel-default">
                      <div id="secondName" class="panel-heading">
                          	商品小类
                      </div>
                      <!-- /.panel-heading -->
                      <div class="panel-body">
                          <div class="table-responsive">
                              <table class="table">
                                  <thead>
                                      <tr>
                                          <th><center>类别ID</center></th>
                                          <th><center>类名</center></th>
                                          <th><center>商品个数</center></th>
                                      </tr>
                                  </thead>
                                  <tbody id="secondClass"></tbody>
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
		<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
    <!-- /#wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
