<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>查询用户主页</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 70%;
            background-color: #ffffff;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            transition: transform 0.3s ease;
        }
        .container:hover {
            transform: scale(1.02);
        }
        h1, h2, p, form, hr {
            margin: 15px 0;
        }
        .post {
            background-color: #f9f9f9;
            padding: 20px;
            margin: 20px 0;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }
        .post:hover {
            transform: scale(1.02);
        }
        .post h3 {
            margin: 0;
            font-size: 1.8em;
            color: #333;
        }
        .post p {
            margin: 10px 0;
            color: #666;
        }
        .post small {
            color: #999;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>用户帖子</h1>
    <a href="post.jsp">返回论坛主页</a>
    <!-- 显示用户的帖子 -->
    <%
        List<Post> userPosts = (List<Post>) request.getAttribute("userPosts");
        if (userPosts != null && !userPosts.isEmpty()) {
            for (Post post : userPosts) {
    %>
    <div class="post">
        <h3><%= post.getTitle() %></h3>
        <p><%= post.getText() %></p>
        <p><small>发布于: <%= post.getPosttime() %> 作者: <%= post.getUsername() %></small></p>
    </div>
    <%
        }
    } else {
    %>
    <p>没有帖子。</p>
    <%
        }
    %>
</div>
</body>
</html>

