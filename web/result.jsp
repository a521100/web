<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
  Created by IntelliJ IDEA.
  User: bingo
  Date: 2017/10/19
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>下载页面</title>
    <script type="text/javascript">
        function getcity()
        {
            document.myform.action="servlet/ServletTwo"
            document.myform.method="post"
        }
    </script>
</head>

<body background="<%=basePath%>/img/10.jpg">
<div style="margin: 200px 100px auto 560px;">
    <form id="searchForm" action="/servlet/ServletTwo" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-cell">
            <tbody>
            <tr>
                <td>
                    <div class="">
                        欢迎您：${sessionScope.username}<br/>
                        <h2>下载文件</h2>
                        地区：
                        <select name="filename" id="filename" >
                            <option value="南昌市">南昌市</option>
                            <option value="九江市">九江市</option>
                            <option value="赣州市">赣州市</option>
                            <option value="宜春市">宜春市</option>
                            <option value="吉安市">吉安市</option>
                            <option value="抚州市">抚州市</option>
                            <option value="鹰潭市">鹰潭市</option>
                            <option value="新余市">新余市</option>
                            <option value="萍乡市">萍乡市</option>
                            <option value="上饶市">上饶市</option>
                            <option value="景德镇市">景德镇市</option>
                        </select>
                        <input type="submit" onclick="getcity()"  value="下载" style="width:50px;height:30px;"/>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>



