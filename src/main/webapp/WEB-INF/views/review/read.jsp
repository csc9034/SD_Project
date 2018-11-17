<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
    crossorigin="anonymous">
<%@ include file="../include/header.jsp"%>

 <div class="main-content">
     <!-- Section: inner-header -->
     <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="/resources/images/coursereview.jpg">
         <div class="container pt-70 pb-20">
             <!-- Section Content -->
             <div class="section-content">
                 <div class="row">
                     <div class="col-md-12">
                         <h2 class="title text-white">수강후기</h2>
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
                         <h3 class="line-bottom mt-20 mb-20 text-theme-colored">수강후기 게시판</h3>
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
                                             <!-- 제목 -->

                                             <div class="panel-heading ">
                                                 <h4>
                                                     <b>${reviewVO.reviewTitle}</b>
                                                 </h4>
                                             </div>
                                             <div class="panel-body ">
                                                 <!-- 등록일 -->
                                                 <span>
                                                     <i class="fas fa-clock" title="등록일"></i>
                                                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reviewVO.reRegDate}"
                                                     />
                                                 </span>

                                                 <div class="blog-pull-right">
                                                     <span>
                                                         <i class="fas fa-eye"></i> ${reviewVO.reviewCnt}</span>
                                                 </div>
                                             </div>




                                             <div class="panel-heading">
                                                 <!-- 센터 -->
                                                 <span>
                                                     <i class="fas fa-building"></i>
                                                     </i>
                                                     ${reviewVO.compName}&nbsp;&nbsp;
                                                 </span>
                                                 <!-- 강좌 -->
                                                 <span>
                                                     <i class="fas fa-book-open"></i>
                                                     </i>
                                                     ${reviewVO.courName}&nbsp;&nbsp;
                                                 </span>
                                                 <!-- 강사 -->
                                                 <span>
                                                     <i class="fas fa-user" title="강사"></i>
                                                     ${reviewVO.empName}
                                                 </span>
                                             </div>



                                             <div class="panel panel-default">
                                                 <div class="panel-body mb-10">

                                                     <!-- 글영역 -->
                                                     <div class="form-group col-md-12" style="width: 100%; height: 56.25%">



                                                         <!-- 내용 -->

                                                         <div class="panel-body mb-10">
                                                             <!--                                     <div class="form-group col-md-12 mt-15 "> -->
                                                             ${reviewVO.reviewText}
                                                         </div>
                                                     </div>
                                                 </div>

                                             </div>

                                             <div class="panel-body md-12">
                                                 <div align="center">
                                                     <a href="/apply/list?page=1&perPageNum=10&compnum=${reviewVO.compNum}" class="btn btn-border" target="_sub">수강신청 하러가기
                                                         <i class="fa fa-arrow-circle-right"></i>
                                                     </a>

                                                     <a href="${reviewVO.uri }" class="btn btn-border" target="_sub">수강후기 보러가기
                                                         <i class="fa fa-arrow-circle-right"></i>
                                                     </a>

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
             <div class="col-sm-2 mt-30 hidden-sm hidden-xs">

                 <div class="sidebar sidebar-left mt-sm-60">
                     <div class="widget">
                         <h5 class="widget-title line-bottom">PR</h5>
                         <div id="accordion1" class="panel-group accordion">

                             <div class="panel">
                                 <div class="panel-title">
                                     <a href="/news/list">보도자료 </a>
                                 </div>

                             </div>
                             <div class="panel">
                                 <div class="panel-title">
                                     <a href="/review/list">수강후기</a>
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

             <a href="/review/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchCour=${cri.searchCour}&searchComp=${cri.searchComp}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=new"
                 class="btn btn-border btn-theme-colored">목록</a>

         </div>
     </div>
     <!-- /.box -->
 </div>
 <!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>