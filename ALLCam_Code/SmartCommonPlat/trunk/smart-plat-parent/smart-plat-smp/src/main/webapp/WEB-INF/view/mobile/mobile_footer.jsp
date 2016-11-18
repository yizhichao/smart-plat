<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<div data-role="footer" data-position="fixed" id="page_footer" style="position:fixed">
	<div data-role="navbar">
		<ul>
			<li><a onclick="showContactList();" data-icon="user" id="footer_contact">联系人</a>
			</li>
			<li><a onclick="showApplicationList();" data-icon="grid" id="footer_application">应用</a>
			</li>
		</ul>
	</div>
</div>
<script type="text/javascript">
var footerFlag = "${footerFlag}";
if (footerFlag == "contact")
{
	$("#footer_contact").addClass("ui-btn-active");
}
else if(footerFlag == "application")
{
	$("#footer_application").addClass("ui-btn-active");
}
</script>