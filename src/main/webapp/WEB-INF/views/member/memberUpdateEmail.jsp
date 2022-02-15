<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 변경 및 인증</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/memberJoinus.css">
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<body>

<script>
		let val = false;	
	 
		 <!--이메일인증 검사 -->
		 function Validation(){		 
		        var eRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 유효성검사
		        var objEmail = document.getElementById("email");//메일
		        
		        // ================ email 유효성검사 ================readonly/ //
		        if(eRegExp.value == ''){ // 이메일 입력여부 검사
		            alert("이메일을 입력해주세요.");
		            return false;
		        }
		        
		        if(!eRegExp.test(objEmail.value)){ //이메일 유효성 검사
		            alert("올바른 이메일 형식이 아닙니다.");
		            return false;
		        }
		        
		        if(!val){
		        	alert("인증 실패.");
		        	return false;
		        }			 
		 }
		  
		 function sendEmail(){
			 //alert('확인');
			
			 const m= document.getElementById('email').value;//이메일 가져오고
			 fetch("http://localhost/member/memberSendEmail.do?email="+m).then((response)=>
					console.log(response)		 
			 
			 );
			 alert('인증 이메일이 전송되었습니다.');
			 
			 
		 }
		 
		 function checkNum(){
			  //alert('확인')
			  $.ajax({
					type : "GET",
					url : "get.do",
					data : {
					
					},
					error : function(error) {
						console.log("error");
					},
					success : function(data) {
						console.log("success");
						 const checkNum = data;
						 const m= document.getElementById('emailRe').value;
						 console.log(checkNum)
						 if(m==checkNum){
							 val =true;
							 alert("일치");
						 }
						 else{
							 alert("불일치");
						 }
					}
				});
		 }
		 
		 
		 </script>

	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/member/goMemberUpdateEmail.do">이메일 변경</a>
			</div>
			<form action="/member/memberUpdateEmail.do" onsubmit="return Validation();" method="post">
					<span id="memberEmail">${sessionScope.user.email }</span>					 			
					<label for="email" class="tit-label">에서 변경하실 이메일을 입력하시고 인증해주세요.</label><br>
					<input type="email" id="email" class="input-style" name="email" placeholder="새로운 이메일을 입력해주세요."><button type="button" onclick='sendEmail()'>인증메일 발송하기</button><br>
					<span id="emailCheck" class="check-msg"></span><br>		
				    <input type="text" class="input-style" id="emailRe" name="emailRe" placeholder="이메일 인증번호를 입력해주세요."><br>
				    <button type="button" onclick='checkNum()'>인증번호 확인</button><br>
				    <input type="submit" class="btn-submit" value="인증완료">		
			</form>
			<a href="/">메인으로 가기</a>
		</div>
	</div>
	
	
	<script>
			
			$("#email").blur(function() {
				var email = $("#email").val();
			    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			    
			    if(!getMail.test($("#email").val())){
					$("#emailCheck").html("올바른 이메일 형식이 아닙니다.").css("color","red");
			        return false;
			      }
			    
				
				$.ajax({ 
					url: "/member/memberEmailCheck.do",
					data: {"email":email},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#emailCheck").html("중복되는 이메일입니다.다시 입력해주세요.").css("color","red");
							$("#email").val('');
							return false;
						}else{
							$("#emailCheck").html("사용 가능한 이메일입니다.").css("color","blue");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	
</body>
</html>