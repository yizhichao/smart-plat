<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
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
<jsp:include page="../../../inc/headTag.jsp"></jsp:include>
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
		<jsp:include page="../head.jsp"></jsp:include>
		<!-- end #header -->

		<jsp:include page="../menu.jsp"></jsp:include>

		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">菜单导航</a></li>
				<li><a href="javascript:;">系统管理</a></li>
				<li class="active">系统日志</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				系统管理<small>系统日志</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">系统日志</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">

						<div class="vertical-box-column p-15">
							<div class="form-group" style="text-align: left;">

								<div class="col-md-2 col-sm-2">
									<form id="allocateForm" action="allocate" method="post">

										<button type="button" id="allocateDev"
											class="btn btn-success m-r-5">查看详情</button>
									</form>
								</div>

							</div>
							<div id="data-table_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">
								<div class="row">
									<div class="col-sm-12">
										<table id="data-table"
											class="table table-hover table-bordered dataTable no-footer dtr-inline"
											role="grid" aria-describedby="data-table_info">
											<thead>
												<tr role="row">
													<th><input type="checkbox" id="selectAll"></th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="名称: activate to sort column descending">日志文件</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="类型: activate to sort column descending">日志大小</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="状态: activate to sort column ascending">日志级别</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="创建时间: activate to sort column ascending">创建时间</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="最后修改时间: activate to sort column ascending">最后修改时间</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													<td><input type="checkbox"></td>
													<td>2016_8_1.log</td>
													<td>5.5M</td>
													<td>INFO</td>
													<td>2016-08-01 00:00:00</td>
													<td>2016-08-01 23:59:03</td>
												</tr>
												<tr>
													<td><input type="checkbox"></td>
													<td>2016_8_2.log</td>
													<td>5.4M</td>
													<td>INFO</td>
													<td>2016-08-02 00:00:00</td>
													<td>2016-08-02 23:59:05</td>
												</tr>
												<tr>
												<td><input type="checkbox"></td>
													<td>2016_8_3.log</td>
													<td>5.6M</td>
													<td>INFO</td>
													<td>2016-08-03 00:00:00</td>
													<td>2016-08-03 23:58:44</td>
												</tr>
											</tbody>
										</table>
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
		<jsp:include page="../foot.jsp"></jsp:include>
		<!-- end #footer -->

		<!-- begin #theme -->
		<jsp:include page="../theme.jsp"></jsp:include>
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
		});

		var dataTable = function(clientId) {
			"use strict";
			if ($("#data-table").length !== 0) {
				$("#data-table").DataTable({
					"aoColumns" : [ {
						"Name" : "devId","bSortable": false
					},{
						"sName" : "devName","bSortable": true
					}, {
						"sName" : "devType","bSortable": true
					}, {
						"sName" : "status","bSortable": true
					}, {
						"sName" : "createTime","bSortable": true
					}, {
						"sName" : "updateTime","bSortable": true
					}],
					"aoColumnDefs" : [{
											"aTargets" : [0],
											"mRender" : function(data,
													type, full) {
											return '<input type="checkbox" name="id[]" value="' + full[0] + '">';
											}
										},
										{
											"aTargets" : [ 2 ],
											"mRender" : function(data,
													type, full) {
												if (data == "1") {
													return "DVR";
												} else if (data == "2") {
													return "DVS";
												} else if(data == "3"){
													return "IPC";
												} else if(data == "4"){
													return "解码器";
												} else if (data == "5") {
													return "DVS";
												} else if(data == "6"){
													return "NVR";
												} else if(data == "7"){
													return "手机设备";
												} else if(data=="8"){
													return "家庭网关";
												}
												else {
													return "";
												}													
											}
										},
										{
											"aTargets" : [ 3 ],
											"mRender" : function(data,
													type, full) {
												if (data == "0") {
													return "待开户";
												} else if (data == "1") {
													return "正常";
												} else if(data == "2"){
													return "停用";
												} else if(data == "3"){
													return "删除";
												}
												else {
													return "";
												}													
											}
										}
										],
					"destroy" : true,
					"bProcessing" : true,
					"bAutoWidth": true,//自动宽度
					"bServerSide" : true,
					"sAjaxSource" : "getClientDevList.json",
					"fnServerParams" : function(aoData) {
						aoData.push({
							"name" : "sClientId",
							"value" : clientId
						});
					},
					"bSort":true,
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

	

		$('#addDevice').click(function() {
			var clientId = $("#clientId").val();
			if (clientId == null || clientId == "") {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请选择客户',
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
				return;
			}
			$('#addForm').submit();
		});

		$('#allocateDev').click(function() {
			var clientId = $("#clientId").val();
			if (clientId == null || clientId == "") {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请选择客户',
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
				return;
			}
			$('#allocateForm').submit();
		});

		$("#selectAll").click(function() {
			if ($("#selectAll").attr('checked') == "checked") {
				$("input[name='id[]']").attr('checked', true);
			} else {
				$("input[name='id[]']").attr('checked', false);
			}
		});

		$("#delDevice").click(function() {
			var arr = $("input:checkbox[name='id[]']:checked");
			var data = new Array();
			if (arr.length < 1) {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请选择设备',
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
				return;
			}
			$(arr).each(function() {
				data.push(this.value);
			});
			$.ajax({
				url : "delDevice.json",
				data : {
					"devId" : data.join()
				},
				type : 'POST',
				dataType : "json",
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
						alert('操作成功');
						dataTable($("#clientId").val());
					} else {
						alert('操作失败');
					}
				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});
		});
	</script>
</body>
</html>