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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
				<li><a href="DaDuyet">Đơn đã duyệt</a></li>
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


	<div id="editLoai">
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
							value="Cancel" onclick="location.href='LoaiSach'"> <input
							type="submit" class="btn btn-success" value="Change">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>