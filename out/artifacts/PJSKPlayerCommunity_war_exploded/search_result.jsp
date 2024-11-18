<%@ page import="com.pjsk.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 60%;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 20px;
        }
        .post {
            background-color: #f9f9f9;
            padding: 15px;
            margin: 15px 0;
            border-radius: 8px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        .post h2 {
            margin: 0;
            font-size: 2em;
        }
        .post p {
            margin: 10px 0;
            color: #555;
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
    </style>
</head>
<body>
<div class="container">
    <h1>搜索结果</h1>
    <a href="post.jsp">返回论坛主页</a>

        <%
    List<Post> searchList = (List<Post>) request.getAttribute("searchList");
    if (searchList != null && !searchList.isEmpty()) {
      for (Post post : searchList) {
  %>
    <div class="post">
        <h3><a href="/post_detail?id=<%= post.getPostid() %>"><%= post.getTitle() %></a></h3>
        <p><%= post.getText() %></p>
        <p><small>发布于: <%= post.getPosttime() %></small></p>
    </div>
        <%
    }
  } else {
  %>
    <p>没有帖子。</p>
        <%
    }
  %>

</body>
</html>
