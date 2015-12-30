<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/30
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单查询</title>
</head>
<body>
    <form action="bookServlet?method=getTrades" method="post">
        <input type="text" name="username">
        <input type="submit" value="提交">
    </form>
</body>
</html>
