<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
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
 .form-control
{
width:400
}</style>

</head>
<body>
<!-- <button class="btn btn-danger"><a href="<c:url value='/display' />">Display</a></button>-->
	
	<h2>Edit Category Details</h2>
	<form:form action="${pageContext.request.contextPath}/admin/editcategory" modelAttribute="category">
		<table class="table">
		
				<form:input value="${categoryList.id}" type="hidden" class="form-control" path="id"/></td>
			
		
			<tr class="form-group">
				<td>category name:</td>
				<td><form:input value="${categoryList.cname}" class="form-control" path="cname"/></td>
			    <td><form:errors path = "cname"  /></td>
			</tr>
			<tr>
				<td><input type="submit" value="update" class="btn btn-primary"></td>
				
			</tr>
</table>
</form:form>
</body>
</html>