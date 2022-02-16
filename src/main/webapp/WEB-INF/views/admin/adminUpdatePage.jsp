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
            width: 400px;
            height: 650px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        .image{
            width : 250px;
            height: 100px;
            margin: 35px 75px 200px 75px;
            text-align: center;
        }
        .image>img{
            display: block;
            margin: auto;
        }
        .update{
            width: 300px;
            height: 150px;
            position: absolute;
            margin: 140px 0px 0px 65px;
            color: #8C8C8C;
            padding : 0px 0px 0px 70px;
        }
        .enter{
            width: 280px;
            height: 280px;
            position: absolute;
            margin: 230px 0px 50px 60px;
            padding: 10px 0px 0px 20px;
        }
        fieldset{
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
            <div class="update">
                	등급 &nbsp; ${sessionScope.admin.adminGrade = '1' ? "최고 관리자" : "일반 관리자"} <br>
                	ID &nbsp; ${sessionScope.admin.adminId }<br>
					이름 &nbsp; ${sessionScope.admin.adminName }<br>
            </div>
            <div class="enter">
				
				<div id="pass">
					<fieldset>
					<H5>비밀번호 변경</H5>
						<input class="form-control form-control-sm" type="password"  name="adminOriginalPass" placeholder="기존 비밀번호" maxlength="12" ><br>
						<input class="form-control form-control-sm" type="password"  name="adminNewPass" placeholder="변경 비밀번호" maxlength="12" ><br>
						<input class="form-control form-control-sm" type="password"  name="adminNewPass_re" placeholder="변경 비밀번호 재입력" maxlength="12" ><br>
						<button type="reset" class="btn btn-outline-warning col-5 mx-auto">취소</button> <button type="button" id="adminPassChangeBtn" class="btn btn-outline-primary col-5 mx-auto">변경</button>
					</fieldset>
				</div>
		         
		         <br>
			         <div class="button">
				         <button class="btn btn-primary col-12 mx-auto" type="button"><a href="/admin/adminLogout.do">로그아웃</a></button><br>
				         <button type="button" id="withDrawBtn" class="btn btn-dark col-12 mx-auto">탈퇴</button>
				      </div>
		         </div>
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