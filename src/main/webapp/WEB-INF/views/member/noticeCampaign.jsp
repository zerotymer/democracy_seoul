<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>행사일정</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/noticeCampaign.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>

<body>

   <div id="wrap">
   
      <!-- header -->

      <div id="content">
         <div class="box-title">
            <p class="tit-small"></p>
            <p class="tit-big">행사 소식</p>
         </div>
         
         <div class="notice-top">
         	 <div class="box-button">
				<button class="btn-campaign">
					<a href="/notice/noticeCampaignAllSelect.do">행사 안내</a>
				</button>
			 </div>
		 </div>
		
        <div class="area-campaign">
        	<div class="box-search">
				<form  action="/notice/noticeCampaignSearch.do" method="get">
					<div class="select-search">
						<select name="type">
							<option value="subject">글제목</option>
							<option value="content">글내용</option>
							<option value="all">제목+내용</option>
						</select>
						<i class="fas fa-chevron-down icon-arrow"></i>
					</div>
					<div class="input-search">
						<i class="fas fa-search icon-search"></i><!--/// 검색 기능 출발점2 ///-->
						<input type="text" name="keyword" placeholder="검색어을 검색하세요">
					</div>
					<input type="submit" class="btn-rec" value="검색">
				</form>
			 </div>
			 
			 <div class="box-campaign-list">	        
			 	<div class="box-campaign">
			 		<a href="/notice/CampaignContent.do?campaignNo=(게시글 번호)&currentPage=(최근페이지)"><!-- 누르면 이동 -->
			 			<div class="img-campaign">
				 			<img alt="" src="images">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>(제목)</p>
				 			<p>(등록일자)</p>
				 		</div>
			 		</a>
			 	</div>
			 </div>
			 
			 <div id="page_wrap">
		        <ul class="page_ul">
		            <li></li>
		        </ul>
		    </div>
        </div> 
         
         
      </div>
      
      <!-- footer -->
   </div>

</body>
</html>