
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<link rel="stylesheet"
   href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
   integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
   crossorigin="anonymous">
   
<%@include file="../include/header.jsp"%>
<style>
.panel-group .panel-title a::after {
	right: 0;
	left: auto;
}

.panel-group .panel-title a {
	padding: 10px 48px 10px 15px;
}

.table-no-margin {
	margin: 0;
}

.notice-table.table>tbody>tr>td, .notice-table.table>tbody>tr>th,
	.notice-table.table>tfoot>tr>td, .notice-table.table>tfoot>tr>th,
	.notice-table.table>thead>tr>td, .notice-table.table>thead>tr>th {
	margin: 0;
	padding: 0;
	border: none;
	text-align: center;
}

.notice-panel-header {
	padding-left: 15px;
}

.panel-heading{
	color: #333;
	background-color: #f5f5f5;
	border-color: #ddd;
}

.table-striped > tbody > tr:nth-of-type(odd) {
  background-color: transparent;
}

.notice-head-table{
	margin-bottom: 10px;
    padding-left: 15px;
    padding-right: 48px;
}

strong {
	 color:inherit;
}

/* 첨부파일 화면 출력 */

.mailbox-attachments {
	list-style: none;
	margin: 0;
	padding: 0
}

.mailbox-attachments li {
	float: left;
	width: 200px;
	border: 1px solid #eee;
	margin-bottom: 10px;
	margin-right: 10px
}

.mailbox-attachment-name {
	font-weight: bold;
	color: #666
}

.mailbox-attachment-icon, .mailbox-attachment-info,
	.mailbox-attachment-size {
	display: block
}

.mailbox-attachment-info {
	padding: 10px;
	background: #f4f4f4
}

.mailbox-attachment-size {
	color: #999;
	font-size: 12px
}

.mailbox-attachment-icon {
	text-align: center;
	font-size: 65px;
	color: #666;
	padding: 20px 10px
}

.mailbox-attachment-icon.has-img {
	padding: 0
}

