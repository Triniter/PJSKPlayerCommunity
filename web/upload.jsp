<%@ page import="com.pjsk.entity.User" %>
<%@ page import="javax.print.attribute.standard.RequestingUserName" %>
<%@ page import="com.pjsk.service.Userdao" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script src="js/jquery-3.6.0.min.js"></script>

</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;

    }
    .container {
        width: 20%;
        height: 40%;
        overflow: hidden;
        background-color: aliceblue;
        padding: 2px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        text-align: center;
    }
    img.profile {
        width: 120px;
        height: 120px;
        border-radius: 50%;
        margin-bottom: 10px;
    }
    .profile{
        text-align: center;
     }
    input[type="file"] {
        margin-bottom: 10px;
    }
    input[type="submit"] {
        background-color: #5cb85c;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #4cae4c;
        top: 0;

    }
    body{
        background:none;
    }

</style>
<body>
<div class="container">
<%
    User user1 = new User();
    user1 = (User)session.getAttribute("user");
    System.out.println(user1.getUsername());

%>
    <form action="Inertm" method="post" enctype="multipart/form-data">
        <a>请选择你要上传的头像</a>
        <img src="image/photo/${user.profile}" class="profile"/>
        <input type="hidden" id="user" name="user" value="<%=user1.getUsername()%>">
        <input class="fileInput" type="file" name="image" />
        <input type="submit" value="提交"/>
    </form>
</div>

<script type="text/javascript" src="Jquery/jquery.min.js"></script>
</body>
</html>



