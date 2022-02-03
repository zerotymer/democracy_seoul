<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script type="text/javascript" ></script>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/post.css">
</head>
<body>
	<div class="content-frame">
        <div class="frame-image">
            <div class="inner">
                <h2>제안결과</h2>
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
                                    <li><a href="">민주주의 서울 소개</a></li>
                                    <li><a href="">민주주의 서울 이야기</a></li>
                                    <li><a href="">공지사항</a></li>
                                    <li><a href="">자료실</a></li>
                                    <li><a href="">행사일정</a></li>
                                </ul>
                            </li>
                            <li class="menuitem">
                                <a href="">서울시민회의</a>
                                <ul class="submenu">
                                    <li><a href="">서울시민회의 소개</a></li>
                                    <li><a href="">서울시민회의 소식</a></li>
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
    <content>

        <div class="inner">
            <!-- DHH -->
		 
            
            <div class="container">
                <div class="contentTitle">
                    <br><br>
                    <div class="title"  value='<c:out value="${proposalView.propsosalTitle}"/>'>
                        <h2>서울시가 묻습니다. </h2>
                    </div>
                    <div class="detail" >투표기간 :
                        
                    </div>
                    <div class="hashtag">#동네책방 #동네책방</div>
                </div>
                <br><br>
                <hr>
                <article class="view_content" value='<c:out value="${proposalView.propsosalContent}"/>'>
                    내용입니다. ${proposal.proposalContent }
                  
                    <br>

                    <button class="survey" style="border: 0;">
                        설문조사
                    </button>
  	
                </article>
                
              
                <div class="sug">당신의 의견을 전달해주세요</div>

                <div class="comment">
                    <input type="hidden" name="bno" class="bno" value="">
                    <div class="userNick">김떙땡</div>
                    <input type="hidden" name="bno" class="bno" value="">
                    <input type="hidden" name="name" value="">
                    <div class="today">2022.01.22</div>
                    <textarea class="ccontent" style="width: 99%; border:0;"></textarea>
                    <button value="reg" style="float: right;  border: 0; background-color: white;">등록</button>
                </div>

                <hr style="color: #CCCCC">

				<!-- 댓글영역 -->
                <div id="replyList"></div>
                
    <script>     
	function listReply(num){
		$.ajax({
			type: "get",
			url: "${path}/reply/list.do?proposalNo=${proposal.proposalno}&curPage="+num,
			success: function(result){
			// responseText가 result에 저장됨.
				$("#listReply").html(result);
			}
		});
	}

	
	  </script> 
            </div>
        </div>
        
    </content>
    <script src="/resources/script/content-frame.js"></script>
</body>
</html>