.mailbox-attachment-icon.has-img>img {
	max-width: 100%;
	height: auto;
}
.content-box{
	overflow:auto;
	min-height:200px;
	max-height:500px;
	text-align:left;
}
</style>
<!-- Start main-content -->
<div class="main-content">
	<!-- Section: inner-header -->
	<section
		class="inner-header divider parallax layer-overlay overlay-dark-5"
		data-bg-img="/resources/images/notice.jpg">
		<div class="container pt-70 pb-20">
			<!-- Section Content -->
			<div class="section-content">
				<div class="row">
					<div class="col-md-12">
						<h2 class="title text-white">공지사항</h2>
   					<ol class="breadcrumb text-left text-white">
						<li><a href="/">&nbsp;</a></li>
					</ol>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Section: Notice list -->
	<section>
		<div class="container">
			<div class="col-md-9 blog-pull-right">
				<div class="row">
					<div class="col-md-12 mt-10">
						<h4 class="line-bottom mt-20 mb-20 text-theme-colored">공지사항</h4>
						<hr>
						<div id="accordion1" class="panel-group accordion">
							<!-- 공지사항 출력 -->
							<div data-example-id="striped-table" class="bs-example notice-head-table">
								<table class="table table-striped notice-table table-no-margin">
									<thead>
										<tr>
											<th class="col-sm-1">번호</th>
											<th class="col-sm-6">제목</th>
											<th class="col-sm-2">글쓴이</th>
											<th class="col-sm-2"><span><i class="fas fa-clock" title="등록일"></i></span>등록일</th>
										</tr>
									</thead>
								</table>
							</div>
							<c:forEach items="${topList}" var="noticeVO" varStatus="status">
								<div class="panel panel-primary">
									<div class="panel-title">
										<a data-parent="#accordion${status.count}" id="boardNum${status.count}"
											data-toggle="collapse" href="#accordion${status.count + 10}"
											class="<c:choose>
											<c:when test="${cri.listType eq null}">
											<c:out value="${status.count eq 1?'active':'collapsed'}"/>
 									 		  </c:when>
 									 		  <c:otherwise>
 									 			<c:out value="collapsed"/>
 									 		  </c:otherwise>
   										 </c:choose>"
   										 
											aria-expanded="<c:choose>
											<c:when test="${cri.listType eq null}">
											<c:out value="${status.count eq 1?'true':'false'}"/>
 									 		  </c:when>
 									 		  <c:otherwise>
 									 			<c:out value="false"/>
 									 		  </c:otherwise>
   										 </c:choose>" style="background:lightblue">
											<input type="hidden" name="noNum" value="${noticeVO.noNum}">
											<span class="open-sub"></span> <strong>
												<table
													class="table table-striped notice-table table-no-margin">
													<tbody>
														<c:if test="${noticeVO.noKeyword eq 1 }">
															<tr>
																<td class="col-sm-1"><c:if
																		test="${noticeVO.noKeyword eq 1 }">필독</c:if></td>
																<td class="col-sm-6">${noticeVO.noTitle}</td>
																<td class="col-sm-2">${noticeVO.adminId}</td>
																<td class="col-sm-2"><fmt:formatDate
																		pattern="yyyy-MM-dd HH:mm"
																		value="${noticeVO.noRegDate}" /></td>
															</tr>
														</c:if>
													</tbody>
												</table>
										</strong>
										</a>
									</div>
									<div id="accordion${status.count + 10}"
									
										class="<c:choose>
											<c:when test="${cri.listType eq null}">
											<c:out value="${status.count eq 1?'panel-collapse collapse in':'panel-collapse collapse'}"/>
 									 		  </c:when>
 									 		  <c:otherwise>
 									 			<c:out value="panel-collapse collapse"/>
 									 		  </c:otherwise>
   										 </c:choose>"
										role="tablist"
   										 
										aria-expanded="<c:choose>
											<c:when test="${cri.listType eq null}">
											<c:out value="${status.count eq 1?'true':'false'}"/>
 									 		  </c:when>
 									 		  <c:otherwise>
 									 			<c:out value="false"/>
 									 		  </c:otherwise>
   										 </c:choose>">
										<div class="panel-content">
										 <%-- 첨부파일 --%>
											<div class="blog-pull-right"> <dt><ul class="attachFiles"></ul></dt></div>
											
											<%-- 내용 --%>
												<div class="panel-body content-box">
													${noticeVO.noText}</div>
										<%-- 링크 --%>
												<div class="panel-heading">링크</div>
												<div class="panel-body">
													<div class="imgAttachment">
														<ul class="mailbox-attachments clearfix showImgUploadedList"></ul>
													</div>
												</div>
											<%--	<div class="panel-heading">첨부파일</div>
												<div class="panel-body">
													<div class="nomalAttachment">
														<ul class="mailbox-attachments clearfix showUploadedList"></ul>
													</div>
												</div>--%>
										</div>
									</div>
								</div>
							</c:forEach>

							<c:forEach items="${list}" var="noticeVO" varStatus="status">
								<div class="panel">
									<div class="panel-title">
										<a data-parent="#accordion${status.count + 3}" id="boardNum${status.count + 3}"
											data-toggle="collapse"
											href="#accordion${status.count + 3 + 10}" class="collapsed"
											aria-expanded="false"> <input type="hidden" name="noNum"
											value="${noticeVO.noNum}"> <span class="open-sub"></span>
											<strong>
												<table class="table table-striped notice-table table-no-margin">
													<c:if test="${noticeVO.noKeyword eq 1 }">
														<tr>
															<td class="col-sm-1"><c:if
																	test="${noticeVO.noKeyword eq 1 }">필독</c:if></td>
															<td class="col-sm-6">${noticeVO.noTitle}</td>
															<td class="col-sm-2">${noticeVO.adminId}</td>
															<td class="col-sm-2"><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm"
																	value="${noticeVO.noRegDate}" /></td>
														</tr>
													</c:if>
													<c:if test="${noticeVO.noKeyword eq 2 }">
														<tr>
															<td class="col-sm-1"><c:if
																	test="${noticeVO.noKeyword eq 2 }">공지</c:if></td>
															<td class="col-sm-6">${noticeVO.noTitle}</td>
															<td class="col-sm-2">${noticeVO.adminId}</td>
															<td class="col-sm-2"><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm"
																	value="${noticeVO.noRegDate}" /></td>
														</tr>
													</c:if>
													<c:if test="${noticeVO.noKeyword eq 3 }">
														<tr>
															<td class="col-sm-1"><c:if
																	test="${noticeVO.noKeyword eq 3 }">${(pageMaker.totalCount - status.index) - (pageMaker.cri.page-1) * pageMaker.listCount(pageMaker.cri.page)}</c:if>
															</td>
															<td class="col-sm-6">${noticeVO.noTitle}</td>
															<td class="col-sm-2">${noticeVO.adminId}</td>
															<td class="col-sm-2"><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm"
																	value="${noticeVO.noRegDate}" /></td>
														</tr>
													</c:if>
												</table>
										</strong>
										</a>
									</div>
									<div id="accordion${status.count + 3 + 10}"
										class="panel-collapse collapse" role="tablist"
										aria-expanded="false">
										<div class="panel-content">

												<div class="blog-pull-right"> <dt><ul class="attachFiles"></ul></dt></div>
												<div class="panel-body content-box">
													${noticeVO.noText}</div>
												<div class="panel-heading">링크</div>
												<div class="panel-body">
													<div class="imgAttachment">
														<ul class="mailbox-attachments clearfix showImgUploadedList"></ul>
													</div>
												</div>
												<%-- <div class="panel-heading">첨부파일</div>
												<div class="panel-body">
													<div class="nomalAttachment">
														<ul class="mailbox-attachments clearfix showUploadedList"></ul>
													</div>
												</div> --%>

										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>

				</div>
				<!-- Notice list end -->

				<!-- 페이징 -->
