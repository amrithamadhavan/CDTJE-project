<%@include file="header.jsp" %>
<!DOCTYPE html>
  <html lang="en">
<head>

  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
form
{
margin-top:50px;

}
.form-control
{
width:75%;
background-color:white;
}
.form-group
{
margin-bottom:50px
}
body
{
background-image:url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_y_S03E0T0S3OJwFq9Qh4mfYXlJH9fHyaXvzCDMCEPxf9jlHHkA");"
}
</style>
</head>
<body>

<div class="container">
  <h2><center>user registration </center></h2>
  <form:form class="form-horizontal" action="registration" modelAttribute="uDemo">
  <div class="form-group">
   <label class="control-label col-sm-2" for="fname">First Name:</label>
   <div class="col-sm-10">
      <form:input type="text" class="form-control" id="fname" placeholder="Enter the first name" name="fname" path="fname"/>
      <form:errors path = "fname"  />
    </div>
    </div>
    <div class="form-group">
   <label class="control-label col-sm-2"for="lname">Last Name:</label>
      <div class="col-sm-10">
      <form:input type="text" class="form-control" id="lname" placeholder="Enter the last name" name="lname" path="lname"/>
      
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
      <form:input type="email" class="form-control" id="email" placeholder="Enter email" name="email" path="email"/>
      <form:errors path = "email"  />
    </div>
    </div>
      <div class="form-group">
    <label class="control-label col-sm-2" for="uname">username:</label>
      <div class="col-sm-10">
      <form:input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" path="uname"/>
    <form:errors path = "uname"  />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      
      <div class="col-sm-10">
      <form:input type="password" class="form-control" id="pwd" placeholder="Enter new password" name="pwd" path="pwd"/>
    <form:errors path = "pwd"  />
    </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="repwd">re-enter Password:</label>
      <div class="col-sm-10">
      <input type="password" class="form-control" id="repwd" placeholder="Re-Enter new password" name="repwd">
    
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="mobno">mobile no:</label>
      <div class="col-sm-10">
      <form:input type="text" class="form-control" id="mobno" placeholder="enter mobile no" name="mobno" path="mobno"/>
    <form:errors path = "mobno"  />
    </div>
    </div>
    
    <center><button type="submit" class="btn btn-success btn-lg">Register</button></center>
  </form:form>
</div>

</body>
</html>
