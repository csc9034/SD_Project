<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<div class="main-content">
	<!-- Section : inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/newslist.jpg">
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

	<!-- main  -->
	<section>


		<div class="container">
			<dic class="row">  </dic>
			<div class="col-sm-9 blog-pull-right">
				<div class="row">
					<div class="col-md-12 mt-10">
						<h4 class="line-bottom mt-20 mb-20 text-theme-colored">보도자료
							게시판</h4>
						<hr>
						<div data-example-id="striped-table" class="bs-example">
							<table class="table table-striped">
								<thead>

									<tr>
										<th>번호</th>
										<th class="board-title-middle">제목</th>
										<th>글쓴이</th>
										<th class="hidden-xs">날짜</th>
										<th>조회수</th>
									</tr>
								</thead>

								<c:forEach items="${list}" var="newsVO" varStatus="status">

									<tr>
										<%-- 기존의 번호 표현 : ${NewsVO.newsNum} --%>
										<!-- status.index를 쓰려면 위에 varStatus="status"를 써줘야 한다. -->

										<td align="center">${(pageMaker.totalCount - status.index) - pageMaker.listCount(pageMaker.cri.page)}</td>
										<td class="board-title-middle"><a
											href='/news/read${pageMaker.makeSearch(pageMaker.cri.page) }&newsNum=${newsVO.newsNum}'>${newsVO.newsTitle}</a></td>
										<td>${newsVO.adminId}</td>
										<td class="hidden-xs"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
												value="${newsVO.newsRegDate}" /></td>
										<td align="center">${newsVO.newsViewCnt}</td>
									</tr>

								</c:forEach>

							</table>
						</div>
					</div>
				</div>


				<!-- 페이징 -->
				<div class="row">
                   <div class="col-sm-12">
                       <nav>
                           <div class="text-center">
                               <ul class="pagination theme-colored xs-pull-center mb-xs-40">
                                   <li><a href="#" aria-label="Previous"> <span aria-hidden="true">«</span>
                                       </a></li>
                                   <c:if test="${pageMaker.prev}">
                                       <li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
                                   </c:if>

                                   <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
                                       <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}" />>
                                       <a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
                                       </li>
                                   </c:forEach>

                                   <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                       <li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
                                   </c:if>
                                   <li><a href="#" aria-label="Next"> <span aria-hidden="true">»</span>
                                       </a></li>
                               </ul>
                           </div>
                       </nav>
                   </div>
               </div>



				<!-- 정렬 기준을 정하는 콤보박스 -->
				<!-- 항목 클릭 시, 페이지를 이동하는 콤보박스. 링크의 마지막에 listType의 value dd/da/vc를 넣어준다. -->

				<div class="row">
						<div class="col-md-2">

							<select name="listType" id="sortingVeiw" class="form-control"
								onchange="if(this.value) location.href=(this.value);">
								<option
									value="/news/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=${cri.listType}">정렬
									기준</option>
								<option <c:out value="${cri.listType eq 'dd'?'selected':''}"/>
									value="/news/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=dd">최신순</option>
								<option <c:out value="${cri.listType eq 'da'?'selected':''}"/>
									value="/news/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=da">오래된순</option>
								<option <c:out value="${cri.listType eq 'vc'?'selected':''}"/>
									value="/news/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=vc">조회순</option>
							</select>
						</div>
						<div class="col-md-2">
							<select name="searchType" id="searchType" class="form-control">

								<option value="t"
									<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
									제목</option>
								<option value="c"
									<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
									내용</option>
								<option value="tc"
									<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
									제목 + 내용</option>

							</select>
						</div>
					<!-- 검색 기능 콤보박스 -->
						<!-- 검색 텍스트필드 -->
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" id="keywordInput"
									placeholder="Search">
							</div>
						</div>
						<div class="col-md-2 mt-5 pull-right">
							<button id='searchBtn' type="submit" class="btn btn-default">
                           	 <i class="fa fa-search"></i>
                             검색
                            </button>
						</div>
				</div>
			</div>




			<!-- /. side Menu -->
<!-- 			<div class="col-sm-2 mt-30">

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

			</div> -->
			
                <div class="col-sm-2 mt-30 hidden-sm hidden-xs">
                        <div class="sidebar sidebar-left mt-sm-30">
                            <div class="widget">
                                <h5 class="widget-title line-bottom"><a href="introGroup">PR</a></h5>
                                <div class="categories">
                                    <ul class="list list-border angle-double-right">
                                        <li><a  href="/news/list" >보도자료	</a></li>
                                        <li><a  href="/review/list" >수강후기</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
		</div>
	</section>
	<!-- /.content -->
</div>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>
<!-- 스크립트 메세지 -->

<!-- 페이지이동 스트립트 -->

<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "/news/list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("#searchType option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "/admin/news/register";

				});

			});
</script>
<!-- 검색버튼, 등록버튼 스크립트 -->

<form id="jobForm">
	<input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
	<input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum}>
</form>






<%@include file="../include/footer.jsp"%>
