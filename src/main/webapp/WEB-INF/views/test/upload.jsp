<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="/test/imgUpload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="file" placeholder="업로드할 파일명을 지정해주세요"/>
        <input type="submit">
    </form>
</body>
</html>