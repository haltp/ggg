<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
</head>
<body>
<h3>사원목록</h3>
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서번호 : <input name="department_id" value="${empSearchVO.department_id}">
	job_id : <input name="job_id" value="${empSearchVO.job_id}">
	이름 : <input name="first_name" value="${empSearchVO.first_name}">
	<button>검색</button>
</form>

<c:forEach items="${list}" var="emp">
이름: <a href="getEmp?employee_id=${emp.employee_id}">${emp.first_name}</a> 사원번호: ${emp.employee_id} 이메일: ${emp.email}
급여: ${emp.salary} 부서번호:${emp.department_id} 부서이름: ${emp.department_name} job_id: ${emp.job_id} job_title: ${emp.job_title} <br>
</c:forEach>
<my:paging paging="${paging}" jsFunc="goPage" />
<script>
	function goPage(p) {
		//location.href="getSearchEmp?page="+p;
		searchFrm.page.value=p;
		searchFrm.submit();
	}
</script>

<a href="insertEmp">사원등록</a>
</body>
</html>