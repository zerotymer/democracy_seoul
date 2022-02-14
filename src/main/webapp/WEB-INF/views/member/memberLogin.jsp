<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>민주주의 서울  로그인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/resources/style/member/memberLogin.css">
<link rel="stylesheet" href="/resources/style/member/default.css">
</head>

<body>

<c:choose>
	<c:when test="${sessionScope.user != null }">
			[<a href="/member/goMypage.do"">${sessionScope.user.userName }</a>]님 환영 합니다 <a href="/member/logout.do">로그아웃</a><br>
		<a href="/">메인으로 이동</a><br>
    </c:when>
	<c:otherwise>
	<div class="bg-color">
		<div class="box-white">
			<div class="logo-user"><a href="/"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIEAAABWCAMAAADfRQX1AAAA0lBMVEX///8dvtIrKigUu8gWu8UTuLiioaEUspkRtagTtaZSUVD7/v5FREKO3uhj0uATuLlHytoSt7Ni0NKP3dvU8/eHh4ZtbGvj9/lfX116eXjk5OQ4xtfe9fPy8vLX19cWsZavr668vLyP2tB508IjrX3G7/SVlJN/2uY3NzXKysnS8OtKSUc2NTNqaWjo6Oe46/G0tLOl5e1719g0wsCu5+jK8PPD7OlAxLpfzMI9xs5c0Ntpzr9aybWo49rb8urL6+CZ2cNKupB7zrK35NU7tIah3Mct7tfuAAAGK0lEQVRoge2YiXbaOBSGhZOoiSwomSJbMpFjJcFYBZvQNN1mJl3n/V9priRjCwKTpqVDe8p/ThLlWsunu8gChDYpfnFzdHR08yzc2OMHa3DzFACOTk9v4t0AhDdHNcHpzW4IXj5tCE6f74TghUfwcicEf3gEz/YEe4I9we9DEN+ORrfLx/9mgrNXr1493+67In57cHBweHj4zp92E8HZ62PQycmbLb4y44MDR3D41pt1A8HZ8bEjOHm9PYR3DcHhiwcJ3jQEJxfbAggPWoLDhwjC45bg5IcQtJ5dTxDvnODMJ9hWIuwJtkbw/OLy8vLim+5zWyEI/3wCOj8//+sbHLMVAgtgCM7/2g3B2ZOG4PzxgdgGwd8eweOPym0QXHgEl3uCPcGe4NchCO/evz/bJcGHK6OP73dG8Omq1gLh/yb4vAC4+hLuhuBjQ3D1eTcELcDVh50QhB7Bp9/UBz9BHuy+FnZ/HiD0zxd7Jt41hoGntlvcGr2vK8LnnrzOntU78DcpvLu729HX5Xvt9V/SUjOplMYK6RSJBMk0zRhDWiEuEU5TgVKlVApdE/NcQ7tElZIKw2DGkrLCGCvohZFIZe5mhREKyxyUaPMbSWVmQgkDVSpTeSlzaCroO9GKp9OSC6wo1TRFCaGc8IyQPEhIQSOCrhnjEXTNSkRTXhZZgSY8wmZCHPAAfglBMC0I0clUaw1dA1FgIbPJNEtSHJAM8ajABAaQknPJaESnEhd4ChsLpxkQUAwEDOc5ECBMKOG5YCIQmkSq0LD5zBCwiSHAk6xIqJwaAkxzEiR5QTgJBdFESAEyBNdAkBIuqMooI6Sa4AkDgoyCFCECCASZ8gyhvIDVEyGwwDkT2BDwqSDAKapAlhlnYMIiZwhVBc1oioVQhSw0NQQprDdJokTgSJNrTpggIIiEEAwLVTIWwayMlTplWDcEggtRKNOkCDbFIo5yDEmQwLqwnOYZ+ABxjZi8LogiEkZkmUSMpRFNE4okRjnNDAHilAZJRUvCJKEZREG4PLiGvNApDFRaK5KrlExICQQVLBqA53mpkZiQSeayhiNGOcembXwQIsw5IoRzk36aVCaVconc8yTgEEloWgJaUAoEEbErE50G4AN4mhWcg9tya+aQb9LMBHkQAIJMqIhoFU14YRdFEvLfyLRT6Zvqpid4vvSgSpIkRGFa2adJ8zR0f6ukNjcDoH9ieaQdK7+7lvf6RQVnbppuin/Y6XS6S/cTJ3Mfume8P7zX6fTXT0yKwlaFzMppYFVE1+6WFXca9RqCeWdF5krTXTXW0PNevz+eLQiG3rJwFBJXI4gGgTlUFQ08TdJtEIyG7p9+fJ8gglUSnyA1607hPBQRsX6Q308waP7rhw8T5GCI6gyoDMN1TTCfzWZDnyCMjeySM9s0EXPGsTGObNPM0zdrd8fGEeOHCbBxfeYOKWwComqC2E3VEljN7NaGywk3b11udOtch0JAGIYPEsg6DaZ1NvJFHqwjcJs16rY367jXGMMGKG4b6wlM8dWZWEV+JjK5kQDy22VG3/2Z2Wqcu//GLvd6o/AhghJWgXSv14tc+DPBCYX3JMvqhFhHsEivcRjWmx7GaFQb540nwO0za0A2Azr3omByTbcEGq9Ragn6oKVasDnYH9nN2R2bcrdh6du0cGVx6/p35i4/e/cy0UQbtwQsWKNsfTWi3rA3q6eBiAxtaoS9/ni0SAgwzlsWq8EqgTYrlFABoOKxBF+vJmFnaJVA2CVcMZhMVKyWqYZFG6IwbjSvCbr9NeqtM5qQuPzsDdAqQepV3KIaMytzGrrW/R1Zgl5njYbrjC4osXtzrRDY2jc/rCVIVmNQxxQ2M/8egnpoPJt5BNIUArd+YA8RmNob+wSzbi2zcHdVpiAW7VHPqd+3gL2WIJ0YVyf2HA54tYiCX4frCVD9DnBy74oVdTzjaNklLYEsDIB5+ZqgwwcjR1ARTxsIlvRIgmG39YGaBtRVgS6g4h6OQm/k6esJBnUUxt35bLD8dta8vpugynwkaAmmvh9agiV9PcGqVs5ETy0BXT6Td0CwJPyTELi7j6dm2O1odP9CDImy8au4wWh0u/5JqrX5QJqsCF7Q/wKhrgFS0MYbvgAAAABJRU5ErkJggg==" alt="로고"></a></div>
			<form action="/member/login.do" method="post" >
				<input type="text" class="input-login" name="userId" placeholder="아이디를 입력하세요"><br>
				<input type="password" class="input-login" name="userPwd" placeholder="비밀번호를 입력하세요"><br>
				<input type="submit" class="btn-submit" value="로그인"><br>
				<button class="btn-join"><a href="/member/goMemberJoinus.do">회원가입</a></button><br>
				<div class="link-search">
					<a href="/member/goMemberSearchId.do">아이디 찾기</a><br>
					<a href="/member/goMemberSearchPwd.do">비밀번호 찾기</a>
				</div>
			</form>
		</div>
	</div>
		</c:otherwise>
</c:choose>
	
	
	
</body>
</html>