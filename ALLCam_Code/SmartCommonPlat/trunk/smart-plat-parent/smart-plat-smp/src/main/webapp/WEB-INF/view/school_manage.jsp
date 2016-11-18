<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String wsPath = "ws://" + request.getServerName() + ":"
					+ request.getServerPort() + path + "/";
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
<link href="assets/plugins/DataTables/css/data-table.css" rel="stylesheet" />
<!-- ================== END PAGE LEVEL STYLE ================== -->
<style>
.content {
	margin-left: 0 !important
}
table.dataTable thead .sorting_asc:after {
    content: "";
}
table.dataTable thead .sorting_desc:after {
    content: "";
}
table.dataTable thead .sorting:after {
    content: "";
}
</style>
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
		<!-- <div id="content" class="content"> -->
		<div id="content" style="margin-left:220px;padding:20px 25px;">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">菜单导航</a></li>
				<li><a href="javascript:;">同步数据管理</a></li>
				<li class="active">同步学校</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				同步数据管理 <small>同步学校</small>
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
							<h4 class="panel-title">学校列表</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
										<table id="data-table"
											class="table table-hover table-bordered table-striped">
											<thead>
												<tr>
													<th>学校名称</th>
													<th>学校地址</th>
													<th>主页</th>
													<th>BPM地址</th>
													<th>BPC地址</th>
												</tr>
											</thead>
										</table>
							</div>
							<a href="javascript:syncSchoolData();" id="syncSchool"
											class="btn btn-success m-r-5"><i class="fa fa-university"></i>
											同步学校</a>
										<div class="progress progress-striped active" hidden
											id="progress">
											<div class="progress-bar progress-bar-success"
												style="width: 0%"></div>
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
	<!-- <script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script> -->
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.fixedHeader.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		var sessionId;
		$(document).ready(function() {
			App.init();
			TableManageDefault.init();
			var webSocket = new WebSocket('<%=wsPath%>websocket');
			webSocket.onerror = function(event) {
				onError(event);
			};

			webSocket.onopen = function(event) {
				onOpen(event);
			};

			webSocket.onmessage = function(event) {
				onMessage(event);
			};

			function onMessage(event) {
				if ((event.data).indexOf("%") != -1) {
					$('.progress-bar').css('width',event.data);
					$('.progress-bar').html(event.data);
				} else {
					sessionId = event.data;
				}
			}

			function onOpen(event) {
			}

			function onError(event) {
			}
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
				var e = $("#data-table")
						.DataTable(
								{
									"aoColumns" : [ {
										"sName" : "SCHOOL_NAME"
									}, {
										"sName" : "SCHOOL_ADDRESS"
									}, {
										"sName" : "SCHOOL_HOME"
									}, {
										"sName" : "BPMSERVERURL"
									}, {
										"sName" : "BPCSERVERURL"
									} ],
									"destroy" : true,
									"bProcessing" : true,
									"bServerSide" : true,
									"sAjaxSource" : "getSchoolList.json",
									"fnServerData" : retrieveData,
									"bDeferRender" : true,
									//是否开启状态保存，当选项开启的时候会使用一个cookie保存表格展示的信息的状态，例如分页信息，展示长度，过滤和排序等
									//这样当终端用户重新加载这个页面的时候可以使用以前的设置
									"bStateSave" : true,
									"iCookieDuration" : 60 * 60 * 24,
									"oLanguage" : {
										"sProcessing" : "",
										//"sProcessing" : "正在加载数据...",
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
									"iTabIndex" : 1,
									"sPaginationType" : "full_numbers"
								});
				new $.fn.dataTable.FixedHeader(e);
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
		
		function syncSchoolData() {
			 $
					.confirm({
						backgroundDismiss : false,
						content : '<p style="text-align:center;font-size:18px">您确定进行此操作？</span>',//false
						icon : 'fa fa-warning',
						title : '同步学校',//false
						autoClose : 'cancel|10000',
						animation : 'Rotate',
						columnClass : 'col-md-6 col-md-offset-3',//col-md-6 col-md-offset-3
						confirmButtonClass : 'btn-info',
						cancelButtonClass : 'btn-danger',
						confirmButton : '确定',//false
						cancelButton : '取消',//false
						theme : 'holodark',//white|black|hololight|holodark|supervan
						closeIcon : null,//false
						confirm : function() {
							$('#syncSchool').hide();
							$('#progress').show();
							$
									.ajax({
										url : "syncSchoolData.json",
										type : 'POST',
										dataType : 'json',
										data:{
											sessionId:sessionId
										},
										async : true,
										success : function(result) {
											handleDataTableDefault();
											if (result.resultCode == "SUCCESS") {
												$
														.confirm({
															backgroundDismiss : false,
															content : false,
															icon : 'fa fa-angellist',
															title : result.resultMessage,
															autoClose : 'confirm|10000',
															animation : 'top',
															columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
															confirmButtonClass : 'btn-info',
															confirmButton : '确定',//false
															cancelButton : false,
															theme : 'black',//white|black|hololight|holodark|supervan
															confirm : function() {
															}
														});
											} else {
												$('.progress-bar').removeClass('progress-bar-success').addClass('progress-bar-danger');
												$
														.confirm({
															backgroundDismiss : false,
															content : false,
															icon : 'fa fa-frown-o',
															title : result.resultMessage,
															autoClose : 'confirm|10000',
															animation : 'top',
															columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
															confirmButtonClass : 'btn-info',
															confirmButton : '确定',//false
															cancelButton : false,
															theme : 'black',//white|black|hololight|holodark|supervan
															confirm : function() {
															}
														});
											}
										},
										error : function(msg) {
											$('.progress-bar').removeClass('progress-bar-success').addClass('progress-bar-danger');
											if (-1 != msg.responseText
													.indexOf("window.parent.location.href")) {
												alert("访问超时，请重新登录");
												window.location.href="<%=basePath%>login";
											} else {
												$
														.confirm({
															backgroundDismiss : false,
															content : false,
															icon : 'fa fa-frown-o',
															title : '请求失败',
															autoClose : 'confirm|10000',
															animation : 'top',
															columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
															confirmButtonClass : 'btn-info',
															confirmButton : '确定',//false
															cancelButton : false,
															theme : 'black',//white|black|hololight|holodark|supervan
															confirm : function() {
															}
														});
											}
										}
									});
						 }
					});
		}
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