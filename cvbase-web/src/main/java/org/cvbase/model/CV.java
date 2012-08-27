/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.model;

/**
 * This is a basic model class for <b>CV Base Application</b> has 
 * profile attribute as a key.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see Model
 */
public abstract class CV extends Model {

    private String profile;

    public CV() {
    }

    public final String getProfile() {
        return profile;
    }

    public final void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(", ");
        sb.append("profile=\'").append(profile).append("\'");

        return sb.toString();
    }
}
