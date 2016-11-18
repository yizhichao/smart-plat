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
<link href="assets/plugins/jstree/jstree.min.css" rel="stylesheet" />
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
				<li class="active">设备任务配置</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				设备管理 <small>设备任务配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">设备任务详情</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">
						<div
							class="vertical-box-column overflow-auto p-15 bg-white width-250"
							style="border: 1px solid #e7e7eb;">
							<div id="jstree" class="jstree jstree-4 jstree-default"
								role="tree" aria-multiselectable="true" tabindex="0"
								aria-activedescendant="demo_root_1" aria-busy="false"></div>
						</div>
						<div class="vertical-box-column p-15">
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
														aria-label="任务编号: activate to sort column descending">任务编号</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="任务类型: activate to sort column descending">任务类型</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="任务下发时间: activate to sort column ascending">任务下发时间</th>
												</tr>
											</thead>
										</table>
										<a href="javascript:assignTask();"
											class="btn btn-success m-r-5"><i class="fa fa-gears"></i>
											下发任务</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end panel -->
		</div>
		<!-- end #content -->

		<!-- begin #footer -->
		<jsp:include page="foot.jsp"></jsp:include>
		<!-- end #footer -->

		<!-- begin #theme -->
		<jsp:include page="theme.jsp"></jsp:include>
		<!-- end #theme -->
	</div>
	<!-- begin #page-container -->

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="assets/plugins/pace/pace.min.js"></script>
	<script src="assets/plugins/jstree/jstree.min.js"></script>
	<script src="resources/plugin/layer/layer.js"></script>
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
			$.cookie('schoolId','');
			$.cookie('deviceId','');
			$.cookie('deviceName','');
			handleJstreeAjax();
		});

		function assignTask() {
			if ($.cookie('deviceId') == "" || $.cookie('deviceId') == undefined) {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请先选择设备',
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
				layer.open({
					type : 2,
					shade : 0.5,
					skin : 'layui-layer-rim', //加上边框
					title: [$.cookie('deviceName'), 'font-size:18px;font-weight:bold;color:#00acac'],
					shadeClose : true,
					maxmin : true, //开启最大化最小化按钮
					/* iframe : {
						src : 'www.baidu.com'
					}, */
					area: ['500px', '350px'],
					close : function(index) {
					},
					content : '${basePath }choose_task',
					scrollbar: false//锁定浏览器滚动条
				});
			}
		}

		var dataTable = function(deviceId) {
			"use strict";
			if ($("#data-table").length !== 0) {
				$("#data-table").DataTable({
					"aoColumns" : [ {
						"sName" : "taskId"
					}, {
						"sName" : "taskValue"
					}, {
						"sName" : "createDate"
					} ],
					"aoColumnDefs" : [ {
						"aTargets" : [ 1 ],
						"mRender" : function(data, type, full) {
							if (data == "1") {
								return "拉取学生信息";
							} else if (data == "2") {
								return "拉取老师信息";
							}else if (data == "3") {
								return "拉取广告信息";
							}else if (data == "4") {
								return "版本升级信息";
							} else {
								return "";
							}
						}
					} ],
					"destroy" : true,
					"bProcessing" : true,
					"bServerSide" : true,
					"sAjaxSource" : "getDeviceTask.json",
					"fnServerParams" : function(aoData) {
						aoData.push({
							"name" : "sDeviceId",
							"value" : deviceId
						});
					},
					"fnServerData" : retrieveData,
					"bDeferRender" : true,
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

		handleJstreeAjax = function() {
			$("#jstree").jstree(
					{
						core : {
							themes : {
								responsive : !1
							},
							check_callback : !0,
							data : {
								type : 'POST',
								url : function(e) {
									return "getAllocatedDevices.json?rnd="
											+ Math.random();
								},
								data : function(e) {
									return {
										schoolId : $.cookie('schoolId')
									}
								},
								dataType : "json",
								cache : false
							}
						},
						types : {
							"root" : {
								icon : "fa fa-tree text-success fa-lg"
							},
							"school" : {
								icon : "fa fa-university text-success fa-lg"
							},
							"device" : {
								icon : "fa fa-support text-primary fa-lg"
							}
						},
						plugins : [ "types" ]
					}).bind("select_node.jstree", function(e, data) {
				if ("device" == data.node.type) {
					$.cookie('deviceId', data.node.id);
					$.cookie('schoolId', data.node.parent);
					$.cookie('deviceName', data.node.text);
					dataTable($.cookie('deviceId'));
				} else {
					$.cookie('deviceId', '');
					$.cookie('schoolId', '');
					$.cookie('deviceName', '');
					dataTable($.cookie('deviceId'));
				}
			});
		};
	</script>
</body>
</html>