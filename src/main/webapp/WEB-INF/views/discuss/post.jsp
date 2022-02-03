<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- JSTL Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>민서네 시민토론 - 게시글</title>
    <style>
        * {
            box-sizing: border-box;
        }
        
        body {
            width: 100%;
            margin: 0;
            padding: 0;
        }
        content {
            width: 100%;
        }
        
        content .inner {
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
        
        #vote{
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
        #vote>div:first-of-type{
            width:60%;
            height:100%;
            margin:auto 0;
            padding-top:2px;
            background-color:rgba(69, 49, 250);
            border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
            color:white;
        }
        #vote>div:last-of-type{
            width:40%;
            height:100%;
            margin:auto 0;
            padding-top:2px;
            background-color:rgba(250, 49, 49);
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
            color:white;
        }
        
        #contents{
            width:100%;
            margin-top:2%;
            margin-left:auto;
            margin-right:auto;
            padding-left:5%;
            font-size:14px;
        }
        
        .inner>div:last-of-type{
            width:100%;
            margin:0 auto;
            display:flex;
            flex-direction: row;
        }
        #pros{
            width:50%;
            margin-top:10px;
        }
        .pros{
            width:97%;
            display:flex;
            flex-direction: row;
            border:1px solid rgba(200, 200, 180);
            border-radius: 8px;
        }
        .pros>div:first-child{
            width:85%;
            margin:10px;
        }
        .pros>div:first-child>div:first-child{
            font-size:12px;
        }
        .pros>div:first-child>div:last-child{
            margin-top:5px;
            font-size:14px;
            color:rgba(110, 110, 100);
        }
        .pros>div:last-child{
            width:15%;
            height:100%;
            margin:auto;
            border-top-right-radius: 8px;
            border-bottom-right-radius: 8px;
            background-color:rgba(69, 49, 250);
            text-align: center;
            color:white;
        }
        
        #cons{
            width:50%;
            margin-top:10px;
        }
        .cons{
            width:97%;
            margin-left:3%;
            display:flex;
            flex-direction: row;
            border:1px solid rgba(200, 200, 180);
            border-radius: 8px;
        }
        .cons>div:first-child{
            width:15%;
            height:100%;
            margin:auto;
            border-top-left-radius: 8px;
            border-bottom-left-radius: 8px;
            background-color: rgba(250, 49, 49);
            text-align: center;
            color:white;
        }
        .cons>div:last-child{
            width:85%;
            height:100%;
            margin:10px;
        }
        .cons>div:last-child>div:first-child{
            font-size:12px;
        }
        .cons>div:last-child>div:last-child{
            margin-top:5px;
            font-size:14px;
            color:rgba(110, 110, 100);
        }
    </style>
    
