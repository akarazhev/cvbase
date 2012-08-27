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
import org.cvbase.model.Contact;
import org.cvbase.model.Objective;
import org.cvbase.service.GenericService;
import org.cvbase.service.ModelBuilder;

/**
 * This is an implementation of Add Contact scenario.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class AddContact extends AddCommand {

    public AddContact(HttpServletRequest request, GenericService service) {
        super(request, service);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        Contact contact = new ModelBuilder<Contact>().set(Contact.class).set(params).getModel();
        contact.setProfile(contact.getFirstName() + "."
                + contact.getMiddleInitial() + "." + contact.getLastName());

        // Save information to session cache
        session.setAttribute("profile", contact.getProfile());
        session.setAttribute(Contact.class.getName(), contact);

        if ("complete".equals(command)) {
            // Create a model
            selector = ModelHandler.create(service, session) ? "" : "Error";
        } else {
            // Set a next page and check session cache
            selector = "Add Objective";
            model = (Objective) session.getAttribute(Objective.class.getName());
        }
    }
}
