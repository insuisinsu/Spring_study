<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<center>
	<h3>회원가입</h3>
	<hr>
	<form action="insertUser.do" method="post">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="password"><br>
	이름 : <input type="text" name="name"><br>
	역할 : <input type="text" name="role"><br>
	<input type="submit" value="회원가입">
	</form>

</center>

</body>
</html>