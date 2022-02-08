<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>민서네 시민토론 - 게시글 작성</title>

	<style>
        * {
            box-sizing: border-box;
        }
        
        body {
            width: 100%;
            margin: 0;
            padding: 0;
        }
        
        .inner {
            width: 70%;
            margin: 0 auto;
        }
        
        form>div{
            display:flex;
            flex-direction: column;
            gap: 20px;
        }
        
        .write {
            width:100%;
            margin:auto;
        }
        .title .write {
            padding:15px;
            border:1px solid rgba(200, 200, 180);
            border-radius:5px;
        	font-size:20px;
            font-weight:bold;
        }
        
        form>div:last-child{
            margin-top:20px;
        }
        .btn {
            width:60px;
            height:30px;
            margin:auto;
            border:1px solid rgba(210, 210, 190);
            border-radius:5px;
            background-color: rgba(230, 230, 220);
            font-size:15px;
        }
    </style>

</head>
<body>
	<section class="inner">
    <form name="writeForm" method="post" action="/discuss/write.do">
        <div>
	        <div class="title">
	            <input type="text" name="title" class="write" placeholder="제목을 입력하세요."/>
	        </div>
	        
	        <div class="content">
	            <textarea id="editor" name="content" class="write"></textarea>
	        </div>
        </div>
        
        <div>
            <input type="submit" value="완료" class="btn">
        </div>
    </form>
    </section>

<!-- JQuery Library -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!-- ckEditor Library -->
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ), {
        	filebrowserImageUploadUrl: '/webapp/upload'
        } )
        .catch( error => {
            console.error( error );
        } );
    </script>
</body>
</html>