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
<style type="text/css">
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

</body>
</html>