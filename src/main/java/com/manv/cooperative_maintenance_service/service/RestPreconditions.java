package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.exception.UserNotFoundException;

public class RestPreconditions {

    public static <T> T checkNotNull(T user) {
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}