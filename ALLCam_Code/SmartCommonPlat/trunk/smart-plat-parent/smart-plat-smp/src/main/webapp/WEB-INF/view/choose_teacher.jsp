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
					<select class="form-control selectpicker" data-size="10"
						id="school" data-live-search="true" data-style="btn-success">
						<c:forEach items="${schoolList }" var="schoolInfo">
							<option value="${schoolInfo.schoolId }">${schoolInfo.schoolName
								}</option>
						</c:forEach>
					</select>
					<table id="data-table" class="table table-hover table-bordered">
						<thead>
							<tr role="row">
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="卡号: activate to sort column descending">卡号</th>
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="持卡人: activate to sort column descending">持卡人</th>
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="学校: activate to sort column ascending">学校</th>
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="手机: activate to sort column ascending">手机</th>
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="工号: activate to sort column ascending">工号</th>
								<th class="sorting" aria-controls="data-table" rowspan="1"
									colspan="1" aria-sort="ascending"
									aria-label="性别: activate to sort column ascending">性别</th>
								<th rowspan="1" colspan="1"><input type="checkbox"
									name="teacherIds" value="" /></th>
							</tr>
						</thead>
					</table>
					<div style="float:right">
						<a
							href="javascript:var index = parent.layer
												.getFrameIndex(window.name);
										parent.layer.close(index);"
							class="btn m-r-5 m-b-5 btn-white">取消</a> <a
							href="javascript:deviceAllocate();"
							class="btn m-r-5 m-b-5 btn-success">确定</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="resources/plugin/layer/layer.js"></script>
	<script src="assets/plugins/jstree/jstree.min.js"></script>
	<script src="resources/plugin/icheck/icheck.js"></script>
	<script src="assets/plugins/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		var toadd = [];
		var toremove = [];
		var original = [];
		$(document).ready(function() {
			App.init();
			handleSelectpicker();
			$(".selectpicker").selectpicker("val", $.cookie('schoolId'));
			dataTable($.cookie('deviceId'), $.cookie('schoolId'));
		});

		var handleSelectpicker = function() {
			$(".selectpicker").selectpicker("render");
		};

		$(".selectpicker").change(function() {
			toadd = [];
			toremove = [];
			original = [];
			//$.cookie('schoolId', $(this).val());
			/* $("#data-table").dataTable().fnClearTable();
			$("#data-table").dataTable().fnDestroy(); */
			dataTable($.cookie('deviceId'), $(this).val());
		});

		function retrieveData(sSource, aoData, fnCallback) {
			$
					.ajax({
						url : sSource,//这个就是请求地址对应sAjaxSource
						data : {
							"aoData" : JSON.stringify(aoData)
						},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
						type : 'POST',
						dataType : 'json',
						async : false,
						success : function(result) {
							original = [];//此处考虑下？？？？？？？

							fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
							$("input[type='checkbox']").iCheck({
								checkboxClass : 'icheckbox_polaris'
							});

							if (!$("input[name='teacherIds']").parent()
									.hasClass("checked")) {
								$("input[name='teacherIds']").parent()
										.addClass("checked");
							}
							if (result.iTotalRecords == 0) {
								$("input[name='teacherIds']").parent()
										.removeClass("checked");
							} else {
								$("input[name='teacherId']").each(
										function() {
											if (!$(this).parent().hasClass(
													"checked")) {
												$("input[name='teacherIds']")
														.parent().removeClass(
																"checked");
												return false;
											}
										});
							}

							$("input[name='teacherIds']").on(
									'ifChecked',
									function() {
										$("input[name='teacherId']").each(
												function() {
													$(this).iCheck('check');
												});
									});

							$("input[name='teacherIds']").on(
									'ifUnchecked',
									function() {
										$("input[name='teacherId']").each(
												function() {
													$(this).iCheck('uncheck');
												});
									});

							$("input[name='teacherId']")
									.on(
											'ifChecked',
											function() {
												var val = $(this).val();
												$("input[value='" + val + "']")
														.iCheck("check");
												if (-1 == jQuery.inArray(val,
														original)
														&& -1 == jQuery
																.inArray(val,
																		toadd)) {
													toadd.push(val);
												} else if (-1 != jQuery
														.inArray(val, toremove)) {
													toremove.splice(jQuery
															.inArray(val,
																	toremove),
															1);
												}

												if (!$(
														"input[name='teacherIds']")
														.parent().hasClass(
																"checked")) {
													$(
															"input[name='teacherIds']")
															.parent().addClass(
																	"checked");
												}
												$("input[name='teacherId']")
														.each(
																function() {
																	if ("checked" != $(
																			this)
																			.attr(
																					"checked")) {
																		if ($(
																				"input[name='teacherIds']")
																				.parent()
																				.hasClass(
																						"checked")) {
																			$(
																					"input[name='teacherIds']")
																					.parent()
																					.removeClass(
																							"checked");
																		}
																		return false;
																	}
																});
											});

							$("input[name='teacherId']").on(
									'ifUnchecked',
									function() {
										var val = $(this).val();
										$("input[value='" + val + "']").iCheck(
												"uncheck");
										if (-1 != jQuery.inArray(val, original)
												&& -1 == jQuery.inArray(val,
														toremove)) {
											toremove.push(val);
										} else if (-1 != jQuery.inArray(val,
												toadd)) {
											toadd.splice(jQuery.inArray(val,
													toadd), 1);
										}
										if ($("input[name='teacherIds']")
												.parent().hasClass("checked")) {
											$("input[name='teacherIds']")
													.parent().removeClass(
															"checked");
										}
									});
						},
						error : function(msg) {
							if (-1 != msg.responseText
									.indexOf("window.parent.location.href")) {
								alert("访问超时，请重新登录");
								parent.window.location.href="<%=basePath%>login";
							}
						}
					});
		}

		var dataTable = function(deviceId, schoolId) {
			"use strict";
			if ($("#data-table").length !== 0) {
				$("#data-table")
						.DataTable(
								{
									"aoColumns" : [ {
										"sName" : "cardId"
									}, {
										"sName" : "user_name"
									}, {
										"sName" : "school_name"
									}, {
										"sName" : "phone"
									}, {
										"sName" : "userCode"
									}, {
										"sName" : "sex"
									} ],
									//"sSearchPlaceholder": "请输入关键字",
									"aoColumnDefs" : [
											{
												"aTargets" : [ 5 ],
												"mRender" : function(data,
														type, full) {
													if (data == "0") {
														return "男";
													} else if (data == "1") {
														return "女";
													} else {
														return "";
													}
												}
											},
											{
												"aTargets" : [ 6 ],
												"mRender" : function(data,
														type, full) {
													if ("_" == data.substring(
															0, 1)) {
														if (-1 == jQuery
																.inArray(
																		data
																				.substring(1),
																		original)) {
															original
																	.push(data
																			.substring(1));
														}
														if (-1 != jQuery
																.inArray(
																		data
																				.substring(1),
																		toremove)) {
															return "<input type=\"checkbox\" name=\"teacherId\" value='"
																	+ data
																			.substring(1)
																	+ "' \"/>";
														} else {
															return "<input type=\"checkbox\" checked name=\"teacherId\" value='"
																	+ data
																			.substring(1)
																	+ "' \"/>";
														}
													} else {
														if (-1 != jQuery
																.inArray(data,
																		toadd)) {
															return "<input type=\"checkbox\" checked name=\"teacherId\" value='"
									+ data
									+ "' \"/>";
														} else {
															return "<input type=\"checkbox\" name=\"teacherId\" value='"
									+ data
									+ "' \"/>";
														}
													}

												}
											} ],
									"destroy" : true,
									"bProcessing" : true,
									"bServerSide" : true,
									"sAjaxSource" : "getSchoolTeacher.json",
									"fnServerParams" : function(aoData) {
										aoData.push({
											"name" : "sSchoolId",
											"value" : schoolId
										});
										aoData.push({
											"name" : "sDeviceId",
											"value" : deviceId
										});
									},
									"fnServerData" : retrieveData,
									"sScrollY" : "360px",
									"bScrollCollapse" : true,
									//responsive: true,
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

		function deviceAllocate() {
			var alertStr = "您确定进行此操作？";
			if(($(".selectpicker").val()!=$.cookie('schoolId')) && $.cookie('schoolId')!='0'){
				alertStr = "重新分配学校会解除原学校用户与 此设备的绑定关系，您确定进行此操作？";
			}
			$
					.confirm({
						backgroundDismiss : false,
						content : '<p style="text-align:center;font-size:18px">'+alertStr+'</span>',//false
						icon : 'fa fa-warning',
						title : '设备分配老师',//false
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
										url : "deviceAllocateTeacher.json",
										data : {
											"toAdd" : toadd.join(","),
											"toRemove" : toremove.join(","),
											"schoolId" : $(".selectpicker").val(),
											"deviceId" : $.cookie('deviceId')
										},
										type : 'POST',
										dataType : 'json',
										async : false,
										success : function(result) {
											if (result.resultCode == "SUCCESS") {
												$.cookie('schoolId', $(".selectpicker").val());
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
																parent
																		.$(
																				"#jstree")
																		.jstree()
																		.refresh();
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
	</script>
</body>
</html>