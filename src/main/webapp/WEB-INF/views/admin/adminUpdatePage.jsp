<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 마이페이지</title>

<style>
        .wrapper{
            width: 100%;
            height: 740px;
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
                	관리자 등급 &nbsp; ${sessionScope.admin.adminGrade != "1" ? "최고 관리자" : "일반 관리자"} <br>
                	ID &nbsp; ${sessionScope.admin.adminId }<br>
					이름 &nbsp; ${sessionScope.admin.adminName }<br>
            </div>
            <div class="enter">
		                비밀번호 <input type="password" size="12"/><br>
		                비밀번호 재확인 <input type="password" size="12"/><br>
		         <input type="reset" value="취소"/><input type="submit" value="완료"/><br><br>
		         <button><a href="/admin/adminLogout.do">로그아웃</a></button><br>
		         <input type="button" value="탈퇴" id="withDrawBtn"/>
            </div>
        </div>
    </div>
    
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