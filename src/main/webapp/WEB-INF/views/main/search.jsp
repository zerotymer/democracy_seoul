<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL Core Library --> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>통합검색 > 민주주의 서울</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/main/search.css">
</head>
<body>
    <header>
        <%@ include file="/includes/header.jsp" %>
    </header>

    <section>
        <div class="content-frame">
            <div class="frame-image">
                <div class="inner">
                    <h2>통합검색</h2>
                </div>
            </div>
            <div class="frame-menu hidden">
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
                        </li>    
                        <li class="menubar-list">
                            <h3>서브메뉴<span class="slick-arrow"></span></h3>                        
                            <ul class="menu">
                                <li class="menuitem">
                                    <a href="">시민제안</a>
                                </li>
                                <li class="menuitem">
                                    <a href="">시민토론</a>
                                </li>
                                <li class="menuitem">
                                    <a href="">서울시가 묻습니다.</a>
                                </li>
                            </ul>
                        </li>
                    </ul>                
                </div>
            </div>
        </div>

        <div class="search--container inner">
            <div class="search-bar">
                <input type="text" placeholder="검색" />
                <button>
                    검색
                </button>
            </div>
            <div class="search-result">
                <div class="search-msg">
                    "<strong>${ requestScope.keyword }</strong>"에 대한 검색결과는 '<strong>${ requestScope.count }</strong>'건입니다.
                </div>
                <div>
                    <div class="tab">
                        <span class="tab-btn active">전체 (${ requestScope.count })</span>
                        <span class="tab-btn">시민제안 (${ requestScope.suggest.size() })</span>
                        <span class="tab-btn">서울시가 묻습니다 (${ requestScope.proposal.size() })</span>
                    </div>
                    <hr>
                    <div class="result">
                        <ul id="suggest--container">
                            <div>
                                <h3>시민제안 검색결과 (총 <strong>${ requestScope.suggest.size() }</strong>건)</h3>
                                <span class="more" onclick="">더보기</span>
                            </div>
                            <c:forEach items="${ requestScope.suggest }" var="item">
                                <li>
                                    <h4 href="">${ item.TITLE }</h4>
                                    <p>${ item.CONTENT }</p>
                                </li>
                            </c:forEach>
                        </ul>
                        <ul id="proposal--container">
                            <div>
                                <h3>서울시가 묻습니다 검색결과 (총 ${ requestScope.proposal.size() }건)</h3>
                                <span class="more">더보기</span>
                            </div>
                            <c:forEach items="${ requestScope.proposal }" var="item">
                                <li>
                                    <h4 href="">${ item.TITLE }</h4>
                                    <p>${ item.CONTENT }</p>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>

    <!-- jQuery Library -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
    <script>
        const suggestCount = ${ requestScope.suggest.size() };
        const proposalCount = ${ requestScope.proposal.size() };
        const keyword = "${ requestScope.keyword }";
        var suggsetPage = 3;
        var proposalPage = 3;

        function createResultItem(data) {
            let li = document.createElement('li');

            let h4 = li.appendChild(document.createElement('h4'));
            h4.innerHTML = data.TITLE;
            h4.setAttribute('href', data.URL);

            let p = li.appendChild(document.createElement('p'));
            p.innerHTML = data.CONTENT;
            return li;
        }

        function loadAjax() {
            jQuery.ajax({
                url: '/main/search.ajax',
                type: 'GET',
                data: {
                    keyword: keyword
                },
                success: data => console.log(data),
                error: e => console.log('ajax 통신 실패')
            });
        }

        loadAjax();
    </script>
</body>
</html>