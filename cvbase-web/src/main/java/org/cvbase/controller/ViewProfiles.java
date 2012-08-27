/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.cvbase.model.CV;
import org.cvbase.model.Contact;
import org.cvbase.service.GenericService;

/**
 * This is a view profiles implementation scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class ViewProfiles implements Command {

    private HttpServletRequest request;
    private GenericService service;
    // A next operation id
    private String selector;
    // A list with all instances of models
    protected List<CV> content;

    public ViewProfiles(HttpServletRequest request, GenericService service) {
        this.request = request;
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        selector = "Content";
        content.addAll(service.find(Contact.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        this.content = new LinkedList<CV>();
        ModelHandler.invalidate(request.getSession());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        request.setAttribute("selector", selector);
        request.setAttribute("content", content);
        request.setAttribute("size", content.size());
    }
}
