<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
        function checkUsername() {
            var username = document.getElementById("username");
            var userid = document.getElementById("userid");
            var usernameResult = document.getElementById("usernameResult");
            if(username.value.length<5 || username.value.length>8){
                usernameResult.innerHTML = "<font color='red'><b>用户名长度为5~8个字符</b></font>";
                return false;
            }else{
                var result = "";
                $.ajax({
                    type: "get",
                    url: "/check_modify_username",
                    data: "userid=" + userid.value +"&username=" + username.value,
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
        function checkModify() {
            checkUsername();
            checkPassword();
            checkTel();
            checkAddress()
            return  checkUsername() &&checkPassword() &&checkTel() && checkAddress();
        }
    </script>

</head>
<body>
<table>
    <form action="/user_modify" method="post"  onsubmit="return checkModify()">
        <tr>
            <td>用户名</td>
            <td><input type="text" id="username" name="username" value="${user.username}" onblur="checkUsername()"></td>
            <td  width="200"><span id="usernameResult"></span></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" id="password" name="password" value="${user.password}" onblur="checkPassword()"></td>
            <td><span id="passwordResult"></span></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" id="tel" name="tel" value="${user.tel}" onblur="checkTel()"></td>
            <td><span id="telResult"></span></td>
        </tr>
        <tr>
            <td>地址</td>
            <td>
                <input type="text" id="address" name="address" value="${user.address}" onblur="checkAddress()">
                <input type="hidden" id="userid" name="userid" value="${user.userid}">
            </td>
            <td><span id="addressResult"></span></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="修改"></td>
        </tr>
    </form>
</table>
</body>
</html>
