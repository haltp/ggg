<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept/getSearchdept.jsp</title>
</head>
<body>

<form action="getSearchDept" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서이름 : <input name="department_name" value="${DeptVO.department_name}">
	manager_id : <input name="manager_id" value="${DeptVO.manager_id}">
	<button>검색</button>
</form>

<h3>부서목록</h3>
<c:forEach items="${list}" var="dept">
부서 번호: <a href="getDept?department_id=${dept.department_id}">${dept.department_id}</a> 부서 이름: ${dept.department_name} location_id: ${dept.location_id} city: ${dept.city} manager_id: ${dept.manager_id} manager_last_name: ${dept.last_name} <br>
</c:forEach>

<my:paging paging="${paging}" jsFunc="goPage" />
<script>
	function goPage(p) {
		//location.href="getSearchEmp?page="+p;
		searchFrm.page.value=p;
		searchFrm.submit();
	}
</script>

<a href="insertDept">부서등록</a>
</body>
</html>