<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/7
  Time: 6:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${userInfoList}" var="list">
    <div>
    <span>${list.id}</span>
    <span>${list.username}</span>
    <span>${list.password}</span>
    <span>
    <a href="update/${list.id}">修改</a>
    <a href="delete/${list.id}">删除</a>
    </span>
    </div>
</c:forEach>
</body>
</html>
