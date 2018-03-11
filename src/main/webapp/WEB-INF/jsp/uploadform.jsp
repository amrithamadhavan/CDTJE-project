<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@include file="header.jsp" %>  
   
<!DOCTYPE html>  
<html>  
 <head>  
 <title>Image File Upload</title>  
 </head>  
 <body>  
<h1>Upload your image</h1>  
  

<form method="post" action="${pageContext.request.contextPath}/admin/savefile" enctype="multipart/form-data">  
<p><label for="image">Choose Image</label></p> <br>
<p><input name="file" id="fileToUpload" type="file" /></p><br><br>  
<p><input type="submit" value="Upload"></p>  
</form>  
</body>  
</html>  