<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br>
<center><h1>Choose Shipping Address..!</h1><br>
<a  class="btn btn-info btn-lg" href="${flowExecutionUrl}&_eventId_Existing">Existing</a>
<a  class="btn btn-info btn-lg" href="${flowExecutionUrl}&_eventId_New">New</a></center>
<!-- <a class="btn btn-info btn-sm" href=${pageContext.request.contextPath}/user/existing>EXISTING</a>-->
</body>
</html>