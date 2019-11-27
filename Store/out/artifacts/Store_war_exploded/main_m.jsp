<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>网上电脑商城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        a:link {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }

        a:visited {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }

        a:hover {
            font-size: 18px;
            color: #DB8400;
            text-decoration: underline;
            font-weight: bolder;
        }
    </style>
</head>

<body>
<div class="header">网上电脑商城</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/> <a href="controller?action=list">商品列表</a></p>
    <p class="text2"> 您可以从产品列表中选择商品进行修改 </p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/mycar1.jpg" align="absmiddle"/> <a href="controller?action=modify">添加商品</a></p>
    <p class="text2"> 您可以添加新的商品 </p>
</div>

</body>
</html>
