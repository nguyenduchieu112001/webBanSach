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
<title>Quản lý sách</title>
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

.pagination-container {
	/* position: fixed; */
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
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Admin">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="LoaiSach">Loại</a></li>
				<li><a href="Sach">Sách</a></li>
				<li><a href="XacNhan">Xác nhận hóa đơn</a></li>
				<li><a href="DonDuyet">Đơn đã duyệt</a></li>
			</ul>
			<div class="nav navbar-nav">
				<form class="navbar-form navbar-left" action="Sach">
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
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><span
						class="fa-sharp fa-solid fa-arrow-right-from-bracket"></span> Log
						Out</a></li>
				<li><a><span>Xin chào, <c:out value="${ad}" />!
					</span></a></li>
			</ul>

		</div>
	</nav>

	<div class="ctn-history">
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="width: 4%">Mã sách</th>
					<th style="width: 12%">Sản phẩm</th>
					<th style="width: 25%">Tên sách</th>
					<th style="width: 6%">Số tập</th>
					<th style="width: 15%">Tác giả</th>
					<th style="width: 12%">Đơn giá</th>
					<th style="width: 6%">Số lượng</th>
					<th style="width: 12%">Ngày nhập</th>
					<th style="width: 8%">Thao tác</th>
					<th style="width: 10%">
						<button data-toggle="modal" data-target="#addSach">Thêm</button>
					</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${not empty l }">
					<c:forEach var="h" items="${l }">
						<tr>
							<td data-th="Mã sách">
								<h4 style="margin: 30px 0 0 10px">
									<c:out value="${h.getMasach() }" />
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
							<td data-th="Số tập">
								<h4 style="margin-top: 30px">${h.getSotap() }</h4>
							</td>
							<td data-th="Tác giả">
								<h4 style="margin-top: 30px">${h.getTacgia() }</h4>
							</td>
							<td data-th="Đơn giá">
								<h4 style="margin-top: 30px">${h.getGia() }VNĐ</h4>
							</td>

							<td data-th="Số lượng"><h4 style="margin: 30px 0 0 20px">${h.getSoluong() }</h4></td>

							<td data-th="Ngày nhập">
								<h4 style="margin-top: 30px;">
									<fmt:formatDate pattern="dd/MM/yyyy"
										value="${h.getNgaynhap() }" />
								</h4>
							</td>
							<td data-th="Thao tác">
								<div class="text-right thtac">
									<a class="up_del" id="edit"
										href="loadSach?ms=${h.getMasach() }" data-toggle="modal"<%-- onclick="location.href='loaiSach?ml=${h.getMaloai() }' --%>">
										Sửa </a> <a class="up_del" href="#"
										onclick="location.href='deleteSach?ms=${h.getMasach() }'">
										Xóa </a>
								</div>
							</td>

						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination-container">
			<ul class="pagination">
				<c:if test="${tag>1 }">
					<li><a href="Sach?page=${tag-1 }">Previous</a></li>
				</c:if>
				<c:forEach begin="1" end="${endPage }" var="i">
					<li><a class="${tag==i?'active':''}" href="Sach?page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${tag < endPage }">
					<li><a href="Sach?page=${tag+1 }">Next</a></li>
				</c:if>
			</ul>
		</div>
	</div>

	<!-- Thêm sách -->
	<div id="addSach" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addSach" method="post" enctype="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Thêm sách</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Mã sách</label> <input name="ma-sach" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Image</label> <input name="san-pham" type="file" size="60"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Tên sách</label> <input name="ten-sach" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Số tập</label> <input name="so-tap" type="number"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Tác giả</label> <input name="tac-gia" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Đơn giá</label> <input name="don-gia" type="number"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Số lượng</label> <input name="so-luong" type="number"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ngày nhập</label> <input name="ngay-nhap" type="date"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Loại</label> <select name="loai-sach" class="form-select"
								aria-label="Default select example">
								<c:forEach items="${listLoai }" var="o">
									<option value="${o.maloai }">${o.tenloai }</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>