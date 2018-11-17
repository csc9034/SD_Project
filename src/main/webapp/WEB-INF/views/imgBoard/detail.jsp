<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp"%>

<div class="main-content">
    <!-- Section: inner-header -->
    <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="http://placehold.it/1920x1280">
        <div class="container pt-70 pb-20">
            <!-- Section Content -->
            <div class="section-content">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="title text-white">이미지</h2>
                        <ol class="breadcrumb text-left text-black mt-10">
                            <li><a href="/">Home</a></li>
                            <li><a href="/imgBoard/list">게시판</a></li>
                            <li class="active text-gray-silver">리스트</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Section: Job Apply Form -->
    <section class="divider">
        <div class="container">
            <div class="row col-sm-10 blog-pull-right">
                <div class="col-sm-12 ">
                    <h4 class="line-bottom mt-20 mb-20 text-theme-colored">이미지</h4>
                    <div>
                        <div id="myTabContent" class="">
                            <div class="tab-pane fade in active" id="small">
                                <div class="panel panel-default">
                                    <div class="panel-heading">제목</div>
                                    <div class="panel-body">
                                        ${imgBoardVO.title}
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">날짜</div>
                                    <div class="panel-body">
                                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${imgBoardVO.regdate}" />
                                    </div>
                                </div>


                                <!-- 메인이미지 -->
                                <c:forEach items="${mainImg}" var="maimg">
                                    <div class="col-sm-1"></div>
                                    <div class="col-sm-10 mt-20" style="text-align: center;">
                                        <c:set var="TextValue" value="${maimg.name}" />
                                        <img alt="" src="/displayFile?fileName=${fn:substring(TextValue,0,12)}${fn:substring(TextValue,12,180)}">
                                    </div>
                                </c:forEach>



                                <!-- 글 내용  -->
                                <!-- mt-50: 높이 간격 -->
                                <div class="col-sm-12 mt-50">
                                    <div class="col-sm-1"></div>
                                    <div class="col-sm-10">${imgBoardVO.content}</div>
                                </div>

                                <!-- 추가이미지_version.4 -->
                                <div class="heading-line-bottom mt-50">
                                    <h4 class="text-uppercase font-weight-600 mt-0">더 많은 사진을 클릭해 보세요</h4>
                                </div>

                                <!-- 추가이미지 Grid -->
                                <div class="gallery-isotope grid-3 gutter-small clearfix" data-lightbox="gallery">
                                    <!--  Item Start -->
                                    <c:forEach items="${imgs}" var="imgs">
                                        <div class="gallery-item">
                                            <c:set var="TextValue" value="${imgs.name}" />
                                            <a href="/displayFile?fileName=${fn:substring(TextValue,0,12) }${fn:substring(TextValue,14,180) }" data-lightbox="gallery-item"
                                                title="Title Here 2">
                                                <img alt="" src="/displayFile?fileName=${fn:substring(TextValue,0,12) }${fn:substring(TextValue,14,180) }">
                                            </a>
                                        </div>
                                    </c:forEach>
                                    <!--  Item End -->
                                </div>
                                <!-- End 추가이미지 Grid -->

                            </div>
                        </div>
                    </div>



                    <!-- 타 게시글 링크걸린 (해당 게시글 활동에 사용된 관련 프로그램 보러가기) 이미지들 -->
                    <div class="col-sm-12 mt-80">
                        <h3 class="text-uppercase font-weight-600 mt-0  line-bottom ">사용된 프로그램 보러가기</h3>

                        <div class="owl-carousel-4col" style="background-color: #EAEAEA">

                            <c:forEach items="${RImgs}" var="r">

                                <div class="item">
                                    <div>
                                        <a href="../imgBoard/detail?imgnum=${r.imgnum}"> <img alt="" src="/displayFile?fileName=${r.name}"
                                                style="margin-top: 5px; margin-bottom: 5px;">
                                        </a>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>

                    </div>
                </div>
            </div>


            <div class="col-sm-2 mt-30 hidden-sm hidden-xs">

                <div class="sidebar sidebar-left mt-sm-60">
                    <div class="widget">
                        <h5 class="widget-title line-bottom">커뮤니티</h5>
                        <div id="accordion1" class="panel-group accordion">

                            <div class="panel">
                                <div class="panel-title">
                                    <a href="/notice/list">공지사항</a>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-title">
                                    <a href="/imgBoard/list">이미지 </a>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-title">
                                    <a href="/eventBoard/list">이벤트 </a>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
</div>
<!-- end main-content -->

<div class="row">
    <div class="col-sm-6 col-md-push-6" style="text-align: center;">
        <div class="form-group" style="text-align: center;">

            <a href="/imgBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}"
                class="btn btn-border btn-theme-colored">목록</a>
        </div>
    </div>
    <!-- /.box -->
</div>
<!-- /.row -->

<%@include file="../include/footer.jsp"%>