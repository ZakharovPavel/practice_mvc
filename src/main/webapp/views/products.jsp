<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feejie
  Date: 11/03/20
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h2>Products</h2>

<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>cost</th>
        <th>action</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.title}</td>
            <td>${product.cost}</td>
            <td>
                <a href="/edit/${product.id}">edit</a>
                <a href="/delete/${product.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new product</a>
</body>
</html>
