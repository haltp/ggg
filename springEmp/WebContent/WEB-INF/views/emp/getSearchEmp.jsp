<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
</head>
<body>
<h3>사원목록</h3>
<c:forEach items="${list}" var="emp">
<a href="getEmp?employee_id=${emp.employee_id}">${emp.first_name}</a> ${emp.employee_id} ${emp.email} ${emp.salary} ${emp.department_name} ${emp.job_title} <br>
</c:forEach>
<a href="insertEmp">사원등록</a>
</body>
</html>