<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Content

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="../js/cvbase.js"></script>
<table>
    <tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>Email</th><th>Profile</th><th>Action</th></tr>
    <c:forEach var="cont" items="${requestScope.content}">
        <tr>
            <td><c:out value="${cont.firstName}"/></td>
        <td><c:out value="${cont.lastName}"/></td>
        <td><c:out value="${cont.phone}"/></td>
        <td><c:out value="${cont.email}"/></td>
        <td><a href="main.page?profile=${cont.profile}&page=contact">view</a></td>
        <td><a href="main.page?profile=${cont.profile}&operation=delete" id="${cont.profile}"
               onclick="confirmDelete('${cont.profile}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
<p><c:out value="${requestScope.size}"/> record(s) found in base.</p>