<%-- 				<div class="row">
					<div class="box-footer">

						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
						<!-- .text-center END -->
					</div>
				</div> --%>
				
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

				<div class="row">
					<div class="col-sm-5">
						<div class="col-sm-5">
							<select class="form-control" name="listType" id="listType">
								<option value="0"
									<c:out value="${cri.listType eq null?'selected':''}"/>>글머리</option>
								<option value="1"
									<c:out value="${cri.listType eq '1'?'selected':''}"/>>필독</option>
								<option value="2"
									<c:out value="${cri.listType eq '2'?'selected':''}"/>>공지</option>
								<option value="3"
									<c:out value="${cri.listType eq '3'?'selected':''}"/>>일반</option>
							</select>
						</div>
						<div class="col-sm-6">
							<select class="form-control" name="searchType" id="searchType">
								<option value="n"
									<c:out value="${cri.searchType eq null?'selected':''}"/>>검색방법</option>
								<option value="t"
									<c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
								<option value="x"
									<c:out value="${cri.searchType eq 'x'?'selected':''}"/>>내용</option>
								<option value="a"
									<c:out value="${cri.searchType eq 'a'?'selected':''}"/>>글쓴이</option>
								<option value="tx"
									<c:out value="${cri.searchType eq 'tx'?'selected':''}"/>>제목
									OR 내용</option>
							</select>
						</div>
					</div>

					<!-- 검색 기능 -->
					<div class="col-sm-7">
						<div class="col-sm-9">
							<input type="text" name='keyword' id="keywordInput"
								value='${cri.keyword }' class="form-control"
								placeholder="키워드를 입력하세요">
						</div>
						<div class="col-sm-2 mt-5">
							<div class="btn-group-custom">
								<button type="submit" class="btn btn-default" id="searchBtn">
									<i class="fa fa-search"></i> 검색
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- /. side Menu -->
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
	<!-- /.main-content -->
</div>
<script type="text/javascript" src="/resources/admin/validity/notice.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/admin/validity/upload.js"></script>

<!-- 업로드된 일반 첨부파일 출력 -->
<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src="{{fullName}}">
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
			<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			</div>
	</li>
</script>

<!-- 업로드된 링크용 이미지 출력 -->
<script id="imgUploadedAttachment" type="text/x-handlebars-template">
	<li data-src="{{fullName}}"><a href="{{imgUri}}" target="_blank">
		<span class="mailbox-attachment-icon has-img" href="{{fullName}}"><img src="{{imgsrc}}" alt="Attachment"></span>
		<div class="mailbox-attachment-info"><input type="hidden" name="imgFileName" value="{{fullName}}">
		</div>
		<a>
	</li>
</script>

<!-- 첨부파일 다운로드용 템플릿 -->
<script id="attachFiles" type="text/x-handlebars-template">
<li data-src="{{fullName}}"><i class="fas fa-download" title="첨부"></i>
	<a href="{{getLink}}">{{fileName}}<span class="bubble"></span></a>
</li>
</script>



