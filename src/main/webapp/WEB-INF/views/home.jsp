<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="./css/sb-instagram.css" type="text/css"
	media="all" />
<%@ include file="./include/header.jsp"%>
<%-- <%@ include file="./exboard/list.jsp"%> --%>

<!-- Start main-content -->
<div class="main-content">

	<!-- Section: home -->
	<section id="home"
		class="divider no-bg layer-overlay overlay-dark-light"
		data-bg-img="http://placehold.it/1920x1280">
	<div class="bg-video">
		<div id="home-video" class="video">
			<div class="player video-container"
				data-property="{videoURL:'QTrL5hmNXaA',containment:'#home-video',autoPlay:true, showControls:true, mute:false, startAt:0, opacity:1}"></div>
		</div>
	</div>
	<div class="display-table">
		<div class="display-table-cell">
			<div class="container pt-200 pb-200">
				<div class="row">
					<div class="col-md-12 text-center">
						<h2 class="text-white text-uppercase font-60 font-weight-700 mb-0">
							공부를 <span class="text-theme-color-2">디자인 </span>하라!
						</h2>
						<p class="font-16 text-white">SD교육그룹</p>
						<!-- 	<a class="btn btn-colored btn-theme-colored btn-flat mt-15"
							href="">Book Now</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- Section: home-boxes -->
	<section class="bg-silver-light">
	<div class="container pt-0 pb-0">
		<div class="section-content">
			<div class="row equal-height-inner home-boxes"
				data-margin-top="-100px">
				<div
					class="col-sm-12 col-md-3 pl-0 pl-sm-15 pr-0 pr-sm-15 sm-height-auto mt-sm-0 wow fadeInLeft animation-delay1">
					<!-- <a href="#"><div class="sm-height-auto bg-theme-colored" style="background: url('/resources/images/mathback.png') no-repeat; background-size: contain">
						<div class="text-center pt-30 pb-30">

							<h4 class="text-uppercase mt-20">
								<a href="#" class="text-white">수학의시선 홈페이지</a>
							</h4>
						</div>
					</div></a>
					
					
				</div> -->
				<div class="sm-height-auto bg-theme-colored" >
						<div class="text-center pt-30 pb-30" style="cursor:pointer;" onclick="window.open('http://203.241.38.227:8083/');">
							<img src="/resources/images/mathlogo.png">
							<h4 class="text-uppercase mt-20">
							</h4>
						</div>
					</div>
				</div> 
				<div
					class="col-sm-12 col-md-3 pl-0 pl-sm-15 pr-0 pr-sm-15 sm-height-auto mt-sm-0 wow fadeInLeft animation-delay2">
					<div class="sm-height-auto bg-theme-colored-darker2">
						<div class="text-center pt-30 pb-30">
							<!-- <i class="fa fa-comments-o text-white font-64"></i> -->
							<img src="/resources/images/kakao.png">
							<h4 class="text-uppercase mt-20">
								<a href="#" class="text-white"
									onclick="window.open('http://pf.kakao.com/_xbvuRj/chat');">카카오톡 상담</a>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-3 pl-0 pl-sm-15 pr-0 pr-sm-15 sm-height-auto mt-sm-0 wow fadeInLeft animation-delay3">
					<div class="sm-height-auto bg-theme-colored-darker3">
						<div class="text-center pt-30 pb-30">
														<img src="/resources/images/apply.png">
							<h4 class="text-uppercase mt-20">
								<a href="/apply/login" class="text-white">수강신청</a>
							</h4>
						</div>
					</div>
				</div>
				<div
					class="col-sm-12 col-md-3 pl-0 pl-sm-15 pr-0 pr-sm-15 sm-height-auto mt-sm-0 wow fadeInLeft animation-delay4">
					<div class="sm-height-auto bg-theme-colored-darker4">
						<div class="text-center pt-30 pb-30">
														<img src="/resources/images/blog.png">
							<h4 class="text-uppercase mt-20">
								<a href="https://blog.naver.com/barohanl" class="text-white" target="_sub">블로그+</a>
							</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- Section: Services -->
	<section id="services" class="">
	<div class="container">
		<div class="section-content">
			<div class="row col-md-12">
				<div class="section-title">
					<div class="row col-md-12">
						<div class="col-md-12">
							<h2
								class="text-uppercase mt-0 line-bottom line-height-1 theme-colored">
								이벤트</h2>
						</div>
					</div>
				</div>

				<div id="grid" class="gallery-isotope grid-3 gutter clearfix">
					<c:forEach items="${list}" var="EventVO" end="2">
						<a href="/eventBoard/read?page=1&perPageNum=10&searchType&listType&keyword&num=${EventVO.num}">
							<div class="col-xs-12 col-sm-6 col-md-4 pb-sm-20">
								<div class="image-box-thum" style="height: 56.25%; text-align:center">
									<c:if test="${EventVO.name eq null}">
										<img src="/resources/images/default.jpg" class="upload-thumb">
									</c:if>

									<c:if test="${EventVO.name ne null}">
										<img src="displayImg?fileName=${EventVO.name}"
											class="upload-thumb">
									</c:if>
								</div>
								<div class="image-box-details pt-20 pb-sm-20">
									<h4 class="title text-uppercase line-bottom mt-0">${EventVO.title}</h4>
									<p class="listcontent" style="margin-right: 30%;">${EventVO.content}</p>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
</div>
</section>

