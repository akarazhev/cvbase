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
import org.cvbase.controller.ModelHandler;
import org.cvbase.model.*;
import org.cvbase.service.GenericService;
import org.cvbase.service.ModelBuilder;

/**
 * This is an implementation of Add Experience scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class AddExperience extends AddCommand {

    public AddExperience(HttpServletRequest request, GenericService service) {
        super(request, service);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        Experience experience = new ModelBuilder<Experience>().set(Experience.class).set(params).set(profile).getModel();
        // Save information to session cache
        session.setAttribute(Experience.class.getName(), experience);

        if ("prev".equals(command)) {
            // Set a prev page and check session cache
            selector = "Add Skills";
            model = (Skills) session.getAttribute(Skills.class.getName());
        } else if ("next".equals(command)) {
            // Set a next page and check session cache
            selector = "Add Education";
            model = (Education) session.getAttribute(Education.class.getName());
        } else if ("complete".equals(command)) {
            // Create a model
            selector = ModelHandler.create(service, session) ? "" : "Error";
        }
    }
}
