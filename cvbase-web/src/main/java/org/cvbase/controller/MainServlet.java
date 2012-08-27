/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cvbase.controller.model.*;
import org.cvbase.service.*;

/**
 * This is the main web servlet that handles incoming requests.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
@WebServlet(urlPatterns = {"/admin/main", "*.page"})
public class MainServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(MainServlet.class.getName());
    // A main page
    private static final String MAIN_VIEW = "/admin/view.jspx";
    // The service layer
    @EJB(name = "GenericServiceBean")
    private GenericService service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String operationParam = request.getParameter("operation");
        if (operationParam != null) {
            if ("view".equals(operationParam)) {
                Commander.execute(new ViewProfiles(request, service));
            } else if ("create".equals(operationParam)) {
                Commander.execute(new CreateProfile(request));
            } else if ("delete".equals(operationParam)) {
                Commander.execute(new DeleteProfile(request, service));
            } else if ("logout".equals(operationParam)) {
                Commander.execute(new Logout(request));
            }
        }

        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            if ("objective".equals(pageParam)) {
                Commander.execute(new ViewObjective(request, service));
            } else if ("summary".equals(pageParam)) {
                Commander.execute(new ViewSummary(request, service));
            } else if ("skills".equals(pageParam)) {
                Commander.execute(new ViewSkills(request, service));
            } else if ("experience".equals(pageParam)) {
                Commander.execute(new ViewExperience(request, service));
            } else if ("education".equals(pageParam)) {
                Commander.execute(new ViewEducation(request, service));
            } else if ("contact".equals(pageParam)) {
                Commander.execute(new ViewContact(request, service));
            }
        }

        try {
            // Forward to the front page
            getServletContext().getRequestDispatcher(MAIN_VIEW).forward(request, response);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "Forward can't be performed.", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Forward can't be performed.", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        if (id != null) {
            if ("contact".equals(id)) {
                Commander.execute(new AddContact(request, service));
            } else if ("objective".equals(id)) {
                Commander.execute(new AddObjective(request, service));
            } else if ("summary".equals(id)) {
                Commander.execute(new AddSummary(request, service));
            } else if ("skills".equals(id)) {
                Commander.execute(new AddSkills(request, service));
            } else if ("experience".equals(id)) {
                Commander.execute(new AddExperience(request, service));
            } else if ("education".equals(id)) {
                Commander.execute(new AddEducation(request, service));
            }
        }

        try {
            // Forward to the front page
            getServletContext().getRequestDispatcher(MAIN_VIEW).forward(request, response);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "Forward can't be performed.", ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Forward can't be performed.", ex);
        }
    }
}
