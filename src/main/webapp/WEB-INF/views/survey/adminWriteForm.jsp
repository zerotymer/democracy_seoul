<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
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
	    <button type="button" class="survey-plus-btn">설문 추가</button>
	    <button type="button" class="survey-delete-btn">설문 삭제</button>
    </form>
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
    	var qNo=1;
    	
        $(".survey-plus-btn").click(function(){
        	
        	//질문 10개까지 제한
        	if(qNo<11){
                var oneSurvey = "<div class='one-survey'>"+qNo+". <input class='contentQ' type='text'><div class='box-btn'><button type='button' class='checkbox'>중복선택</button><button type='button' class='radio'>단일선택</button><button type='button' class='text'>단답식</button><button type='button' class='textarea'>서술형</button><button type='button' class='delete'>삭제</button><button type='button' class='change' style='display:none;'>변경</button><button type='button' class='complete'>완료</button></div><input class='input_type' name='question_input_type' type='hidden'/><input class='question' name='question_content' type='hidden'/></div><br>"
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
                	$(this).parent().siblings(".question").val(qNo-1);
                	var result=$(this).parent().siblings(".question").val();

                	$(this).text('추가');
                	$(this).siblings('.radio').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                	
                	$('.complete').click(function(){
                		
                		$(this).parent().siblings('.content').each(function(index){
                			var content=$(this).parent().siblings('.content').val();
                		});
                		console.log(content);
                		//입력폼에 입력한 내용
                		/* var content=$(this).parent().siblings('.content').val(); */
                		
                		
                		/* var result=$(this).siblings('.question').val();
                		
                		$(this).siblings('.question').val(result+'/'+content);
                		var re=$(this).siblings('.question').val();
                		console.log(re); */
                		$(this).text('수정');
                	});
                });

              	//문항타입 단일선택 선택 시
                $(".radio").click(function(){
					var content="<input type='text' class='content'/><br>";
                	
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo+'/'+2);
                	
                	//qNo번 질문의 문항 내용 입력폼 생성
                	$(this).parent().parent('.one-survey').append(content);
                	
                	//방금 추가된 입력폼에 입력한 내용
                	var content=$(this).parent().parent('.one-survey').children('.content').last().val();

                	//qNo번 질문의 문항 내용 저장
                	$(this).parent().next(".question").val(qNo+'/'+content+'/');
                	
                	$(this).text('추가');
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });

              	//문항타입 단답식 선택 시
                $(".text").click(function(){
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo+'/'+3);
                	
                	$(this).css('display','none');
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
                	$(this).siblings('.change').css('display','inline-block');
                });

              	//문항타입 서술형 선택 시
                $(".textarea").click(function(){
                	//qNo번 질문의 답변 타입 저장
                	$(this).parent().next(".input_type").val(qNo+'/'+4);
                	
                	$(this).css('display','none');
                	$(this).siblings('.checkbox').css('display','none');
                	$(this).siblings('.text').css('display','none');
                	$(this).siblings('.textarea').css('display','none');
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
                });
                
                $('.delete').click(function(){
                	$(this).parents('.one-survey').children('.content').last().remove();
                	$(this).parents('.one-survey').children('.complete').last().remove();
                	var no=$("input[class='content']").length;
                	var qnoContent=$(this).parent().next('.question').val();
                	console.log(qnoContent);
                	var content=qnoContent.split('/')[no-1];
                })
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