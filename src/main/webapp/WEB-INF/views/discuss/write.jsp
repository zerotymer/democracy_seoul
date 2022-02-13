<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>민주주의 서울 - 시민토론 게시글 작성</title>

	<link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">

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
        
        .upload{
            margin-bottom: 60px;
            width:100%;
            position:relative;
        }
        
        .file{
            width:100px;
            position:absolute;
            opacity: 0;
        }
        .thumbnail{
            left:0px;
        }
        .pdf{
            right:0px;
        }
        
        .iconImg{
            position:absolute;
            left:5%;
            z-index: -1;
            display: flex;
            flex-direction:column;
        }
        .iconPdf{
            position:absolute;
            right:5%;
            z-index: -1;
            display: flex;
            flex-direction:column;
        }
        .icon{
            margin:auto;
        }
    </style>

</head>
<body>

	<header>
        <%@ include file="/includes/header.jsp" %>
    </header>

	<section class="inner">
    <form name="writeForm" method="post" action="/discuss/write.do">
        <div>
        <div class="title">
            <input type="text" name="title" class="write" placeholder="제목을 입력하세요."/>
        </div>
        
        <div class="upload">
            <div class="thumbnail file">
                <input id="thumbnail" name="discussThumbnailPath" type="file"/>
                <input id="fileName" name="discussThumbnailName" type="hidden"/>
            </div>
            <div class="iconImg">
                <div class="icon">
                    <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M7 19L12 14L13.88 15.88C13.33 16.79 13 17.86 13 19H7M10 10.5C10 9.67 9.33 9 8.5 9S7 9.67 7 10.5 7.67 12 8.5 12 10 11.33 10 10.5M13.09 20H6V4H13V9H18V13.09C18.33 13.04 18.66 13 19 13C19.34 13 19.67 13.04 20 13.09V8L14 2H6C4.89 2 4 2.9 4 4V20C4 21.11 4.89 22 6 22H13.81C13.46 21.39 13.21 20.72 13.09 20M18 15V18H15V20H18V23H20V20H23V18H20V15H18Z" />
                    </svg>
                </div>
                <button class="label uploadImg">썸네일 업로드</button>
            </div>
            <div  class="pdf file">
                <input id="pdf" name="pdf" type="file"/>
                <input id="hiddenFile" name="fileName" type="hidden"/>
            </div>
            <div class="iconPdf">
                <div class="icon">
                    <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M14,2L20,8V20A2,2 0 0,1 18,22H6A2,2 0 0,1 4,20V4A2,2 0 0,1 6,2H14M18,20V9H13V4H6V20H18M12,12L16,16H13.5V19H10.5V16H8L12,12Z" />
                    </svg>
                </div>
                <button class="label uploadPdf">파일 업로드</button>
            </div>
	    </div>
        </div>
        
    <form name="writeForm" method="post" action="/discuss/write.do">        
        <div class="content">
            <textarea id="editor" name="content" class="write"></textarea>
        </div>
        </div>
        <div>
            <input type="submit" value="완료" class="btn">
        </div>
    </form>
    </section>

	<footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>

<!-- JQuery Library -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!-- ckEditor Library -->
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>

<!-- 에디터에 삽입한 이미지 미리보기 -->
<script>

	$("#uploadImg").click(function(){
		var file = document.getElementById('thumbnail');
		if(file.files.length === 0){
		    alert("이미지 파일을 선택해주세요");
		    return;
		}
		const formdata = new FormData();
		formdata.append('img', file.files[0])
		
		$.ajax({
			url: "/discuss/thumbnailUpload.ajax",
			type:"post",
			data: formdata,
			processData: false,
		    contentType: false,
			success: function(data){
				var json = JSON.parse(data);
				document.getElementById('thumbnail').value = json.imgUrl;
				$('#fileName').val(json.fileName);
				alert("업로드 성공");
			}
		});
	});
	
	$("#uploadPdf").click(function(){
		var file = document.getElementById('pdf');
		if(file.files.length === 0){
		    alert("파일을 선택해주세요");
		    return;
		}
		const formdata = new FormData();
		formdata.append('img', file.files[0])
		
		$.ajax({
			url: "/discuss/thumbnailUpload.ajax",
			type:"post",
			data: formdata,
			processData: false,
		    contentType: false,
			success: function(data){
				var json = JSON.parse(data);
				document.getElementById('thumbnail').value = json.imgUrl;
				$('#fileName').val(json.fileName);
				alert("업로드 성공");
			}
		});
	});

    ClassicEditor
	    .create( document.querySelector( '#editor' ), {
	        ckfinder: {
	            uploadUrl: '/ajax/imageUpload.do'
	        }
	    })
        .catch( error => {
            console.error( error );
        } );
</script>
</body>
</html>