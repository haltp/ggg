<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getJob.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btnUpd").on("click", function(){
			location.assign("updateJob?job_id=${job.job_id}");
		})		
	});
	
	</script>
</head>
<body>
	job_id : ${job.job_id}
	<br> 
	job_title : ${job.job_title}
	<br> 
	min_salary : ${job.min_salary}
	<br> 
	max_salary : ${job.max_salary}
	<br> 
	<br>
	<button id="btnUpd">수정</button>
	<a href="deleteJob?job_id=${job.job_id}">삭제</a>
	<a href="getSearchJob">목록으로</a>
</body>
</html>