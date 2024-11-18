<%@ page import="com.pjsk.entity.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个性签名</title>
    <script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

<h2>修改个性签名</h2>
<form action="/update_message" method="post">
    当前签名: <span>${user.message}</span><br>
    新签名: <input type="text" name="message" value="${user.message}" required>
    <input type="hidden" name="userid" value="${user.userid}">
    <input type="submit" value="保存修改">
</form>
</body>
</html>


