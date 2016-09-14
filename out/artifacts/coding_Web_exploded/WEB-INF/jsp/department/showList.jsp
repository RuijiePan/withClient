<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../top.jsp"%>
<!DOCTYPE html>
<html>
<%@include file="../header.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Main Header -->
		<%@include file="../main-header.jsp"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="../left-side.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					部门管理 <small>浏览</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard">部门管理</i></a></li>
					<li class="active">部门维护</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">部门列表</h3>
						<div class="pull-right box-tools">
							<a href="javascript:addData();" class="btn btn-default" data-toggle="tooltip" title="添加部门"><i class="glyphicon glyphicon-plus"></i></a>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<%-- <c:if test="${OResult.message != null}">
							<div
								class="alert <c:if test="${OResult.code == 0}">alert-danger</c:if><c:if test="${OResult.code == 1}">alert-success</c:if> alert-dismissible"
								role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>${OResult.message}</strong>
							</div>
						</c:if> --%>
                        <input id="modify" type="hidden" value="modify"/>
                        <input id="allot" type="hidden" value="allot"/>
                        <input id="remove" type="hidden" value="remove"/>
						<table id="list" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th style="width:10%;text-align: center">序号</th>
									<th style="width:15%;text-align: center">部门ID</th>
									<th style="width:20%;text-align: center">部门名称</th>
									<th style="text-align: center">上级部门</th>
									<th style="width: 80px;text-align: center">操作</th>
								</tr>
							</thead>
							<tbody id="table_body">
							</tbody>
						</table>
						<div class="text-center">
                        	<ul id="pagination" class="pagination"></ul>
                    	</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->
	<%@include file="../js-scripts-pagination.jsp"%>

	<script>
	/* 
	在../js-scripts-pagination.jsp里已声明
	var pagination;
    var tableBody;
    var pageSize;
    var currentPage=1;
    function initList() 
    function initPage(totalCount, totalPages) 
    function getDialogWidth()
    function getDialogWidth()
    */
    var url ="getDepartmentList.action";//getData(currentPage)使用些变量
    
    jQuery(document).ready(function () {
    	init('<%= basePath%>');//替换点
        initMenu([${User.permissions}], "80", "81");//替换点
        initTopRight('${User.trueName}', '超级管理员');
        initList();
        getData(currentPage);
    });

    function setData(result) {//替换点getData(currentPage)方法回调此函数
        var html = "";
        for (var i = 0; i < result.data.length; i++) {
            var item = result.data[i];
            html += "<tr>";
            html += "<td style='text-align: center'>" + ((currentPage-1)*pageSize+i+1) + "</td>";
            html += "<td style='text-align: center'>" + item.id + "</td>";
            html += "<td style='text-align: center'>" + item.name + "</td>";
            html += "<td>" + item.parent + "</td>";
            html += "<td style='text-align: center'>";
            
            
            if ($("#modify").val()) {
                html += "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:modifyData(\"" + item.id + "\")' class='glyphicon glyphicon-edit' title='修改[" + item.name + "]' data-toggle='tooltip'></a>";
            }

            if ($("#remove").val()) {
                html += "&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:removeData(\"" + item.id + "\",\"" + item.name + "\")' class='glyphicon glyphicon-trash' title='删除[" + item.name + "]' data-toggle='tooltip'></a>";
            }
            
            html += "</td>";

            html += "</tr>";
        }
        tableBody.html(html);
    }

    function removeData(id, name) {
    	$.dialog.confirm("确定要删除部门【" + name + "】吗?",function(dialog){
    		var url = "remove.action";
			var data = {id:id};
			/* {
				name:$("#name").val(),
				description:$("#description").val()
			}; */
			$.post(url,data, function( result ) {
  				if(result.success===true){
					//dialog.reload(top,"projectList.action");
					//$.dialog.focus.reload(parent,"projectList.action");
					window.location.href="showList.action";
				}else{
					$.dialog.tips(result.message,tips_sec);
				}
			},"json");
    	}); 
    }
    
    function modifyData(id) {
    	var width = getDialogWidth();
    	var height = getDialogHeight();
    	$.dialog({content:'url:modify.action?id='+id,min:false,width:width,height:height,title:'修改部门',lock:true,fixed:true});
    }
    
    function addData() {
    	var width = getDialogWidth();
    	var height = getDialogHeight();
    	$.dialog({content:'url:add.action',min:false,width:width,height:height,title:'添加新部门',lock:true,fixed:true});
    }

</script>
</body>
</html>

