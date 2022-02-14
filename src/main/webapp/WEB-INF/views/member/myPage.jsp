<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>

<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/resources/style/default.css">
<link rel="stylesheet" href="/resources/style/member/common.css">
<link rel="stylesheet" href="/resources/style/member/myPage.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/resources/CkEditor/member/ui.js"></script>
</head>
<body>

	

	<div id="wrap">
		<div id="content">
			<div class="user-info">
			
				<div class=box-title>
					<p class="tit-small"></p>
					<p class="tit-big">회원 정보</p>
				</div>
				
				<table class="info">
					<tr class="profile">
						<td>사진</td>
						<td class="profile-img">	
									<img class="profile-img2" src="/upload/profile/${mf.profileName }">
						</td>
						<td>
							<p>프로필 사진을 등록해 주세요.</p>
							<p>등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다.</p>
						</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td colspan="2">${user.userId}</td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td colspan="2">${user.nick}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td colspan="2">${user.email}</td>
					</tr>
					<tr>
						<td colspan="3"><button class="btn-m">
								<a href="/member/goMyPageUpdate.do">프로필 수정하기</a>
							</button></td>
					</tr>
				</table>
			</div>
			
			<div class="user-sec">
			<div>
				<p class="tit-big">닉네임 변경</p>
			</div>
				<table class="sec">
					<tr>
						<td>닉네임 변경</td>
						<td><button class="btn-m">
								<a href="/member/goMemberUpdateNick.do">닉네임 변경</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
			
						
			
			
			<div class="user-sec">
			<div>
				<p class="tit-big">이메일 인증 및 재설정</p>
			</div>
				<table class="sec">
					<tr>
						<td>이메일 재설정</td>
						<td><button class="btn-m">
								<a href="/member/goMemberUpdateEmail.do">이메일 변경</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
			
			
			<div class="user-sec">
			<div>
				<p class="tit-big">비밀번호 변경</p>
			</div>
				<table class="sec">
					<tr>
						<td>비밀번호</td>
						<td><button class="btn-m">
								<a href="/member/goMypageUpdatePwd.do">비밀번호 변경</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
			
			<div class="user-withdraw">
				<table class="withdraw">
					<tr>
						<td><p>회원탈퇴</p></td>
						<td><button class="btn-withdraw">
								<a href="/member/goMypageWithdraw.do">회원 탈퇴</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	
	</div>
	



</body>
</html>