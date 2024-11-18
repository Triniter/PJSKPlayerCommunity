<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/9
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pjsk.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.pjsk.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户修改</title>

</head>
<body>

<%
    //接收数据
    int userid = Integer.parseInt(request.getParameter("userid"));

    //根据用户编号删除用户记录
    JDBCUtil jdbcUtil = new JDBCUtil();

    String sql = "select userid, username, password, balance from user where userid = ?";

    ResultSet rs = jdbcUtil.execQuery(sql, userid);

    //创建实体类对象
    User user = new User();

    if(rs.next()){

        //填充实体类对象
        user.setUserid(rs.getInt(1));
        user.setUsername(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setBalance(rs.getFloat(4));
    }
%>

<h3 align="center">用户修改</h3>

<table align="center">

    <form action="/ma_modify" method="post">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="<%=user.getUsername()%>"/></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="<%=user.getPassword()%>"/></td>
        </tr>

        <tr>
            <td>账户金额</td>
            <td><input type="text" name="balance" value="<%=user.getBalance()%>"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="userid" value="<%=user.getUserid()%>"/>
                <input type="submit" value="保存修改"/>
            </td>
        </tr>

    </form>
</table>

</body>
</html>

