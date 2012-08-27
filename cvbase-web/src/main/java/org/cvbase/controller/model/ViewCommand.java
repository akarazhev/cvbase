/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.cvbase.controller.Command;
import org.cvbase.model.*;
import org.cvbase.service.GenericService;

/**
 * This is an implementation of View Profiles scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public abstract class ViewCommand implements Command {

    protected HttpServletRequest request;
    // A profile name
    protected String profile;
    // A next operation id
    protected String selector;
    // A list of models 
    protected List<CV> content;
    // Query
    protected Map<String, Object> params;
    protected GenericService service;

    public ViewCommand(HttpServletRequest request, GenericService service) {
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
        this.profile = request.getParameter("profile");
        // Prepare the query by the profile name
        params = new HashMap<String, Object>();
        params.put("profile", profile);

        this.content = new LinkedList<CV>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        request.setAttribute("profile", profile);
        request.setAttribute("selector", selector);
        request.setAttribute("content", content);
        request.setAttribute("size", content.size());
    }
}
