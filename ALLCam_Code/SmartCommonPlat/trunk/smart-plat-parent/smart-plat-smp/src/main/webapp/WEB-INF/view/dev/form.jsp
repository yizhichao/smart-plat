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
				<li><a href="javascript:;">设备树</a></li>
				<li class="active">设备列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				设备管理 <small>设备配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">设备配置情况</h4>
				</div>
				<div class="panel-body">
					<div class="vertical-box">
						<div class="vertical-box-column p-15">
							<div class="panel-body panel-form">
								<form class="form-horizontal form-bordered"
									data-parsley-validate="true" name="demo-form" id="addForm"  method="post">
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="zoneName">区域名称
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input type="hidden" id="zoneId" name="zoneId"
												value="${zoneId}" /> 
												<input class="form-control"
												type="text" id="zoneName" name="zoneName"
												value="${zoneName}" disabled="disabled"
												data-parsley-required="true" />
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="clientName">客户编号
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input type="hidden" id=clientId name="clientId"
												value="${clientId}" /> 
												<input class="form-control" placeholder="客户编号"
												type="text" id="clientName" name="clientName" disabled="disabled"
												value="${clientName}"  data-parsley-required-message="客户编号不可为空" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="devSn">设备SN号
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="devSn"
												name="devSn" placeholder="设备SN号" value="devSn"
												data-parsley-required="true" data-parsley-required-message="设备SN号不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="devId">设备编号
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="devId"
												name="devId" placeholder="设备编号" value="1"
												data-parsley-required="true" data-parsley-required-message="设备编号不可为空"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="devName">主设备名称
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="devName"
												name="devName" placeholder="主设备名称" value="devName"
												data-parsley-required="true" data-parsley-required-message="主设备名称不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left">设备类型* :</label>
										<div class="col-md-4 col-sm-4">
											<select id="devType" name="devType" class="form-control selectpicker" data-size="10"
												data-live-search="true" data-style="btn-success">
												<option value="00" selected>融合设备</option>
												<option value="01">SVS</option>
												<option value="02">HW-千里眼</option>
												<option value="03">HW-全球眼</option>
												<option value="04">海康-7800</option>
												<option value="99">其他</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="loginName">设备登录账号
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="loginName"
												name="loginName" placeholder="设备登录账号" value="loginName"
												data-parsley-required="true" data-parsley-required-message="设备登录账号不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for=passwd>设备登录密码
											* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="passwd"
												name="passwd" placeholder="设备登录密码" value="passwd"
												data-parsley-required="true" data-parsley-required-message="设备登录密码不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="storageVolume">存储容量* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="storageVolume"
												name="storageVolume" placeholder="设备登录密码" value="100"
												data-parsley-required="true" data-parsley-required-message="存储容量不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="accessMode">有线接入方式* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="accessMode"
												name="accessMode" placeholder="有线接入方式" value="100"
												data-parsley-required="true" data-parsley-required-message="有线接入方式不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="deviceModelId">设备型号ID* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="deviceModelId"
												name="deviceModelId" placeholder="设备型号ID" value="100" 
												data-parsley-required="true" data-parsley-required-message="设备型号ID不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="devAccessMode">设备接入方式* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="devAccessMode"
												name="devAccessMode" placeholder="设备接入方式" value="100"
												data-parsley-required="true" data-parsley-required-message="设备接入方式不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="simNum">SIM卡号* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="simNum"
												name="simNum" placeholder="设备接入方式" value="simNum"
												data-parsley-required="true" data-parsley-required-message="SIM卡号不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="wireLessMode">无限网络控制* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="wireLessMode"
												name="wireLessMode" placeholder="无限网络控制"  value="123"
												data-parsley-required="true" data-parsley-required-message="无限网络控制不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="platIp">静态ip地址* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="staticIp"
												name="staticIp" placeholder="静态ip地址" value="platIp"
												data-parsley-required="true" data-parsley-required-message="静态ip地址不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="netMask">掩码* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="netMask"
												name="netMask" placeholder="掩码" value="netMask"
												data-parsley-required="true" data-parsley-required-message="掩码不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="gateWay">网关地址* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="gateWay"
												name="gateWay" placeholder="网关地址" value="gateWay"
												data-parsley-required="true" data-parsley-required-message="网关地址不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="dns">DNS地址* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="dns"
												name="dns" placeholder="DNS地址" value="dns"
												data-parsley-required="true" data-parsley-required-message="dns不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-2 col-sm-2 text-left" for="installLocate">安装位置扫描* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="installLocate"
												name="installLocate" placeholder="安装位置扫描地址" value="installLocate"
												data-parsley-required="true" data-parsley-required-message="安装位置扫描不可为空"/>
										</div>
										<label class="control-label col-md-2 col-sm-2 text-left" for="status">状态* :</label>
										<div class="col-md-4 col-sm-4">
											<input class="form-control" type="text" id="status"
												name="status" placeholder="状态" value="0"
												data-parsley-required="true" data-parsley-required-message="状态不可为空"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-5 col-sm-5"></label>
										<div class="col-md-6 col-sm-6">
											<button type="button" class="btn btn-success m-r-5" id="addDevice"
												>添加设备</button>
										    <button type="button" id="returnPlat" class="btn btn-success m-r-5"
												>返回</button>
										</div>
									</div>
								</form>
							</div>
						<!-- end panel -->
				</div>
		</div>
	</div>
	<!-- end panel -->
	</div>
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
	    $(document).ready(function () {
	        App.init();
	    });

		$("#addDevice").click(function(){
			var aoData = {
				"zoneId" : $("#zoneId").val(),
				"clientId" : $("#clientId").val(),
				"devSn" : $("#devSn").val(),
				"devId" : $("#devId").val(),
				"devName" : $("#devName").val(),
				"devType" : "03",
				"loginName" : $("#loginName").val(),
				"passwd" : $("#passwd").val(),
				"storageVolume" : $("#storageVolume").val(),
				"accessMode" : $("#clientId").val(),
				"deviceModelId" : $("#deviceModelId").val(),
				"devAccessMode" : $("#devAccessMode").val(),
				"simNum" : $("#simNum").val(),
				"wireLessMode" : $("#wireLessMode").val(),
				"staticIp" : $("#staticIp").val(),
				"netMask" : $("#netMask").val(),
				"gateWay" : $("#gateWay").val(),
				"dns" : $("#dns").val(),
				"installLocate" : $("#installLocate").val(),
				"status" : 1
			};
			ajaxPost("addDevice.json", JSON.stringify(aoData), goback);
		});
		
		function goback(){
			response.sendRedirect(<%=basePath%>+"/device");
		}

	    function ajaxPost(sSource, data, fnCallback) {
	        $.ajax({
	            url: sSource,
	            data: data,//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
	            type: 'POST',
	            dataType: "json",
	            headers: {
	                'Accept': 'application/json',
	                'Content-Type': 'application/json'
	            },
	            async: false,
	            success: function (result) {
	                if (result.resultCode == "SUCCESS") {
	                    alert('操作成功');
	                    fnCallback();
	                } else {
	                    alert('操作失败');
	                }
	            },
	            error: function (msg) {
	                alert(msg.responseText);
	            }
	        });
	    }

	  
	    $('#returnPlat').click(function () {
	        window.history.go(-1);
	    });
	</script>
</body>
</html>