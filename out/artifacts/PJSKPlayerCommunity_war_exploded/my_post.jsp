<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人帖子</title>
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
            margin-top: 10px;
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
    <h1>我的帖子</h1>
    <a href="post.jsp">返回论坛主页</a>

    <%
        List<Post> mypostList = (List<Post>) request.getAttribute("mypostList");
        if (mypostList != null && !mypostList.isEmpty()) {
            for (Post post : mypostList) {
    %>
    <div class="post">
        <h3><%= post.getTitle() %></h3>
        <p><%= post.getText() %></p>
        <p><small>发布于: <%= post.getPosttime() %></small></p>
        <form action="/deletePost" method="post">
            <input type="hidden" name="postId" value="<%= post.getPostid() %>">
            <button type="submit">删除</button>
        </form>
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

