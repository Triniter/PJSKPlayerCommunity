<%@ page import="java.util.List" %>
<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="com.pjsk.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>论坛主页</title>
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
        .actions {
            margin-top: 15px;
        }
        .post-meta {
            display: flex;
            justify-content: space-between;
            font-size: 0.9em;
            color: #777;
        }
        .author {
            float: left;
        }
        .time {
            float: right;
        }
        .search-bar {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }
        .search-bar input[type="text"] {
            width: 70%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px 0 0 5px;
            outline: none;
            transition: border-color 0.3s ease;
        }
        .search-bar input[type="text"]:focus {
            border-color: #007bff;
        }
        .search-bar button {
            padding: 10px 20px;
            border: none;
            background-color: #007bff;
            color: white;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .search-bar button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>论坛主页</h1>
    <%
        User user = (User) session.getAttribute("user");
        if (user == null || user.getUsername() == null) {
    %>
    <script type="text/javascript">
        alert("你没有登录");
        location.href="base.jsp";
    </script>
    <%
    } else {
        String username = user.getUsername();
    %>
    <p>欢迎, <%= username %>!</p>
    <%
        }
    %>
    <a href="new_post.jsp">发布新帖子</a> | <a href="/my_post">查看我的帖子</a>
    <div class="search-bar">
        <form action="/post_search" method="get">
            <input type="text" name="title" placeholder="搜索帖子">
            <button type="submit">搜索</button>
        </form>
    </div>

    <%
        List<Post> postList = (List<Post>) request.getAttribute("postList");
        if (postList != null && !postList.isEmpty()) {
            for (Post post : postList) {
    %>
    <div class="post">
        <h3><a href="/post_detail?id=<%= post.getPostid() %>"><%= post.getTitle() %></a></h3>
        <p><%= post.getText() %></p>
        <div class="post-meta">
            <span class="author">作者: <%= post.getUsername() %></span>
            <span class="time">发布于: <%= post.getPosttime() %></span>
        </div>
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


