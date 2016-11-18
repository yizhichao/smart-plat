<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/tags.jsp"%>
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
<jsp:include page="../../../inc/headTag.jsp"></jsp:include>
<base href="<%=basePath%>">
<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
<link href="assets/plugins/DataTables/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/plugins/DataTables/css/responsive.bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/plugins/jstree/jstree.min.css" rel="stylesheet" />
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
		<jsp:include page="../head.jsp"></jsp:include>
		<!-- end #header -->

		<jsp:include page="../menu.jsp"></jsp:include>

		<!-- begin #content -->
		<div id="content" class="content">
			<!-- begin breadcrumb -->
			<ol class="breadcrumb pull-right">
				<li><a href="javascript:;">菜单导航</a></li>
				<li><a href="javascript:;">区域树</a></li>
				<li class="active">开放SDK列表</li>
			</ol>
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">
				开放SDK管理 <small>开放SDK配置</small>
			</h1>
			<!-- end page-header -->
			<!-- begin panel -->
			<div class="panel panel-inverse" style="height:100%">
				<div class="panel-heading">
					<h4 class="panel-title">开放SDK配置情况</h4>
				</div>
				<div class="panel-body">
				



<!-- 				<div class="container-fluid"> -->
<!-- 					<div class="row-fluid"> -->
<!-- 						<div class="span3"> -->
<!-- 							<ol> -->
<!-- 								<li><a -->
<!-- 									href="#function" -->
<!-- 									title="功能手册">功能手册</a></li> -->
<!-- 								<li><a -->
<!-- 									href="#sdkapi" -->
<!-- 									title="SDK下载">SDK下载</a></li> -->
<!-- 								<li><a href="#interface" -->
<!-- 									title="接口协议">接口协议</a></li> -->
<!-- 								<li><a href="#play" -->
<!-- 									title="播放器下载">播放器下载</a></li> -->
<!-- 								<li><a href="#apidemo" -->
<!-- 									title="API调用示例">API调用示例</a></li> -->
<!-- 								<li><a href="#faq" -->
<!-- 									title="常见问题FAQ">常见问题FAQ</a></li> -->
<!-- 							</ol> -->
<!-- 						</div> -->

<!--                         <a name="function">测试锚点</a> -->
						<div class="span9">
						
						<div name="function">&nbsp;
														<br>
														<br>
							</div>
							
							
<!-- 							<p> -->
<!-- 							<h3>1.功能手册</h3> -->
<!-- 							1）视频直播 -->
<!-- 							<br/> -->
<!-- 							&nbsp;&nbsp;&nbsp;&nbsp;待补充...... -->
<!-- 							</br>  -->
<!-- 							2）视频点播 -->
<!-- 							<br/> -->
<!-- 							&nbsp;&nbsp;&nbsp;&nbsp;待补充...... -->

<!-- 							</p> -->

