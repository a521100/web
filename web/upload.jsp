<%--
  Created by IntelliJ IDEA.
  User: bingo
  Date: 2017/10/12
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>上传页面</title>
    <meta charset="utf-8">
    <meta name="description" content="login">
    <meta name="author" content="yourname">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form class="login" name="myform" action="servlet/ServletUpload" enctype="multipart/form-data" method="post">
    上传文件:<input type="file" name="file1"><br/>
    <input type="submit" value="提交" class="login-sub">

</form>
</body>
</html>
