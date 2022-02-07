<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#myForm{
		width : 400px;
	}
	#pass{
		width : 400px;
		border : 1px solid black;
	}
</style>

</head>
<body>
	
	ID : ${sessionScope.admin.adminId }<br>
	관리자 등급 : ${sessionScope.admin.adminGrade }<br>
	이름 : ${sessionScope.admin.adminName }<br>
		
	<form id="myForm"> 
		<fieldset>
			<div id="pass">
				<H4>비밀번호 변경</H4>
				기존 비밀번호 : <input type="password" name="adminOriginalPass"/><br>
				새로운 비밀번호 : <input type="password" name="adminNewPass"/><br>
				비밀번호 재입력 : <input type="password" name="adminNewPass_re"/><br>
				<button id="adminPassChangeBtn">변경</button>
			</div>
		</fieldset>
	</form>
	
	<script>
		$('#adminPassChangeBtn').click(function(){
			
			var adminOriginalPass = $('input[name=adminOriginalPass]').val();
			var adminNewPass = $('input[name=adminNewPass]').val();
			
			$.ajax({
				url : "/admin/adminPasswordChange.do",
				data : {"adminOriginalPass" : adminOriginalPass, "adminNewPass" : adminNewPass},
				type : "POST",
				success : function(result){
					if(result == 'true')
					{
						alert('비밀번호 변경 성공');
					}else{
						alert('비밀번호 변경 실패 -기존 비밀번호 재확인 바랍니다.');
					}
					$('#pass>input').val('');
				},
				error : function(){
					console.log('ajax 통신 실패');
				}
			});
			
		});
	</script>
	
	<a href="/">메인 페이지로</a>
	
</body>
</html>