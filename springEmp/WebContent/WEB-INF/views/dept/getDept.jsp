<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getdept.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btnUpd").on("click", function(){
			location.assign("updateDept?department_id=${dept.department_id}");
		})		
	});
	
	</script>
</head>
<body>
	부서번호 : ${dept.department_id}
	<br> 
	부서이름 : ${dept.department_name}
	<br> 
	MANAGER_ID : ${dept.manager_id}
	<br> 
	LOCATION_ID : ${dept.location_id}
	<br> 
	<br>
	<button id="btnUpd">수정</button>
	<a href="deleteDept?department_id=${dept.department_id}">삭제</a>
	<a href="getSearchDept">목록으로</a>
</body>
</html>