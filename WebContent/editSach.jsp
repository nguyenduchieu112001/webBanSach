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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
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
	<!-- sửa sách -->

	<c:forEach items="${listSach }" var="h">
		<div id="editSach">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="editSach" method="post" enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Sửa sách</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Mã sách</label> <input value="${h.masach }"
									name="ma-sach" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Sản phẩm</label>
								<%-- <img alt="" src="${h.getAnh() }" style="width: 200px" height="200px"> --%>
								<input name="san-pham" value="${anhcu }" type="file" size="60"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Tên sách</label> <input value="${h.tensach }"
									name="ten-sach" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Số tập</label> <input value="${h.sotap }" name="so-tap"
									type="number" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Tác giả</label> <input value="${h.tacgia }"
									name="tac-gia" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Đơn giá</label> <input value="${h.gia }" name="don-gia"
									type="number" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Số lượng</label> <input value="${h.soluong }"
									name="so-luong" type="number" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Ngày nhập</label> <input value="${h.ngaynhap }"
									name="ngay-nhap" type="date" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Loại</label> <select name="loai-sach" class="form-select"
									aria-label="Default select example">
									<c:forEach items="${listLoai }" var="o">
										<option ${h.masach == o.maloai?"selected":"" }
											value="${o.maloai }">${o.tenloai }</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-default" data-dismiss="modal"
								value="Cancel" name="Huy" onclick="location.href='Sach'">
							<input type="submit" class="btn btn-success" value="Change">
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- 	<script>
		// Get a reference to our file input
		const fileInput = document.querySelector('input[type="file"]');

		// Create a new File object
		const myFile = new File([ 'Hello World!' ], '${anhcu }', {
			type : 'text/plain',
			lastModified : new Date(),
		});

		// Now let's create a DataTransfer to get a FileList
		const dataTransfer = new DataTransfer();
		dataTransfer.items.add(myFile);
		fileInput.files = dataTransfer.files;
	</script> -->



</body>
</html>