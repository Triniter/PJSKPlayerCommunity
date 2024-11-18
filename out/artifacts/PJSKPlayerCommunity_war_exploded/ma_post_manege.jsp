<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/7/10
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pjsk.util.JDBCUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理删除帖子</title>

</head>
<body>

<%
    //从request属性范围中取出用户列表
    List<Post> userList = (List<Post>) request.getAttribute("userList");
%>

<h3 align="center">订单列表</h3>

<table border="1" cellspacing="0" align="center">

    <tr><th>选择</th><th>用户号</th><th>标题</th><th>内容</th><th>操作</th></tr>

    <form action="/po_delete_batch">

        <%
            //遍历用户列表
            for ( Post user : userList) {
        %>

        <tr>

            <td align="center">
                <input type="checkbox" name="postid" value="<%=user.getPostid()%>"/>
            </td>

            <td><%=user.getUserid()%></td>
            <td><%=user.getTitle()%></td>
            <td><%=user.getText()%></td>

            <td>
                <a href="/po_delete?postid=<%=user.getPostid()%>">删除</a>
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
