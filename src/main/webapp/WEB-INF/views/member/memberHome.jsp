<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>
	#loginForm{
		width : 300px;
	}
</style>

<H1>기본 메인 페이지</H1>

<c:choose>
	<c:when test="${sessionScope.user != null }">
		[<a href="/member/myPage.do">${sessionScope.user.userName }</a>]님 환영 합니다 <a href="/member/logout.do">로그아웃</a><br>
	    <a href="/member/goMyPage.do">mypage</a>
		<a href="/member/memberWithdraw.do">회원 탈퇴</a><br>
	</c:when>
	<c:otherwise>
		<form id="loginForm" action="/member/login.do" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text" name="userId"/><br>
				PW : <input type="password" name="userPwd"/><br>
				<input type="submit" value="로그인"/>
			</fieldset>
			
		</form>		
	</c:otherwise>
</c:choose>







</body>
</html>