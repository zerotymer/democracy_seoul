<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

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

	<!-- 관리자 회원 가입  -->
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
	
	<a href="/admin/adminLoginPage.jsp">메인 페이지</a>
	
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
	
	
	<!-- 가입 유효성 검사 -->
	<script>

            var message = document.getElementById("message");
            
            var adminId = document.getElementById("adminId");
            var adminPwd = document.getElementById("adminPwd");
            var adminPwd_re = document.getElementById("adminPwd_re");
            var adminName = document.getElementById("adminName");
            
            var email1 = document.getElementById("email1");
            var email2 = document.getElementById("email2");


        function check() {
			
        	if (!(/^[a-z][a-z0-9]{8,10}$/.test(adminId.value))) //아이디 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※아이디는 영문 소문자,숫자 8~10 글자 이내로 입력";
                return false;
                
            } 
			else if (!(/[a-zA-Z0-9]{8,12}$/.test(adminPwd.value))) //비밀번호 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※비밀번호는 소문자,대문자,숫자를 포함한 8~12 글자 이내로 입력";
                return false;
                
            } 
			else if (!(adminPwd.value == adminPwd_re.value)) //PW와 PW_RE 비교 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※비밀번호가 일치하지 않습니다.";
                return false;
       			
            }
			else if (!(/[가-힣]+$/.test(adminName.value))) //이름 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※이름은 한글(최소1글자)만 가능합니다.";
                return false;
                
            }
			else if (!(/^[a-z0-9]{4,12}/).test(email1.value)) //이메일 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※이메일을 재확인해주세요.";
                return false;
            } 	
			else{
            	return true;	
            }
            
            
        }

    </script>

</body>
</html>