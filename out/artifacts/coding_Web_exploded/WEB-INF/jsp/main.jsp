<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="top.jsp" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- Main Header -->
<%@include file="main-header.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
<%@include file="left-side.jsp" %>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
               	 首页
                <small>开发日志</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

             <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年4月27日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>login.action">完成系统登陆</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>main.action">完成主页面显示</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>main.action">完成功能菜单及权限设定</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>logout.action">完成用户注消（退出）</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年4月28日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成通用分页功能</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成项目浏览功能（项目分页列表）</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年4月29日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成通用弹出窗口（增、删、改使用窗口处理）</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年5月3日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="#">与汪总、赵庆鑫开会，探讨代码安全，文件 管理、物流项目的进度及工作安排。</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="#">试着修复赵庆鑫硬盘文件 （未完成）</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年5月4日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成项目添加、修改、删除功能</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年5月5日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成项目配置参数功能</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成项目的指定当前项目</a>
                        </li>
                    </ul>
                </div>
            </div>
            
            <div class="panel panel-primary" style="width: 600px;">
                <div class="panel-heading">2016年5月6日</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="badge">徐新宇</span>
                            <a href="<%=basePath%>project/projectList.action">完成功能模块的数据库连接、修改项目参数及项目信息修改</a>
                        </li>
                    </ul>
                </div>
            </div>

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <form action="" id="removeForm">
    </form>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="js-scripts.jsp" %>

<script>

    jQuery(document).ready(function () {
        init('${pageContext.request.contextPath}/');
        initMenu([${User.permissions}], "", "");
        initTopRight('${User.trueName}', '超级管理员');
        ///initList();
    });

</script>
</body>
</html>

