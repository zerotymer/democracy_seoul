<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>민서네 시민토론 - 오류</title>
</head>
<body>

	<script>
		alert('오류가 발생하였습니다. 지속적인 오류 발생 시 관리자에게 문의 바랍니다.');
		window.redirect("/");
	</script>
	
</body>
</html>