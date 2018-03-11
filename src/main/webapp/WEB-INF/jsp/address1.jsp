<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.form-control
{
width:400
}
</style>

</head>
<body>
<form:form  modelAttribute="address">
		<table class="table">
			 <tr class="form-group">
				<td>Door no:</td>
				<td><form:input class="form-control"  path="doorno"/></td>
				<td><form:errors path = "doorno"  /></td>
			</tr>
			<tr class="form-group">
				<td>Street name:</td>
				<td><form:input class="form-control" path="stname"/></td>
				<td><form:errors path = "stname"  /></td>
			</tr>
			<tr class="form-group">
				<td>Area name:</td>
				<td><form:input class="form-control" path="areaname"/></td>
				<td><form:errors path = "areaname"  /></td>
			</tr>
			<tr class="form-group">
				<td>city:</td>
				<td><form:input class="form-control" path="city"/></td>
				<td><form:errors path = "city"  /></td>
			</tr>
			<tr class="form-group">
				<td>Pincode:</td>
				<td><form:input class="form-control" path="pincode"/></td>
			<td><form:errors path = "pincode"  /></td>
			</tr>
			<tr>
				<td><a  class="btn btn-info btn-sm" href="${flowExecutionUrl}&_eventId_Deliver">Deliver</a></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>