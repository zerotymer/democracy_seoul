<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
		<c:when test="${!requestScope.list.isEmpty() }">
			<table border="1px">
				<tr>
					<th>순번</th>
					<th>ID</th>
					<th>PW</th>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
					<th>가입일</th>
					<th>탈퇴여부</th>
				</tr>
				
				<c:forEach items="${requestScope.list }" var="m" varStatus="i">
					<tr>
						<td>${m.userId }</td>
						<td>${m.userPwd }</td>
						<td>${m.userName }</td>
						<td>${m.nick }</td>
						<td>${m.email }</td>
						<td>${m.enrollDate }</td>
						<td><button style="width:100%" class="stateChangeBtn" data="${m.userNo }">${m.endYN }</button></td>
					</tr>
				</c:forEach>
				
			</table>
		</c:when>
		
		<c:otherwise>
			<H1>저장된 회원 리스트가 없습니다.</H1>
		</c:otherwise>
	</c:choose>
	
	<script>
	$('.stateChangeBtn').click(function(){
		
		var userNo = $(this).attr('data');
		var endYN = $(this).html();
		
		
		$.ajax({
			url : "/admin/memberEndYNChange.do",
			data : {"userNo":userNo, "endYN":endYN},
			type : "post",
			context : this,
			success : function(result){
				
				if(result != 'false')
				{
					$(this).html(result);
				}else{
					console.log("데이터 변경 실패");
				}
				
			},
			error : function(){
				console.log('ajax 통신 문제 발생');
			}
		})
		
	});
	</script>

</body>
</html>