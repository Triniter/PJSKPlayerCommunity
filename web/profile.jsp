<%@ page import="com.pjsk.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Avatar</title>
    <script src="js/jquery-3.6.0.min.js"></script>
</head>
<style>
    a{ color: #c40b00; }

    /* - 侧边栏 */
    .sidebar{
        top: 0;
        left: 0;
        bottom: 0;
        color: #fff;
        width: 250px;
        position: fixed;
        overflow: hidden;
        overflow-y: auto;
        background: #4b4b4b;
    }

    /* -- 头像 */
    img{
        width: 150px;
        height: 150px;
        border: #000 solid 2px;
        display: block;
        margin: 50px auto;
        border-radius: 50%;
        transition: all 2.0s;
    }
    img:hover{
        transform: rotate(1080deg);
    }

    /* -- 侧边栏导航 */
    .sidebar .nav{
        margin: 0;
        display: flex;
        list-style: none;
        flex-direction: column;
    }
    .sidebar .nav a{
        color: #fff;
        padding: 1em;
        display: block;
        text-align: center;
        transition: background .3s, box-shadow .3s;
        text-decoration: none;
    }
    .sidebar .nav a:hover{
        background: rgba(0, 0, 0, .2);
    }

    @media screen and (max-width: 900px) {
        .sidebar {
            width: inherit;
            position: relative;
        }
        .sidebar .nav{
            background: none;
            flex-direction: row;
            justify-content: center;
        }
        .sidebar .nav a:hover{
            background: none;
            box-shadow: 0 -3px 0 #fff inset;
        }
        main{
            margin-left: 0px;

        }
    }

    .title{

        margin: auto;
    }


    .wrap{

        right: 0;
        left: 250px;
        top: 0;
        position: fixed;
        width: 100%;
        height: 100%;
        background-color:cadetblue;



    }
    body{

    }
    .rap{
        background-color:#808080 ;
        opacity:1;

        right: 0px;
        left: 250px;
        bottom: 0;
        top: 200px;
        position: fixed;
    }
    /* 侧边栏和按钮容器样式 */
    .rap {
        text-align: center; /* 使按钮在容器内居中显示 */
        padding: 20px; /* 内边距 */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
        margin-top: 30px; /* 与顶部内容保持一定间距 */
    }

    /* 表格样式重置 */
    .gr {
        width: auto; /* 根据内容自动调整表格宽度 */
        border-collapse: separate; /* 分离表格边框 */
        border-spacing: 10px;
        margin: auto;
    }

    /* 按钮样式 */
    .btn {
        display: inline-block;
        padding: 100px 100px;
        margin: 1px; /* 按钮之间的间距 */
        font-size: 16px; /* 字体大小 */
        color: #fff; /* 字体颜色 */
        background-color: cornflowerblue; /* 按钮背景色 */
        border: none; /* 无边框 */
        border-radius: 5px; /* 圆角边框 */
        text-decoration: none; /* 去除下划线 */
        transition: background-color 0.3s;
        margin: auto;/* 背景色渐变效果 */
    }

    /* 按钮悬浮效果 */
    .btn:hover {
        background-color: #0056b3; /* 鼠标悬浮时的按钮背景色 */
        text-decoration: none; /* 悬浮时保持无下划线 */
    }

    /* 按钮点击效果 */
    .btn:active {
        background-color: #004085; /* 按钮被点击时的背景色 */
    }

    /* 响应式设计 */
    @media (max-width: 768px) {
        .rap td {
            display: block; /* 使每个按钮独占一行 */
        }
    }
</style>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || user.getUsername() == null) {
%>
<script type="text/javascript">
    alert("你没有登录");
    location.href="base.jsp";
</script>
<%
    }
%>
<aside class="sidebar">
    <div class="avatar">

        <img src="image/photo/${user.profile}" title=""/>
    </div>
    <nav class="nav">
        <a href="upload.jsp">修改头像</a>
        <a href="user_modify.jsp">修改信息</a>
        <a href="modifyMessage.jsp">修改留言</a>
        <a href="user_recharge.jsp">我的钱包</a>
    </nav>
</aside>

<main class="main">
    <section id="info" class="infoo">
        <div class="wrap">
            <h2 class="title">个人资料</h2>
            <div class="row">
                    <table>
                        <tr  class="nothing">
                            <td width="15%"  class="nothing">姓名：${user.username}</td>
                            <td width="15%"  class="nothing">电话:${user.tel}</td>
                        </tr>
                        <tr  class="nothing">
                            <td width="15%"  class="nothing"> 余额：${user.balance}</td>
                            <td width="15%"  class="nothing">地址：${user.address}</td>
                        </tr>
                        <tr  class="nothing">
                            <td  class="nothing">个性签名：${user.message}</td>
                        </tr>
                    </table>
            </div>
        </div>
    </section>
    <div class="rap">
        <table class="gr">
            <tr>
                <td>
                    <a href="jump_order_query.jsp" class="btn">我的订单</a>


                </td>
                <td>
                    <a href="jump_good_mine.jsp" class="btn">我的商品</a>
                </td>
                <td>
                    <a href="/my_post" class="btn">我的贴子</a>
                </td>
            </tr>
        </table>
    </div>
</main>
</body>
</html>

