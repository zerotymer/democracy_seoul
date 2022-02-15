<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- JSTL Core Library -->
<!-- Header -->
<div class="noticebar">
    <div class="inner">
        <span>서울특별시</span>
        <span>코로나19 재택치료 안내 우리동네 재택치료 상담•처방(전화)병의원, 지정약국, 대면진료센터 확인</span>
        <ul>
            <li><a href="//www.seoul.go.kr/sgnb/seoulgnblog.do?gid=G197&amp;kind=seoulnews&amp;link=https://www.seoul.go.kr/realmnews/in/list.do" target="_blank" title="새창열림">서울소식</a></li>
            <li><a href="//www.seoul.go.kr/sgnb/seoulgnblog.do?gid=G197&amp;kind=eungdapso&amp;link=http://eungdapso.seoul.go.kr" target="_blank" title="새창열림">응답소</a></li>
            <li><a href="//www.seoul.go.kr/sgnb/seoulgnblog.do?gid=G197&amp;kind=opengov&amp;link=http://opengov.seoul.go.kr" target="_blank" title="새창열림">정보공개</a></li>
            <li><a href="//www.seoul.go.kr/sgnb/seoulgnblog.do?gid=G197&amp;kind=citybuild&amp;link=http://news.seoul.go.kr/" target="_blank" title="새창열림">분야별정보</a></li>
        </ul>
    </div>
</div>
<nav id="gnb" class="gnb inner">
    <div class="logo">
        <h4>민주주의 서울</h4>
    </div>
    
    <!-- Menu -->
    <ul class="menu">
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
                <li><a href="">공론결과</a></li>
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

    <ul class="icons">
        <li class="search">
            <button class="btn invert searchbtn" onclick="location.replace('/main/search.do');"></button>
        </li>
        <c:choose>
            <c:when test="${ sessionScope.user != null}" >
                <li class="mypage">
                    <button class="btn invert accountbtn" onclick="location.replace('/member/goMypage.do');"></button>
                </li>
                <li class="logout">
                    <button class="btn invert logoutbtn" onclick="location.replace('/member/logout.do');"></button>
                </li>
            </c:when>
            <c:when test="${ sessionScope.admin != null }" >
                <li class="logout">
                    <button class="btn admin logoutbtn" onclick="location.replace('/admin/adminLogout.do');"></button>
                </li>
                <li class="mypage">
                    <button class="btn admin accountbtn" onclick="location.replace('/member/logout.do');"></button>
                </li>
            </c:when>
            <c:otherwise>    
                <li class="login">
                    <button class="btn invert loginbtn" onclick="location.replace('/member/goLogin.do');"></button>
                </li>
            </c:otherwise>
        </c:choose>
        <li class="menubtn">
            <button id="menubtn" class="btn invert menubtn"></button>
        </li>
    </ul>
</nav>