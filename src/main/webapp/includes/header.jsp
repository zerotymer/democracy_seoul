<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Header -->
<div class="noticebar">
    <div class="wrapper">
        공지사항
    </div>
</div>
<nav id="gnb" class="gnb">
    <div class="logo">
        <h4>민주주의 서울</h4>
    </div>
    
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
                <li><a href="">제안결과</a></li>
                <li><a href="">공론결과</a></li>
            </ul>
        </li>
        <li class="menuitem">
            <a>알아보기</a>
            <ul class="submenu">
                <li><a href="/main/introduce.do">민주주의 서울 <wbr/>소개</a></li>
                <li><a href="" style="font-size: 13px;">민주주의 서울 <wbr/>이야기</a></li>
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
            <a href="">시민참여예산</a>
        </li>
    </ul>

    <ul class="icons">
        <li class="search">
            <button class="btn invert searchbtn"></button>
        </li>
        <li class="login">
            <button class="btn invert loginbtn" onclick="location.replace('/member/goLogin.do');"></button>
        </li>
        <li class="menubtn">
            <button id="menubtn" class="btn invert menubtn"></button>
        </li>
    </ul>
</nav>