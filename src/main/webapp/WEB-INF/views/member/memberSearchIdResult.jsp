<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기 결과</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/commons/default.css">
<link rel="stylesheet" href="/resources/style/member/commons/common.css">
<link rel="stylesheet" href="/resources/style/member/memberSearchIdResult.css">
</head>

<body>


	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/member/goMemberSearchPwd.do">비밀번호 찾기</a>
			</div>
			<div class="box-result">
				<p>입력하신 정보와 일치하는 아이디입니다.</p>
				<div class="box-userInfo">
					<span id="userId">아이디 님</span> 
					<span id="enrollDate">회원 가입일</span>
				</div>
			</div>
			<button class="btn-login"><a href="/member/goLogin.do">로그인하기</a></button>
		</div>
	</div>
</body>
</html>