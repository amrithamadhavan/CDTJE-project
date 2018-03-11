<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
	<style>
	img {
    vertical-align: middle;
    width: 100px;
}</style>
</head>
<body>
<c:if test="${!empty cartitemslist}">
		<table class="table table-bordered">
			<tr>
				
				<th width="120">ProductName</th>
				<th width="200">ProductDescription</th>
				<th width="80">Price</th>
				<th width="80">Quantity</th>
				<th width="80">subtotal</th>
				<th width="120">image</th>
				<!-- <th width="100">Delete</th>-->
				
				
			</tr>
			<c:forEach items="${cartitemslist}" var="cartitem">
				<tr>
					<td>${cartitem.getProduct().getPname()}</td>
					<td>${cartitem.getProduct().getDescription()}</td>
					<td>${cartitem.getProduct().getCost()}</td>
					<td>${cartitem.quantity}</td>
					<td>${cartitem.subtotal}</td>
					
					<td><img src="${pageContext.request.contextPath}/resources/images/${cartitem.getProduct().getId()}.jpg"></td>
					<!-- <td><a class="btn btn-info btn-sm" href="<c:url value='/user/removeitem/${cartitem.getProduct().getId()}'/>">Remove</a></td>-->
					</tr>
			</c:forEach>
			
		</table>
	</c:if><br><br><br>
	<center><h3><b>The grand total is ${cart.getGrandtotal()}</b></h3><br>
	<a class="btn btn-info btn-lg" href=${pageContext.request.contextPath}/user/product>Continue Shopping</a>
	<a class="btn btn-info btn-lg" href=${pageContext.request.contextPath}/user/deletecart>Buy Now</a></center>
</body>