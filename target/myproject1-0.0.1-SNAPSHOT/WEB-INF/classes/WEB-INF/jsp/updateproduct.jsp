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

.display {
    margin-left: 100px;
    margin-bottom: 30px;
    margin-top: -61px;
}
.navbar-inverse {
    background-color: #222;
    border-color: #080808;
    margin-left: -68px;
    margin-right: -68px;
}
.form-control
{
width:400
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
</head>

<body bgcolor="gray" class="container">
<!-- <button class="btn btn-danger"><a href="<c:url value='/display' />">Display</a></button>-->
	
	
	<form:form action="${pageContext.request.contextPath}/admin/editprodct" modelAttribute="product">
		<table class="table">
		<tr class="form-group">
				<td>Product id:</td>
				<td><form:input type="text" name="productId" class="form-control" value="${productList.id}" path="id"/></td>
			</tr>
		
			<tr class="form-group">
				<td>Product name:</td>
				<td><form:input type="text" name="productName" class="form-control" value="${productList.pname}" path="pname"/></td>
			    <td><form:errors path = "pname"  /></td>
			</tr>
			<tr class="form-group">
				<td>Product Description:</td>
				<td><form:input type="text" name="productDesc"  class="form-control" value="${productList.description}" path="description"/></td>
			    <td><form:errors path = "description"  /></td>
			</tr>
			<tr class="form-group">
				<td>Product Price:</td>
				<td><form:input type="text" name="productPrice"  class="form-control" value="${productList.cost}" path="cost"/></td>
			    <td><form:errors path = "cost"  /></td>
			</tr>
			<tr class="form-group">
				<td>Category:</td>
				<td><form:select class="form-control" path="category.id">
		            <form:options items="${categorylist}" itemLabel="cname" itemValue="id"></form:options>
		            </form:select>
				    </td>
			</tr>
			<tr>
				<td><input type="submit" value="update" class="btn btn-primary"></td>
				
			</tr>
		</table>
	</form:form>
</body>
</html>