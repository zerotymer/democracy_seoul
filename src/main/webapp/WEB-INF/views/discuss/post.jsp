<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<title>민주주의 서울 - 시민토론 게시글 <${discuss.discussTitle}></title>

    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    
    <style>
        * {
            box-sizing: border-box;
        }
        
        body {
            width: 100%;
            margin: 0;
            padding: 0;
        }
        
        .inner {
            width: 80%;
            margin: 0 auto;
        }
        .inner>div:first-of-type{
            border-top:solid 4px rgba(200, 200, 180);
            border-left:solid 1px rgba(200, 200, 180);
            border-right:solid 1px rgba(200, 200, 180);
            border-bottom:solid 1px rgba(200, 200, 180);
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
            padding:30px;
        }
        
        #title{
            width:100%;
        }
        #title>div:first-of-type{
            width:100%;
            margin:0 auto;
            padding-left:6%;
            font-size:25px;
            font-weight: bolder;
        }
        #title>div:last-of-type{
            padding-right:5%;
        }
        .tag{
            float:right;
            margin:12px;
        }
        #title a{
            font-size:13px;
            font-weight:1000;
            color:rgba(160, 160, 130);
        }
        
        .vote{
            width:80%;
            height:24px;
            margin-top:7%;
            margin-left:auto;
            margin-right:auto;
            display:flex;
            flex-direction: row;
            justify-content: center;
            text-align: center;
        }
        .vote.reverse{
        	flex-direction: row-reverse;
        }
        
        .graph{
            width:50%;
            height:100%;
            margin:auto 0;
            padding-top:2px;
            color:white;
        }
        .votePro{
        	background-color:rgba(69, 49, 250);
        	border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }
        .voteCon{
        	background-color: rgba(250, 49, 49);
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
        }
        .vote.reverse .votePro{
        	border-top-left-radius: 0;
            border-bottom-left-radius: 0;
        	border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
        }
        .vote.reverse .voteCon{
        	border-top-right-radius: 0;
            border-bottom-right-radius: 0;
        	border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }
        
        .contents{
            width:100%;
            margin-top:2%;
            margin-left:auto;
            margin-right:auto;
            padding-left:5%;
            font-size:14px;
        }
        
        .comment-container{
            width:100%;
            margin:0 auto;
            display:flex;
            flex-direction: row;
        }
        
        .comment-container.reverse{
        	flex-direction:row-reverse;
        }
        
        .comments{
            width:50%;
            margin-top:10px;
        }
        
        .comment {
        	margin: 0;
        	padding: 0;
        	overflow: hidden;
            width:97%;
            border:1px solid rgba(200, 200, 180);
            border-radius: 8px;
            display: flex;
        }
        .comment.pro {
        	flex-direction: row;
        	background-color: rgba(69, 49, 250);
        }
        .comment.con {
        	margin-left:3%;
        	flex-direction: row-reverse;
        	background-color: rgba(250, 49, 49);
        }
        .comment-container.reverse .comment.pro{
        	flex-direction: row-reverse;
        	margin-left:3%;
        }
        .comment-container.reverse .comment.con{
        	flex-direction: row;
        	margin-left:0;
        }
        .comment .content {
            width:85%;
            height:100%;
        	margin: 0;
        	padding: 8px;
            background-color: white;
        }
        .comment .content .text{
            font-size:12px;
        }
        .comment .content .id{
            margin-top:5px;
            font-size:14px;
            color:rgba(110, 110, 100);
        }
        
        .icon{
            width:15%;
            margin:auto 0;
            display:flex;
            align-items:center;
            justify-content:center;
            border-top-right-radius: 8px;
            border-bottom-right-radius: 8px;
            text-align: center;
        }
        .icon .img{
        	width:100%;
        	color:white;
        }
        
        .more{
            display:flex;
            align-items: center;
            justify-content: center;
        }
        .get{
            border:0px;
            background-color: white;
        }
        
        
        /*댓글 작성폼*/
        #commentWrite{
        	width:100%;
            height:110px;
            display:flex;
            flex-direction: row;
        }
        .form{
            border:2px solid rgba(20, 160, 134);
        }
        .input-group-text{
            width:100px;
            background-color: rgba(20, 160, 134);
            color:white;
        }
        .form-control{
            resize:none;
        }
        .write{
            border:1px solid rgba(100, 100, 100);
            background-color: rgba(20, 160, 134);
            font-size:13px;
            color:white;
        }
        
        a{
        	text-decoration:none;
        }
    </style>
    
