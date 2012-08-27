/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.config;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is a test for
 * <code>Config<code/> class.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see Config
 */
public class ConfigTest {

    private static Config config;

    @BeforeClass
    public static void init() {
        config = Config.getInstance();
    }

    @Test
    public void testGetInstance() {
        Assert.assertNotNull(config);
    }

    @Test
    public void testGetString() {
        Assert.assertTrue("getString".equals(config.getString("getString")));
    }

    @Test
    public void testGetByte() {
        Assert.assertTrue(config.getByte("getByte").equals((byte) 1));
    }

    @Test
    public void testGetInteger() {
        Assert.assertTrue(config.getInteger("getInteger").equals(1010));
    }
}
