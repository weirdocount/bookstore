<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/21
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyBook</title>
    <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#pageNo").change(function(){
                var val = $(this).val();
                val = $.trim(val);

                //1. 校验 val 是否为数字 1, 2, 而不是 a12, b
                var flag = false;
                var reg = /^\d+$/g;
                var pageNo = 0;

                if(reg.test(val)){
                    //2. 校验 val 在一个合法的范围内： 1-totalPageNumber
                    pageNo = parseInt(val);
                    if(pageNo >= 1 && pageNo <= parseInt("${bookResult.totalPages}")){
                        flag = true;
                    }

                    if(!flag){
                        alert("输入的不是合法的页码.");
                        $(this).val("");
                        return;
                    }

                    //3. 页面跳转
                    var price = "&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}";
                    var href = "bookServlet?method=getBooks&pageNo=" + pageNo+price;
                    window.location.href = href;
                }
            })

        })

    </script>
    <%@ include file="/commons/queryCondition.jsp" %>
</head>
<body>

    <table align="center" cellpadding="10">
        <tr>
            <td align="center" >
                <c:if test="${param.title != null}">
                    您已经将 ${param.title} 放入到购物车中.
                    <br><br>
                </c:if>

                <c:if test="${!empty sessionScope.cart.map }">
                    您的购物车中有 ${sessionScope.cart.totalNum} 本书, <a href="bookServlet?method=forward&dest=cart&pageNo=${bookpage.pageNo }">查看购物车</a>
                </c:if>
            </td>
        </tr>
        <tr>
            <td align="center">
                <c:if test="${empty requestScope.bookResult}">
                    <font color="red">未找到您想要的数据，请重新搜索！</font>
                </c:if>
            </td>
        </tr>
        <tr>
            <td align="center">
                <table align="center" cellpadding="10">
                    <form action="bookServlet?method=getBooks" method="post">
                        Price:
                        <input type="text" size="1" name="minPrice"/> -
                        <input type="text" size="1" name="maxPrice"/>

                        <input type="submit" value="查询"/>
                    </form>
                </table>
            </td>
        </tr>

        <tr>
            <td align="center">
            <table align="center" cellpadding="10">
                    <c:forEach var="book" items="${bookResult.books }">
                        <tr>
                            <td>
                                <a href="bookServlet?method=getBook&pageNo=${bookResult.pageNo}&id=${book.id}">${book.title}</a>
                                <br>
                                    ${book.author }
                            </td>
                            <td>${book.price}</td>
                            <td><a href="bookServlet?method=buyBook&pageNo=${bookResult.pageNo}&id=${book.id}&title=${book.title}">加入购物车</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

        <tr>
            <td align="center">
                <c:if test="${!empty requestScope.bookResult}">
                    <table align="center" cellpadding="10">
                        共 ${bookResult.totalPages } 页
                        &nbsp;
                        当前第 ${bookResult.pageNo } 页
                        &nbsp;

                        <c:if test="${bookResult.pageNo > 1 }">
                            <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
                            &nbsp;
                            <a href="bookServlet?method=getBooks&pageNo=${bookResult.pageNo-1}">上一页</a>
                        </c:if>
                        &nbsp;
                        <c:if test="${bookResult.pageNo < bookResult.totalPages }">
                            <a href="bookServlet?method=getBooks&pageNo=${bookResult.pageNo+1 }">下一页</a>
                            &nbsp;
                            <a href="bookServlet?method=getBooks&pageNo=${bookResult.totalPages }">末页</a>
                        </c:if>
                        &nbsp;
                        转到 <input type="text" size="1" id="pageNo"/> 页
                    </table>
                </c:if>
            </td>
        </tr>
    </table>

</body>
</html>
