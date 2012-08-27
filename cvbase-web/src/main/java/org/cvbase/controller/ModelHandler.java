/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller;

import java.util.*;
import javax.servlet.http.HttpSession;
import org.cvbase.model.*;
import org.cvbase.service.GenericService;

/**
 * This class represents a wrapper for complex instructions 
 * such as create, update, delete.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public final class ModelHandler {

    /**
     * This method removes all models from the session cache.
     * 
     * @param session an instance of current session cache.
     */
    public static void invalidate(HttpSession session) {
        // Remove all models
        session.removeAttribute(Contact.class.getName());
        session.removeAttribute(Objective.class.getName());
        session.removeAttribute(Summary.class.getName());
        session.removeAttribute(Skills.class.getName());
        session.removeAttribute(Experience.class.getName());
        session.removeAttribute(Education.class.getName());
        // Remove a profile name 
        session.removeAttribute("profile");
    }

    /**
     * This method saves models from the session cache to the base.
     * 
     * @param service an instance of service layer.
     * @param session an instance of current session cache.
     * @return a status of operation.  
     */
    public static boolean create(GenericService service, HttpSession session) {
        List<CV> models = new LinkedList<CV>();
        // Get contact model from session cache
        CV model = (Contact) session.getAttribute(Contact.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Get objective model from session cache
        model = (Objective) session.getAttribute(Objective.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Get summary model from session cache
        model = (Summary) session.getAttribute(Summary.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Get skills model from session cache
        model = (Skills) session.getAttribute(Skills.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Get experience model from session cache
        model = (Experience) session.getAttribute(Experience.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Get education model from session cache
        model = (Education) session.getAttribute(Education.class.getName());
        if (model != null) {
            models.add(model);
        }
        // Create models
        models = service.create(models);
        return !models.contains(null);
    }

    /**
     * This method removes models from the base.
     * 
     * @param service an instance of service layer.
     * @param profile a name of profile.
     * @return a status of operation. 
     */
    public static boolean delete(GenericService service, String profile) {
        // Do query by the profile name
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("profile", profile);
        // Collect all models
        List<CV> models = new LinkedList<CV>();
        models.addAll(service.findWithParams(Education.class, params));
        models.addAll(service.findWithParams(Experience.class, params));
        models.addAll(service.findWithParams(Skills.class, params));
        models.addAll(service.findWithParams(Summary.class, params));
        models.addAll(service.findWithParams(Objective.class, params));
        models.addAll(service.findWithParams(Contact.class, params));
        // Delete models
        return service.delete(models);
    }
}
