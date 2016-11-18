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
				<li><a href="javascript:;">设备组管理</a></li>
				<li class="active">添加设备组</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				设备组管理 <small>添加设备组</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">添加设备租</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">
						<div class="vertical-box-column p-15">
							<div class="panel-body panel-form">
								<form class="form-horizontal form-bordered"
									data-parsley-validate="true" name="demo-form" id="allocateForm"
									method="post">
									
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4" for="groupName">设备组名称
											* :</label>
										<div class="col-md-6 col-sm-6">
											<input type="hidden" id="clientId" name="clientId"
												value="${clientId}" />
												<input class="form-control" type="text" id="groupName"
												name="groupName" placeholder="请填写设备组名称" data-parsley-required="true"
												data-parsley-required-message="设备组名称不可为空" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4">所属组 :</label>
										<div class="col-md-6 col-sm-6">
											<select id="parentId" name="parentId"
												class="form-control selectpicker" data-size="10"
												data-live-search="true" data-style="btn-success">
												<option value="-1" selected>--请选择--</option>
												
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4 col-sm-4"
											for="groupDesc">设备组描述 :</label>
										<div class="col-md-6 col-sm-6">
										
												<input class="form-control" type="text" id="groupDesc"
												name="groupDesc"  />
										</div>
									</div>
								
								</form>
							</div>
						</div>
					</div>
					<!-- dialog begin-->
					<div id="dlg" class="model dialog" style="display: none">
						<div id="jstree" class="jstree jstree-4 jstree-default"
							role="tree" aria-multiselectable="true" tabindex="0"
							aria-activedescendant="demo_root_1" aria-busy="false"></div>
					</div>
					<!-- dialog end-->
					<div class="form-group">
						<label class="control-label col-md-4 col-sm-4"></label>
						<div class="col-md-6 col-sm-6">
							<button id="confirm" type="button" class="btn btn-success m-r-5">添加设备组</button>
							<button type="button" id="returnPlat"
								class="btn btn-success m-r-5">返回</button>
						</div>
					</div>
				</div>
				<!-- end panel -->
			</div>
		</div>
		<!-- end panel -->
		<!-- end #content -->
	</div>
	<!-- begin #footer -->
	<jsp:include page="../foot.jsp"></jsp:include>
	<!-- end #footer -->

	<!-- begin #theme -->
	<jsp:include page="../theme.jsp"></jsp:include>
	<!-- end #theme -->
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

		function initDialog() {
			$("#dlg").dialog({
				left : 400,
				top : 400,
				modal : true,
				autoOpen : false,
				width : 300,
				height : 500,
				resizable : true,
				draggable : true,
				open : function(event, ui) {
					handleJstreeAjax();
					$(".ui-dialog-titlebar", $(this).parent()).hide();
					$(".ui-dialog-buttonpane button").addClass("btn btn-success m-r-5");
				},
				buttons : {
					"确定" : function() {
						var ids = "";
						var name="";
						var nodes = $("#jstree").jstree("get_checked"); 
						$.each(nodes, function(i, n) {
							ids += n + ",";
							name +=$("#" + n).text()+",";
						});
						$("#device").val(name.substring(0,name.length-1));
						$("#deviceId").val(ids.substring(0,ids.length-1));
						$(this).dialog('close');
					},
					"取消" : function() {
						$(this).dialog('close');
					}
				}
			});
		}

		var handleJstreeAjax = function() {
			var platType = $("#platType option:selected").val();
			var url = $("#url").val();
			var userName = $("#loginName").val();
			var passWord = $("#passwd").val();
			$("#jstree").jstree({
				core : {
					themes : {
						responsive : !1
					},
					check_callback : !0,
					data : {
						type : "GET",
						url : function(e) {
							return "getOnlineDevices.json";
						},
						data : function(e) {
							return {
								platType : platType,
								url : url,
								userName : userName,
								passWord : passWord
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
						icon : "fa fa-bookmark text-success fa-lg"
					},
					"device" : {
						icon : "fa fa-desktop text-success fa-lg"
					}
				},
				plugins : [ "checkbox", "types" ]
			}).bind("select_node.jstree", function(e, data) {
					
			});
		};
	
		$("#platType").change(function(){
			var type=$("#platType option:selected").val();
			var obj=$("#url");
			if(type=="02"){
				obj.append("<option value=1>http://112.4.18.90:8340/nvswsu/httpAction</option>");
			}else if(type=="04"){
				obj.append("<option value=1>http://139.129.55.9</option>");
			}else{
			}
		});
		
		
		$("#device").click(function() {
			$("#device").val("");
			initDialog();
			$("#dlg").dialog("open");
		});

		function refreshTree(){
			$("#jstree").jstree().refresh();
		}

		function ajaxPost(sSource, data, fnCallback) {
			$.ajax({
				url : sSource,
				data : data,
				type : 'POST',
				dataType : "json",
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				async : false,
				success : function(result) {
					if (result.resultCode == "SUCCESS") {
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
								window.location.href="<%=basePath%>device";
							}
						});

					} else {
						$.confirm({
							backgroundDismiss : true,
							content : false,
							icon : 'fa fa-warning',
							title : '操作失败',
							autoClose : 'confirm|10000',
							animation : 'top',
							columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
							confirmButtonClass : 'btn-info',
							confirmButton : '确定',//false
							cancelButton : false,
							theme : 'black',//white|black|hololight|holodark|supervan
							confirm : function() {
								window.location.href="<%=basePath%>device";
							}
						});
					}
				},
				error : function(msg) {
					alert(msg.responseText);
				}
			});
		}

		function initTree() {
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
			}).bind();
		}

		$("#confirm").click(function() {
		    var parentId=$("#parentId option:selected").val();
		    if(parentId=="-1"){
		    	parentId="";
		    }
			var aoData = {
				"groupName" : $("#groupName").val(),
				"clientId" : $("#clientId").val(),
				"groupType" : "5",
				"groupDesc" : $("#groupDesc").val(),
				"passwd" : $("#passwd").val(),
				"status" : 1,
				"parentId" : parentId,
			};
			ajaxPost("addDevGroup.json", JSON.stringify(aoData), refreshTree);
		});

		$('#returnPlat').click(function() {
			window.history.go(-1);
		});
	</script>
</body>
</html>