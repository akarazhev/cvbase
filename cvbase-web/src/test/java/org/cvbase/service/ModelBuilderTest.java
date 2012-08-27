/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.service;

import java.util.HashMap;
import java.util.Map;
import org.cvbase.model.Objective;
import org.junit.Assert;
import org.junit.Test;

/**
 * This is a test for
 * <code>ModelBuilder<code/> class.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see MongodbService
 */
public class ModelBuilderTest {

    @Test
    public void testGetModel() {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("objective", new String[]{"Test getModel!"});

        Objective o = new ModelBuilder<Objective>().set(Objective.class).set(params).set("profile").getModel();
        Assert.assertTrue("profile".equals(o.getProfile()) && "Test getModel!".equals(o.getObjective()));
    }
}
