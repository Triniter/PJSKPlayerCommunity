<%@ page import="com.pjsk.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>添加商品</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>

        //检查是否选择文件
        function checkSelectFile() {

            var file = document.getElementById("file");

            if(file.value==""){
                alert("必须上传商品图片");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<h3 align="center">添加商品</h3>

<table align="center">
    <form action="/good_add?userid=${user.userid}" method="post" enctype="multipart/form-data" onsubmit="return checkSelectFile()">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="goodname"></td>
        </tr>

        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price"/></td>
        </tr>

        <tr>
            <td>商品数量</td>
            <td><input type="text" name="quantity"/></td>
        </tr>

        <tr>
            <td>商品图片</td>
            <td><input type="file" name="file" id="file"></td>
        </tr>


        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="立即上架"/>
            </td>
        </tr>

    </form>
</table>

</body>
</html>
