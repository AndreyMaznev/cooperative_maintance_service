package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.exception.PersonNotFoundException;

import java.util.UUID;

public class RestPreconditions {

    public static <T> T checkNotNull(T resource) {
        if (resource == null) {
            throw new PersonNotFoundException("Resource not found");
        }
        return resource;
    }

    public static <T> T checkThatUuidAreEquals(UUID uuid, T resource) {
        if (resource == null) {
            throw new PersonNotFoundException("Resource not found");
        }

        return resource;
    }


}