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
<link href="assets/plugins/jstree/jstree.min.css" rel="stylesheet" />
<link
	href="resources/plugin/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"
	rel="stylesheet" />
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
		<jsp:include page="head.jsp"></jsp:include>
		<!-- end #header -->

		<jsp:include page="menu.jsp"></jsp:include>

		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">菜单导航</a></li>
				<li><a href="javascript:;">考勤管理</a></li>
				<li class="active">日考勤记录</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				考勤管理 <small>日考勤记录</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<div class="btn-group pull-right" data-toggle="buttons">
						<label class="btn btn-success btn-sm"> <input type="radio"
							name="options" id="schoolName" /> <i class="fa fa-university"
							id="school"></i>
						</label> <label class="btn btn-primary btn-sm active"> <input
							type="radio" name="options" id="className" checked /> <i
							class="fa fa-group" id="class"></i>
						</label>
					</div>
					<h4 class="panel-title">日考勤记录</h4>
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
							<div class="input-group date" id="datepicker"
								data-date-format="yyyy-mm" data-link-field="month"
								data-link-format="yyyy-mm">
								<input type="text" class="form-control" id="month" readonly
									placeholder="请选择月份" /> <span class="input-group-addon"><i
									class="fa fa-calendar"></i></span>
							</div>
							</br>
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
														aria-label="日期: activate to sort column descending">日期</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="星期: activate to sort column descending">星期</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="学校: activate to sort column descending">学校</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="班级: activate to sort column descending">班级</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="打卡人数: activate to sort column ascending">打卡人数</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="未打卡人数: activate to sort column ascending">未打卡人数</th>
												</tr>
											</thead>
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
		<jsp:include page="foot.jsp"></jsp:include>
		<!-- end #footer -->

		<!-- begin #theme -->
		<jsp:include page="theme.jsp"></jsp:include>
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
	<!-- <script
		src="resources/plugin/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
		charset="UTF-8"></script> -->
	<script
		src="resources/plugin/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		var schoolId = '${userInfo.schoolId}';
		$(document).ready(
				function() {
					App.init();
					var date = new Date();
					var month = (date.getMonth() + 1);
					month = month<10?'0'+month:month;
					$('#month').val(
							date.getFullYear() + "-" + month);
					$.cookie('schoolId', schoolId);
					$.cookie('className', '');
					$.cookie('month', $('#month').val());
					handleJstreeAjax();
					$.fn.datetimepicker.dates['zh-CN'] = {
						days : [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
								"星期六", "星期日" ],
						daysShort : [ "周日", "周一", "周二", "周三", "周四", "周五", "周六",
								"周日" ],
						daysMin : [ "日", "一", "二", "三", "四", "五", "六", "日" ],
						months : [ "1月", "2月", "3月", "4月", "5月", "6月", "7月",
								"8月", "9月", "10月", "11月", "12月" ],
						monthsShort : [ "1月", "2月", "3月", "4月", "5月", "6月",
								"7月", "8月", "9月", "10月", "11月", "12月" ],
						today : "今天",
						suffix : [],
						meridiem : [ "上午", "下午" ]
					};
					$("#datepicker").datetimepicker({
						autoclose : true,
						startView : 3,
						minView : 3,
						language : 'zh-CN',
						initialDate : new Date()
					})
							.on(
									'changeDate',
									function(ev) {
										$.cookie('month', $('#month').val());
										//$("#jstree").jstree('refresh',-1,function(){});
										$("#jstree").jstree().refresh();
										dataTable($.cookie('schoolId'), $
												.cookie('className'), $(
												'#month').val());
									});
					dataTable($.cookie('schoolId'), $
							.cookie('className'), $(
							'#month').val());
				});

		var dataTable = function(schoolId, className, month) {
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
										"sName" : "schoolName"
									}, {
										"sName" : "className"
									}, {
										"sName" : "checkCardOnes"
									}, {
										"sName" : "uncheckCardOnes"
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
												"aTargets" : [ 4 ],
												"mRender" : function(data,
														type, full) {
													if (data.substring(0, data
															.indexOf("_")) != "0") {
														return "<a href=\"javascript:getDayAttendDetail('"
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
													} else
														return "0";
												}
											},
											{
												"aTargets" : [ 5 ],
												"mRender" : function(data,
														type, full) {
													if (data.substring(0, data
															.indexOf("_")) != "0") {
														return "<a href=\"javascript:getDayUnAttendDetail('"
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
													} else
														return "0";
												}
											} ],
									"destroy" : true,
									"bProcessing" : true,
									"bServerSide" : true,
									"sAjaxSource" : "getAttendDayStatistics.json",
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
											"name" : "sMonth",
											"value" : month
										});
									},
									"fnServerData" : retrieveData,
									"bDeferRender" : true,
									"bFilter" : false,
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
			$("#jstree").jstree(
					{
						core : {
							themes : {
								responsive : !1
							},
							check_callback : !0,
							data : {
								/* url : "getAttendDayClasses.json?rnd=" + Math.random(), */
								type : 'POST',
								/* data : {
									month : $.cookie('month')
								}, */
								url : function(e) {
									return "getAttendDayClasses.json?rnd="
											+ Math.random();
								},
								data : function(e) {
									return {
										month : $.cookie('month'),
										schoolId : $.cookie('schoolId'),
										className : $.cookie('className')
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
							"school" : {
								icon : "fa fa-university text-success fa-lg"
							},
							"class" : {
								icon : "fa fa-group text-primary fa-lg"
							}
						},
						plugins : [ "types" ]
					}).bind(
					"select_node.jstree",
					function(e, data) {
						if ("class" == data.node.type) {
							$.cookie('schoolId', data.node.parent);
							$.cookie('className', data.node.text);
							var inner = $("#" + data.node.parent).find(
									"a:first").text();
							$("#school").html(inner);
							$("#class").html(data.node.text);
							dataTable($.cookie('schoolId'), $
									.cookie('className'), $.cookie('month'));
						} else if ("school" == data.node.type) {
							$.cookie('schoolId', data.node.id);
							$.cookie('className', '');
							$("#school").html(data.node.text);
							$("#class").html('');
							dataTable($.cookie('schoolId'), $
									.cookie('className'), $.cookie('month'));
						} else if ("root" == data.node.type) {
							$.cookie('schoolId', schoolId);
							$.cookie('className', '');
							$("#school").html('');
							$("#class").html('');
							dataTable($.cookie('schoolId'), $
									.cookie('className'), $.cookie('month'));
						}
					});
		};

		function getDayAttendDetail(param) {
			$.cookie('date', param.substring(0, param.indexOf("--")));
			$.cookie('schoolId',param.substring(param.indexOf("_")+1));
			var index = layer.open({
				type : 2,
				shade : 0.5,
				title : param.substring(0,param.indexOf("_")) + '--已打卡',
				shadeClose : true,
				maxmin : false,
				close : function(index) {
				},
				content : '${basePath }attend_day_detail',
				scrollbar : false
			//锁定浏览器滚动条
			});
			layer.full(index);
		}

		function getDayUnAttendDetail(param) {
			$.cookie('date', param.substring(0, param.indexOf("--")));
			$.cookie('schoolId',param.substring(param.indexOf("_")+1));
			var index = layer.open({
				type : 2,
				shade : 0.5,
				title : param.substring(0,param.indexOf("_")) + '--未打卡',
				shadeClose : true,
				maxmin : false,
				close : function(index) {
				},
				content : '${basePath }unattend_day_detail',
				scrollbar : false
			//锁定浏览器滚动条
			});
			layer.full(index);
		}
	</script>
</body>
</html>