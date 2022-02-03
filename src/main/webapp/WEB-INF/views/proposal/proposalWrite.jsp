<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/post-write.css">
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
        
        <div class="container" >
            <!-- DHH: 다흐ㅎ흐 -->
            <br>
            <h1 style="text-align: center;">글쓰기</h1><br><br><br><br>
                <div style="text-align:center;">
                    <input type="text" name="title" class="title" placeholder="제목을 입력하세요" >    
                    <br>
                    <hr width="800px">
                      
                         <textarea id="editor4" class="editor4" name="editor4" placeholder="내용" ></textarea> 
                        <script>CKEDITOR.replace('editor4');</script>
           <br>
            
               
               <button type="submit" class="commit" style="float: right;  background-color: white; border:1px; ">
                글작성
            </button>

        		<br><br><br><br><br><br>
            

            
           </div>
         </div>
    </section>
    <script src="/resources/script/content-frame.js"></script>
</body>
</html>