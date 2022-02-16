<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>민주주의 서울 - 시민토론</title>

	<link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
	
	<style>
		
	</style>
	
</head>
<body>
	<header>
    <%@ include file="/includes/header.jsp" %>
	</header>
	
	<div id="success"></div>
	
	<header>
    <%@ include file="/includes/header.jsp" %>
	</header>

<script>
	var msg=${msg};
	alert(msg);
	location.replace('/discuss/list.do');
</script>

</body>
</html>