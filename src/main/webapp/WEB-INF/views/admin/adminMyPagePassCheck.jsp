<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


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