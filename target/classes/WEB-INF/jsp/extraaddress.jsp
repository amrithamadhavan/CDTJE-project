<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

.btn-info {
    
    margin-left: -7px;
    margin-top: 100px;
}
	</style>
</head>
<body>
do u want to add another address?
<div class="display">
	<button class="btn btn-info"><a href="<c:url value='/address/${user.id}'/>">yes</a></button>
	</div>
	<div class="img-upload">
	<button class="btn btn-danger"><a href="${pageContext.request.contextPath}/">no</a></button>
	</div>
</body>
</html>