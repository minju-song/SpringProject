<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>게시물 정보</title>
            </head>

            <body>
                <table>
                    <tr>
                        <th>번호</th>
                        <td>${vo.bno }</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td>${vo.title }</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>${vo.writer }</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea rows="3" cols="2" style="width: 200px;" readonly>${vo.contents }</textarea></td>
                    </tr>
                    <tr>
                        <th>첨부이미지</th>
                        <c:choose>
                            <c:when test="${not empty vo.image}">
                                <td><img src="<c:url value='/resources/img/${vo.image }'/>" style="width:200px;"></td>
                            </c:when>
                            <c:otherwise>
                                <td>이미지없음</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <th>작성일자</th>
                        <td>
                            <fmt:formatDate value="${vo.regdate }" pattern="yyyy/MM/dd" />
                        </td>
                    </tr>
                </table>
                <button type="button" onclick="location.href='boardUpdate?bno=${vo.bno}'">수정</button>
                <button type="button" onclick="location.href='boardDelete?bno=${vo.bno }'">삭제</button>
                <button name="list" type="button">목록</button>

                <script>

                </script>
            </body>

            </html>