/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.cvbase.config.Config;
import org.cvbase.service.mongodb.MongodbServiceFactory;

/**
 * This is an abstract factory class that describes instances of various
 * factories based on the type.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public abstract class ServiceFactory {

    private static final Logger LOG = Logger.getLogger(ServiceFactory.class.getName());
    public static final byte MONGO_DB = 1;
    public static final byte ORIENT_DB = 2;
    public static final byte NEO4J = 3;

    public abstract GenericService getService();

    public abstract void destroy();

    public static ServiceFactory getServiceFactory() {
        // read the type of data source.
        byte whichFactory = Config.getInstance().getByte("cvbase.type");
        switch (whichFactory) {
            case MONGO_DB:
                LOG.log(Level.INFO, "Mongo DB is selected.");
                return new MongodbServiceFactory();
            case ORIENT_DB:
                LOG.log(Level.INFO, "Orient DB is selected.");
                return null;
            case NEO4J:
                LOG.log(Level.INFO, "Neo4J is selected.");
                return null;
            default:
                LOG.log(Level.INFO, "Default factory is selected.");
                return null;
        }
    }
}
