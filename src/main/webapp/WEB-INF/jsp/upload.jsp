<%--
  Created by IntelliJ IDEA.
  User: df
  Date: 2019/8/5
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
文件上传<input type="file" name="picfile"/>
    <br/>
    <button>提交</button>
</form>
</body>
</html>
