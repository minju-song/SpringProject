<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>사원 조회</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		</head>

		<body>
			<form>
				<div>
					<label>employee_id : <input type="text" name="employeeId" value="${empVO.employeeId }"
							readonly></label>
				</div>
				<div>
					<label>first_name : <input type="text" name="firstName" value="${empVO.firstName }"></label>
				</div>
				<div>
					<label>last_name : <input type="text" name="lastName" value="${empVO.lastName }" readonly></label>
				</div>
				<div>
					<label>email : <input type="email" name="email" value="${empVO.email }"></label>
				</div>
				<div>
					<label>hire_date : <input type="date" name="hireDate"
							value='<fmt:formatDate value="${empVO.hireDate }" pattern="yyyy-MM-dd"/>' readonly></label>
				</div>
				<div>
					<label>job_id : <input type="text" name="jobId" value="${empVO.jobId }" readonly></label>
				</div>
				<div>
					<label>salary : <input type="number" name="salary" value="${empVO.salary }"></label>
				</div>
				<div>
					<button type="button" id="updateBtn">수정</button>
					<button type="button" onclick="location.href='empDelete?employeeId=${empVO.employeeId}'">삭제</button>
					<button type="button" onclick="location.href='empList'">목록</button>
				</div>
			</form>

			<script>
				document.querySelector('#updateBtn').addEventListener('click', updateEmpInfo);

				function updateEmpInfo(event) {
					// form태그 내부의 input을 기반으로 수정할 대상 정보를 가져오기
					let empInfo = getEmpInfo();
					//해당 정보를 기반으로 Ajax

					//1. QueryString
					fetch('empUpdate', {
						method: 'post',
						body: new URLSearchParams(empInfo)
					})
						.then(response => response.json())
						.then(result => {
							console.log('result : ', result);
						})
						.catch(err => console.log(err))

					//2. JSON
					fetch('empUpdateAjax', {
						method: 'post',
						headers: {
							'content-Type': 'application/json'
						},
						body: JSON.stringify(empInfo)
					})
						.then(response => response.json())
						.then(result => {
							console.log('result : ', result);
						})
						.catch(err => console.log(err))
				};

				function getEmpInfo() {
					let inputList = document.querySelectorAll('form input');

					let objData = {};

					inputList.forEach((tag) => {
						objData[tag.name] = tag.value;
					})

					return objData;
				}
			</script>

			<script>
				//jQuery 버전
				$('#updateBtn').on('click', updateEmpInfoAjax);

				function updateEmpInfoAjax(event) {

					let empInfo = getEmpInfoAjax();

					// Ajax -> Query String
					$.ajax('empUpdate', {
						type: 'post',
						data: empInfo
					})
						.done(result => {
							console.log('Query String', result);
						})
						.fail(err => console.log(err));


					// Ajax -> JSON
					$.ajax('empUpdateAjax', {
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(empInfo)
					})
						.done(result => {
							console.log('JSON', result);
						})
						.fail(err => console.log(err));

					return false;
				}

				function getEmpInfoAjax() {
					let formDta = $('form').serializeArray();
					console.log(formDta);
					let objData = {};

					$.each(formDta, (idx, obj) => {
						objData[obj.name] = obj.value;
					})

					return objData;
				}

			</script>
		</body>

		</html>