<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp"%>


<div class="main-content">
	<!-- Section: inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/coursereview.jpg">
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

	<section>
	<div class="container">
		<dic class="row"> <!-- 		<div class="col-md-12 mt-5"> --> <!-- 			<a href="#" class="btn btn-default" style="float: right">등록</a> -->
		<!-- 		</div> --> </dic>
		<div class="col-sm-9 blog-pull-right" >
		<div class="row">
			<div class="col-md-12 mt-10">
			<h4 class="line-bottom mt-20 mb-20 text-theme-colored">수강후기 게시판</h4>
				<hr>
				<div data-example-id="striped-table" class="bs-example">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th class="hidden-xs">센터</th>
								<th>강좌</th>
								<th class="board-title-short">제목</th>
								<th class="hidden-xs">날짜</th>
								<th>
									<span class="visible-xs"><i class="fa fa-eye"></i></span>
	                                <span class="hidden-xs">조회수</span>
								</th>
							</tr>
						</thead>

						<c:forEach items="${list}" var="reviewVO" varStatus="status">

							<tr onclick='location.href="/review/read${pageMaker.makeSearch(pageMaker.cri.page) }&reviewNum=${reviewVO.reviewNum}&searchComp=${cri.searchComp}&searchCour=${cri.searchCour}"' style="text-align: center; cursor: pointer">
								<td>${(pageMaker.totalCount-status.index) - pageMaker.listCount(pageMaker.cri.page) }</td>
								<td class="hidden-xs">${reviewVO.compName }</td>
								<td>${reviewVO.courName }</td>
								<td style="text-align: left;"><b>${reviewVO.reviewTitle} </b></td>
								<td class="hidden-xs"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${reviewVO.reRegDate}" /></td>
								<td>${reviewVO.reviewCnt}</td>
							</tr>
						</c:forEach>
					</table>
				</div>



			</div>
			
		</div>
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

		<div class="row">
			<div class="row mb-10">
				<div class="col-md-10">
					<div class="col-md-6">
						<select id="company" name="companyNum"
							onchange="compSelect(this.value)" class="form-control">
							<option value="0">센터선택</option>
							<c:forEach items="${compSelect}" var="companyVO"
								varStatus="status">
								<c:choose>
									<c:when test="${companyVO.compnum eq cri.searchComp}">
										<option value="${companyVO.compnum} " selected="selected">${companyVO.compname }</option>
									</c:when>
									<c:otherwise>
										<option value="${companyVO.compnum} ">${companyVO.compname }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-6">
						<select id="cour" name="cour" class="form-control">
							<option value="0">강좌선택</option>
							<c:forEach items="${courList}" var="cour" varStatus="status">
								<c:choose>
									<c:when test="${cour.cournum eq cri.searchCour}">
										<option value="${cour.cournum} " selected="selected">${cour.courname }</option>
									</c:when>
									<c:otherwise>
										<option value="${cour.cournum} ">${cour.courname }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
			</div> <!-- row end -->
			
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 mb-30">
						<select name="listType" id="sortingView" class="form-control" onchange="if(this.value) location.href=(this.value);">
							<option>정렬기준</option>
							<option <c:out value="${cri.listType eq 'new'?'selected':''}"/>
								value="/review/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=new">최신순</option>
							<option <c:out value="${cri.listType eq 'most'?'selected':''}"/>
								value="/review/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=most">조회순</option>
						</select>
					</div>
					<div class="col-md-2">
						<select name="searchType" class="form-control">
							<option value="t"
								<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
								제목</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
								내용</option>
						</select>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<input type="text" class="form-control" id="search" placeholder="Search">
						</div>
					</div>
					<div class="col-md-2 mt-5 pull-right">
						<button id='searchBtn' type="submit" class="btn btn-default">검색</button>
					</div>
				</div>
			</div> <!-- row end -->

					<%-- <input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
                  <button id='searchBtn'>Search</button> --%>
				</div>

			</div>
<!-- 				<div class="col-sm-2 mt-30">

					<div class="sidebar sidebar-left mt-sm-60">
						<div class="widget">
							<h5 class="widget-title line-bottom">PR</h5>
							<div id="accordion1" class="panel-group accordion">
			
								<div class="panel">
										<div class="panel-title">
										<a  href="/news/list" >보도자료	</a>
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
</div>
<!-- end main-content -->
<script type="text/javascript">
	//AJAX select box
	function compSelect(company) {
		
		$.ajax({
			type : "POST",
			url : "/review/list.do",
			dataType : "json",
			data : {
				param : company
			},
			success : function(result) {

				//SELECT BOX 초기화           
				$("#cour").find("option").remove().end().append(
						"<option value='0'>강좌선택</option>");

				//배열 개수 만큼 option 추가
				$.each(result, function(i) {
					$("#cour").append(
							"<option value='"+result[i].cournum+"'>"
									+ result[i].courname + "</option>")
				});
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("오류가 발생하였습니다.");
			}
		});
	}
</script>
<script>
   $(document).ready(
         function() {
         
            
            $('#searchBtn').on(
                  "click",
                  function(event) {
                     
                     
                     self.location = "list"
                        
                        + '${pageMaker.makeQuery(1)}'
                        + "&searchType="
                        + $("#searchType option:selected").val()
                        
                        + "&searchCour="
                        + $("#cour option:selected").val()
                        
                        + "&searchComp="
                        + $("#company option:selected").val()
                        + "&keyword=" + $('#keyword').val();

               });
         });
</script>

<%@ include file="../include/footer.jsp"%>