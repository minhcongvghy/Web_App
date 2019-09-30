<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2019
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/index" method="post">
  <input type="checkbox" name="condiment" value="Lettuce">Lettuce
  <input type="checkbox" name="condiment" value="Tomato">Tomato
  <input type="checkbox" name="condiment" value="Mustard">Mustard
  <input type="checkbox" name="condiment" value="Spout">Spout
  <input type="submit" value="Save" formmethod="post">
  <h1>${ab} ${ as }</h1>
</form>
</body>
</html>
