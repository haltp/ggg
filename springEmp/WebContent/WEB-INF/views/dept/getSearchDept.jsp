<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/getSearchdept.jsp</title>
</head>
<body>
<h3>부서목록</h3>
<c:forEach items="${list}" var="dept">
<a href="getDept?department_id=${dept.department_id}">${dept.department_id}</a> ${dept.department_name} ${dept.manager_id} ${dept.location_id} ${dept.city} ${dept.last_name} <br>
</c:forEach>
<a href="insertDept">부서등록</a>
</body>
</html>