<!-- Section: About -->
<section class="bg-lighter">
<div class="container">
	<div class="row">
	
	<!-- facebook plugin -->
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
			<script>
				(function(d, s, id) {
					var js, fjs = d.getElementsByTagName(s)[0];
					if (d.getElementById(id))
						return;
					js = d.createElement(s);
					js.id = id;
					js.src = 'https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.1';
					fjs.parentNode.insertBefore(js, fjs);
				}(document, 'script', 'facebook-jssdk'));
			</script>
			<h3 class="mt-0 line-bottom line-height-1 theme-colored">facebook</h3>
			<div class="fb-page"
				data-href="https://www.facebook.com/hannam.university"
				data-tabs="timeline" data-small-header="false"
				data-adapt-container-width="true" data-hide-cover="false"
				data-show-facepile="true">
				<blockquote cite="https://www.facebook.com/facebook"
					class="fb-xfbml-parse-ignore">
					<a href="https://www.facebook.com/facebook">Facebook</a>
				</blockquote>
			</div>
		</div>
		
		<!-- instagram plugin -->
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
			<div id="fb-root"></div>
			<script>
				$('.instagram-feed').each(function() {
					var current_div = $(this);
					var instagramFeed = new Instafeed({
						target : current_div.attr('id'),
						get : 'user',
						userId : current_div.data('userid'),
						accessToken : current_div.data('accesstoken'),
						resolution : 'low_resolution',
						limit : 9,
						template : '',
						after : function() {
						}
					});
					instagramFeed.run();
				});
			</script>
			<h3 class="mt-0 line-bottom line-height-1 theme-colored">instagram</h3>

			<div id="instafeed1" class="instagram-feed" data-userid="1212394882"
				data-accesstoken="1212394882.2aabac8.41ebc9f020b14e69aa38848469fef29e"
				data-limit="15" data-resolution="low_resolution"></div>
		</div>


		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
			<h3 class="mt-0 line-bottom line-height-1 theme-colored">youtube</h3>

			<div id="ytyt"></div>
			<script>
				var url = 'https://www.googleapis.com/youtube/v3/search?key=AIzaSyB5mV2xVDsOePgYBbYYe4QTbMYc9-kYmIA&channel'
						+ 'Id=UCiXDVCqPmUHMcl0R1rfERpw&part=snippet,id&order=date&maxResults=3';
				var fuck = null;

				$(document)
						.ready(
								function() {
									$.ajax({
												type : 'GET',
												url : url,
												data : 'JSON',
												success : function(data) {
													//                        alert(data.items[0].id.videoId);
													fuck = data;
													for (var i = 0; i < fuck.items.length; i++) {
														var ifrm = document
																.createElement("iframe");
														ifrm
																.setAttribute(
																		"src",
																		("https://www.youtube.com/embed/" + fuck.items[i].id.videoId));
														ifrm.style.width = "100%";
														ifrm.style.height = "100%";
														document
																.getElementById(
																		"ytyt")
																.appendChild(
																		ifrm);
													}
												}
											});
								});

				//document.writeLine("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/\"" + data.items[i].id.videoId + " frameborder=\"0\" encrypted-media\" allowfullscreen></iframe>");
			</script>



		</div>

	</div>
</section>





<!-- Divider: Clients -->
<section class="clients layer-overlay overlay-dark-1 bg-theme-color-2">
<div class="container pt-10 pb-0">
   <div class="row">
      <div class="col-md-12">
         <!-- Section: Clients -->
         <div
            class="owl-carousel-6col clients-logo transparent text-center owl-nav-top">
            <div class="item">
               <a href="http://www.thinkwise.co.kr/" target="_blank"><img src="resources/images/main-edugroup-png/main_ThinkWise.PNG"" alt=""></a>
            </div>
            <div class="item">
               <a href="http://www.redschool.or.kr/" target="_blank"><img src="resources/images/main-edugroup-png/main_MABSStudyCoachlabs.PNG" alt=""></a>
            </div>
            <div class="item">
               <a href="http://www.hanbitchan.com/bbs/group.php?gr_id=m6" target="_blank"><img src="resources/images/main-edugroup-png/main_MABSCamp.png" alt=""></a>
            </div>
            <div class="item">
               <a href="http://www.simtech.co.kr/main/main.asp" target="_blank"><img src="resources/images/main-edugroup-png/main_SimTech.PNG" alt=""></a>
            </div>
            <div class="item">
               <a href="http://www.100books.kr/" target="_blank"><img src="resources/images/main-edugroup-png/main_100BOOKS.PNG" alt=""></a>
            </div>
            <div class="item">
               <a href="http://i.concordiauhak.com/" target="_blank"><img src="/resources/images/main-edugroup-png/main_CONCORDIA.PNG" alt=""></a>
            </div>
            <div class="item">
               <a href="https://blog.naver.com/cancom77" target="_blank"><img src="/resources/images/main-edugroup-png/main_100Edulabs.png" alt=""></a>
            </div>
            <div class="item">
               <a href="#"><img src="/resources/images/main-edugroup-png/main_MAXPhyEdu.png" alt=""></a>
            </div>
            <div class="item">
               <a href="#"><img src="/resources/images/main-edugroup-png/main_Modelinglabs.png" alt=""></a>
            </div>
         </div>
      </div>
   </div>
</div>
</section>
</div>

<%@ include file="include/footer.jsp"%>