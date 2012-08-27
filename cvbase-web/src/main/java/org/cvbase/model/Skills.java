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
 * This class contains an skills attribute.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class Skills extends CV {

    private String skills;

    public Skills() {
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (getProfile() != null ? getProfile().hashCode() : 0);
        hash = 17 * hash + (skills != null ? skills.hashCode() : 0);
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
        
        final Skills other = (Skills) obj;
        if ((getProfile() == null) ? (other.getProfile() != null) : 
                !getProfile().equals(other.getProfile())) {
            return false;
        }
        
        if ((skills == null) ? (other.skills != null) : 
                !skills.equals(other.skills)) {
            return false;
        } 
                
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Skills");
        sb.append('{').append(super.toString());
        sb.append(", skills='").append(skills).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
