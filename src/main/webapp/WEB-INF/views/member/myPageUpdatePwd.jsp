<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/myPageUpdatePwd.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CKEditor/member/ui.js"></script>
</head>


<body>

	<script>
		function passwordChange() {
			
			var pwd = document.getElementById('pwd').value;
			var new_pwd = document.getElementById('new_pwd').value;
			var new_pwd_re = document.getElementById('new_pwd_re').value;
			var reg = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[`~!@$!%*#^?&\\(\\)\\-_=+])(?!.*[^a-zA-z0-9`~!@$!%*#^?&\\(\\)\\-_=+]).{8,16}$/;
			//var reg = /^[a-z0-9]{8,16}$/;
			
			if(pwd == '') {
				window.alert('현재 비밀번호를 입력해주세요.');
				return false;
			}
			if(new_pwd == '' || new_pwd_re == '') {
				window.alert('신규 비밀번호를 입력해주세요.');
				return false;
			}
			if(!(new_pwd == new_pwd_re)) {
				window.alert('신규 비밀번호가 일치하지 않습니다.');
				return false;
			}
			if( !reg.test(new_pwd) ) {
			    alert("비밀번호를 재확인해주세요. \n8글자 이상, 16글자 이하, 특수문자를 포함시켜야 합니다.");
			    return false;
			}
			if( !reg.test(new_pwd_re) ) {
			    alert("비밀번호를 재확인해주세요. \n8글자 이상, 16글자 이하, 특수문자를 포함시켜야 합니다.");
			    return false;
			}
		}
	</script>



	<div id="wrap">
		<div id="content">
			<div class="user-info">
				<div class=box-title>
					<p class="tit-small"></p>
					<p class="tit-big">비밀번호 변경</p>
				</div>
				<form action="/member/MypageUpdatePassword.do" method="post" onsubmit="return passwordChange();">
					<table class="info">
						<tr>
							<td>현재 비밀번호</td>
							<td><input type="password" class="input-style" id="pwd" name="memberOriginalPass" placeholder="현재 비밀번호 입력"></td>
						</tr>
						<tr>
							<td>새로운 비밀번호</td>
							<td><input type="password" class="input-style" id="new_pwd" name="memberNewPass" placeholder="신규 비밀번호 입력"></td>
						</tr>
						<tr>
							<td>새로운 비밀번호 재입력</td>
							<td><input type="password" class="input-style" id="new_pwd_re" name="memberNewPass_re" placeholder="신규 비밀번호 재입력"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="btn-m" value="변경완료">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
		
	
</body>
</html>
