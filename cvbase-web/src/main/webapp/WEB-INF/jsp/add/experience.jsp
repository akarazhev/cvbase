<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Add Experience

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<form method="post" action="main.page">
    <input type="hidden" name="id" value="experience">
    <input type="hidden" name="command" id="cmd" value=""/>

    <div id="column">

        <p><t:tooltip element="Company:" content="Company where candidate has worked."/>
            <input type="text" name="company" value="${requestScope.model.company}"><br />
            <t:tooltip element="Country:" content="Country where company is. Example: Belarus"/>
            <input type="text" name="country" value="${requestScope.model.country}"><br />
            <t:tooltip element="City:" content="City where company is. Example: Minsk"/>
            <input type="text" name="city" value="${requestScope.model.city}"><br />
            <t:tooltip element="State:" content="State where company is."/>
            <input type="text" name="state" value="${requestScope.model.state}"><br />
        </p>

        <p><t:tooltip element="Start:" content="When candidate started to work. Example: August, 2007"/>
            <input type="text" name="start" value="${requestScope.model.start}"><br />
            <t:tooltip element="End:" content="When candidate finished to work or has been working. Example: June, 2011"/>
            <input type="text" name="end" value="${requestScope.model.end}"><br />
        </p>

        <p><t:tooltip element="Position:" content="The occupied position. Example: Software Engineer"/>
            <input type="text" name="position" value="${requestScope.model.position}">
        </p>

    </div>   

    <div id="list">

        <p><t:tooltip element="Details content:" content="Note: Html tags can be used.<br />Example:<br /><br />
                   Details:<br />
                   LA6112AX is product for managing SI3000 Peso. 
                   The SI3000 Peso is 32 POTS port VoIP terminal adapter (Gateway).<br /><br />
                   Responsibilities:<br />
                   - Wrote a functional specification, design document.<br />
                   - Implemented java beans, handlers, components and controllers 
                   to provide a management of Plain old telephone services (POTS).<br />
                   - and etc."/><br />
            <textarea rows="15" cols="70" name="content"/>${requestScope.model.content}</textarea>
        </p>

        <jsp:include page="../../jspf/prevnextaddcomplete.jspf"/>
    </div>

</form>
