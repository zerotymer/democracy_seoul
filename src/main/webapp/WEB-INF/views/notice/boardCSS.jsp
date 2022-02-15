<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 게시판 페이지</title>

<style>
        .wrapper{
            width: 100%;
            height: 600px;
        }
        .menu{
            width: 200px;
            height: 600px;
            background-color: #3F51B5;
            float: left;
        }
        .main_logo{
            width: 100%;
            height: 100px;
            display: block;
            margin: auto;
            text-align: center;
            background-color: white;
            box-sizing: border-box;
            padding: 7px;
            float: left;
        }
        .menu_bar_memberMNGM{
            width: 100%;
            height: 400px;
            margin: 110px 0px 200px 0px;
            padding: 10px;
        }
        .menu_bar_inner{
            width: 100%;
            height: 100px;
            color: white;
        }
        .notice{
            width: 100%;
            height: 30px;
        }
        #content{
            float: left;
            width: 1015px;
            height: 600px;
        }
        .info{
            background-color: #3F51B5;
            width: 100%;
            height: 100px;
            float: left;
            padding: 15px;
        }
        .menu_info{
            width: 20%;
            height: 100%;
            color: white;
            padding: 20px;
            float: left;
        }
        .admin_info{
            float: left;
            width: 20%;
            height: 100%;
            padding: 10px;
            margin: 0px 0px 0px 590px;
            text-align: center;
            color: white;
        }
        .admin_icon{
            width: 50px;
            height: 50px;
            float: left;
        }
        .admin_icon>img{
            width: 100%;
            height: 100%;
        }
        .board{
            background-color: #EAEAEA;
            padding: 10px;
            float: left;
            width: 100%;
            height: 500px;
        }
        .board_content{
            background-color: white;
            width: 100%;
            height: 90%;
            padding: 20px;
        }
        
    </style>

</head>
<body>
	
	<div class="wrapper">
        <div class="menu">
            <div class="main_logo">
                <img src="/src/main/webapp/WEB-INF/image/main_logo.png"/>
            </div>
            <div class="menu_bar">
                <div class="menu_bar_memberMNGM">
                    <div class="menu_bar_inner">
                        MEMBER<br>
                        - 회원관리
                    </div>
                    <div class="menu_bar_inner">
                        BOARD
                        <div class="notice">- 공지사항</div>
                        <div class="notice">- 게시판 관리</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="content">
            <div class="info">
                <div class="menu_info">
                    MEMBER > 회원관리
                </div>
                <div class="admin_info">
                    <div class="admin_icon">
                        <img src="/src/main/webapp/WEB-INF/image/admin_icon.png">
                    </div>
                    superadmin
                </div>
            </div>
            <div class="board">
                <div class="board_content">
                    <table class="table">
                      <thead>
                        <tr>
                          <th scope="col">No</th>
                          <th scope="col">ID</th>
                          <th scope="col">이름</th>
                          <th scope="col">탈퇴여부</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th scope="row">1</th>
                          <td>user11</td>
                          <td>홍길동</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">2</th>
                          <td>user22</td>
                          <td>김말똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">3</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">4</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">5</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">6</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">7</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">8</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                        <tr>
                          <th scope="row">9</th>
                          <td>user33</td>
                          <td>고길똥</td>
                          <td>N</td>
                        </tr>
                      </tbody>
                    </table>
                    
                    <nav aria-label="Page navigation example">
                      <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                          <a class="page-link" href="#" tabindex="-1" aria-disabled="true"><<</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item">
                          <a class="page-link" href="#">>></a>
                        </li>
                      </ul>
                    </nav>
            	</div>
                    
                </div>
            </div>
        </div>
    </div>
	
</body>
</html>