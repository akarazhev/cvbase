/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller.model;

import javax.servlet.http.HttpServletRequest;
import org.cvbase.model.Experience;
import org.cvbase.service.GenericService;

/**
 * This is an implementation of View Experience scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class ViewExperience extends ViewCommand {

    public ViewExperience(HttpServletRequest request, GenericService service) {
        super(request, service);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        // Set the experience page
        selector = "Experience";
        // Set experience info
        content.addAll(service.findWithParams(Experience.class, params));
    }
}
