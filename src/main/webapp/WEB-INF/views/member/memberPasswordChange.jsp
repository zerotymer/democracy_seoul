<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pwdForm{
		width : 250px;
		height: 200px;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<div id="pwdForm">
		<form>
			<input type="password" name="original_pwd" class="w-100" placeholder="현재 패스워드를  작성하세요"/><br>
			<input type="password" name="new_pwd" class="w-100" placeholder="변경할 패스워드를 작성하세요"/><br>
			<input type="password" name="new_pwd_re" class="w-100" placeholder="변경할 패스워드를 재작성"/><br>
			<input type="submit" class="btn btn-primary b-block w-100" value="변경하기"/>
		</form>
	
	</div>

</body>
</html>