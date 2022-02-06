<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
    
    
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
    <button class="survey-plus-btn">설문추가</button>
    
    
    <script>
        $(".survey-plus-btn").click(function(){
            //var oneSurvey =$(".one-survey").html();
            var oneSurvey = "<div class='one-survey'><input type='text'><div class='box-btn'><button class='checkbox'>중복선택</button><button class='radio'>단일선택</button><button class='text'>단답식</button><button class='textarea'>서술형</button></div><div class='input-area'></div></div><br>"
            
            $("#surveyWrap").append(oneSurvey);
            
            $(".checkbox").click(function(){
                var answer = "<input type='checkbox'><input type='text'>";

                var inputArea =$(this).parent().next(".input-area").html();

                $(this).parent().next(".input-area").html(inputArea+answer+"<br>");
            });

            $(".radio").click(function(){
                var answer = "<input type='radio'><input type='text'>";

                var inputArea =$(this).parent().next(".input-area").html();

                $(this).parent().next(".input-area").html(inputArea+answer+"<br>");
            });

            $(".text").click(function(){
                var answer = "<input type='text'>";

                var inputArea =$(this).parent().next(".input-area").html();

                $(this).parent().next(".input-area").html(inputArea+answer+"<br>");
            });

            $(".textarea").click(function(){
                var answer = "<textarea></textarea>";

                var inputArea =$(this).parent().next(".input-area").html();

                $(this).parent().next(".input-area").html(inputArea+answer+"<br>");
            });
        });
    </script>
    
</body>
</html>