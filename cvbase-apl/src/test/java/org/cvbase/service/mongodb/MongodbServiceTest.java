/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service.mongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.cvbase.model.ModelTest;
import org.cvbase.service.GenericService;
import org.cvbase.service.ServiceFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is a test for
 * <code>MongodbService<code/> class.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see MongodbService
 */
public class MongodbServiceTest {

    private static final int INSTANCE_NUM = 5;
    private static ServiceFactory factory;
    private static GenericService service;
    private ModelTest model;

    @BeforeClass
    public static void init() {
        factory = ServiceFactory.getServiceFactory();
        service = factory.getService();
    }

    @AfterClass
    public static void logout() {
        factory.destroy();
    }

    @Test
    public void testCreate() {
        model = new ModelTest();
        model.setField("Test create!");

        model = service.create(model);
        Assert.assertNotNull(model);

        service.delete(model);
    }

    @Test
    public void testCreateModels() {
        List<ModelTest> models = new ArrayList<ModelTest>(INSTANCE_NUM);

        for (int i = 0; i < INSTANCE_NUM; i++) {
            model = new ModelTest();
            model.setField("Test create model=" + i + "!");
            models.add(model);
        }

        Assert.assertEquals(models.size(), service.create(models).size());

        service.delete(models);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdate() {
        model = new ModelTest();
        model.setField("Test update!");

        Assert.assertNull(service.update(model));
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateModels() {
        List<ModelTest> models = new ArrayList<ModelTest>(INSTANCE_NUM);

        for (int i = 0; i < INSTANCE_NUM; i++) {
            model = new ModelTest();
            model.setField("Test update model=" + i + "!");
            models.add(model);
        }

        Assert.assertNull(service.update(models));
    }

    @Test
    public void testDelete() {
        model = new ModelTest();
        model.setField("Test delete!");

        model = service.create(model);
        Assert.assertTrue(service.delete(model));
    }

    @Test
    public void testDeleteModels() {
        List<ModelTest> models = new ArrayList<ModelTest>(INSTANCE_NUM);

        for (int i = 0; i < INSTANCE_NUM; i++) {
            model = new ModelTest();
            model.setField("Test delete model=" + i + "!");
            models.add(model);
        }

        service.create(models);
        Assert.assertTrue(service.delete(models));
    }

    @Test
    public void testFind() {
        model = new ModelTest();
        model.setField("Test find!");

        model = service.create(model);
        Assert.assertNotNull(service.find(ModelTest.class, model.getOid()));
        service.delete(model);
    }

    @Test
    public void testFindNull() {
        Assert.assertNull(service.find(ModelTest.class, null));
    }

    @Test
    public void testFindAll() {
        Assert.assertNotNull(service.find(ModelTest.class));
    }

    @Test
    public void testFindWithParams() {
        model = new ModelTest();
        model.setField("Test findWithParams!");
        model = service.create(model);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("field", "Test findWithParams!");

        List<ModelTest> models = service.findWithParams(ModelTest.class, params);
        Assert.assertTrue(!models.isEmpty());
        service.delete(model);
    }
}
