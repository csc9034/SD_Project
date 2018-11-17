
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<c:if test="${sessionScope.stuLogin.stuid ne null}">
	<% 
	/*
		이미 로그인 세션이 존재하면
		관리자 메인 화면으로 이동
	*/
	response.sendRedirect("/apply/center"); 	
	%>
</c:if>

<!-- Start main-content -->
<div class="main-content">
	<!-- Section: inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/courseapply.jsp.jpg">
		<div class="container pt-70 pb-20">
			<!-- Section Content -->
			<div class="section-content">
				<div class="row">
					<div class="col-md-12">
						<h2 class="title text-white">수강신청</h2>
   					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

</div>

<!-- Section: Course list -->
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-9 blog-pull-right">
		        <div class="display-table-cell">
		          <div class="container">
		            <div class="row">
		              <div class="col-md-6 col-md-push-1">
		                <h4 class="text-theme-colored mt-0 pt-10 line-bottom"> 학원생 로그인</h4>
		                <hr>
		                <form name="login-form" onsubmit="return validateEmptyVal()" role="form" class="clearfix" method="post" action="loginPost">
		                  <div class="row">
		                    <div class="form-group col-md-12">
		                      <label for="form_username_email">아이디</label>
		                      <input id="form_username_email"  name="stuid" class="form-control" type="text">
		                    </div>
		                  </div>
		                  <div class="row">
		                    <div class="form-group col-md-12">
		                      <label for="form_password">비밀번호</label>
		                      <input id="form_password" name="stupw" class="form-control" type="password">
		                    </div>
		                  </div>
		                  <div class="clear text-center pt-10">
		                    <button type="submit" class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="#" data-bg-color="#3b5998">
		                    	학원생 계정으로 로그인
		                    </button>
		                    <a class="btn btn-dark btn-lg btn-block no-border" href="/">
		                    	<i class="fa fa-home"></i>
		                    	홈으로 돌아가기
		                    </a>
		                  </div>
		                </form>
		              </div>
		            </div>
		          </div>
		        </div>
			</div>


			<!-- nav 시작 -->
			<div class="col-md-3">
				<div class="sidebar sidebar-left mt-sm-30">
					<div class="widget">
						<h5 class="widget-title line-bottom">수강신청</h5>
						<div class="categories">
							<ul class="list list-border angle-double-right">
								<c:forEach items="${appCompList}" var="list" varStatus="status">
								<li><a href="/apply/list?page=${cri.page}&perPageNum=${cri.perPageNum}&compnum=${list.compnum }">${list.compname }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- nav 종료 -->



		</div>
	</div>
</section>
</div>
<!-- end main-content -->

	<script>
		$(document).ready(
				function() {

					$('#btn-default').on(
							"click",
							function(event) {

								self.location = "center"
										+ '${pageMaker.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							});

				});
	</script>

	<%@include file="../include/footer.jsp"%>