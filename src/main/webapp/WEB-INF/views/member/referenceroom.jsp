<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료실</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/style/member/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/noticeNews.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>

<body>


   <div id="wrap">
   
      <!-- header -->

      <div id="content">
            <div class="box-title">
            <p class="tit-small"></p>
            <p class="tit-big">자료실</p>
         </div>
         
         <div class="notice-top">
         	    <div class="box-button">
				<button class="btn-notice">
				<a href="/board/referenceList.do">자료실</a>
				</button>
			 </div>
		 </div>
		<div class="area-notice">
			<div class="box-search">
				<form action="/board/referenceSearch.do" method="get"><!--공지사항 검색기능-->
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
			                <th width="150">작성일</th>
			            </tr>
			        </thead>
			        <tbody>	
			       	 <c:forEach items="${requestScope.list}" var="item" varStatus="i">	       				
			            <tr>
			                <td>${i.count}</td>
			                <td><div class="text-ellipsis subject"><a href="/board/referenceDetail.do?referNo=${item.referNo}&currentNo=${currentNo}">${ item.referTitle }</a></div></td><!-- 누르면 이동하게 -->
			                <td>0</td>
			                <td>${item.referDate }</td>
			               
			            </tr>
			          </c:forEach>
			        </tbody>
			    </table>
			
			   <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                    	<c:if test="${ preNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/board/referenceList.do?currentPage=${ preNavi }" tabindex="-1" aria-disabled="true"><<</a> <!-- a href=안이 맞나 확인하기 -->
	                        </li>
                        </c:if>
                        <c:forEach items="${ requestScope.navi }" var="m" varStatus="i">
	                        <li class="page-item">
	                        	<a class="page-link" href="/board/referenceList.do?currentPage=${ m }">${ m }</a>
	                        </li>
                        </c:forEach>
                        <c:if test="${ nextNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/board/referenceList.do?currentPage=${ nextNavi }">>></a>
	                        </li>
                        </c:if>
                    </ul>
                </nav>
			</div>
		</div>
		
      </div>
      
      <!-- footer -->
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