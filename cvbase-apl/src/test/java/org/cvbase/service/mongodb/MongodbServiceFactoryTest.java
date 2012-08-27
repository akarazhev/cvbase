/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service.mongodb;

import org.cvbase.service.ServiceFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is a test for
 * <code>MongodbServiceFactory<code/> class.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see MongodbServiceFactory
 */
public class MongodbServiceFactoryTest {

    private static ServiceFactory factory;

    @BeforeClass
    public static void init() {
        factory = ServiceFactory.getServiceFactory();
    }

    @AfterClass
    public static void logout() {
        factory.destroy();
    }

    @Test
    public void testGetService() {
        Assert.assertNotNull(factory.getService());
    }
}
