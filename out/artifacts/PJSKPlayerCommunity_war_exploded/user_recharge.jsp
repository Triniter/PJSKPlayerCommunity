<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值页面</title>
    <style>
        /* Modal styles */
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
            text-align: center;
        }
        .modal-content {
            background-color: lightcyan;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 20%;
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
        .content {
            text-align: center;
        }
    </style>
    <script>
        function openModal() {
            document.getElementById('confirmModal').style.display = 'block';
        }

        function closeModal() {
            document.getElementById('confirmModal').style.display = 'none';
        }

        function confirmRecharge() {
            document.getElementById('rechargeForm').submit();
        }
    </script>
</head>
<body>
<div class="content">
    <h1>充值页面</h1>
    <form id="rechargeForm" action="/user_recharge" method="POST">
        <input type="hidden" name="userid" value="${user.userid}">
        <p>用户名：${user.username}</p>
        <p>余额：${user.balance}</p>
        <label for="amount">充值金额：</label>
        <input type="number" id="amount" name="amount" min="1" max="1000" required>
        <input type="hidden" id="balance" name="balance" value="${user.balance}">
        <br><br>
        <button type="button" onclick="openModal()">充值</button>
    </form>
</div>

<!-- The Confirm Modal -->
<div id="confirmModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>确认充值</h2>
        <button type="button" onclick="confirmRecharge()">确认</button>
        <button type="button" onclick="closeModal()">取消</button>
    </div>
</div>
</body>
</html>