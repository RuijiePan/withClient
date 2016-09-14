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
			用户管理 <small>修改密码</small>
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
							<input type="hidden" name="userId" id="userId" value="${User.id}" />
							<label for="old_password">旧密码</label> <input type="password"
								class="form-control" name="old_password" id="old_password"
								placeholder="旧密码" value="" />
						</div>

						<div class="form-group">
							<label for="new_password">新密码</label> <input type="password"
								class="form-control" name="new_password" id="new_password"
								placeholder="新密码" value="" />
						</div>

						<div class="form-group">
							<label for="confirm_password">确认密码</label> <input type="password"
								class="form-control" name="confirm_password"
								id="confirm_password" placeholder="确认密码" value="" />
						</div>
					</div>

					<div class="box-footer">
						<button class="btn btn-primary">修改</button>
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
				old_password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						stringLength : {
							min : 6,
							max : 30,
							message : '密码长度必须在6到30之间'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '密码只能包含字母大、小写，数字和下划线'
						}
					}
				},
				new_password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						stringLength : {
							min : 6,
							max : 30,
							message : '密码长度必须在6到30之间'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '密码只能包含字母大、小写，数字和下划线'
						},
						identical : {
							field : 'confirm_password',
							message : '新密码与确认密码不一致'
						},
						different : {
							field : 'old_password',
							message : '旧密码与新密码不能相同'
						}
					}
				},
				confirm_password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						stringLength : {
							min : 6,
							max : 30,
							message : '密码长度必须在6到30之间'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '密码只能包含字母大、小写，数字和下划线'
						},
						identical : {
							field : 'new_password',
							message : '新密码与确认密码不一致'
						},
						different : {
							field : 'old_password',
							message : '旧密码与新密码不能相同'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			var url = "<%=basePath%>modifyedPassword.action";
			var data = $("#form").serialize();
			$.getJSON(url,data,function(result){
				console.log(JSON.stringify(result));
				if(result.success===true){
					//parent.$.dialog.tips("修改密码成功！",tips_sec);
					parent.$.dialog.focus.close();
				}else{
					$.dialog.tips(result.message,tips_sec);
				}
			});
		});
	</script>
</body>
</html>

