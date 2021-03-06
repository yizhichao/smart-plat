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
					<table id="data-table" class="table table-hover table-bordered">
						<thead>
							<tr role="row">
								<th rowspan="1" colspan="1">日期</th>
								<th rowspan="1" colspan="1">星期</th>
								<th rowspan="1" colspan="1">学生</th>
								<th rowspan="1" colspan="1">学号</th>
								<th rowspan="1" colspan="1">班级</th>
								<th rowspan="1" colspan="1">打卡次数</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="resources/plugin/layer/layer.js"></script>
	<script src="resources/plugin/layer/extend/layer.ext.js"></script>
	<script src="assets/plugins/DataTables/js/jquery.dataTables.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/DataTables/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(
				function() {
					App.init();
					dataTable($.cookie('schoolId'), $.cookie('className'), $
							.cookie('studentCode'), $.cookie('month'));
					/* layer.config({
					    extend: 'extend/layer.ext.js'
					}); */
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
					fnCallback(result);
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

		var dataTable = function(schoolId, className, studentCode, month) {
			"use strict";
			if ($("#data-table").length !== 0) {
				$("#data-table")
						.DataTable(
								{
									"aoColumns" : [ {
										"sName" : "date"
									}, {
										"sName" : "weekday"
									}, {
										"sName" : "studentName"
									}, {
										"sName" : "studentCode"
									}, {
										"sName" : "className"
									}, {
										"sName" : "attendCount"
									} ],
									"aoColumnDefs" : [
											{
												"aTargets" : [ 1 ],
												"mRender" : function(data,
														type, full) {
													if (data == "0") {
														return "星期日";
													} else if (data == "1") {
														return "星期一";
													} else if (data == "2") {
														return "星期二";
													} else if (data == "3") {
														return "星期三";
													} else if (data == "4") {
														return "星期四";
													} else if (data == "5") {
														return "星期五";
													} else if (data == "6") {
														return "星期六";
													} else {
														return "";
													}
												}
											},
											{
												"aTargets" : [ 5 ],
												"mRender" : function(data,
														type, full) {
													return "<a href=\"javascript:showPhotos('"
															+ data
																	.substring(data
																			.indexOf("_") + 1)
															+ "');\">"
															+ data
																	.substring(
																			0,
																			data
																					.indexOf("_"))
															+ "</a>";
												}
											} ],
									"bProcessing" : true,
									"bServerSide" : true,
									"sAjaxSource" : "getAttendMonthDetail.json",
									"fnServerParams" : function(aoData) {
										aoData.push({
											"name" : "sSchoolId",
											"value" : schoolId
										});
										aoData.push({
											"name" : "sClassName",
											"value" : className
										});
										aoData.push({
											"name" : "sStudentCode",
											"value" : studentCode
										});
										aoData.push({
											"name" : "sMonth",
											"value" : month
										});
									},
									"fnServerData" : retrieveData,
									"bDeferRender" : true,
									"sScrollX" : "100%",
									"bFilter" : false,
									"bLengthChange" : false,
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
									"iTabIndex" : 1
								});
			}
		};

		function showPhotos(date) {
			/* $.getJSON('getAttendDailyPhotos.json', {
				date : date,
				schoolId : $.cookie('schoolId'),
				className : $.cookie('className'),
				studentCode : $.cookie('studentCode')
			}, function(json) {
				alert(json);
				var index = layer.photos({
					photos : json
				});
				//layer.full(index);
			}); */

			$.ajax({
				url : 'getAttendDailyPhotos.json',
				type : "GET",
				data : {
					date : date,
					schoolId : $.cookie('schoolId'),
					className : $.cookie('className'),
					studentCode : $.cookie('studentCode')
				},
				dataType : "json",
				success : function(json) {
					var index = layer.photos({
						photos : json
					});
					//layer.full(index);
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
	</script>
</body>
</html>