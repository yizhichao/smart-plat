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
				<li class="active">区域列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				区域管理 <small>区域配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">区域配置情况</h4>
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
							<div class="panel-body panel-form">
								<form class="form-horizontal form-bordered"
									data-parsley-validate="true" name="demo-form">
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="zoneName">区域名称
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" id="zoneName"
												name="zoneName" placeholder="名称"
												data-parsley-required="true" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="status">区域状态
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" id="status"
												disabled="disabled" name="status" data-parsley-type="email"
												placeholder="正常" data-parsley-required="true" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="zoneCode">区号
											:</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="url" id="zoneCode"
												name="zoneCode" data-parsley-type="url" placeholder="区号" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="remark">备注
											:</label>
										<div class="col-md-6 col-sm-6">
											<textarea class="form-control" id="remark" name="remark"
												rows="4" data-parsley-range="[20,200]" placeholder="请填写备注"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="lastDate">最后修改时间
											:</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control" type="text" id="lastDate"
												disabled="disabled" name="lastDate"
												data-parsley-type="digits" placeholder="最后修改时间" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"></label>
										<div class="col-md-6 col-sm-6">
											<button type="button" class="btn btn-success m-r-5"
												onclick="addZone();">添加子区域</button>
											<button type="button" class="btn btn-success m-r-5"
												onclick="modZone();">修改当前区域</button>
											<button type="button" class="btn btn-success m-r-5"
												onclick="delZone();">删除当前区域</button>
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
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
			clearInputData();
			handleJstreeAjax();
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
							return "getZones.json?rnd=" + Math.random();
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
					}
				},
				plugins : [ "types" ]
			}).bind("select_node.jstree", function(e, data) {
				if ("zone" == data.node.type) {
					$.cookie('zoneId', data.node.id);
					$.cookie('parentId', data.node.parent);
					$.cookie('zoneName', data.node.text);
					/* $("#data-table").dataTable().fnClearTable();
					$("#data-table").dataTable().fnDestroy();  
					$("#zoneId").val(data.node.id);
					$("#parentId").val(data.node.parentId);*/
					$("#zoneName").val(data.node.text);
					getZone();
				} else {
					clearInputData();
				}
			});
		};

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
						clearInputData();
						$.confirm({
							backgroundDismiss : true,
							content : false,
							icon : 'fa fa-warning',
							title : '操作成功',
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

		function addZone() {
			var zoneName = $("#zoneName").val();
			if (null == zoneName || "" == zoneName) {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '区域名称不能为空',
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
			var aoData = {
				"zoneName" : $("#zoneName").val(),
				"parentId" : $.cookie('zoneId'),
				"status" : 1,
				"zoneCode" : $("#zoneCode").val(),
				"remark" : $("#remark").val()
			};
			ajaxPost("addZone.json", JSON.stringify(aoData), refreshTree);
		}

		function modZone() {
			var zoneName = $("#zoneName").val();
			if (null == zoneName || "" == zoneName) {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请选择区域',
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
			var aoData = {
				"zoneId" : $.cookie('zoneId'),
				"zoneName" : $("#zoneName").val(),
				"parentId" : $.cookie('parentId'),
				"status" : 1,
				"zoneCode" : $("#zoneCode").val(),
				"remark" : $("#remark").val()
			};
			ajaxPost("modZone.json", JSON.stringify(aoData), refreshTree);
		}

		function delZone() {
			var zoneName = $("#zoneName").val();
			if (null == zoneName || "" == zoneName) {
				$.confirm({
					backgroundDismiss : true,
					content : false,
					icon : 'fa fa-warning',
					title : '请选择区域',
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
			var data = {
				"zoneId" : $.cookie('zoneId')
			};
			$.ajax({
				url : "delZone.json",
				data : data,
				type : 'POST',
				dataType : "json",
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
						refreshTree();
						clearInputData();
						$.confirm({
							backgroundDismiss : true,
							content : false,
							icon : 'fa fa-warning',
							title : '操作成功',
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
	</script>
</body>
</html>