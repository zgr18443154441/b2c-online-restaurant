<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%> 
<script type="text/javascript" src="plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
function color(){
	var $obj = $("#color");
	var $value = $obj.attr("aria-valuenow");
	var $color = $obj.attr("class");
	if($value<5){
		$color.s
	}
}
</script>
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index/index.jsp">foodee餐饮网络平台  v1.0</a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-messages">
            <c:forEach items="${sessionScope.fourEstimate}" var="fe">
            	<li>
                <a href="#">
                    <div>
                        <strong>${fe.real_name}</strong>
                        <span class="pull-right text-muted">
                            <em>${fe.assess_time}</em>
                        </span>
                    </div><br/>
                    <div>${fe.assessment}</div>
                </a>
            </li>
            <li class="divider"></li>
            </c:forEach>
            <li>
                <a class="text-center" href="selEmail.do">
                    <strong>查看所有评价</strong>
                    <i class="fa fa-angle-right"></i>
                </a>
            </li>
        </ul>
        <!-- /.dropdown-messages -->
    </li>
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" onclick="color();">
            <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-tasks">
            <c:forEach items="${sessionScope.fourStock}" var="fs">
            	<li>
                	<a href="javascript:void(0);">
               		   <div>
	                        <p>
	                            <strong>${fs.name}</strong>
	                            <span class="pull-right text-muted">上限${fs.top} &nbsp; 剩余 ${fs.rest}</span>
	                        </p>
	                        <div class="progress progress-striped active">
	                            <div id="color" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${fs.percent}" aria-valuemin="0" aria-valuemax="100" style="width: ${fs.percent}%">
	                            </div>
	                        </div>
	                   </div>
	                </a>
	            </li>
	            <li class="divider"></li>
            </c:forEach>
            <li>
                <a class="text-center" href="selSeldomStock.do">
                    <strong>查看所有库存提示</strong>
                    <i class="fa fa-angle-right"></i>
                </a>
            </li>
        </ul>
        <!-- /.dropdown-tasks -->
    </li>
    <!-- /.dropdown -->
   
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="#"><i class="fa fa-user fa-fw"></i> 管理员&nbsp;<font color="blue" size = "2">${sessionScope.real_name}</font>&nbsp;正在登陆</a>
            </li>
            <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
            </li>
            <li class="divider"></li>
            <li><a href="loginOut.do"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>
<!-- /.navbar-top-links -->