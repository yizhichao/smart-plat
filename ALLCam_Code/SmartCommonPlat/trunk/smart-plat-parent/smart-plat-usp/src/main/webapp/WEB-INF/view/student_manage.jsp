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
<!-- ================== END PAGE LEVEL STYLE ================== -->
<style>
.content {
	margin-left: 0 !important
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
				<li class="active">同步学生</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				同步数据管理 <small>同步学生</small>
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
							<h4 class="panel-title">学生列表</h4>
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
														rowspan="1" colspan="1"
														aria-label="卡号: activate to sort column ascending">卡号</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="持卡人: activate to sort column ascending">持卡人</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="学生: activate to sort column ascending">学生</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="学号: activate to sort column ascending">学号</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="英文名: activate to sort column descending">英文名</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="性别: activate to sort column descending">性别</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="学校名称: activate to sort column descending">学校</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="学校地址: activate to sort column descending">年级</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="班级: activate to sort column ascending">班级</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="更新时间: activate to sort column ascending">更新时间</th>
												</tr>
											</thead>
										</table>
										<a href="javascript:syncStudentData();" id="syncStudent"
											class="btn btn-success m-r-5"><i class="fa fa-user"></i>
											同步学生</a>
										<div class="progress progress-striped active" hidden
											id="progress">
											<div class="progress-bar progress-bar-success"
												style="width: 0%"></div>
										</div>
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
				$("#data-table").DataTable({
					"aoColumns" : [ {
						"sName" : "cardId"
					}, {
						"sName" : "userName"
					}, {
						"sName" : "studentName"
					}, {
						"sName" : "studentCode"
					}, {
						"sName" : "studentEnName"
					}, {
						"sName" : "gender"
					}, {
						"sName" : "school_Name"
					}, {
						"sName" : "gradeName"
					}, {
						"sName" : "className"
					}, {
						"sName" : "lastdate"
					} ],
					"aoColumnDefs" : [ {
						"aTargets" : [ 5 ],
						"mRender" : function(data, type, full) {
							if (data == "0") {
								return "男";
							} else if (data == "1") {
								return "女";
							} else {
								return "";
							}
						}
					} ],
					"destroy" : true,
					"bProcessing" : true,
					"bServerSide" : true,
					"sAjaxSource" : "getStudentList.json",
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
		
		function syncStudentData() {
			 $
					.confirm({
						backgroundDismiss : false,
						content : '<p style="text-align:center;font-size:18px">您确定进行此操作？</span>',//false
						icon : 'fa fa-warning',
						title : '同步学生',//false
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
							$('#syncStudent').hide();
							$('#progress').show();
							$
									.ajax({
										url : "syncStudentData.json",
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