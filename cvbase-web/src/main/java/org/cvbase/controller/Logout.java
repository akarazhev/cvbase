/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * This is a logout application scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class Logout implements Command {

    private HttpServletRequest request;
    // A next operation id
    private String selector;

    public Logout(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        selector = "Logout";
        request.getSession().invalidate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        ModelHandler.invalidate(request.getSession());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        request.setAttribute("selector", selector);
    }
}