</head>
<body>

	<header>
        <%@ include file="/includes/header.jsp" %>
    </header>

    <section class="inner">
        <div>

          <!-- 게시글 내용 -->
          <div id="title">
            <div>${discuss.discussTitle}</div>
            <div>
                <div class="tag"><a href="url">#해시태그</a></div>
            </div>
          </div>

          <div class="vote">
            <div class="votePro graph">
                <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                <path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" />
                </svg>
            </div>
            
            <div class="voteCon graph">
                <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                <path fill="currentColor" d="M19,15V3H23V15H19M15,3A2,2 0 0,1 17,5V15C17,15.55 16.78,16.05 16.41,16.41L9.83,23L8.77,21.94C8.5,21.67 8.33,21.3 8.33,20.88L8.36,20.57L9.31,16H3C1.89,16 1,15.1 1,14V12C1,11.74 1.05,11.5 1.14,11.27L4.16,4.22C4.46,3.5 5.17,3 6,3H15M15,5H5.97L3,12V14H11.78L10.65,19.32L15,14.97V5Z" />
                </svg>
            </div>
          </div>

          <div id="contents" class="contents">
          	
          </div>

        </div>
        
        <!-- 댓글 작성폼 -->
        <c:choose>
        
	        <c:when test="${user }!=null">
	        <c:choose>
	        
	        	<c:when test="${my }!=null">
	        		<form id="commentWrite" name="commentWriteForm" method="post" action="/discuss/writeComment.do">
					<div class="input-group">
						<span id="input-group-text" class="input-group-text form">댓글</span>
					    <textarea name="commentContent" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="댓글을 작성하세요.">${my.commentContent }</textarea>
					    <input name="discussNo" type="hidden" value="${discuss.discussNo}" />
					    <input class="commentVote" name="vote" type="hidden" value="${my.commentVote}" />
					    <button class="write" type="submit"><!--<i class="xi-pen-o"></i>-->수정</button>
				    </div>
					</form>
	        	</c:when>
	        	
	        	<c:otherwise>
	        	<a href=".vote">
	        		<form id="commentWrite" name="commentWriteForm" method="post" action="/discuss/writeComment.do">
					<div class="input-group abled">
						<span class="input-group-text form">댓글</span>
					    <textarea name="commentContent" id="disabled" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="댓글을 작성하세요." disabled></textarea>
					    <input name="discussNo" type="hidden" value="${discuss.discussNo}" />
					    <input class="commentVote" name="vote" type="hidden" value="Y" />
					    <button class="write" type="submit"><!--<i class="xi-pen-o"></i>-->완료</button>
				    </div>
					</form>
				</a>
	        	</c:otherwise>
	        	
			</c:choose>
			</c:when>
			
			<c:otherwise>
				<form id="commentWrite" name="commentWriteForm" method="post" action="/discuss/writeComment.do">
				<div class="input-group disabled">
		            <span class="input-group-text form">댓글</span>
		            <textarea name="commentContent" class="form-control form" aria-label="With textarea" cols="60" rows="4" maxlength="500" placeholder="로그인 후 댓글 작성 가능합니다." disabled></textarea>
		            <button class="write"><!--<i class="xi-pen-o"></i>-->입력</button>
	            </div>
				</form>
			</c:otherwise>
        
        </c:choose><hr>
        
        <!-- 댓글 목록 -->
        <div class="comment-container">
        
        <div id="comments-pro" class="comments pro">
        	<c:forEach var="proComment" items="${proComment}">
            <div class="comment pro">
                <div class="content">
                    <div class="text">${proComment.get(commentContent)}</div>
                    <div class="id">${proComment.get(userId)}</div>
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
        
		<div id="comments-con" class="comments con">
		<c:forEach var="conComment" items="${conComment}">
            <div class="comment con">
                <div class="content">
                    <div class="text">${conComment.get(commentContent)}</div>
                    <div class="id">${conComment.get(userId)}</div>
                </div>
                <div class="icon">
                	<div class="img">
                		<svg style="width:18px;height:18px" viewBox="0 0 24 24">
                    	<path fill="currentColor" d="M19,15V3H23V15H19M15,3A2,2 0 0,1 17,5V15C17,15.55 16.78,16.05 16.41,16.41L9.83,23L8.77,21.94C8.5,21.67 8.33,21.3 8.33,20.88L8.36,20.57L9.31,16H3C1.89,16 1,15.1 1,14V12C1,11.74 1.05,11.5 1.14,11.27L4.16,4.22C4.46,3.5 5.17,3 6,3H15M15,5H5.97L3,12V14H11.78L10.65,19.32L15,14.97V5Z" />
                    	</svg>
                	</div>
                </div> 
            </div>
		</c:forEach>
		</div>
		
        </div><hr>
        <div class="more">
        	<button class="get" value="1" type="submit"><i class="xi-caret-down-circle-o"></i>더보기</button>
        </div>
		
    </section>
    
    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>

