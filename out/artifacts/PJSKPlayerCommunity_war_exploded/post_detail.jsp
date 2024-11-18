<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pjsk.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>帖子详情</title>
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
        .comment-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }
        .comment-title {
            font-size: 1.5em;
            text-align: center;
        }
        .comment-container form {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 70%;
        }
        .comment-container textarea {
            width: 100%;
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
            transition: border-color 0.3s ease;
        }
        .comment-container textarea:focus {
            border-color: #007bff;
        }
        .comment-container button {
            font-size: 1em;
            padding: 10px 20px;
            border: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .comment-container button:hover {
            background-color: #0056b3;
        }
        .comment {
            background-color: #f9f9f9;
            padding: 15px;
            margin: 15px 0;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 70%;
        }
        .comment p {
            margin: 10px 0;
            color: #666;
        }
        .comment small {
            color: #999;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>帖子详情</h1>
    <a href="post.jsp">返回论坛主页</a>
    <!-- 显示帖子 -->
    <%
        List<Post> postdetailList = (List<Post>) request.getAttribute("postdetailList");
        if (postdetailList != null && !postdetailList.isEmpty()) {
            for (Post post : postdetailList) {
    %>
    <div class="post">
        <h3><%= post.getTitle() %></h3>
        <p><%= post.getText() %></p>
        <p><small>发布于: <%= post.getPosttime() %> 作者: <a href="/user_profile?userid=<%= post.getUserid() %>"><%= post.getUsername() %></a></small></p>
    </div>
    <%
        }
    } else {
    %>
    <p>没有帖子。</p>
    <%
        }
    %>
    <!-- 显示评论 -->
    <%
        List<Comment> commentList = (List<Comment>) request.getAttribute("commentList");
        if (commentList != null && !commentList.isEmpty()) {
            for (Comment comment : commentList) {
    %>
    <div class="comment">
        <p><%= comment.getText() %> —— <%= comment.getUsername() %></p>
    </div>
    <%
        }
    } else {
    %>
    <p>没有评论。</p>
    <%
        }
    %>
    <!-- 评论框 -->
    <div class="comment-container">
        <h1 class="comment-title">发布评论</h1>
        <form action="/comment" method="get">
            <textarea name="text" placeholder="内容" required></textarea>
            <button type="submit">发布</button>
        </form>
    </div>
</div>
</body>
</html>

