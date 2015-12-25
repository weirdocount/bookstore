<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/25
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>支付订单</title>
</head>
<body>

    <table align="center">
        <tr>
            <td align="center">
                <c:if test="${!empty requestScope.msg}">
                    <font color="red">${requestScope.msg}</font>
                </c:if>
            </td>
        </tr>
    </table>

    <table align="center">
        <tr>
            <td align="center">
                您的购物车中共有 ${sessionScope.cart.totalNum} 本书
            </td>
        </tr>
        <tr>
            <td align="center">
                共记￥${sessionScope.cart.totalMoney}
            </td>
        </tr>
        <tr>
            <td align="center">
                <form action="bookServlet?method=cash" method="post">
                    <table cellpadding="10">
                        <tr>
                            <td>信用卡姓名:</td>
                            <td><input type="text" name="username"/></td>
                        </tr>
                        <tr>
                            <td>信用卡账号:</td>
                            <td><input type="text" name="accountId"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Submit"/></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
