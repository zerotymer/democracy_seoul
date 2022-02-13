<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>민주주의 서울 - 시민제안</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/card-container.css">
    <link rel="stylesheet" href="/resources/style/list-frame.css">
    <style>
        body {
            background-color: var(--COLOR-WHITE);
            margin: 0;

            /* no Scrollbar */
            -ms-overflow-style: none; /* IE and Edge */
            scrollbar-width: none; /* Firefox */
        }

        body::-webkit-scrollbar {
            display: none; /* Chrome, Safari, Opera*/
        }
 
        header {
            z-index: 10;
        }

        section {
            position: relative;
            width: 100%;
            min-height: 90vh;
            /* overflow: scroll; */
        }
    </style>
</head>
<body>
    <header>
        <%@ include file="/includes/header.jsp" %>
    </header>

    <section>
        <div class="content-frame">
            <div class="frame-image">
                <div class="inner">
                    <h2>시민제안</h2>
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
                            <h3>시민제안<span class="slick-arrow"></span></h3>                        
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

        <div class="frame--header inner">
            <div class="rect suggest">
                
            </div>
            
            <div class="contents-session">
                <!-- 글작성 버튼 위치 -->
                <div class="contents--textarea">
                    <h2>어쩌고 저쩌고</h2>
                    <span>읍냐?</span>
                </div>
                <div class="contents--btns">
                    <button class="btn suggest" onclick="location.href='suggestwrite.do' ">시민 제안하기</button>
                </div>
            </div>

            <div class="contents-search">
                <!-- 검색 위치 -->
                
            </div>

            <div class="contents-tag">
                <!-- 태그 위치 -->
                <a href="">#이게나다</a>
                <a href="">#골목책방</a>
                <a href="">#누구신가</a>
            </div>
            
        </div>
        
        
        <div class="contents">
            <div class="card-container">

				<c:forEach items="${requestScope.list}" var="sug" varStatus="i"> 
		            <div class="card-item survey">
		                <div class="category"> 설문</div>
		                <div class="title">
		                	<a class="sugTitle">${sug.sugTitle }</a>
		                </div>
		                <div class="content">${sug.sugContent }</div>
		                <div class="thumnail">
	                        <img src="${sug.sugThumbnail }" alt="제목" />
	                    </div>
		                <div class="icons">
		                    <object class="icon hits auto-hidden"></object>
		                    <span>200</span>
		                    <object class="icon heart"></object>
		                    <span>10</span>
		                    <object class="icon comment"></object>
		                    <span>10</span>
		                    <object class="icon calendar auto-hidden"></object>
		                    <span> ${sug.sugStart } ~ ${sug.sugEnd }</span>
	                    </div>
	                    <a class="detail-btn" href="/sug/post.do?sugNo=${sug.sugNo}">
                        			결과 보기 
                   		</a>
      				</div>
           		</c:forEach> 
               
            </div>
						
							 
			
						
            <div class="contents-navbar"></div>
        </div>
        
        
        
        
        
        
        
        
        
        
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
    
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
    <script src="/resources/script/card-container.js"></script>
</body>
</html>