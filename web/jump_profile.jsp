<%--
  Created by IntelliJ IDEA.
  User: LMX
  Date: 2024/7/11
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("targetAddress", "profile.jsp");
%>
<script>
    location.href="/user_update"
</script>
</body>
</html>
