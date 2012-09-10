<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    View Contact

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="cont" items="${requestScope.content}">
    <h4><c:out value="${cont.firstName}"/>
        <c:out value="${cont.middleInitial}"/>
        <c:out value="${cont.lastName}"/></h4><br />

    <p><c:out value="${cont.city}"/>,
       <c:out value="${cont.state}"/>,
       <c:out value="${cont.country}"/><br />
       <c:out value="${cont.zipCode}"/>,
       <c:out value="${cont.address}"/>
    </p>

    <p>Phone: <c:out value="${cont.phone}"/><br />
       Email: <a href="mailto:${cont.email}">${cont.email}</a><br />
       Site: <a href="${cont.website}">${cont.website}</a>
    </p>

</c:forEach>
