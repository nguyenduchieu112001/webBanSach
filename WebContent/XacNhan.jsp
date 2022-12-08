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
					<th style="width: 4%">STT</th>
					<th style="width: 20%">Tên khách hàng</th>
					<th style="width: 20%">Tên sách</th>
					<th style="width: 12%">Đơn giá</th>
					<th style="width: 10%">Số lượng</th>
					<th style="width: 12%">Số tiền</th>
					<th style="width: 12%">Ngày mua</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>

			<tbody>
				<c:set value="0" var="i" />
				<c:if test="${not empty xn }">
					<c:forEach var="h" items="${xn }">
						<tr>
							<c:set value="${i+1 }" var="i" />
							<td data-th="STT">
								<h4 style="margin: 30px 0 0 10px">
									<c:out value="${i }" />
								</h4>
							</td>
							<td data-th="Tên khách hàng">
								<h4 style="margin-top: 30px">${h.getHoten() }</h4>
							</td>
							<td data-th="Tên sách">
								<h4 style="margin-top: 30px">${h.getTensach() }</h4>
							</td>
							<td data-th="Đơn giá">
								<h4 style="margin-top: 30px">${h.getGia() }VNĐ</h4>
							</td>

							<td data-th="Số lượng"><h4 style="margin: 30px 0 0 20px">${h.getSoluongmua() }</h4></td>
							<td data-th="Số tiền">
								<h4 style="margin-top: 30px; color: #ee4d2d;">${h.getThanhtien() }
									VNĐ</h4>
							</td>
							<td data-th="Ngày mua">
								<h4 style="margin-top: 30px;">
									<c:out value="${h.getNgaymua() }"></c:out>
								</h4>
							</td>
							<td class="actions" data-th="">
								<div class="text-right thtac">
									<a class="up_del" href="#"
										onclick="location.href='XacNhan?act=confirm&macthd=${h.getMacthd() }'">
										Xác nhận </a>
								</div>
							</td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>