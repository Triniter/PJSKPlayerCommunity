<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的在售</title>
    <style>
        .good-container {
            margin-top: 20px;
        }
        .good {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .good .good-info {
            display: flex;
            align-items: center;
        }
        .good .good-info img {
            width: 50px;
            height: 50px;
            margin-right: 10px;
        }
        .good .good-info h3 {
            margin: 0;
        }
        .good .good-info p {
            margin: 5px 0;
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
        function mygood() {

            window.location.href = '/good_add.jsp';

        }
    </script>
</head>
<body>
<h1>我的在售</h1>

<!-- 右侧导航按钮 -->
<div class="nav-buttons" align="right">
    <button onclick="mygood()">我要出售</button>
</div>

<button onclick="window.location.reload();">刷新</button>


<div class="good-container">
    <c:forEach items="${goods}" var="good">
        <div class="good">
            <div class="good-info">
                <img src="image/good_photo/${good.photo}" alt="${good.goodname}">
                <div>
                    <h3>${good.goodname}</h3>
                    <p>余量: ${good.quantity}</p>
                    <p>单价：${good.price}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>