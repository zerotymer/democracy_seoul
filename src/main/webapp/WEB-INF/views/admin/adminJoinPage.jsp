<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#joinForm{
		width : 500px;
	}
</style>

</head>
<body>

	<form action="/admin/adminJoin.do" method="post" id="joinForm">
		<fieldset>
			<legend>관리자 가입</legend>
			ID : <input type="text" name="adminId" placeholder="아이디"/><button type="button" id="idCheckBtn">중복체크</button><br>
			PW : <input type="password" name="adminPwd" placeholder="비밀번호"/><br>
			이름 : <input type="text" name="adminName" /><br>
			이메일 : <input type="text" name="adminEmail"/><br>
			<input type="submit" value="가입"/>
		</fieldset>
	</form>
	
	<a href="/">메인 페이지</a>
	
	<script>
		$('#idCheckBtn').click(function(){
			var adminId = $('input[name=adminId]').val();
			
			$.ajax({
				url : "/admin/adminIdCheck.do",
				data : {"adminId" : adminId},
				type : "get",
				success : function(result){
					if(result == "true")
					{
						alert('[' + adminId + ']사용 불가능한 ID');
						$('input[name=adminId]').css('color', 'red');
					}else{
						alert('[' + adminId + ']사용 가능한 ID');
						$('input[name=adminId]').css('color', 'blue');
					}
				},
				error : function(){
					console.log("ajax 통신 실패");
				}
			});
		});
	</script>

</body>
</html>