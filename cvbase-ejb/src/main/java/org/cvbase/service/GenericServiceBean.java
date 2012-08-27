/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import org.cvbase.model.Model;

/**
 * {@inheritDoc}
 *
 * This is an implementation of singleton Enterprise Java Bean.
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class GenericServiceBean implements GenericService {

    private static final Logger LOG = Logger.getLogger(GenericServiceBean.class.getName());
    private static ServiceFactory factory;
    private static GenericService service;

    @PostConstruct
    public void applicationStartup() {
        LOG.log(Level.INFO, "Startup ...");
        factory = ServiceFactory.getServiceFactory();
        service = factory.getService();
    }

    @PreDestroy
    public void applicationShutdown() {
        LOG.log(Level.INFO, "Shutdown ...");
        service = null;
        factory.destroy();
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> T create(T t) {
        LOG.log(Level.INFO, "Create {0} object", t);
        return service.create(t);
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> List<T> create(List<T> models) {
        LOG.log(Level.INFO, "Create {0} objects", models);
        return service.create(models);
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> T update(T t) {
        LOG.log(Level.INFO, "Update {0} object", t);
        return service.update(t);
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> List<T> update(List<T> models) {
        LOG.log(Level.INFO, "Update {0} objects", models);
        return service.update(models);
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> boolean delete(T t) {
        LOG.log(Level.INFO, "Delete {0} object", t);
        return service.delete(t);
    }

    @Override
    @Lock(LockType.WRITE)
    public <T extends Model> boolean delete(List<T> models) {
        LOG.log(Level.INFO, "Delete {0} objects", models);
        return service.delete(models);
    }

    @Override
    @Lock(LockType.READ)
    public <T extends Model> T find(Class<T> type, Long key) {
        LOG.log(Level.INFO, "Find object with {0} type, key = {1}",
                new Object[]{type, key});
        return service.find(type, key);
    }

    @Override
    @Lock(LockType.READ)
    public <T extends Model> List<T> find(Class<T> type) {
        LOG.log(Level.INFO, "Find all objects with {0} type", type);
        return service.find(type);
    }

    @Override
    @Lock(LockType.READ)
    public <T extends Model> List<T> findWithParams(Class<T> type,
            Map<String, Object> params) {
        LOG.log(Level.INFO, "Find with params objects of {0} type", type);
        return service.findWithParams(type, params);
    }
}
