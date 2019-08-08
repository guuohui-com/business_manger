<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/7
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/updateproductA" method="post">
    <input name="id" type="hidden" value="${product.id}">
    <br/>
    <span>产品名称</span>
    <input name="name" value="${product.name}"/>
    <br/>
    <span>类别Id</span>
    <input name="categoryId"  value="${product.categoryId}"/>
    <br/>
    <span>单价：</span>
    <input name="price" value="${product.price}"/>
    <br/>
    <span>stock：</span>
    <input name="stock" value="${product.stock}"/>
    <br/>
    <span>status：</span>
    <input name="status" value="${product.status}"/>
    <br/>
    <%--<span>主图：</span>
    <img src="/uplodpic/${product.mainImage}">
    <br/>
    <span>子图：</span>
    <img src="/uplodpic/${product.subImage}">
    <br/>--%>
    <button>提交</button>
</form>
</body>
</html>
