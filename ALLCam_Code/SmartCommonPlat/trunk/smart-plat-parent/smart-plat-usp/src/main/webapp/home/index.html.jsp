<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<title>4G千里眼</title>

<!-- css -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/nivo-lightbox.css" rel="stylesheet" />
<link href="css/nivo-lightbox-theme/default/default.css"
	rel="stylesheet" type="text/css" />
<link href="css/owl.carousel.css" rel="stylesheet" media="screen" />
<link href="css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="css/flexslider.css" rel="stylesheet" />
<link href="css/animate.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">
<link href="color/default.css" rel="stylesheet">

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">


	<!-- Navigation -->
	<div id="navigation">
		<nav class="navbar navbar-custom" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-md-2">
						<div class="site-logo">
							<a href="index.html" class="brand" style="font-family: 微软雅黑;">4G千里眼</a>
						</div>
					</div>


					<div class="col-md-10">

						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#menu">
								<i class="fa fa-bars"></i>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="menu">
							<ul class="nav navbar-nav navbar-right">
								<li class="active"><a href="#intro" style="font-family: 微软雅黑; font-size: 16px;">首页</a></li>
								<li><a href="#about" style="font-family: 微软雅黑; font-size: 16px;">关于我们</a></li>
								<li><a href="#service" style="font-family: 微软雅黑; font-size: 16px;">能力市场</a></li>
								<li><a href="#works" style="font-family: 微软雅黑; font-size: 16px;">应用市场</a></li>
								<li><a href="#contact" style="font-family: 微软雅黑; font-size: 16px;">联系我们</a></li>
								<li><a href="javascript:window.location.href='/USP/login'" style="font-family: 微软雅黑; font-size: 16px;">登录</a></li>
							</ul>
						</div>
						<!-- /.Navbar-collapse -->

					</div>
				</div>
			</div>
			<!-- /.container -->
		</nav>
	</div>
	<!-- /Navigation -->
	
		<section id="intro" class="home-slide text-light">

		<!-- Carousel -->
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/1.png" alt="First slide">
					<!-- Static Header -->
					<div class="header-text hidden-xs">
						<!--   <div class="col-md-12 text-center">
                            <h2>
                            	<span>4G千里眼</span>
                            </h2>
                            <br>
                            <h3>
                            	<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                            </h3>
                            <br>
                            <div class="">
                                 <a class="btn btn-theme btn-sm btn-min-block" href="#about">关于我们</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                        </div> -->
					</div>
					<!-- /header-text -->
				</div>
				<div class="item">
					<img src="img/2.png" alt="Second slide">
					<!-- Static Header -->
					<div class="header-text hidden-xs">
						<!-- <div class="col-md-12 text-center">
                            <h2>
                                <span>Awesome Bootstrap template</span>
                            </h2>
                            <br>
                            <h3>
                            	<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                            </h3>
                            <br>
                            <div class="">
                                 <a class="btn btn-theme btn-sm btn-min-block" href="#about">About us</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                        </div> -->
					</div>
					<!-- /header-text -->
				</div>
				<div class="item">
					<img src="img/3.png" alt="Third slide">
					<!-- Static Header -->
					<div class="header-text hidden-xs">
						<!-- <div class="col-md-12 text-center">
                            <h2>
                                <span>Use without any charge</span>
                            </h2>
                            <br>
                            <h3>
                            	<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                            </h3>
                            <br>
                            <div class="">
                                <a class="btn btn-theme btn-sm btn-min-block" href="#about">About us</a><a class="btn btn-theme btn-sm btn-min-block" href="#works">Our works</a></div>
                        </div> -->
					</div>
					<!-- /header-text -->
				</div>
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
		<!-- /carousel -->

	</section>
	<!-- /Section: intro -->

	<!-- Section: about -->
	<section id="about" class="home-section color-dark bg-white">
		<div class="container marginbot-50">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
						<div class="section-heading text-center">
							<h2 style="font-family: 微软雅黑;">关于我们</h2>
							<div class="divider-header"></div>
							<p  style="font-family: 微软雅黑;">4G千里眼，一切尽在眼前</p>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="container">


			<div class="row">

				<div class="col-md-6">
						<!-- 具备自动播放、显示用户控件、播放完毕后循环播放功能的video标签 -->
						<video class="img-responsive"  id="myVideo" src="http://allcam-app.oss-cn-hangzhou.aliyuncs.com/IndexPlayer.mp4" autoplay="autoplay" controls="controls" loop="loop">
						您的浏览器不支持video标签。
						</video>
				</div>

				<div class="col-md-6">
					<p  style="font-family: 微软雅黑; font-size: 16px;">“千里眼”是一款无线实时图像监控终端，在中国移动网络覆盖区域下的任何地点，千里眼业务通过有线或无线（TD-SCDMA/EDGE/GPRS/WLAN）网络提供图像和各种报警信号远程采集、传输、储存、处理、转发服务。客户使用千里眼业务，可以从手机、PC终端、专业监控中心获取清晰、逼真、实时的监控视频图像和各种报警信号，可以有效满足用户的监控、安防、远程查看需求。</p>
					<p  style="font-family: 微软雅黑; font-size: 16px;">“4G千里眼”是一款融合多个视频监控平台及多业务的开发性平台:<br/>
					1.多平台&nbsp;对接多个视频监控平台  （海康，华为千里眼，卡尔 等）。<br/>
					2.多租户&nbsp;开放创建租户 对租户分配不同资源 。<br/>
					3.多业务&nbsp;纵向实现多个垂直业务，实现不同业务调用。<br/>
					4.多伙伴&nbsp;基于多个垂直业务基础上，横向能够发展多个开发伙伴。各个伙伴，能够发展更多应用业务。<br/>
					</p>
				</div>
			</div>
		</div>

	</section>
	<!-- /Section: about -->


	<!-- Section: services -->
	<section id="service" class="home-section color-dark bg-gray">
		<div class="container marginbot-50">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
						<div class="section-heading text-center">
							<h2 style="font-family: 微软雅黑;">能力市场</h2>
							<div class="divider-header"></div>
							<p style="font-family: 微软雅黑;">摈弃一切繁杂，不需学习，你天生就会用</p>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="text-center">
			<div class="container">

				<div class="row">
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="wow fadeInLeft" data-wow-delay="0.2s">
							<div class="service-box">
								<div class="service-desc">
									<h5><font style="font-family: 微软雅黑" >江苏景区监控</font></h5>
									<img alt="" src="img/works/4G_1.png" width="220" height="100%">
									<br/>
									<br/>
									<p style="font-family: 微软雅黑;">提供全江苏著名景点实时监控视频，支持应用软件快速集成使用;可以应用于旅游出行、票务平台、娱乐推广等场景，系统提供H5、HLS、RTMP、RTSP等多种流形式，满足业务在各种场景上的集成使用</p>
									<a href="#" class="btn btn-skin">详情</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="wow fadeInUp" data-wow-delay="0.2s">
							<div class="service-box">
								<!-- <div class="service-icon">
									<span class="fa fa-camera fa-5x"></span>
								</div> -->
								<div class="service-desc">
									<h5><font style="font-family: 微软雅黑" >南京公共交通监控</font></h5>
									<img alt="" src="img/works/4G_2.png" width="220" height="100%">
									<br/>
									<br/>
									<p style="font-family: 微软雅黑;">提供全南京市关键道路监控实时监控视频，支持应用软件快速集成使用;可以应用于旅游出行、导航、市民应用等场景，系统提供H5、HLS、RTMP、RTSP等多种流形式，满足业务在各种场景上的集成使用</p>
									<a href="#" class="btn btn-skin">详情</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="wow fadeInUp" data-wow-delay="0.2s">
							<div class="service-box">
								<div class="service-desc">
									<h5><font style="font-family: 微软雅黑" >南京商铺监控</font></h5>
									<img alt="" src="img/works/4G_3.png" width="220" height="100%">
									<br/>
									<br/>
									<p style="font-family: 微软雅黑;">提供全南京小商铺实时监控视频，支持应用软件快速集成使用;可以应用于明厨亮灶、外面应用、商铺推广等场景，系统提供H5、HLS、RTMP、RTSP等多种流形式，满足业务在各种场景上的集成使用</p>
									<a href="#" class="btn btn-skin">详情</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="wow fadeInRight" data-wow-delay="0.2s">
							<div class="service-box">
								<div class="service-desc">
									<h5><font style="font-family: 微软雅黑" >应急监控-南京</font></h5>
									<img alt="" src="img/works/4G_4.png" width="220" height="100%">
									<br/>
									<br/>
									<p style="font-family: 微软雅黑;">提供南京应急关键点位实时监控视频，如关键水文观测点、关键到路口、人群密集区、商业区、重点政府学校等单位；可以提供给应急指挥、政府OA等系统快速集成应用；提示提供安全区可靠的传输保证。</p>
									<a href="#" class="btn btn-skin">详情</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /Section: services -->


	<!-- Section: works -->
	<section id="works"
		class="home-section color-dark text-center bg-white">
		<div class="container marginbot-50">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
						<div class="section-heading text-center">
							<h2 style="font-family: 微软雅黑;">应用市场</h2>
							<div class="divider-header"></div>
							<p style="font-family: 微软雅黑;">多种应用，想'幻'就换，享受应用</p>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="wow bounceInUp" data-wow-delay="0.4s">
						<div id="owl-works" class="owl-carousel">
							<div class="item">
								<a href="img/works/d1.jpg" title="宝宝在线"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/1@2x.jpg"><img
									src="img/works/1.jpg" class="img-responsive" alt="img"></a>
								<div style="font-family: 微软雅黑;">宝宝在线</div>
							</div>
							<div class="item">
								<a href="img/works/d2.jpg" title="蓝天卫士"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/2@2x.jpg"><img
									src="img/works/2.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">蓝天卫士</div>
							</div>
							<div class="item">
								<a href="img/works/d3.jpg" title="商铺监控"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/3@2x.jpg"><img
									src="img/works/3.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">商铺监控</div>
							</div>
							<div class="item">
								<a href="img/works/d4.jpg" title="手机看家"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/4@2x.jpg"><img
									src="img/works/4.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">手机看家</div>
							</div>
							<div class="item">
								<a href="img/works/d1.jpg" title="宝宝在线"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/1@2x.jpg"><img
									src="img/works/1.jpg" class="img-responsive" alt="img"></a>
								<div style="font-family: 微软雅黑;">宝宝在线</div>
							</div>
							<div class="item">
								<a href="img/works/d2.jpg" title="蓝天卫士"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/2@2x.jpg"><img
									src="img/works/2.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">蓝天卫士</div>
							</div>
							<div class="item">
								<a href="img/works/d3.jpg" title="商铺监控"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/3@2x.jpg"><img
									src="img/works/3.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">商铺监控</div>
							</div>
							<div class="item">
								<a href="img/works/d4.jpg" title="手机看家"
									data-lightbox-gallery="gallery1"
									data-lightbox-hidpi="img/works/4@2x.jpg"><img
									src="img/works/4.png" class="img-responsive " alt="img"></a>
									<div style="font-family: 微软雅黑;">手机看家</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- /Section: works -->

	<!-- Section: contact -->
	<section id="contact"
		class="home-section nopadd-bot color-dark bg-gray text-center">
		<div class="container marginbot-50">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
						<div class="section-heading text-center">
							<h2 style="font-family: 微软雅黑;">联系我们</h2>
							<div class="divider-header"></div>
							<p style="font-family: 微软雅黑;">
								服务热线：400-025-8655,025-83359216 <br /> 客服QQ：3140605822<br />
								服务邮箱：support@allcam.com.cn
							</p>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="container">

			<div class="row marginbot-80">
				<div class="col-md-8 col-md-offset-2">
					<form id="contact-form" class="wow bounceInUp" data-wow-offset="10"
						data-wow-delay="0.2s">
						<div class="row marginbot-20">
							<div class="col-md-6 xs-marginbot-20">
								<input type="text" class="form-control input-lg" id="name"
									placeholder="姓名" required="required" />
							</div>
							<div class="col-md-6">
								<input type="email" class="form-control input-lg" id="email"
									placeholder="邮箱" required="required" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control input-lg" id="subject"
										placeholder="主题" required="required" />
								</div>
								<div class="form-group">
									<textarea name="message" id="message" class="form-control"
										rows="4" cols="25" required="required" placeholder="内容"></textarea>
								</div>
								<button type="submit" class="btn btn-skin btn-lg btn-block"
									id="btnContactUs">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>


		</div>
	</section>
	<!-- /Section: contact -->


	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">

					<div class="text-center">
						<a href="#intro" class="totop"><i class="fa fa-angle-up fa-3x"></i></a>

						<p>
							南京奥看信息科技有限公司 版权所有 <br /> &copy;Copyright 2016 - <a
								href="http://www.allcam.com.cn">allcam.com.cn</a> all rights
							reserved
						</p>

						<!-- 
                            All links in the footer should remain intact. 
                            Licenseing information is available at: http://bootstraptaste.com/license/
                            You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Shuffle
                        -->
					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- Core JavaScript Files -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/jquery.scrollTo.js"></script>
	<script src="js/jquery.appear.js"></script>
	<script src="js/stellar.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/nivo-lightbox.min.js"></script>

	<script src="js/custom.js"></script>

</body>

</html>
