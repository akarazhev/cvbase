/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */
package org.cvbase.model;

import java.io.Serializable;

/**
 * This is a basic model class that used for common operations (i.e.
 * <b>C</b>reate<b>R</b>ead<b>U</b>pdate<b>D</b>elete).
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */
public abstract class Model implements Serializable {

    // The name of the object identifier field.
    public static final String OID = "oid";
    // a value of the object identifier.
    private Long oid;

    public final Long getOid() {
        return oid;
    }

    public final void setOid(Long oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("oid=\'").append(oid).append("\'");

        return sb.toString();
    }
}
