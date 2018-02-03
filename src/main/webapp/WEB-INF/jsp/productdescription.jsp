<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    width: 200px;
    height:200px;
    margin-left: 20px;
    
}
	</style>
  </head>
  
<body>

<form:form action="${pageContext.request.contextPath}/user/addtocart/${product.id}" modelAttribute="cartitems">

		<div style="float:left">
		<table class="table" style="margin-left: 30px">
			<tr class="form-group">
				<td>Product name:</td>
				<td>${product.pname}</td>
			</tr>
			<tr class="form-group">
				<td>Product Description:</td>
				<td>${product.description}</td>
			</tr>
			<tr class="form-group">
				<td>Product Price:</td>
				<td>${product.cost}</td>
			</tr>
			<tr class="form-group">
				<td>Category:</td>
				<td>${product.category.cname}
				    </td>
			</tr>
			<!-- <tr class="form-group">
				<td>image:</td>
				<td>
			<img src="${pageContext.request.contextPath}/resources/images/${product.id}.jpg"></td>
			</tr>-->
			<tr class="form-group">
				<td>quantity:</td>
				<td><form:input type="text" name="quantity"  class="form-control" path="quantity"/></td>
			    
			</tr>
			
			<tr>
				<td><input type="submit" value="Add To Cart" class="btn btn-primary"></td>
				
			</tr>
			
		</table>
		</div>
		<div style="float:left">
       <img src="${pageContext.request.contextPath}/resources/images/${product.id}.jpg">
		</div>
	</form:form>
	
	

</body>
</html>