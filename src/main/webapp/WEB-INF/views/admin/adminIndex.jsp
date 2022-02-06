<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#loginForm{
		width : 300px;
	}
</style>

</head>
<body>
	
	<H1>기본 메인 페이지</H1>
	
	<c:choose>
		
		<c:when test="${sessionScope.admin != null }">
			[<a href="/admin/myPage.do">${sessionScope.admin.adminName }</a>]님 환영합니다. <a href="/admin/adminLogout.do">로그아웃</a><br>
			<a href="/admin/adminMyPage.do">마이 페이지</a><br>
			<a href="/admin/adminWithDraw.do">회원 탈퇴</a><br>
			<a href="/admin/memberAllList.do">전체 회원 리스트</a><br>
		</c:when>
		
		<c:otherwise>
			<form id="loginForm" action="/admin/adminLogin.do" method="post">
				<fieldset>
					<legend>로그인</legend>
					ID : <input type="text" name="userId"/><br>
					PW : <input type="password" name="userPwd"/><br>
					<input type="submit" value="로그인"/>
				</fieldset>
			</form>
			
			<a href="/admin/adminJoinPage.do">회원가입</a><br>
			
		</c:otherwise>
		
	</c:choose>
	
	
	
</body>
</html>