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
    width: 250px;
    height:250px;
   }
   .form-horizontal .form-group{
   margin-right: -15px;
   margin-left: -15px;
   padding-left: 550px;
   padding-right: 310px;
   }
	</style>
  </head>
  
<body>
<h1><center>Product Description</center></h1><br>
<form:form class="form-horizontal" action="${pageContext.request.contextPath}/user/addtocart/${product.id}" modelAttribute="cartitems">
 <center><img src="${pageContext.request.contextPath}/resources/images/${product.id}.jpg">
		
				<h4><label>ProductName : ${product.pname}</label></h4>
			<h4><label>Product Description : ${product.description}</label></h4>
			<h4><label>Product Price : ${product.cost}</label></h4>
				
			<h4><label>Category : ${product.category.cname}</label></h4>
				    
			
			<div class="form-group">
				<h4><label class="control-label col-sm-2 input-lg">Quantity:</label>
				<div class="col-sm-5">
				<form:input type="text" class="form-control input-lg" name="quantity"   value="1" path="quantity"/></h4>
			    
			</div>
			
	        </div>		
			<input type="submit" value="Add To Cart" class="btn btn-primary"></center>
			</form:form>
	
	

</body>
</html>