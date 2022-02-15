<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/noticeNewsContent.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>







	<div id="wrap">   
		<!-- header -->

		<div id="content">
			<div class="box-title">
				<p class="tit-small"></p>
				<p class="tit-big">공지사항</p>
			</div>
         	
         	<div class="box-notice">
	         	<div class="notice-top">
	         		<div class="box-subject">
	         			<p>${board.noticeNewsTitle}</p>
	         		</div>
	         		   <div class="box-notice-info">
	         			   <div class="box-gray">조회수</div>
	         		    	<span>0</span>
	         		</div>
	         			<div class="box-notice-info">
	         			<div class="box-gray">작성일</div>
	         			<span>${board.noticeNewsDate }</span>
	         		</div>
	         	</div>
	         	   <div class="box-content">
	         		<p>${board.noticeNewsContent}</p>
	         	</div>
         	</div>
         	<div class="box-button">
         		<button class="btn-m">
	         		<a href="/board/goNoticeNews.do?currentPage=${currentNo}">목록</a>
	         	</button>
         	</div>
		</div>

	</div>
	
</body>
</html>