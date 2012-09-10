<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    View Experience

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="cont" items="${requestScope.content}">
    <h4><c:out value="${cont.company}"/>,
        <c:out value="${cont.country}"/>,
        <c:out value="${cont.state}"/>,
        <c:out value="${cont.city}"/><br />
        <c:out value="${cont.start}"/> - <c:out value="${cont.end}"/>
    </h4><br />

    <p><c:out value="${cont.position}"/>
    </p>

    <p><c:out value="${cont.content}"/>
    </p>

    <br />
</c:forEach>