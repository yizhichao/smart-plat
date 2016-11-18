<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<div id="footer" class="footer">&copy; 2016 4G千里眼运营管理系统 - Nanjing
	Allcam All Rights Reserved</div>
<!-- begin scroll to top btn -->
<a href="javascript:;"
	class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade"
	data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
<!-- end scroll to top btn -->