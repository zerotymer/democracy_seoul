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
<title>관리자 마이페이지</title>

<style>
        .wrapper{
            width: 100%;
            height: 1000px;
            background-color: #3F51B5;
            box-sizing: border-box;
            display: flex;
        }
        .login_form{
            width: 350px;
            height: 700px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        .image{
            width : 250px;
            height: 100px;
            margin: 30px 50px 200px 50px;
            text-align: center;
        }
        .image>img{
            display: block;
            margin: auto;
        }
        .update{
            width: 200px;
            height: 150px;
            position: absolute;
            margin: 115px 140px 0px 140px;
            color: #8C8C8C;
        }
        .enter{
            width: 280px;
            height: 280px;
            position: absolute;
            margin: 250px 0px 50px 60px;
            padding: 30px 0px 0px 30px;
        }
        .enter>input{
            
        }
    </style>

</head>
<body>
	
	<div class="wrapper">
        <div class="login_form">
            <div class="image">  
            <img src="/resources/images/admin/adminmain_logo.png"> 
            </div>
            <div class="update">
                <H3>정보수정</H3>
                	관리자 등급 &nbsp; ${sessionScope.admin.adminGrade} <br>
                	ID &nbsp; ${sessionScope.admin.adminId }<br>
					이름 &nbsp; ${sessionScope.admin.adminName }<br>
            </div>
            <div class="enter">
            
            	<form id="myForm" action="/admin/adminUpdate.do" method="post"> 
					<fieldset>
						<H4>이메일 변경</H4>
						<input type="text" name="email" placeholder="${sessionScope.admin.adminEmail }"/><br>
						<input type="reset" value="취소"/><input type="submit" value="변경"/>
					</fieldset>
				</form>
				
				<div id="pass">
					<fieldset>
					<H4>비밀번호 변경</H4>
						<input type="password" name="adminOriginalPass" placeholder="기존 비밀번호"/><br>
						<input type="password" name="adminNewPass" placeholder="변경 비밀번호"/><br>
						<input type="password" name="adminNewPass_re" placeholder="변경 비밀번호 재입력"/><br>
						<input type="reset" value="취소"/><input type="button" id="adminPassChangeBtn" value="변경"/>
					</fieldset>
				</div>
		         
		         <button><a href="/admin/adminLogout.do">로그아웃</a></button><br>
		         <input type="button" value="탈퇴" id="withDrawBtn"/>
            </div>
        </div>
    </div>
    
    
    
    
    <!-- 비밀번호 변경 -->
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
    
    
    
    
    
    <!-- 탈퇴 버튼 활성화 -->
    <script>
	    $('#withDrawBtn').click(function () {
	    	
	        if (window.confirm("관리자 '${sessionScope.admin.adminId }'님<br>탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴 후 데이터 복구는 불가능합니다.")) {
	            location.replace("/admin/adminWithDraw.do");
	        } else {
	            alert('탈퇴를 취소하였습니다.');
	        }
	
	    });
    </script>
	
</body>
</html>