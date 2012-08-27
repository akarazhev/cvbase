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
import javax.ejb.Remote;
import org.cvbase.model.Model;

/**
 * This is a general interface describes common operations (i.e.
 * <b>C</b>reate<b>R</b>ead<b>U</b>pdate<b>D</b>elete) and that is used as
 * remote interface for Enterprise java Bean.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
@Remote
public interface GenericService {

    /**
     * This method creates a model.
     *
     * @param t a model.
     * @param <T> a type of the model.
     * @return a created model.
     */
    public <T extends Model> T create(T t);

    /**
     * This method creates all models stored in a list.
     *
     * @param models a list with models.
     * @param <T> a type of the models.
     * @return a list with created models.
     */
    public <T extends Model> List<T> create(List<T> models);

    /**
     * This method updates a model.
     *
     * @param t a model.
     * @param <T> a type of the model.
     * @return a updated model.
     */
    public <T extends Model> T update(T t);

    /**
     * This method updates all models stored in a list.
     *
     * @param models a list with models.
     * @param <T> a type of the models.
     * @return a list with updated models.
     */
    public <T extends Model> List<T> update(List<T> models);

    /**
     * This method deletes a model.
     *
     * @param t a model.
     * @param <T> a type of the model.
     * @return a status of operation.
     */
    public <T extends Model> boolean delete(T t);

    /**
     * This method deletes all models stored in a list.
     *
     * @param models a list with models.
     * @param <T> a type of the models.
     * @return a status of operation.
     */
    public <T extends Model> boolean delete(List<T> models);

    /**
     * This method is looking for an instance with a defined type and an object
     * identifier.
     *
     * @param type a class instance.
     * @param oid an object identifier.
     * @param <T> a type of the model.
     * @return an instance of the defined type.
     */
    public <T extends Model> T find(Class<T> type, Long oid);

    /**
     * This method is looking for all instances with a defined type.
     *
     * @param type a class instance.
     * @param <T> a type of the models.
     * @return a list with found models.
     */
    public <T extends Model> List<T> find(Class<T> type);

    /**
     * This method is looking for all instances with a defined type and query
     * parameters.
     *
     * @param type a class of instances.
     * @param params a map with names and values of fields.
     * @param <T> a type of the models.
     * @return a list with found models.
     */
    public <T extends Model> List<T> findWithParams(Class<T> type,
            Map<String, Object> params);
}
