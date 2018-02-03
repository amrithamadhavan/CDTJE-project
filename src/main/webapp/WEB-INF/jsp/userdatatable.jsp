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
<table id="example" class="display table table-hover" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>id</th>
				<th>pname</th>
				<th>description</th>
				<th>cost</th>
				<th>category</th>
				<th>image</th>
				<th>Cart</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>id</th>
				<th>pname</th>
				<th>description</th>
				<th>cost</th>
				<th>category</th>
				<th>image</th>
			    <th>Cart</th>
			</tr>
		</tfoot>

	</table>
	<script type="text/javascript">
		$('#example').DataTable({
			ajax : {

				url : 'http://localhost:8090/myproject1/test123',
				dataSrc : ''

			},
			columns : [ {
				data : 'id'
			},
			{
				data : 'pname'
			}, 
			{
				data : 'description'
			}, 
			{
				data : 'cost'
			},
			{
				data:'category.cname'
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,full){
					return '<img src="${pageContext.request.contextPath}/resources/images/'+data+'.jpg">';
				}
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,full){
					return '<a class="btn btn-info btn-sm" href=${pageContext.request.contextPath}/user/viewproduct/'+data+'>'+'view'+'</a>';
				}
			}
			
			
			]
		});
	</script>
	
</body>
</html>