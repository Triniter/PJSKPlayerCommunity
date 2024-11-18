<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/9
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>

</head>
<body>

<h3 align="center">新管理员注册</h3>

<table align="center">

    <form action="/ma_register" method="post">
        <tr>
            <td>管理员名</td>
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="立即添加"/>
            </td>
        </tr>

    </form>
</table>
<br>
<a href="/ma_goback">返回主页</a>
</body>
</html>
