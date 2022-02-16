<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

<style>
		*{
			word-spacing: -0.6px;
		}
        .wrapper{
            width: 100%;
            height: 750px;
            background-color: #3F51B5;
            box-sizing: border-box;
            display: flex;
        }
        .login_form{
            width: 400px;
            height: 550px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        .image{
            width : 200px;
            height: 85px;
            margin: 30px 100px 200px 100px;
            text-align: center;
        }
        .image>img{
            display: block;
            margin: auto;
        }
        .img_admin_icon{
            width: 80px;
            height: 80px;
            position: absolute;
            margin: 140px 160px 200px 160px;
        }
        .img_admin_icon>img{
            width: 100%;
            height: 100%;
        }
        .text{
            width: 120px;
            height: 100px;
            text-align: center;
            position: absolute;
            margin: 230px 160px 50px 140px;
            color: #8C8C8C;
            font-size : 100%;
        }
        .enter{
            width: 230px;
            height: 100px;
            position: absolute;
            margin: 260px 85px 50px 85px;
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
            	관리자 로그인
            </div>
            
            <div class="enter">
                <form id="adminLoginForm" action="/admin/adminLogin.do" method="post">
                	아이디 <input class="form-control form-control-sm" type="text" name="adminId" size="12"  maxlength="12"><br>
               		비밀번호 <input class="form-control form-control-sm" type="password" name="adminPwd" size="12"  maxlength="12"><br>
               		<div class="d-grid gap-2 col-12 mx-auto">
               			<button type="submit" class="btn btn-outline-primary" size="20">로그인</button>
               		</div>
            	</form>
            	
            	<div class="d-grid gap-2 col-12 mx-auto">
            		<button type="button" class="btn btn-outline-info"><a href="/admin/adminJoinPage.do">회원가입</a></button>
            	</div>
            	
            </div>
            
        </div>
    </div>

	<!--부트스트랩 링크 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>

</body>
</html>