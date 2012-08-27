/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cvbase.model.CV;

/**
 * This is a builder class that creates a model based on request parameters.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @param <T> is type of the model.
 */
public class ModelBuilder<T extends CV> {

    private static final Logger LOG = Logger.getLogger(ModelBuilder.class.getName());
    // A type of model
    private Class<T> type;
    // Requests parameters
    private Map<String, String[]> params;
    // A profile name
    private String profile;

    public ModelBuilder() {
    }

    /**
     * This method initializes the builder. 
     * 
     * @param profile a profile name.
     * @return the instance of the builder.
     */
    public ModelBuilder<T> set(String profile) {
        this.profile = profile;
        return this;
    }

    /**
     * This method initializes the builder.
     * 
     * @param type of the model.
     * @return the instance of the builder.
     */
    public ModelBuilder<T> set(Class<T> type) {
        this.type = type;
        return this;
    }

    /**
     * This method initializes the builder.
     * 
     * @param params request parameters. 
     * @return the instance of the builder.
     */
    public ModelBuilder<T> set(Map<String, String[]> params) {
        this.params = params;
        return this;
    }

    /**
     * This method returns a created model.
     *
     * @return a created model.
     */
    public T getModel() {
        T model = null;

        if (type != null && params != null) {
            try {
                model = type.newInstance();
                Field[] fields = type.getDeclaredFields();
                Method[] methods = type.getDeclaredMethods();
                for (Field field : fields) {
                    for (Method method : methods) {
                        // Call a setter method
                        if (("set" + field.getName()).equalsIgnoreCase(method.getName())) {
                            try {
                                method.invoke(model, params.get(field.getName())[0]);
                            } catch (IllegalAccessException e) {
                                LOG.log(Level.WARNING, "Call of the method "
                                        + method.getName() + " is failed", e);
                            } catch (InvocationTargetException e) {
                                LOG.log(Level.WARNING, "Call of the method "
                                        + method.getName() + " is failed", e);
                            }
                            break;
                        }
                    }
                }

                LOG.log(Level.INFO, "{0}", model);
            } catch (InstantiationException e) {
                LOG.log(Level.WARNING, "Model with a type " + type.getName()
                        + " can't be created", e);
            } catch (IllegalAccessException e) {
                LOG.log(Level.WARNING, "Model with a type " + type.getName()
                        + " can't be created", e);
            }
        }

        if (model != null && profile != null) {
            // Set a profile name if it's available
            model.setProfile(profile);
        }

        if (model != null) {
            LOG.log(Level.INFO, "{0}", model);
        }

        return model;
    }
}
