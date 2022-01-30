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
            width: 400px;
            height: 500px;
            background-color: white;
            margin: auto;
            border-radius: 2em;
            box-shadow: 7px 7px 2px 1px rgba(0, 0, 0, .2);
            display: flex;
        }
        .image{
            width : 250px;
            height: 100px;
            margin: 30px 100px 200px 100px;
            text-align: center;
        }
        .image>img{
            display: block;
            margin: auto;
        }
        .update{
            width: 80px;
            height: 40px;
            position: absolute;
            margin: 115px 160px 0px 160px;
            color: #8C8C8C;
        }
        .enter{
            width: 280px;
            height: 280px;
            position: absolute;
            margin: 180px 0px 50px 60px;
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
            <img src="/src/main/webapp/WEB-INF/image/main_logo.png"> 
            </div>
            <div class="update">
                <H3>정보수정</H3>
            </div>
            <div class="enter">
                등급 <input type="text" placeholder="최고관리자" size="8"/><br>
                아이디 <input type="text" placeholder="superadmin" size="8"/><br>
                비밀번호 <input type="password" size="12"/><br>
                비밀번호 재확인 <input type="password" size="12"/><br>
            </div>
        </div>
    </div>
	
</body>
</html>