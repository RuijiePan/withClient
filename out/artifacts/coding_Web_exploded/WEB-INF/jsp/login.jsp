<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>人力资源管理系统</title>

<!-- CSS -->
<link rel="stylesheet"
	href="<%=basePath%>resources/lib/login/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/lib/login/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/lib/login/css/form-elements.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/lib/login/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="<%=basePath%>resources/lib/ie/html5shiv.min.js"></script>
    <script src="<%=basePath%>resources/lib/ie/respond.min.js"></script>
    <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon"
	href="<%=basePath%>resources/lib/login/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=basePath%>resources/lib/login/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=basePath%>resources/lib/login/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=basePath%>resources/lib/login/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=basePath%>resources/lib/login/ico/apple-touch-icon-57-precomposed.png">
<%
//为了解决在弹出窗口中出现登陆的现象
String forword = (String)request.getAttribute("forward");
if(forword!=null){
%>
<script type="text/javascript">
if(window!=top){
	top.location.href="<%=forword%>";
}
</script>
<%
}
 %>
</head>
<body>
	<div class="top-content">
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>人力资源管理系统</strong>
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>登录系统</h3>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<c:if test="${errors!=null && errors.errorCount != 0}">
								<div class="alert alert-danger alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<strong>
										<c:forEach items="${errors.allErrors}"
											var="error">
												${error.defaultMessage }<br />
										</c:forEach> 
									</strong>
								</div>
							</c:if>
							<form role="form" action="${pageContext.request.contextPath}/logined.action" method="post"
								class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">Username</label> <input
										type="text" name="userName" placeholder="Username..."
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label> <input
										type="password" name="password" placeholder="Password..."
										class="form-password form-control" id="form-password">
								</div>
								<button type="submit" class="btn">登 录</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Javascript -->
	<script src="<%=basePath%>resources/lib/login/js/jquery-1.11.1.min.js"></script>
	<script
		src="<%=basePath%>resources/lib/login/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>resources/lib/login/js/jquery.backstretch.min.js"></script>

	<!--[if lt IE 10]>
<script src="<%=basePath%>resources/lib/login/js/placeholder.js"></script>
<![endif]-->
	<script>

    jQuery(document).ready(function() {

        /*
         Fullscreen background
         */
        $.backstretch("<%=basePath%>resources/lib/login/img/backgrounds/1.jpg");

							/*
							 Form validation
							 */
							$('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea')
									.on('focus', function() {
										$(this).removeClass('input-error');
									});

							$('.login-form')
									.on(
											'submit',
											function(e) {

												$(this)
														.find(
																'input[type="text"], input[type="password"], textarea')
														.each(
																function() {
																	if ($(this)
																			.val() == "") {
																		e
																				.preventDefault();
																		$(this)
																				.addClass(
																						'input-error');
																	} else {
																		$(this)
																				.removeClass(
																						'input-error');
																	}
																});

											});

						});
	</script>
</body>

</html>