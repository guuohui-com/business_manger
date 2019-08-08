<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/6
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改类别</title>
</head>
<body>

<form action="" method="post">
    <input type="hidden" name="id" value="${category.id}"><br/>
    名称<input type="text" name="name" value="${category.name}"><br/>
    父类id<input type="text" name="parentId" value="${category.parentId}"><br/>
    类别状态<input type="text" name="status" value="${category.status}"><br/>

    <button>修改</button>
</form>
</body>
</html>
