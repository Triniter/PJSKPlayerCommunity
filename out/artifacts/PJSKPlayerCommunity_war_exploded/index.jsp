<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pjsk.entity.User" %>
<%@ page import="java.util.logging.ErrorManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Default Page</title>
  <style>
    body {
      text-align: center;
      font-family: Arial, sans-serif;
      background-image: url("image/indexBG.png");
      background-attachment: fixed;
    }
    .profile {
      width: 20px;
      height: 20px;
      border-radius: 50%;
    }
    .basetable {
      width: 70%;
      align: center;
      background-color: rgba(12,23,43,0.5);
    }
    .user {
      text-align: right;
      vertical-align: top;
      text-decoration: none;
    }
    .nav a {
      margin: 0 15px;
      text-decoration: none;
      color: blue;
      font-size: 18px;
      padding: 10px 20px;
      display: inline-block;
      border-radius: 10px;
    }
    .nav a.active {
      background-color: cornflowerblue;
      color: white;
    }
    .content {
      margin-top: 20px;
    }
    iframe {
      width: 100%;
      height: 600px;
      border: none;
    }
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
      width: 20%;
    }
    .modal-content-r {
      background-color: lightcyan;
      margin: 5% auto;
      padding: 20px;
      border: 1px solid #888;
      width: 40%;
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
    .error{
      color: red;
      font-weight: bold;
      text-align: center;
    }
  </style>
  <script src="js/jquery-3.6.0.min.js"></script>
  <script>
    function setActive(link) {

      var links = document.querySelectorAll('.nav a');
      links.forEach(function(l) {
        l.classList.remove('active');
      });
      link.classList.add('active');
    }
    function openLoginModal() {
      document.getElementById('loginModal').style.display = "block";
    }

    function closeLoginModal() {
      document.getElementById('loginModal').style.display = "none";

    }

    function openRegisterModal() {
      document.getElementById('registerModal').style.display = "block";
    }

    function closeRegisterModal() {
      document.getElementById('registerModal').style.display = "none";
    }

    function checkUsername() {
      var username = document.getElementById("username");
      var usernameResult = document.getElementById("usernameResult");
      if(username.value.length<5 || username.value.length>8){
        usernameResult.innerHTML = "<font color='red'><b>用户名长度为5~8个字符</b></font>";
        return false;
      }else{
        var result = "";
        $.ajax({
          type: "get",
          url: "/check_username",
          data: "username=" + username.value,
          success: function (data) {
            if (data=="no") {
              usernameResult.innerHTML = "<font color='red'><b>用户名已存在</b></font>";
            } else {
              usernameResult.innerHTML = "<img src='image/yes.gif'/>";
            }
            result = data;
          },
          async: false
        })
        return result=="yes";
      }
    }

    function checkPassword() {
      var password = document.getElementById("password");
      var passwordResult = document.getElementById("passwordResult");
      if (password.value.length==0) {
        passwordResult.innerHTML = "<font color='red'><b>密码不能为空</b></font>";
        return false;
      } else if (password.value.length>20) {
        passwordResult.innerHTML = "<font color='red'><b>密码过长</b></font>";
        return false;
      } else {
        passwordResult.innerHTML = "<img src='image/yes.gif'/>";
        return true;
      }
    }

    function checkPasswordConfig() {
      var password = document.getElementById("password");
      var passwordConfig = document.getElementById("passwordConfig");
      var passwordConfigResult = document.getElementById("passwordConfigResult");
      if (password.value!=passwordConfig.value) {
        passwordConfigResult.innerHTML = "<font color='red'><b>两次输入密码不一致</b></font>";
        return false;
      } else if (passwordConfig.value.length==0){
        passwordConfigResult.innerHTML = "";
      } else {
        passwordConfigResult.innerHTML = "<img src='image/yes.gif'/>";
        return true;
      }
    }
    function checkTel() {
      var tel = document.getElementById("tel");
      var telResult = document.getElementById("telResult");
      if (tel.value.length>20) {
        telResult.innerHTML = "<font color='red'><b>电话号码过长</b></font>";
        return false;
      } else if (tel.value.length==0){
        telResult.innerHTML = "";
        return true;
      } else {
        telResult.innerHTML = "<img src='image/yes.gif'/>";
        return true;
      }
    }

    function checkAddress() {
      var address = document.getElementById("address");
      var addressResult = document.getElementById("addressResult");
      if (address.value.length>255) {
        addressResult.innerHTML = "<font color='red'><b>地址过长</b></font>";
        return false;
      } else if (address.value.length==0){
        addressResult.innerHTML = "";
        return true;
      } else {
        addressResult.innerHTML = "<img src='image/yes.gif'/>";
        return true;
      }
    }
    function checkRegister() {
      checkUsername();
      checkPassword();
      checkPasswordConfig();
      checkTel();
      checkAddress()
      return  checkUsername() &&checkPassword() &&checkPasswordConfig() &&checkTel() && checkAddress();
    }
    function checkLogin() {

    }
  </script>
</head>
<body>
<center>
  <table class="basetable">
    <tr>
      <td colspan="3">
        <img src="image/logo.png" alt="Logo" width="300">
      </td>
      <td class="user">
        <c:choose>
          <c:when test="${sessionScope.user!=null}">
            <span><img src="image/photo/${user.profile}" class="profile">${user.username}</span>
            <a class="user" href="/user_logout">登出</a>
          </c:when>
          <c:otherwise>
            <a class="user" href="javascript:void(0)" onclick="openLoginModal()">登录</a>
          </c:otherwise>
        </c:choose>

      </td>
    </tr>
    <tr align="center" class="nav">
      <td>
        <a href="base.jsp" target="contentFrame" onclick="setActive(this)">主页</a>
      </td>
      <td>
        <a href="/post" target="contentFrame" onclick="setActive(this)">论坛</a>
      </td>
      <td>
        <a href="/good_query" target="contentFrame" onclick="setActive(this)">购物</a>
      </td>
      <td>
        <a href="profile.jsp" target="contentFrame" onclick="setActive(this)">个人Home</a>
      </td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <div class="content">
          <iframe name="contentFrame"></iframe>
        </div>
      </td>
    </tr>
  </table>

  <div id="loginModal" class="modal">


    <div class="modal-content">
      <span class="close" onclick="closeLoginModal()">&times;</span><br/>
      <h3>用户登录</h3>
      <table>
        <form action="/user_login" method="post">
          <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
          </tr>
          <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"></td>
          </tr>
        </form>
        <form action="/jump_register" method="post">
          <tr>
            <td colspan="2" align="center"><input type="hidden" name="register" value="1"><input type="submit" value="注册"></td>
          </tr>
        </form>
      </table>
      <div class="error">${loginError}</div>
    </div>
  </div>
  <c:if test="${loginError!=null || loginJump!=null}">
    <script>
      openLoginModal();
    </script>
  </c:if>

  <div id="registerModal" class="modal">
    <div class="modal-content-r" >
      <span class="close" onclick="closeRegisterModal()">&times;</span><br/>
      <h3>用户注册</h3>
      <table>
        <form action="/user_register" method="post"  onsubmit="return checkRegister()">
          <tr>
            <td>用户名</td>
            <td><input type="text" id="username" name="username" onblur="checkUsername()"></td>
            <td  width="200"><span id="usernameResult"></span></td>
          </tr>
          <tr>
            <td>密码</td>
            <td><input type="password" id="password" name="password" onblur="checkPassword()"></td>
            <td><span id="passwordResult"></span></td>
          </tr>
          <tr>
            <td>确认密码</td>
            <td><input type="password" id="passwordConfig" name="passwordConfig" onblur="checkPasswordConfig()"></td>
            <td><span id="passwordConfigResult"></span></td>
          </tr>
          <tr>
            <td>电话</td>
            <td><input type="text" id="tel" name="tel" onblur="checkTel()"></td>
            <td><span id="telResult"></span></td>
          </tr>
          <tr>
            <td>地址</td>
            <td><input type="text" id="address" name="address" onblur="checkAddress()"></td>
            <td><span id="addressResult"></span></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
          </tr>
        </form>
      </table>
    </div>
  </div>
  <c:if test= "${registerJump!=null}">
    <script>
      closeLoginModal();
      openRegisterModal();
    </script>
  </c:if>
  <c:remove var="registerJump" scope="session"/>
  <c:remove var="loginError" scope="session"/>
  <c:remove var="loginJump" scope="session"/>
</center>

</body>
</html>
