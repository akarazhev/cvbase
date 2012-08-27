/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.config;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a singleton class is needed to read configuration parameters from
 * properties file.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public final class Config {

    private static final Logger LOG = Logger.getLogger(Config.class.getName());
    private ResourceBundle bundle;

    private Config() {
        // Configuration file is Config.properties.
        bundle = ResourceBundle.getBundle("Config");
    }

    private static class Holder {

        public static final Config INSTANCE = new Config();
    }

    public static Config getInstance() {
        return Holder.INSTANCE;
    }

    public String getString(String key) {
        String val = bundle.getString(key);
        LOG.log(Level.INFO, "key = {0}, val = {1}", new Object[]{key, val});
        return val;
    }

    public Byte getByte(String key) {
        Byte val = Byte.valueOf(bundle.getString(key));
        LOG.log(Level.INFO, "key = {0}, val = {1}", new Object[]{key, val});
        return val;
    }

    public Integer getInteger(String key) {
        Integer val = Integer.valueOf(bundle.getString(key));
        LOG.log(Level.INFO, "key = {0}, val = {1}", new Object[]{key, val});
        return val;
    }
}
