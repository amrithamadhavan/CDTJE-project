<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><!-- ${addresses} -->
<c:forEach items="${user.getAddresses()}" var="address">
<table class="table table-bordered" style="width:300px">

<tr><td>DOOR NO:</td><td>${address.getDoorno()}</td></tr>
<tr><td>STREET NAME:</td><td>${address.getStname()}</td></tr>
<tr><td>AREA NAME:</td><td>${address.getAreaname()}</td></tr>
<tr><td>CITY NAME:</td><td>${address.getCity()}</td></tr>
<tr><td>PIN CODE:</td><td>${address.getPincode()}</td></tr>

</table>
<!-- <a class="btn btn-info btn-sm" href=${pageContext.request.contextPath}/>DELIVER</a>-->
<a class="btn btn-info btn-sm" href=${flowExecutionUrl}&_eventId_deliver?id=${address.getId()}>DELIVER</a>
</c:forEach>
</body>
</html>