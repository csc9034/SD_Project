<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<!-- Meta Tags -->
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="StudyPress | Education & Courses HTML Template" />
<meta name="keywords"
	content="academy, course, education, education html theme, elearning, learning," />
<meta name="author" content="ThemeMascot" />

<!-- Page Title -->
<title>SD 교육 그룹 | 공부를 디자인하라</title>

<!-- Favicon and Touch Icons -->
<link href="/resources/images/favicon.png" rel="shortcut icon"
	type="image/png">
<link href="/resources/images/apple-touch-icon.png"
	rel="apple-touch-icon">
<link href="/resources/images/apple-touch-icon-72x72.png"
	rel="apple-touch-icon" sizes="72x72">
<link href="/resources/images/apple-touch-icon-114x114.png"
	rel="apple-touch-icon" sizes="114x114">
<link href="/resources/images/apple-touch-icon-144x144.png"
	rel="apple-touch-icon" sizes="144x144">

<!-- Stylesheet -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/resources/css/jquery-ui.min.css" rel="stylesheet"
	type="text/css">
<!-- CUSTOM STYLE | Created  by. KAYH -->
<link href="/resources/css/all.css?ver=1" rel="stylesheet" type="text/css">
<link href="/resources/css/custom-overall.css" rel="stylesheet" type="text/css">
	
<link href="/resources/css/animate.css" rel="stylesheet" type="text/css">
<link href="/resources/css/css-plugin-collections.css" rel="stylesheet" />
<!-- CSS | menuzord megamenu skins -->
<link id="menuzord-menu-skins"
	href="/resources/css/menuzord-skins/menuzord-strip.css?ver=1"
	rel="stylesheet" />
<!-- CSS | Main style file -->
<link href="/resources/css/style-main.css?ver=2" rel="stylesheet"
	type="text/css">
<!-- CSS | Preloader Styles -->
<link href="/resources/css/preloader.css" rel="stylesheet"
	type="text/css">
<!-- CSS | Custom Margin Padding Collection -->
<link href="/resources/css/custom-bootstrap-margin-padding.css"
	rel="stylesheet" type="text/css">
<!-- CSS | Responsive media queries -->
<link href="/resources/css/responsive.css" rel="stylesheet"
	type="text/css">
<!-- CSS | Style css. This is the file where you can place your own custom css code. Just uncomment it and use it. -->
<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> -->

<link href="/resources/css/components/dropdown.css" rel="stylesheet"
	type="text/css">

<!-- CSS | Theme Color -->
<link href="/resources/css/colors/theme-skin-color-set-1.css"
	rel="stylesheet" type="text/css">

