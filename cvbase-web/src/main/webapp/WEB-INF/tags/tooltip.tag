<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    This is a tag file for tooltips. Example of usage:
    <t:tooltip element="Foo Name:" content="Foo name tooltip"/>

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@tag description="This tag prepares a tooltip for UI element" pageEncoding="UTF-8"%>
<%-- The element attribute contains a text of UI element --%>
<%@attribute name="element"%>
<%-- It's the content of tooltip --%>
<%@attribute name="content"%>
<a class="tooltip">${element}<span class="classic">${content}</span></a>