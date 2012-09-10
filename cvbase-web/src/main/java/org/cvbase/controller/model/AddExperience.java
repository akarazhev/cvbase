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

import java.util.LinkedHashSet;
import java.util.Set;

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
        Set<Experience> experience = (Set) session.getAttribute(Experience.class.getName());
        if (experience == null) {
            experience = new LinkedHashSet<Experience>();
        }

        if ("prev".equals(command)) {
            // Set a prev page and check session cache
            selector = "Add Skills";
            model = (Skills) session.getAttribute(Skills.class.getName());
        } else if ("next".equals(command)) {
            // Set a next page and check session cache
            selector = "Add Education";
            Set<Education> education = (Set) session.getAttribute(Education.class.getName());
            if (education != null && education.size() > 0) {
                model = education.toArray(new Education[education.size()])[education.size() - 1];
            }
        } else if ("complete".equals(command)) {
            // Create a model
            selector = ModelHandler.create(service, session) ? "" : "Error";
        } else if ("add".equals(command)) {
            // Add a new education info
            experience.add(new ModelBuilder<Experience>().set(Experience.class).set(params).set(profile).getModel());
            selector = "Add Experience";
        }

        // Save model to session cache
        session.setAttribute(Experience.class.getName(), experience);
    }
}
