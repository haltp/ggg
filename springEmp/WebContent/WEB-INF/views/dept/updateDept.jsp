<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>부서 수정</h3>
<form action="updateDept" method="post" name="frm">
	department_id <input type="number" name="department_id" value="${DeptVO.department_id}"><br>
	department_name <input name="department_name" value="${DeptVO.department_name}"><br>
	manager_id <input name="manager_id" value="${DeptVO.manager_id}"><br>
	location_id <input name="location_id" value="${DeptVO.location_id}"><br>
	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>