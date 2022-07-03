<%--
  Created by IntelliJ IDEA.
  User: fzg1987
  Date: 2022/7/3
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Index</h1>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>
                    <a href="/user/deleteById/${user.id}">删除</a>
                    <a href="/user/findById/${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
