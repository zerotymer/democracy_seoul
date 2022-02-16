<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<title>민주주의 서울 - 시민토론</title>

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
        
        .more{
        	margin-top:20px;
            display:flex;
            align-items: center;
            justify-content: center;
        }
        .get{
        	padding:10px;
        	padding-left:20px;
        	padding-right:25px;
            border:1px solid rgba(150, 150, 120);
            border-radius:10px;
            background-color: white;
            font-size:20px;
            font-weight:bold;
            color:rgba(50, 50, 40);
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
                    <h2>시민토론</h2>
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

        <div class="frame--header inner">
            <div class="rect discuss">
                
            </div>
            
            <div class="contents-session">
                <!-- 글작성 버튼 위치 -->
                <div class="contents--textarea">
                    <h2>어쩌고 저쩌고</h2>
                    <span>읍냐?</span>
                </div>
                <c:if test="${admin!=null }">
                <div class="contents--btns">
                    <button class="btn suggest">시민토론 작성하기</button>
                </div>
                </c:if>
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
            	<c:forEach var="list" items="${list}">
                <div class="card-item discussion">
                    <div class="category">토론</div>
                    <div class="title">${list.discussTitle }</div>
                    <div class="content">내용</div>
                    <div class="thumnail">
                        <img src="${list.discussThumbnailPath }" alt="제목" />
                    </div>
                    <div class="icons">
                        <object class="icon hits auto-hidden"></object>
                        <span>212</span>
                        <object class="icon heart"></object>
                        <span>11</span>
                        <object class="icon comment"></object>
                        <span>12</span>
                        <object class="icon calendar auto-hidden"></object>
                        <span>${list.discussStart } ~ ${list.discussEnd }</span>
                    </div>
                    <a class="detail-btn" href="/discuss/onePost.do?discussNo=${list.discussNo}">결과 보기</a>
                </div>
                </c:forEach>
            </div>
            <hr>
            <div class="more">
        		<button class="get" value="1"><i class="xi-caret-down-circle-o"></i>더보기</button>
        	</div>

        </div>
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
    
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
    <script src="/resources/script/card-container.js"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- 로그인한 관리자만 작성 가능 -->
    <script>
    	var admin = ${admin != null};
    	
    	console.log(admin);
    	$('.btn.suggest').click(function(){
    		if(admin){
    			location.href='/discuss/writeForm.do';
    		}
    		else{
    			var result=confirm('관리자 로그인이 필요한 기능입니다. 로그인 하시겠습니까?');
    			if(result){
    				alert('관리자 로그인 페이지로 이동합니다.');
    				location.href='/test/admintest.do';
    			}
    		}
    	});
    </script>
    
    <!-- 목록 더보기 -->
    <script>
    $('.get').click(function(){
		var currentListPage=$('.get').val();
		var pageLimit=${pageCount};
		console.log(currentListPage);
		console.log(pageLimit);
		
		if(pageLimit>currentListPage){
			$.ajax({
				url : "/discuss/getList.ajax",
				type: "get",
				data : {currentListPage:currentListPage},
				success : function(data){
					var json = JSON.parse(data);
					var discuss=json.discuss;
					for(var i=0;i<discuss.length;i++){
						$("<div class='card-item discussion'><div class='category'>토론</div><div class='title'>"+${discuss[i].discussTitle }+"</div><div class='content'>내용</div><div class='thumnail'><img src='"+${discuss[i].discussThumbnailPath }+"' alt='제목' /></div><div class='icons'><object class='icon hits auto-hidden'></object><span>212</span><object class='icon heart'></object><span>11</span><object class='icon comment'></object><span>12</span><object class='icon calendar auto-hidden'></object><span>"+${discuss[i].discussStart }+" ~ "+${discuss[i].discussEnd }+"</span></div><a class='detail-btn' href='/discuss/onePost.do?discussNo="+${discuss[i].discussNo}+"'>결과 보기</a></div>").appendTo('.card-container');
					}
					$('.get').val(currentListPage+1);
				},
				error : function(data){
					alert('게시글 목록을 불러오지 못하였습니다. 지속적인 오류 발생 시 관리자에게 문의 바랍니다.');
				}	
			});
		}
		else{
			alert('더이상 불러올 게시글 목록이 없습니다.');
		}
	});
    </script>
</body>
</html>