<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp"%>

<div class="main-content">
      <!-- Section: inner-header -->
      <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="/resources/images/image.jpg">
            <div class="container pt-70 pb-20">
                  <!-- Section Content -->
                  <div class="section-content">
                        <div class="row">
                        <div class="col-md-12">
                              <h2 class="title text-white">SD 갤러리</h2>
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
                                    <h3 class="line-bottom mt-20 mb-20 text-theme-colored">SD 갤러리</h3>
                              </div>
                              <div class="xet_content">
                                    <!-- // 게시판 시작 // -->
                                    <div id="xet_board" class="">

                                          <!-- // header // -->
                                          <div class="board-header">
                                                <!-- // 상단 내용 // -->
                                          </div>
                                          <div class="viewDocument">
                                                <div class="boardRead">
                                                      <div class="tab-pane fade in active" id="small">

                                                            <div class="panel panel-default">

                                <div class="panel-heading">
                                    <b>${galleryBoardVO.title}</b>
                                </div>
                                <div class="panel-body">
                                    <!-- 작성일 아이콘 -->
                                    <span> <i class="fa fa-clock" title="등록일"></i> <!-- 작성일 데이터 -->
                                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${galleryBoardVO.regdate}" />
                                    </span>

                                    <!-- 오른쪽 div -->
                                    <div class="blog-pull-right">
                                        <!-- 작성자 아이콘 -->
                                        <i class="fa fa-eye" title="조회수"></i>
                                        <!-- 작성자 데이터 -->
                                        ${galleryBoardVO.viewcnt}

                                    </div>
                                </div>

                                    <div class="panel-body">
                                        <div class="panel panel-default" style="width: 100%; height: 56.25%; float: center;">
                                            <c:forEach items="${list}" var="maimg">
                                        <div class="panel-body" style="text-align: center;">
                                            <c:set var="TextValue" value="${maimg}" />
                                            <img alt="" src="displayFile?fileName=${fn:substring(TextValue,0,12)}${fn:substring(TextValue,12,180)}">
                                        </div>
                                    </c:forEach>
                                        </div>
                                        <!-- 내용 -->
                                        <div class="panel panel-default">
                                            <div class="panel-body mb-10">

                                                <div class="form-group col-md-12" style="width: 100%;">
                                                    ${galleryBoardVO.content}</div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                                                      </div>
                                                      <!-- // 확장 변수 출력 // -->
                                                      <!-- // 본문 출력 // -->
                                                      <div class="boardReadBody">
                                                      </div>

                                                </div>
                                          </div>
                                          <!-- // 하단 내용 // -->
                                    </div>
                                    <!-- board End -->
                                    <!-- // 게시판 끝 // -->
                              </div>
                        </div>

                  </div>
                  <<div class="col-md-2 mt-30">
                        <div class="sidebar sidebar-left mt-sm-30">
                            <div class="widget">
                                <h5 class="widget-title line-bottom"><a href="introGroup">커뮤니티</a></h5>
                                <div class="categories">
                                    <ul class="list list-border angle-double-right">
                                        <li><a href="/notice/list">공지사항 </a></li>
                                        <li><a href="/imgGallery/list">SD 갤러리</a></li>
                                        <li><a href="/eventBoard/list">이벤트 게시판</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>   
            </div>
      </section>
</div>
<!-- end main-content -->

<div class="row">
   <div class="col-sm-6 col-md-push-6"
      style="text-align: center;">
      <div class="form-group" style="text-align: center;">
         <a href="/imgGallery/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}"
                class="btn btn-border btn-theme-colored">목록</a>
         </div>
      </div>
      <!-- /.box -->
</div>
<!-- /.row -->

<%@include file="../include/footer.jsp"%>