<!-- external javascripts -->
<script src="/resources/js/jquery-2.2.4.min.js"></script>
<script src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/css/components/dropdown.js"></script>
<!-- JS | jquery plugin collection for this theme -->
<script src="/resources/js/jquery-plugin-collection.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body class="">
	<div id="wrapper" class="clearfix">
		<!-- preloader -->
		<div id="preloader">
			<div id="spinner">
				<div class="preloader-dot-loading">
					<div class="cssload-loading">
						<i></i><i></i><i></i><i></i>
					</div>
				</div>
			</div>
			<div id="disable-preloader" class="btn btn-default btn-sm">Disable
				Preloader</div>
		</div>

		<!-- Header -->
		<header id="header" class="header">
		<div class="header-top bg-theme-color-1 sm-text-center p-0">
			<div class="container">
				<div class="row">
					<!-- <div class="col-md-4">
						<div class="widget no-border m-0">
							<ul class="list-inline font-13 sm-text-center mt-5">
								<li>
									<a class="text-white" href="#"> <a href="#">FAQ</a>
								</li>
								<li>|</li>
								<li><a href="#">Help Desk</a></li>
								<li>|</li>
								<li><a href="#">Login</a></li>
							</ul>
						</div>
					</div> -->
					<!-- <div class="col-md-8">
            <div class="widget m-0 pull-right sm-pull-none sm-text-center">
              <ul class="list-inline pull-right">
                <li class="mb-0 pb-0">
                  <div class="top-dropdown-outer pt-5 pb-10">
                    <a class="top-cart-link has-dropdown text-white text-hover-theme-colored"><i class="fa fa-shopping-cart font-13"></i> (12)</a>
                    <ul class="dropdown">
                      <li>
                        dropdown cart
                        <div class="dropdown-cart">
                          <table class="table cart-table-list table-responsive">
                            <tbody>
                              <tr>
                                <td><a href="#"><img alt="" src="http://placehold.it/85x85"></a></td>
                                <td><a href="#"> Product Title</a></td>
                                <td>X3</td>
                                <td>$ 100.00</td>
                                <td><a class="close" href="#"><i class="fa fa-close font-13"></i></a></td>
                              </tr>
                              <tr>
                                <td><a href="#"><img alt="" src="http://placehold.it/85x85"></a></td>
                                <td><a href="#"> Product Title</a></td>
                                <td>X2</td>
                                <td>$ 70.00</td>
                                <td><a class="close" href="#"><i class="fa fa-close font-13"></i></a></td>
                              </tr>
                            </tbody>
                          </table>
                          <div class="total-cart text-right">
                            <table class="table table-responsive">
                              <tbody>
                                <tr>
                                  <td>Cart Subtotal</td>
                                  <td>$170.00</td>
                                </tr>
                                <tr>
                                  <td>Shipping and Handling</td>
                                  <td>$20.00</td>
                                </tr>
                                <tr>
                                  <td>Order Total</td>
                                  <td>$190.00</td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                          <div class="cart-btn text-right">
                              <a class="btn btn-theme-colored btn-xs" href="shop-cart.html"> View cart</a>
                              <a class="btn btn-dark btn-xs" href="shop-checkout.html"> Checkout</a>
                          </div>
                        </div>
                        dropdown cart ends
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="mb-0 pb-0">
                  <div class="top-dropdown-outer pt-5 pb-10">
                    <a class="top-search-box has-dropdown text-white text-hover-theme-colored"><i class="fa fa-search font-13"></i> &nbsp;</a>
                    <ul class="dropdown">
                      <li>
                        <div class="search-form-wrapper">
                          <form method="get" class="mt-10">
                            <input type="text" onfocus="if(this.value =='Enter your search') { this.value = ''; }" onblur="if(this.value == '') { this.value ='Enter your search'; }" value="Enter your search" id="searchinput" name="s" class="">
                            <label><input type="submit" name="submit" value=""></label>
                          </form>
                        </div>
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
            <div class="widget no-border m-0 mr-15 pull-right flip sm-pull-none sm-text-center">
              <ul class="styled-icons icon-circled icon-sm pull-right flip sm-pull-none sm-text-center mt-sm-15">
                <li><a href="#"><i class="fa fa-facebook text-white"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter text-white"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus text-white"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram text-white"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin text-white"></i></a></li>
              </ul>
            </div>
          </div> -->
				</div>
			</div>
		</div>
		<div class="header-nav">
			<div class="header-nav-wrapper navbar-scrolltofixed bg-lightest">
				<div class="container">
					<nav id="menuzord-right" class="menuzord red"> <a
						class="menuzord-brand pull-left flip mt-5 mb-5" href="/"> <img
						src="/resources/images/logo1.png" alt="">
					</a>
					<ul class="menuzord-menu dark">
						<li><a href="/edugroup/intro">SD교육그룹</a>
							<ul class="dropdown">
								<li><a href="/edugroup/intro">SD교육그룹 소개</a></li>
								<li><a href="/edugroup/value">핵심가치</a></li>
								<li><a href="/edugroup/history">연혁</a></li>
								<li><a href="/edugroup/people">사람들</a></li>
							</ul></li>

						<li><a href="/company/introGroup">기관 소개 </a>
							<ul class="dropdown">
								<li><a href="/company/introGroup?division=1">연구소</a></li>
								<li><a href="/company/introGroup?division=2">교육센터</a></li>
							</ul></li>
						<li><a href="/program/list?compnums=1&categorize=1">교육/컨설팅</a>
							<ul class="dropdown">
								<li><a href="/program/list?compnums=1&categorize=1">프로그램 소개</a></li>
							</ul></li>
						<li><a href="/apply/list?page=1&perPageNum=10">수강신청 </a>
							<ul class="dropdown">
								<li><a href="/apply/list?page=1&perPageNum=10&compnum=2">SD교육센터</a></li>
								<li><a href="/apply/list?page=1&perPageNum=10&compnum=3">SD연구소</a></li>
							</ul></li>

						<li><a href="/notice/list">커뮤니티</a>
							<ul class="dropdown">
								<li><a href="/notice/list">공지사항</a></li>
								<li><a href="/imgGallery/list">SD갤러리</a></li>
								<li><a href="/eventBoard/list">이벤트</a></li>
							</ul></li>

						<li><a href="/news/list">PR</a>
							<ul class="dropdown">
								<li><a href="/news/list">보도자료</a></li>
								<li><a href="/review/list">수강후기</a></li>
							</ul></li>
					</ul>
					</nav>
				</div>
			</div>
		</div>
		</header>