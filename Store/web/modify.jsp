<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改商品</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        table {
            border-collapse: collapse;
        }

        .boder {
            border: 1px solid #5B96D0;
        }

        .col1 {
            background-color: #A6D2FF;
            text-align: right;
            padding-right: 10px;
            border: 1px solid #5B96D0;
            line-height: 50px;
        }

        .col2 {
            padding-left: 10px;
            border: 1px solid #5B96D0;
            line-height: 50px;
        }

        .textfield {
            height: 20px;
            width: 200px;
            border: 1px solid #999999;
            text-align: left;
            font-size: medium;
            line-height: 50px;
        }
    </style>

    <script>

        function verify(myform) {
            var errorMsg = "";
            if (myform.name.value == "") {
                errorMsg += "商品名称不能为空！\n";
            }
            if (myform.price.value == "") {
                errorMsg += "商品价格不能为空！\n";
            }
            if (myform.storage.value =="") {
                errorMsg += "库存不能为空\n";
            }

            if (errorMsg == "") {
                return true;
            } else {
                alert(errorMsg);
                return false;
            }
        }

    </script>
</head>

<body>
<div>添加或修改商品</div>
<br>
<hr width="100%"/>
<div class="text3" align="center">请填写下列信息</div>
<br>
<%--显示错误消息--%>
<ul>
    <c:forEach var="error" items="${errors}">
        <li class="error">${error}</li>
    </c:forEach>
</ul>
<form action="controller" method="post" onsubmit="return verify(this)" >
    <table width="60%" border="0" align="center" class="boder">
        <tr>
            <td width="35%" height="27" class="col1">商品名称：</td>
            <td class="col2"><input type="text" name="name" value="${goods.name}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">商品价格：</td>
            <td class="col2"><input type="text" name="price" value="${goods.price}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">商品描述：</td>
            <td class="col2"><input type="text" name="description" value="${goods.description}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">品牌：</td>
            <td class="col2"><input type="text" name="brand" value="${goods.brand}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">CPU品牌：</td>
            <td class="col2"><input type="text" name="cpu_brand" value="${goods.cpuBrand}"/>
            </td>
        </tr>
        <tr>
            <td height="27" class="col1">CPU型号：</td>
            <td class="col2"><input type="text" name="cpu_type" value="${goods.cpuType}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">内存大小：</td>
            <td class="col2"><input type="text" name="memory_capacity" value="${goods.memoryCapacity}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">硬盘大小：</td>
            <td class="col2"><input type="text" name="hd_capacity" value="${goods.hdCapacity}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">显卡型号：</td>
            <td class="col2"><input type="text" name="card_model" value="${goods.cardModel}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">显示屏尺寸大小：</td>
            <td class="col2"><input type="text" name="displaysize" value="${goods.displaysize}"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">库存：</td>
            <td class="col2"><input type="text" name="storage" value="${goods.storage}"/>*</td>
        </tr>

    </table>
    <br>
    <div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="id" value="${goods.id}" />
    <input type="hidden" name="image" value="${goods.image}" />
    <input type="hidden" name="action" value="${modify}" />
    </form>

</body>
</html>
