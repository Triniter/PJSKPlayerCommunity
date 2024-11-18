<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/10
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pjsk.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.pjsk.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单状态修改</title>

</head>
<body>

<%
    //接收数据
    Order user = (Order)request.getAttribute("user");
%>

<h3 align="center">订单修改</h3>

<table align="center">

    <form action="/or_modify" method="post">

        <tr>
            <td>商品号</td>
            <td><input type="text" name="goodid" value="<%=user.getGoodid()%>"/></td>
        </tr>

        <tr>
            <td>用户编号</td>
            <td><input type="text" name="userid" value="<%=user.getUserid()%>"/></td>
        </tr>

        <tr>
            <td>状态</td>
            <td>
                <select name="status">
                    <option value="未发出">未发出</option>
                    <option value="送货中">送货中</option>
                    <option value="已送达">已送达</option>
                </select>


            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="orderid" value="<%=user.getOrderid()%>"/>
                <input type="submit" value="保存修改"/>
            </td>
        </tr>

    </form>
</table>


</body>
</html>

