<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/23/2019
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<fieldset>
    <legend>Vietnamese Translate</legend>
    <form method="post" action="/translate">
        <table>
            <tr>
                <td>EngLish :</td>
                <td><input type="text" name="english" placeholder="Write Here" value="${english}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Translate"></td>
            </tr>
            <tr>
                <td><span>Result :</span></td>
                <td><span>${result}</span></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
