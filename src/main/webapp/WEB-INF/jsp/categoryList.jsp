<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/6
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body
<c:forEach items="${categoryList}" var="list">
    <div>
        <span>${list.id}</span>
        <span>${list.name}</span>
        <span>${list.parentId}</span>
        <span>${list.status}</span>
        <span>${list.createTime}</span>
        <span>
            <a href="update/${list.id}">修改</a>
            <a href="delete/${list.id}">删除</a>
        </span>
    </div>
</c:forEach>
</body>
</html>
