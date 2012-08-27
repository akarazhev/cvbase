/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service.mongodb;

import com.mongodb.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cvbase.model.Model;
import org.cvbase.service.GenericService;

/**
 * This is the implementation class of the
 * <code>GenericService<code/> interface
 * that works with Mongo DB.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class MongodbService implements GenericService {

    private static final Logger LOG = Logger.getLogger(MongodbService.class.getName());
    private DB db;

    public MongodbService(DB db) {
        this.db = db;
    }

    private List<Field> getDeclaredFields(Class<?> type, List<Field> fields) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        // Get declared fields of parent class.
        if (!Model.class.equals(type)) {
            getDeclaredFields(type.getSuperclass(), fields);
        }

        return fields;
    }

    private List<Method> getDeclaredMethods(Class<?> type, List<Method> methods) {
        methods.addAll(Arrays.asList(type.getDeclaredMethods()));

        // Get declared fields of parent class.
        if (!Model.class.equals(type)) {
            getDeclaredMethods(type.getSuperclass(), methods);
        }

        return methods;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> T create(T t) {
        if (t == null) {
            return null;
        }

        BasicDBObject object = new BasicDBObject();

        Class<?> type = t.getClass();
        DBCollection coll = db.getCollection(type.getSimpleName());

        Long key = t.getOid();
        if (key == null) {
            // Set a new object identifier.
            DBCursor cursor = coll.find();
            key = (long) cursor.size() + 1;
            cursor.close();
        }
        t.setOid(key);

        if (find(t.getClass(), key) != null) {
            return null;
        }

        List<Field> fields = getDeclaredFields(type, new LinkedList<Field>());
        List<Method> methods = getDeclaredMethods(type, new LinkedList<Method>());

        for (Field field : fields) {
            for (Method method : methods) {
                // Call a getter method.
                if (("get" + field.getName()).equalsIgnoreCase(method.getName())) {
                    try {
                        object.put(field.getName(), method.invoke(t));
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

        try {
            LOG.log(Level.INFO, "{0}", t);
            WriteResult writeResult = coll.insert(object);
            if (writeResult.getError() != null) {
                LOG.log(Level.WARNING, "Insertion of {0} is failed.", t);
            }
        } catch (MongoException e) {
            LOG.log(Level.SEVERE, "Insertion of " + t + " is failed.", e);
        }

        return t;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> List<T> create(List<T> models) {
        List<T> createdModels = new ArrayList<T>(models.size());

        for (T model : models) {
            createdModels.add(create(model));
        }

        return createdModels;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> T update(T t) {
        LOG.log(Level.SEVERE, "Update of {0} hasn''t been supported yet.", t);
        throw new RuntimeException();
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> List<T> update(List<T> models) {
        LOG.log(Level.SEVERE, "Update of objects hasn't been supported yet.");
        throw new RuntimeException();
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> boolean delete(T t) {
        boolean status = false;

        if (t == null || find(t.getClass(), t.getOid()) == null) {
            return status;
        }

        Class<?> type = t.getClass();
        DBCollection coll = db.getCollection(type.getSimpleName());

        BasicDBObject object = new BasicDBObject();
        object.put(Model.OID, t.getOid());

        try {
            LOG.log(Level.INFO, "{0}", t);
            WriteResult writeResult = coll.remove(object);
            if (writeResult.getError() != null) {
                LOG.log(Level.WARNING, "Delete of {0} is failed.", t);
            } else {
                status = true;
            }
        } catch (MongoException e) {
            LOG.log(Level.SEVERE, "Delete of " + t + " is failed.", e);
        }

        return status;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> boolean delete(List<T> models) {
        boolean status = false;

        for (T model : models) {
            status = delete(model);
            if (!status) {
                break;
            }
        }

        return status;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> T find(Class<T> type, Long oid) {
        T model = null;

        // Do query by an object identifier
        BasicDBObject query = new BasicDBObject();
        query.put(Model.OID, oid);

        DBCollection coll = db.getCollection(type.getSimpleName());
        DBCursor cursor = coll.find(query);
        try {
            if (cursor.hasNext()) {
                DBObject o = cursor.next();
                model = type.newInstance();

                List<Field> fields = getDeclaredFields(type,
                        new LinkedList<Field>());
                List<Method> methods = getDeclaredMethods(type,
                        new LinkedList<Method>());
                for (Field field : fields) {
                    for (Method method : methods) {
                        // Call a setter method.
                        if (("set" + field.getName()).equalsIgnoreCase(method.getName())) {
                            try {
                                method.invoke(model, o.get(field.getName()));
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
            }
        } catch (InstantiationException e) {
            LOG.log(Level.WARNING, "Model with a type " + type.getName()
                    + " can't be created", e);
        } catch (IllegalAccessException e) {
            LOG.log(Level.WARNING, "Model with a type " + type.getName()
                    + " can't be created", e);
        } finally {
            cursor.close();
        }

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> List<T> find(Class<T> type) {
        List<T> models = new LinkedList<T>();

        DBCollection coll = db.getCollection(type.getSimpleName());
        DBCursor cursor = coll.find();
        try {
            while (cursor.hasNext()) {
                models.add(find(type, (Long) cursor.next().get(Model.OID)));
            }
        } finally {
            cursor.close();
        }

        return models;
    }

    /**
     * {@inheritDoc}
     *
     * This is an implementation for Mongo DB.
     */
    @Override
    public <T extends Model> List<T> findWithParams(Class<T> type,
            Map<String, Object> params) {
        List<T> models = new LinkedList<T>();

        // Do query by map parameters.
        BasicDBObject query = new BasicDBObject();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.put(param.getKey(), param.getValue());
        }

        DBCollection coll = db.getCollection(type.getSimpleName());
        DBCursor cursor = coll.find(query);
        try {
            DBObject o;
            T model;

            List<Field> fields = getDeclaredFields(type, new LinkedList<Field>());
            List<Method> methods = getDeclaredMethods(type, new LinkedList<Method>());
            while (cursor.hasNext()) {
                o = cursor.next();

                model = type.newInstance();
                for (Field field : fields) {
                    for (Method method : methods) {
                        // Call a setter method.
                        if (("set" + field.getName()).equalsIgnoreCase(method.getName())) {
                            try {
                                method.invoke(model, o.get(field.getName()));
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
                models.add(model);

                LOG.log(Level.INFO, "{0}", model);
            }
        } catch (InstantiationException e) {
            LOG.log(Level.WARNING, "Model with a type " + type.getName()
                    + " can't be created", e);
        } catch (IllegalAccessException e) {
            LOG.log(Level.WARNING, "Model with a type " + type.getName()
                    + " can't be created", e);
        } finally {
            cursor.close();
        }

        return models;
    }
}
