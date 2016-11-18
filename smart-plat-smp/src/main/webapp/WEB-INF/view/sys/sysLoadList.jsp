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
				<li class="active">系统负载</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				系统管理 <small>系统负载</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">系统负载</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">
						
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
														aria-label="服务方法: activate to sort column descending">服务方法</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="服务名: activate to sort column descending">服务名</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="负载均衡策略: activate to sort column ascending">负载均衡策略</th>
													
												</tr>
											</thead>
											 <tbody>
											 <tr role="row">
													<td>美丽江苏</td>
													<td>夫子庙</td>
													<td>最小并发</td>
													
												</tr>
												 <tr role="row">
													<td>蓝天卫士</td>
													<td>连云港</td>
													<td>轮询</td>
												</tr>
												 <tr role="row">
													<td>美丽江苏</td>
													<td>雨花台</td>
													<td>随机</td>
												</tr>
												 <tr role="row">
													<td>蓝天卫士</td>
													<td>徐州</td>
													<td>最小并发</td>
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
			}).bind("select_node.jstree", function(e, data) {
				if ("client" == data.node.type) {
					$("#zoneId").val(data.node.parent);
					$("#zoneName").val($("#"+data.node.parent+"_anchor").text());
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
		
		$('#addDevice').click(function(){
			var clientId=$("#clientId").val();
			if(clientId == null || clientId == "")
			{
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
		
		
		$('#allocateDev').click(function(){
			var clientId=$("#clientId").val();
			if(clientId == null || clientId == "")
			{
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
		
		 
	   $("#selectAll").click(function(){
		   	 if($("#selectAll").attr('checked')=="checked"){
		   	 	$("input[name='id[]']").attr('checked', true);
		   	 }else{
		   	 	$("input[name='id[]']").attr('checked', false);
		   	 }
	   });
	
	   $("#delDevice").click(function(){
	   		 var arr=$("input:checkbox[name='id[]']:checked");
	   		 var data=new Array();
	   		 if(arr.length<1)
			 {
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
	   		 $(arr).each(function(){
	   		 		data.push(this.value);
	   		 });
	   		 $.ajax({
				url : "delDevice.json",
				data : {
					"devId":data.join()
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