<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%> 
<div class="navbar-default sidebar" role="navigation">
   <div class="sidebar-nav navbar-collapse">
       <ul class="nav" id="side-menu">
           <li class="sidebar-search">
               <div class="input-group custom-search-form">
                   <input type="text" class="form-control" placeholder="搜索...">
                   <span class="input-group-btn">
                       <button class="btn btn-default" type="button">
                           <i class="fa fa-search"></i>
                       </button>
                   </span>
               </div>
               <!-- /input-group -->
           </li>
           <li>
               <a href="index/frame.jsp"><i class="fa fa-rotate-left fa-fw"></i> 返回主页</a>
           </li>
           <li>
               <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 数据统计<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
                   <li>
                       <a href="selHotGoods.do">热销榜</a>
                   </li>
                   <li>
                       <a href="selOldCustomer.do">老主顾</a>
                   </li>
               </ul>
               <!-- /.nav-second-level -->
           </li>
           <li>
               <a href="introduceGoods.do"><i class="fa fa-thumbs-o-up  fa-fw"></i> 推荐商品</a>
           </li>
           <li>
               <a href="selActivity.do"><i class="fa fa-calendar  fa-fw"></i> 活动信息</a>
           </li>
           <li>
               <a href="activity/activityAdd.jsp"><i class="fa fa-edit fa-fw"></i> 添加活动</a>
           </li>
           <li>
               <a href="#"><i class="fa fa-cubes fa-fw"></i> 商品信息<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
					<c:forEach items="${sessionScope.goodsCategory}" var="gc">
						<li>
                       		<a href="selGoods.do?id=${gc.id}">${gc.kind}</a>
                   		</li>
					</c:forEach>
               </ul>
               <!-- /.nav-second-level -->
           </li>
           <li>
               <a href="addGoods.do"><i class="fa fa-download fa-fw"></i> 添加商品</a>
           </li>
           <li>
               <a href="#"><i class="fa fa-truck fa-fw"></i> 库存信息<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
                   <c:forEach items="${sessionScope.stockCategory}" var="sc">
						<li>
                       		<a href="selStock.do?id=${sc.id}">${sc.kind}</a>
                   		</li>
					</c:forEach>
               </ul>
           </li>
            <li>
               <a href="addStock.do"><i class="fa fa-download fa-fw"></i> 库存进货</a>
           </li>
           <li>
               <a href="#"><i class="fa fa-group fa-fw"></i> 人员管理<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
                   <li>
                       <a href="showEmployee.do">员工信息</a>
                   </li>
                   <li>
                       <a href="showCustomer.do">用户信息</a>
                   </li>
               </ul>
               <!-- /.nav-second-level -->
           </li>
           <li>
               <a href="addEmployee.do"><i class="fa fa-user fa-fw"></i> 添加员工</a>
           </li>
           <li>
               <a href="selRestaurant.do"><i class="fa fa-building-o fa-fw"></i> 实体店信息</a>
           </li>
           <li>
               <a href="addRestaurant.do"><i class="fa fa-sitemap fa-fw"></i> 新店加盟</a>
           </li>
           <li>
               <a href="selEmail.do"><i class="fa fa-envelope-o fa-fw"></i> 客服邮箱</a>
           </li>
       </ul>
   </div>
   <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->