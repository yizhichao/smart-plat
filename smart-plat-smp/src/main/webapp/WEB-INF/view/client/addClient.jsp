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
<link href="assets/plugins/parsley/src/parsley.css" rel="stylesheet" />
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
				<li><a href="javascript:;">客户树</a></li>
				<li class="active">客户列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				客户管理 <small>客户配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">客户配置情况</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">
						<div class="vertical-box-column p-15">
							<div class="panel-body panel-form">
								<form class="form-horizontal form-bordered"
									data-parsley-validate="true" name="demo-form" id="addForm" action="addPlat" method="post">
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="zoneName">区域名称
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input type="hidden" id="zoneId" name="zoneId"
												value="${zoneId}" /> <input class="form-control"
												type="text" id="zoneName" name="zoneName"
												value="${zoneName}" disabled="disabled"
												data-parsley-required="true" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="platName">客户名称
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" id="platName"
												name="platName" placeholder="名称"
												data-parsley-required="true" data-parsley-required-message="客户名称不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4">客户类型* :</label>
										<div class="col-md-6 col-sm-6">
											<select id="platType" name="platType"
												class="form-control selectpicker" data-size="10"
												data-live-search="true" data-style="btn-success">
												<option value="1" selected>企业</option>
												<option value="2">政府</option>
												<option value="3">政企</option>
												<option value="4">个人</option>
												<option value="5">其他</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="platIp">邮政编码
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" id="platIp"
												name="platIp" placeholder="正常"
												data-parsley-required="true" data-parsley-required-message="邮政编码不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="platPort">客户地址*
											:</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control"  id="platPort"
												name="platPort" placeholder="客户地址" data-parsley-required="true" data-parsley-required-message="客户地址不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"
											for="platVersion">联系Email* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" id="platVersion"
												name="platVersion"
												placeholder="联系Email" data-parsley-required="true" data-parsley-required-message="联系Email不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"
											for="platVersion">联系电话* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" id="platVersion"
												name="platVersion"
												placeholder="联系电话" data-parsley-required="true" data-parsley-required-message="联系电话不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"
											for="platVersion">传真号码* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" id="platVersion"
												name="platVersion"
												placeholder="传真号码" data-parsley-required="true" data-parsley-required-message="传真号码不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="remark">备注
											:</label>
										<div class="col-md-6 col-sm-6">
											<textarea class="form-control" id="remark" name="remark"
												rows="4" placeholder="请填写备注"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"></label>
										<div class="col-md-6 col-sm-6">
											<button type="submit" class="btn btn-success m-r-5"
												>添加客户</button>
										    <button type="button" id="returnPlat" class="btn btn-success m-r-5"
												>返回</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- end panel -->
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
	<script src="assets/js/apps.min.js"></script>
	<script src="assets/plugins/parsley/dist/parsley.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
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

		function ajaxPost(sSource, data, fnCallback) {
			$.ajax({
				url : sSource,
				data : data,//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
				type : 'POST',
				dataType : "json",
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
						fnCallback();
						alert('操作成功');
					} else {
						alert('操作失败');
					}
				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});
		}

		function clearInputData() {
			$.cookie('zoneId', '');
			$.cookie('parentId', '');
			$.cookie('zoneName', '');
			$("#zoneName").val('');
			$("#zoneCode").val('');
			$("#remark").val('');
			$("#lastDate").val('');
		}

		function refreshTree() {
			parent.$("#jstree").jstree().refresh();
		}

		function addPlat() {
			var platName = $("#platName").val();
			//if (null == platName) {
			//	alert("客户名称不能为空")
			//	return;
			//}
			var aoData = {
				"platName" : $("#platName").val(),
				"parentId" : $.cookie('platId'),
				"status" : 1,
				"platCode" : $("#platCode").val(),
				"remark" : $("#remark").val()
			};
			ajaxPost("addPlat.json", JSON.stringify(aoData), refreshTree);
		}

		function modPlat() {
			var aoData = {
				"platId" : $.cookie('platId'),
				"platName" : $("#platName").val(),
				"parentId" : $.cookie('parentId'),
				"status" : 1,
				"platCode" : $("#platCode").val(),
				"remark" : $("#remark").val()
			};
			ajaxPost("modplat.json", JSON.stringify(aoData), refreshTree);
		}

		function delplat() {
			var data = {
				"platId" : $.cookie('platId')
			};
			$.ajax({
				url : "delplat.json",
				data : data,
				type : 'POST',
				dataType : "json",
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
						refreshTree();
						alert('操作成功');
					} else {
						alert('操作失败');
					}
				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});
		}

		function getZone() {
			var data = {
				"zoneId" : $.cookie('zoneId')
			};
			$.ajax({
				url : "getZone.json",
				data : data,
				type : 'POST',
				dataType : "json",
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
						//alert('操作成功');
						//alert(result.baseInfo);
						$("#zoneCode").val(result.baseInfo.zoneCode);
						$("#remark").val(result.baseInfo.remark);
						$("#lastDate").val(result.baseInfo.lastDate);
					} else {
						//alert('操作失败');
					}
				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});
		}
		
		$('#returnPlat').click(function(){
			window.history.go(-1);
		});
	</script>
</body>
</html>