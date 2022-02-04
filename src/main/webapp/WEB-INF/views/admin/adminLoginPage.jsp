<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

<style>
        .wrapper{
            width: 100%;
            height: 600px;
            background-color: #3F51B5;
            box-sizing: border-box;
            display: flex;
        }
        .login_form{
            width: 300px;
            height: 400px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        .image{
            width : 200px;
            height: 85px;
            margin: 30px 50px 200px 50px;
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
            margin: 140px 110px 200px 110px;
        }
        .img_admin_icon>img{
            width: 100%;
            height: 100%;
        }
        .text{
            width: 120px;
            height: 40px;
            text-align: center;
            position: absolute;
            margin: 200px 90px 50px 90px;
            color: #8C8C8C;
        }
        .enter{
            width: 230px;
            height: 100px;
            position: absolute;
            margin: 260px 0px 50px 60px;
        }
        .enter>input{
            text-align: center;
        }
    </style>

</head>
<body>

	<div class="wrapper">
        <div class="login_form">
            <div class="image">  
            <img src="/src/main/webapp/resources/images/adminmain_logo.png"> 
            </div>
            <div class="img_admin_icon">  
            <img src="/src/main/webapp/resources/images/admin_icon.png">
            </div>
            <div class="text">
            <H3>관리자 로그인</H3>
            </div>
            <div class="enter">
                <form id="adminLoginForm" action="/admin/adminLogin.do" method="post">
                	아이디 &nbsp;&nbsp; <input type="text" size="15"/><br>
               		비밀번호 <input type="password" size="15"/>
            		<input type="submit" value="로그인"/>
            	</form>
            </div>
        </div>
    </div>

</body>
</html>