<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.08.2017
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
</head>
<body>
        <h2>All users.</h2>

        <c:forEach items="${allUsers}" var="user">

            <p>${user}</p>

        </c:forEach>
</body>
</html>
