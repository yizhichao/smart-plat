<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<div id="sidebar" class="sidebar sidebar-grid">
	<!-- begin sidebar scrollbar -->
	<div data-scrollbar="true" data-height="100%">
		<!-- begin sidebar user -->
		<ul class="nav">
			<li class="nav-profile">
				<div class="image">
					<a href="javascript:;"><img src="assets/img/user-12.jpg" alt="" /></a>
				</div>
				<div class="info">
					${loginUser.userName } <small><c:if
							test="${loginUser.userType eq 0 }">管理员</c:if>
						<c:if test="${loginUser.userType eq 1 }">老师</c:if>
						<c:if test="${loginUser.userType eq 3 }">校长</c:if></small>
				</div>
			</li>
		</ul>
		<!-- end sidebar user -->
		<!-- begin sidebar nav -->
		<ul class="nav">
			<li class="nav-header" style="font-size:15px">菜单导航</li>
			<c:forEach items="${menuList }" var="menuInfo">
				<c:if test="${menuInfo.parentMenuId eq 0 }">
					<li class="has-sub" id="menuItem_${menuInfo.menuId }"><c:choose>
							<c:when
								test="${menuInfo.menuTarget == null && menuInfo.menuTarget == '' }">
								<a href="javascript:;"> <b class="caret pull-right"></b> <c:if
										test="${menuInfo.menuIcon != null && menuInfo.menuIcon != '' }">
										<i class="${menuInfo.menuIcon }"></i>
									</c:if> <span>${menuInfo.menuName}</span>
								</a>
							</c:when>
							<c:otherwise>
								<a href="${menuInfo.menuTarget }"> <b
									class="caret pull-right"></b> <c:if
										test="${menuInfo.menuIcon != null && menuInfo.menuIcon != '' }">
										<i class="${menuInfo.menuIcon }"></i>
									</c:if> <span>${menuInfo.menuName}</span>
								</a>
							</c:otherwise>
						</c:choose>
						<ul class="sub-menu">
							<c:forEach items="${menuList }" var="subMenuInfo"
								varStatus="currIndex">
								<c:if
									test="${subMenuInfo.parentMenuId eq menuInfo.menuId && subMenuInfo.parentMenuId ne 0}">
									<li id="subMenuItem_${subMenuInfo.menuId }"><c:choose>
											<c:when
												test="${subMenuInfo.menuTarget == null && subMenuInfo.menuTarget == '' }">
												<a href="javascript:;"><c:if
														test="${subMenuInfo.menuIcon != null && subMenuInfo.menuIcon != '' }">
														<i class="${subMenuInfo.menuIcon }"></i>
													</c:if>${subMenuInfo.menuName}</a>
											</c:when>
											<c:otherwise>
												<a href="${subMenuInfo.menuTarget }"><c:if
														test="${subMenuInfo.menuIcon != null && subMenuInfo.menuIcon != '' }">
														<i class="${subMenuInfo.menuIcon }"></i>
													</c:if>${subMenuInfo.menuName}</a>
											</c:otherwise>
										</c:choose></li>
								</c:if>
							</c:forEach>
						</ul></li>
				</c:if>
			</c:forEach>
			<!-- begin sidebar minify button -->
			<li><a href="javascript:;" class="sidebar-minify-btn"
				data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>
			<!-- end sidebar minify button -->
		</ul>
		<!-- end sidebar nav -->
	</div>
	<!-- end sidebar scrollbar -->
</div>
<div class="sidebar-bg"></div>
<script type="text/javascript">
	$("li[id*='menuItem_']").on('click', function() {
		$.cookie('menuItem', $(this).attr('id'));
	});
	$("li[id*='subMenuItem_']").on('click', function() {
		$.cookie('subMenuItem', $(this).attr('id'));
	});
	var menuItem = "#" + $.cookie('menuItem');
	$(menuItem).addClass("active");
	var subMenuItem = "#" + $.cookie('subMenuItem');
	$(subMenuItem).addClass("active");
</script>