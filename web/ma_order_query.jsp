<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/10
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pjsk.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.pjsk.entity.Order" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理删除帖子</title>

</head>
<body>

<%
    //从request属性范围中取出用户列表
    List<Order> userList = (List<Order>) request.getAttribute("userList");
%>

<h3 align="center">订单列表</h3>

<table border="1" cellspacing="0" align="center">

    <tr><th>选择</th><th>商品号</th><th>用户号</th><th>总数</th><th>状态</th><th>操作</th></tr>

    <form action="/po_delete_batch">

        <%
            //遍历用户列表
            for ( Order user : userList) {
        %>

        <tr>

            <td align="center">
                <input type="checkbox" name="orderid" value="<%=user.getOrderid()%>"/>
            </td>


            <td><%=user.getUserid()%></td>
            <td><%=user.getQuantity()%></td>
            <td><%=user.getStatus()%></td>
            <td><%=user.getTotal()%></td>
            <td>
                <a href="/or_delete?orderid=<%=user.getOrderid()%>">删除</a>
                <a href="/or_get?orderid=<%=user.getOrderid()%>">修改</a>
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
