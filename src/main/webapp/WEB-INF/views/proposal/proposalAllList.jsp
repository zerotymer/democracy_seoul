<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/card-container.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
    <link rel="stylesheet" href="/resources/style/proposal/ProposalAllList.css">
    
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
            
            <c:choose>
				<c:when test="${!requestScope.list.isEmpty()}">
					<c:forEach items="${requestScope.list }" var="proposal" varStatus="i"> 
			            <div class="card-item survey">
			                <div class="category">TEST</div>
			                <div class="title"><a href="/proposal/post.do?proposalNo=${proposalView.proposalNO}">${proposal.proposalTitle }</div>
			                <div class="content">${proposal.proposalContent }</div>
			                <div class="icons">
			                    <object class="icon hits auto-hidden"></object>
			                    <span>212</span>
			                    <object class="icon heart"></object>
			                    <span>11</span>
			                    <object class="icon comment"></object>
			                    <span>12</span>
			                    <object class="icon calendar auto-hidden"></object>
			                    <span> ${proposal.proposalStart } ~ ${proposal.proposalEnd }</span>
			                </div>
			            </div>
            		</c:forEach>
            	</c:when>
	       
			</c:choose>
        </div>
    </section>

	<footer>
        <%@ include file="/resources/include/footer.jsp" %>
    </footer>

    
    <script src="/resources/script/header.js"></script>
    <script src="/resources/script/card-container.js"></script>
</body>
</html>