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
                        <span class="tab-btn active" onclick="changeTab(this);" type="all">전체 (${ requestScope.count })</span>
                        <span class="tab-btn" onclick="changeTab(this);" type="suggest">시민제안 (${ requestScope.suggestCount })</span>
                        <span class="tab-btn" onclick="changeTab(this);" type="proposal">서울시가 묻습니다 (${ requestScope.proposalCount })</span>
                    </div>
                    <hr>
                    <div class="result">
                        <ul id="suggest--container">
                            <c:if test="${ requestScope.suggestCount > 3 }">
                                <div>
                                    <h3>시민제안 검색결과 (총 <strong>${ requestScope.suggestCount }</strong>건)</h3>
                                    <span id="suggestMore" class="more" onclick="moreSuggest();">더보기</span>
                                </div>
                            </c:if>
                            <c:forEach items="${ requestScope.suggest }" var="item">
                                <li>
                                    <h4><a href="${ item.URL }">${ item.TITLE }</a></h4>
                                    <p>${ item.CONTENT }</p>
                                </li>
                            </c:forEach>
                        </ul>
                        <ul id="proposal--container"> 
                            <c:if test="${ requestScope.proposalCount > 3 }">
                                <div>
                                    <h3>서울시가 묻습니다. 검색결과 (총 <strong>${ requestScope.proposalCount }</strong>건)</h3>
                                    <span id="proposalMore" class="more" onclick="moreProposal();">더보기</span>
                                </div>
                            </c:if>
                            <c:forEach items="${ requestScope.proposal }" var="item">
                                <li>
                                    <h4><a href="${ item.URL }">${ item.TITLE }</a></h4>
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
        const suggestCount = ${ requestScope.suggestCount };
        const proposalCount = ${ requestScope.proposalCount };
        const keyword = "${ requestScope.keyword }";
        var suggsetPage = 1;
        var proposalPage = 1;

        function insertResultItem(data, parent) {
            let li = parent.appendChild(document.createElement('li'));

            let h4 = li.appendChild(document.createElement('h4'));
            let a = h4.appendChild(document.createElement('a'));
            a.href = data.URL;
            a.innerHTML = data.TITLE;

            let p = li.appendChild(document.createElement('p'));
            p.innerHTML = data.CONTENT;
            return li;
        }

        function moreSuggest() {
            jQuery.ajax({
                url: '/main/search.ajax',
                type: 'GET',
                data: {
                    keyword: keyword,
                    keywordType: 'suggest',
                    currentPage: ++suggsetPage,
                    pageSize: 3,
                },
                success: data => data.forEach(item => insertResultItem(item, document.getElementById('suggest--container'))),
                error: e => console.log('ajax 통신 실패')
            });

            (suggsetPage * 3 >= suggestCount) && document.getElementById('suggestMore').classList.add('hidden');
        }
        function moreProposal() {
            jQuery.ajax({
                url: '/main/search.ajax',
                type: 'GET',
                data: {
                    keyword: keyword,
                    keywordType: 'proposal',
                    currentPage: ++proposalPage,
                    pageSize: 3,
                },
                success: data => data.forEach(item => insertResultItem(item, document.getElementById('proposal--container'))),
                error: e => console.log('ajax 통신 실패')
            });

            (proposalPage * 3 >= proposalCount) && document.getElementById('proposalMore').classList.add('hidden');
        }

        function changeTab(element) {
            Array.from(document.getElementsByClassName('tab-btn')).forEach(item => item.classList.remove('active'));
            element.classList.add('active');
            
            switch(element.getAttribute('type')) {
                case 'suggest':
                    document.getElementById('suggest--container').classList.remove('hidden');
                    document.getElementById('proposal--container').classList.add('hidden');
                    break;
                case 'proposal':
                    document.getElementById('suggest--container').classList.add('hidden');
                    document.getElementById('proposal--container').classList.remove('hidden');
                    break;
                case 'all':
                default:
                    document.getElementById('suggest--container').classList.remove('hidden');
                    document.getElementById('proposal--container').classList.remove('hidden');
                    break;
            }

            
        }
    </script>
</body>
</html>