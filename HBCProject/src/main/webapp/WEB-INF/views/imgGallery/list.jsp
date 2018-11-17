<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Start main-content -->
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

    <!-- Section: Event List -->
    <section>
        <div class="container">
            <div class="row">

                <div class="col-md-9 blog-pull-right">
                    <h3 class="widget-title line-bottom">이미지</h3>
                    <c:forEach items="${list}" var="galleryBoardVO" varStatus="status">

                        <div class="upcoming-events bg-white-f3 mb-20">
                            <div class="row">
                                <div class="col-sm-4 pr-0 pr-sm-15">
                                    <div class="thumb p-15">
                                        <!-- 대표 이미지가 들어가는 공간  -->
                                        <img alt="" src="displayFile?fileName=${galleryBoardVO.name}">
                                    </div>
                                </div>
                                <div class="col-sm-8 pl-0 pl-sm-15">
                                    <div class="event-details p-15 mt-20">
                                        <h4 class="media-heading text-uppercase font-weight-500">${galleryBoardVO.title}</h4>
                                        <ul>
                                            <li>
                                                게시일:
                                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${galleryBoardVO.regdate}"
                                                /> &nbsp;&nbsp;&nbsp; 조회수: ${galleryBoardVO.viewcnt}
                                            </li>
                                        </ul>

                                        <p class="listcontent" style="margin-right: 30%;">${galleryBoardVO.content}
                                        </p>
                                        <a href="/imgGallery/detail${pageMaker.makeSearch(pageMaker.cri.page) }&galnum=${galleryBoardVO.galnum}" class="btn btn-flat btn-dark btn-theme-colored btn-sm">
                                            글 보러가기 <i class="fa fa-angle-double-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>

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

                    <div class="box-keyword">
                        <div class="row">
                            <div class="col-md-2 col-xs-3">
                                <select name="listType" class="form-control" onchange="if(this.value) location.href=(this.value);">
                                    <option value="/imgGallery/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">정렬
                                        기준
                                    </option>
                                    <option <c:out value="${cri.listType eq 'dd'?'selected':''}" /> value="/imgGallery/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=dd">최신순
                                    </option>
                                    <option <c:out value="${cri.listType eq 'da'?'selected':''}" /> value="/imgGallery/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=da">오래된순
                                    </option>
                                    <option <c:out value="${cri.listType eq 'vc'?'selected':''}" /> value="/imgGallery/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType=vc">조회순
                                    </option>
                                </select>
                            </div>
                            <div class="col-md-2 col-xs-3">
                                <!-- <div class="col-md-2 col-xs-4" style="margin-left: 50%"> -->
                                <select name="searchType" id="searchType" class="form-control">
                                    <option value="n" <c:out value="${cri.searchType == null?'selected':''}" />> ---
                                    </option>
                                    <option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}" />> 제목
                                    </option>
                                    <option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}" />> 내용
                                    </option>
                                    <option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}" />> 작성자
                                    </option>
                                    <option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}" />> 제목 or 내용
                                    </option>
                                    <option value="cw" <c:out value="${cri.searchType eq 'cw'?'selected':''}" />> 내용 or 작성자
                                    </option>
                                    <option value="twc" <c:out value="${cri.searchType eq 'twc'?'selected':''}" />> 제목 or
                                    내용 or 작성자
                                    </option>
                                </select>
                            </div>
                            <div class="col-md-5 col-xs-4">
                                <input class="form-control" type="text" name='keyword' id="keywordInput" value='${cri.keyword}' placeholder="키워드를 입력하세요">
                            </div>
                            <div class="col-md-3 col-xs-2">
                                <div class="btn-group-custom">
                                    <button id='searchBtn' type="submit" class="btn btn-default">
                                        <i class="fa fa-search"></i> 검색
                                    </button>
                                </div>

                            </div>

                        </div>


                    </div>

                </div>
                
                <section>
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
    </section>
            </div>
            
            


            <!-- end main-content -->

            <!-- Footer -->

        </div>
        </div>
    </section>
</div>


<script>
    var result = '${msg}';

    if (result == 'SUCCESS') {
        alert("처리가 완료되었습니다.");
    }

    $(document)
        .ready(

            function () {
                $('#searchBtn')
                    .on(
                        "click",
                        function (video) {
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
                                    + "&searchType="
                                    + $("#searchType option:selected").val()
                                    + "&keyword="
                                    + $('#keywordInput').val();

                        });

                $('#newBtn')
                    .on(
                        "click",
                        function (evt) {
                            self.location = "register${pageMaker.makeSearch(pageMaker.cri.page) }";
                        });
            });
</script>
<%@ include file="../include/footer.jsp"%>