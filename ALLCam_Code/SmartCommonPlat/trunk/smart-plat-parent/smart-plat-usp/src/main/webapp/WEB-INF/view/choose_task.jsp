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
<link href="resources/plugin/icheck/skins/polaris/polaris.css"
	rel="stylesheet" />
<link href="assets/plugins/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet" />
<!-- ================== END PAGE LEVEL STYLE ================== -->
<style>
.content {
	margin-left: 0 !important
}
</style>
</head>
<body style="background-color:white;">
	<!-- begin #page-loader -->
	<div id="page-loader" class="fade in">
		<span class="spinner"></span>
	</div>
	<!-- end #page-loader -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div style="margin-top:10px">
					<select multiple class="form-control" id="taskSelect" >
						<option value="1">拉取学生信息</option>
						<option value="2">拉取老师信息</option>
						<option value="3">拉取广告信息</option>
						<option value="4">版本升级信息</option>
					</select> </br>
					<div style="float:right">
						<a
							href="javascript:var index = parent.layer
												.getFrameIndex(window.name);
										parent.layer.close(index);"
							class="btn m-r-5 m-b-5 btn-white">取消</a> <a
							href="javascript:deviceAssign();"
							class="btn m-r-5 m-b-5 btn-success">确定</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="assets/plugins/jstree/jstree.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
		});

		function deviceAssign() {
			var tasks = $("#taskSelect").val();
			if ('' == tasks || null == tasks) {
				$.confirm({
					backgroundDismiss : false,
					content : false,
					icon : 'fa fa-frown-o',
					title : '请选择任务',
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
				$
						.confirm({
							backgroundDismiss : false,
							content : '<p style="text-align:center;font-size:18px">您确定进行此操作？</span>',//false
							icon : 'fa fa-warning',
							title : '设备分配',//false
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
								$
										.ajax({
											url : "deviceAssign.json",
											data : {
												"tasks" : tasks.join(","),
												"schoolId" : $
														.cookie('schoolId'),
												"deviceId" : $
														.cookie('deviceId')
											},
											type : 'POST',
											dataType : 'json',
											async : false,
											success : function(result) {
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
																	parent.$("#jstree").jstree().refresh();
																	var index = parent.layer
																			.getFrameIndex(window.name);
																	parent.layer
																			.close(index);
																}
															});
												} else {
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
																	var index = parent.layer
																			.getFrameIndex(window.name);
																	parent.layer
																			.close(index);
																}
															});
												}
											},
											error : function(msg) {
												if (-1 != msg.responseText
														.indexOf("window.parent.location.href")) {
													alert("访问超时，请重新登录");
													parent.window.location.href="<%=basePath%>login";
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
																	var index = parent.layer
																			.getFrameIndex(window.name);
																	parent.layer
																			.close(index);
																}
															});
												}
											}
										});
							}
						});
			}

		}
	</script>
</body>
</html>