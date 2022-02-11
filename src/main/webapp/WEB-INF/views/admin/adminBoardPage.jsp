<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>


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
            height: 750px;
        }

        .menu {
            width: 200px;
            height: 600px;
            background-color: #3F51B5;
            float: left;
        }

        .main_logo {
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

        .menu_bar_memberMNGM {
            width: 100%;
            height: 400px;
            margin: 110px 0px 200px 0px;
            padding: 10px;
        }

        .menu_bar_inner {
            width: 100%;
            height: 100px;
            color: white;
        }

        .notice {
            width: 100%;
            height: 30px;
        }

        #content {
            float: left;
            width: 1015px;
            height: 600px;
        }

        .info {
            background-color: #3F51B5;
            width: 100%;
            height: 100px;
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
            float: left;
            width: 20%;
            height: 100%;
            padding: 10px;
            margin: 0px 0px 0px 590px;
            text-align: center;
            color: white;
        }

        .admin_info:hover {
            cursor: pointer;
        }

        .admin_icon {
            width: 50px;
            height: 50px;
            float: left;
        }

        .admin_icon > img {
            width: 100%;
            height: 100%;
        }
		.admin_idarea{
			display : inline-block;
		}
        .board {
            background-color: #EAEAEA;
            padding: 10px;
            float: left;
            width: 100%;
            height: 500px;
        }

        .board_content {
            background-color: white;
            width: 100%;
            height: 100%;
            padding: 20px;
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
                                    <th scope="row"><td>${i.count }</td></th>
                                    <td>${m.userId }</td>
                                    <td>${m.userName }</td>
                                    <td>${m.nick }</td>
                                    <td>${m.email }</td>
                                    <td>${m.enrollDate }</td>
                                    <td>
                                        <button style="width:100%" class="stateChangeBtn"
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
                    	<c:if test="${ preNavi } != 0">
	                        <li class="page-item">
	                            <a class="page-link" href="/admin/allMemberList.do?currentPage=${ preNavi }" tabindex="-1" aria-disabled="true"><<</a> <!-- a href=안이 맞나 확인하기 -->
	                        </li>
                        </c:if>
                        <c:forEach items="${ requestScope.navi }" var="m" varStatus="i">
	                        <li class="page-item">
	                        	<a class="page-link" href="/admin/allMemberList.do?currentPage=${ m }">${ m }</a>
	                        </li>
                        </c:forEach>
                        <c:if test="${ nextNavi } != 0">
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
<!-- 탈퇴 버튼 변경 ajax -->
<script>
    $('.stateChangeBtn').click(function () {

        var userId = $(this).attr('data');
        var endYN = $(this).html();


        $.ajax({
            url: "/admin/memberEndYNChange.do",
            data: {"userId": userId, "endYN": endYN},
            type: "post",
            context: this,
            success: function (result) {

                if (result != 'false') {
                    $(this).html(result);
                } else {
                    console.log("데이터 변경 실패");
                }

            },
            error: function () {
                console.log('ajax 통신 문제 발생');
            }
        })

    });
</script>


</body>
</html>