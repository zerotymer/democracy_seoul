<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/post-write.css">

</head>
<body>
    <header>
		<%@ include file="/includes/header.jsp"%>
	</header>

    <section>
        <div class="content-frame">
            <div class="frame-image">
                <div class="inner">
                    <h2>게시글 수정</h2>
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
                            <h3>서울시가 묻습니다<span class="slick-arrow"></span></h3>
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
        <div class="container inner" >
            <!-- DHH: 다흐ㅎ흐 -->
           <br>
            <h1 style="text-align: center;">수정하기</h1><br><br><br><br>
 				<form action="/proposal/update.do" method="post">
					  <input type="text" name="proposalTitle" class="title" placeholder="제목을 입력하세요" value="${proposal.proposalTitle }" >    
				       		 <br>
				        		<hr width="800px"> 
				        		<div class="textBox">			          
					             		<textarea id="ckeditor" class="ckeditor" name="proposalContent">${proposal.proposalContent }</textarea> 
				                </div><br>
				   		<input type="hidden" name="proposalNo" value="${proposal.proposalNo}">
				   	<button type="submit" class="commit" style="float: right;" a href="/proposal/allList">
				    				  수정하기
				  	</button>
				</form> 
				  	</div>
				<br><br><br><br><br><br>
           </div>
         </div>
    </section>

    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>

    <script
        src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>

	<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/content-frame.js"></script>
    <script>
	    // 3. CKEditor5를 생성할 textarea 지정
	    ClassicEditor
	        .create( document.querySelector( '#ckeditor' ) )
	        .catch( error => {
	            console.error( error );
	        } );
	    
	  //글쓰기 폼으로 이동하게 하는 함수
		$(document).ready(function(){    
		        $("#btnWrite").click(function(){
		            location.href="/allList.do";
		        });
		});
    </script>
</body>
</html>