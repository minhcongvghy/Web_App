<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2019
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="/translate" method="get">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  </body>
</html>
