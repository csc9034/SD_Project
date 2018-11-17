<%--
	
	기관 소개 뷰
	
	작성자 : 진재환
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>

<!-- CUSTOM STYLE | Created  by. KAYH -->
<link href="/resources/css/custom-introgroup.css" rel="stylesheet" type="text/css">

<div class="main-content">

    <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="/resources/images/edugroup.jpg">
        <div class="container pt-70 pb-20">
            <!-- Section Content -->
            <div class="section-content">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="title text-white">기관소개</h2>
   					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container pb-40">
            <div class="section-title">
                <div class="row mb-15">
                    <div class="col-sm-15 col-md-15">
                        <div class="col-md-9 blog-pull-right">
                            <h4 class="line-bottom mt-0 mt-sm-20">
                                <b>
                                    기관 소개
                                    <c:if test="${division eq '1'}">
                                        - 연구소
                                    </c:if>
                                    <c:if test="${division eq '2'}">
                                        - 교육센터
                                    </c:if>
                                </b>
                            </h4>
                            <div class="col-md-12">
                                <hr />
                            </div>
                            <div>
                                <!-- 기관정보 컨텐츠 시작 -->
                                <c:forEach var="company" items="${companys}" varStatus="compState">
                                    <c:choose>
                                        <%--
											forEach문의 status인 compState의 인덱스가
											짝수이면 소개글이 먼저 표시되고
											홀수이면 기관 사진이 먼저 표시됨
										--%>
                                            <c:when test="${compState.index % 2 == 0}">
                                                <div class="row comp-card">
                                                    <div class="col-md-5 col-xs-12 pull-left">
                                                        <div class="card effect__hover">
                                                            <div class="card__front">
                                                                <img class="compImg" alt="기관 사진" src="displayFile?fileName=${company.imglink}" />
                                                            </div>
                                                            <div class="card__back" data-bg-color="#e0e0e0">
                                                                <div class="card__text">
                                                                    <div class="display-table-parent p-30">
                                                                        <div class="display-table">
                                                                            <div class="display-table-cell">
                                                                                <h4>기관 정보</h4>
                                                                                <hr />
                                                                                <div class="row">
                                                                                    <div class="col-md-1">
                                                                                        <i class="fa fa-phone" aria-hidden="true"></i>
                                                                                    </div>
                                                                                    <div class="col-md-9">
                                                                                        ${company.phone}
                                                                                    </div>
                                                                                </div>
                                                                                <br />
                                                                                <div class="row">
                                                                                    <div class="col-md-1">
                                                                                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                                                                                    </div>
                                                                                    <div class="col-md-9">
                                                                                        <span>(${company.zipcode}) ${company.frontaddr}
                                                                                            ${company.rearaddr}</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xs-12 pull-right title-div">
                                                        <div class="row line-bottom-long">
                                                            <div class="col-md-12 comp-title">
                                                                ${company.compname}
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <ul class="list theme-colored angle-double-right">
                                                                    <c:if test="${company.target ne null}">
                                                                        <li>대상: ${company.target}</li>
                                                                    </c:if>
                                                                    <c:if test="${company.compfield ne null}">
                                                                        <li>분야: ${company.compfield}</li>
                                                                    </c:if>
                                                                    <li class="comp-desc">
                                                                        ${company.compdesc}
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="row comp-card">
                                                    <div class="col-md-5 col-xs-12 pull-right">
                                                        <div class="card effect__hover">
                                                            <div class="card__front">
                                                                <img class="compImg" alt="기관 사진" src="displayFile?fileName=${company.imglink}" />
                                                            </div>
                                                            <div class="card__back" data-bg-color="#e0e0e0">
                                                                <div class="card__text">
                                                                    <div class="display-table-parent p-30">
                                                                        <div class="display-table">
                                                                            <div class="display-table-cell">
                                                                                <h4>기관 정보</h4>
                                                                                <hr />
                                                                                <div class="row">
                                                                                    <div class="col-md-1">
                                                                                        <i class="fa fa-phone" aria-hidden="true"></i>
                                                                                    </div>
                                                                                    <div class="col-md-9">
                                                                                        ${company.phone}
                                                                                    </div>
                                                                                </div>
                                                                                <br />
                                                                                <div class="row">
                                                                                    <div class="col-md-1">
                                                                                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                                                                                    </div>
                                                                                    <div class="col-md-9">
                                                                                        <span>(${company.zipcode}) ${company.frontaddr}
                                                                                            ${company.rearaddr}</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-7 col-xs-12 pull-left title-div">
                                                        <div class="row line-bottom-long">
                                                            <div class="col-md-12 comp-title">
                                                                ${company.compname}
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <ul class="list theme-colored angle-double-right">
                                                                    <c:if test="${company.target ne null}">
                                                                        <li>대상: ${company.target}</li>
                                                                    </c:if>
                                                                    <c:if test="${company.compfield ne null}">
                                                                        <li>분야: ${company.compfield}</li>
                                                                    </c:if>
                                                                    <li class="comp-desc">
                                                                        ${company.compdesc}
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div> <!-- 기관정보 컨텐츠 끝 -->
                        </div>
                    </div>
                    <!-- 	nav 시작 -->
                                 <div class="col-sm-2 mt-30 hidden-sm hidden-xs">

                        <div class="sidebar sidebar-left mt-sm-30">
                            <div class="widget">
                                <h5 class="widget-title line-bottom"><a href="introGroup">기관소개</a></h5>
                                <div class="categories">
                                    <ul class="list list-border angle-double-right">
                                        <li><a href="introGroup?division=1">연구소</a></li>
                                        <li><a href="introGroup?division=2">교육센터</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- nav 종료 -->
                </div>
            </div>
        </div>
    </section>
</div>
<%@ include file="../include/footer.jsp"%>