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
import org.cvbase.model.Education;
import org.cvbase.service.GenericService;

/**
 * This is an implementation of View Education scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class ViewEducation extends ViewCommand {

    public ViewEducation(HttpServletRequest request, GenericService service) {
        super(request, service);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        // Set the education page
        selector = "Education";
        // Set education info 
        content.addAll(service.findWithParams(Education.class, params));
    }
}
