<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<div id="header"
	class="header navbar navbar-default navbar-fixed-top navbar-inverse">
	<!-- begin container-fluid -->
	<div class="container-fluid">
		<!-- begin mobile sidebar expand / collapse button -->
		<div class="navbar-header">
			<a href="index" class="navbar-brand"><span
				class="navbar-logo"></span>4G千里眼运营管理</a>
			<button type="button" class="navbar-toggle"
				data-click="sidebar-toggled">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<!-- end mobile sidebar expand / collapse button -->

		<!-- begin header navigation right -->
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form class="navbar-form full-width">
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="请输入关键字">
						<button type="submit" class="btn btn-search">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</form>
			</li>
			<li class="dropdown navbar-user"><a href="javascript:;"
				class="dropdown-toggle" data-toggle="dropdown"> <img
					src="assets/img/user-12.jpg" alt=""> <span class="hidden-xs">${loginUser.userName }</span>
					<b class="caret"></b>
			</a>
				<ul class="dropdown-menu animated fadeInLeft">
					<li class="arrow"></li>
					<li><a href="javascript:;">修改资料</a></li>
					<li class="divider"></li>
					<li><a href="javascript:;">设置</a></li>
					<li class="divider"></li>
					<li><a href="logout">退出</a></li>
				</ul></li>
		</ul>
		<!-- end header navigation right -->
	</div>
	<!-- end container-fluid -->
</div>