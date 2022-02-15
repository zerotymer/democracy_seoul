<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>민주주의 서울 소개</title>
    <link rel="stylesheet" href="/resources/style/header.css">
    <link rel="stylesheet" href="/resources/style/footer.css">
    <link rel="stylesheet" href="/resources/style/color.css">
    <link rel="stylesheet" href="/resources/style/content-frame.css">
	<link rel="stylesheet" href="/resources/style/main/introduce.css">
</head>
<body>
<header>
    <%@ include file="/includes/header.jsp" %>
</header>

	<section>
		<div class="content-frame">
			<div class="frame-image">
				<div class="inner">
					<h2>민주주의 서울 소개</h2>
				</div>
			</div>
			<div class="frame-menu">
				<div class="inner menubar">
					<ul>
						<li class="menubar-icon">
							<a href="/">
								<div class="icon home"></div>
							</a>
						</li>
						<li class="menubar-list">
							<h3>알아보기<span class="slick-arrow"></span></h3>

							<!-- Menu -->
							<ul class="include menu">
								<li class="menuitem">
                                    <a>참여하기</a>
                                    <ul class="submenu">
                                        <li><a href="/suggest/suggest.do">시민제안</a></li>
                                        <li><a href="/discuss/list.do">시민토론</a></li>
                                        <li><a href="/proposal/allList.do">서울시가 묻습니다</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a>결과보기</a>
                                    <ul class="submenu">
                                        <li><a href="/suggest2/listExpired.do">제안결과</a></li>
                                        <li><a href="">공론결과</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a href="">알아보기</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">민주주의 서울 <wbr/>소개</a></li>
                                        <li><a href="/board/seoulNews.do" style="font-size: 13px;">민주주의 서울 <wbr/>이야기</a></li>
                                        <li><a href="/board/goNoticeNews.do">공지사항</a></li>
                                        <li><a href="/board/referenceList.do">자료실</a></li>
                                        <li><a href="/board/noticeCampaign.do">행사일정</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a>서울시민회의</a>
                                    <ul class="submenu">
                                        <li><a href="/main/introduce.do">서울시민회의 <wbr/>소개</a></li>
                                        <li><a href="/board/seoulNews.do">서울시민회의 <wbr/>소식</a></li>
                                    </ul>
                                </li>
                                <li class="menuitem">
                                    <a href="/main/budget.go">시민참여예산</a>
                                </li>
							</ul>
						</li>
						<li class="menubar-list">
							<h3>민주주의 서울 소개<span class="slick-arrow"></span></h3>
							<ul class="menu">
								<li class="menuitem">
									<a href="#none">민주주의 서울 소개</a>
								</li>
								<li class="menuitem">
									<a href="/board/seoulNews.do">민주주의 서울 이야기</a>
								</li>
								<li class="menuitem">
									<a href="/board/goNoticeNews.do">공지사항</a>
								</li>
								<li class="menuitem">
									<a href="/board/referenceList.do">자료실</a>
								</li>
								<li class="menuitem">
									<a href="/board/noticeCampaign.do">행사일정</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="content--viewer inner">
			<h4>민주주의 서울 소개</h4>
			<hr>
			
			<div class="content--block">
				<h2>시민의 일상을 바꾸는 서울의 공론장, “민주주의 서울”에 참여하세요!</h2>
				<p class="txt-introduce">민주주의 서울은 시민과 서울시가 함께 일상의 제안, 일상의 토론, 일상의 정책을 만드는 시민참여 플랫폼입니다.</p>

				<p class="txt-introduce">우리의 일상의 문제를 시민과 시가 함께 해결합니다.</p>
				<div class="img__center">
					<img src="/resources/images/main/introduce/img_introduce01.png"
						 alt="제안단계에서는 1.민주주의서울 온라인 플랫폼 2.찾아가는 민주주의 서울 3.제안발굴 워크숍을 통해 시민제안을 진행하여 제안분류별 50명이 공감하면 부서검토에서 수용 및 수용불가 처리하여 공론의제 선정인 토론단계로 진행.  공감100명이면 공론의제 신정으로 진행.  서울시 제안(서울시 정책 수렴,전 쟁점사항) 공론장 토론단계로 진행.  토론단계에서는 공론의제 선정에서 의제 선정단 검토 후 공론장(온·오프라인)에서 1.시민토론 단기:1~2개월 이내, 중장기:3~12개월 이상 2.서울시가 묻습니다 단기:1-2개월 이내 처리하여 단변공개를 진행.  공로장에 1000명 이상 참여서 시장답변 실시하여 결과 단계인 실행 및 결과 모니터링">
				</div>

				<h4>1.시민제안</h4>
				<p class="default-introduce">'시민제안'에서는 시민들이 일상에서 변화가 필요한 부분에 대해 해결 방법을 제안합니다. <br>
					시민들은 “<em>민주주의 서울</em>”에서 제안하는 것 외에도, <br>
					다른 시민들의 제안을 읽고 공감을 하거나 제안에 대한 의견을 적으며 토론에 참여할 수 있습니다.<br>
					또한 민주주의 서울은 시민들의 제안을 발굴하기 위한 활동을 진행합니다.
				</p>
				<div>
					<ul class="second-desc-ul">
						<li class="second-desc-li">
							<p class="second-desc-p">
								<span class="middle-dot-span">·</span> 시민들이 관심 있는 주제에 대해 자유롭게 토론,<br>제안 할 수 있는 '시민제안 발굴 워크숍'
								과<br> 시민들이 있는 서울 곳곳에 직접 찾아가 시민들의 생각과 제안을 듣는<br> '찾아가는 민주주의 서울' 활동을 진행하고 있습니다.
							</p>
						</li>
					</ul>
				</div>
				<div class="img__center">
					<img src="/resources/images/main/introduce/img_introduce02.png" alt="제안 + 공감 + 토론">
				</div>
				<div class="detail-btn">
					<a href="/front/allSuggest/list.do">시민제안 사례보기</a>
				</div>

				<div class="img__center">
					<img src="/resources/images/main/introduce/img_introduce03.png"
						 alt="제안올리기(제목과 간다한 설명만 적으면 끝입니다. 일상에 생각을 올려보세요.) / 찬반 투표하기(제안에 대한 나의 의사를 찬성과 반대, 중립으로 표현해보세요.) / 공감하고 이야기 나누기(마음이 움직이는 제안에는 공감을 누르고, 댓글로 대화에 참여해보세요.)">
				</div>
				<div class="detail-btn">
					<a href="/front/suggest/freeSuggestInsertFrm.do">제안시작하기</a>
				</div>

				<h4>2. 시민토론</h4>
				<p class="first-introduce">
					'시민토론'은 시민제안을 바탕으로 열리는 공론장입니다.<br>
					시민토론은 시민제안이 일정 시민(100명 이상)의 공감을 받으면, <br>시민으로 구성된 의제선정단의 검토, 기획, 숙의, 선정 단계를 거친 뒤 공론장이 개최됩니다.<br>
					온라인에서 진행하는 시민토론은 의제 필요에 따라<br> 시민들과 직접 만나 논의하는 ‘열린토론회’와 병행할 수 있습니다.<br>
					서울시는 시민의 참여로 더 나은 서울을 만들어 갑니다.
				</p>

				<h4>3. 시민이 공감한 제안에 서울시가 답변합니다.</h4>
				<div class="suggest-img">
					<p class="first-introduce">① 등록된 제안에 대해서 30일 동안 <strong>50명</strong> 이상 공감을 받으면 부서가 검토하고 <br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>100명</strong>
						이상 공감을 받으면 시민으로 구성된 의제선정단의 검토, 기획, 숙의를 통해 공론 의제로 최종 선정됩니다.</p>
					<p style="margin-top: 0px;">시민토론 의제 선정단은 '기획단'과 '선정단'으로 이루어져 있습니다.</p>
					<ul class="second-desc-ul">
						<li class="second-desc-li">
							<p class="second-desc-p">
								<span class="middle-dot-span">·</span> 시민 참여 분야 전문가로 구성된 ‘기획단’은 토론을 통해 공론화 여부, 방향, 방식 등을
								기획합니다.
							</p>
						</li>
						<li class="second-desc-li">
							<p class="second-desc-p">
								<span class="middle-dot-span">·</span> 그 후 일반 시민을 대상으로 한 무작위 추첨으로 구성된 ‘선정단'이 토론을 통해 공론화 의제를
								최종 선정합니다.
							</p>
						</li>
					</ul>
					<p class="sub-desc-text">※ 의제 선정시 서울시 응답소 민원처리 규정 및 국민제안 규정을 준용합니다. </p>
					<p>② 최종 선정된 의제에 한해 온라인에서 30일 이상 시민토론 공론장이 열립니다. </p>
					<p class="sub-desc-text">※ 시민토론 이후 필요에 따라 열린토론회를 개최할 수 있습니다. </p>
					<p>③ 시민토론 공론장의 참여 인원이 1,000명을 넘으면 시장이 답변합니다.</p>
					<p class="sub-desc-text">※ ‘시민토론’의 참여인원이 1,000명이 넘을 경우에만 시장이 답변하며,<br> 참여인원에 '시민제안' 단계에서의 공감과 댓글 참여자 수는
						포함되지 않습니다.</p>
					<p>④ 시민과 서울시의 토론을 통해 만들어진 정책의 실행 결과를 민주주의 서울에 공개합니다. </p>
				</div>

				<h4>4. 서울시가 묻습니다</h4>
				<p class="first-introduce">서울시는 '<em>서울시가 묻습니다</em>' 온라인 공론장을 통해 정책 수립 전·후 주요 쟁점 사항에 대한 시민들의 생각을 듣습니다. <br>시민들은
					서울시 정책의 주요 쟁점에 대해 찬성, 반대 등의 입장을 낼 수 있으며, 더 많은 토론을 할 수 있습니다. <br>
					온라인에서 진행하는 시민토론은 의제 필요에 따라 시민들과 직접 만나 논의하는 '열린토론회'와 병행할 수 있습니다.<br>
					서울시는 시민들의 의견을 반영하여 더 나은 정책, 더 나은 서울을 만들어갑니다.</p>

				<div class="img__center">
					<img src="/resources/images/main/introduce/img_introduce04.png" alt="정책제안 + 여론수렴 = 합의실행">
				</div>

				<div class="detail-btn">
					<a href="/front/seoulAsk/seoulAsk_list.do">서울시가 묻습니다 사례보기</a>
				</div>


			</div>
			<!-- //introduce-block -->

		</div>
	</section>

<footer>
    <%@ include file="/includes/footer.jsp" %>
</footer>

<script src="/resources/script/header.js"></script>
<script src="/resources/script/content-frame.js"></script>
</body>
</html>