<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
<style>
	table, th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">
	등록</button>
	<br>
	<table>
		<thead>
			<tr>
				<th>NO.</th>				
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList }" var="e" varStatus="sts">
				<tr onclick="location.href='empInfo?employeeId=${e.employeeId}'">
					<td>${sts.count }</td>
					<td>${e.employeeId }</td>
					<td>${e.firstName }</td>
					<td>${e.lastName }</td>
					<td>${e.email }</td>
					<td>
						<fmt:formatDate value="${e.hireDate }" pattern="yyyy.MM.dd"/>
					</td>
					<td>${e.jobId }</td>
					<td>
						<fmt:formatNumber value="${e.salary }" pattern="#,###"/>					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>