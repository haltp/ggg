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
<h3>Job 수정</h3>
<form action="updateJob" method="post" name="frm">
	job_id <input type="text" name="job_id" value="${JobVO.job_id}"><br>
	job_title <input name="job_title" value="${JobVO.job_title}"><br>
	min_salary <input name="min_salary" value="${JobVO.min_salary}"><br>
	max_salary <input name="max_salary" value="${JobVO.max_salary}"><br>
	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>