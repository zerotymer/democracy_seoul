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
        
        .stateChangeBtn{
        	width: 100%;
            height: 100%;
        }
        .writeBtn{
        	width: 30px;
            height: 30px;
        }
    </style>

</head>
<body>

<div class="wrapper">
    <div class="menu">
        <div class="main_logo">
            <img src="/resources/images/admin/adminmain_logo.png">
        </div>
        
        <!-- 사이드 메뉴바 -->
        <div class="menu_bar">
            <div class="menu_bar_memberMNGM">
                <div class="menu_bar_inner">
                    MEMBER<br>
                    <a href="/admin/allMemberList.do">
                		- 회원관리
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
    
    <!-- 메뉴 상단 -->
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
        
        <!-- 게시판 내용 -->
        <div class="board">
            <div class="board_content">
				<form action="/notice/noticeWrite.do" method="post">
			 		<input type="text" name="noticeTitle" placeholder="제목을 작성하세요"/>
			    	<textarea name="noticeContent" id="editor" placeholder="내용을 작성하세요"></textarea>
			    	<input type="submit" value="작성"/>
			    </form>
			    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
			    <script>
			        ClassicEditor
			            .create( document.querySelector( '#editor' ), {
			                ckfinder: {
			                    uploadUrl: '/ckeditor/imgUpload.do'
			                }
			            })
			            .catch( error => {
			                console.error( error );
			            });
			    </script>
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



</body>
</html>