<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="mobileHeadTag.jsp"></jsp:include>
		<script type="text/javascript">
		</script>
	</head>

	<body>
		<!-- Start of first page -->
		<div data-role="page" id="menu" data-theme="a">
			<div data-role="header">
				<h1>系统提示</h1>
			</div>
			<!-- /header -->
			<div data-role="content">
				${message }
				<a href="<%=basePath %>app/login">返回到登录页面</a>
			</div>
			<!-- /content -->
			<!-- /footer -->
		</div>
		<!-- /page -->
	</body>

</html>