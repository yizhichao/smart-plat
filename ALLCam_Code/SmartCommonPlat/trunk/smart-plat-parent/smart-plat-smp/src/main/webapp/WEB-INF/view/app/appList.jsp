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
				<li class="active">应用列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				应用管理 <small>应用配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">应用配置情况</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">

						<div class="vertical-box-column p-15">
			
						<div class="row">
						<button type="button" id="allocateDev" class="btn btn-success m-r-5">审核应用</button>
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
														aria-label="审核状态: activate to sort column descending">审核状态</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="应用名称: activate to sort column descending">应用名称</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="应用类型: activate to sort column descending">应用类型</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="开发者: activate to sort column descending">开发者</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="展示地址: activate to sort column ascending">展示地址</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="创建时间: activate to sort column ascending">创建时间</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="最后修改时间: activate to sort column ascending">最后修改时间</th>

												</tr>
											</thead>
											<tbody>
											<tr><td><input type="checkbox" name="id[]"></td><td>审核通过</td><td>宝宝在线</td><td>教育</td><td>奥看</td><td>http://112.4.17.123:8010/AG/download/index.html</td><td>2016-01-05 09:23:01</td><td>2016-08-09 15:51:38</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>审核通过</td><td>蓝天卫士</td><td>环境</td><td>奥看</td><td>http://112.4.17.123:8003/AG/download/index.html</td><td>2016-01-02 10:11:23</td><td>2016-08-09 19:31:02</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>审核通过</td><td>手机看家·店</td><td>安全</td><td>奥看</td><td>http://112.4.17.123:8003/APP_upgrade/download/shop.html</td><td>2016-01-04 10:21:45</td><td>2016-08-10 18:27:21</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>审核通过</td><td>平安商铺</td><td>安全</td><td>奥看</td><td>http://app.isafe365.cn:8000/AG/download/home.html</td><td>2016-01-19 10:51:38</td><td>2016-08-10 21:17:21</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>未审核</td><td>环保局</td><td>安全</td><td>奥看</td><td></td><td>2016-02-08 10:51:20</td><td>2016-08-09 21:10:11</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>未审核</td><td>车联网</td><td>交通</td><td>奥看</td><td></td><td>2016-03-02 09:21:21</td><td>2016-08-10 22:31:31</td></tr>
											<tr><td><input type="checkbox" name="id[]"></td><td>未审核</td><td>南京旅游局 </td><td>旅遊</td><td>奥看</td><td></td><td>2016-03-10 10:30:13</td><td>2016-08-10 21:15:27</td></tr>
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
		
		$("#selectAll").click(function(){
		   	 if($("#selectAll").attr('checked')=="checked"){
		   	 	$("input[name='id[]']").attr('checked', true);
		   	 }else{
		   	 	$("input[name='id[]']").attr('checked', false);
		   	 }
	   });
	
		
	</script>
</body>
</html>