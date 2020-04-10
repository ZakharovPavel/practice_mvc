<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feejie
  Date: 12/03/20
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty product.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty product.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty product.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty product.title}">
    <c:url value="/edit" var="var"/>
</c:if>

<form action="${var}" method="post">
    <c:if test="${!empty product.title}">
        <input type="hidden" name="id" value="${product.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title">
    <label for="cost">Cost</label>
    <input type="text" name="cost" id="cost">
    <c:if test="${empty product.title}">
        <input type="submit" value="Add new product">
    </c:if>
    <c:if test="${!empty product.title}">
        <input type="submit" value="Edit product">
    </c:if>
</form>
</body>
</html>