<script>
$(document).ready(function() {
$("#listType").on("change", function(evnet){
	location.href="/notice/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}&listType="+this.value;
});

$('#searchBtn').on(
		"click",
		function(event) {
			
			if (document.getElementById("keywordInput").value != "" && document.getElementById("searchType").value == "n") {
				alert("검색항목을 선택해주세요")
				//document.searchType.option.focus();
				return false;

			} else if (document.getElementById("searchType").value != "n" && document.getElementById("keywordInput").value == "") {
				alert("검색단어를 입력해주세요");
				return false;

			} else {
				self.location = "list"
						+ '${pageMaker.makeQuery(1)}'
						+ "&searchType="
						+ $("#searchType option:selected").val()
						+ "&keyword="
						+ $('#keywordInput').val()
						+ "&listType="
						+ $("#listType").val();
			}
		});
});
	//업로드된 일반 첨부파일을 출력할 템플릿
// 	var Attachtemplate = Handlebars.compile($("#templateAttach").html());
	
	// 업로드된 링크용 이미지파일을 출력할 템플릿
	var imgUploadedAttachment = Handlebars.compile($("#imgUploadedAttachment").html());
	
	// 첨부파일 다운로드 템플릿
	var attachFiles = Handlebars.compile($("#attachFiles").html());
	
	var nolist = new Array();

	<c:forEach items="${list}" var="noticeVO">
	nolist.push("${noticeVO.noNum}");
	</c:forEach>
	
	// 나머지 게시물의 파일 경로를 불러와 화면에 출력
	$(document).ready(function() {
		$.each(nolist, function(idx, num) {
			var noNum = num;
			
			$.getJSON("/notice/getAttach/" + noNum, function(result) {
				$(result).each(function() {
					var fileInfo = getUserFileAndLinkInfo(this);
					
					var accordion = "accordion" + (11 + 3 + idx);
					
					if(fileInfo.imgUri == "" || fileInfo.imgUri == null){
							var html = attachFiles(fileInfo);
							$('#' + accordion).find(".attachFiles").append(html);
						} else {
							var html = imgUploadedAttachment(fileInfo);
							$('#' + accordion).find(".showImgUploadedList").append(html);
						}
/* 					if(fileInfo.imgUri == "" || fileInfo.imgUri == null){
						if(checkImageType(this)){
							var html = Attachtemplate(fileInfo);
							$('#' + accordion).find(".showUploadedList").append(html);
						} else {
							var html2 = attachFiles(fileInfo);
							$('#' + accordion).find(".attachFiles").append(html2);
						}
						} else {
							var html = imgUploadedAttachment(fileInfo);
							$('#' + accordion).find(".showImgUploadedList").append(html);
						} */

				});
			});
		});
	});

	var noTopList = new Array();

	<c:forEach items="${topList}" var="noticeVO">
	noTopList.push("${noticeVO.noNum}");
	</c:forEach>
	
	// 필독(상위3개) 게시물의 파일 경로를 불러와 화면에 출력
	$(document).ready(function() {
		$.each(noTopList, function(idx, num) {
			var noNum = num;
			$.getJSON("/notice/getAttach/" + noNum, function(result) {
				$(result).each(function() {
					var fileInfo = getUserFileAndLinkInfo(this);
					
					var accordion = "accordion" + (11 + idx);
					
					if(fileInfo.imgUri == "" || fileInfo.imgUri == null){
							var html = attachFiles(fileInfo);
							$('#' + accordion).find(".attachFiles").append(html);
						} else {
							var html = imgUploadedAttachment(fileInfo);
							$('#' + accordion).find(".showImgUploadedList").append(html);
						}
/* 					if(fileInfo.imgUri == "" || fileInfo.imgUri == null){
						if(checkImageType(this)){
							var html = Attachtemplate(fileInfo);
							$('#' + accordion).find(".showUploadedList").append(html);
						} else{
							var html2 = attachFiles(fileInfo);
							$('#' + accordion).find(".attachFiles").append(html2);
						}
						} else {
							var html = imgUploadedAttachment(fileInfo);
							$('#' + accordion).find(".showImgUploadedList").append(html);
						} */
				});
			});
		});
	});
	
	$(".panel-title > a").on("click", function(event){
	       var boardNum = $(this).attr("id");
	       var isExpanded = $("#"+boardNum).attr("aria-expanded");
	         isExpanded = $.trim(isExpanded);
	         
	         if(isExpanded == 'false'){
	         var noNum=$("#"+boardNum+"> input[name=noNum]").attr("value");
	         $.ajax({
	            url : "/notice/read",
	            type : "post",
	            data : {noNum:noNum},
	            dataType : "text",
	            success : function(result) {
	            },
	            error: function (jqXHR, textStatus, errorThrown) {
	                  alert("오류가 발생하였습니다.");
	                 }  
	         });
	         }
	   });

</script>
<%@include file="../include/footer.jsp"%>