<!-- jQuery Library -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!-- 투표하기 -->
<script>
    var result1=false;
    var result2=false;
    var discussNo=${discuss.discussNo};
    var voteTotal=${vote.get('voteTotal')};
	var votePro=${vote.get('votePro')};
	var voteCon=${vote.get('voteCon')};
    
	
    window.onload=function(){
		$('.votePro').width(votePro/voteTotal*100+'%');
	    $('.voteCon').width(voteCon/voteTotal*100+'%');
	    
	    
	    if(voteCon>votePro){
	    	$('.comment-container').addClass('reverse');
	    	$('.vote').addClass('reverse');
	    }
	    
	    /* 작성한 댓글이 있으면 댓글창 색 바꾸기 */
		if($('.commentVote').val()=='N'){
			$('#input-group-text').css('background-color','rgba(250, 49, 49)');
		}
		else if($('.commentVote').val()=='Y'){
			$('#input-group-text').css('background-color','rgba(69, 49, 250)');
		}
	}
    
    
    $('.votePro').click(function(){
        if(result1||result2){
            alert('이미 투표하셨습니다. 재투표는 불가합니다.');
        }
        else{
            result1=confirm('안건에 찬성하시겠습니까?');
            if(result1){
                var result=confirm('한번 투표 시 재투표가 불가합니다. 정말 찬성하시겠습니까?')
                if(result){
                	alert('찬성하셨습니다. 투표해 주셔서 감사합니다.');
                    $('.votePro').html('<svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M23,10C23,8.89 22.1,8 21,8H14.68L15.64,3.43C15.66,3.33 15.67,3.22 15.67,3.11C15.67,2.7 15.5,2.32 15.23,2.05L14.17,1L7.59,7.58C7.22,7.95 7,8.45 7,9V19A2,2 0 0,0 9,21H18C18.83,21 19.54,20.5 19.84,19.78L22.86,12.73C22.95,12.5 23,12.26 23,12V10M1,21H5V9H1V21Z" /></svg>');
                    $('.input-group-text').css('background-color','rgba(69, 49, 250)');
                    $('.commentVote').val('Y');
                    $('#disabled').attr("disabled",false);
                    $('a').removeAttr("href");
                    $.ajax({
            			url : "/discuss/vote.ajax",
            			type: "get",
            			data : {votePro:1,voteCon:0,discussNo:discussNo},
            			success : function(data){
            				voteTotal++;
            				votePro++;
            				$('.votePro').width(votePro/voteTotal*100+'%');
            			},
            			error : function(data){
            				alert('투표 결과를 반영하지 못했습니다. - 지속적인 오류 발생 시 관리자에게 문의 바랍니다.');
            			}	
            		});
                }
            }
        }
    });
    $('.voteCon').click(function(){
        if(result1||result2){
            alert('이미 투표하셨습니다. 재투표는 불가합니다.');
        }
        else{
            result2=confirm('안건에 반대하시겠습니까?');
            if(result2){
                var result=confirm('한번 투표 시 재투표가 불가합니다. 정말 반대하시겠습니까?')
                if(result){
                    alert('반대하셨습니다. 투표해 주셔서 감사합니다.');
                    $('.voteCon').html('<svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M19,15H23V3H19M15,3H6C5.17,3 4.46,3.5 4.16,4.22L1.14,11.27C1.05,11.5 1,11.74 1,12V14A2,2 0 0,0 3,16H9.31L8.36,20.57C8.34,20.67 8.33,20.77 8.33,20.88C8.33,21.3 8.5,21.67 8.77,21.94L9.83,23L16.41,16.41C16.78,16.05 17,15.55 17,15V5C17,3.89 16.1,3 15,3Z" /></svg>');
                    $('.input-group-text').css('background-color','rgba(250, 49, 49)');
                    $('.commentVote').val('N');
                    $('#disabled').attr("disabled",false);
                    $('a').removeAttr("href");
                    $.ajax({
            			url : "/discuss/vote.ajax",
            			type: "get",
            			data : {votePro:0,voteCon:1,discussNo:discussNo},
            			success : function(data){
            				voteTotal++;
            				voteCon++;
            				$('.voteCon').width(voteCon/voteTotal*100+'%');
            			},
            			error : function(data){
            				alert('투표 결과를 반영하지 못했습니다. - 지속적인 오류 발생 시 관리자에게 문의 바랍니다.');
            			}	
            		});
                }
            }
        }
    });
