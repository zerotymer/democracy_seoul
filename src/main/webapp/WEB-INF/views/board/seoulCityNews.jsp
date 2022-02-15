<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>서울시민회의 소식</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/member/default.css">
	<link rel="stylesheet" href="/resources/style/member/common.css">
	<link rel="stylesheet" href="/resources/style/member/noticeNews.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
</head>
<body>
    <header>
        <%@ include file="/includes/header.jsp" %>
    </header>

    <section>
        <div class="content-frame">
            <div class="frame-image">
                <div class="inner">
                    <h2>서울시민회의 소식</h2>
                </div>
            </div>
            <div class="frame-menu">
                <div class="inner menubar">
                    <ul>
                        <li class="menubar-icon">
                            <a href="/">
                                <div class="icon home"></div>
                            </a>
                        </li>
                        <li class="menubar-list">
                            <h3>참여하기<span class="slick-arrow"></span></h3>      
                                        
                            <!-- Menu -->
                            <ul class="include menu">
                                <li class="menuitem">
                                    <a>참여하기</a>
                                    <ul class="submenu">
                                        <li><a href="/suggest/suggest.do">시민제안</a></li>
                                        <li><a href="/discuss/list.do">시민토론</a></li>
                                        <li><a href="/proposal/allList.do">서울시가 묻습니다</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a>결과보기</a>
                                    <ul class="submenu">
                                        <li><a href="/suggest2/listExpired.do">제안결과</a></li>
                                        <li><a href="/proposal/resultList.do">공론결과</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a>알아보기</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">민주주의 서울 <wbr/>소개</a></li>
                                        <li><a href="/board/seoulNews.do" style="font-size: 13px;">민주주의 서울 <wbr/>이야기</a></li>
                                        <li><a href="/board/goNoticeNews.do">공지사항</a></li>
                                        <li><a href="/board/referenceList.do">자료실</a></li>
                                        <li><a href="/board/noticeCampaign.do">행사일정</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a>서울시민회의</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">서울시민회의 <wbr/>소개</a></li>
                                        <li><a href="/board/seoulNews.do">서울시민회의 <wbr/>소식</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a href="/main/budget.go">시민참여예산</a>
                                </li>
                            </ul>
                        </li>    
                        <li class="menubar-list">
                            <h3>서브메뉴<span class="slick-arrow"></span></h3>                        
                            <ul class="menu">
                                <li class="menuitem">
                                    <a href="/suggest/suggest.do">시민제안</a>
                                </li>
                                <li class="menuitem">
                                    <a href="/discuss/list.do">시민토론</a>
                                </li>
                                <li class="menuitem">
                                    <a href="/proposal/allList.do">서울시가 묻습니다.</a>
                                </li>
                            </ul>
                        </li>
                    </ul>                
                </div>
            </div>
        </div>

        <div>
           <div id="content">
             <div class="box-title">
             <p class="tit-big">서울시민회의</p>
           </div>
         
         <div class="notice-top">
         	 <div class="box-button">
				<button class="btn-notice">
					<a href="/board/seoulNews.do">서울시민회의</a>
				</button>
			 </div>
		 </div>
		<div class="area-notice">
			<div class="box-search">
				<form action="/board/seoulNewsSearch.do" method="get"><!-- 검색기능-->
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
			                <td><div class="text-ellipsis subject"><a href="/board/seoulNewsDetail.do?seoulNewsNo=${item.seoulNewsNo}&currentNo=${currentNo}">${ item.seoulTitle }</a></div></td><!-- 누르면 이동하게 -->
			                <td>0</td>
			                <td>${item.seoulDate }</td>
			            </tr>
			            </c:forEach>
			        </tbody>
			    </table>
			
			   <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                    	<c:if test="${ preNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/board/seoulNews.do?currentPage=${ preNavi }" tabindex="-1" aria-disabled="true"><<</a> <!-- a href=안이 맞나 확인하기 -->
	                        </li>
                        </c:if>
                        <c:forEach items="${ requestScope.navi }" var="m" varStatus="i">
	                        <li class="page-item">
	                        	<a class="page-link" href="/board/seoulNews.do?currentPage=${ m }">${ m }</a>
	                        </li>
                        </c:forEach>
                        <c:if test="${ nextNavi > 0 }">
	                        <li class="page-item">
	                            <a class="page-link" href="/board/seoulNews.do?currentPage=${ nextNavi }">>></a>
	                        </li>
                        </c:if>
                    </ul>
                </nav>
			</div>
		</div>
       </div>
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
</body>
</html>