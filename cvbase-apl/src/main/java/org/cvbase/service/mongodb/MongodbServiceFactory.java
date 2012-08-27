/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service.mongodb;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cvbase.config.Config;
import org.cvbase.service.GenericService;
import org.cvbase.service.ServiceFactory;

/**
 * This is the implementation of the Mongo DB data source.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class MongodbServiceFactory extends ServiceFactory {

    private static final Logger LOG = Logger.getLogger(MongodbServiceFactory.class.getName());
    private Mongo db;
    private Config config;

    public MongodbServiceFactory() {
        config = Config.getInstance();
        try {
            // Set the hostname and the port.
            db = new Mongo(config.getString("cvbase.host"),
                    config.getInteger("cvbase.port"));
            LOG.log(Level.INFO, "Mongo DB is opened.");
        } catch (UnknownHostException ex) {
            LOG.log(Level.SEVERE, "Connect can't be established.", ex);
        } catch (MongoException ex) {
            LOG.log(Level.SEVERE, "Connect can't be established.", ex);
        }
    }

    @Override
    public GenericService getService() {
        // Set the collection name.
        String dbName = config.getString("cvbase.dbname");
        LOG.log(Level.INFO, "Open ''{0}''.", dbName);
        return new MongodbService(db.getDB(dbName));
    }

    @Override
    public void destroy() {
        if (db != null) {
            db.close();
            LOG.log(Level.INFO, "Mongo DB is closed.");
            db = null;
        }
    }
}
