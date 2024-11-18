<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
            padding-top: 60px;
        }
        .modal-content {
            background-color: lightcyan;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            text-align: center;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .error {
            color: red;
        }
        .content {
            text-align: center;
        }
        button {
            margin: 5px;
        }
    </style>
    <script>
        function updateTotalPrice() {
            var quantity = document.getElementById("quantity").value;
            var price = parseFloat(document.getElementById("price").innerText);
            var totalPrice = quantity * price;
            document.getElementById("totalPrice").innerText = totalPrice.toFixed(2);
        }

        function checkQuantity(event) {
            var quantity = parseInt(document.getElementById("quantity").value);
            var available = parseInt(document.getElementById("available").innerText);

            if (quantity > available) {
                event.preventDefault();
                alert("购买数量不能大于商品余量。");
            } else {
                openModal('paymentModal');
            }
        }

        function openModal(id) {
            document.getElementById(id).style.display = "block";
            updatePaymentModal();
        }

        function closeModal(id) {
            document.getElementById(id).style.display = "none";
        }

        function updatePaymentModal() {
            var quantity = document.getElementById("quantity").value;
            var price = parseFloat(document.getElementById("price").innerText);
            var totalPrice = quantity * price;
            document.getElementById("paymentTotalPrice").innerText = totalPrice.toFixed(2);
            document.getElementById("paymentQuantity").value = quantity;
            document.getElementById("paymentTotal").value = totalPrice.toFixed(2);
        }

        function checkBalance() {
            var totalPrice = parseFloat(document.getElementById("paymentTotalPrice").innerText);
            var balance = parseFloat(document.getElementById("userBalance").innerText);

            if (balance < totalPrice) {
                alert("余额不足。");
            } else {
                document.getElementById("paymentForm").submit();
            }
        }

        window.onload = function() {
            document.getElementById("quantity").addEventListener("input", updateTotalPrice);
            document.getElementById("purchaseButton").addEventListener("click", checkQuantity);
            updateTotalPrice();
        }
    </script>
</head>
<body>
<div class="content">
    <h1>商品详情</h1>
    <div>
        <img src="image/good_photo/${good.photo}" alt="商品图片" width="200">
    </div>
    <div>
        <h2>${good.goodname}</h2>
        <p>价格：<span id="price">${good.price}</span></p>
        <p>余量：<span id="available">${good.quantity}</span></p>

        <form id="purchaseForm" action="${pageContext.request.contextPath}/purchase" method="POST">
            <input type="hidden" name="goodid" value="${good.goodid}">
            <label for="quantity">数量：</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1">
            <br>
            <p>总价：<span id="totalPrice"></span></p>
            <button type="button" onclick="location.href='/good_query'">返回</button>
            <button type="button" id="purchaseButton">购买</button>
        </form>
    </div>
</div>

<div id="paymentModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal('paymentModal')">&times;</span>
        <h2>付款页面</h2>
        <div>
            <img src="image/good_photo/${good.photo}" alt="商品图片" width="200">
        </div>
        <div>
            <p>总价：<span id="paymentTotalPrice"></span></p>
            <p>余额：<span id="userBalance">${user.balance}</span></p>
            <form id="paymentForm" action="${pageContext.request.contextPath}/create_order" method="POST">
                <input type="hidden" name="goodid" value="${good.goodid}">
                <input type="hidden" name="userid" value="${user.userid}">
                <input type="hidden" id="paymentQuantity" name="quantity" value="">
                <input type="hidden" id="paymentTotal" name="total" value="">
                <input type="hidden" name="rest" value="${good.quantity}">
                <input type="hidden" name="balance" value="${user.balance}">
                <button type="button" onclick="checkBalance()">支付</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>