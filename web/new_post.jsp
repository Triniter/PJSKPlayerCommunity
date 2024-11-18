<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>发布新帖子</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
            height: 100vh;
            margin: 0;
            padding-top: 50px;
            font-family: 'Roboto', sans-serif;
        }
        .container {
            width: 60%;
            background-color: #ffffff;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            transition: transform 0.3s ease;
        }
        .container:hover {
            transform: scale(1.02);
        }
        h1, form, a {
            margin: 15px 0;
        }
        form input, form textarea, form button {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
            transition: border-color 0.3s ease;
        }
        form textarea {
            height: 300px; /* 扩大内容的文本框 */
        }
        form input:focus, form textarea:focus {
            border-color: #007bff;
        }
        form button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        form button:hover {
            background-color: #0056b3;
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
    <h1>发布新帖子</h1>
    <form action="/new_post" method="post">
        <input type="text" name="title" placeholder="标题" required>
        <textarea name="text" placeholder="内容" required></textarea>
        <button type="submit">发布</button>
    </form>
    <a href="post.jsp">返回主页</a>
</div>
</body>
</html>


