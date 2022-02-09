/**
 * 
 */
$(document).ready(function(){
	
	//Header navi
	$(".gnb-list>li").mouseenter(function(){
	    $("#header").addClass("on");
	});
	$(".gnb-list>li").mouseleave(function(){
	    $("#header").removeClass("on");
	});
	
	
	//bestReview hover
	$(".swiper-slide").hover(function() {
		$(this).find(".box-review-hover").css("display", "block");
		$(this).find("img").css("transform", "scale(1.1)");
	}, function(){
		$(this).find(".box-review-hover").css("display", "none");
		$(this).find("img").css("transform", "scale(1)");
	});
	
	
	//main-notice btn 전환
	$("#notice").click(function(){
		$("#campaign").removeClass("check");
		$(".box-campaign-list").css('display', 'none');
		
	    $(this).addClass("check");
	    $(".box-notice-list").css('display', 'block');
	    
	});
	$("#campaign").click(function(){
	    $("#notice").removeClass("check");
	    $(".box-notice-list").css('display', 'none');
	    
	    $(this).addClass("check");
		$(".box-campaign-list").css('display', 'block');
	});
	
	
	//crew btn 전환
	$(".btn-created-crew").click(function(){
		$(".btn-joined-crew").removeClass("on");
		$(".area-joined-crew").css('display', 'none');
		
	    $(this).addClass("on");
	    $(".area-created-crew").css('display', 'block');
	});
	
	$(".btn-joined-crew").click(function(){
	    $(".btn-created-crew").removeClass("on");
	    $(".area-created-crew").css('display', 'none');
	    
	    $(this).addClass("on");
		$(".area-joined-crew").css('display', 'block');
	});
	
	
	//noticeFAQ slideDown
    $(".question-box").click(function(){
		if($(this).next(".answer-box").css("display") == "none") {
			$(this).next(".answer-box").slideDown(250);
			$(this).find(".fa-chevron-down").addClass("on");
			
			$(".answer-box").not($(this).next(".answer-box")).slideUp(250);
			$(".fa-chevron-down").not($(this).find(".fa-chevron-down")).removeClass("on");
		}
		else {
			$(this).next(".answer-box").slideUp(250);
			$(this).find(".fa-chevron-down").removeClass("on");
		}
    });
    
    
    //review map slideDown
    $(".map-top").click(function(){
    	
    	if($(this).next(".map-content").css("display")=="none"){
    		$(this).next(".map-content").slideDown(500);
    		$(this).find(".fa-chevron-down").addClass("on");
    	}else {
    		$(this).next(".map-content").slideUp(500);
    		$(this).find(".fa-chevron-down").removeClass("on");
    	}
	});
    
    
    //notice btn 전환
//	$(".btn-notice").click(function(){
//		$(".btn-campaign").removeClass("check");
//		$(".area-campaign").css('display', 'none');
//		
//	    $(this).addClass("check");
//	    $(".area-notice").css('display', 'block');
//	    
//	});
//	$(".btn-campaign").click(function(){
//	    $(".btn-notice").removeClass("check");
//	    $(".area-notice").css('display', 'none');
//	    
//	    $(this).addClass("check");
//		$(".area-campaign").css('display', 'block');
//	});
    
    
    //Admin 네비게이션 토글
    $(".mdl_nav>li").click(function() {
    	
    	if($(this).next(".sub_nav").css("display")=="none"){
    		$(this).next(".sub_nav").slideDown(250);
    		$(this).find(".fa-chevron-down").css("transform","rotate(0deg)");
    		
    		$(".sub_nav").not($(this).next(".sub_nav")).slideUp(250);
			$(".fa-chevron-down").not($(this).find(".fa-chevron-down")).css("transform","rotate(-90deg)");
    	}else {
    		$(this).next(".sub_nav").slideUp(250);
    		$(this).find(".fa-chevron-down").css("transform","rotate(-90deg)");
    	}

    });
    
    
    //maxlength
    $('.input-style').keyup(function(){ 
    	if($(this).val().length > $(this).attr('maxlength')) { 
    		alert('제한길이를 초과했습니다'); 
    		$(this).val($(this).val().substr(0, $(this).attr('maxlength'))); 
		} 
	});
    
    
    //file name 표시
    $("#crewImg").on('change',function(){
    	var fileValue = $("#crewImg").val().split("\\");
    	var fileName = fileValue[fileValue.length-1];

    	$(".file-name").text(fileName);
	});

    
    //가입 alert
    $(".alertJoin").click(function(){
    	alert("크루에 가입해 주세요");
    });

    
});

