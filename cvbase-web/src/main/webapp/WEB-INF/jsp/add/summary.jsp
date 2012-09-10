<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Add Summary

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<div id="list">
    <form method="post" action="main.page">
        <input type="hidden" name="id" value="summary">
        <input type="hidden" name="command" id="cmd" value=""/>

        <p><t:tooltip element="Details content:" content="Note: Html tags can be used.<br />
                   Example:<br />
                   - Experience in developing applications such as client-server, 
                   web based using Java and mobile applications using Objective C.<br />
                   - Hard level of programming knowledge. 
                   Clear understanding of the programming life cycle.<br />
                   - Experience in Object-Oriented analysis and design. 
                   Good at various Design Patterns, UML.<br />
                   and etc."/><br />
            <textarea rows="15" cols="70" name="summary"/>${requestScope.model.summary}</textarea>
        </p>

        <jsp:include page="../../jspf/prevnextcomplete.jspf"/>
    </form>
</div>