<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#id1{
padding-left: 200px;
}
#id2{
padding-left: 50px;}
</style>
</head>
<body>
<div id="id1">
<h1><center>MY PROFILE</center></h1><br><br>
<h3><b>Your Name   :   ${user2.getUname()}</b></h3><br>
<h3><b>Your Email id  :  ${user2.getEmail()}</b></h3><br>
<h3><b>Your Mobile number  :  ${user2.getMobno()}</b></h3><br>
<h3><b>Address  :</b></h3>
<c:forEach items="${user2.getAddresses()}" var="address">

<div id="id2"><h4><b><p>
${address.getDoorno()},
${address.getStname()},<br>
${address.getAreaname()},<br>
${address.getCity()},<br>
${address.getPincode()}.   </p></b></h4></div>


</c:forEach>
</div>
</body>
</html>