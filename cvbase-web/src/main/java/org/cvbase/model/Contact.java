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
 * This class contains contact attributes: 
 * <ul> 
 *  <li>First Name</li> 
 *  <li>Middle Initial</li> 
 *  <li>Last Name</li> 
 *  <li>Country</li>
 *  <li>City</li>
 *  <li>State</li>
 *  <li>Zip Code</li>
 *  <li>Address</li>
 *  <li>Phone</li>
 *  <li>Email</li>
 *  <li>Site</li>
 * </ul>
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public class Contact extends CV {

    private String firstName;
    private String lastName;
    private String middleInitial;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;
    private String email;
    private String website;

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (getProfile() != null ? getProfile().hashCode() : 0);
        hash = 29 * hash + (firstName != null ? firstName.hashCode() : 0);
        hash = 29 * hash + (lastName != null ? lastName.hashCode() : 0);
        hash = 29 * hash + (middleInitial != null ? middleInitial.hashCode() : 0);
        hash = 29 * hash + (address != null ? address.hashCode() : 0);
        hash = 29 * hash + (city != null ? city.hashCode() : 0);
        hash = 29 * hash + (state != null ? state.hashCode() : 0);
        hash = 29 * hash + (country != null ? country.hashCode() : 0);
        hash = 29 * hash + (zipCode != null ? zipCode.hashCode() : 0);
        hash = 29 * hash + (phone != null ? phone.hashCode() : 0);
        hash = 29 * hash + (email != null ? email.hashCode() : 0);
        hash = 29 * hash + (website != null ? website.hashCode() : 0);
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

        final Contact other = (Contact) obj;
        if ((getProfile() == null) ? (other.getProfile() != null)
                : !getProfile().equals(other.getProfile())) {
            return false;
        }

        if ((firstName == null) ? (other.firstName != null) : 
                !firstName.equals(other.firstName)) {
            return false;
        }

        if ((lastName == null) ? (other.lastName != null) : 
                !lastName.equals(other.lastName)) {
            return false;
        }

        if ((middleInitial == null) ? (other.middleInitial != null) : 
                !middleInitial.equals(other.middleInitial)) {
            return false;
        }

        if ((address == null) ? (other.address != null) : 
                !address.equals(other.address)) {
            return false;
        }

        if ((city == null) ? (other.city != null) : 
                !city.equals(other.city)) {
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

        if ((zipCode == null) ? (other.zipCode != null) : 
                !zipCode.equals(other.zipCode)) {
            return false;
        }

        if ((phone == null) ? (other.phone != null) : 
                !phone.equals(other.phone)) {
            return false;
        }

        if ((email == null) ? (other.email != null) : 
                !email.equals(other.email)) {
            return false;
        }

        if ((website == null) ? (other.website != null) : 
                !website.equals(other.website)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Contact");
        sb.append('{').append(super.toString());
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", middleInitial='").append(middleInitial).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
