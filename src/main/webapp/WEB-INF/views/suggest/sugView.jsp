<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>민주주의 서울 - 시민제안</title>
<link rel="stylesheet" href="/resources/style/header.css">
<link rel="stylesheet" href="/resources/style/footer.css">
<link rel="stylesheet" href="/resources/style/color.css">
<link rel="stylesheet" href="/resources/style/content-frame.css">
<link rel="stylesheet" href="/resources/style/card-container.css">
<link rel="stylesheet" href="/resources/style/list-frame.css">
<style>
body {
	background-color: var(- -COLOR-WHITE);
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

section {
	position: relative;
	width: 100%;
	min-height: 90vh;
	/* overflow: scroll; */
}
</style>
</head>
<body>
	<header>
		<%@ include file="/includes/header.jsp"%>
	</header>

	<section>
		<div class="content-frame">
			<div class="frame-image">
				<div class="inner">
					<h2>시민제안</h2>
				</div>
			</div>
			<div class="frame-menu">
				<div class="inner menubar">
					<ul>
						<li class="menubar-icon"><a href="/">
								<div class="icon home"></div>
						</a></li>
						<li class="menubar-list">
							<h3>
								참여하기<span class="slick-arrow"></span>
							</h3> <!-- Menu -->
							<ul class="include menu">
								<li class="menuitem"><a href="">참여하기</a>
									<ul class="submenu">
										<li><a href=""></a>시민제안</li>
										<li><a href=""></a>시민토론</li>
										<li><a href=""></a>서울시가 묻습니다</li>
									</ul></li>
								<li class="menuitem"><a href="">결과보기</a>
									<ul class="submenu">
										<li><a href="">제안결과</a></li>
										<li><a href="">공론결과</a></li>
									</ul></li>
								<li class="menuitem"><a href="">알아보기</a>
									<ul class="submenu">
										<li><a href="">민주주의 서울 <wbr />소개
										</a></li>
										<li><a href="" style="font-size: 13px;">민주주의 서울 <wbr />이야기
										</a></li>
										<li><a href="">공지사항</a></li>
										<li><a href="">자료실</a></li>
										<li><a href="">행사일정</a></li>
									</ul></li>
								<li class="menuitem"><a href="">서울시민회의</a>
									<ul class="submenu">
										<li><a href="">서울시민회의 <wbr />소개
										</a></li>
										<li><a href="">서울시민회의 <wbr />소식
										</a></li>
									</ul></li>
								<li class="menuitem"><a href="">시민참여예산</a></li>
							</ul>
						</li>
						<li class="menubar-list">
							<h3>
								시민제안<span class="slick-arrow"></span>
							</h3>
							<ul class="menu">
								<li class="menuitem"><a href="">시민제안</a></li>
								<li class="menuitem"><a href="">시민토론</a></li>
								<li class="menuitem"><a href="">서울시가 묻습니다.</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>



<!--  여기서부터  -->
		<div id="content" class="content">

			<div class="step-area">

				<div class="inner">
					<!-- ==>0 :50 -->
					<ol>
						<!--
									<li><span>제안접수<br />2022.02.09.</span></li>
									<li class="on"><span>제안검토<br />2022.02.09.</span></li>
									<li><span>50,500공감<br />30일간</span></li>
									<li><span>50공감 달성!<br /></span></li>
									<li><span>부서답변<br /></span></li>
									 -->

						<li class="on"><span>제안접수<br>2022.02.09.
						</span></li>
						<li><span>제안검토전<br>2022.02.09.
						</span></li>
						<li><span>50공감 투표 중<br>2022.03.11.
						</span></li>
						<li><span>부서검토</span></li>
						<li><span>부서답변<br>- 요청전
						</span></li>


					</ol>
				</div>

			</div>

			<div class="cont-view-area">
				<h4>
					66번 버스 노선 변경 부탁드립니다 <a href="#none" class="cont-scrap"
						title="게시글 스크랩하기"
						onclick="myScrap('192121','A0','29'); return false;"
						style="right: 90px;">스크랩</a>



					<!-- SNS 공유 -->




					<a href="#none" class="cont-share" title="게시글 공유하기"
						aria-selected="false">공유</a>
					<ul class="sns-share-lst">
						<li><a href="#"
							onclick="snsSubmitAndHist('twitter', '/front/freeSuggest/view.do?sn=192121', '66번 버스 노선 변경 부탁드립니다', '192121', '01'); return false;"
							title="트위터 바로가기 새창열림"> <img
								src="/assets/front/images/btn/btn_sns_share01.png" alt="트위터">
						</a></li>
						<li><a href="#"
							onclick="snsSubmitAndHist('facebook', '/front/freeSuggest/view.do?sn=192121', '66번 버스 노선 변경 부탁드립니다', '192121', '01'); return false;"
							title="페이스북 바로가기 새창열림"> <img
								src="/assets/front/images/btn/btn_sns_share02.png" alt="페이스북">
						</a></li>
						<li><a href="#"
							onclick="snsSubmitAndHist('kakaoLink', '/front/freeSuggest/view.do?sn=192121', '66번 버스 노선 변경 부탁드립니다', '192121', '01'); return false;"
							title="카카오링크 바로가기 새창열림"> <img
								src="/assets/front/images/btn/btn_sns_share06.png" alt="카카오링크">
						</a></li>
						<li><a href="#"
							onclick="snsSubmitAndHist('naverBlog', '/front/freeSuggest/view.do?sn=192121', '66번 버스 노선 변경 부탁드립니다', '192121', '01'); return false;"
							title="네이버블로그 바로가기 새창열림"> <img
								src="/assets/front/images/btn/btn_sns_share04.png" alt="네이버블로그">
						</a></li>
						<li><a href="#"
							onclick="copyLink('/front/freeSuggest/view.do?sn=192121');"
							title="링크 바로가기"> <img
								src="/assets/front/images/btn/btn_sns_share05.png" alt="링크">
						</a></li>
					</ul>
					<!-- SNS 공유 -->

				</h4>



				<p class="file-add">
					<!-- 첨부파일목록 -->


					<img src="/assets/front/images/ico/icon_file.png" alt="첨부파일">첨부파일
					<a href="/file/download.do?file_sn=17734" class="link"
						title="첨부파일 다운로드">66번 버스노선.JPG</a> <span class="file-size">(0.14
						MB)</span>

				</p>


				<!-- suggest-detail -->
				<div class="suggest-detail">
					<div class="user-info">
						<p>





							<!-- <input type="text" name="fileUrl" value="/cso/images/main/mem_icoP.png" /> -->
							<img src="/cso/images/main/mem_icoP.png" alt="이**님의 프로필 사진"
								style="border-radius: 50%; height: 100%;"> <span
								class="sns-mask"><img
								src="/assets/front/images/ico/ico_ka_user.png" alt="카카오"></span>



						</p>
					</div>
					<p class="user-txt">
						<span class="name"> 이 * * </span> <span class="date">2022.02.09.</span>
					</p>
					<div class="suggest-user">
						<ul>



						</ul>
					</div>
				</div>
				<!-- //suggest-detail -->

				<div class="citizen-idea">
					<p>시민의견 &nbsp;&nbsp;: 0</p>
					<p class="etc">
						<span>정책분류</span><span>-</span>
					</p>
				</div>




				<div class="txt-block">



					<pre>
						<p>66번 버스 노선이 변경되었는지</p>
						<p>몇일 전부터 가재울중학교를 거쳐서 가재울 고등학교 앞을 지나 가는데요</p>
						<p>이 길은 2차선 도로고 굉장히 좁아서 버스가 다니기에 적합하지 않을 뿐더러</p>
						<p>가재울중학교에서 우회전 하는 부분에서 </p>
						<p>버스가 우회전 하기에는 좁아 양 쪽 모두 차가 없어야 가능합니다.</p>
						<p>출퇴근 시간 교통량이 꽤 있는 이 부분이</p>
						<p>66번 버스 때문에 줄줄히 막히는 현상에 발생하고 있습니다</p>
						<p>이런 버스는 큰 길로 우회하도록 해주세요</p>
					</pre>




					<div class="hash-detail">
						<ul class="hash-lst">

						</ul>
					</div>


					<div class="suggest-view">




						<div class="sym-box">

							<span class="total"><i>전체인원</i>50</span> <span
								class="progressbar ty02" style="width: 0.0%;"> <i
								class="empath-num"></i><span
								style="top: -9999px; left: -9999px; position: absolute;">공감수</span><em
								title="공감수">0</em>
							</span>
						</div>

						<p class="txt-term">
							<em>투표기간</em> 2022.02.09. ~ 2022.03.11. <span class="label">D-29</span>

						</p>

						<div class="btn-area">





							<a href="#none" type="button" class="btn-go-sympathy"
								onclick="voteP4('192121','A0','29','insert'); return false;"
								title="공감하기"> <span class="sr-only">공감수 : </span> <em>0</em>
								<span>공감하시면 눌러주세요</span>
							</a>


						</div>
					</div>



				</div>
				<div class="btn-area">

					<a href="javascript:history.back();" class="btn btn-solid1 lg">목록보기</a>

				</div>

				<!-- 유사 제안 바로하기 -->
				<div class="go-similar">
					<p>이 글에서 새로운 제안이 떠오르셨나요?</p>
					<a href="#" onclick="openSuggestView('sug-go a'); return false;"
						title="유사 제안 바로하기">유사 <em>제안 바로하기</em></a>
				</div>
				<!-- //유사 제안 바로하기 -->

				<!-- 댓글 토론참여 -->
				<div class="join-box">


					<!-- 로그인 전 a 태그 소스 -->
					<div class="join-top"
						onclick="openSuggestView('sug-go a'); return false;">
						<div class="txt-join">
							<textarea placeholder="댓글 토론참여" title="댓글 토론참여" disabled=""></textarea>
						</div>
						<div class="btn-join">
							<button class="login">
								로그인 후<br> 참여가 가능합니다.
							</button>
						</div>
					</div>
					<!-- //로그인 전 a 태그 소스 -->


					<div class="comment_list_wrap">

						<script>
							var isPageMoreWating = false;
							function fn_egov_link_page_more() {

								if (!isPageMoreWating) {

									isPageMoreWating = true;
									var frm = document
											.getElementById("searchFrm");

									var url = "/front/common/reply/list_more.do";
									var pageIdx = Number(frm.pageIndex.value);
									pageIdx = pageIdx + 1;
									frm.pageIndex.value = pageIdx;
									var totPage = Number("0");
									var formData = $("#searchFrm").serialize();
									var total = 10
									var replyTotCnt = '0';

									$("#spAddRe").html("더 보기 불러오는 중");

									$
											.ajax({
												type : "POST",
												url : url,
												cache : false,
												data : formData,
												async : false,
												contentType : "application/x-www-form-urlencoded; charset=UTF-8",
												success : function(args) {
													//frm.value = "y";
													var $newLi = $(args)
													isPageMoreWating = false;
													$("#spAddRe")
															.html("더 보기 +");
													$(".vre_ls").append($newLi);
													if ((total * pageIdx) >= replyTotCnt) {
														$('.btn-area').hide();
													}
													//snsDiaplayInit2();
												},
												error : function(e) {
													isPageMoreWating = false;
													alert(e.responseText);
												}
											});
								}
							}

							function addListMore(sn) {
								/*
								var height = Number($('#idCon_'+sn).css('height').replace( 'px', '' ));
								if(height > 300){
									$('#idCon_'+sn).css('height','50px');
								}else{
									$('#idCon_'+sn).css('height','100%');
								}
								 */
								var openYn = $('#idCon_' + sn).val();
								if (openYn == 'Y') {
									setTimeout(
											function() {
												$('#idCon_' + sn).css('height',
														'50px');
											}, 50);
									$('#idCon_' + sn).val('N');
								} else {
									setTimeout(function() {
										$('#idCon_' + sn)
												.css('height', '490px');
									}, 50);
									$('#idCon_' + sn).val('Y');
								}
							}

							function addComm(sn) {

								var strMember_name = $('#myNameHid').val();
								var member_name_ch = strMember_name;

								if ($("#comm_" + sn).css("display") == "none") {
									jQuery("#comm_" + sn).show();

									var addDiv = "<div class=\"join-top-login\">"
											+ "<div class=\"inner\">"
											+ "<p class=\"user-login-name\">"
											+ "<span>"
											+ member_name_ch
											+ "</span></p>"
											+ "<div class=\"txt-join\">"
											+ "<textarea placeholder=\"권리침해, 욕설, 특정 대상을 비하하는 내용, 청소년에게 유해한 내용 등을 게시할 경우 운영정책과 이용약관 및 관련 법률에 의해 제재될 수 있습니다. 댓글 작성 시 상대방에 대한 배려와 책임을 담아 주세요.\" title=\"댓글 토론참여\" "
											+ "id=\"content_on_"
											+ sn
											+ "\" name=\"content_on_"
											+ sn
											+ "\" onkeyup=\"chkStrLength_addNew("
											+ sn
											+ ");\"></textarea>"
											+ "</div>"
											+ "<div class=\"btn-join\" id=\"div_"+sn+"\">"
											+ "<span><em>1</em>/1,000</span>"
											+ "<button class=\"login\" onclick=\"writeSnsReply_addComm("
											+ sn
											+ "); return false;\" "
											+ ">등록</button>"
											+ "</div>"
											+ "</div>" + "</div>";

									$("#comm_" + sn).append(addDiv);
								} else {
									jQuery("#comm_" + sn).hide();
									$("#comm_" + sn).empty();
								}
							}

							function slideUp_idCon(i) {
								var num = i;
								$('#slideUp_idCon' + num).hide();
								$('#slideDown_idCon' + num).show();
								$('#idCon_' + num).hide();
								$('#tempContent_idCon' + num).show();
							}

							function slideDown_idCon(i) {
								var num = i;

								$('#slideDown_idCon' + num).hide();
								$('#slideUp_idCon' + num).show();
								$('#tempContent_idCon' + num).hide();
								$('#idCon_' + num).show();
							}
						</script>

						<div class="join-total-num">
							<div class="total-left">
								총 <span class="txt-num">0</span>개의 댓글이 있습니다.
							</div>
							<ul class="total-sort">




								<li><a href="#none"
									onclick="commentList('192121', '1', ''); return false;"><h5>최신순</h5></a>
								</li>



								<li><a href="#none"
									onclick="commentList('192121', '2', ''); return false;"><h5>과거순</h5></a>
								</li>



								<li class="on"><a href="#none"
									onclick="commentList('192121', '3', ''); return false;"><h5>공감순</h5></a>
								</li>

							</ul>
						</div>

						<!-- 댓글 영역 -->
						<section class="comment-box">
							<ul class="vre_ls">

							</ul>
						</section>



						<form id="snsReplyDelForm" name="snsReplyDelForm" method="post"
							action="/front/common/reply/suggestDelete.do"
							target="snsReplyIfr"
							wtx-context="C88596C0-D3FF-45F9-832D-BB1730EF7B2C">
							<input type="hidden" name="sn" value=""
								wtx-context="467C478A-6F48-4B0E-9478-216D36F48600"> <input
								type="hidden" name="comment_sn" value=""
								wtx-context="FD91E8A0-524B-4FE6-BD03-7EA8EF501E57"> <input
								type="hidden" name="sns_code" value=""
								wtx-context="26F64B95-D49F-4517-B04C-DF9F7026AC7F"> <input
								type="hidden" name="mem_id" value=""
								wtx-context="608AB9D3-722C-4382-B3D6-3137F643B711">
						</form>

						<form id="snsReplyNotForm" name="snsReplyNotForm" method="post"
							action="/front/common/reply/notify.do" target="snsReplyIfr"
							wtx-context="8FE938BA-9988-4413-A503-5B836658185F">
							<input type="hidden" name="sn" value=""
								wtx-context="61ABBC3B-87D1-475D-847E-6CA6885340A1"> <input
								type="hidden" name="comment_sn" value=""
								wtx-context="E1DD0BE0-8FCF-402B-BB70-D8729F9F7D5E"> <input
								type="hidden" name="sns_code" value=""
								wtx-context="5745988D-BB8D-4A47-9FA4-BC4CC413639E"> <input
								type="hidden" name="mem_id" value=""
								wtx-context="93969162-AEB5-4B00-8446-18C26E974178">
						</form>

						<form name="searchFrm" id="searchFrm" method="post" action=""
							wtx-context="F80928F9-B5D5-4CEA-8C00-C98DBDDBB52B">
							<input type="hidden" name="pageIndex" value="1"
								wtx-context="41EC6105-4784-4CC1-8AB7-8CA06B66AA71"> <input
								type="hidden" name="prePages" value="1"
								wtx-context="6B692FF1-472A-4BAD-8734-C7C238AAFB89"> <input
								type="hidden" name="sn" value="192121"
								wtx-context="88BF647A-C533-4E60-BDD2-97910B4C0262"> <input
								type="hidden" name="order" value="3"
								wtx-context="6E1762ED-00F0-40EA-81D3-41D006EAE983"> <input
								type="hidden" name="category" value=""
								wtx-context="5CE8025D-30FA-4095-ABEA-58F73EB5E0C5"> <input
								type="hidden" name="total" value="10"
								wtx-context="9B817A75-61B5-4473-836F-DC614ACE2A8B"> <input
								type="hidden" name="replyTotCnt" value="0"
								wtx-context="CE0DAC4E-7227-4EB6-A5A1-B656F37D228A">
						</form>

					</div>
					<!-- /common/reply/listNew.do 호출 -->

					<script type="text/javascript">
						commentList('192121', '3', '');
					</script>



					<!-- //토론의견 작성 -->



				</div>
				<!-- //댓글 토론참여 -->


			</div>
		</div>






	</section>

	<footer>
		<%@ include file="/includes/footer.jsp"%>
	</footer>

	<script src="/resources/script/header.js"></script>
	<script src="/resources/script/content-frame.js"></script>
	<script src="/resources/script/card-container.js"></script>
</body>
</html>