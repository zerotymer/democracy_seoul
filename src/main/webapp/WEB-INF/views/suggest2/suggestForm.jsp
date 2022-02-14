<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- JSTL Core Library -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제안하기 - 민주주의 서울</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/suggest/postform.css">
</head>
<body>
    <header>
        <%@ include file="/includes/header.jsp" %>
    </header>

    <section>
        <div class="content-frame">
            <div class="frame-image">
                <div class="inner">
                    <h2>제안하기</h2>
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
                                        <li><a href="">제안결과</a></li>
                                        <li><a href="">공론결과</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a href="">알아보기</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">민주주의 서울 <wbr/>소개</a></li>
                                        <li><a href="" style="font-size: 13px;">민주주의 서울 <wbr/>이야기</a></li>
                                        <li><a href="/board/goNoticeNews.do">공지사항</a></li>
                                        <li><a href="/board/referenceList.do">자료실</a></li>
                                        <li><a href="/board/noticeCampaign.do">행사일정</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a href="">서울시민회의</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">서울시민회의 <wbr/>소개</a></li>
                                        <li><a href="/board/seoulNews.do">서울시민회의 <wbr/>소식</a></li>
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

        <div class="write--form inner">
            <form id="form" action="/suggest2/update.do" method="post">
                <input type="hidden" name="suggestNo" value="${ requestScope.suggest.suggestNo }">
                <input class="title" type="text" name="suggestTitle" placeholder="제목" value="${ requestScope.suggest.suggestTitle }" />
                <textarea id="editor" class="ckeditor" name="suggestContent" placeholder="내용">${ requestScope.suggest.suggestContent }</textarea>
                <input type="hidden" name="suggestGory" placeholder="부서" value="${ requestScope.suggest.suggestGory }" />
                <input type="hidden" name="suggestLocal" placeholder="관할구역" value="${ requestScope.suggest.suggestLocal }" />
                <div class="btn--container">
                    <c:if test="${ requestScope.suggestNo == 0 }">
                        <button>제안하기</button>
                    </c:if>
                    <c:if test="${ requestScope.suggestNo != 0 }">
                        <button>수정하기</button>
                    </c:if>
                    <button type="button" onclick="location.replace('/suggest/suggest.do');">취소하기</button>
                </div>
            </form>
        </div>
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
    
    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
    <script>
    ClassicEditor
            .create( document.querySelector( '#editor' ), {
                ckfinder: {
                    uploadUrl: '/ckeditor/imgUpload.do'
                }
            })
            .catch( error => {
                console.error( error );
            });
    </script>
</body>
</html>