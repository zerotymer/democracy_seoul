<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>민주주의 서울</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/card-container.css">
    <style>
        body {
            background-color: var(--COLOR-WHITE);
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

        content {
            position: relative;
            width: 100%;
            min-height: 90vh;
            overflow: scroll;
        }
    </style>
</head>

<body>
    <header>
        <%@ include file="/resources/include/header.jsp" %>
    </header>

    <div class="header-gap">
    </div>

    <section>
        <div>

        </div>
        <div class="card-container">
            <div class="card-item suggest expand">
                <div class="category">제안</div>
                <div class="title">제목입니다1</div>
                <div class="content">
                    제안내용입니다.그렇습니다.
                </div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item suggest">
                <div class="category">제안</div>
                <div class="title">농수산물시장 제대로 하고 있는가???</div>
                <div class="content">
                    농수산물시장 물가 공개하자,,, <br>
                    농수산물시장에서는 주민들에게 청과, 야채, 축·수산물, 건어물 등등 신선하고 유기농 상품을 <wbr>
                    저렴한 가격으로 제공한다고 알고 있습니다. <br>
                    그러나, 농수산물시장을 살펴보면, 가격표시, 원산지표시등이 잘 이루어지지 않고 있습니다. <br>
                    주민편익증진을 위해 설립된 농수산물시장의 분야별 품목에 대해 <wbr>
                    시장을 운영하는 시설관리공단 관리자께서 주 1회이상 지도점검을 시행하시기 바랍니다. <br>
                    가격표시와 원산지표시등을 함께 공개한다면 가격비교를 쉽게 할 수 있으며, <wbr>
                    서로 믿을 수 있는 주민들의 경제적이고 합리적인 소비자물가의 안정에 도움이 될 것 같아요??? <br>
                </div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item suggest">
                <div class="category">제안</div>
                <div class="title">제목3</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item suggest">
                <div class="category">제안</div>
                <div class="title">제목4</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item discussion">
                <div class="category">토론</div>
                <div class="title">제목5</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item discussion">
                <div class="category">토론</div>
                <div class="title">제목6</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item survey">
                <div class="category">설문</div>
                <div class="title">제목7</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
            <div class="card-item survey">
                <div class="category">설문</div>
                <div class="title">제목8</div>
                <div class="content">내용</div>
                <div class="icons">
                    <object class="icon hits auto-hidden"></object>
                    <span>212</span>
                    <object class="icon heart"></object>
                    <span>11</span>
                    <object class="icon comment"></object>
                    <span>12</span>
                    <object class="icon calendar auto-hidden"></object>
                    <span>2022-01-31 ~ 2022-02-16</span>
                </div>
            </div>
        </div>
    </section>

    <div class="footer-gap">
    </div>

    <footer>
        <%@ include file="/resources/include/footer.jsp" %>
    </footer>
    
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/card-container.js"></script>
</body>
</html>