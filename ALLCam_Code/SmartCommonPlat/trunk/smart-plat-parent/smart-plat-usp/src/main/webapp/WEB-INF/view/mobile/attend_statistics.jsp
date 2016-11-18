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
	</head>

	<body>
		<!-- Start of first page -->
		<div data-role="page" id="menu" data-theme="a" data-dom-cache="true">
			<div data-role="header" style="position: fixed;top: 0; width: 100%; z-index: 999;">
    			<h1>应用</h1>  
			</div>
			<!-- /header -->
			<div data-role="content" style="margin-top:30px;">&nbsp;
				此功能正在建设中...
			</div>
			<!-- /content -->
			<jsp:include page="mobile_footer.jsp"></jsp:include>
		</div>
		<!-- /page -->
	</body>
</html>