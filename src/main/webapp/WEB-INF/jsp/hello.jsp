<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/2
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello SpringMvc</h1>
<c:forEach items="${productList}" var="list">
    <div>
        <span>${list.name}</span>
        <a href="/updateproducrB/${list.id}">修改</a>
        <a href="/deleteproduct/${list.id}">删除</a>
        <a href="/insertproductB">插入</a>
    </div>
    <%--<span>${list.categoryId}</span>--%>
</c:forEach>
</body>
</html>
