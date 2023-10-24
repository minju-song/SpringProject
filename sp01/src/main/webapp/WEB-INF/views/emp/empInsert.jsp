<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			table,
			th,
			td {
				border: 1px solid black;
			}
		</style>
	</head>

	<body>

		<form action="empInsert" method="post">
			<div>
				<label>first_name : </label>
				<input type="text" name="firstName">
			</div>
			<div>
				<label>last_name : </label>
				<input type="text" name="lastName">
			</div>
			<div>
				<label>email : </label>
				<input type="email" name="email">
			</div>
			<div>
				<label>hire_date : </label>
				<input type="date" placeholder="yyyy/MM/dd" name="hireDate">
			</div>
			<div>
				<label>job_id : </label>
				<input type="text" name="jobId">
			</div>
			<div>
				<label>salary : </label>
				<input type="number" name="salary">
			</div>
			<div>
				<button type="submit">등록</button>
				<button type="button" onclick="location.href='empList'">목록</button>
			</div>
		</form>

	</body>

	</html>