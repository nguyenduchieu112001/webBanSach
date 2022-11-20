<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-color: #f5f5f5;
}
.wrapper {
	display: flex;
	align-items: stretch;
	padding-top: 100px;
}

.navbar {
	position: fixed;
	right: 0;
	left: 0;
	z-index: 1000;
}

.sach-img {
	width: 100%;
	height: 270px;
	border-radius: 12px;
}

img {
	object-fit: cover;
}

.buy-sach {
	
}

.sach-tacgia, .sach-gia {
	font-size: 18px;
}

.sach-name {
	text-align: center;
	margin: 10px 0;
}

.container {
	width: 1440px;
	margin-bottom: 80px;
}

.wrapper-mh {
	flex: 0 0 20%;body
	max-width: 20%;
	padding-right: 25px;
}

.tim-kiem {
	display: flex;
	flex: 0 0 20%;
}

.MenuTrang li {
	display: inline;
}

a.active {
	color: green;
	font-weight: bold;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.card-img {
	height: 240px;
	width: 100%;
}

.box-card {
	margin: 20px;
}

.card-body {
	text-align: center;
	height: 134px;
}

h4 {
	padding: 6px 0;
	height: 40%;
	width: 240px;
	font-weight: 600;
}

.book-container {
	display: flex;
	/*  justify-content: space-around; */
	flex-wrap: wrap;
}

.card {
	/* border: 2px solid rgb(234, 233, 233);
	border-radius: 8px; */
	height: 380px;
	width: 240px;
	overflow: hidden;
	background-color: #fff;
	transition: .35s;
	box-shadow: 1px 1px #e7e7e7;
}
.card:hover {
	/* margin-top: -8px; */
	box-shadow: 0 0 0 1px #55ad39;
	transform: scale(1.1);
}
.btns {
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 64px;
}

.btn-book{
	height: 40px;
	width: 100px;
	padding: 10px 0px;
	border-radius: 8px;
	color: #fff;
}
.buy-btn:hover {
	text-decoration: none;
	color: #fff;
	opacity:0.8;
}

.buy-btn:active {
	text-decoration: none;
	color: #fff;
	opacity:0.6;
}

.buy-btn {
	display:inline-block;
	border-radius:8px;
	text-decoration: none;
	color: #fff;
	height: 40px;
	width: 100px;
	padding: 10px 0px;
	color: #fff;
}

.book-gia {
	background-color: rgb(200, 53, 48);
	cursor: default;
}

.book-mua {
	background-color: rgb(18, 112, 43);
	
	border-radius: 8px;
}

.pagination-container {
	position: fixed;
	bottom: 0;
	right: 0;
	left: 0;
	border-top: 1px solid #e7e7e7;
	background-color: #fff;
	z-index: 30;
}
.pagination {
	display: flex;
	justify-content: center;
}
.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="ChuDeSach">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="GioHang">Giỏ hàng</a></li>
				<li><a href="#">Thanh toán</a></li>
				<li><a href="LichSu?mkh=${makh }">Lịch sử mua hàng</a></li>
			</ul>
			<div class="nav navbar-nav">
				<form class="navbar-form navbar-left" action="ChuDeSach">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="timkiem">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<c:if test="${DangNhap==null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="login"><span
							class="fa-sharp fa-solid fa-arrow-right-to-bracket"></span> Login</a></li>
							
				</ul>
			</c:if> 
			<c:if test="${DangNhap != null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout"><span
							class="fa-sharp fa-solid fa-arrow-right-from-bracket"></span> Log Out</a></li>
					<li><a><span>Xin chào, <c:out value="${DangNhap}" />!
						</span></a></li>
				</ul>
			</c:if>
		</div>
	</nav>
	<div class="container">
		<div class="wrapper">

			<div class="wrapper-mh">
				<p class="lead">CHỦ ĐỀ SÁCH</p>
				<div class="list-group">
					<c:forEach items="${loai }" var="l">
						<a class="list-group-item" href="ChuDeSach?ml=${l.getMaloai() }">
							${l.getTenloai() }</a>
					</c:forEach>
				</div>
			</div>


			<div class="book-container">
				<c:forEach items="${dsSach }" var="s">
					<div class="box-card" <%-- onclick="location.href='GioHang?act=add&ms=${s.getMasach()}&ts=${s.getTensach()}&gia=${s.getGia()}&anh=${s.getAnh()}&makh=${makh}'" --%>>
						<div class="card">
							<img src="${s.getAnh() }" alt="avatar" class="card-img" />

							<div class="card-body">
								<h4 class="">${s.getTensach() }</h4>
								<div class="btns">
									<span class="book-gia btn-book">${s.getGia() } VNĐ</span>
									<div class="book-mua">
										<a class="buy-btn" style="cursor: pointer;"
											href="GioHang?act=add&ms=${s.getMasach()}&ts=${s.getTensach()}&gia=${s.getGia()}&anh=${s.getAnh()}&makh=${makh}">
											Mua hàng </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<div class="pagination-container">
		<ul class="pagination">
			<c:if test="${tag>1 }">
				<li><a href="ChuDeSach?page=${tag-1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="1" end="${endPage }" var="i">
				<li><a class="${tag==i?'active':''}"
					href="ChuDeSach?page=${i }">${i }</a></li>
			</c:forEach>
			<c:if test="${tag < endPage }">
				<li><a href="ChuDeSach?page=${tag+1 }">Next</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>