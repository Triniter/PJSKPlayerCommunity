
<%@ page import="com.pjsk.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
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
    //登录检查
    if(session.getAttribute("user")==null){   //未登录

        //弹框并跳转到登录页面
        out.print("<script>alert('您尚未登录，请先登录');location='user_login.jsp'</script>");

        return;
    }
%>

<%
    //从session属性范围中取出用户对象
    User user = (User) session.getAttribute("user");
%>

欢迎管理员【<%=user.getUsername()%>】光临主页。
<br>
<a href="/ma_query">管理用户</a>
<br>
<a href="ma_register.jsp">注册管理</a>
<br>
<a href="/or_query">管理订单</a>
<br>
<a href="/po_query">管理帖子</a>
<br>
<a href="/ma_logout">用户注销</a>

</body>
</html>