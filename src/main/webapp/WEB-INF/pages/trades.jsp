<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>交易详情</title>
</head>
<body>
    <table align="center">
        <tr>
            <td align="center">
                <h4>${param.username}</h4>
            </td>
        </tr>
        <tr>
            <c:forEach var="trade" items="${trades}">
                <tr>
                    <td colspan="3">TradTime: ${trade.date }</td>
                </tr>
                <c:forEach var="tradeItem" items="${trade.tradeItems}">
                    <tr>
                        <td>${tradeItem.book.title }</td>
                        <td>${tradeItem.book.price }</td>
                        <td>${tradeItem.num}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
            <br>
        </tr>
    </table>
</body>
</html>
