<%-- 
    Copyright (c) 2012. CV Base Application.

    This file is part of CV Base Application. CV Base Application is free software:
    you can redistribute it and/or modify it under the terms of the
    GNU General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.
--%>
<%--
    Page:    Menu

    Author:  Andrej Karazhev
    Version: 1.0.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
    <h1><a href="index.jspx">CV Base</a></h1>
    <p class="slogan">Save and view your cv</p>
    <% if (request.getUserPrincipal() == null) {%>
    <div id="login">   
        <form method="post" action="j_security_check">
            Username:&nbsp;<input type="text" name="j_username"><br />
            Password:&nbsp;<input type="password" name="j_password"><br />
            <input type="submit" value="Login">
        </form>
    </div>
    <% } else {%>
    <ul>
        <li><a href="admin/index.jspx">Enter</a><br />
            Login is successful, forward...</li>
        <li><a href="admin/main.page?operation=logout">Logout</a><br />
            Logout from the application...</li>
    </ul>
    <% }%>
</div>
