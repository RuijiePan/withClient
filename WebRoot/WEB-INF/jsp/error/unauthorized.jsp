<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>No Permission</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/adminlte/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/font-awesome-4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/ionicons-2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/adminlte/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/adminlte/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/adminlte/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resources/lib/adminlte/dist/css/skins/_all-skins.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div>
    <div>
        <section class="content">
            <div class="error-page">
                <div class="error-content">
                    <h3><i class="fa fa-warning text-yellow"></i> 警告! 没有访问权限.</h3>
                    <p>
                        您当前登录的账号没有该访问权限.
                        您可能需要点击<a href="<%=basePath%>logout.action" title="点我回登录页">返回</a>重新登录，或者返回原來页面.
                    </p>
                </div><!-- /.error-content -->
            </div><!-- /.error-page -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <div class="control-sidebar-bg"></div>
</div><!-- ./wrapper -->
</body>
</html>
