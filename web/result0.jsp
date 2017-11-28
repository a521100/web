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
    <title>下载总数据页面</title>

    <script type="text/javascript">
        function getc()
        {
            document.myform.action="servlet/ServletDown?filename=ShuJu"
            document.myform.method="post"
        }
    </script>
</head>
<body>

<div class="table-form service-form">
    <form id="searchForm" action="/servlet/ServletDown?filename=ShuJu" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-cell">
            <tbody>
            <tr>
                <td>
                    <input type="submit" onclick="getc()"  value="下载" style="width:50px;height:30px;"/>
                </td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>
