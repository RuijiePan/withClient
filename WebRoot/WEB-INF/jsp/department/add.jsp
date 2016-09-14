<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../top.jsp"%>
<!DOCTYPE html>
<html>
<%@include file="../header-add-modify.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			部门管理 <small>添加</small>
		</h1>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="box box-primary">
			<!-- /.box-header -->
			<div class="box-body" style="width: 400px">
				<form role="form" id="form">
					<div class="box-body">
						<div class="form-group">
							<label for="name">部门名称</label> <input type="text"
								class="form-control" name="name" id="name"
								placeholder="部门名称" value="" />
						</div>

						<div class="form-group">
							<label for="inputParent">上级部门</label>
							<select class="form-control" name="parent" id="inputParent">
								<c:forEach var="item" items="${departmentList}" varStatus="status">  
									<option value="${item.id}" <c:if test="${item.id==department.parent}">selected</c:if>>
										${item.name}
									</option> 
								</c:forEach> 
							</select>
						</div>
					</div>

					<div class="box-footer">
						<button class="btn btn-primary">添加</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- /.content -->

	<!-- REQUIRED JS SCRIPTS -->
	<%@include file="../js-scripts-add-modify.jsp"%>

	<script>
		$('#form').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				name : {
					validators : {
						notEmpty : {
							message : '部门名称不能为空'
						},
						stringLength : {
							min : 2,
							max : 30,
							message : '部门名称长度必须在2到30之间'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			var url = "added.action";
			var data = $("#form").serialize();
			/* {
				name:$("#name").val(),
				description:$("#description").val()
			}; */
			$.post(url,data, function( result ) {
  				if(result.success===true){
					parent.$.dialog.focus.reload(parent);
				}else{
					$.dialog.tips(result.message,tips_sec);
				}
			},"json");
		});
	</script>
</body>
</html>

