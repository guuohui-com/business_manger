<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/7
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/insertproductA" method="post" enctype="multipart/form-data">
    <span>产品名称</span>
    <input name="name" />
    <br/>
    <span>类别Id</span>
    <input name="categoryId"  />
    <br/>
    <span>单价：</span>
    <input name="price" />
    <br/>
    <span>stock：</span>
    <input name="stock" />
    <br/>
    <span>status：</span>
    <input name="status" />
    <br/>
    <span>主图片：</span>
    <input name="mainImage" type="file"/>
    <br/>
    <span>子图片：</span>
    <input name="subImage" type="file"/>
    <br/>
    <button>提交</button>
</form>
</body>
</html>
