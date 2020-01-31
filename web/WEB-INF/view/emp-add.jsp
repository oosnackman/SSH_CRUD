<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div id="message">
		<p>{{message}}</p>
	</div>
	<div>

		<s:form action="emp-save" method="post">
			<s:if test="id != null">
				<s:textfield name="name" label="姓名" v-model="fname" disabled="true"></s:textfield>
				<s:hidden name="id"></s:hidden>
				<s:hidden name="name"></s:hidden>
				<s:hidden name="createTime"></s:hidden>
			</s:if>
			<s:else>
				<s:textfield name="name" label="姓名" v-model="fname"></s:textfield>
			</s:else>

			<s:textfield name="email" label="信箱" v-model="femail"></s:textfield>

			<s:textfield name="birth" label="生日	" v-model="fbirth"></s:textfield>


			<s:select list="#request.departments" listKey="id"
				listValue="departmentName" name="departmentId.id" label="部門"></s:select>
			<s:submit></s:submit>
		</s:form>

	</div>
	<script type="text/javascript">
		var app = new Vue({
			el : '#message',
			data : {
				message : '員工資料功能'
			}
		});
	</script>
</body>
</html>