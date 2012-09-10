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
import org.cvbase.model.Education;
import org.cvbase.model.Experience;
import org.cvbase.service.GenericService;
import org.cvbase.service.ModelBuilder;


import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This is an implementation of Add Education scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class AddEducation extends AddCommand {

    public AddEducation(HttpServletRequest request, GenericService service) {
        super(request, service);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        Set<Education> education = (Set) session.getAttribute(Education.class.getName());
        if (education == null) {
            education = new LinkedHashSet<Education>();
        }

        if ("complete".equals(command)) {
            // Create a model
            selector = ModelHandler.create(service, session) ? "" : "Error";
        } else if ("prev".equals(command)) {
            // Set a next page and check session cache
            selector = "Add Experience";
            Set<Experience> experience = (Set) session.getAttribute(Experience.class.getName());
            if (experience != null && experience.size() > 0) {
                model = experience.toArray(new Experience[experience.size()])[experience.size() - 1];
            }
        } else if ("add".equals(command)) {
            // Add a new education info
            education.add(new ModelBuilder<Education>().set(Education.class).set(params).set(profile).getModel());
            selector = "Add Education";
        }

        // Save models to session cache
        session.setAttribute(Education.class.getName(), education);
    }
}
