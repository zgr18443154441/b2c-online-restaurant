<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<script type="text/javascript" src="plugins/jQuery/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(function(){
	var url = "selFirstClass.do";
	$menu1 = $("#menu1");
	$menu2 = $("#menu2");
	$.post(url,function(firstClass){
		for(var i = 0; i<firstClass.length; i++){
			if(i%2==0){
				$menu1.append("<a href='selSecondMenu.do?id=" + firstClass[i].id + "'>" + firstClass[i].kind + "</a>");
			}else{
				$menu2.append("<a href='selSecondMenu.do?id=" + firstClass[i].id + "'>" + firstClass[i].kind + "</a>");
			}
		}
	})
})
function direct(id){
	window.location.href = "selMenu.do";
}
</script>  
<div class="js-sticky">
	<div class="fh5co-main-nav">
		<div class="container-fluid">
			<div id="menu1" class="fh5co-menu-1"></div>
			<div class="fh5co-logo">
				<a href="javascript:void(0);" onclick="direct();">foodee</a>
			</div>
			<div id="menu2" class="fh5co-menu-2"></div>
		</div>
	</div>
</div>