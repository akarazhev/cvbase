<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page: Menu Section

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
    <h1><a href="index.jspx">CV Base</a></h1>

    <p class="slogan">Save and view your cv
    </p>

    <ul>
        <li><a href="main.page?profile=${profile}&page=contact">Contact</a><br />
            There is an information about tel, city...</li>
        <li><a href="main.page?profile=${profile}&page=objective">Objective</a><br />
            Objective information...</li>
        <li><a href="main.page?profile=${profile}&page=summary">Summary</a><br />
            Summary information...</li>
        <li><a href="main.page?profile=${profile}&page=skills">Skills</a><br />
            There is a list of skills...</li>
        <li><a href="main.page?profile=${profile}&page=experience">Experience</a><br />
            Check professional experience...</li>
        <li><a href="main.page?profile=${profile}&page=education">Education</a><br />
            Check degree and etc...</li>
    </ul>
</div>
