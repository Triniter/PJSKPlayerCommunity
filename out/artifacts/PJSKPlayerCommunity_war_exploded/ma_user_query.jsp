<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/9
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pjsk.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.pjsk.entity.User" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查询</title>
    <style>
        img{
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }
    </style>
</head>
<body>

<%
    //从request属性范围中取出用户列表
    List<User> userList = (List<User>) request.getAttribute("userList");
%>

<h3 align="center">用户列表</h3>

<table border="1" cellspacing="0" align="center">

    <tr><th>选择</th><th>头像</th><th>用户名</th><th>余额</th><th>role</th><th>操作</th></tr>

    <form action="/ma_delete_batch">

        <%
            //遍历用户列表
            for (User user : userList) {
        %>

        <tr>

            <td align="center">
                <input type="checkbox" name="userid" value="<%=user.getUserid()%>"/>
            </td>

            <td><img src="image/profile/<%=user.getProfile()%>"></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getBalance()%></td>
            <td><%=user.getRole()%></td>
            <td>
                <a href="/ma_delete?userid=<%=user.getUserid()%>">删除</a>
                <a href="/ma_get?userid=<%=user.getUserid()%>">修改</a>
            </td>
        </tr>
        <%
            }
        %>

        <tr>
            <td colspan="6" align="center"><input type="submit" value="批量删除"/> </td>
        </tr>

    </form>
</table>
<br>
<a href="/ma_goback">返回主页</a>
</body>
</html>
