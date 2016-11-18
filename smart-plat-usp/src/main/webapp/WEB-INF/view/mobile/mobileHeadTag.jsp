<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no,minimal-ui" />
<meta content="telephone=no" name="format-detection" />
<link href="<%=basePath %>resources/mobile/jquerymobile/jquery.mobile-1.4.5.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>resources/mobile/css/myalert.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>resources/mobile/css/myprogress.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>resources/mobile/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>resources/mobile/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/mobile/js/myalert.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/mobile/js/myprogress.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/mobile/jquerymobile/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="<%=basePath %>resources/mobile/js/mycommon.js"></script>