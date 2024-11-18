<%@ page import="com.pjsk.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    Integer userid = user.getUserid();
%>
<script>
    location.href = "/order_query?userid="+<%=userid%>;
</script>

</body>
</html>
