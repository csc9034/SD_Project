<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
   href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
   integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
   crossorigin="anonymous">
<%@include file="../include/header.jsp"%>

<div class="main-content">
	<!-- Section: inner-header -->
	<section class="inner-header layer-overlay overlay-dark-5" data-bg-img="/resources/images/newslist.jpg">
      <div class="container pt-70 pb-20">
         <!-- Section Content -->
         <div class="section-content">
            <div class="row">
               <div class="col-md-12">
                  <h2 class="title text-white">보도자료</h2>
   					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
               </div>

            </div>

         </div>
      </div>
   </section>


	<!-- Section: Job Apply Form -->
	<section class="divider">
		<div class="container">
			<div class="row col-md-10 blog-pull-right">
				<div class="xet_container">
					<div class="b_title">
						<h3 class="line-bottom mt-20 mb-20 text-theme-colored">보도자료
							게시판</h3>
					</div>

					<!-- 게시판 시작 -->
					<div class="xet_content">
						<div id="xet_board" class="">

							<!-- //header// -->
							<div class="board-header"></div>
							<!-- // 상단 내용// -->
						</div>


						<div class="viewDocument">
							<div class="boardRead">
								<div class="tab-pane fade in active" id="small">
									<div class="pannel panel-default">
										<!-- 제목 -->

										<div class="panel-heading">
											<h5>
												<b>${newsVO.newsTitle}</b>
											</h5>
										</div>
										<div class="panel-body">
											<!-- 등록일 -->
											<span><i class="fas fa-clock" title="등록일"></i>&nbsp; <fmt:formatDate
													pattern="yyyy-MM-dd HH:mm" value="${newsVO.newsRegDate}" /></span>

											<div class="blog-pull-right">
												<span><i class="fas fa-eye">&nbsp;</i>${newsVO.newsViewCnt}</span>
											</div>
											
											
											<hr>
											<div class="panel panel-default">
												<div class="panel-body mb-10">
													
														<!-- 첨부파일 -->
														<div class="blog-pull-right">
															<dt>
																<ul class="files">
																	<li><i class="fas fa-download" title="첨부"></i><a
																		href="downloadFile.do?fileName=${newsVO.fileName}">${newsVO.fileName}
																			<span class="bubble"></span>
																	</a></li>
																</ul>
															</dt>
														</div>
														<!-- 내용 -->
														<div class="form-group col-md-12">
															<div class="panel-body mb-10">
															
															${newsVO.newsText}
															 
													</div>
												<a href="${newsVO.newsLink}" target="_sub"><b><span style=font-size:17px;>>> 기사원문보기 << </span></b></a>
												</div>
												
												<!-- 링크 -->
												
											</div>
										</div>
									

									<div class="row">
										<div class="col-sm-6 col-md-push-6"
											style="text-align: center;">
											<div class="form-group" style="text-align: center;">
												<a
													href="/news/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=${cri.listType}"
													class="btn btn-border btn-theme-colored">
													목록</a>
											</div>
										</div>
									</div>
								</div>

								<!--  // 확장 변수 출력 // -->
								<!--  // 본문 출력// -->
								<div class="boardReadBody"></div>
							</div>
						</div>
						<!-- //하단 내용// -->
					</div>
					<!-- board End -->
					<!-- // 게시판 끝 // -->
				</div>
			</div>
			</div>
			</div>
			<div class="col-sm-2 mt-30 hidden-sm hidden-xs">

			<div class="sidebar sidebar-left mt-sm-60">
                  <div class="widget">
                     <h5 class="widget-title line-bottom">PR</h5>
                     <div id="accordion1" class="panel-group accordion">
         
                        <div class="panel">
                              <div class="panel-title">
                              <a  href="/news/list" >보도자료   </a>
                              </div>            
                           
                        </div>
                        <div class="panel">
                           <div class="panel-title">
                              <a  href="/review/list" >수강후기</a>
                              </div>      
                        </div>
                     </div>
                  </div>
               </div>

		</div>
	</section>
</div>

										<%-- <a href="${newsVO.newsLink}" target="_sub">기사원문보기</a> --%>
								











<%@include file="../include/footer.jsp"%>
