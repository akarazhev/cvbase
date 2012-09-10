<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Add Contact

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<div id="column">
    <form method="post" action="main.page">      
        <input type="hidden" name="id" value="contact">
        <input type="hidden" name="command" id="cmd" value=""/>

        <p><t:tooltip element="First Name:" content="Candidate's first name. Example: Andrej"/>
            <input type="text" name="firstName" value="${requestScope.model.firstName}"><br />
            <t:tooltip element="Middle Initial:" content="Candidate's middle initial. Example: A"/>
            <input type="text" name="middleInitial" value="${requestScope.model.middleInitial}"><br />
            <t:tooltip element="Last Name:" content="Candidate's last name. Example: Karazhev"/>
            <input type="text" name="lastName" value="${requestScope.model.lastName}">
        </p>

        <p><t:tooltip element="Country:" content="Candidate's country. Example: Belarus"/>
            <input type="text" name="country" value="${requestScope.model.country}"><br />
            <t:tooltip element="City:" content="Candidate's city. Example: Minsk"/>
            <input type="text" name="city" value="${requestScope.model.city}"><br />
            <t:tooltip element="State:" content="Candidate's state."/>
            <input type="text" name="state" value="${requestScope.model.state}"><br />
            <t:tooltip element="Zip Code:" content="Candidate's zip code."/>
            <input type="text" name="zipCode" value="${requestScope.model.zipCode}"><br />
            <t:tooltip element="Address:" content="Candidate's address."/>
            <input type="text" name="address" value="${requestScope.model.address}"><br />
        </p>

        <p><t:tooltip element="Phone:" content="Candidate's phone number."/>
            <input type="text" name="phone" value="${requestScope.model.phone}"><br />
            <t:tooltip element="Email:" content="Candidate's email address."/>
            <input type="text" name="email" value="${requestScope.model.email}"><br />
            <t:tooltip element="Site:" content="Candidate's web site.
                    Example: http://www.linkedin.com/pub/andrey-karazhev/49/89a/a7a"/>
            <input type="text" name="website" value="${requestScope.model.website}"><br />
        </p>

        <jsp:include page="../../jspf/nextcomplete.jspf"/>
    </form>
</div>