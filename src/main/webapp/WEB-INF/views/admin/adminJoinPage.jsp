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
<title>관리자 로그인</title>

<style>
        .wrapper{
            width: 100%;
            height: 1000px;
            background-color: #3F51B5;
            box-sizing: border-box;
            display: flex;
        }
        .login_form{
            width: 500px;
            height: 950px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        #joinform{
        	 width: 305px;
            height: 591px;
        }
        .image{
            width : 250px;
            height: 90px;
            margin: 30px 125px 200px 125px;
            text-align: center;
        }
        .image>img{
            display: block;
            margin: auto;
        }
        .img_admin_icon{
            width: 70px;
            height: 70px;
            position: absolute;
            margin: 145px 215px 200px 215px;
        }
        .img_admin_icon>img{
            width: 100%;
            height: 100%;
        }
        .text{
            width: 150px;
            height: 40px;
            text-align: center;
            position: absolute;
            margin: 210px 175px 50px 175px;
            color: #8C8C8C;
        }
        .enter{
            width: 300px;
            height: 300px;
            position: absolute;
            margin: 260px 0px 50px 80px;
        }
        .enter>input{
            text-align: center;
        }
        a{
        	text-decoration:none;
        	color : white;
        }
        a:hover{
        	color : white;
        }
        .button{
        	width: 305px;
        	text-align: center;
        }
    </style>

</head>
<body>

	<div class="wrapper">
        <div class="login_form">
            <div class="image">  
            <img src="/resources/images/admin/adminmain_logo.png"> 
            </div>
            <div class="img_admin_icon">  
            <img src="/resources/icons/admin_icon.png">
            </div>
            <div class="text">
            <H5>관리자 로그인</H5>
            </div>
            
            
            <div class="enter">
                <form action="/admin/adminJoin.do" method="post" id="joinForm" onsubmit="return mustHave();">
						아이디 <input class="form-control form-control-sm" type="text"  name="adminId" id="adminId" placeholder="아이디" maxlength="12" >
							<p style="font-size: 0.8em; color: darkgray;">아이디는 영문 소문자,숫자 8~10 글자 이내로 입력하세요.</p>
							<button type="button" class="btn btn-outline-primary col-12 mx-auto"" id="adminIdCheckBtn">중복체크</button><br><br>
							
						비밀번호  <input class="form-control form-control-sm" type="password"  name="adminPwd" id="adminPwd" placeholder="비밀번호" maxlength="12" >
							<p style="font-size: 0.8em; color: darkgray;">소문자,대문자,숫자를 포함한 8~12 글자 이내로 입력하세요.</p>
							
						비밀번호 재입력  <input class="form-control form-control-sm" type="password" name="adminPwd_re" id="adminPwd_re" placeholder="비밀번호 재입력" maxlength="12" >
							<p style="font-size: 0.8em; color: darkgray;">동일한 비밀번호를 한 번 더 입력하세요.</p>
							
						이름  <input class="form-control form-control-sm" type="text" name="adminName" id="adminName" placeholder="이름 입력" maxlength="5" ><br>
							
						이메일  <input class="form-control form-control-sm" type="text" name="adminEmail" id="adminEmail" placeholder="이메일 입력" maxlength="40" ><br>
						
						<span id="message" style="font-size: 0.8em;"></span><br>
						
						<div class="button">
							<button type="reset" class="btn btn-outline-warning col-5 mx-auto" id="reset">취소</button>
							<button type="submit" class="btn btn-outline-primary col-5 mx-auto" id="reset">가입</button>
						</div>
				</form>
				
				<div class="button">
					<button class="btn btn-primary col-12 mx-auto" type="submit"><a href="/admin/adminMain.do">메인 페이지</a></button>
				</div>
            </div>
			
            
        </div>
    </div>
    
    <!-- ID 중복 체크 -->
    <script>
		$('#adminIdCheckBtn').click(function(){
			var adminId = $('input[name=adminId]').val();
			
			$.ajax({
				url : "/admin/adminIdCheck.do",
				data : {"adminId" : adminId},
				type : "get",
				success : function(result){
					if(result == "true")
					{
						alert('[' + adminId + ']사용 불가능한 아이디');
					}else{
						alert('[' + adminId + ']사용 가능한 아이디');
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
            var adminEmail = document.getElementById("adminEmail");


        function check() {
			
        	if (!(/^[a-z][a-z0-9]{7,9}$/.test(adminId.value))) //아이디 검사
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
				console.log(adminPwd.value);
				console.log(adminPwd_re.value);
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
    
    <!--submit 이동 시 이벤트 -->
	<script>

		function mustHave(){
			
			return check();
			
		}
	</script>
	

</body>
</html>