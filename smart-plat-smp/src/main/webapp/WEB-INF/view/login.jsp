<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="resources/plugin/icheck/skins/futurico/futurico.css"
	rel="stylesheet" />
<style>
label {
	padding-left: 0 !important
}
</style>
</head>
<body>
	<!-- begin #page-loader -->
	<div id="page-loader" class="fade in">
		<span class="spinner"></span>
	</div>
	<!-- end #page-loader -->

	<div class="login-cover">
		<div class="login-cover-image">
			<img src="assets/img/login-bg/bg-1.jpg" data-id="login-cover-image"
				alt="" />
		</div>
		<div class="login-cover-bg"></div>
	</div>
	<!-- begin #page-container -->
	<div id="page-container" class="fade">
		<!-- begin login -->
		<div class="login login-v2" data-pageload-addclass="animated flipInX">
			<!-- begin brand -->
			<div class="login-header">
				<div class="brand">
					<span class="logo"></span>4G千里眼运营管理
				</div>
				<div class="icon">
					<i class="fa fa-sign-in"></i>
				</div>
			</div>
			<!-- end brand -->
			<div class="login-content">
				<!-- <form action="index.html" method="POST" class="margin-bottom-0"> -->
				<div class="form-group m-b-20">
					<input type="text" id="username" class="form-control input-lg"
						placeholder="Username" />
				</div>
				<div class="form-group m-b-20">
					<input type="password" id="password" class="form-control input-lg"
						placeholder="Password" />
				</div>
				<div class="checkbox m-b-20">
					<label> <input type="checkbox" />记住我
					</label>
				</div>
				<div class="login-buttons">
					<button type="submit" class="btn btn-success btn-block btn-lg"
						onclick="javascript:login();">登录</button>
				</div>
				<!-- </form> -->
			</div>
		</div>
		<!-- end login -->

		<ul class="login-bg-list">
			<li class="active"><a href="javascript:void(0);"
				data-click="change-bg"><img src="assets/img/login-bg/bg-1.jpg"
					alt="" /></a></li>
			<%--<li><a href="javascript:void(0);" data-click="change-bg"><img
					src="assets/img/login-bg/bg-2.jpg" alt="" /></a></li>
			<li><a href="javascript:void(0);" data-click="change-bg"><img
					src="assets/img/login-bg/bg-3.jpg" alt="" /></a></li>
			<li><a href="javascript:void(0);" data-click="change-bg"><img
					src="assets/img/login-bg/bg-4.jpg" alt="" /></a></li>
			<li><a href="javascript:void(0);" data-click="change-bg"><img
					src="assets/img/login-bg/bg-5.jpg" alt="" /></a></li>
			<li><a href="javascript:void(0);" data-click="change-bg"><img
					src="assets/img/login-bg/bg-6.jpg" alt="" /></a></li>--%>
		</ul>

	</div>
	<!-- end page container -->

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="resources/plugin/layer/layer.js"></script>
	<script src="resources/plugin/icheck/icheck.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
			Login.init();
			$("input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_futurico'
			});
			$.cookie('menuItem', '');
			$.cookie('subMenuItem', '');
		});

		var handleLoginPageChangeBackground = function() {
			$('[data-click="change-bg"]')
					.live(
							"click",
							function() {
								var e = '[data-id="login-cover-image"]';
								var t = $(this).find("img").attr("src");
								var n = '<img src="' + t + '" data-id="login-cover-image" />';
								$(".login-cover-image").prepend(n);
								$(e).not('[src="' + t + '"]').fadeOut("slow",
										function() {
											$(this).remove();
										});
								$('[data-click="change-bg"]').closest("li")
										.removeClass("active");
								$(this).closest("li").addClass("active");
							});
		};
		var Login = function() {
			"use strict";
			return {
				init : function() {
					handleLoginPageChangeBackground();
				}
			};
		}();
		
		function login() {
			var username = $("#username").val();
			if ($.trim(username) == "") {
				$.confirm({
					backgroundDismiss : false,
					content : false,
					icon : 'fa fa-warning',
					title : '请输入账号',
					autoClose : 'confirm|10000',
					animation : 'scale',
					columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
					confirmButtonClass : 'btn-info',
					confirmButton : '确定',//false
					cancelButton : false,
					theme : 'black'//white|black|hololight|holodark|supervan
				});
				return false;
			}
			else if("admin"==username){
				loginMethod("","");
			}
			else{
				$.ajax({
					type : "POST",
					url : "list_school.json",
					data : {"username" : $.trim(username)},
					dataType : 'json',
					beforeSend : function() {
						return true;
					},
					success : function(a) {
						if (a.resultCode == "SUCCESS") {
							var arr = JSON.parse(a.resultMessage);
							if (arr.length > 1) {
								var content = "<div class='hidden-sm hidden-xs'><ul class='nav nav-pills nav-stacked nav-inbox'>";
								for ( var i = 0; i < arr.length; i++) {
									content = content+"<li><a href=\"javascript:loginMethod('"+arr[i].schoolId+"','"+arr[i].bpcServerUrl+"');\" style =\"font-size:15px;\"><i class='fa fa-star fa-fw m-r-5'></i>"+arr[i].schoolName+"</a></li>";
								}
								content = content+"</ul></div>";
								layer.open({
									type : 1,
									title: '<i class=\'fa fa-hand-o-down fa-fw m-r-5\'></i>请选择学校：',
									skin : 'layer-ext-moon', //样式类名
									area: '300px',
									closeBtn : 0, //不显示关闭按钮
									shift : 0,
									shadeClose : true, //开启遮罩关闭
									content : content
								});
							} else {
								var schoolId = arr[0].schoolId;
								var bpcServerUrl = arr[0].bpcServerUrl;
								loginMethod(schoolId,bpcServerUrl);
							}

						} else {
							$.confirm({
								backgroundDismiss : false,
								content : false,
								icon : 'fa fa-frown-o',
								title : a.resultMessage,
								autoClose : 'confirm|10000',
								animation : 'scale',
								columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
								confirmButtonClass : 'btn-info',
								confirmButton : '确定',//false
								cancelButton : false,
								theme : 'black'//white|black|hololight|holodark|supervan
							});
						}
					},
					error : function(e) {
						alert(e);
						$.confirm({
							backgroundDismiss : false,
							content : false,
							icon : 'fa fa-frown-o',
							title : '请求失败',
							autoClose : 'confirm|10000',
							animation : 'scale',
							columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
							confirmButtonClass : 'btn-info',
							confirmButton : '确定',//false
							cancelButton : false,
							theme : 'black'//white|black|hololight|holodark|supervan
						});
					}
				});
			}
		}
		
		function loginMethod(schoolId,bpcServerUrl){
			var obj = $.confirm({
				backgroundDismiss : false,
				title : '正在登录,请稍候...',
				icon : 'fa fa-spinner fa-spin',
				closeIcon : false,
				content : false,
				animation : 'scaleY',
				columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
				confirmButton : false,
				cancelButton : false,
				theme : 'black'//white|black|hololight|holodark|supervan
			});
			var username = $("#username").val();
			var password = $("#password").val();
			var rememberMe = $("input[type=checkbox]").val();
			if ($.trim(username) == "") {
				obj.close();
				$.confirm({
					backgroundDismiss : false,
					content : false,
					icon : 'fa fa-warning',
					title : '请输入账号',
					autoClose : 'confirm|10000',
					animation : 'scale',
					columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
					confirmButtonClass : 'btn-info',
					confirmButton : '确定',//false
					cancelButton : false,
					theme : 'black'//white|black|hololight|holodark|supervan
				});
				return false;
			}

			if ($.trim(password) == "") {
				obj.close();
				$.confirm({
					backgroundDismiss : false,
					content : false,
					icon : 'fa fa-warning',
					title : '请输入密码',
					autoClose : 'confirm|10000',
					animation : 'scale',
					columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
					confirmButtonClass : 'btn-info',
					confirmButton : '确定',//false
					cancelButton : false,
					theme : 'black'//white|black|hololight|holodark|supervan
				});
				return false;
			}
			
			var b = {
					"username" : $.trim(username),
					"password" : $.trim(password),
					"rememberMe" : $.trim(rememberMe),
					"schoolId" : schoolId,
					"bpcServerUrl" : bpcServerUrl
				};
			$.ajax({
				type : "POST",
				url : "login.json",
				data : b,
				dataType : 'json',
				beforeSend : function() {
					return true;
				},
				success : function(a) {
					if (a.resultCode == "SUCCESS") {
						window.location.href="<%=basePath%>index";
					} else {
						obj.close();
						$.confirm({
							backgroundDismiss : false,
							content : false,
							icon : 'fa fa-frown-o',
							title : a.resultMessage,
							autoClose : 'confirm|10000',
							animation : 'scale',
							columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
							confirmButtonClass : 'btn-info',
							confirmButton : '确定',//false
							cancelButton : false,
							theme : 'black'//white|black|hololight|holodark|supervan
						});
					}
				},
				error : function() {
					obj.close();
					$.confirm({
						backgroundDismiss : false,
						content : false,
						icon : 'fa fa-frown-o',
						title : '请求失败',
						autoClose : 'confirm|10000',
						animation : 'scale',
						columnClass : 'col-md-4 col-md-offset-4',//col-md-6 col-md-offset-3
						confirmButtonClass : 'btn-info',
						confirmButton : '确定',//false
						cancelButton : false,
						theme : 'black'//white|black|hololight|holodark|supervan
					});
				}
			});
		}
	</script>

</body>
</html>
