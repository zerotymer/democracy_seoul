<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>민주주의 서울 - 설문지 폼 작성</title>
	
	<link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
	
	<style>
		form{
			width:70%;
			min-height:500px;
			margin:auto;
			padding:20px;
			border:1px solid rgba(200, 200, 180);
			border-radius:10px;
		}
		button{
			margin-right:2px;
			padding:5px;
			padding-left:10px;
			padding-right:10px;
			border-radius:5px;
			border:1px solid rgba(200, 200, 180);
			background-color:rgba(250, 250, 250);
		}
		
		#surveyWrap{
			width:94%;
			padding:20px;
			min-height:450px;
			margin:auto;
			/* border:1px solid rgba(200, 200, 180); */
		}
		
		.contentQ{
			font-size:20px;
		}
		
		.one-survey button{
			margin-top:3px;
			margin-bottom:5px;
			background-color:rgba(204, 229, 255);
			border-color:rgba(204, 219, 255);
		}
		
		.content{
			margin-left:20px;
			margin-bottom:3px;
			font-size:15px;
		}
		
		#submit{
			margin-top:10px;
			display:flex;
			align-items:center;
            justify-content:center;
		}
	</style>

</head>
<body>

	<header>
        <%@ include file="/includes/header.jsp" %>
    </header>

	<form name="surveyWriteForm" method="post" action="/survey/adminWrite.do">
		<button type="button" class="survey-plus-btn">설문 추가</button>
	    <button type="button" class="survey-delete-btn">설문 삭제</button>
	    
		<div id="surveyWrap">
		<!--
	        <div class="one-survey">
	            <input type="text">
	            <div class="box-btn">
	                <button class="checkbox">체크박스</button>
	                <button class="radio">체크박스</button>
	                <button class="text">체크박스</button>
	                <button class="textarea">체크박스</button>
	            </div>
	            <div class="input-area">
	                
	            </div>
	        </div>
		-->
	    </div>
	    
	    <div id="submit"><button type="submit" class="survey-submit-btn">설문 작성 완료</button></div>
    </form>
    
    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
    	var qNo=1;
    	
        $(".survey-plus-btn").click(function(){
        	
        	//질s문 10개까지 제한
        	if(qNo<11){
                var oneSurvey = "<div class='one-survey'>"+qNo+". <textarea class='contentQ' name='contentQ'></textarea><div class='box-btn'><button type='button' class='checkbox'>중복선택</button><button type='button' class='radio'>단일선택</button><button type='button' class='text'>단답식</button><button type='button' class='textarea'>서술형</button><button type='button' class='delete'>삭제</button><button type='button' class='change' style='display:none;'>변경</button><button type='button' class='complete'>완료</button></div><input class='input_type' name='questionInputType' type='hidden'/><input class='question' name='questionContent' type='hidden'/></div><br>"
                qNo++;
                
                //질문폼 생성
                $("#surveyWrap").append(oneSurvey);
                
              	//문항타입 중복선택 선택 시
                $(".checkbox").click(function(){
                	var content="<input type='text' class='content'/><br>";
                	
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo-1+'/'+1);
                	
                	//qNo번 질문의 문항 내용 입력폼 생성
                	$(this).parent().parent('.one-survey').append(content);
                	
                	//qNo번 질문의 문항 내용 저장
                	//$(this).parent().siblings(".question").val(qNo-1);
                	//var result=$(this).parent().siblings(".question").val();

                	$(this).text('중복선택 추가');
                	$(this).siblings('.radio').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });
              	
              	//문항타입 단일선택 선택 시
                $(".radio").click(function(){
					var content="<input type='text' class='content'/><br>";
                	
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo-1+'/'+2);
                	
                	//qNo번 질문의 문항 내용 입력폼 생성
                	$(this).parent().parent('.one-survey').append(content);
                	
                	//방금 추가된 입력폼에 입력한 내용
                	var content=$(this).parent().parent('.one-survey').children('.content').last().val();

                	//qNo번 질문의 문항 내용 저장
                	//$(this).parent().next(".question").val(qNo+'/'+content+'/');
                	
                	$(this).text('단일선택 추가');
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });

              	//문항타입 단답식 선택 시
                $(".text").click(function(){
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo-1+'/'+3);
                	
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.radio').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });

              	//문항타입 서술형 선택 시
                $(".textarea").click(function(){
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo-1+'/'+4);
                	
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.radio').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });
                
                //문항타입 변경
                $('.change').click(function(){
                	var typeNo=$(this).parent().next('.input_type').val();
                	var inputTypeNo=typeNo.split('/')[1];
                	var text;
                	var type;
                	
                	if(inputTypeNo=='1'){
                		text='중복선택';
                		type='checkbox';
                	}
                	else if(inputTypeNo=='2'){
                		text='단일선택';
                		type='radio';
                	}
                	else if(inputTypeNo=='3'){
                		text='단답식';
                		type='text';
                	}
                	else if(inputTypeNo=='4'){
                		text='서술형';
                		type='textarea';
                	}
                	$(this).siblings('.'+type).text(text);
                	$(this).siblings('.checkbox').css('display','inline-block');
                	$(this).siblings('.radio').css('display','inline-block');
                	$(this).siblings('.text').css('display','inline-block');
                	$(this).siblings('.textarea').css('display','inline-block');
                	$(this).css('display','none');
                	$(this).parent().siblings('.content').remove();
                	$(this).parent().siblings('br').remove();
                });
                
                $('.delete').click(function(){
                	$(this).parents('.one-survey').children('.content').last().remove();
                	$(this).parents('.one-survey').children('.complete').last().remove();
                	$(this).parents('.one-survey').children('br').last().remove();
                	/* var no=$("input[class='content']").length;
                	var qnoContent=$(this).parent().next('.question').val();
                	var content=qnoContent.split('/')[no-1]; */
                })
                
                //입력한 내용 취합
                $('.complete').click(function(){
                	
            		var $content = $(this).parent().siblings('.content');
            		var str = qNo-1;
            		 $content.each(function(index,item){
            			 var data = $(item).val();
            			 str +="/"+data;
            		});
            		$(this).parent().siblings('.question').val(str);
            		$(this).text('수정');
            	});
        	}
        	else{
        		alert('더이상 문항을 추가할 수 없습니다.');
        	}
        });
        
        $('.survey-delete-btn').click(function(){
        	$(this).siblings('#surveyWrap').children('.one-survey').last().remove();
        	$(this).siblings('#surveyWrap').children('br').last().remove();
        	qNo--;
        });
    </script>

</body>
</html>