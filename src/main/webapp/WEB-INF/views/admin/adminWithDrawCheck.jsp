<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#withDrawForm{
		width : 500px;
	}
</style>

</head>
<body>
	
	<form action="/admin/adminWithDraw.do" method="post" id="adminWithDrawForm">
		<H1>관리자 탈퇴 요청</H1>
		<fieldset>
			<legend>관리자 확인 비밀번호 입력</legend>
			비밀번호 입력 : <input type="password" name="adminPwd"/><br>
			
			<H4>탈퇴 시 복원은 불가능합니다.</H4>
			<input type="checkbox" name="agree" value="Y"/>동의<br>
			
			<input type="submit" value="탈퇴요청"/>
		</fieldset>
	</form>
	
	<a href="/">메인 페이지로</a><br>
	
</body>
</html>