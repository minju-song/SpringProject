<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <ul class="nav justify-content-start">
    <li class="nav-item">
      <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/">홈</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath }/empList">전체사원조회</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath }/empInsert">사원정보등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath }/boardList">익명게시판조회</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath }/boardInsert">익명게시글등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" aria-disabled="true">Disabled</a>
    </li>
  </ul>