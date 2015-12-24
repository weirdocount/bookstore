<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/23
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/commons/queryCondition.jsp" %>
<html>
<head>
    <title>购物车详情</title>
    <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                var flag = confirm("确定要删除" + title + "的信息吗?");

                if(flag){
                    return true;
                }
                return false;
            });

            $(":text").change(function(){
                var numStr = $.trim(this.value);
                var flag = false;

                //正则表达式校验输入是否为数字
                var reg = new RegExp("^[0-9]*$");
                var num = -1;
                if(reg.test(numStr)){
                    num =  parseInt(numStr);
                    if(num >= 0){
                        flag = true;
                    }
                }

                //如果输入不合法则恢复其原来的值
                if(!flag){
                    alert("输入的数量不合法!");
                    $(this).val($(this).attr("class"));
                    return;
                }

                //如果修改的值为0则删除
                var $tr = $(this).parent().parent();
                var idStr = $.trim(this.name);
                //获取标题
                var title = $.trim($tr.find("td:first").text());
                if(num == 0){
                    var flag2 = confirm("确认要删除"+title+"吗？")
                    if(flag2){
                        <%--//bookServlet?method=removeBook&pageNo=${param.pageNo }&id=${item.id }--%>
                        var args = {"method":"removeBook","pageNo":"5","id":idStr}
                        var $a = $tr.find("td:last").find("a");
//                        $a[0].onclick();
                        $.post("bookServlet",args,function(){},"JSON");
                        return;
                    }
                }

                var flag3 = confirm("确定要修改"+title+"的数量吗？");
                if(!flag3){
                    $(this).val($(this).attr("class"));
                    return ;
                }

                var url = "bookServlet";
                var args={"method":"updateBook","id":idStr,"num":num,"time":new Date()};

                $.post(url,args,function(data){
                    var totalNum = data.totalNum;
                    var totalMoney = data.totalMoney;
                    $("#bookNumber").text("您的购物车中共有"+totalNum+ " 本书");
                    $("#totalMoney").text("总金额: ￥ "+totalMoney);

                },"JSON")
            });
        })
    </script>
</head>
<body>
    <c:if test="${!empty sessionScope.cart}">
        <table align="center">
            <tr>
                <td align="center">
                    <div id="bookNumber">您的购物车中共有 ${sessionScope.cart.totalNum} 本书</div>
                </td>
            </tr>

            <tr>
                <td>Title</td>
                <td>Num</td>
                <td>Price</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.title}</td>
                    <td>
                        <input class="${item.num }" type="text" size="1" name="${item.id }" value="${item.num }"/>
                    </td>
                    <td>${item.price}</td>
                    <td><a href="bookServlet?method=removeBook&pageNo=${param.pageNo }&id=${item.id }" class="delete">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" id="totalMoney">总金额: ￥ ${ sessionScope.cart.totalMoney}</td>
            </tr>

            <tr>
                <td colspan="4">
                    <a href="bookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>
                    &nbsp;&nbsp;

                    <a href="bookServlet?method=clearBook">清空购物车</a>
                    &nbsp;&nbsp;

                    <a href="">结账</a>
                    &nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </c:if>
</body>
</html>
