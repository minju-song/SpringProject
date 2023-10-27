<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>게시판 목록</title>
				<style>
					table,
					th,
					td {
						border: 1px solid black;
						padding: 10px;
					}
				</style>
			</head>

			<body>
				<button type="button" onclick="location.href='boardInsert'">
					등록</button>
				<br>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="b" varStatus="sts">
							<tr onclick="location.href='boardInfo?bno=${b.bno}'">
								<td>${b.bno }</td>
								<td>${b.title }</td>
								<td>${b.writer }</td>
								<td>
									<fmt:formatDate value="${b.regdate }" pattern="yyyy년 MM월 dd일" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<script>
					let msg = `${result}`;

					if (msg != '') alert(msg);
				</script>
			</body>

			</html>