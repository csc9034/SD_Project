<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../include/header.jsp"%>

<div class="main-content">
    <!-- Section: inner-header -->
    <section class="inner-header divider parallax layer-overlay overlay-dark-5" data-bg-img="/resources/images/event.jpg">
        <div class="container pt-70 pb-20">
            <!-- Section Content -->
            <div class="section-content">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="title text-white">이벤트 게시판</h2>
					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="container">
        <div class="row">
            <!-- 		<div class="col-md-12 mt-5"> -->
            <!-- 			<a href="#" class="btn btn-default" style="float: right">등록</a> -->
            <!-- 		</div> -->
        </div>
        <div class="col-sm-9 blog-pull-right">
            <div class="row">
                <div class="col-md-12 mt-10">
                    <h4 class="line-bottom mt-20 mb-20 text-theme-colored">이벤트 게시판</h4>
                    <hr>
                    <div data-example-id="striped-table" class="bs-example">
                        <table class="table table-striped">
                            <tr>
                                <th>No.</th>
                                <th class="board-title-middle">제목</th>
                                <th>글쓴이</th>
                                <th class="hidden-xs">날짜</th>
                                <th>
	                                <span class="visible-xs"><i class="fa fa-eye"></i></span>
	                                <span class="hidden-xs">조회수</span>
                                </th>
                            </tr>

                            <c:forEach items="${list}" var="eventBoardVO" varStatus="status">

                                <tr>
                                    <td style="text-align: center;">${(pageMaker.totalCount - status.index) - (pageMaker.cri.page-1)
                                        * pageMaker.listCount(pageMaker.cri.page)}
                                    </td>
                                    <td style="text-align: center;"><a href='read${pageMaker.makeSearch(pageMaker.cri.page) }&num=${eventBoardVO.num}'>
                                            ${eventBoardVO.title} </a></td>
                                    <td style="text-align: center;">${eventBoardVO.adminId}</td>
                                    <td  class="hidden-xs" style="text-align: center;">
                                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${eventBoardVO.regdate}"
                                        />
                                    </td>
                                    <td style="text-align: center;">${eventBoardVO.viewcnt}</td>
                                </tr>

                            </c:forEach>
                        </table>
                    </div>

                </div>

            </div>
            <div class="col-md-12">
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
                </section>

                <section>
                    <div class="Searchcontainer">
                        <div class="row">
                            <div class="box-keyword">
                                <div class="row">
                                    <form name="form">
                                        <div class="col-md-2 mb-30">
                                            <select class="form-control" onchange="if(this.value) location.href=(this.value);">
                                                <option value="/eventBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">정렬
                                                    기준
                                                </option>
                                                <option <c:out value="${cri.listType eq 'dd'?'selected':''}" /> value="/eventBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=dd">최신순
                                                </option>
                                                <option <c:out value="${cri.listType eq 'da'?'selected':''}" /> value="/eventBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=da">오래된순
                                                </option>
                                                <option <c:out value="${cri.listType eq 'vc'?'selected':''}" /> value="/eventBoard/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=vc">조회순
                                                </option>
                                            </select>
                                            <input type="hidden" id="listType" value="${cri.listType}">
                                        </div>
                                        <div class="col-md-2">
                                            <select name="searchType" id="searchType" class="form-control">
                                                <option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}" />>
                                                제목
                                                </option>
                                                <option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}" />>
                                                내용
                                                </option>
                                                <option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}" />>
                                                제목 or 내용
                                                </option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" type="text" name='keyword' id="keywordInput" value='${cri.keyword}' placeholder="키워드를 입력하세요">
                                        </div>
                                        <div class="col-md-2 mt-5 pull-right">
                                            <div class="btn-group-custom">
                                                <button id='searchBtn' type="submit" class="btn btn-default">
                                               	 <i class="fa fa-search"></i>
                                                 검색
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
            </div>
        </div>
        </section>
        
	<div class="col-md-2 mt-30 hidden-xs hidden-sm">
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

</div>
<!-- end main-content -->
<script>
    $(document)
        .ready(

            function () {
                $('#searchBtn')
                    .on(
                        "click",
                        function () {
                            if (document.getElementById("searchType").value == "n") {
                                alert("검색항목을 선택해주세요")
                                //document.searchType.option.focus();
                                return false;

                            } else if (document
                                .getElementById("keywordInput").value == "") {
                                alert("검색단어를 입력해주세요");
                                return false;

                            } else

                                self.location = "list"
                                    + '${pageMaker.makeQuery(1)}'
                                    + "&searchType=" + $("#searchType option:selected").val()
                                    + "&keyword=" + $('#keywordInput').val()
                                    + "&listType=" + $("#listType").val();

                        });
            });
</script>

<%@ include file="../include/footer.jsp"%>