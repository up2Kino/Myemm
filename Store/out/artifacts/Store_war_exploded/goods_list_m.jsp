<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品列表</title>
</head>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
    table {
        border-collapse: collapse;
    }

    /*商品列表第1列*/
    .col1 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-indent: 40px
    }

    /*商品列表第2列*/
    .col2 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
    }

    /*商品列表第3列*/
    .col3 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }

    /*商品列表第4列*/
    .col4 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }
</style>
<body>
<table width="100%" border="0" align="center">
    <tr>
        <td width="616"><img src="images/list.jpg" align="absmiddle"/></td>
        <td width="734" align="right">
            | <a href="controller?action=list">商品列表</a>
            | <a href="controller?action=logout">帐户注销</a>
        </td>
    </tr>
</table>
<hr width="100%"/>
<div class="text3" align="center">请从商品列表中选择商品</div>
<br>
<table width="100%" border="0" align="center">
    <tr bgcolor="#b4c8ed">
        <th>商品名称</th>
        <th width="5%">商品价格</th>
        <th width="15%">商品库存</th>
        <th width="15%">修改商品信息</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}" varStatus="status">
        <tr
                <c:if test="${status.index % 2 == 0}">
                    bgcolor='#ffffff'
                </c:if>
                <c:if test="${status.index % 2 != 0}">
                    bgcolor='#edf8ff'
                </c:if>
        >
            <td class="col1"><a href="controller?action=detail&id=${goods.id}">${goods.description}</a></td>
            <td class="col2">￥${goods.price}</td>
            <td class="col3">${goods.storage}</td>
            <td class="col4"><a href="controller?action=change_goods&pagename=list&id=${goods.id}">修改</a></td>
        </tr>
    </c:forEach>

</table>

<hr/>
<div align="center">
    <ul class="pagination">

        <li><a href="controller?action=paging&page=prev">«</a></li>
        <c:forEach var="page" begin="1" end="${totalPageNumber}">
            <li><a
                    <c:if test="${page == currentPage}">
                        class="active"
                    </c:if>
                    href="controller?action=paging&page=${page}">${page}</a></li>
        </c:forEach>
        <li><a href="controller?action=paging&page=next">»</a></li>
    </ul>
</div>

</body>
</html>