</head>
<body>
    <content>
      <div class="inner">
        <div>

          <div id="title">
            <div>게시글 제목 겸 토론 주제</div>
            <div>
                <div class="tag"><a href="url">#해시태그</a></div>
            </div>
          </div>

          <div id="vote">
            <div>
                <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                <path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" />
                </svg>
            </div>
            
            <div>
                <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                <path fill="currentColor" d="M19,15V3H23V15H19M15,3A2,2 0 0,1 17,5V15C17,15.55 16.78,16.05 16.41,16.41L9.83,23L8.77,21.94C8.5,21.67 8.33,21.3 8.33,20.88L8.36,20.57L9.31,16H3C1.89,16 1,15.1 1,14V12C1,11.74 1.05,11.5 1.14,11.27L4.16,4.22C4.46,3.5 5.17,3 6,3H15M15,5H5.97L3,12V14H11.78L10.65,19.32L15,14.97V5Z" />
                </svg>
            </div>
          </div>

          <div id="contents">토론 내용</div>

        </div>
        <div>

          <div id="pros">
            <div class="pros">
                <div>
                    <div>찬성 댓글 내용</div>
                    <div>찬성 댓글 작성자</div>
                </div>
                <div>
                    <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M5,9V21H1V9H5M9,21A2,2 0 0,1 7,19V9C7,8.45 7.22,7.95 7.59,7.59L14.17,1L15.23,2.06C15.5,2.33 15.67,2.7 15.67,3.11L15.64,3.43L14.69,8H21C22.11,8 23,8.9 23,10V12C23,12.26 22.95,12.5 22.86,12.73L19.84,19.78C19.54,20.5 18.83,21 18,21H9M9,19H18.03L21,12V10H12.21L13.34,4.68L9,9.03V19Z" />
                    </svg>
                </div>
            </div>
          </div>

          <div id="cons">
            <div class="cons">
                <div>
                    <svg style="width:18px;height:18px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M19,15V3H23V15H19M15,3A2,2 0 0,1 17,5V15C17,15.55 16.78,16.05 16.41,16.41L9.83,23L8.77,21.94C8.5,21.67 8.33,21.3 8.33,20.88L8.36,20.57L9.31,16H3C1.89,16 1,15.1 1,14V12C1,11.74 1.05,11.5 1.14,11.27L4.16,4.22C4.46,3.5 5.17,3 6,3H15M15,5H5.97L3,12V14H11.78L10.65,19.32L15,14.97V5Z" />
                    </svg>
                </div>
                <div>
                    <div>반대 댓글 내용</div>
                    <div>반대 댓글 작성자</div>
                </div>
            </div>
          </div>

        </div>
      </div>
      <div>
          <div id="page" style="text-align: center;"></div>
      </div>
    </content>

<script>
    var result1=false;
    var result2=false;
    $('#vote>div:first').click(function(){
        /*$('#vote>div:first').css('color','black');*/
        var $this=$('#vote>div:first').html();
        if(result1||result2){
            alert('이미 투표하셨습니다. 재투표는 불가합니다.');
        }
        else{
            result1=confirm('안건에 반대하시겠습니까?');
            if(result1){
                var result=confirm('한번 투표 시 재투표가 불가합니다. 정말 반대하시겠습니까?')
                if(result){
                    alert('반대하셨습니다. 투표해 주셔서 감사합니다.');
                    $('#vote>div:first').empty();
                    $('<svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M23,10C23,8.89 22.1,8 21,8H14.68L15.64,3.43C15.66,3.33 15.67,3.22 15.67,3.11C15.67,2.7 15.5,2.32 15.23,2.05L14.17,1L7.59,7.58C7.22,7.95 7,8.45 7,9V19A2,2 0 0,0 9,21H18C18.83,21 19.54,20.5 19.84,19.78L22.86,12.73C22.95,12.5 23,12.26 23,12V10M1,21H5V9H1V21Z" /></svg>').appendTo('#vote>div:first');
                }
            }
        }
    });
    
    $('#vote>div:last').click(function(){
        /*$('#vote>div:last').css('color','black');*/
        if(result1||result2){
            alert('이미 투표하셨습니다. 재투표는 불가합니다.');
        }
        else{
            result2=confirm('안건에 찬성하시겠습니까?');
            if(result2){
                var final=confirm('한번 투표 시 재투표가 불가합니다. 정말 찬성하시겠습니까?')
                if(final){
                    alert('찬성하셨습니다. 투표해 주셔서 감사합니다.');
                    $('#vote>div:last').empty();
                    $('<svg style="width:18px;height:18px" viewBox="0 0 24 24"><path fill="currentColor" d="M19,15H23V3H19M15,3H6C5.17,3 4.46,3.5 4.16,4.22L1.14,11.27C1.05,11.5 1,11.74 1,12V14A2,2 0 0,0 3,16H9.31L8.36,20.57C8.34,20.67 8.33,20.77 8.33,20.88C8.33,21.3 8.5,21.67 8.77,21.94L9.83,23L16.41,16.41C16.78,16.05 17,15.55 17,15V5C17,3.89 16.1,3 15,3Z" /></svg>').appendTo('#vote>div:last');
                }
            }
        }
    });
    
</script>

</body>
</html>