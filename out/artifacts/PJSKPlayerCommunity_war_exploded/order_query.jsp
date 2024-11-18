<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的订单</title>
    <style>
        .order-container {
            margin-top: 20px;
        }
        .order {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .order .order-info {
            display: flex;
            align-items: center;
        }
        .order .order-info img {
            width: 50px;
            height: 50px;
            margin-right: 10px;
        }
        .order .order-info h3 {
            margin: 0;
        }
        .order .order-info p {
            margin: 5px 0;
        }
        .order .order-link {
            margin-left: auto;
        }
    </style>
</head>
<body>
<h1>我的订单</h1>

<div class="order-container">
    <c:forEach items="${orders}" var="order">
        <div class="order">
            <div class="order-info">
                <img src="image/good_photo/${order.photo}" alt="${order.goodname}">
                <div>
                    <h3>${order.goodname}</h3>
                    <p>数量: ${order.quantity}</p>
                    <p>总价：${order.total}</p>
                    <p>状态: ${order.order_status}</p>
                    <p>下单时间: ${order.ordertime}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
