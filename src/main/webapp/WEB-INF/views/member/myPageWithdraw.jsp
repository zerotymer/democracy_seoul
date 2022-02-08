<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/myPageWithdraw.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>

<body>

	<script>
		/*var msg = "${msg}";
		console.log("msg:", msg+":");
		if(!msg) {
			alert(msg);
		}*/
	</script>
	
	<script>
		function checkList() {
			
			var pwd = document.getElementById('pwd').value;
			var pwd_re = document.getElementById('pwd_re').value;
			var chk = document.getElementById("agree").checked;
			
			if(pwd == '') {
				window.alert('현재 비밀번호를 입력해주세요.');
				return false;
			} else if(pwd_re == '') {
				window.alert('비밀번호를 재입력해주세요.');
				return false;
			} else if(!(pwd == pwd_re)) {
				window.alert('비밀번호가 일치하지 않습니다.');
				return false;
			} else if(!chk){
				window.alert('필수 약관에 동의해 주세요');
	            return false;
	        } 
			
			
		}
	</script>
	
	
	
	<script>
		
		function check() {
			
			if(window.confirm("탈퇴를 진행하시게 되면 데이터는 복구 불가능합니다. \n탈퇴하시겠습니까?")) {
				return true;
			} else {
				return false;
			};
			
		};
		
	</script>
	
	
	
	<div id="wrap">
		<div id="content">
			<div class="user-info">
				<div class=box-title>
					<p class="tit-small"></p>
					<p class="tit-big">회원 탈퇴</p>
				</div>
				
				<form action="/member/memberWithdraw.do" method="post" onsubmit="return checkList();">
				<table class="info">
					<tr>
						<td>비밀번호</td>
						<td><input type="password" class="input-style" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" class="input-style" id="pwd_re" name="pwd_re" placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="2">
							<p class="title-wd">탈퇴 유의사항</p>
							<p>-(아이디)탈퇴할 경우 재사용 및 복구가 불가능합니다. <br>
							<input type="checkbox" id="agree"> <span>안내사항을 모두 확인하였으며, 이에 동의합니다.</span>
						</td>
					</tr>
				</table>
				
				<div>
					<input type="submit" class="btn-m" value="회원 탈퇴" id="withDraw" onclick="return check();"/>
				</div>
			</form>
			</div>
		</div>
	</div>
	

</body>
</html>