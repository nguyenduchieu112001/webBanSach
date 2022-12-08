<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
<link href="css/manager.css" rel="stylesheet">
<style type="text/css">
.ctn-history {
	width: 80%;
	margin: 0 10%;
}

.thtac {
	display: flex;
	justify-content: space-evenly;
}

.up_del {
	text-decoration: none;
	display: block;
	padding: 6px 20px;
	border: 1px solid #ccc;
	border-radius: 3px;
	background-color: #ccc;
	font-weight: 600;
}
</style>
<title>Insert title here</title>
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
					<th style="width: 10%">STT</th>
					<th style="width: 20%; text-align: center;">Mã loại</th>
					<th style="width: 20%; text-align: center;">Tên loại</th>
					<th style="width: 40%; text-align: center;">Thao tác</th>
					<th style="width: 10%">
						<button data-toggle="modal" data-target="#addLoai">Thêm</button>
					</th>
				</tr>
			</thead>

			<tbody>
				<c:set value="0" var="i" />
				<c:if test="${not empty list }">
					<c:forEach var="h" items="${list }">
						<tr>
							<c:set value="${i+1 }" var="i" />
							<td data-th="STT">
								<h4 style="margin: 30px 0 0 10px">
									<c:out value="${i }" />
								</h4>
							</td>
							<td data-th="Mã loại">
								<h4 style="margin-top: 30px">${h.getMaloai() }</h4>
							</td>
							<td data-th="Tên loại">
								<h4 style="margin-top: 30px">${h.getTenloai() }</h4>
							</td>

							<td class="actions" data-th="Thao tác">
								<div class="text-right thtac">
									<a class="up_del" id="edit"
										href="loadLoai?maloai=${h.getMaloai() }" data-toggle="modal"<%-- onclick="location.href='loaiSach?ml=${h.getMaloai() }' --%>">
										Sửa </a> <a class="up_del" href="#"
										onclick="location.href='deleteLoai?act=delete&ml=${h.getMaloai() }'">
										Xóa </a>
								</div>
							</td>

						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>


	<!-- Thêm loại -->
	<div id="addLoai" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addLoai" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Thêm loại</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Mã loại</label> <input name="ma-loai" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Tên loại</label> <input name="ten-loai" type="text"
								class="form-control" required>
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

	<%-- <!-- Sửa loại -->
	<div id="editLoai" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="editLoai" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Thêm loại</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Mã loại</label> <input name="ma-loai" value="${ml }"
								required="required" type="text" class="form-control">
						</div>
						<div class="form-group">
							<label>Tên loại</label> <input name="ten-loai" value="${tl }"
								required="required" type="text" class="form-control">
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Change">
					</div>
				</form>
			</div>
		</div>
	</div> --%>

</body>
</html>