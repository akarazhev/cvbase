/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.controller;

/**
 * This is a general interface describes command that is processed by the main
 * web servlet.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public interface Command {

    /**
     * This method performs operations that have to be called before the
     * <code>execute</code> method.
     */
    public void begin();

    /**
     * This method performs main content.
     */
    public void execute();

    /**
     * This method performs operations that have to be called after the
     * <code>execute</code> method.
     */
    public void end();
}
