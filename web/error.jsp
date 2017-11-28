<%--
  Created by IntelliJ IDEA.
  User: bingo
  Date: 2017/11/2
  Time: 14:27
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
    <title>登录失败页面</title>
    <meta charset="utf-8">
    <meta name="description" content="login">
    <meta name="author" content="yourname">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

<form class="login" name="myform" action="servlet/ServletLogin" method="post">
    用户名或密码错误，请重新登录！<br/>
    <br>
    用户名：
    <input type="text" name="username" placeholder="请输入用户名" class="login-form" id="username">
    密码：
    <input type="password" name="password" placeholder="请输入密码" class="login-form" id="password">
    <input type="submit" value="登录" class="login-sub">
</form>
</body>
</html>