<div id="sdkapi">&nbsp;
														<br>
														<br>
							</div>
							
							<p>
							</p><h3>1.SDK下载</h3>
							<a href="./download/sdk/AnyLive_SDK.zip" title="4G千里眼手机视频采集SDK">4G千里眼手机视频采集SDK.zip</a><br>
							<p></p>

							<div id="interface">&nbsp;
														<br>
														<br>
							</div>
							
							<p>
							</p><h3>2.接口协议</h3>
							<a href="./download/doc/developHelper.zip" title="4G千里眼能力开放接口说明书">4G千里眼能力开放接口说明书.zip</a>
							<p></p>


							<div id="play">&nbsp;
														<br>
														<br>
							</div>
							
							<p>
							</p><h3>3.播放器下载</h3>
							<a href="./download/doc/FVPlayer.zip" title="4G千里眼FVPlayer.zip">4G千里眼FVPlayer.zip</a><br> <a href="./download/doc/HLSPlayer.zip" title="4G千里眼HLSPlayer.zip">4G千里眼HLSPlayer.zip</a><br>
							<p></p>


							<div id="apidemo">&nbsp;
														<br>
														<br>
							</div>
							
							<p>
							</p><h3>4.API调用示例</h3>
							<div class="container-fluid">
								<div class="row-fluid">
									<div class="span12">
										<blockquote>
											<p>1）JAVA代码片段：</p>

											<small>String userName = "yizhichao";</small> <small>String
												passWord = "123456"; </small> <small>HttpClient httpClient =
												new HttpClient(); </small> <small>PostMethod method = new
												PostMethod(SERVER_URL);</small> <small> // method.setData </small> <small>
												String requestXml = "&lt;?xml version="1.0"
												encoding="UTF-8"?&gt; <br> &lt;Message&gt;<br>
												&lt;Msghead Version="1.0" Direction="request"
												Msgtype="GET_DEVICE_REALTIME_URL"/&gt;<br>
												&lt;Msgbody&gt;&lt;Realtime
												DeviceID="110ud4dii867fsa0nwag0pnxf41k22rm"
												/&gt;&lt;/Msgbody&gt; &lt;/Message&gt;";
											</small> <small>RequestEntity requestEntity = new
												ByteArrayRequestEntity(requestXml.getBytes("UTF-8"),
												"UTF-8"); method.setRequestEntity(requestEntity);</small> <small>httpClient.executeMethod(method);</small>

											<small> String response =
												method.getResponseBodyAsString();</small> <small>System.out.println(response);</small>

											<small> method.releaseConnection();</small>
										</blockquote>
									</div>
								</div>
							</div>

							<div class="container-fluid">
								<div class="row-fluid">
									<div class="span12">
										<blockquote>
											<p>2）C++代码片段：</p>

											<small>String userName = "yizhichao";</small> <small>String
												passWord = "123456"; </small> <small>HttpClient httpClient =
												new HttpClient(); </small> <small>PostMethod method = new
												PostMethod(SERVER_URL);</small> <small> // method.setData </small> <small>
												String requestXml = "&lt;?xml version="1.0"
												encoding="UTF-8"?&gt; <br> &lt;Message&gt;<br>
												&lt;Msghead Version="1.0" Direction="request"
												Msgtype="GET_DEVICE_REALTIME_URL"/&gt;<br>
												&lt;Msgbody&gt;&lt;Realtime
												DeviceID="110ud4dii867fsa0nwag0pnxf41k22rm"
												/&gt;&lt;/Msgbody&gt; &lt;/Message&gt;";
											</small> <small>RequestEntity requestEntity = new
												ByteArrayRequestEntity(requestXml.getBytes("UTF-8"),
												"UTF-8"); method.setRequestEntity(requestEntity);</small> <small>httpClient.executeMethod(method);</small>

											<small> String response =
												method.getResponseBodyAsString();</small> <small>System.out.println(response);</small>

											<small> method.releaseConnection();</small>
										</blockquote>
									</div>
								</div>
							</div>


							<div class="container-fluid">
								<div class="row-fluid">
									<div class="span12">
										<blockquote>
											<p>3）PHP代码片段：</p>

											<small>String userName = "yizhichao";</small> <small>String
												passWord = "123456"; </small> <small>HttpClient httpClient =
												new HttpClient(); </small> <small>PostMethod method = new
												PostMethod(SERVER_URL);</small> <small> // method.setData </small> <small>
												String requestXml = "&lt;?xml version="1.0"
												encoding="UTF-8"?&gt; <br> &lt;Message&gt;<br>
												&lt;Msghead Version="1.0" Direction="request"
												Msgtype="GET_DEVICE_REALTIME_URL"/&gt;<br>
												&lt;Msgbody&gt;&lt;Realtime
												DeviceID="110ud4dii867fsa0nwag0pnxf41k22rm"
												/&gt;&lt;/Msgbody&gt; &lt;/Message&gt;";
											</small> <small>RequestEntity requestEntity = new
												ByteArrayRequestEntity(requestXml.getBytes("UTF-8"),
												"UTF-8"); method.setRequestEntity(requestEntity);</small> <small>httpClient.executeMethod(method);</small>

											<small> String response =
												method.getResponseBodyAsString();</small> <small>System.out.println(response);</small>

											<small> method.releaseConnection();</small>
										</blockquote>
									</div>
								</div>
							</div>


							<div class="container-fluid">
								<div class="row-fluid">
									<div class="span12">
										<blockquote>
											<p>4）Pythod代码片段：</p>

											<small>String userName = "yizhichao";</small> <small>String
												passWord = "123456"; </small> <small>HttpClient httpClient =
												new HttpClient(); </small> <small>PostMethod method = new
												PostMethod(SERVER_URL);</small> <small> // method.setData </small> <small>
												String requestXml = "&lt;?xml version="1.0"
												encoding="UTF-8"?&gt; <br> &lt;Message&gt;<br>
												&lt;Msghead Version="1.0" Direction="request"
												Msgtype="GET_DEVICE_REALTIME_URL"/&gt;<br>
												&lt;Msgbody&gt;&lt;Realtime
												DeviceID="110ud4dii867fsa0nwag0pnxf41k22rm"
												/&gt;&lt;/Msgbody&gt; &lt;/Message&gt;";
											</small> <small>RequestEntity requestEntity = new
												ByteArrayRequestEntity(requestXml.getBytes("UTF-8"),
												"UTF-8"); method.setRequestEntity(requestEntity);</small> <small>httpClient.executeMethod(method);</small>

											<small> String response =
												method.getResponseBodyAsString();</small> <small>System.out.println(response);</small>

											<small> method.releaseConnection();</small>
										</blockquote>
									</div>
								</div>
							</div>

							<p></p>

							<div id="faq">&nbsp;
							<br>
							<br>
							</div>

							<p>
							</p><h3>5.常见问题FAQ</h3>

							<dl>
								<dt>1)多终端代码使用注意事项</dt>
								<dd>在设置播放域名限制的同时，使用保利威视的多终端代码（如下图）时，要注意div标签中的id必须是唯一的，而且不能跟vid一样，否则会导致有些浏览器使用播放域名限制会出现问题。</dd>

								<br>


								<dt>2)移动端无法播放视频</dt>
								<dd>

									1、IOS系列 <br> 1）支持iOS6以上版本的设备进行视频播放，iOS6的高版本可以支持，低版本无法支持 <br>
									2）视频无法播放时，清空浏览器缓存信息，刷新后播放 <br> 3）系统版本无问题，仍有视频播放问题，请联系售后客服 <br>
									<br> 2、安卓系列 <br> 1）视频无法播放时，清空浏览器缓存信息，刷新后播放 <br>
									2）系统版本无问题，仍有视频播放问题，请联系售后客服 <br> 

								</dd>

								<br>

								<dt>3)视频花屏问题</dt>
								<dd>
									1、关闭硬件加速 <br> 原因：硬件加速导致视频计算机资源调用 <br>
									解决办法：关闭硬件加速，找到启动硬件加速，把前面的勾选去掉。 <br> <br> 2、更新Flash
									player <br> 原因：Flash player版本较低 <br> 解决办法：升级Flash player <br>
								</dd>
								<p></p>
						</dl></div>
					
				<!-- 
					<div class="vertical-box">
						
						<div class="vertical-box-column p-15">
						
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
														aria-label="SDK名称: activate to sort column descending">SDK名称</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1" aria-sort="ascending"
														aria-label="SDK类型: activate to sort column descending">SDK类型</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="状态: activate to sort column ascending">状态</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="创建时间: activate to sort column ascending">创建时间</th>
													<th class="sorting" tabindex="0" aria-controls="data-table"
														rowspan="1" colspan="1"
														aria-label="最后修改时间: activate to sort column ascending">最后修改时间</th>
													
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				 -->
			</div>
			<!-- end panel -->
		</div>
		<!-- end #content -->

		<!-- begin #footer -->
		<jsp:include page="../foot.jsp"></jsp:include>
		<!-- end #footer -->

		<!-- begin #theme -->
		<jsp:include page="../theme.jsp"></jsp:include>
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
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
		});


	</script>
</body>
</html>