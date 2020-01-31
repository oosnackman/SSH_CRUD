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

	<s:if test="#request.employees==null||#request.employees==0">
		沒有任何員工訊息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>員工編號</td>
				<td>姓名</td>
				<td>信箱</td>
				<td>生日</td>
				<td>創建日期</td>
				<td>部門</td>
				<td colspan="3" align="center">功能</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id}</td>
					<td>${name}</td>
					<td>${email}</td>
					<td>${birth}</td>
					<td>${createTime}</td>
					<td>${departmentId.departmentName}</td>
					<td><a href="emp-delete?id=${id}">刪除</a></td>
					<td><a href="emp-add">新增</a></td>
					<td><a href="emp-update?id=${id}">修改</a></td>
				</tr>
			</s:iterator>
		</table>

	</s:else>

</body>


</html>