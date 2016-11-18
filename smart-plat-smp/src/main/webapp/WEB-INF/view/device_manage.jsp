<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh">
<!--<![endif]-->
<head>
<jsp:include page="../../inc/headTag.jsp"></jsp:include>
<base href="<%=basePath%>">
<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
<link href="assets/plugins/DataTables/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/plugins/DataTables/css/responsive.bootstrap.min.css"
	rel="stylesheet" />
<!-- ================== END PAGE LEVEL STYLE ================== -->
</head>
<body class="pace-done">
	<!-- <div class="pace  pace-inactive">
		<div class="pace-progress" data-progress-text="100%"
			data-progress="99" style="width: 100%;">
			<div class="pace-progress-inner"></div>
		</div>
		<div class="pace-activity"></div>
	</div> -->
	<!-- begin #page-loader -->
	<div id="page-loader" class="fade in">
		<span class="spinner"></span>
	</div>
	<!-- end #page-loader -->

	<!-- begin #page-container -->
	<div id="page-container"
		class="fade page-sidebar-fixed page-header-fixed in gradient-enabled">
		<!-- begin #header -->
		<jsp:include page="head.jsp"></jsp:include>
		<!-- end #header -->

		<jsp:include page="menu.jsp"></jsp:include>

		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">菜单导航</a></li>
				<li><a href="javascript:;">设备管理</a></li>
				<li class="active">设备注册管理</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				设备管理 <small>设备注册</small>
			</h1>
			<!-- end page-header -->
			<!-- begin row -->
			<div class="row">
				<!-- begin col-12 -->
				<div class="col-md-12 ui-sortable">
					<!-- begin panel -->
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<div class="panel-heading-btn">
								<a href="javascript:;"
									class="btn btn-xs btn-icon btn-circle btn-default"
									data-click="panel-expand"><i class="fa fa-expand"></i></a> <a
									href="javascript:;"
									class="btn btn-xs btn-icon btn-circle btn-success"
									data-click="panel-reload"><i class="fa fa-repeat"></i></a> <a
									href="javascript:;"
									class="btn btn-xs btn-icon btn-circle btn-warning"
									data-click="panel-collapse"><i class="fa fa-minus"></i></a>
							</div>
							<h4 class="panel-title">设备列表</h4>
						</div>
						<div class="panel-body">
							<div id="data-table_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">

								<div class="row">
									<div class="col-sm-12">
										<table id="data-table"
											class="table table-hover table-bordered dataTable no-footer dtr-inline"
											role="grid" aria-describedby="data-table_info">
											<thead>
												<tr role="row">
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="编号: activate to sort column descending">编号</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="学校: activate to sort column descending">学校</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="设备名: activate to sort column ascending">设备名</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="设备类型: activate to sort column ascending">设备类型</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="状态: activate to sort column ascending">状态</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="语言环境: activate to sort column ascending">语言环境</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="操作系统: activate to sort column ascending">操作系统</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="IP地址: activate to sort column ascending">IP地址</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="MAC地址: activate to sort column ascending">MAC地址</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="软件版本: activate to sort column ascending">软件版本</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="创建时间: activate to sort column ascending">创建时间</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="更新时间: activate to sort column ascending">更新时间</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- end panel -->
				</div>
				<!-- end col-12 -->
			</div>
			<!-- end row -->
		</div>
		<!-- end #content -->
		
		<!-- begin #footer -->
		<jsp:include page="foot.jsp"></jsp:include>
		<!-- end #footer -->
		
		<!-- begin #theme -->
		<jsp:include page="theme.jsp"></jsp:include>
		<!-- end #theme -->
	</div>
	<!-- end page container -->
	
	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="assets/plugins/pace/pace.min.js"></script>
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
			TableManageDefault.init();
		});

		function retrieveData(sSource, aoData, fnCallback) {
			$.ajax({
				url : sSource,//这个就是请求地址对应sAjaxSource
				data : {
					"aoData" : JSON.stringify(aoData)
				},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
				type : 'POST',
				dataType : 'json',
				async : false,
				success : function(result) {
					fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
				},
				error : function(msg) {
					if (-1 != msg.responseText
							.indexOf("window.parent.location.href")) {
						alert("访问超时，请重新登录");
						window.location.href="<%=basePath%>login";
					}
				}
			});
		}

		var handleDataTableDefault = function() {
			"use strict";
			if ($("#data-table").length !== 0) {
				$("#data-table")
						.DataTable(
								{
									"aoColumns" : [ {
										"sName" : "id"
									}, {
										"sName" : "nurName"
									}, {
										"sName" : "deviceName"
									}, {
										"sName" : "deviceType"
									}, {
										"sName" : "status"
									}, {
										"sName" : "userLan"
									}, {
										"sName" : "deviceSys"
									}, {
										"sName" : "ip"
									}, {
										"sName" : "macAddr"
									}, {
										"sName" : "softVersion"
									}, {
										"sName" : "createDate"
									}, {
										"sName" : "lastDate"
									} ],
									"bProcessing" : true,
									"bServerSide" : true,
									"sAjaxSource" : "getDeviceList.json",
									"fnServerData" : retrieveData,
									"bDeferRender" : true,
									//是否开启状态保存，当选项开启的时候会使用一个cookie保存表格展示的信息的状态，例如分页信息，展示长度，过滤和排序等
									//这样当终端用户重新加载这个页面的时候可以使用以前的设置
									"bStateSave" : true,
									"iCookieDuration" : 60 * 60 * 24,
									"sScrollX" : "100%",
									"oLanguage" : {
										"sProcessing" : "正在加载数据...",
										"sLengthMenu" : "每页显示 _MENU_ 条记录",
										"sZeroRecords" : "没有检索到数据",
										"sEmptyTable" : "表中无数据存在！",
										"sInfo" : "当前显示 _START_ 到 _END_ 条 (共  _MAX_ 条记录)",
										"sInfoEmpty" : "没有检索到数据",
										"sInfoFiltered" : "数据表中共 _MAX_ 条记录",
										"sSearch" : "搜索:",
										"oPaginate" : {
											"sFirst" : "首页",
											"sPrevious" : "上一页",
											"sNext" : "下一页",
											"sLast" : "末页"
										}
									},
									"aoColumnDefs" : [
											{
												"aTargets" : [ 3 ],
												"mRender" : function(data,
														type, full) {
													if (data == "0") {
														return "北京新长远";
													} else if (data == "1") {
														return "广州广告机";
													} else if (data == "2") {
														return "威海北洋";
													} else if (data == "3") {
														return "北京泰德";
													} else if (data == "4") {
														return "中控设备";
													} else {
														return "";
													}
												}
											},
											{
												"aTargets" : [ 4 ],
												"mRender" : function(data,
														type, full) {
													if (data == "0") {
														return "正常";
													} else if (data == "1") {
														return "停用";
													} else {
														return "";
													}
												}
											}],
									"iTabIndex" : 1,
									"sPaginationType" : "full_numbers"
								});
			}
		};
		var TableManageDefault = function() {
			"use strict";
			return {
				init : function() {
					handleDataTableDefault();
				}
			};
		}();
	</script>
	<!-- <script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-53034621-1', 'auto');
		ga('send', 'pageview');
	</script> -->
</body>
</html>