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
				<li><a href="javascript:;">区域树</a></li>
				<li class="active">管理员列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				管理员管理 <small>管理员配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">管理员配置情况</h4>
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
							<div class="form-group" style="text-align: left;">
								<!--
								<div class="col-md-2 col-sm-2">
								<form id="addForm" action="<%=basePath%>device/form" method="post">
									<input type="hidden" id="zoneId" name="zoneId" value=""/>
									<input type="hidden" id="zoneName" name="zoneName" value=""/>
									<input type="hidden" id="clientId" name="clientId" value=""/>
									<input type="hidden" id="clientName" name="clientName" value=""/>
									<button type="button" id="addDevice" class="btn btn-success m-r-5">添加管理员</button>
                                </form>
                                </div>
                                -->
								<div class="col-md-2 col-sm-2">
									<form id="allocateForm" action="allocate" method="post">
										<input type="hidden" id="zoneId" name="zoneId" value="" /> <input
											type="hidden" id="zoneName" name="zoneName" value="" /> <input
											type="hidden" id="clientId" name="clientId" value="" /> <input
											type="hidden" id="clientName" name="clientName" value="" />
										<button type="button" id="allocateDev"
											class="btn btn-success m-r-5">添加管理员</button>
									</form>
								</div>
								<div class="col-md-2 col-sm-2">
									<button type="button" id="delDevice"
										class="btn btn-success m-r-5">删除管理员</button>
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
														aria-label="账号: activate to sort column descending">账号</th>
													
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="类型: activate to sort column ascending">类型</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="创建时间: activate to sort column ascending">创建时间</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													<td><input type="checkbox"></td>
													<td>admin</td>
													<td>超级管理员</td>
													<td>2016-08-01 13:51:08</td>
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
			handleJstreeAjax();
		});

		
		handleJstreeAjax = function() {
			$("#jstree").jstree({
				core : {
					themes : {
						responsive : !1
					},
					check_callback : !0,
					data : {
						type : 'POST',
						url : function(e) {
							return "getDevices.json?rnd=" + Math.random();
						},
						data : function(e) {
							return {
								zoneId : $.cookie('zoneId')
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
					"zone" : {
						icon : "fa fa-university text-success fa-lg"
					},
					"client" : {
						icon : "fa fa-male text-success fa-lg"
					}
				},
				plugins : [ "types" ]
			}).bind(
					"select_node.jstree",
					function(e, data) {
						if ("client" == data.node.type) {
							$("#zoneId").val(data.node.parent);
							$("#zoneName").val(
									$("#" + data.node.parent + "_anchor")
											.text());
							$("#clientId").val(data.node.id);
							$("#clientName").val(data.node.text);
							dataTable(data.node.id);
						} else {
							$("#zoneId").val("");
							$("#zoneName").val("");
							$("#clientId").val("");
							$("#clientName").val("");
							//dataTable(data.node.id);
						}
					});
		};

	
	</script>
</body>
</html>