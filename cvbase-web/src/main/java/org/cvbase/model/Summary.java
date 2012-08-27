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
 * This class contains an summary attribute.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class Summary extends CV {

    private String summary;

    public Summary() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (getProfile() != null ? getProfile().hashCode() : 0);
        hash = 17 * hash + (summary != null ? summary.hashCode() : 0);
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
        
        final Summary other = (Summary) obj;
        if ((getProfile() == null) ? (other.getProfile() != null) : 
                !getProfile().equals(other.getProfile())) {
            return false;
        }
        
        if ((summary == null) ? (other.summary != null) : 
                !summary.equals(other.summary)) {
            return false;
        } 
                
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Summary");
        sb.append('{').append(super.toString());
        sb.append(", summary='").append(summary).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
