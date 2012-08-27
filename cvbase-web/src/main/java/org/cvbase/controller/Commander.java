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
 * This is a commander class that provides execution of an implemented command.
 * It's used by the main web servlet. 
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see Command
 */
public final class Commander {

    private Commander() {
    }

    /**
     * This method is performing a command.
     * 
     * @param cmd command to execution.
     */
    public static void execute(Command cmd) {
        cmd.begin();
        cmd.execute();
        cmd.end();
    }
}