</script>


<!-- 로그인 안하고 댓글 작성 시도 시 로그인 페이지로 이동-->
<script>
	$('.disabled').click(function(){
		alert('로그인 페이지로 이동합니다.');
		location.replace('/member/goLogin.do');
	});
</script>


<!-- 게시글 내용 기호 변환 -->
<script language="javascript">
	var content="{{discuss.discussContent}}";
	content=content.replaceAll("&lt;","<");
	content=content.replaceAll("&gt;",">");
	content=content.replaceAll("&amp;lt;","<");
	content=content.replaceAll("&amp;gt;",">");
	content=content.replaceAll("&amp;nbsp;"," ");
	content=content.replaceAll("&amp;amp;","&");
	$('#contents').html(content);
</script>

<!-- 댓글 더보기 -->
<script>
	$('#getComment').click(function(){
		var currentCommentPage=$('#getComment').val();
		var discussNo=${discuss.discussNo};
		var totalCount=${totalCount};
		
		if(totalCount/5>=currentCommentPage){
			$.ajax({
				url : "/discuss/getComment.do",
				type: "get",
				data : {currentCommentPage:currentCommentPage,discussNo:discussNo},
				success : function(data){
					for(var i=0;i<data.length;i++){
						if(data[i].comment_vote=='Y'){
							$('<div class="comment pro"><div class="content"><div class="text">'
							+data[i].commentContent
							+'</div><div class="id">'
							+data[i].userId
							+'</div></div><div class="icon"><div class="img"><svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" /></svg></div></div></div>').appendTo('#comments-pro');
						}
						else if(data[i].comment_vote=='N'){
							$('<div class="comment con"><div class="content"><div class="text">'
							+data[i].commentContent
							+'</div><div class="id">'
							+data[i].userId
							+'</div></div><div class="icon"><div class="img"><svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M19,15V3H23V15H19M15,3A2,2 0 0,1 17,5V15C17,15.55 16.78,16.05 16.41,16.41L9.83,23L8.77,21.94C8.5,21.67 8.33,21.3 8.33,20.88L8.36,20.57L9.31,16H3C1.89,16 1,15.1 1,14V12C1,11.74 1.05,11.5 1.14,11.27L4.16,4.22C4.46,3.5 5.17,3 6,3H15M15,5H5.97L3,12V14H11.78L10.65,19.32L15,14.97V5Z" /></svg></div></div></div>').appendTo('#comments-con');
						}
					}
					$('#getComment').val(currentCommentPage+1);
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