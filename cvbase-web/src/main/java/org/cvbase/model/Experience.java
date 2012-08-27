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
 * This class contains experience attributes: 
 * <ul> 
 *  <li>Company</li> 
 *  <li>Country</li> 
 *  <li>City</li> 
 *  <li>State</li>
 *  <li>Start</li>
 *  <li>End</li>
 *  <li>Position</li>
 *  <li>Details content</li>
 * </ul>
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class Experience extends CV {

    private String start;
    private String end;
    private String company;
    private String position;
    private String city;
    private String state;
    private String country;
    private String content;

    public Experience() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (getProfile() != null ? getProfile().hashCode() : 0);
        hash = 37 * hash + (start != null ? start.hashCode() : 0);
        hash = 37 * hash + (end != null ? end.hashCode() : 0);
        hash = 37 * hash + (company != null ? company.hashCode() : 0);
        hash = 37 * hash + (position != null ? position.hashCode() : 0);
        hash = 37 * hash + (city != null ? city.hashCode() : 0);
        hash = 37 * hash + (state != null ? state.hashCode() : 0);
        hash = 37 * hash + (country != null ? country.hashCode() : 0);
        hash = 37 * hash + (content != null ? content.hashCode() : 0);
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
        
        final Experience other = (Experience) obj;
        if ((getProfile() == null) ? (other.getProfile() != null) : 
                !getProfile().equals(other.getProfile())) {
            return false;
        }
        
        if ((start == null) ? (other.start != null) : !start.equals(other.start)) {
            return false;
        }
        
        if ((end == null) ? (other.end != null) : !end.equals(other.end)) {
            return false;
        }
        
        if ((company == null) ? (other.company != null) : 
                !company.equals(other.company)) {
            return false;
        }
        
        if ((position == null) ? (other.position != null) : 
                !position.equals(other.position)) {
            return false;
        }
        
        if ((city == null) ? (other.city != null) : !city.equals(other.city)) {
            return false;
        }
        
        if ((state == null) ? (other.state != null) : 
                !state.equals(other.state)) {
            return false;
        }
        
        if ((country == null) ? (other.country != null) : 
                !country.equals(other.country)) {
            return false;
        }
        
        if ((content == null) ? (other.content != null) : 
                !content.equals(other.content)) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Experience");
        sb.append('{').append(super.toString());
        sb.append(", start='").append(start).append('\'');
        sb.append(", end='").append(end).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
