<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/23
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center">
        <tr>
            <td align="center">
                <c:if test="${!empty requestScope.msg}">
                    <font color="red">${requestScope.msg}</font>
                </c:if>
                <br>
                <a href="${pageContext.request.contextPath}/bookServlet?method=getBooks">继续浏览</a>
            </td>
        </tr>
    </table>
</body>
</html>
