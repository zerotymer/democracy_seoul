<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>시민제안 등록 | 민주주의 서울</title>
<link rel="stylesheet" href="/resources/style/header.css">
<link rel="stylesheet" href="/resources/style/footer.css">
<link rel="stylesheet" href="/resources/style/color.css">
<link rel="stylesheet" href="/resources/style/content-frame.css">
<link rel="stylesheet" href="/resources/style/card-container.css">
<link rel="stylesheet" href="/resources/style/list-frame.css">
<style>
body {
	background-color: var(- -COLOR-WHITE);
	margin: 0;
	/* no Scrollbar */
	-ms-overflow-style: none; /* IE and Edge */
	scrollbar-width: none; /* Firefox */
}

body::-webkit-scrollbar {
	display: none; /* Chrome, Safari, Opera*/
}

header {
	z-index: 10;
}

section {
	position: relative;
	width: 100%;
	min-height: 90vh;
	/* overflow: scroll; */
}
</style>

</head>
<body>
	<header>
		<%@ include file="/includes/header.jsp"%>
	</header>

	<section>

		<div class="content-frame">
			<div class="frame-image">
				<div class="inner">
					<h2>시민제안</h2>
				</div>
			</div>
			<div class="frame-menu">
				<div class="inner menubar">
					<ul>
						<li class="menubar-icon"><a href="/">
								<div class="icon home"></div>
						</a></li>
						<li class="menubar-list">
							<h3>
								참여하기<span class="slick-arrow"></span>
							</h3> <!-- Menu -->
							<ul class="include menu">
								<li class="menuitem"><a href="">참여하기</a>
									<ul class="submenu">
										<li><a href=""></a>시민제안</li>
										<li><a href=""></a>시민토론</li>
										<li><a href=""></a>서울시가 묻습니다</li>
									</ul></li>
								<li class="menuitem"><a href="">결과보기</a>
									<ul class="submenu">
										<li><a href="">제안결과</a></li>
										<li><a href="">공론결과</a></li>
									</ul></li>
								<li class="menuitem"><a href="">알아보기</a>
									<ul class="submenu">
										<li><a href="">민주주의 서울 <wbr />소개
										</a></li>
										<li><a href="" style="font-size: 13px;">민주주의 서울 <wbr />이야기
										</a></li>
										<li><a href="">공지사항</a></li>
										<li><a href="">자료실</a></li>
										<li><a href="">행사일정</a></li>
									</ul></li>
								<li class="menuitem"><a href="">서울시민회의</a>
									<ul class="submenu">
										<li><a href="">서울시민회의 <wbr />소개
										</a></li>
										<li><a href="">서울시민회의 <wbr />소식
										</a></li>
									</ul></li>
								<li class="menuitem"><a href="">시민참여예산</a></li>
							</ul>
						</li>
						<li class="menubar-list">
							<h3>
								시민제안<span class="slick-arrow"></span>
							</h3>
							<ul class="menu">
								<li class="menuitem"><a href="">시민제안</a></li>
								<li class="menuitem"><a href="">시민토론</a></li>
								<li class="menuitem"><a href="">서울시가 묻습니다.</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>



		<h1 style="text-align: center;">글쓰기</h1>







	<div>
			<br>
			<h1 style="text-align: center;">글쓰기</h1>
			<br>
			
			<div style="text-align: center;">

				<input type="text" name="sugTitle" class="title"placeholder="제목을 입력하세요"> <br>
				<hr width="800px">
		<div class="textBox">
				<textarea id="ckeditor" class="ckeditor" name="sugContent"></textarea>
		</div>
				
				<br>
				
			<button type="submit" class="commit" style="float: right;">	글작성</button>
	
	</div>
			
		



		</div>







	</section>

	<script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.ckeditor.com/ckeditor5/11.1.0/classic/ckeditor.js"></script>
	<script src="/resources/script/content-frame.js"></script>

	<script>
    
	
				  //글쓰기버튼
					$(document).ready(function(){    
					        $("#btnWrite").click(function(){
					            location.href="/suggest.do";
					        });
					});
    		</script>
</body>
<footer>
	<%@ include file="/includes/footer.jsp"%>
</footer>

<script src="/resources/script/header.js"></script>
<script src="/resources/script/content-frame.js"></script>
<script src="/resources/script/card-container.js"></script>
</body>
</html>