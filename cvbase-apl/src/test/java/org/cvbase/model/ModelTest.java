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
 * This is a basic class that needed to perform all test cases.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 * @see Model
 */
public class ModelTest extends Model {

    private String field;

    public ModelTest() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (field != null ? field.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ModelTest other = (ModelTest) obj;
        if ((field == null) ? (other.field != null) : !field.equals(other.field)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModelTest{" + "field=" + field + '}';
    }
}
