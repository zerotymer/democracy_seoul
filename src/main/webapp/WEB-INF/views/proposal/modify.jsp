<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/post-write.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
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
        
        <div class="container inner" >
            <!-- DHH: 다흐ㅎ흐 -->
           <br>
            <h1 style="text-align: center;">글쓰기</h1><br><br><br><br>
   				 <form action='<c:url value='/proposal/update.do'/>' method="post">
					  <input type="text" name="proposalTitle" class="title" placeholder="제목을 입력하세요" value="${proposal.proposalTitle }" >    
				        <br>
				        	<hr width="800px">
								<div class="textBox">			          
					             <textarea id="ckeditor" class="ckeditor" name="proposalContent"  value="${proposal.proposalContent }"></textarea> 
				                </div>
							 <br>
				
				   		<input type="hidden" name="proposalNo" value="${proposal.proposalNo}">
				   	<button type="submit" class="commit" style="float: right;" a href="/proposal/allList">
				    				  수정하기
				  			</button>
				  	</div>
				</form>  

        		<br><br><br><br><br><br>

           </div>
         </div>
    </section>
    <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>

	<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
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