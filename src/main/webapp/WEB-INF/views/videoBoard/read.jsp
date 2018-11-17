
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="../include/header.jsp"%>

<!-- Start main-content -->
<div class="main-content" data-bg-img="/resources/images/main_img_1980.png">

	<!-- Section: inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		 data-bg-img="/resources/images/title.png">
		<div class="container pt-70 pb-20">
			<!-- Section Content -->
			<div class="section-content">
				<div class="row" >
					<div class="col-md-12">
						<h2 class="title text-white">동영상</h2>
						<ol class="breadcrumb text-left text-black mt-10">
							<li><a href="#">Home</a></li>
                            <li class="active text-gray-silver">동영상</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- The archive: C:/Program Files/Java/jdk1.8.0_161/lib/tools.jar which is referenced by the classpath, does not exist. -->
	<!-- Section: Course list -->
	<section class="layer-overlay overlay-dark-9">
		<div class="container">
			<div class="row">
					
				<div class="col-md-12 blog-classic-no-sidebar">
				<h3>동영상 게시판</h3>
					<hr>
					<!-- 상단 글제목과 게시일만 테이블로 -->
					 <div id="myTabContent" class="tab-content">
                  <div class="tab-pane fade in active" id="small">
                     <div class="panel panel-default">
                        <div class="panel-heading">제목</div>
                        <div class="panel-body">
                           ${videoBoardVO.title}
                        </div>
                     </div>
                     
                     <div class="panel panel-default">
                        <div class="panel-heading">날짜</div>
                        <div class="panel-body">
                           <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${videoBoardVO.regdate}" />
                        </div>
                     </div>
                     
                     
                     
                     <div class="panel panel-default">
                        <div class="panel-heading">내용</div>
                        
                        <div class="panel-body" >
                       
					<div class="form-group col-md-12" style="width:100%; height:56.25%">
						<iframe id="vid_prv" width=100% height="56.25%"
							src="https://www.youtube.com/embed/${videoBoardVO.link}"
							frameborder="0" gesture="media" allow="encrypted-media"
							allowfullscreen></iframe>
					</div>
					
					<div class="form-group col-md-12">${videoBoardVO.content}</div>
					<div class="col-md-12">
						<button style="float: right;" type="button" class="btn btn-border btn-theme-colored" id="cancleBtn">목록</button>
					</div>
                       
                       
                        </div>
                     </div>
                  </div>
                  
					
				</div>


			</div>



			<!-- end main-content -->

			<!-- Footer -->

		</div>
	</section>

</div>


<script>
	$(document)
			.ready(
					function() {

						$('#cancleBtn')
								.on(
										"click",
										function() {
											self.location = "/videoBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
													+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
										});
					});
</script>
<%@include file="../include/footer.jsp"%>