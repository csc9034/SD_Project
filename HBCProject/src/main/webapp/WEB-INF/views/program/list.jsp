<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>

<!-- Start main-content -->
<div class="main-content">
    <!-- Section: inner-header -->
    <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="/resources/images/consulting.jpg">
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

    <!-- Section: Event List -->
    <section>
        <div class="container">
            <div class="row">

                <div class="col-md-9 blog-pull-right">
                	<c:if test="${cri.categorize eq 1}">
                    	<h3 class="widget-title line-bottom"><b>학습법</b></h3>
                    	</c:if>
                	<c:if test="${cri.categorize eq 2}">
                    	<h3 class="widget-title line-bottom"><b>소프트웨어</b></h3>
                    	</c:if>
                    	
                    	
                    <c:forEach items="${list}" var="programVO"  varStatus="status">

                        <div class="upcoming-events bg-white-f3 mb-20">
                            <div class="row">
                                <div class="col-sm-4 pr-0 pr-sm-15">
                                    <div class="thumb p-15">
                                        <!-- 대표 이미지가 들어가는 공간  -->
                                        <c:if test="${programVO.link != null}">
					                  <iframe id="vid_prv" height="170px" src="https://www.youtube.com/embed/${fn:substring(programVO.link, 17, 250)}" frameborder="0" gesture="media"
                                        allow="encrypted-media" allowfullscreen></iframe>
					                </c:if>
					                <c:if test="${programVO.link == null}">
                                         <c:if test="${programVO.name ne null}">
                                         <img src="/displayFile?fileName=${fn:substring(programVO.name,0,12)}${fn:substring(programVO.name,14,180)}" alt="" style="width: auto; width: auto; max-height: 170px;">
                                         </c:if>
                                         <c:if test="${programVO.name eq null}">
                                          <img class="img-fullwidth" src="http://www.dreams.metroeve.com/wp-content/uploads/2017/10/www.dreams.metroeve.com-mathematics-dreams-meaning.jpg"
                                              alt="..." style="width: auto; width: auto; max-height: 170px;">
                                         </c:if>
                                         
                                     </c:if>
                                    </div>
                                </div>
                                <div class="col-sm-8 pl-0 pl-sm-15">
                                    <div class="event-details p-15 mt-20">
                                        <h4 class="media-heading text-uppercase font-weight-500">${programVO.title}</h4>
                                        <ul class="mt-15">
                                            <li>
                                            </li>
                                        </ul>

                                        <p class="listcontent" style="margin-right: 30%;">${programVO.content}</p>
                                        <a href="../program/detail${pageMaker.makeSearch(pageMaker.cri.page) }&compnum=${companyVO.compnum}&categorize=1&intronum=${programVO.intronum}" class="btn btn-flat btn-dark btn-theme-colored btn-sm mb-15"> Details <i class="fa fa-angle-double-right"></i></a>
                            </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                    <div class="upcoming-events bg-white-f3 mb-20">
                        <div class="row">


                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <nav>
                                <div class="text-center">
                                    <ul class="pagination theme-colored xs-pull-center mb-xs-40">
                                        <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">«</span> </a> </li>
                                        <c:if test="${pageMaker.prev}">
                                            <li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }&categorize=${cri.categorize}&compnums=${cri.compnums}">&laquo;</a></li>
                                        </c:if>

                                        <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
                                            <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}" />>
                                            <a href="list${pageMaker.makeSearch(idx)}&categorize=${cri.categorize}&compnums=${cri.compnums}">${idx}</a>
                                            </li>
                                        </c:forEach>

                                        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                            <li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }&categorize=${cri.categorize}&compnums=${cri.compnums}">&raquo;</a></li>
                                        </c:if>
                                        <li> <a href="#" aria-label="Next"> <span aria-hidden="true">»</span> </a> </li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-3 mt-30">
                    <div class="sidebar sidebar-left mt-sm-60">
                        <div class="widget">
                            <h5 class="widget-title line-bottom">기관 목록</h5>
                            <div id="accordion1" class="panel-group accordion">

                                <c:forEach items="${sideList}" var="companyVO" varStatus="status">
                                    <!-- 기관수 만큼 사이드 메뉴 반복 -->
                                    <div class="panel">
                                        <div class="panel-title">
                                            <a class="collapsed" data-parent="#accordion1" data-toggle="collapse" href="#accordion${2 + status.index}" aria-expanded="false">
                                                <span class="open-sub"></span>${companyVO.compname} </a> </div>
                                        <div id="accordion${2 + status.index}" class="panel-collapse collapse" role="tablist" aria-expanded="false" style="height: 0px;">
                                            <div class="panel-content">
                                                <ul class="list-icon list-divider list-border">
                                                    <li><a href="./list${pageMaker.makeSearchs(pageMaker.cri.page) }&compnums=${companyVO.compnum}&categorize=1"><i
                                                                class="fa fa-hand-o-right mr-10 text-black-light"></i>학습법</a></li>
                                                    <li><a href="./list${pageMaker.makeSearchs(pageMaker.cri.page) }&compnums=${companyVO.compnum}&categorize=2"><i
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
        </div>
    </section>
</div>
<!-- end main-content -->
<%@ include file="../include/footer.jsp"%>