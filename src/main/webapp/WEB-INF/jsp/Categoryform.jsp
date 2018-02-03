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
}
</style>
  
  
</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/savecategory" modelAttribute="category">
		<table class="table">
			<tr class="form-group">
				<td>category name:</td>
				<td><form:input type="text" class="form-control" path="cname"/></td>
				<td><form:errors path = "cname"  /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="btn btn-primary"></td>
			</tr>
			</table>
			</form:form>
			<table id="example" class="display table table-hover" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>id</th>
				<th>cname</th>
				<th>delete</th>
                <th>edit</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>id</th>
				<th>cname</th>
				
			    <th>delete</th>
			    <th>edit</th>
			</tr>
		</tfoot>

	</table>
	<script type="text/javascript">
		$('#example').DataTable({
			ajax : {

				url : 'http://localhost:8090/myproject1/testforcategory',
				dataSrc : ''

			},
			columns : [ {
				data : 'id'
			}, {
				data : 'cname'
			},
			
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,full){
					return '<a class="btn btn-info btn-sm" href=${pageContext.request.contextPath}/admin/deletecategory/'+data+'>'+'delete'+'</a>';
				}
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,full){
					return '<a class="btn btn-info btn-sm" href=${pageContext.request.contextPath}/admin/updatecategory/'+data+'>'+'edit'+'</a>';
				}
			}
			
			
			]
		});
	</script>
</body>
</html>