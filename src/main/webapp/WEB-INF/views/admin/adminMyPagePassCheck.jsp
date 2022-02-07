<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#passForm{
		width : 300px;
	}
</style>

</head>
<body>
	
	<form action="" method="post" id="passForm">
		<H1>MyPage</H1>
		<fieldset>
			<legend>비밀번호 확인</legend>
			PW : <input type="password" name="adminPwd"/>
			<input type="submit" value="확인"/>
		</fieldset>
	</form>
	
	<a href="/">메인 페이지로</a>
	
</body>
</html>