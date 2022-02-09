<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>소식</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/resources/style/member/noticeNews.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>

<body>


   <div id="wrap">
   
      <!-- header -->

      <div id="content">
         <div class="box-title">
            <p class="tit-small"></p>
            <p class="tit-big">소식</p>
         </div>
         
         <div class="notice-top">
         	 <div class="box-button">
				<button class="btn-notice">
					<a href="/views/notice/noticeNewsAllSelect.do">공지사항</a>
				</button>
				<button class="btn-campaign">
					<a href="/notice/noticeCampaignAllSelect.do">캠페인 안내</a>
				</button>
			 </div>
		 </div>
		
		<div class="area-notice">
			<div class="box-search">
				<form action="/notice/noticeNewsSearch.do" method="get"><!--공지사항 검색기능-->
					<div class="select-search">
						<select name="type">
							<option value="subject">글제목</option>
							<option value="content">글내용</option>
							<option value="all">제목+내용</option>
						</select>
						<i class="fas fa-chevron-down icon-arrow"></i>
					</div>
					<div class="input-search">
						<i class="fas fa-search icon-search"></i><!--/// 검색 기능 출발점 (1) ///-->
						<input type="text" name="keyword" placeholder="검색어을 검색하세요">
					</div>
					<input type="submit" class="btn-rec" value="검색">
				</form>
			 </div>        
	         <div class="container">
			    <table>
			        <thead>
			            <tr>
			                <th width="100">번호</th>
			                <th width="400">제목</th>
			                <th width="100">조회수</th>
			                <th width="100">작성자</th>
			                <th width="150">작성일</th>
			            </tr>
			        </thead>
			        <tbody>		        
			            <tr>
			                <td>(게시물 고유번호)</td>
			                <td><div class="text-ellipsis subject"><a href="/notice/noticeNewsSelectContent.do?noticeNo=(게시물고유번호)&currentPage=(최근페이지)">(제목)</a></div></td><!-- 누르면 이동하게 -->
			                <td>(조회수)</td>
			                <td>(작성자)</td>
			                <td><(작성일)</td>
			            </tr>
			        </tbody>
			    </table>
			
			    <div id="page_wrap">
					<ul class="page_ul">
					<li></li>
	 				</ul>
			    </div>
			</div>
		</div>
		
      </div>
      
      <!-- footer -->
   </div>

</body>
</html>