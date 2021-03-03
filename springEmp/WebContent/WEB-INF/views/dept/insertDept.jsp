<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>부서 등록</h3>
<form action="insertDept" method="post" name="frm">
	department_id <input type="number" name="department_id"><br>
	department_name <input name="department_name"><br>
	manager_id <input name="manager_id" value='100'><br>
	location_id <input name="location_id" value='2500'><br>
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>