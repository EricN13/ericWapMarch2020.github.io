<%-- 
    Document   : index
    Created on : Feb 29, 2020, 9:31:21 PM
    Author     : nkuri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>beer</title>
</head>
<body>
<h2 align="center">select beer</h2>
<form method="POST" action="BeerSelect">
  <p>Select beer characteristics</p>
  Color:<select name="color" size="1">
  <option value="light"> light</option>
  <option value="amber"> amber</option>
  <option value="brown"> brown</option>
  <option value="dark"> dark</option>
</select>
  <br><br>
  <center>
  <input type="SUBMIT">  </center>

</form>
</body>
</html>
