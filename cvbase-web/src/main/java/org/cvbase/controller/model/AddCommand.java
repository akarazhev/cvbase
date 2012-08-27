/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller.model;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.cvbase.controller.Command;
import org.cvbase.model.*;
import org.cvbase.service.GenericService;

/**
 * This is an abstract class that describes common actions linked to the Add
 * operation.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public abstract class AddCommand implements Command {

    protected HttpServletRequest request;
    protected HttpSession session;
    // A profile name
    protected String profile;
    // A next operation id
    protected String selector;
    // Selected command
    protected String command;
    // Query
    protected Map<String, String[]> params;
    // A basic instance
    protected CV model;
    protected GenericService service;

    public AddCommand(HttpServletRequest request, GenericService service) {
        this.request = request;
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        this.session = request.getSession();
        this.params = request.getParameterMap();
        this.profile = (String) session.getAttribute("profile");
        this.command = request.getParameter("command");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        request.setAttribute("model", model);
        request.setAttribute("selector", selector);
    }
}
