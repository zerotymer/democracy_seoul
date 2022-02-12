<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>시민제안 &gt; 시민제안 등록 | 민주주의 서울</title>
<script type="text/javascript" src="/cso/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    
    var tag     = {};
    var counter = 0;
    
    $(document).ready(function () {
        
        document.getElementById("main_addr_depth1").disabled = true;
        $("#main_addr_depth1 option:eq(0)").attr("selected", "selected");
        document.getElementById("main_addr_depth2").disabled = true;
        $("#main_addr_depth2").html("<option value='0'>선택</option>");
        document.getElementById("main_addr_depth3").disabled = true;
        $("#main_addr_depth3").html("<option value='0'>선택</option>");
        $('#main_addr_depth1').css("background-color", "#e6e6e6");
        $('#main_addr_depth2').css("background-color", "#e6e6e6");
        $('#main_addr_depth3').css("background-color", "#e6e6e6");
    
        var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;
    
        function addCheck (value) {
            if( !pattern_spc.test(value)){
                return true
            }else{
                alert("특수문자는 입력 불가능 합니다.!!!");
                return false
            }
        }
        
        if($("input:checkbox[id='chkEmail']").is(":checked") == true){
             $("#emailTr").show();
        }else{
             $("#emailTr").hide();              
        }
        // 삭제 버튼 
        // 삭제 버튼은 비동기적 생성이므로 document 최초 생성시가 아닌 검색을 통해 이벤트를 구현시킨다.
        $(document).on("click", ".del-btn", function (e) {
            var index = $(this).attr("idx");
            tag[index] = "";
            $(this).parent().remove();
        });
        
        
        $(function(){
            $("#addrCheckBox").click(function(){
                var chk = $(this).is(":checked");//.attr('checked');
                if(chk){
                    
                    document.getElementById("main_addr_depth1").disabled = false;
                    document.getElementById("main_addr_depth2").disabled = false;
                    document.getElementById("main_addr_depth3").disabled = false;
                    $('#main_addr_depth1').css("background-color", "#ffffff");
                    $('#main_addr_depth2').css("background-color", "#ffffff");
                    $('#main_addr_depth3').css("background-color", "#ffffff");
                    
                    
                }else{
                    
                    document.getElementById("main_addr_depth1").disabled = true;
                    $("#main_addr_depth1 option:eq(0)").attr("selected", "selected");
                    document.getElementById("main_addr_depth2").disabled = true;
                    $("#main_addr_depth2").html("<option value='0'>선택</option>");
                    document.getElementById("main_addr_depth3").disabled = true;
                    $("#main_addr_depth3").html("<option value='0'>선택</option>");
                    $('#main_addr_depth1').css("background-color", "#e6e6e6");
                    $('#main_addr_depth2').css("background-color", "#e6e6e6");
                    $('#main_addr_depth3').css("background-color", "#e6e6e6");
                }
            });
        });
    })

    //formcheck
    function dataSubmit() {
        
        var frm = document.frm;
        
        if( isFieldCheck(frm.title,"제목을 입력하세요.")) {
            document.getElementById("suggest_tit").focus();
            return false; 
        }
        
        /*
        if( isFieldCheck(frm.sugg_contact1,"휴대폰 번호를 입력하세요.")) { 
            document.getElementById("sugg_contact1").focus();
            return false; 
        }
        if( isFieldCheck(frm.sugg_contact2,"휴대폰 번호를 입력하세요.")) {
            document.getElementById("sugg_contact2").focus();
            return false; 
        }
        if( isFieldCheck(frm.sugg_contact3,"휴대폰 번호를 입력하세요.")) {
            document.getElementById("sugg_contact3").focus();
            return false; 
        }        
        */
        
        if( isFieldCheck(frm.sugg_contact1,"휴대폰 번호 첫자리를 입력하세요.")) { 
            document.getElementById("sugg_contact1").focus();
            return false; 
        }
        if( isFieldCheck(frm.sugg_contact2,"휴대폰 번호 중간자리를 입력하세요.")) {
            document.getElementById("sugg_contact2").focus();
            return false; 
        }
        if( isFieldCheck(frm.sugg_contact3,"휴대폰 번호 끝자리를 입력하세요.")) {
            document.getElementById("sugg_contact3").focus();
            return false; 
        }
        if($("input:checkbox[id='chkKakao']").is(":checked") == true){
            $('#chk_kakao_val').val('Y');            
        }else{
            $('#chk_kakao_val').val('N');                           
        }       
        if($("input:checkbox[id='chkEmail']").is(":checked") == true){
            if( isFieldCheck(frm.sugg_email1,"이메일 첫자리를 입력하세요.")) {
                document.getElementById("sugg_email1").focus();
                return false; 
            }           
            if( isFieldCheck(frm.sugg_email2,"이메일 끝자리를 입력하세요.")) {
                document.getElementById("sugg_email2").focus();
                return false; 
            }
            $('#chk_email_val').val('Y');
        }else{
            $('#chk_email_val').val('N');           
        }
        

        oEditors.getById["ir1"].exec("UPDATE_IR_FIELD", []);
        frm.content.value = document.getElementById("ir1").value;
        
        var str = strip_tags(frm.content.value, '');
        if( str == '' ){
            alert('내용을 입력하세요');
//          frm.content.focus();
            return false;
        }
        
        if( document.getElementById("suggest_tit").value.length < 5){
            alert("제목을 5자 이상 입력하세요. ");
            document.getElementById("suggest_tit").focus();
            return false;
        }

        var sugg_contact = frm.sugg_contact1.value + "_" + frm.sugg_contact2.value + "_" + frm.sugg_contact3.value;
        $("#sugg_contact").val(sugg_contact);
        
        var sugg_email = frm.sugg_email1.value + "@" + frm.sugg_email2.value;
        $('#sugg_email').val(sugg_email);
        $('#hashTagArr').val($('#hero-demo').val());
        
        var main_addr_depth1 = "";
        var main_addr_depth2 = "";
        var main_addr_depth3 = "";
        var final_choice = ""; // 관련지역 최종 위치
        
        if($("input:checkbox[id='addrCheckBox']").is(":checked") == true){
            if($('#main_addr_depth2').val() == '0'){
                alert('지역관련 체크시 [구] or [동] 까지 선택하여야 합니다.')
                return;
            }else{
                main_addr_depth1 = $('#main_addr_depth1').val();
                main_addr_depth2 = $('#main_addr_depth2').val();
                main_addr_depth3 = $('#main_addr_depth3').val();
                
                if (main_addr_depth3 != "") {
                    final_choice = main_addr_depth3;
                } else if (main_addr_depth2 != "") {
                    final_choice = main_addr_depth2;
                } else {
                    final_choice = main_addr_depth1;
                }
                
                $('#addr_code').val(final_choice);
            }
        }
        
        if( !confirm("등록 하시겠습니까?") ){
            return;
        }
        
        if (frm.value == "y") {
            alert("등록 중입니다. ");
            return false;
        }
        var hostUrl = "https://democracy.seoul.go.kr/front/suggest/freeSuggestInsertFrm.do";
        var up_params = {content: document.getElementById("ir1").value, file1: document.getElementById("suggest_file").value,hostUrl:hostUrl };
        var tmp_data = new FormData(frm);
        
        $.ajax({
            //url: 'http://api73.eseoul.go.kr:5500/UPServer/',   dev
            url: 'https://api73.eseoul.go.kr:5443/UPServer/', // real
            enctype: 'multipart/form-data',
    		processData: false,
    		contentType: false,
            type: 'post',
            crossDomain: true,
            data:tmp_data,
            cache: false,
            error:function(request,status,error){
                alert("--->code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                frm.value = "y";
            },
            success: function(res){
                var data_result = JSON.parse(res);
                if (data_result.privacy[0].isPriv == '0') {
                    frm.value = "y";
                    frm.submit();
                } else {
                	if(data_result.privacy[0].privType == '5'){
                        frm.value = "y";
                        frm.submit();
                	}
                	else{
                		alert('작성하신 제안 내용 및 파일에 개인정보 및 금칙어가 포함되어 있어 등록이 거부되었습니다.');
                	}
                }
            }
        });
    }

    function titleInsert(value) {
        if (value == "제목을 입력하세요") {
            $("#title").val('');
        }
    } 
    
    // 임시 저장
    function temporary() {
        
        var frm = document.frm;
        if( isFieldCheck(frm.title,"제목을 입력하세요. ") ) { return false; }
        oEditors.getById["ir1"].exec("UPDATE_IR_FIELD", []);
        frm.content.value = document.getElementById("ir1").value;
        
        var str = strip_tags(frm.content.value, '');
        if( str == '' ){
            alert('내용을 입력하세요');
            return false;
        }
        //if( isFieldCheck(frm.content,"내용을 입력하세요. ") ) { return false; }
        
        if (confirm("임시저장을 하게되면 현재 제안글은 등록 되지 않습니다. \n그래도 임시저장 하시겠습니까? ")) {
            if (frm.value == "y") {
                alert("등록 중입니다. ");
                return false;
            }
            frm.value = "y";
            frm.action = "/front/suggest/suggestInsertTmp.do";
            frm.submit();   
            
        } else {
            return false;
        }
    }
    
    function digit_check(evt){
        var code = evt.which?evt.which:event.keyCode;
        if(code < 48 || code > 57){
            return false;
        }
    }
    
    function check(){
        document.getElementById('suggest_file').click();
    }
    //카카오톡,이메일 체크
    function chkFunction(val){
        if(val == 'k'){
            if($("input:checkbox[id='chkKakao']").is(":checked") == true){
                $("#chk_kakao_val").val('Y');
            }else{
                $("#chk_kakao_val").val('N');                   
            }           
        }else if(val == 'e'){
             if($("input:checkbox[id='chkEmail']").is(":checked") == true){
                $("#emailTr").show();
                $("#chk_email_val").val('Y');
             }else{
                $("#emailTr").hide();
                $("#chk_email_val").val('N');                 
             }   
        }
    //document.getElementById('phoneTr').hide
    }
    
    function enterkey() {
        if (window.event.keyCode == 13) {
             // 엔터키가 눌렸을 때 실행할 내용
            //alert('asdf');
        }
    }
    
    function get_addr_depth(sDeptDepth, sDeptPCode, selectTagPre) {
        if(sDeptPCode !=""){
            if (sDeptDepth == 3 && sDeptPCode == "") {
                $("#"+selectTagPre+sDeptDepth).html("");
            } else if (sDeptDepth == 2 && sDeptPCode == "") {
                    $("#"+selectTagPre+sDeptDepth).html("");
                    $("#"+selectTagPre+(sDeptDepth-1)).html("");
            } else {
                $.ajax({
                    type: "POST",
                    url: "/front/suggest/getAddrList.do",
                    data: "sDeptDepth="+sDeptDepth+"&sDeptPCode="+sDeptPCode,
                    success: function(html) {
                        $("#"+selectTagPre+sDeptDepth).html(html);
                    }
                });
            }
        }
    }

    </script>
<link rel="stylesheet" type="text/css" media="all"
	href="//www.seoul.go.kr/seoulgnb/seoul-common-gnb.css">




<link rel="stylesheet" href="/resources/style/header.css">
<link rel="stylesheet" href="/resources/style/footer.css">
<link rel="stylesheet" href="/resources/style/color.css">
<link rel="stylesheet" href="/resources/style/content-frame.css">
<link rel="stylesheet" href="/resources/style/card-container.css">
<link rel="stylesheet" href="/resources/style/list-frame.css">
<style>
body {
	background-color: var(- -COLOR-WHITE);
	margin: 0;
	/* no Scrollbar */
	-ms-overflow-style: none; /* IE and Edge */
	scrollbar-width: none; /* Firefox */
}

body::-webkit-scrollbar {
	display: none; /* Chrome, Safari, Opera*/
}

header {
	z-index: 10;
}

section {
	position: relative;
	width: 100%;
	min-height: 90vh;
	/* overflow: scroll; */
}
</style>

<!--////////////////////////////////////////////////////////////////// -->







<!--  -->

</head>
<body>
	<header>
		<%@ include file="/includes/header.jsp"%>
	</header>

	<section>
		<div class="content-frame">
			<div class="frame-image">
				<div class="inner">
					<h2>시민제안</h2>
				</div>
			</div>
			<div class="frame-menu">
				<div class="inner menubar">
					<ul>
						<li class="menubar-icon"><a href="/">
								<div class="icon home"></div>
						</a></li>
						<li class="menubar-list">
							<h3>
								참여하기<span class="slick-arrow"></span>
							</h3> <!-- Menu -->
							<ul class="include menu">
								<li class="menuitem"><a href="">참여하기</a>
									<ul class="submenu">
										<li><a href=""></a>시민제안</li>
										<li><a href=""></a>시민토론</li>
										<li><a href=""></a>서울시가 묻습니다</li>
									</ul></li>
								<li class="menuitem"><a href="">결과보기</a>
									<ul class="submenu">
										<li><a href="">제안결과</a></li>
										<li><a href="">공론결과</a></li>
									</ul></li>
								<li class="menuitem"><a href="">알아보기</a>
									<ul class="submenu">
										<li><a href="">민주주의 서울 <wbr />소개
										</a></li>
										<li><a href="" style="font-size: 13px;">민주주의 서울 <wbr />이야기
										</a></li>
										<li><a href="">공지사항</a></li>
										<li><a href="">자료실</a></li>
										<li><a href="">행사일정</a></li>
									</ul></li>
								<li class="menuitem"><a href="">서울시민회의</a>
									<ul class="submenu">
										<li><a href="">서울시민회의 <wbr />소개
										</a></li>
										<li><a href="">서울시민회의 <wbr />소식
										</a></li>
									</ul></li>
								<li class="menuitem"><a href="">시민참여예산</a></li>
							</ul>
						</li>
						<li class="menubar-list">
							<h3>
								시민제안<span class="slick-arrow"></span>
							</h3>
							<ul class="menu">
								<li class="menuitem"><a href="">시민제안</a></li>
								<li class="menuitem"><a href="">시민토론</a></li>
								<li class="menuitem"><a href="">서울시가 묻습니다.</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>



		<!--  여기서부터  -->


		<div class="content-box">

			<div id="content" class="content">

				<div class="info-lst">
					<ul>
						<li>정치적 목적, 특정인 또는 단체에 대한 비방·명예훼손, 상업성 광고, 유사한 내용을 반복적으로 올리는
							경우, 욕설·음란물 등 불건전한 게시물은 관리자에 의해 삭제될 수 있습니다.<br> <a href="#"
							onclick="layerShow('layer03')" title="홈페이지 운영 활성화에 관한 조례">(자세히
								보기)</a>
						</li>
						<li><span style="color: blue">민원, 불편, 개선</span>, 부조리 신고, 홍보
							등은 <a href="https://eungdapso.seoul.go.kr/" target="_blank">응답소</a>
							(https://eungdapso.seoul.go.kr) 로 등록해 주십시오.<br>(서울시 정책 제안이
							아닌 경우 부서답변 되지 않을수 있습니다.)</li>
						<li>제안 기준에 맞지 않는 부적절한 게시물은 이동 또는 삭제 조치됩니다. <a href="#"
							onclick="layerShow('layer01')" title="저작권 및 콘텐츠 이용안내 팝업">저작권
								및 콘텐츠 이용안내</a></li>
						<li><span class="ico-ess-mark">필수항목</span> 표시는 필수입니다.</li>
						<li>좋은 제안 선정 설명입니다. <a href="#"
							onclick="layerShow('layer02')" title="좋은 제안 선정 설명 팝업 ">좋은 제안
								선정 안내</a></li>
						<li>한글문서에서 작성한 내용을 복사 후 붙여넣기는 자제해 주십시오.</li>
					</ul>
				</div>
				<!-- 테이블 영역 -->
				<div class="table-box">
					<table class="table-ty02">
						<caption>제목, 휴대폰, 이메일, 내용, 첨부파일, 태그추가, 관련지역을 등록하는 시민제안
							등록 리스트입니다.</caption>
						<colgroup>
							<col style="width: 130px">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">제목<span class="ico-ess-mark">필수항목</span></th>
								<td>
									<div class="box-table-form">
										<span class="cell full"> <input type="text"
											id="suggest_tit" name="title" style="width: 100%"
											maxlength="500" title="제목" class="input-ty01"
											wtx-context="6EE9065E-BD3E-4B05-83BB-EB08FA69F88F">
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">진행 알림 <br>메신저 선택
								</th>
								<td>
									<div class="box-table-form" style="height: 40px;">
										<span class="form-radio"> <input type="checkbox"
											name="chkKakao" id="chkKakao" onclick="chkFunction('k');"
											checked="" wtx-context="30EA21FB-63CA-4558-B0F1-B25B781B2FF9">
											<label for="chkKakao">카카오톡(문자)</label> &nbsp;&nbsp;<input
											type="checkbox" name="chkEmail" id="chkEmail"
											onclick="chkFunction('e');" checked=""
											wtx-context="09E4BDDE-09E3-49FF-9040-18FF5CCF7E9E"> <label
											for="chkEmail">이메일</label>
										</span>

									</div>
								</td>
							</tr>
							<tr id="phoneTr">
								<th scope="row">휴대폰<span class="ico-ess-mark">필수항목</span></th>
								<td>
									<div class="box-table-form">
										<span class="cell"> <input type="text"
											id="sugg_contact1" name="sugg_contact1" value=""
											class="input-ty01" title="휴대폰 첫번째자리"
											style="ime-mode: disabled;" maxlength="3"
											onkeypress="return digit_check(event)"
											wtx-context="50D0CAFC-C5A2-46E2-8A6D-7AB60A6EEA19">
										</span> <span class="cell bar">-</span> <span class="cell"> <input
											type="text" id="sugg_contact2" name="sugg_contact2" value=""
											class="input-ty01" title="휴대폰 두번째자리"
											style="ime-mode: disabled;" maxlength="4"
											onkeypress="return digit_check(event)"
											wtx-context="C331932D-CA61-444F-8EAC-12C667CAA6A2">
										</span> <span class="cell bar">-</span> <span class="cell"> <input
											type="text" id="sugg_contact3" name="sugg_contact3" value=""
											class="input-ty01" title="휴대폰 세번째자리"
											style="ime-mode: disabled;" maxlength="4"
											onkeypress="return digit_check(event)"
											wtx-context="948E92B1-A353-498B-8B05-0F792F68B042">
										</span> <span class="txt-table-info">※ 휴대폰 번호는 누구에게도 공개되지
											않습니다.</span>
									</div>
								</td>
							</tr>

							<tr id="emailTr">
								<th scope="row">이메일<span class="ico-ess-mark">필수항목</span></th>
								<td>
									<div class="box-table-form mail">
										<span class="cell"> <input type="text" id="sugg_email1"
											name="sugg_email1" value="" class="input-ty01"
											title="이메일 앞자리" style="ime-mode: disabled;"
											wtx-context="345FB156-E992-4293-A8FB-67822F43DAA2">
										</span> <span class="cell at">@</span> <span class="cell"> <input
											type="text" id="sugg_email2" name="sugg_email2" value=""
											class="input-ty01" title="이메일 뒷자리"
											style="ime-mode: disabled; width: 150px;"
											wtx-context="1BBF9021-FC96-45B5-8691-E8024040A3B8">
										</span> <span class="cell hyphen"></span>
										<!-- <span class="cell">
                                                    <select title="이메일선택">
                                                        <option value="">이메일선택</option>
                                                        <option value="">1</option>
                                                    </select>
                                                </span> -->
										<span class="txt-table-info">※50공감 달성 및 부서답변 시 알림 전송</span>
									</div>
								</td>
							</tr>

	<tr>
		<th scope="row">내용<span class="ico-ess-mark">필수항목</span></th>
			<td>
				<div id="editor">
					<script>
					 
					//글쓰기 폼으로 이동하게 하는 함수
					$(document).ready(function(){    
					        $("#btnWrite").click(function(){
					            location.href="/proposal/proposalWrite.do";
					        });
					});
					 
					</script>
				<!-- 	
				<iframe frameborder="0" scrolling="no" title="editor"
						style="width: 100%; height: 453px;"
						src="/oasis/SEditor/SEditorSkin.html">
				</iframe>
				 -->
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">첨부파일</th>
								<td>
									<div class="box-table-form">
										<div class="input-file">
											<input type="text" title="첨부파일" id="ffl_tx"
												wtx-context="DA0E9FCD-89C4-4279-8AC6-307486BD5814">
											<input type="file" title="첨부파일" id="suggest_file"
												name="file1"
												onchange="javascript:document.getElementById('ffl_tx').value=this.value"
												onfocus="focusFunction()" onblur="blurFunction()"
												wtx-context="C5101DAD-DF43-4BA2-AC40-801C5081314D">
											<label id="fileBoxId" for="upload" class="file-label"
												onclick="check()">파일첨부</label> <span class="txt-table-info">※
												파일 용량 10MB제한</span>
										</div>
									</div>
								</td>
							</tr>
							
							
							<tr>
								<th scope="row">관련지역</th>
								<td>
									<div class="box-table-form place">
										<span class="form-radio"> <input type="checkbox"
											name="addrCheckBox" id="addrCheckBox" value="N"
											wtx-context="358A77BE-E99F-4365-B613-946C8F109286"> <label
											for="addrCheckBox">지역관련</label>
										</span> <label for="main_addr_depth1" class="hd-element">시/도선택</label>
										<span id="addrCheckBox"> <select
											name="main_addr_depth1" id="main_addr_depth1"
											onchange="get_addr_depth('2', this.value, 'main_addr_depth');"
											class="form-control"
											style="width: 200px; background-color: rgb(230, 230, 230);"
											disabled=""
											wtx-context="A2A4D689-3894-4421-89F1-DB4D4DF74003">
												<option value="" selected="selected">시/도 선택</option>

												<option value="1100000000">서울특별시</option>

										</select> <span class="cell hyphen"></span> <label
											for="main_addr_depth2" class="hd-element">시/군/구 선택</label> <select
											name="main_addr_depth2" id="main_addr_depth2"
											onchange="get_addr_depth('3', this.value, 'main_addr_depth');"
											class="form-control"
											style="width: 200px; background-color: rgb(230, 230, 230);"
											disabled=""
											wtx-context="5940BB2D-F3A9-47BE-8543-24CB9CA5B416"><option
													value="0">선택</option></select> <span class="cell hyphen"></span> <label
											for="main_addr_depth3" class="hd-element">읍/면/동 선택</label> <select
											name="main_addr_depth3" id="main_addr_depth3"
											class="form-control"
											style="width: 200px; background-color: rgb(230, 230, 230);"
											disabled=""
											wtx-context="F51653C1-1F2C-4F73-9D7E-D2B8A0AF4852"><option
													value="0">선택</option></select>
										</span> <span class="txt-table-info">지역과 관련한 시민제안일 경우에는 해당 지역을
											선택해 주십시오. (구 또는 동까지 선택 가능) </span>
									</div>
								</td>
							</tr>


						</tbody>
					</table>
				</div>
				<!-- //테이블 영역 -->

				<div class="btn-area">
					
					<button type="button" class="btn btn-solid2 xlg"
						onclick="dataSubmit(); return false;">
						<span>등록하기</span>
					</button>
				</div>
			</div>
		</div>





		<!-- 여기까지 -->





	</section>

	<footer>
		<%@ include file="/includes/footer.jsp"%>
	</footer>

	<script src="/resources/script/header.js"></script>
	<script src="/resources/script/content-frame.js"></script>
	<script src="/resources/script/card-container.js"></script>
</body>
</html>