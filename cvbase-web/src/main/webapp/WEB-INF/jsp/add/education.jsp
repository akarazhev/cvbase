<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Add Education

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<form method="post" action="main.page">
    <input type="hidden" name="id" value="education">
    <input type="hidden" name="command" id="cmd" value=""/>

    <div id="column">

        <p><t:tooltip element="Degree:" content="Candidate's degree. Example: National Technical University:
                   Software of information technologies."/>
            <input type="text" name="degree" value="${requestScope.model.degree}"><br />
            <t:tooltip element="Country:" content="Country where school/university is. Example: Belarus"/>
            <input type="text" name="country" value="${requestScope.model.country}"><br />
            <t:tooltip element="City:" content="City where school/university is. Example: Minsk"/>
            <input type="text" name="city" value="${requestScope.model.city}"><br />
            <t:tooltip element="State:" content="State where school/university is. Example: Minsk's"/>
            <input type="text" name="state" value="${requestScope.model.state}"><br />
        </p>

        <p><t:tooltip element="Start:" content="When candidate started to study. Example: 2005"/>
            <input type="text" name="start" value="${requestScope.model.start}"><br />
            <t:tooltip element="End:" content="When candidate finished to study. Example: 2011"/>
            <input type="text" name="end" value="${requestScope.model.end}"><br />
        </p>

    </div>   

    <div id="list">

        <p><t:tooltip element="Description:" content="Note: Html tags can be used.<br />
                   Example: Bachelor, Software Engineer"/><br />
            <textarea rows="15" cols="70" name="description"/>${requestScope.model.description}</textarea>
        </p>

        <jsp:include page="../../jspf/prevaddcomplete.jspf"/>
    </div>

</form>
