<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/22
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍详细信息</title>
    <%@ include file="/commons/queryCondition.jsp" %>
</head>
<body>
    <table align="center">
        <br><br>
        Title: ${book.title }
        <br><br>
        Author: ${book.author}
        <br><br>
        Price: ${book.price}
        <br><br>
        PublishingDate: ${book.publishingdate}
        <br><br>
        Remark: ${book.remark}
        <br><br>

        <a href="bookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>
    </table>
</body>
</html>
