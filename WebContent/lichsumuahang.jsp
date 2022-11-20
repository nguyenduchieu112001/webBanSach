<%@page import="bean.chitiethoadonbean"%>
<%@page import="bo.lichsubo"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Lịch sử mua hàng</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.book {
	display: inherit;
	background-color: #cbcbcb;
	border-radius: 20px;
	padding: 20px;
	cursor: pointer;
}

.book-img {
	width: 234px;
	height: 264px;
	border-radius: 10px;
}

.list-items {
	display: block;
	width: 100%;
	height: 40px;
	padding: 8px 10px;
	border: 1px solid #ccc;
	color: #000;
}

.list-items:hover {
	text-decoration: none;
	background-color: #d3d3d3;
	color: #000;
	font-weight: 600;
}
/* 
.payment {
	width: 100%;
	height: 70px;
	display: flex;
	justify-content: space-evenly;
	position: fixed;
	bottom: 0;
	right: 0;
	left: 0;
	border-top: 1px solid #ccc;
	background-color: #fff;
	z-index: 30;
}
 */
th, tr {
	text-align: center;
}

.text-right {
	width: 30%;
}

.ctn-history {
	width: 80%;
	margin: 0 10%;
}
</style>
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
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</c:if>
			<c:if test="${DangNhap != null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout"><span
							class="glyphicon glyphicon-user"></span> Log Out</a></li>
					<li><a><span>Xin chào, <c:out value="${DangNhap}" />!
						</span></a></li>
				</ul>
			</c:if>
		</div>
	</nav>

	<div class="ctn-history">
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="width: 4%">STT</th>
					<th style="width: 12%">Sản phẩm</th>
					<th style="width: 30%">Tên sách</th>
					<th style="width: 12%">Đơn giá</th>
					<th style="width: 12%">Số lượng</th>
					<th style="width: 12%">Số tiền</th>
					<th style="width: 12%">Ngày mua</th>
					<th style="width: 6%">Đã mua</th>
				</tr>
			</thead>

			<tbody>
				<c:set value="0" var="i" />
				<c:if test="${not empty ls }">
					<c:forEach var="h" items="${ls }">
						<tr>
							<c:set value="${i+1 }" var="i" />
							<td data-th="STT">
								<h4 style="margin: 30px 0 0 10px">
									<c:out value="${i }" />
								</h4>
							</td>
							<td data-th="Sản phẩm">
								<div class="row">
									<img src="${h.getAnh() }" alt=""
										class="img-fluid  d-md-block rounded mb-2 shadow "
										style="width: 90px; margin-left: 12px">
								</div>
							</td>
							<td data-th="Tên sách">
								<h4 style="margin-top: 30px">${h.getTensach() }</h4>
							</td>
							<td data-th="Đơn giá">
								<h4 style="margin-top: 30px">${h.getGia() }VNĐ</h4>
							</td>

							<td data-th="Số lượng"><h4 style="margin: 30px 0 0 20px">${h.getSoluong() }</h4></td>
							<td data-th="Số tiền">
								<h4 style="margin-top: 30px; color: #ee4d2d;">${h.getGia() * h.getSoluong() }
									VNĐ</h4>
							</td>
							<td data-th="Ngày mua">
								<h4 style="margin-top: 30px;">
									<c:out value="${h.getNgaymua() }"></c:out>
								</h4>
							</td>
							<td data-th="Đã mua">
							<c:if test="${h.isDamua() == false}">
								<h4 style="margin-top: 30px">Chưa thanh toán</h4>
							</c:if>
							<c:if test="${h.isDamua() != false}">
								<h4 style="margin-top: 30px">Đã thanh toán</h4>
							</c:if>
							</td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>