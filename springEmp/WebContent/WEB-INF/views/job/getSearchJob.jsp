<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>job/getSearchjob.jsp</title>
</head>
<body>
<h3>JOB목록</h3>
<c:forEach items="${list}" var="job">
job_title: <a href="getJob?job_id=${job.job_id}">${job.job_title}</a> min_salary: ${job.min_salary} max_salary: ${job.max_salary}<br>
</c:forEach>
<a href="insertJob">JOB등록</a>
</body>
</html>