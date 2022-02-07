<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>민주주의 서울  회원가입</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/commons/default.css">
<link rel="stylesheet" href="/resources/style/member/commons/common.css">
<link rel="stylesheet" href="/resources/style/member/css/memberJoinus.css">
	<!-- 비밀번호 유효성 검사 확인 및 이메일-->
	
</head>

<body>

<script>
		let val = false;
	    //비밀번호 일치 및 조건
        function pwCheck(){
            var userPwd = document.getElementById('userPwd').value;
            var SC = ["!","@","#","$","%","^","&","*","(",")"];//!@#$%^&*()
            var check_SC = 0;
 			//비밀번호 길이
            if(userPwd.length < 8 || userPwd.length > 16){
                window.alert('비밀번호는 8글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('userPwd').value='';
                return false;
            }
            for(var i=0;i<SC.length;i++){
                if(userPwd.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }//비밀번호 특수문자 혼합 
            if(check_SC == 0){
                window.alert('비밀번호에 !,@,#,$,%,^,&,*,(,) 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('userPwd').value='';
                return false;
            }//사용자에게 알려주기
            if(document.getElementById('userPwd').value !='' && document.getElementById('userPwdRe').value!=''){
                if(document.getElementById('userPwd').value==document.getElementById('userPwdRe').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='green';     }
                else{
                	document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                    return false;
     	
                }
            }
        }
		<!-- 전체 약관 동의를 누르면 전체 선택 및 전체해제-->
		function selectAll(selectAll)  {
			  const checkboxes 
			     = document.getElementsByName('Minseo');
			  
			  checkboxes.forEach((checkbox) =>{
			    checkbox.checked = selectAll.checked
			  })
			}
	
		<!--체크박스를 하나하나 클릭하여 전체를 선택하면 selectall 체크박스가 선택 ->
		<!--selectall 체크박스를 선택하여 전체선택을 한 경우, 체크박스가 하나라도 선택해제 되면, selectall 체크박스 역시 선택해제-->
		function checkSelectAll()  {
			  // 전체 체크박스
			  const checkboxes 
			    = document.querySelectorAll('input[name="Minseo"]');
			  // 선택된 체크박스
			  const checked 
			    = document.querySelectorAll('input[name="Minseo"]:checked');
			  // select all 체크박스
			  const selectAll 
			    = document.querySelector('input[name="selectall"]');
			  
			  if(checkboxes.length === checked.length)  {

			    selectAll.checked = true;
			  }else {
			    selectAll.checked = false;
			  }
	
		}		
	 
		 <!-- 최종 제출전 다향성 검사 -->
		 function Validation(){
			 
			 
		        var RegExp = /^[a-zA-Z0-9]{8,12}$/;  //id 영어와 숫자 글자수 검사
		        var pRegExp = /^[a-zA-Z0-9!@#$%^&*()]{8,16}$/;//pwassword 글자수 유효성 검사 정규식 
		        var eRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 유효성검사
				var nRegExp= /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/;//nick 유효성 검사
				var nameRegExp = /^[가-힣]{2,6}$/;
			   
		        
		        var objId = document.getElementById("userId"); //아이디
		        var objPwd = document.getElementById("userPwd"); //비밀번호
		        var objPwdCheck = document.getElementById("userPwdRe"); //비밀번호확인
		        var objNick = document.getElementById("nick"); //닉네임
				var objName = document.getElementById("userName"); //이름
		        var objEmail = document.getElementById("email");//메일
		        var chk1=document.getElementById("checkAgreement").checked;//필수 약관 체크박스 체크여부 확인 [하나]
		        var chk2=document.getElementById("agreementCheck").checked;//필수 약관 체크박스 체크여부 확인 [둘]
		   
	
		        
		        // ================ ID 유효성검사 ================ //
		        
		        if(objId.value==''){
		            alert("ID를 입력해주세요.");
		            return false;
		        }
		        if(!RegExp.test(objId.value)){ //아이디 유효성검사
		            alert("ID는 8~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
		            return false;
		        }
		        
		        // ================ PASSWORD 유효성검사 ===============//
		        if(objPwd.value==''){ // 비밀번호 입력여부 검사
		            alert("Password를 입력해주세요.");
		            return false;
		        }
		        if(!pRegExp.test(objPwd.value)){ //패스워드 유효성검사
		            alert("Password는 8~16자의 영문 대소문자와 숫자 특수문자로만 입력하여 주세요.");
		            return false;
		        }
		        /*
		        if(objPwd.value==objId.value){ //패스워드와 ID가 동일한지 검사
		            alert("Password는 ID와 동일하면 안됩니다.");
		            return false;
		        }*/
		        
		        if(objPwdCheck.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
		            alert("비밀번호가 일치하지 않습니다. 다시 확인하여 입력해주세요.");
		            return false;
		        }
		        
		        //===============Nick 유효성 검사=========================//
		        
		        if(objNick.value ==''){
		            alert("닉네임을 입력해주세요.");
		            return false;
		        }
		        if(!nRegExp.test(objNick.value)){ //닉네임
		            alert("닉네임을 2~16자의 숫자,한국어,영어,'_'로 입력해주세요.");        
		            return false;
		        }

		        
		        //===============이름 유효성 검사=========================//
		        if(objName.value ==''){
		            alert("이름을 입력해주세요.");
		            return false;
		        }
		        if(!nameRegExp.test(objName.value)){
		            alert("특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");
		            return false;
		        }

		        
		        // ================ email 유효성검사 ================ //
		        if(eRegExp.value == ''){ // 이메일 입력여부 검사
		            alert("이메일을 입력해주세요.");
		            return false;
		        }
		        
		        if(!eRegExp.test(objEmail.value)){ //이메일 유효성 검사
		            alert("올바른 이메일 형식이 아닙니다.");
		            return false;
		        }
		        
		        if(!val){
		        	alert("인증 실패.");
		        	return false;
		        }
		      
		        //==================필수약관 체크 여부 ==================== //
		 		
		        
		        if(!chk1){
		            alert('필수 약관에 동의해 주세요');
		            return false;
		        } 
		        if(!chk2) {
		            alert('필수 약관에 동의해 주세요');
		            return false;
		        }
			 
		 }
		  
		 function sendEmail(){
			 //alert('확인');
			
			 const m= document.getElementById('email').value;//이메일 가져오고
			 fetch("http://localhost/member/memberSendEmail.do?email="+m).then((response)=>
					console.log(response)		 
			 
			 );
			 alert('인증 이메일이 전송되었습니다.');
			 
			 
		 }
		 
		 function checkNum(){
			 //alert('확인')
			  $.ajax({
					type : "GET",
					url : "get.do",
					data : {
					
					},
					error : function(error) {
						console.log("error");
					},
					success : function(data) {
						console.log("success");
						 const checkNum = data;
						 const m= document.getElementById('emailRe').value;
						 console.log(checkNum)
						 if(m==checkNum){
							 val =true;
							 alert("일치");
						 }
						 else{
							 alert("불일치");
						 }
					}
				});
		 }
		 
		 
		 </script>
	<div id="wrap">
		<div class="bg-color">
			<div class="box-white">
				<div class="logo-user"><a href="/"><img src="data:image/png;base64,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" alt="민서네로고"></a></div>
				
				<form action="/member/memberJoin.do" onsubmit="return Validation();" method="post">
					<label for="userId" class="tit-label">아이디</label><br>
					<input type="text" id="userId" class="input-style" name="userId" placeholder="아이디 입력 (8~12자)" maxlength="12"><br>
					<span id="msg" class="check-msg"></span><br>
				
					<label for="userPwd" class="tit-label">비밀번호</label><br>
					<input type="password" id="userPwd" class="input-style" name="userPwd" onchange="pwCheck()" placeholder="비밀번호 입력 (영문, 숫자, 특수문자 조합 (8~16자))" maxlength="16"> <br>
					<input type="password" class="input-style" id="userPwdRe" name="userPwdRe" onchange="pwCheck()"  placeholder="비밀번호 확인">
					<span id="check" class="check-msg"></span><br>
					
					
					<label for="nick" class="tit-label">닉네임</label><br>
					<input type="text" id="nick" class="input-style" name="nick" placeholder="닉네임 입력(영문, 숫자, 한글 조합으로 (8~16자))" ><br>
					<span id="nickCheck" class="check-msg"></span><br>
					
					<label for="userName" class="tit-label">이름</label><br>
					<input type="text" id="userName" class="input-style" name="userName" placeholder="이름 입력(반드시 실명을 한글로 입력해주세요.)" ><br>
					<span id="nameCheck" class="check-msg"></span><br>
					
					<label for="email" class="tit-label">이메일</label><br>
					<input type="email" id="email" class="input-style" name="email" placeholder="이메일"><button type="button" onclick='sendEmail()'>인증하기</button><br>	
					<span id="emailCheck" class="check-msg"></span><br>				
				    <input type="email" class="input-style" id="emailRe" name="emailRe" onchange="emailCheck()"  placeholder="이메일 인증번호"><br>
				    <button type="button" onclick='checkNum()'>인증번호 확인</button><br>		
					
		
					<br>
					    	
		        	<h3 class="tit-join">이용 약관</h3>
		        	<div class="box-checkbox">
		        	    <input type="checkbox" name='Minseo' value='terms1'  id="checkAgreement" onclick='checkSelectAll()'/><a href="">(필수) 개인정보 수집 이용동의</a><br>
			        	<input type="checkbox" name='Minseo' value='terms2'  id="agreementCheck" onclick='checkSelectAll()'/><a href="">(필수) 민주주의 서울 이용약관</a><br>
			        	<input type="checkbox" name='Minseo' value='terms3'  onclick='checkSelectAll()'/><a href="">(선택) 마케팅 활용 및 광고성 정보 수신 동의</a><br>
		        	 	<input type="checkbox" name='selectall' value='selectall' onclick='selectAll(this)' id="checkAll"><label for=checkAll>약관 전체 동의</label><br>
		        	 </div>
					<input type="submit" class="btn-submit" value="회원가입">
				</form>
			</div>
		</div>
		
	</div>
	
	
	
	
	
		<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	
	<!-- 이름 한글 유효성 -->
	<script>
	
				$("#userName").blur(function() {
				var userName = $("#userName").val();
				var nameRegExp = /^[가-힣]{2,6}$/;

			    
			    
		        if(!nameRegExp.test($("#userName").val())){ 
					$("#nameCheck").html("반드시 실명을 한글로 입력해주세요").css("color","red");
			        $("#userName").focus();
		            return false;
		        }else{
					$("#nameCheck").html(" ").css("color","red");
		        	return true;
		            }
				});
		        </script>
	
	
	
	
	<!-- ID 중복 체크 -->
	<script>
			
			$("#userId").blur(function() {
				var userId = $("#userId").val();
			    var getCheck= RegExp(/^[a-zA-Z0-9]{8,12}$/);
			   
				
			    if(!getCheck.test($("#userId").val())){
					$("#msg").html("ID는 8~12자의 영문 대소문자와 숫자로만 입력하여 주세요.").css("color","red");
			        return false;
			      }
				
				
				$.ajax({ 
					url: "/member/memberIdCheck.do",
					data: {"userId":userId},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#msg").html("중복되는 아이디입니다.다시 입력해주세요.").css("color","red");
							$("#userId").val('');
							return false;
						}else{
							$("#msg").html("중복되지 않는 아이디입니다.").css("color","blue");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	
	
		<!-- nick 중복 체크 -->
	<script>
			
			$("#nick").blur(function() {
				var nick = $("#nick").val();
			    var n_RegExp= RegExp(/^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,16}\$/);
			    
			    
		        if(!n_RegExp.test($("#nick").val())){ 
					$("#nickCheck").html("닉네임을 2~16자의 숫자,한국어,영어,'_'로 입력해주세요.").css("color","red");
			        $("#nick").focus();
		            return false;
		        }


				
				$.ajax({ 
					url: "/member/memberNickCheck.do",
					data: {"nick": nick},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#nickCheck").html("중복되는 닉네임입니다.").css("color","red");
							$("#nick").val('');
							return false;
						}else{
							$("#nickCheck").html("중복되지 않는 닉네임입니다.").css("color","blue");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	
			<!-- email 중복 체크 -->
	
	<script>
			
			$("#email").blur(function() {
				var email = $("#email").val();
			    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			    
			   
				
			    if(!getMail.test($("#email").val())){
					$("#emailCheck").html("올바른 이메일 형식이 아닙니다.").css("color","red");
			        return false;
			      }
			
				
				$.ajax({ 
					url: "/member/memberEmailCheck.do",
					data: {"email":email},
					type: "get",
					success: function(result) {
						
						if(result=="true"){
							$("#emailCheck").html("중복되는 이메일입니다.다시 입력해주세요.").css("color","red");
							$("#email").val('');
							return false;
						}else{
							$("#emailCheck").html("중복되지 않는 이메일입니다.").css("color","blue");

						}
						
					},
					error: function() {
						console.log("ajax 통신 실패")
					}
				});
			});
	</script>
	

	

	
	
</body>
</html>