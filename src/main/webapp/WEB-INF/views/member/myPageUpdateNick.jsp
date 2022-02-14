<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지 닉네임 변경</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/common.css">
<link rel="stylesheet" href="/resources/style/member/memberSearchId.css">
</head>



<body>
	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/member/goMemberUpdateNick.do"><H1>닉네임 변경</H1></a>
			</div>
			<form action="/member/myPageUpdateNick.do" method="get">
                <input type="text" id="nick" class="input-style" name="nick" placeholder="변경하실 닉네임입력"><br>
				<span id="nickCheck" class="check-msg"></span><br>
				<input type="submit" id="updateNick" onclick="submitUpdateNick();" class="btn-searchId" value="변경">
			</form>
			<a href="/">메인으로 가기</a>
		</div>
	</div>
	

	
	<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<!-- nick 중복 체크 -->
	<script>
			
			$("#nick").blur(function() {
				var nick = $("#nick").val();
			    var n_RegExp= RegExp(/^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/);
			    
			    
		        if(!n_RegExp.test($("#nick").val())){ 
					$("#nickCheck").html("닉네임을 2~16자의 숫자,한국어,영어,'_'로 입력해주세요.").css("color","red");
			        $("#nick").focus();
		            return false;
		        }


				
				$.ajax({ 
					url: "/member/memberNickCheck.do",
					data: {"nick": nick},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#nickCheck").html("중복되는 닉네임입니다.").css("color","red");
							$("#nick").val('');
							return false;
						}else{
							$("#nickCheck").html("중복되지 않는 닉네임입니다.").css("color","blue");

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