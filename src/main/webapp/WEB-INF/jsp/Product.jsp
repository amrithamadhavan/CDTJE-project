<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

.display {
    margin-left: 100px;
    margin-bottom: 30px;
    margin-top: -61px;
}
.img-upload {
    margin-left: 200px;
    margin-bottom: 30px;
    margin-top: -61px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body bgcolor="gray" class="container">
<!-- <button class="btn btn-danger"><a href="<c:url value='/display' />">Display</a></button>-->
	<div class="logo">E-Commerce</div>
	<h1>Product List</h1>
	<form:form action="addprodct" modelAttribute="product">
		<table class="table">
			<tr>
				<td>Product name:</td>
				<td><form:input type="text" name="productName" required="required" path="pname"/></td>
			</tr>
			<tr>
				<td>Product Description:</td>
				<td><form:input type="text" name="productDesc" required="required" path="description"/></td>
			</tr>
			<tr>
				<td>Product Price:</td>
				<td><form:input type="text" name="productPrice" required="required" path="cost"/></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><form:select path="category.id">
		            <form:options items="${categorylist}" itemLabel="cname" itemValue="id"></form:options>
		            </form:select>
				    </td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="btn btn-primary"></td>
			</tr>
			
		</table>
	</form:form>
	<div class="display">
	<button class="btn btn-info"><a href="<c:url value='/display' />">Display</a></button>
	</div>
	<div class="img-upload">
	<button class="btn btn-info"><a href="<c:url value='/uploadform' />">img-upload</a></button>
	</div>
	<c:if test="${!empty productList}">
		<table class="table table-bordered">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="120">image</th>
				<th width="150">Action</th>
				
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					 <td>${product.id}</td> 
					<td>${product.pname}</td>
					<td>${product.description}</td>
					<td>${product.cost}</td>
					<td><img src="resources/images/${product.pname}.jpg"></td>
					
					<td><button class="btn btn-primary" 
							style="margin-right: 40px;"><a href="<c:url value='/updateproduct/${product.id}' />">Edit</a></button>
						<button class="btn btn-danger"><a href="<c:url value='/deleteproduct/${product.id}' />">Delete</a></button></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>