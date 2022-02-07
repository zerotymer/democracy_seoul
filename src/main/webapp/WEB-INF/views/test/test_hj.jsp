<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <!-- App favicon -->
    <link rel="shortcut icon" href="/resources/images/favicon.ico">
    <!-- App css -->
    <link href="/resources/css/icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/css/app-creative.min.css" rel="stylesheet" type="text/css" id="light-style"/>
</head>

<style>
    * {
        font-family: 'Noto Sans KR', sans-serif;
        background-color: #FAFBFE;
        font-weight: bold;
        color: #919CA7;
    }

    .wrap {
        width: 100%;
        margin: 0 auto;
        background-color: #FAFBFE;
    }

    #header {
        height: 240px;
    }

    #select {
        border: 1px solid #FD6F22;
        border-radius: 5px;
        height: 27px
    }

    #search {
        border: 1px solid #FD6F22;
        box-sizing: border-box;
        border-radius: 5px;
        width: 200px;
        height: 27px;
    }

    #btn {
        background: #FD6F22;
        color: white;
        border-radius: 5px;
        height: 27px;
        border: 0px;
        outline: 0px;
        filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.10));
    }

    #writeBtn {
        float: left;
        border: 1px solid #FD6F22;
        box-sizing: border-box;
        border-radius: 5px;
        height: 27px;
    }

    #commutable {
        width: 1000px;
        margin: 0 auto;
        margin-top: 10px;
        text-align: center;
        background-color: white;
        filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.10));
    }

    #commutitle {
        padding-top: 64px;
        padding-bottom: 35px;
        font-size: 25px;
        color: black;
        text-align: center;
    }

    a {
        color: #919CA7;
    }

    #searchdiv {
        width: 1000px;
        margin: auto;
        text-align: right;
    }

    #paging {
        padding-top: 30px;
        text-align: center;
    }

    #footer {
        height: 235px;
    }
</style>
<body>

<div id="header">
</div>

<div style="height: 105px;"></div>
<div class="wrap">
    <p id="commutitle">커뮤니티 게시판</p>

    <div id="searchdiv">
        <form action="/board/community.do">
            <button id="writeBtn">글쓰기</button>
            <select id="select">
                <option style="text-align: left;" value="subject" selected>제목</option>
                <option style="text-align: left;" value="writer">작성자</option>
            </select>

            <input type="text" id="search"/>
            <button id="btn">검색</button>
        </form>
    </div>
    <table id="commutable" class="table">
        <thead>
        <tr>
            <th style="width: 10%">번호</th>
            <th style="width: 50%">제목</th>
            <th style="width: 12%">작성자</th>
            <th style="width: 15%">작성일</th>
            <th style="width: 13%">수정/삭제</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="table-user">
                7
            </td>
            <td><a href="">[공지사항] 오늘의 댕댕 게시판 및 댓글 운영 규칙 안내</a></td>
            <td>관리자</td>
            <td>2022-01-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                6
            </td>
            <td><a href="">[공지사항] 코로나 19 관련 반려동물 관리지침 안내</a></td>
            <td>관리자</td>
            <td>2022-01-20</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                5
            </td>
            <td>'오늘의 댕댕에게 소원을 빌어봐' 이벤트 당첨자 안내</td>
            <td>관리자</td>
            <td>2022-01-18</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                4
            </td>
            <td>FDA 사료 리콜 관련 긴급 공지</td>
            <td>관리자</td>
            <td>2022-01-16</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                3
            </td>
            <td>오늘의 댕댕 리뉴얼 소식 안내</td>
            <td>관리자</td>
            <td>2021-10-05</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                2
            </td>
            <td>동물 보호법 개정에 따른 '책임 보험 의무 가입' 안내</td>
            <td>관리자</td>
            <td>2021-02-10</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                1
            </td>
            <td>2월 12일 기준, 동물보호법 개정(예정) 시행 사항 안내</td>
            <td>관리자</td>
            <td>2021-02-10</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                178
            </td>
            <td>저희 강아지 귀엽죠?</td>
            <td>율무집사</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                177
            </td>
            <td>강아지 산책 어떻게 하시나요?</td>
            <td>호두맘</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                176
            </td>
            <td>안녕하세요~ 오늘 가입했어요!!:)</td>
            <td>호빵</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                175
            </td>
            <td>덴탈껌 어떤거 먹이시나요??</td>
            <td>까미형아</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                174
            </td>
            <td>오늘 예방접종 다 맞았어요~!</td>
            <td>쭈골이누나</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                173
            </td>
            <td>코엑스에서 하는 펫페어 가시는 분 계신가요??</td>
            <td>두부</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                172
            </td>
            <td>여의도 근처 강아지 동반 가능한 카페 있나요??</td>
            <td>토리누나</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
            <td class="table-user">
                171
            </td>
            <td>부산에 강아지 동반 숙소 추천해주세요~~~</td>
            <td>슈슈</td>
            <td>2022-02-26</td>
            <td>
                <a href="" class="action-icon"> <i class="mdi mdi-pencil"></i></a>
                <a href="" class="action-icon"> <i class="mdi mdi-delete"></i></a>
            </td>
        </tr>
        <tr>
        </tbody>
    </table>

    <div id="paging">
        <a style="color: #FD6F22;" href=""> Prev</a>
        <a style="color: #919CA7;" href="">1</a>
        <a style="color: #919CA7;" href="">2</a>
        <a style="color: #919CA7;" href="">3</a>
        <a style="color: #919CA7;" href="">4</a>
        <a style="color: #919CA7;" href="">5</a>
        <a style="color: #FD6F22;" href="">Next</a>
    </div>
</div>
<div id="footer"></div>

</body>
</html>