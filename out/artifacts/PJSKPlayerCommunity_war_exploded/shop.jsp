<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品列表</title>
    <style>
        .goods-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start; /* 从左往右对齐 */
            margin: 0 -5px; /* 负边距用于消除间距 */
        }
        .good {
            width: calc(25% - 10px); /* 每行显示四个商品，减去外边距后的宽度 */
            border: 0px solid #ccc;
            border-radius: 10%;
            padding: 10px;
            margin: 5px; /* 商品之间的间距 */
            text-align: center; /* 居中显示 */
            box-sizing: border-box; /* 包含内边距和边框 */
            text-decoration: none; /* 移除链接默认的下划线 */
            color: inherit; /* 保持文本颜色不变 */
            transition: background-color 0.3s ease; /* 添加背景色过渡效果 */
        }
        .good:hover {
            background-color: #aaaaaa; /* 鼠标悬停时的背景色 */
            transform: scale(1.1);
        }
        .good img {
            width: 80%; /* 图片宽度占商品框的80% */
            height: 150px;
            display: block;
            margin: 0 auto 10px; /* 图片居中显示 */
        }
        .good .info {
            margin-top: auto; /* 商品信息与底部对齐 */
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .good h3, .good p {
            margin: 5px 0;
        }
        .good .info p {
            font-weight: bold; /* 加粗价格字体 */
            color: #007bff; /* 设置价格字体颜色 */
        }
        .search-form input[type="number"] {
            width: 80px; /* 设置价格输入框的宽度 */
        }

        .nav-buttons button:hover {
            background-color: #0056b3;
        }

        .search-form {
            display: flex;
            align-items: center;
        }
        .search-form input[type="text"],
        .search-form input[type="number"] {
            margin-right: 10px;
        }
        .search-form button {
            margin-left: 10px;
        }
        .nav-buttons {
            margin-left: auto;
        }
        .nav-buttons button {
            margin-left: 10px;
            padding: 8px 12px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

    </style>

    <script>

        function myorder(userid) {

            window.location.href = '/order_query?userid='+${user.userid} ;


        }

        function mygood(userid) {

            window.location.href = '/good_mine?userid='+${user.userid};

        }
    </script>
</head>
<body>

<!-- 右侧导航按钮 -->
<div class="nav-buttons" align="right">
    <button onclick="myorder(${user.userid})">我的订单</button>
    <button onclick="mygood(${user.userid})">我的售卖</button>
</div>

<%--搜索栏--%>
<form class="search-form" action="/good_search" method="post">
    <input type="text" name="keyword" placeholder="输入商品名">
    <input type="number" name="minPrice" placeholder="最低价格">~
    <input type="number" name="maxPrice" placeholder="最高价格">
    <button type="submit">搜索</button>
</form>



<%--商品列表--%>
<div class="goods-container">
    <%-- 使用 EL 表达式访问 Servlet 设置的请求属性 goods --%>
    <c:forEach items="${goods}" var="good">
        <a href="/good_detail?goodid=${good.goodid}" class="good">
            <img src="image/good_photo/${good.photo}" alt="${good.goodname}">
            <h3>${good.goodname}</h3>
            <p>价格: ${good.price}元</p>
        </a>
    </c:forEach>
</div>
</body>
</html>

