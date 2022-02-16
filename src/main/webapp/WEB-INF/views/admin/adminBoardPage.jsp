<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 게시판 페이지</title>

    <style>
        .wrapper {
            width: 100%;
            height: 800px;
        }

        .menu {
            width: 200px;
            height: 780px;
            background-color: #3F51B5;
            float: left;
            
        }

        .main_logo {
            width: 100%;
            height: 120px;
            display: block;
            margin: auto;
            text-align: center;
            box-sizing: border-box;
            padding: 20px;
            float: left;
        }

        .menu_bar_memberMNGM {
            width: 100%;
            height: 400px;
            margin: 110px 0px 200px 0px;
            padding: 10px;
        }

        .menu_bar_inner {
        	padding: 20px;
            width: 100%;
            height: 100px;
            color: white;
        }

        .notice {
            width: 100%;
            height: 30px;
            word-spacing: -0.8px;
        }
        .notice:hover {
            cursor: pointer;
        }

        #content {
            float: left;
            width: 1015px;
            height: 600px;
        }

        .info {
            background-color: #3F51B5;
            width: 1320px;
            height: 80px;
            float: left;
            padding: 15px;
        }

        .menu_info {
            width: 20%;
            height: 100%;
            color: white;
            padding: 20px;
            float: left;
        }

        .admin_info {
            float: right;
            width: 15%;
            height: 100%;
            margin: 0px auto;
            text-align: center;
            color: white;
        }

        .admin_info:hover {
            cursor: pointer;
        }

        .admin_icon {
            width: 45px;
            height: 45px;
            float: left;
            margin : 10px 0px 0px 0px;
        }

        .admin_icon > img {
            width: 100%;
            height: 100%;
        }
		.admin_idarea{
			display : inline-block;
			margin : 15px;
			float: left;
			font-size : 1.2em;
		}
        .board {
            background-color: #EAEAEA;
            padding: 10px;
            float: left;
            width: 1320px;
            height: 700px;
        }

        .board_content {
            background-color: white;
            width: 100%;
            height: 100%;
            padding: 20px;
        }
        
        .stateChangeBtn{
        	width: 100%;
            height: 25px;
            margin : 0px;
        }
        .size{
			word-spacing: -0.8px;
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
    <div class="menu">
        <div class="main_logo">
            <img src="/resources/images/admin/adminmain_logo.png">
        </div>
        <div class="menu_bar">
            <div class="menu_bar_memberMNGM">
            	<br>
                <div class="menu_bar_inner">
                    MEMBER<br>
                    <a href="/admin/allMemberList.do">
                		<div class="size">- 회원관리</div>
                	</a>
                </div>
                <div class="menu_bar_inner">
                    BOARD
                    <a href="/notice/allMemberList.do">
                    	<div class="notice">- 공지사항</div>
                    </a>
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
                <a href="/admin/adminUpdatePageMove.do">
                    <div class="admin_icon">
                        <img src="/resources/icons/admin_icon.png">
                    </div>
                    <div class="admin_idarea">
                    	<a href="/admin/adminUpdatePageMove.do">
                    		${sessionScope.admin.adminId }
                    	</a>
                    </div>
                </a>
            </div>
        </div>
        <div class="board">
            <div class="board_content">

                <c:choose>
                    <c:when test="${!requestScope.list.isEmpty() }">

                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">ID</th>
                                <th scope="col">이름</th>
                                <th scope="col">닉네임</th>
                                <th scope="col">이메일</th>
                                <th scope="col">가입일</th>
                                <th scope="col">탈퇴버튼</th>
                            </tr>
                            </thead>


                            <tbody>
                            <c:forEach items="${requestScope.list }" var="m" varStatus="i">
                                <tr>
                                    <th scope="row">${(i.count) + (requestScope.countResult) }</th>
                                    <td>${m.userId }</td>
                                    <td>${m.userName }</td>
                                    <td>${m.nick }</td>
                                    <td>${m.email }</td>
                                    <td>${m.enrollDate }</td>
                                    <td>
                                    	<button type="button" class="btn btn-secondary gap-2 col-6 mx-auto" onclick="endYnChange(this)"
                                                data="${m.userId }">${m.endYN }</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </c:when>

                    <c:otherwise>
                        <H3>저장된 회원 리스트가 없습니다.</H3>
                    </c:otherwise>

                </c:choose>

                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                    	<c:if test="${ preNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/admin/allMemberList.do?currentPage=${ preNavi }" tabindex="-1" aria-disabled="true"><<</a> <!-- a href=안이 맞나 확인하기 -->
	                        </li>
                        </c:if>
                        <c:forEach items="${ requestScope.navi }" var="m" varStatus="i">
	                        <li class="page-item">
	                        	<a class="page-link" href="/admin/allMemberList.do?currentPage=${ m }">${ m }</a>
	                        </li>
                        </c:forEach>
                        <c:if test="${ nextNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/admin/allMemberList.do?currentPage=${ nextNavi }">>></a>
	                        </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>        
        
        
        
<!-- 탈퇴 버튼 변경 ajax -->
<script>
	function endYnChange(element) {
		var endYN = element.innerText;
		$.ajax({
            url: "/admin/memberEndYNChange.do",
            data: {
            	"userId": element.getAttribute('data'), 
            	"endYN": endYN
            },
            type: "post",
            success: function (result) {
				if (result) {
					element.innerText = (endYN == 'Y') ? 'N' : 'Y';
				} else {
					alert('문제발생');
				}
            },
            error: function () {
                console.log('ajax 통신 문제 발생');
            }
        });
	}
    
</script>


</body>
</html>