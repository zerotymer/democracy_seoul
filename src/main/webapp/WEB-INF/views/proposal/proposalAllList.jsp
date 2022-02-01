<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/card-container.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/ProposalAllList.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    
</head>

<body>
    <header>
        <div class="noticebar">
            <div class="wrapper">
                서울특별시
            </div>
        </div>
        <nav id="gnb" class="gnb">
            <div class="logo">
                <h4>민주주의 서울</h4>
            </div>

            <!-- include Menu -->
            <ul class="menu">
                <li class="menuitem">
                    <a href="">참여하기</a>
                    <ul class="submenu">
                        <li><a href=""></a>시민제안</li>
                        <li><a href=""></a>시민토론</li>
                        <li><a href=""></a>서울시가 묻습니다</li>
                    </ul>
                </li>
                <li class="menuitem">
                    <a href="">결과보기</a>
                    <ul class="submenu">
                        <li><a href="">제안결과</a></li>
                        <li><a href="">공론결과</a></li>
                    </ul>
                </li>
                <li class="menuitem">
                    <a href="">알아보기</a>
                    <ul class="submenu">
                        <li><a href="">민주주의 서울 <wbr/>소개</a></li>
                        <li><a href="" style="font-size: 13px;">민주주의 서울 <wbr/>이야기</a></li>
                        <li><a href="">공지사항</a></li>
                        <li><a href="">자료실</a></li>
                        <li><a href="">행사일정</a></li>
                    </ul>
                </li>
                <li class="menuitem">
                    <a href="">서울시민회의</a>
                    <ul class="submenu">
                        <li><a href="">서울시민회의 <wbr/>소개</a></li>
                        <li><a href="">서울시민회의 <wbr/>소식</a></li>
                    </ul>
                </li>
                <li class="menuitem">
                    <a href="">시민참여예산</a>
                </li>
            </ul>

            <ul class="icons">
                <li class="search">
                    <button class="btn searchbtn invert"></button>
                </li>
                <li class="login">
                    <button class="btn loginbtn invert"></button>
                </li>
                <li class="menubtn">
                    <button id="menubtn" class="btn menubtn invert"></button>
                </li>
            </ul>
        </nav>
    </header>

    <div class="header-gap">
    </div>

    <content>
        <div>

        </div>
        <c:choose>
		<c:when test="${!requestScope.list.isEmpty()}">
        
       <c:forEach items="${requestScope.list }" var="p" varStatus="i">    
        <div class="card-container">
            <div class="card-item suggest">
                <div class="category">${i.count }</div>
                <div class="title">${p.proposalTitle }</div>
                <div class="content">${p.proposalContent }</div>
                <div class="icons">
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                </div>
            </div>
            </c:forEach>
            
            </c:when>
	
		<c:otherwise>
			<H1>저장된 내용이 없습니다</H1>
		</c:otherwise>
	</c:choose>
	
	
          
    </content>

    <div class="footer-gap">

    </div>

    <footer>
        <nav id="FNB" class="fnb">
            <ul>
                <li><a>개인정보처리방침</a></li>
                <li><a>자주묻는 질문</a></li>
                <li><a>사이트맵</a></li>
            </ul>
        </nav>
        <div class="content">
            <ul>
                <li class="logo">
                    <img src="/images/foot_logo.png" alt="서울로고">
                </li>
                <li class="address">
                    (04514) 서울특별시 중구 서소문로 124 씨티스퀘어빌딩 10층<br>
                    대표전화 02-120 / 민주주의 서울 홈페이지 시스템 문의 : 02-2133-6939
                </li>
                <li class="sns">
                    <ul>
                        <li>
                            <a class="icon youtube" target="_blank" href="https://www.youtube.com/channel/UCG4xe68a2ndg69x91jL0x2g/featured" title="유튜브 이동(새창)">유튜브</a>
                        </li>
                        <li>
                            <a class="icon facebook" target="_blank" href="https://www.facebook.com/democracyseoul/" title="페이스북 이동(새창)">페이스북</a>
                        </li>
                        <li>
                            <a class="icon twitter" target="_blank" href="https://twitter.com/seoulmania" title="트위터 이동(새창)">트위터</a>
                        </li>
                        <li>
                            <a class="icon instagram" target="_blank" href="https://www.instagram.com/democracyseoul/" title="인스타그램 이동(새창)">인스타그램</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </footer>

    
    <script src="/include.js"></script>
    <script src="/header.js"></script>
    <script>includeHTML();</script>
    <script src="/resources/script/content-frame.js"></script>
</body>
</html>