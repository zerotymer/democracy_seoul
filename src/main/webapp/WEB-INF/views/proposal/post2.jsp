<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
  
    <title>Insert title here</title>
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/post.css">
    <link rel="stylesheet" type="text/css" href="fontawesome-free-5.15.1-web/css/fontawesome.min.css">
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

<section>
    <div class="inner">
       
        <div class="container" style="overflow:hidden;">
            <div class="contentTitle">
                <br><br>
                <div class="title">
                    <h5>서울시가 묻습니다.</h5>
                    <div class="proposalTitle">${ requestScope.proposal.proposalTitle}</div>
                </div>

            </div><br>
            <div class="date">
                투표기간 : ${ requestScope.proposal.proposalStart} ~ ${ requestScope.proposal.proposalEnd}
            </div>
            <div class="hashtag">
                #동네책방 #동네책방
            </div>
            <br>
            <br>

          <%--   <c:if test="${sessionScope.adminId != null}"> --%>
	            <div class="adminCon">
	                <button class="editBtn" id="editBtn">수정</button>
	                <button class="delBtn" id="delBtn">삭제</button>
	                <button class="listBtn" id="listBtn">목록</button>
	            </div>
         <%--  	</c:if> --%>
            <hr>
            <article class="view_content">

           ${ requestScope.proposal.proposalContent }
                <br>
                <button class="survey">
                    설문조사 <i class="far fa-thumbs-up"></i>
                </button>
            </article>
        </div>

        <div class="sug">
            당신의 의견을 전달해주세요
        </div>

       <%--  <div class="comment">
            <input type="hidden" name="bno" class="bno" value="" />
            <div class="userNick">${ requestScope.member.nick }</div>
            <input type="hidden" name="proposalNo" class="proposalNo" value="proposalNo" />
            <input type="hidden" name="name" value="" />
            <span class="today">
                   
                </span>
            <textarea class="ccontent" style="width: 99%; border:0;">
            </textarea>
            <button value="reg">등록</button>
        </div> --%>

        <hr style="color: #CCC">
        
        <!-- 댓글 작성폼 -->
        <c:choose>
        
	        <c:when test="${user }!=null">
	        <c:choose>
	        
	        	<c:when test="${my }!=null">
	        		<form id="comment" class="comment" name="comment" method="post" action="/proposal/writeComment.do">
					<div class="input-group">
						<span id="input-group-text" class="input-group-text form">댓글</span>
					    <textarea name="commentContent" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="댓글을 작성하세요.">${my.commentContent }</textarea>
					    <input name="proposalNo" type="hidden" value="${proposal.proposalNo}" />
					    <button class="write" type="submit"><!--<i class="xi-pen-o"></i>-->수정</button>
				    </div>
					</form>
	        	</c:when>
	        	
	        	<c:otherwise>
	        	<a href="/proposal/allList">
	        		<form id="comment" name="comment" method="post" action="/proposal/writeComment.do">
					<div class="input-group abled">
						<span class="input-group-text form">댓글</span>
					    <textarea name="commentContent" id="disabled" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="댓글을 작성하세요." disabled></textarea>
					    <input name="proposalNo" type="hidden" value="${proposal.proposalNo}" />
					    <button class="write" type="submit"><!--<i class="xi-pen-o"></i>-->완료</button>
				    </div>
					</form>
				</a>
	        	</c:otherwise>
	        	
			</c:choose>
			</c:when>
			
			<c:otherwise>
				<form id="commentWrite" name="commentWriteForm" method="post" action="/proposal/writeComment.do">
				<div class="input-group disabled">
		            <span class="input-group-text form">댓글</span>
		            <textarea name="commentContent" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="로그인 후 댓글 작성 가능합니다." disabled></textarea>
		            <button class="write"><!--<i class="xi-pen-o"></i>-->입력</button>
	            </div>
				</form>
			</c:otherwise>
        
        </c:choose>
        
         <!-- 댓글 목록 -->
        <div class="comment-container">
        
        <div id="comments-pro" class="comments pro">
        	<c:forEach var="proComment" items="${proComment}">
            <div class="comment pro">
                <div class="content">
                    <div class="text">${proComment.get("commentContent")}</div>
                    <div class="id">${proComment.get("userId")}</div>
                </div>
                <div class="icon">
                	<div class="img">
                		<svg style="width:18px;height:18px" viewBox="0 0 24 24">
	                    <path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" />
	                    </svg>
                	</div>
                </div>
            </div>
            </c:forEach>
        </div>
        
        </div><hr>
        <div class="more">
        	<button class="get" value="1"><i class="xi-caret-down-circle-o"></i>더보기</button>
        </div>
		
    </section>
        
        
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/resources/script/content-frame.js"></script>
<script>
    var proposalNo = ${ proposal.proposalNo };
    var bLogin = ${ sessionScope.user != null };
    /* function listReply(num) {
        var path = 'path';
        var proposalNo = ${ proposal.proposalNo };

        $.ajax({
            url: path + "/reply/list.do",
            type: "get",
            data: {
                proposalNo: proposalNo,
                curPage: num
            },
            success: function (result) {
                // responseText가 result에 저장됨.
                $("#listReply").html(result);
            }
        });
    } */

    //글목록으로 이동하게 하는 함수
    $(document).ready(function(){
        $("#listBtn").click(function(){
            location.href="/proposal/allList.do";
        });

        $("#editBtn").click(function(){
            location.href="/proposal/modify.do?proposalNo="+proposalNo;
        });

        $("#delBtn").click(function(){
            location.href="/proposal/delete.do?proposalNo="+proposalNo;
        });
    })
    
    // 로그인 안하고 댓글 작성 시도 시 로그인 페이지로 이동-
	$('.disabled').click(function(){
		if(!bLogin ){ 
			alert('로그인 페이지로 이동합니다.');
			location.replace('/member/goLogin.do');
		}
	});

    $('.get').click(function(){
		var currentCommentPage=$('.get').val();
		var proposalNo=${proposal.proposalNo};
		var totalCount=${totalCount};
		
		if(totalCount/5>=currentCommentPage){
			$.ajax({
				url : "/proposal/getComment.do",
				type: "get",
				data : {currentCommentPage:currentCommentPage,proposalNo:proposalNo},
				success : function(data){
					var json = JSON.parse(data);
					var comment=json.comment;
					for(var i=0;i<comment.length;i++){
						
							$('<div class="comment pro"><div class="content"><div class="text">'
							+comment[i].commentContent
							+'</div><div class="id">'
							+comment[i].userId
							+'</div></div><div class="icon"><div class="img"><svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" /></svg></div></div></div>').appendTo('#comments-pro');
						}
						
					}
					$('.get').val(currentCommentPage+1);
				},
				error : function(data){
					alert('댓글을 불러오지 못하였습니다. 지속적인 오류 발생 시 관리자에게 문의 바랍니다.');
				}	
			});
		}
		else{
			alert('더이상 불러올 댓글 목록이 없습니다.');
		}
	});

    </script>
    
    

</body>
</html>