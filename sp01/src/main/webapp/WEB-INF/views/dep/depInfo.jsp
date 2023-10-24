<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 조회</title>
</head>
<body>
    <form>
        <div>
            <label>department_id : <input type="number" name="departmentId" value="${depVO.departmentId }"
                    readonly></label>
        </div>
        <div>
            <label>department_name : <input type="text" name="departmentName" value="${depVO.departmentName }"></label>
        </div>
        <div>
            <label>manager_id : <input type="number" name="managerId" value="${depVO.managerId }"></label>
        </div>
        <div>
            <label>location_id : <input type="number" name="locationId" value="${depVO.locationId }"></label>
        </div>
        <div>
            <button type="button" id="updateBtn">수정</button>
            <button type="button" onclick="location.href='depDelete?departmentId=${depVO.departmentId}'">삭제</button>
            <button type="button" onclick="location.href='depList'">목록</button>
        </div>
    </form>

    <script>

        document.querySelector('#updateBtn').addEventListener('click', updateDepInfo);

        function updateDepInfo(event) {
            // form태그 내부의 input을 기반으로 수정할 대상 정보를 가져오기
            let depInfo = getdepInfo();
            //해당 정보를 기반으로 Ajax

            //2. JSON
            fetch('depUpdateAjax', {
                method: 'post',
                headers: {
                    'content-Type': 'application/json'
                },
                body: JSON.stringify(depInfo)
            })
                .then(response => response.json())
                .then(result => {
                    console.log('result : ', result);
                })
                .catch(err => console.log(err))
        };

        function getdepInfo() {
            let inputList = document.querySelectorAll('form input');

            let objData = {};

            inputList.forEach((tag) => {
                objData[tag.name] = tag.value;
            })

            return objData;
        }
    </script>
</body>
</html>