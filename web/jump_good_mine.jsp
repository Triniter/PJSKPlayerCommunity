<%@ page import="com.pjsk.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: LMX
  Date: 2024/7/11
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    Integer userid = user.getUserid();
%>
<script>
    location.href = "/good_mine?userid="+<%=userid%>;
</script>
</body>
</html>
