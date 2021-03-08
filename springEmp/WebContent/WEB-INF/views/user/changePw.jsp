<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePw</title>

</head>
<body>
	<h3>패스워드 변경</h3>
	<form action="changePw" method="post">
		패스워드: <input name="oldpassword"></br> 
		변경할 패스워드: <input name="password"></br> 
		변경할 패스워드 확인: <input name="newpassword"></br>
		<button type="submit">패스워드 변경</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>