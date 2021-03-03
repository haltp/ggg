<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
 $(function(){
	 //이메일 중복 체크
	 $("#btnEmail").on("click", function(){
		 $.ajax({
			 url : "EmailCheck",
			 data : "email=" + $("[name=email]").val(),	//서버에 보낼 파라미터
			 dataType : "xml",
			 success : function(response){
			$("#emailResult").html($(response).find("email").text());
			}
		 });
	 });
 });
 function search() {
		var url = "list";
			window.open(url, "사원검색",
					"width=600, height=200, top=100, left=100");
		}

 
 
</script>
</head>
<body>
<h3 id="top">사원등록</h3>
<form action="insertEmp" method="post" name="frm">
	employee_id <input type="number" name="employee_id"><br>
	first_name  <input name="first_name"><br>
	last_name   <input name="last_name"><br>
	email       <input type="email" name="email">
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number"><br>
	hire_date   <input type="date" name="hire_date"><br>
	department_id 
				<input type="radio" name="department_id" value="10" >기획
				<br>
					 
	job_id      <select name="job_id">
				<option value="AD_ASST" >AD_ASST</option>
				<c:forEach items="${jobList}" var="job">
				</c:forEach>
				</select>
				<br>
	
	
				  
	manager_id 
	<input type="text" name="manager_id" value="${empVO.manager_id}">
	<input type="text" name="mname">
	<button type="button" onclick="search()">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>

</body>
</html>