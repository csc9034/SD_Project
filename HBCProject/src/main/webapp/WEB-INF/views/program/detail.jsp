<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Start main-content -->
<div class="main-content">

	<!-- Section: inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/progarm.jpg">
	<div class="container pt-70 pb-20">
		<!-- Section Content -->
		<div class="section-content">
			<div class="row">
				<div class="col-md-12">
					<h2 class="title text-white">프로그램소개</h2>
					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- Section: About -->
	<section class="divider">
	<div class="container">

		<div class="col-sm-9 blog-pull-right">
			<div class="row">
				<div class="col-md-12">
					<h6
						class="letter-space-4 text-gray-darkgray text-uppercase mt-0 mb-0">
						All About</h6>
					<h2 class="text-uppercase font-weight-600 mt-0 font-28 line-bottom">
						${programVO.title}</h2>

				</div>
				<div class="col-md-12 text-center">
					<div class="fluid-video-wrapper">
						<c:if test="${programVO.link == null}">
							<c:forEach items="${mainImg}" var="imgVO" end="0">
								<div class="col-md-12">
									<img src="/displayFile?fileName=${imgVO.name}" alt="">
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${programVO.link != null}">
							<iframe width="560" height="315"
								src="https://www.youtube.com/embed/${fn:substring(programVO.link, 17, 250)}"
								frameborder="0" allowfullscreen class="col-md-12"></iframe>
						</c:if>
					</div>

				</div>
			</div>
			<div class="row">

				<div class="col-md-12 mt-20">
					<div class="section-title">
						<div class="separator separator-small-line separator-rouned">
							<i class="fa fa-pencil"></i>
						</div>
						<div class="row">
							<div class="panel panel-default col-md-12">
								<!-- Default panel contents -->
								<div class="panel-body">
									<div class="col-md-12 text-center">
										<p>${programVO.content}</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${mainImg ne null}">
						<h3
							class="text-uppercase font-weight-600 mt-0 font-28 line-bottom ">이미지</h3>
						<div class="panel panel-default col-md-12">
							<!-- Default panel contents -->
							<div class="panel-body">
								<div class="col-md-12 text-center">
									<div class="owl-carousel-4col">
										<c:forEach items="${mainImg}" var="imgVO">
											<div class="gallery-isotope grid-1 gutter-small clearfix"
												data-lightbox="gallery">
												<div class="item">
													<div class="gallery-item">
														<div>
															<a
																href="/displayFile?fileName=${fn:substring(imgVO.name,0,12) }${fn:substring(imgVO.name,14,180) }"
																data-lightbox="gallery-item"
																title="${imgVO.num}.${programVO.title} 이미지"> <img
																alt=""
																src="/displayFile?fileName=${fn:substring(imgVO.name,0,12) }${fn:substring(imgVO.name,14,180) }"
																width="180px" height="120px">
															</a>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>



					</c:if>
				</div>


				

			</div>
			<div class="row">
				<div class="col-sm-6 col-md-push-6" style="text-align: center;">
					<div class="form-group" style="text-align: center;">

						<a
							href="./list?compnums=${programVO.compnum}&categorize=${programVO.category}&${pageMaker.makeSearch(pageMaker.cri.page) }&intronum=${ProgramVO.introNum}"
							class="btn btn-border btn-theme-colored">목록</a>

					</div>
				</div>
				<!-- /.box -->
			</div>
		</div>
		<div class="col-sm-2 mt-30">

			<div class="sidebar sidebar-left">
				<div class="widget">
					<h5 class="widget-title line-bottom">기관 목록</h5>
					<div id="accordion1" class="panel-group accordion">

						<c:forEach items="${sideList}" var="companyVO" varStatus="status">
							<!-- 기관수 만큼 사이드 메뉴 반복 -->
							<div class="panel">
								<div class="panel-title">
									<a class="collapsed" data-parent="#accordion1"
										data-toggle="collapse" href="#accordion${2 + status.index}"
										aria-expanded="false"> <span class="open-sub"></span>${companyVO.compname}
									</a>
								</div>
								<div id="accordion${2 + status.index}"
									class="panel-collapse collapse" role="tablist"
									aria-expanded="false" style="height: 0px;">
									<div class="panel-content">
										<ul class="list list-divider list-border">
											<li><a
												href="./list${pageMaker.makeSearch(pageMaker.cri.page) }&compnums=${companyVO.compnum}&categorize=1&intronum=${ProgramVO.intronum}"><i
													class="fa fa-hand-o-right mr-10 text-black-light"></i> 학습법</a></li>
											<li><a
												href="./list${pageMaker.makeSearch(pageMaker.cri.page) }&compnums=${companyVO.compnum}&categorize=2&intronum=${ProgramVO.intronum}"><i
													class="fa fa-hand-o-right mr-10 text-black-light"></i>소프트웨어</a></li>
										</ul>

									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
</div>
<!-- end main-content -->
<%@ include file="../include/footer.jsp"%>